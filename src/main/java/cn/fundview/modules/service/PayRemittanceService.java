package cn.fundview.modules.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import cn.fundview.modules.dao.PayRemittanceMapper;
import cn.fundview.modules.model.PayRemittance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("payRemittanceService")
@Transactional(value = "transactionManager2", readOnly = true)
public class PayRemittanceService {

    @Resource
    private PayRemittanceMapper payRemittanceMapper;

    @Transactional(value = "transactionManager2", readOnly = false)
    public void save(PayRemittance payRemittance) {
        payRemittanceMapper.insert(payRemittance);
    }

    public List<PayRemittance> findByPayCode(String code) {

       List<PayRemittance> result =  payRemittanceMapper.findByPayCode(code);
        return result;
    }

    public PayRemittance findById(int id) {

        return payRemittanceMapper.selectByPrimaryKey(id);
    }

    @Transactional(value="transactionManager2",readOnly = false)
    public void updateRealPayDate(int id) {

        PayRemittance item = new PayRemittance();
        item.setId(id);
        item.setRealPayDate(new Date());
        payRemittanceMapper.updateByPrimaryKeySelective(item);
    }


}
