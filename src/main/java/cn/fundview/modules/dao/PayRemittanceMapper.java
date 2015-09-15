package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.PayRemittance;

import java.util.List;

@MyBatisDao
public interface PayRemittanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayRemittance record);

    int insertSelective(PayRemittance record);

    PayRemittance selectByPrimaryKey(Integer id);

    List<PayRemittance> findByPayCode(String code);

    int updateByPrimaryKeySelective(PayRemittance record);

    int updateByPrimaryKey(PayRemittance record);


}