package cn.fundview.modules.service;

import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.KyOrgMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.KyOrg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service(value="kyOrgService")
@Transactional(value="transactionManager2",readOnly = true)
public class KyOrgService extends  CrudService<KyOrgMapper,KyOrg>{
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	
	/**
	 * 禁用/启用科研机构
	 * 
	 * @param id
	 * @param flag
	 * @return boolean
	 *
	 */
	@Transactional(value="transactionManager2",readOnly = false)
	public boolean validKyorg(String id, boolean flag){
		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.valid(account);

		// 更新缓存
		// List<ExpertItem> list = dao.findAllListItem();
		// UserUtils.putCache(Constants.CACHE_EXPERT_LIST,list);
		return true;
	}
	
	public KyOrg get(String id) {

		KyOrg param = new KyOrg();
		param.setId(id);
		return dao.getSimple(param);
	}

	/**
	 * 更新科研机构认证信息
	 *
	 * @param param
	 * @return boolean
	 *
	 */
	@Transactional(value="transactionManager2",readOnly = false)
	public boolean updateKyOrg(KyOrg kyOrg) {

		kyOrg.setUpdateDate(new Date());
		dao.update(kyOrg);// 更新专家手机号和name
		if (kyOrg.getAccount() != null) {
			kyOrg.getAccount().setId(kyOrg.getId());
			accountMapper.update(kyOrg.getAccount());
		}
		return true;
	}
}
