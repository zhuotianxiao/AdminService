package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.ExpertConsulation;

/**
 * 专家咨询服务Dao
 */
@MyBatisDao
public interface ExpertConsulationMapper {


    public ExpertConsulation selectByPrimaryKey(ExpertConsulation expertConsulation);

}