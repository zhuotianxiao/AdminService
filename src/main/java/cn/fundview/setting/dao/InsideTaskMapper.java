package cn.fundview.setting.dao;


import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.InsideTask;

import java.util.List;

@MyBatisDao
public interface InsideTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(InsideTask record);

    int insertSelective(InsideTask record);

    InsideTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InsideTask record);

    int updateByPrimaryKey(InsideTask record);

    /**
     * 查询所有任务
     * @return 任务列表
     */
    List<InsideTask> selectAll();

    /**
     * 查询部门任务
     */
    List<InsideTask> selectByOfficeId(String officeId);

    /**
     * 根据创建人查询任务
     */
    List<InsideTask> selectByCreateUser(String userId);

    /**
     * 查询个人任务
     */
    List<InsideTask> selectByUserId(String userId);

    /**
     * 根据任务单号，查询所属任务信息
     * @param orderId
     * @return
     */
    List<InsideTask> selectByOrderId(String orderId);

    /**
     * 根据任务id，查询子任务
     * @param parentId 任务单号
     */
    List<InsideTask> selectByParentId(String parentId);

    /**
     * 查询待审核任务列表
     */
    List<InsideTask> findInquiryList();
}