package cn.fundview.modules.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Account;

/**
 * 平台账户Dao
 *    
 * 项目名称：AdminService   
 * 类名称：AccountMapper   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月8日 上午11:39:50   
 * 修改人：lict    
 * 修改时间：2015年9月8日 上午11:39:50   
 * 修改备注：   
 * @version    
 *
 */

@MyBatisDao
public interface AccountMapper extends CrudDao<Account>{

    /**
     * 禁用/启用账户
     * @param account
     */
    public void valid(Account account);
}