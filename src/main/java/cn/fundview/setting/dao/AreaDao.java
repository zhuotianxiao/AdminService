/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.dao;


import cn.fundview.common.persistence.TreeDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.Area;

/**
 * 区域DAO接口
 * @author wangjian
 * @version 2014-05-16
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
