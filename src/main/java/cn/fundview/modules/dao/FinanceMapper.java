package cn.fundview.modules.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Finance;

import java.util.List;

/**
 * 金融机构 Dao
 *    
 * 项目名称：AdminService   
 * 类名称：FinanceMapper   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月9日 上午8:30:21   
 * 修改人：lict    
 * 修改时间：2015年9月9日 上午8:30:21   
 * 修改备注：   
 * @version    
 *
 */
@MyBatisDao
public interface FinanceMapper extends CrudDao<Finance> {

    public List<Finance> getUnCheckFinanceList(Finance finance);
}