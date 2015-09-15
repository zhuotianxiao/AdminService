package cn.fundview.modules.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fundview.common.service.BaseService;
import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.TechRequMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.TechRequ;


@Service("techService")
@Transactional("transactionManager2")
public class TechService extends BaseService {

	@Resource(name="techRequMapper")
	private TechRequMapper techRequMapper;
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	
	public List<TechRequ> findAll() {

		List<TechRequ> list = (List<TechRequ>) techRequMapper.findAllList();
		
		return list;
	}

	public boolean validTech(String id, boolean flag) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.valid(account);

		// ���³ɹ�
		TechRequ techRequ = new TechRequ();
		techRequ.setId(id+"");
		techRequ.setUpdateDate(new Date());
		techRequ.setValid(flag);
		techRequMapper.update(techRequ);
		return true;
		
	}

	public boolean updateTech(TechRequ techrequ) {
		techRequMapper.update(techrequ);
		return true;
	}

	public TechRequ get(TechRequ techrequ) {
		// TODO Auto-generated method stub
		return techRequMapper.get(techrequ);
	}

	

}
