package cn.fundview.setting.dao;


import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.TaskOfficeOrder;

import java.util.List;

@MyBatisDao
public interface TaskOfficeOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskOfficeOrder record);

    int insertSelective(TaskOfficeOrder record);

    TaskOfficeOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskOfficeOrder record);

    int updateByPrimaryKey(TaskOfficeOrder record);

    void insertList(List<TaskOfficeOrder> taskOfficeOrders);

    List<TaskOfficeOrder> selectByTaskId(String taskId);
}