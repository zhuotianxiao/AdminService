package cn.fundview.modules.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.KyOrg;

/**
 * 科研机构Dao
 *    
 * 项目名称：AdminService   
 * 类名称：KyOrgMapper   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月8日 下午10:41:52   
 * 修改人：lict    
 * 修改时间：2015年9月8日 下午10:41:52   
 * 修改备注：   
 * @version    
 *
 */
@MyBatisDao
public interface KyOrgMapper extends CrudDao<KyOrg>{
	
	/**
	 * 获取科研机构的简单信息(不含intro)
	 * 
	 * @param param
	 * @return Expert
	 *
	 */
	public KyOrg getSimple(KyOrg param);
}