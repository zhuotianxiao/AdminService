package cn.fundview.modules.web.consultation;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Consultation;
import cn.fundview.modules.model.PayMain;
import cn.fundview.modules.model.PayRemittance;
import cn.fundview.modules.service.ConsultationService;
import cn.fundview.modules.service.PayMainService;
import cn.fundview.modules.service.PayRemittanceService;
import cn.fundview.modules.util.Constants;
import cn.fundview.modules.util.SnsTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/11 0011.
 */
@Controller
@RequestMapping(value = "/${adminPath}/consultation/list")
public class ConsultationController extends BaseController {

    @Resource(name = "consultationService")
    private ConsultationService service;

    //支付信息
    @Resource(name = "payMainService")
    private PayMainService payMainService;

    //转账汇款
    @Resource(name = "payRemittanceService")
    private PayRemittanceService payRemittanceService;

    //订单
//    @Resource
//    private ConsultationServService consolutationServService;

//

    /**
     * 咨询服务综合查询
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {

        model.addAttribute("list", service.getList(new Consultation()));
        return "modules/consultation/index";
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String info(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("model", service.get(id));
        return "modules/consultation/info";
    }

    @RequestMapping(value = "/unsure", method = RequestMethod.GET)
    public String unsure(Model model) {

        Consultation param = new Consultation();
        param.setStatus(1);//待专家确认
        model.addAttribute("list", service.getList(param));
        return "modules/consultation/unsure";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(Model model) {

        Consultation param = new Consultation();
        param.setCancelStatus(1);//待取消处理
        model.addAttribute("list", service.getList(param));
        return "modules/consultation/cancel";
    }

    @RequestMapping(value = "/to-cancel/{id}")
    public String toCancel(@PathVariable("id") int id, Model model) {

        model.addAttribute("model", service.get(id));
        return "modules/consultation/cancel-info";
    }

    @ResponseBody
    @RequestMapping(value = "/check-consultation-cancel", method = RequestMethod.POST)
    public Map<String, Object> checkConsultationCancel(boolean flag, Integer id, String cancelCheckMark) {

        Map<String, Object> jsonBean = new HashMap<String, Object>();
        boolean result = service.serviceConsultationCheck(id, flag,cancelCheckMark);

        if (result) {

            jsonBean.put("result", "1");
        } else{

            jsonBean.put("result", "0");
        }

        return jsonBean;
    }

    /**
     * 待确认汇款
     *
     * @return
     */
    @RequestMapping(value = "/unpayed", method = RequestMethod.GET)
    public String toUnpayed() {


        return "modules/consultation/unpayed";
    }

    //    @RequestMapping(value = "/unpayed", method= RequestMethod.POST)
//    public String unpayed() {
//
//        return "modules/consultation/unpayed";
//    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value = "code") String code, Model model) {

        System.out.println(code);

        if (StringUtils.isNotBlank(code)) {
            List<PayRemittance> list = payRemittanceService.findByPayCode(code);
            model.addAttribute("list", list);
        }

        return "modules/consultation/unpayed";
    }


    @ResponseBody
    @RequestMapping(value = "/confirm-pay/{id}", method = RequestMethod.POST)
    public Map<String, Object> search(@PathVariable(value = "id") int id, HttpSession session) {

        int result = 0;
        if (0 != id) {
            payRemittanceService.updateRealPayDate(id);
            PayRemittance remittance = payRemittanceService.findById(id);
            payMainService.confirmPay(remittance.getPayId());
            PayMain main = payMainService.findById(remittance.getPayId());
            Consultation consultation = service.updateStatus(main.getOrderId(), 2, 3);
            if (null != consultation.getExpertPhone() && !"".equals(consultation.getExpertPhone()) && null != consultation.getPhone() && !"".equals(consultation.getPhone())) {
                SnsTools snsTools = new SnsTools();
                //给专家发送企业手机号并提示支付成功
                //您好，您有一个丰景网现场咨询服务订单0999企业已支付完成，企业名称：丰景惠农信息服务有限公司，企业手机号：1866666666，请尽快联系企业约定时间进行服务【丰景网】
                String sms = "您好，您有一个丰景网现场咨询服务订单" + consultation.getId() + "企业已支付完成，企业名称："
                        + consultation.getConsulationMan() + "，企业手机号：" + consultation.getPhone() + "，请尽快联系企业约定时间进行服务";
                try {
                    boolean flag = snsTools.sendMsg(consultation.getExpertPhone(), sms);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //存储发送短信的时间
                session.setAttribute(Constants.SMS_TIME, System.currentTimeMillis());

                SnsTools snsTools2 = new SnsTools();
                //给企业发送专家手机号并提示支付成功
                String sms2 = "您好，您的丰景网专家电话咨询服务订单" + consultation.getId() + "支付完成，咨询专家：" + consultation.getExpertName() + "，专家手机号：" + consultation.getExpertPhone() + "，请尽快联系专家约定时间进行服务";
                try {
                    boolean flag = snsTools2.sendMsg(consultation.getPhone(), sms2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //存储发送短信的时间
                session.setAttribute(Constants.SMS_TIME, System.currentTimeMillis());
            }

            result = 1;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", result);
        return map;
    }
}
