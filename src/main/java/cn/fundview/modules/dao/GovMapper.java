package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Gov;

import java.util.List;

/**
 * 政府机构dao
 */
@MyBatisDao
public interface GovMapper {

    /**
     * 查看详细
     * @param param
     * @return
     */
    public Gov get(Gov param);

    /**
     * 查看列表
     * @return
     */
    public List<Gov> getList();
}