package cn.fundview.modules.web.account;

import cn.fundview.common.web.BaseController;
import cn.fundview.modules.model.Company;
import cn.fundview.modules.model.KyOrg;
import cn.fundview.modules.service.CompanyService;
import cn.fundview.modules.service.KyOrgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台企业controller
 */
@Controller
@RequestMapping(value = "/${adminPath}/account/company")
public class CompanyController extends BaseController {

    // Service
    @Resource(name = "companyService")
    private CompanyService companyService;

    @RequestMapping(value = "/index")
    public String list(Model model) {
        List<Company> list = companyService.findList();
        model.addAttribute("list", list);
        return "modules/account/company/index";
    }

    /**
     * 禁用/启用科研机构
     *
     * @param id
     * @param flag
     * @return String
     */
    @RequestMapping(value = "/valid/{id}/{flag}")
    public String valid(@PathVariable(value = "id") int id, @PathVariable(value = "flag") boolean flag) {

        companyService.validCompany(id, flag);
        return "redirect:" + adminPath + "/account/company/index";
    }

    @RequestMapping(value = "/info/{id}")
    public String info(@PathVariable(value = "id") int id, Model model) {

        Company company = new Company();
        company.setAccountId(id);
        company = companyService.get(company);
        model.addAttribute("company", company);
        return "modules/account/company/info";
    }

    /**
     * 修改认证信息
     *
     * @param id
     * @param model
     * @return String
     */
    @RequestMapping(value = "/auth/{id}", method = RequestMethod.GET)
    public String toAuth(@PathVariable(value = "id") int id, Model model) {

        Company company = new Company();
        company.setAccountId(id);
        company = companyService.getSimple(company);
        model.addAttribute("company", company);
        return "modules/account/company/auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(Company company,RedirectAttributes redirectAttr) {

        companyService.updateCompany(company);
        addMessage(redirectAttr, company.getName() + " 认证信息修改成功");
        return "redirect:" + adminPath + "/account/company/index";
    }

    /**
     * 设置企业的前台展示
     *
     * @param id
     * @param model
     * @return String
     */
    @RequestMapping(value = "/setting/{id}", method = RequestMethod.GET)
    public String toSetting(@PathVariable("id") int id, Model model) {
        Company company = new Company();
        company.setAccountId(id);
        company = companyService.getSimple(company);
        model.addAttribute("company", company);
        return "modules/account/company/setting";
    }

    @RequestMapping(value = "/setting", method = RequestMethod.POST)
    public String setting(Company company, RedirectAttributes redirectAttr) {
        companyService.updateCompany(company);
        addMessage(redirectAttr, company.getName() + "前台展示设置成功");
        return "redirect:" + adminPath + "/account/company/index";
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics(Model model) {

        model.addAttribute("list",companyService.countAllCompByArea());
        return "modules/account/company/statistics";
    }


}
