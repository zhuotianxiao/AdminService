package cn.fundview.setting.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.setting.model.InsideTaskDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface InsideTaskDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(InsideTaskDetail record);

    int insertSelective(InsideTaskDetail record);

    InsideTaskDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InsideTaskDetail record);

    int updateByPrimaryKey(InsideTaskDetail record);

    List<InsideTaskDetail> selectByOrderId(String orderId);

    List<InsideTaskDetail> selectHandleTimerByOrderId(String orderId);

    float selectCountTimeByOrderId(String orderId);

    List<InsideTaskDetail> selectAll();

    List<InsideTaskDetail> selectByUserId(@Param("userId") String userId);
}