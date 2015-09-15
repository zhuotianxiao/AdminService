package cn.fundview.modules.service;

import cn.fundview.modules.dao.PayMainMapper;
import cn.fundview.modules.model.PayMain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("payMainService")
@Transactional(value = "transactionManager2", readOnly = true)
public class PayMainService  {

	@Resource
	private PayMainMapper payMainMapper;

	@Transactional(value = "transactionManager2", readOnly = false)
	public void save(PayMain payMain){
		payMainMapper.insert(payMain);
	}

	public PayMain findById(Integer payId) {
		return payMainMapper.selectByPrimaryKey(payId);
	}

	@Transactional(value = "transactionManager2", readOnly = false)
	public void confirmPay(Integer payId) {


		PayMain main = new PayMain();
		main.setId(payId);
		main.setPayStatus(1);
		payMainMapper.updateByPrimaryKeySelective(main);
	}
	
}
