package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.PayMain;

@MyBatisDao
public interface PayMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayMain record);

    int insertSelective(PayMain record);

    PayMain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayMain record);

    int updateByPrimaryKey(PayMain record);
}