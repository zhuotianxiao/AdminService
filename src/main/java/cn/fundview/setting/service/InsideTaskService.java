package cn.fundview.setting.service;


import cn.fundview.common.config.Global;
import cn.fundview.common.utils.IdGen;
import cn.fundview.common.utils.StringUtils;
import cn.fundview.setting.dao.InsideTaskDetailMapper;
import cn.fundview.setting.dao.InsideTaskMapper;
import cn.fundview.setting.dao.TaskOfficeOrderMapper;
import cn.fundview.setting.dao.TaskUserOrderMapper;
import cn.fundview.setting.model.*;
import cn.fundview.setting.utils.UserUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 任务模型服务
 * Created by 健 on 2015/8/19.
 */
@Service
@Transactional(readOnly = true)
public class InsideTaskService{

    @Autowired
    private InsideTaskMapper insideTaskMapper;

    @Autowired
    private TaskOfficeOrderMapper taskOfficeOrderMapper;

    @Autowired
    private TaskUserOrderMapper taskUserOrderMapper;

    @Autowired
    private InsideTaskDetailMapper insideTaskDetailMapper;

    public InsideTask get(String id) {
        return insideTaskMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据角色查询任务列表
     * @return 任务列表
     */
    public List<InsideTask> findTaskList() {
        List<InsideTask> insideTasks = Lists.newArrayList();
        //根据角色返回不同的任务列表
        //1.公司领导查看所有任务
        //2.部门领导查看本部门任务列表
        //3.普通用户查看指派到个人的任务列表
        User user = UserUtils.getUser();
        if(user.isAdmin() || user.getRoleIdList().contains("3")){
            insideTasks = insideTaskMapper.selectAll();
        }else if(user.getRoleIdList().contains("1")){
            insideTasks = insideTaskMapper.selectByOfficeId(user.getOffice().getId());
            List<InsideTask> taskList = insideTaskMapper.selectByCreateUser(user.getId());
            if(!taskList.isEmpty()){
                insideTasks.addAll(taskList);
            }
        }else{
            insideTasks = insideTaskMapper.selectByUserId(user.getId());
        }
        return insideTasks;
    }

    /**
     * 查询我的任务
     */
    public List<TaskUserOrder> findMyTasks(){
        //查询属于我的任务单，然后根据任务单查询任务
        List<TaskUserOrder> taskUserOrders = taskUserOrderMapper.selectByUserId(UserUtils.getUser().getId());
        if(!taskUserOrders.isEmpty()){
            for (TaskUserOrder taskUserOrder : taskUserOrders) {
                InsideTask insideTask = insideTaskMapper.selectByPrimaryKey(taskUserOrder.getTaskId());
                taskUserOrder.setInsideTask(insideTask);
            }
        }
        return taskUserOrders;
    }


    /**
     * 更新任务信息
     * @param insideTask
     */
    @Transactional(readOnly = false)
    public void update(InsideTask insideTask) {
        insideTaskMapper.updateByPrimaryKeySelective(insideTask);
    }


    /**
     * 保存公司任务或部门任务
     * @param insideTask
     */
    @Transactional(readOnly = false)
    public void save(InsideTask insideTask) {
        User user = UserUtils.getUser();
        List<String> userIds = insideTask.getUserIds();
        List<String> officeIds = insideTask.getOfficeIds();
        if (!user.getRoleIdList().contains("3") && StringUtils.isEmpty(insideTask.getParentId())) {
            //部门任务
            insideTask.setType(InsideTask.TASK_TYPE_OFFICE);
            String timer = insideTask.getTimer();
            //大于规定小时需要审批
            if (Double.parseDouble(timer) > Double.parseDouble(Global.getApprovalValue())) {
                insideTask.setTaskStatus(InsideTask.TASK_STATUS_APPROVAL);
            }
        }
        insideTask.preInsert();
        insideTaskMapper.insertSelective(insideTask);


        //保存任务保存成功并且任务状态是正常的，为指定用户生成任务单
        if (StringUtils.isNotEmpty(insideTask.getId())) {
            //如果没有指定到用户,而是指定到部门说明是公司领导发布的任务,
            //为该部门生成任务单反之生成人员任务单
            if (null != officeIds && officeIds.size()>0) {
                List<TaskOfficeOrder> taskOfficeOrders = Lists.newArrayList();
                for (String officeId : officeIds) {
                    TaskOfficeOrder taskOfficeOrder = new TaskOfficeOrder();
                    taskOfficeOrder.setId(IdGen.uuid());
                    taskOfficeOrder.setTaskId(insideTask.getId());
                    taskOfficeOrder.setFirstAgent(officeId);
                    taskOfficeOrders.add(taskOfficeOrder);
                }
                taskOfficeOrderMapper.insertList(taskOfficeOrders);
            }
            if (null != userIds && userIds.size()>0) {
                List<TaskUserOrder> taskUserOrders = Lists.newArrayList();
                for (String userId : userIds) {
                    TaskUserOrder taskUserOrder = new TaskUserOrder();
                    taskUserOrder.setId(IdGen.uuid());
                    taskUserOrder.setTaskId(insideTask.getId());
                    taskUserOrder.setConsumer(userId);
                    taskUserOrders.add(taskUserOrder);
                }
                taskUserOrderMapper.insertList(taskUserOrders);
            }
        }

    }

    /**
     * 根据任务单号，查询任务单详细
     * @param orderId 任务单号
     */
    public TaskUserOrder findOrderByOrderId(String orderId) {
        TaskUserOrder taskUserOrder = taskUserOrderMapper.selectByPrimaryKey(orderId);
        if(null!=taskUserOrder){
            InsideTask insideTask = insideTaskMapper.selectByPrimaryKey(taskUserOrder.getTaskId());
            if(null!=insideTask){
                taskUserOrder.setInsideTask(insideTask);
            }
        }
        return taskUserOrder;
    }

    /**
     * 根据任务id，查询子任务
     * @param parentId 任务单号
     */
    public List<InsideTask> findTaskByParentId(String parentId) {
        List<InsideTask> insideTasks = insideTaskMapper.selectByParentId(parentId);
        return insideTasks;
    }


    /**
     * 根据任务单号，查询所属任务信息
     * @param orderId 任务单号
     */
    public List<InsideTask> findInsideTaskByOrderId(String orderId) {
        List<InsideTask> insideTasks = insideTaskMapper.selectByOrderId(orderId);
        return insideTasks;
    }

    /**
     * 查询任务单办理记录
     * @param orderId 任务单号
     */
    public List<InsideTaskDetail> findInsideTaskDetailByOrderId(String orderId) {
        List<InsideTaskDetail> insideTaskDetails = insideTaskDetailMapper.selectByOrderId(orderId);
        return insideTaskDetails;
    }

    /**
     * 根据任务单统计用时记录，相同日期会将总时间相加
     * @param orderId 任务单号
     * @return 用时记录
     */
    public List<InsideTaskDetail> findHandleTimerByOrderId(String orderId) {
        List<InsideTaskDetail> insideTaskDetails = insideTaskDetailMapper.selectHandleTimerByOrderId(orderId);
        return insideTaskDetails;
    }

    /**
     * 保存办理记录
     * @param insideTaskDetail 办理任务详细
     */
    @Transactional(readOnly = false)
    public void saveInsideTaskDetail(InsideTaskDetail insideTaskDetail) {
        insideTaskDetail.setId(IdGen.uuid());
        insideTaskDetail.setCreateDate(new Date());
        insideTaskDetailMapper.insertSelective(insideTaskDetail);
    }

    /**
     * 查询待审核任务列表
     */
    public List<InsideTask> findInquiryList() {
        List<InsideTask> insideTasks = insideTaskMapper.findInquiryList();
        return insideTasks;
    }

    /**
     * 查询所有的工作记录
     * @return 工作记录
     */
    public List<InsideTaskDetail> findAllInsideTaskDetail() {
        return insideTaskDetailMapper.selectAll();
    }

    /**
     * 根据人员查询工作记录
     * @param userId 人员Id
     * @return 工作记录
     */
    public List<InsideTaskDetail> findTaskDetailsByUser(String userId) {
        return insideTaskDetailMapper.selectByUserId(userId);
    }

    /**
     * 根据任务单号查询工作记录
     * @param orderId 任务单Id
     * @return 工作记录
     */
    public List<InsideTaskDetail> findTaskDetailsByOrder(String orderId) {
        return insideTaskDetailMapper.selectByOrderId(orderId);
    }
}
