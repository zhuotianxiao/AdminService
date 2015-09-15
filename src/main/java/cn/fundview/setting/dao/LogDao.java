/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.Log;

/**
 * 日志DAO接口
 * @author wangjian
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
