package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Consultation;

import java.util.List;

/**
 * 咨询服务Dao
 */
@MyBatisDao
public interface ConsultationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consultation record);

    int insertSelective(Consultation record);

    Consultation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consultation record);

    public List<Consultation> selectByParam(Consultation param);

}