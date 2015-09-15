package cn.fundview.modules.service;

import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service(value="accountService")
@Transactional(value="transactionManager2",readOnly = true)
public class AccountService {
	
	@Resource(name="accountMapper")
	private AccountMapper accountMapper;
	
	private static final String CACHE_ACCOUNT_ITEM_PREFIX = "account_";//单个账户的缓存前缀
	private static final String CACHE_ACCOUNT_ITEM = "account_item";//单个账户的缓存name
	
	public Account get(Account param) {
		
		if(param == null){
			
			return null;
		}else {
			
			//从缓存拿
//			Account account = (Account) CacheUtils.get(CACHE_ACCOUNT_ITEM,CACHE_ACCOUNT_ITEM_PREFIX + param.getId());
			Account account = null;
			if(account == null) {
				
				//从数据库拿
				account = accountMapper.get(param);
			}
			return account;
		}
	}
	
}
