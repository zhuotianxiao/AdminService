package cn.fundview.modules.service;

import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.FinanceMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service(value="financeService")
@Transactional(value="transactionManager2",readOnly = true)
public class FinanceService extends  CrudService<FinanceMapper,Finance>{
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	
	/**
	 * 禁用/启用金融机构
	 * 
	 * @param id
	 * @param flag
	 * @return boolean
	 *
	 */

	@Transactional(value="transactionManager2",readOnly = false)
	public boolean validFinance(String id, boolean flag){
		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.valid(account);
		return true;
	}
	

	/**
	 * 更新专家认证信息,包括专家账户
	 * 
	 * @return boolean
	 * 
	 */
	@Transactional(value="transactionManager2",readOnly = false)
	public boolean updateFinance(Finance finance) {
		
		finance.setUpdateDate(new Date());
		dao.update(finance);// 更新专家手机号和name
		if (finance.getAccount() != null) {
			finance.getAccount().setId(finance.getId());
			accountMapper.update(finance.getAccount());
		}
		return true;
	}

    /**
     * 查询 金融机构详细
     * @param entity
     * @return
     */
    @Override
    public Finance get(Finance entity) {
        Finance finance = dao.get(entity);

        String url = null;
        if (StringUtils.isNotBlank(finance.getBusinessLicence())) {
            url = Constants.STATIC_PATH + finance.getBusinessLicence().replace(Constants.FINANCE_LICENCE_ORI_PATH,
                    Constants.FINANCE_LICENCE_THUMP_PATH);
        }

        System.out.println(url);
        finance.setBusinessLicence(url);
        return finance;
    }

	/**
	 * 查询等待认证审核的企业列表
	 * @return
	 */
	public List <Finance> getUnCheckFinanceList(Finance param) {

		return  dao.getUnCheckFinanceList(param);
	}
}
