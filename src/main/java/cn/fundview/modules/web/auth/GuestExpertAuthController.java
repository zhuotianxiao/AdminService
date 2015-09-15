package cn.fundview.modules.web.auth;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Expert;
import cn.fundview.modules.model.ExpertConsulation;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.service.ExpertService;
import cn.fundview.modules.service.FinanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/10 0010.
 */

/**
 * 特约专家认证审核
 */
@Controller
@RequestMapping(value = "/${adminPath}/auth/guestexpert")
public class GuestExpertAuthController extends BaseController {

    @Resource(name = "expertService")
    private ExpertService expertService;
    /**
     * 待认证审核 特约专家
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String getUnCheckGuestExpertList(Model model){

        Expert param = new Expert();
        param.setApplyGuestExpertStatus(2);
        model.addAttribute("list",expertService.getGuestExpertStatus(param));
        return "modules/auth/expert/index";
    }

    @RequestMapping(value="/auth/{id}", method= RequestMethod.GET)
    public String toAuth(@PathVariable(value = "id")String id,Model model) {

        Expert param = new Expert();
        param.setId(id);
        model.addAttribute("expert", expertService.get(param));

        ExpertConsulation param1 = new ExpertConsulation();
        param1.setId(Integer.parseInt(id));
        model.addAttribute("consultation", expertService.getConsultation(param1));
        return "modules/auth/expert/auth";
    }
    @ResponseBody
    @RequestMapping(value="/auth", method= RequestMethod.POST)
    public Map<String,String> toAuth(Expert expert) {

        boolean flag = expertService.updateExpert(expert);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result",flag?"1":"0");
        return result;
    }
}


