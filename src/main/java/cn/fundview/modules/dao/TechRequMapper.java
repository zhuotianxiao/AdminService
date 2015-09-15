package cn.fundview.modules.dao;


import java.util.List;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.TechRequ;

@MyBatisDao
public interface TechRequMapper  extends CrudDao<TechRequ>{

	List<TechRequ> findAllList();
}