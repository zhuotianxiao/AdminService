package cn.fundview.modules.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.TcDict;

import java.util.List;

/**
 * 平台字典Dao
 *    
 * 项目名称：AdminService   
 * 类名称：TcDictMapper   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月8日 下午2:51:59   
 * 修改人：lict    
 * 修改时间：2015年9月8日 下午2:51:59   
 * 修改备注：   
 * @version    
 *
 */
@MyBatisDao
public interface TcDictMapper extends CrudDao<TcDict>{
   
	public List<TcDict> getTcDictsByTypeAndKey(TcDict param);
}