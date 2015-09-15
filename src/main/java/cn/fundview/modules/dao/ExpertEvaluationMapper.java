package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.ExpertEvaluation;

@MyBatisDao
public interface ExpertEvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpertEvaluation record);

    int insertSelective(ExpertEvaluation record);

    ExpertEvaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpertEvaluation record);

    int updateByPrimaryKey(ExpertEvaluation record);
}