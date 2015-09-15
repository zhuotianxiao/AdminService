/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.dao;

import java.util.List;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.Dict;

/**
 * 字典DAO接口
 * @author wangjian
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
}
