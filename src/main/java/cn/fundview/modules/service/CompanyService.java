package cn.fundview.modules.service;

import cn.fundview.common.config.Global;
import cn.fundview.common.service.BaseService;
import cn.fundview.common.utils.FileUtils;
import cn.fundview.common.utils.StringUtils;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.CompanyMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.Company;
import cn.fundview.modules.util.Constants;
import cn.fundview.modules.util.DateTimeUtil;
import cn.fundview.modules.util.ImgUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Service(value = "companyService")
@Transactional(value="transactionManager2",readOnly = true)
public class CompanyService extends BaseService {

    @Resource(name = "companyMapper")
    private CompanyMapper companyMapper;

    @Resource(name = "accountMapper")
    private AccountMapper accountMapper;

    public List<Company> findList() {

        return companyMapper.getList();
    }

    /**
     * 禁用/启用 企业账户
     *
     * @param id
     * @param flag
     * @return
     */
    @Transactional(value="transactionManager2",readOnly = false)
    public boolean validCompany(int id, boolean flag) {
        // TODO Auto-generated method stub

        Account account = new Account();
        account.setId(id + "");
        account.setValid(flag);
        accountMapper.valid(account);

        // 更新企业
        Company company = new Company();
        company.setAccountId(id);
        company.setUpdateTime(new Date());
        company.setValid(flag ? 1 : 0);
        companyMapper.updateByPrimaryKeySelective(company);

        return true;
    }

    /**
     * 获取企业的详细信息
     *
     * @param company
     * @return
     */


    public Company get(Company company) {


        return companyMapper.get(company);
    }

    /**
     * 获取企业的简单信息
     *
     * @param company
     * @return
     */
    public Company getSimple(Company company) {


        Company comp = companyMapper.getSimple(company);
        if (StringUtils.isNotBlank(comp.getBusinessLicence())) {

            comp.setBusinessLicence(Global.getConfig("static.domain") + comp.getBusinessLicence().replace(Constants.COMP_LICENCE_ORI_PATH,
                    Constants.COMP_LICENCE_THUMP_PATH));
        }
        return comp;
    }

    /**
     * 更新企业信息
     *
     * @param company
     * @return boolean
     */
    @Transactional(value="transactionManager2",readOnly = false)
    public boolean updateCompany(Company company) {

        company.setUpdateTime(new Date());

        //图片处理
        if (StringUtils.isNotBlank(company.getBusinessLicence())) {

            String uploadPath = Global.getConfig("upload.img.absolute.path");//服务器原图存放路径
            String staticPath = Global.getConfig("static.absolute.path");//缩略图存放路径

            if (company.getBusinessLicence().startsWith("/temp")) {

                //临时文件,将临时文件保存到服务器端,生成缩略图, 删除临时文件,查看是否有原图,有的话需要 删除原图及原缩略图
                String oriBusinessLicenece = companyMapper.get(company).getBusinessLicence();
                if (StringUtils.isNotBlank(oriBusinessLicenece)) {

                    //删除原图
                    FileUtils.deleteFile(uploadPath + oriBusinessLicenece);
                    String oriThumbPath = null;
                    oriThumbPath = staticPath
                            + oriBusinessLicenece.replace(Constants.COMP_LICENCE_ORI_PATH,
                            Constants.COMP_LICENCE_THUMP_PATH);
                    FileUtils.deleteFile(oriThumbPath);
                    System.out.println("oriBusinessLicenece" + oriBusinessLicenece);
                    System.out.println("oriBusinessLiceneceThunb" + oriThumbPath);
                }

                String dateDir = "/" + DateTimeUtil.getFormatDay(new Date()) + "/";
                company.setBusinessLicence(Constants.COMP_LICENCE_ORI_PATH + dateDir + company.getBusinessLicence().substring(company.getBusinessLicence().lastIndexOf("/") + 1));
                FileUtils.copyFile(Global.getConfig("absolute.path") + company.getBusinessLicence(), Global.getConfig("upload.img.absolute.path") + Constants.COMP_LICENCE_ORI_PATH + dateDir + company.getBusinessLicence().substring(company.getBusinessLicence().lastIndexOf("/") + 1));

                //生成缩略图
                ImgUtils.compressPic(Global.getConfig("absolute.path") + company.getBusinessLicence(), Global.getConfig("static.absolute.path") + Constants.COMP_LICENCE_ORI_PATH + dateDir + company.getBusinessLicence().substring(company.getBusinessLicence().lastIndexOf("/") + 1), 0.7f);


                //删除临时图
                FileUtils.deleteFile(Global.getConfig("absolute.path") + company.getBusinessLicence());

            } else {

                //文件没有替换,不做更改
                company.setBusinessLicence(null);//不更新
            }
        }

        companyMapper.updateByPrimaryKeySelective(company);
        if (company.getAccount() != null)

        {
            company.getAccount().setId(company.getAccountId() + "");
            accountMapper.update(company.getAccount());
        }

        return true;
    }


    /**
     * 查询等待认证审核的企业列表
     * @return
     */
    public List<Company> getUnCheckCompList(Company param) {

      return  companyMapper.getUnCheckCompList(param);
    }

    public List<Map<String,Integer>> countAllCompByArea() {

        return companyMapper.countAllCompByArea();
    }
}
