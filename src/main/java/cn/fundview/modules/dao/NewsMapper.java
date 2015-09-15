package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.News;

import java.util.List;

@MyBatisDao
public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    List<News> selectAll();
}