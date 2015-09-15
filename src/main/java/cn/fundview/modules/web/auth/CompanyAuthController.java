package cn.fundview.modules.web.auth;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Company;
import cn.fundview.modules.service.CompanyService;
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
 * 企业认证管理
 */
@Controller
@RequestMapping(value = "/${adminPath}/auth/company")
public class CompanyAuthController extends BaseController {

    @Resource(name = "companyService")
    private CompanyService companyService;
    /**
     * 待认证审核企业
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String getUnCheckCompList(Model model){

        Company param = new Company();
        param.setCompAuth(1);
        model.addAttribute("list",companyService.getUnCheckCompList(param));
        return "modules/auth/company/index";
    }

    @RequestMapping(value="/auth/{id}", method= RequestMethod.GET)
    public String toAuth(@PathVariable(value = "id")int id,Model model) {

        Company param = new Company();
        param.setAccountId(id);
        model.addAttribute("company", companyService.getSimple(param));
        return "modules/auth/company/auth";
    }
    @ResponseBody
    @RequestMapping(value="/auth", method= RequestMethod.POST)
    public Map<String,String> toAuth(Company company) {

        boolean flag = companyService.updateCompany(company);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result",flag?"1":"0");
        return result;
    }
}


