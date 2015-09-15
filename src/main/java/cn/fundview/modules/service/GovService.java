package cn.fundview.modules.service;

import cn.fundview.common.service.BaseService;
import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.FinanceMapper;
import cn.fundview.modules.dao.GovMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.Finance;
import cn.fundview.modules.model.Gov;
import cn.fundview.modules.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 政府机构service
 */
@Service(value="govService")
@Transactional(value="transactionManager2",readOnly = true)
public class GovService extends BaseService{
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;

	@Resource(name = "govMapper")
	private GovMapper govMapper;

	/**
	 * 禁用/启用金融机构
	 * 
	 * @param id
	 * @param flag
	 * @return boolean
	 *
	 */
	@Transactional(value="transactionManager2",readOnly = false)
	public boolean validGov(String id, boolean flag){
		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.valid(account);
		return true;
	}


    /**
     * 查询 政府机构详细
     * @param entity
     * @return
     */
    public Gov get(Gov entity) {
        Gov gov = govMapper.get(entity);

        return gov;
    }
    /**
     * 查询 政府机构列表
     * @return
     */
    public List<Gov> getList() {

        return govMapper.getList();
    }
}
