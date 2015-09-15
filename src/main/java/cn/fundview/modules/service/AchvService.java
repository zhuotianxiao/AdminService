package cn.fundview.modules.service;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.AchvNewMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.AchvNew;
import cn.fundview.modules.web.vo.AchvVo;


@Service("achvService")
@Transactional("transactionManager2")
public class AchvService extends CrudService<AchvNewMapper, AchvNew>{
	
	@Resource(name="achvNewMapper")
	private AchvNewMapper achvMapper;
	
	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;
	
	public List<AchvNew> findAll() {
			
		  List<AchvNew> list = achvMapper.findAllListItem();
			
		return list;
	}
	public List<AchvNew>  findNo() {
			
		  List<AchvNew> list = achvMapper.findNoListItem();
			
		return list;
	}

	public List<AchvNew>  findNow() {
			
		  List<AchvNew> list = achvMapper.findNowListItem();
			
		return list;
	}

	public List<AchvNew>  findEnd() {
			
		  List<AchvNew> list = achvMapper.findEndListItem();
			
		return list;
	}
	public boolean validAchv(String id, boolean flag) {
		// TODO Auto-generated method stub

		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.delete(account);

		// ���³ɹ�
		AchvNew achvNew = new AchvNew();
		achvNew.setId(id+"");
		achvNew.setUpdateDate(new Date());
		achvNew.setValid(flag);
		dao.update(achvNew);
		// ���»���
		// List<ExpertItem> list = dao.findAllListItem();
		// UserUtils.putCache(Constants.CACHE_EXPERT_LIST,list);
		return true;
		
	}
	public boolean updateAchv(AchvNew achvNew) {
		dao.update(achvNew);// ����ר���ֻ�ź�name
		return true;
		
	}

}
