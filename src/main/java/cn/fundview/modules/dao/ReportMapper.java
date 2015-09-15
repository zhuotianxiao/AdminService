package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Report;

@MyBatisDao
public interface ReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
}