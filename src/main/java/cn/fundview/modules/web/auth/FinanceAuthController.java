package cn.fundview.modules.web.auth;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Company;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.service.CompanyService;
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
 * 金融机构认证审核
 */
@Controller
@RequestMapping(value = "/${adminPath}/auth/finance")
public class FinanceAuthController extends BaseController {

    @Resource(name = "financeService")
    private FinanceService financeService;
    /**
     * 待认证审核金融机构
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String getUnCheckFinanceList(Model model){

        Finance param = new Finance();
        param.setFinanceAuth("1");
        model.addAttribute("list",financeService.getUnCheckFinanceList(param));
        return "modules/auth/finance/index";
    }

    @RequestMapping(value="/auth/{id}", method= RequestMethod.GET)
    public String toAuth(@PathVariable(value = "id")String id,Model model) {

        Finance param = new Finance();
        param.setId(id);
        model.addAttribute("finance", financeService.get(param));
        return "modules/auth/finance/auth";
    }
    @ResponseBody
    @RequestMapping(value="/auth", method= RequestMethod.POST)
    public Map<String,String> toAuth(Finance finance) {

        boolean flag = financeService.updateFinance(finance);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result",flag?"1":"0");
        return result;
    }
}


