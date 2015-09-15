package cn.fundview.setting.web;

import cn.fundview.common.utils.DateUtils;
import cn.fundview.common.utils.StringUtils;
import cn.fundview.common.web.BaseController;
import cn.fundview.modules.page.HandleData;
import cn.fundview.setting.model.*;
import cn.fundview.setting.service.InsideTaskOrderService;
import cn.fundview.setting.service.InsideTaskService;
import cn.fundview.setting.service.SystemService;
import cn.fundview.setting.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

/**
 * 企业内部任务管理Controller
 * Created by 健 on 2015/8/19.
 */
@Controller
@RequestMapping(value = "${adminPath}/task")
public class InsideTaskController extends BaseController {

    @Autowired
    private InsideTaskService insideTaskService;

    @Autowired
    private InsideTaskOrderService insideTaskOrderService;

    @Autowired
    private SystemService systemService;

    @ModelAttribute
    public InsideTask get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return insideTaskService.get(id);
        } else {
            return new InsideTask();
        }
    }

    /**
     * 查看任务列表
     * @param model         业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:view")
    @RequestMapping(value = {"index", ""})
    public String index(Model model) {
        List<InsideTask> insideTasks = insideTaskService.findTaskList();
        model.addAttribute("insideTasks", insideTasks);
        return "modules/task/index";
    }

    /**
     * 新增任务
     * @param insideTask 任务模型
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:edit")
    @RequestMapping(value = "add")
    public String add(InsideTask insideTask,Model model){
        User user = UserUtils.getUser();
        //根据权限查看当前用户能够指定任务的执行人
        List<User> userList = systemService.findUser(user);
        model.addAttribute("userList", userList);
        model.addAttribute("insideTask",insideTask);
        return "modules/task/add";
    }

    /**
     * 显示任务详细(包含任务单列表)
     * @param insideTask 任务模型
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:view")
    @RequestMapping(value = "form")
    public String form(InsideTask insideTask,Model model){
        if(StringUtils.isNotEmpty(insideTask.getId()) && insideTask.getType().equals(InsideTask.TASK_TYPE_COM) && StringUtils.isEmpty(insideTask.getParentId())){
            List<InsideTask> subTaskLists = insideTaskService.findTaskByParentId(insideTask.getId());
            model.addAttribute("subTaskLists",subTaskLists);
        }
        List<TaskOfficeOrder> officeOrders = insideTaskOrderService.findOfficeOrderByTaskId(insideTask.getId());
        //查询分配的人员任务单列表，人员任务单列表为空，说明未分配人员
        List<TaskUserOrder> userOrders = insideTaskOrderService.findUserOrderByTaskId(insideTask.getId());

        model.addAttribute("insideTask",insideTask);
        model.addAttribute("officeOrders",officeOrders);
        model.addAttribute("userOrders",userOrders);
        return "modules/task/form";
    }


    /**
     * 进入新建子任务界面
     * @param insideTask 任务模型
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:view")
    @RequestMapping(value = "add-sub-task")
    public String addSubTask(InsideTask insideTask,Model model){
        User user = UserUtils.getUser();
        //根据权限查看当前用户能够指定任务的执行人
        List<User> userList = systemService.findUser(user);
        model.addAttribute("userList", userList);
        return "modules/task/addSubTask";
    }

    /**
     * 保存子任务
     * @param insideTask 任务模型
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:edit")
    @RequestMapping(value = "save-sub-task")
    public String saveSubTask(InsideTask insideTask,Model model,RedirectAttributes redirectAttributes){
        if (!beanValidator(model, insideTask)){
            return form(insideTask, model);
        }
        if(StringUtils.isNotEmpty(insideTask.getParentId())){
            //获取父任务信息
            InsideTask parentTask = insideTaskService.get(insideTask.getParentId());
            //判断父任务的状态截至日期
            if(parentTask.getTaskStatus().equals(InsideTask.TASK_STATUS_OK)&& parentTask.getDeadline().after(insideTask.getDeadline())){
                insideTaskService.save(insideTask);
                addMessage(redirectAttributes, "保存子任务成功！");
                return "redirect:" + adminPath + "/task/add-sub-task?id="+insideTask.getParentId();
            }
        }
        addMessage(redirectAttributes, "保存子任务失败！");
        return "redirect:" + adminPath + "/task/add-sub-task?id="+insideTask.getParentId();

    }

    /**
     * 待办任务列表
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequestMapping(value = {"my-task"})
    public String myTask(Model model) {
        List<TaskUserOrder> taskUserOrders = insideTaskService.findMyTasks();
        model.addAttribute("taskUserOrders", taskUserOrders);
        return "modules/task/myTask";
    }

    /**
     * 查询待审批部门任务列表
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:inquiry:view")
    @RequestMapping(value = {"inquiry"})
    public String inquiry(Model model){
        List<InsideTask> list = insideTaskService.findInquiryList();
        model.addAttribute("list", list);
        return "modules/task/inquiry";
    }

    /**
     * 审批
     * @param key 状态值
     * @return 跳转页面
     */
    @RequiresPermissions("task:inquiry:edit")
    @RequestMapping(value = {"save-inquiry"})
    public String saveInquiry(InsideTask insideTask,String key,Model model){
        if(StringUtils.isNotEmpty(key)){
            if("1".equals(key)){
                insideTask.setTaskStatus(InsideTask.TASK_STATUS_OK);
            }else if("0".equals(key)){
                insideTask.setTaskStatus(InsideTask.TASK_STATUS_CANCEL);
            }
            insideTaskService.update(insideTask);
        }
        return inquiry(model);
    }

    /**
     * 查询待审批部门任务详细
     * @param insideTask 任务模型
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequiresPermissions("task:inquiry:view")
    @RequestMapping(value = {"inquiryTask"})
    public String inquiryTask(InsideTask insideTask, Model model){
        //查询分配的人员任务单列表，人员任务单列表为空，说明未分配人员
        List<TaskUserOrder> userOrders = insideTaskOrderService.findUserOrderByTaskId(insideTask.getId());
        model.addAttribute("userOrders", userOrders);
        model.addAttribute("insideTask", insideTask);
        return "modules/task/formInquiry";
    }

    /**
     * 保存任务，并为任务生成任务单
     * @param insideTask 任务模型
     * @param model 业务模型
     * @param redirectAttributes 重定向页面参数绑定
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:edit")
    @RequestMapping(value = "save")
    public String save(InsideTask insideTask,Model model,RedirectAttributes redirectAttributes){
        insideTaskService.save(insideTask);
        addMessage(redirectAttributes, "保存任务成功");
        return "redirect:" + adminPath + "/task/index";
    }

    /**
     * 关闭任务
     * @param insideTask 任务模型
     * @param model 业务模型
     * @param redirectAttributes 重定向页面参数绑定
     * @return 跳转页面
     */
    @RequiresPermissions("task:list:edit")
    @RequestMapping(value = "close-task")
    public String closeTask(InsideTask insideTask,Model model,RedirectAttributes redirectAttributes){
        if (!beanValidator(model, insideTask)){
            return form(insideTask, model);
        }
        insideTask.setTaskStatus(InsideTask.TASK_STATUS_STOP);
        insideTaskService.update(insideTask);
        addMessage(redirectAttributes, "任务已关闭");
        return "redirect:" + adminPath + "/task/index";
    }

    /**
     * 异步获取办理数据统计
     * @param orderId 任务单号
     * @return 跳转页面
     */
    @RequestMapping(value = {"get-handle-data"})
    @ResponseBody
    public String getHandleData(String orderId) {
        List<HandleData> handleDatas = Lists.newArrayList();
        List<InsideTaskDetail> taskDetails = insideTaskService.findHandleTimerByOrderId(orderId);
        if(!taskDetails.isEmpty()){
            for (InsideTaskDetail taskDetail : taskDetails) {
                HandleData handleData = new HandleData();
                handleData.setX(DateUtils.formatDateDefault(taskDetail.getWorkDate()));
                handleData.setY(String.valueOf(taskDetail.getWorkTime()));
                handleDatas.add(handleData);
            }
        }
        return JSON.toJSONString(handleDatas);
    }

    /**
     * 办理任务
     * @param taskUserOrder 任务单模型
     * @param model 业务模型
     * @param redirectAttributes 重定向页面参数绑定
     * @return 跳转页面
     */
    @RequestMapping(value = {"handle"})
    public String handle(TaskUserOrder taskUserOrder,InsideTaskDetail insideTaskDetail,Model model,RedirectAttributes redirectAttributes){
        List<InsideTaskDetail> taskDetails = Lists.newArrayList();
        if(null!=taskUserOrder && StringUtils.isNotEmpty(taskUserOrder.getId())){
            //查询任务单详情
            taskUserOrder = insideTaskService.findOrderByOrderId(taskUserOrder.getId());
            //根据任务单查询已办理记录
            taskDetails = insideTaskService.findInsideTaskDetailByOrderId(taskUserOrder.getId());
        }

        model.addAttribute("taskDetails", taskDetails);
        model.addAttribute("taskUserOrder", taskUserOrder);
        return "modules/task/handle";
    }

    /**
     * 办理任务保存
     * @param insideTaskDetail 任务详细模型
     * @param model 业务模型
     * @param redirectAttributes 重定向页面参数绑定
     * @return 跳转页面
     */
    @RequestMapping(value = {"save-handle"})
    public String saveHandle(InsideTaskDetail insideTaskDetail,Model model,RedirectAttributes redirectAttributes){
        //判断任务状态是否正常
        if(null!=insideTaskDetail && StringUtils.isNotEmpty(insideTaskDetail.getOrderId())){
            List<InsideTask> insideTasks = insideTaskService.findInsideTaskByOrderId(insideTaskDetail.getOrderId());
            if(!insideTasks.isEmpty()){
                for (InsideTask insideTask : insideTasks) {
                    //已结束无法填写
                    if(insideTask.getTaskStatus().equals(InsideTask.TASK_STATUS_STOP)){
                        addMessage(redirectAttributes, "保存失败！<br/> 该任务已结束无法填写");
                        return "redirect:" + adminPath + "/task/handle?id="+insideTaskDetail.getOrderId();
                    }

                    if(insideTask.getTaskStatus().equals(InsideTask.TASK_STATUS_OK)){
                        //判断是否日期超过截至时间或早于发布时间，不能填写
                        Date deadline = insideTask.getDeadline();
                        Date workDate = insideTaskDetail.getWorkDate();
                        Date createDate =DateUtils.parseDate(DateUtils.formatDateDefault(insideTask.getCreateDate()));
                        //1.选择的日期大于今天，不能填写
                        //2.选择的日期大于截至日期，不能填写
                        //3.选择的日期小于任务发布时间，不能填写
                        if(workDate.getTime() > new Date().getTime() ||
                                workDate.getTime() > deadline.getTime() ||
                                workDate.getTime() < createDate.getTime()){
                            addMessage(redirectAttributes, "保存失败！<br/> 日期超过截至时间或早于发布时间");
                            return "redirect:" + adminPath + "/task/handle?id="+insideTaskDetail.getOrderId();
                        }
                        //1.填写的日期大于截至日期，不能填写
                        if(deadline.getTime() < new Date().getTime()){
                            addMessage(redirectAttributes, "保存失败！<br/> 日期超过截至时间");
                            return "redirect:" + adminPath + "/task/handle?id="+insideTaskDetail.getOrderId();
                        }

                        insideTaskService.saveInsideTaskDetail(insideTaskDetail);
                        addMessage(redirectAttributes, "保存成功！");
                    }


                }
            }
        }else{
            addMessage(redirectAttributes, "保存失败！");
        }

        return "redirect:" + adminPath + "/task/handle?id="+insideTaskDetail.getOrderId();
    }


    /**
     * 显示任务时间轴
     * @param model 业务模型
     * @return 跳转页面
     */
    @RequestMapping(value = "timeLine")
    public String timeLine(InsideTask insideTask,Model model){
        return "modules/task/timeLine";
    }

    /**
     * 查询数据显示到时间轴
     * @param page      分页
     * @param userId    用户
     * @param orderId   任务单号
     * @param model     业务模型
     * @return 跳转页面
     */
    @RequestMapping(value = "getTimeLineData")
    public String getTimeLineData(String page,String userId,String orderId,Model model){
        List<InsideTaskDetail> taskDetails = Lists.newArrayList();
        if(StringUtils.isNotEmpty(userId)){
            taskDetails = insideTaskService.findTaskDetailsByUser(userId);
        }else if(StringUtils.isNotEmpty(orderId)){
            taskDetails = insideTaskService.findTaskDetailsByOrder(orderId);
        }else{
            taskDetails = insideTaskService.findAllInsideTaskDetail();
        }

        model.addAttribute("taskDetails", taskDetails);
        return "modules/task/timeLineItem";
    }




}
