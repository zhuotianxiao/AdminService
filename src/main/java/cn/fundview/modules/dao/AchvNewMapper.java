package cn.fundview.modules.dao;

import java.util.List;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.AchvNew;


@MyBatisDao
public interface AchvNewMapper extends CrudDao<AchvNew> {
	
	 List<AchvNew> findAllListItem();

	 List<AchvNew> findNoListItem();

	 List<AchvNew> findNowListItem();

	 List<AchvNew> findEndListItem();
}

