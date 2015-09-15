package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.OpeRecord;

@MyBatisDao
public interface OpeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpeRecord record);

    int insertSelective(OpeRecord record);

    OpeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpeRecord record);

    int updateByPrimaryKey(OpeRecord record);
}