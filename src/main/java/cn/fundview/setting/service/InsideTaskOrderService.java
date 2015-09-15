package cn.fundview.setting.service;

import cn.fundview.setting.dao.InsideTaskDetailMapper;
import cn.fundview.setting.dao.TaskOfficeOrderMapper;
import cn.fundview.setting.dao.TaskUserOrderMapper;
import cn.fundview.setting.model.InsideTaskDetail;
import cn.fundview.setting.model.TaskOfficeOrder;
import cn.fundview.setting.model.TaskUserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 健 on 2015/8/21.
 */
@Service
@Transactional(readOnly = true)
public class InsideTaskOrderService {

    @Autowired
    private TaskOfficeOrderMapper taskOfficeOrderMapper;

    @Autowired
    private TaskUserOrderMapper taskUserOrderMapper;

    @Autowired
    private InsideTaskDetailMapper insideTaskDetailMapper;

    //根据任务号查询部门任务单
    public List<TaskOfficeOrder> findOfficeOrderByTaskId(String taskId){
        return taskOfficeOrderMapper.selectByTaskId(taskId);
    }

    //根据任务号查询人员任务单,并查询详细的用时信息以及总时间
    public List<TaskUserOrder> findUserOrderByTaskId(String taskId){
        List<TaskUserOrder> taskUserOrders = taskUserOrderMapper.selectByTaskId(taskId);

        if(!taskUserOrders.isEmpty()){
            for (TaskUserOrder taskUserOrder : taskUserOrders) {
                //查询详细的用时信息
                List<InsideTaskDetail> insideTaskDetails = insideTaskDetailMapper.selectByOrderId(taskUserOrder.getId());
                if(!insideTaskDetails.isEmpty()){
                    taskUserOrder.setInsideTaskDetails(insideTaskDetails);
                }
                //总时间
                float countTime = insideTaskDetailMapper.selectCountTimeByOrderId(taskUserOrder.getId());
                taskUserOrder.setCountTime(countTime);
            }
        }

        return taskUserOrders;
    }
}
