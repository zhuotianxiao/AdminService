package cn.fundview.setting.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.TaskUserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@MyBatisDao
public interface TaskUserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskUserOrder record);

    int insertSelective(TaskUserOrder record);

    TaskUserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskUserOrder record);

    int updateByPrimaryKey(TaskUserOrder record);

    void insertList(List<TaskUserOrder> taskUserOrders);

    /**
     * 根据任务号查询任务单详情
     * @param taskId
     * @return
     */
    List<TaskUserOrder> selectByTaskId(@Param("taskId") String taskId);

    /**
     * 查询我的任务单列表
     * @param userId
     * @return
     */
    List<TaskUserOrder> selectByUserId(@Param("userId") String userId);
}