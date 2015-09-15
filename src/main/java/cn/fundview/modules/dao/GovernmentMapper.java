package cn.fundview.modules.dao;

import cn.fundview.modules.model.Government;

public interface GovernmentMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Government record);

    int insertSelective(Government record);

    Government selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Government record);

    int updateByPrimaryKey(Government record);
}