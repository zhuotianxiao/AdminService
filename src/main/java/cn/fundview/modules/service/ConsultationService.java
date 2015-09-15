package cn.fundview.modules.service;

import cn.fundview.common.service.BaseService;
import cn.fundview.modules.dao.ConsultationMapper;
import cn.fundview.modules.dao.OpeRecordMapper;
import cn.fundview.modules.model.Consultation;
import cn.fundview.modules.model.OpeRecord;
import cn.fundview.modules.util.Constants;
import cn.fundview.modules.util.constants.ConsultationCancelStatus;
import cn.fundview.modules.util.constants.ConsultationStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/9/11 0011.
 * <p/>
 * 咨询服务service
 */
@Service("consultationService")
@Transactional(value="transactionManager2",readOnly = true)
public class ConsultationService extends BaseService {

    @Resource(name = "consultationMapper")
    private ConsultationMapper mapper;

    @Resource(name = "opeRecordMapper")
    private OpeRecordMapper opeRecordMapper;

    /**
     * 查看列表
     *
     * @param param
     * @return
     */
    public List<Consultation> getList(Consultation param) {

        if (param != null) {

            return mapper.selectByParam(param);
        }

        return null;
    }

    /**
     * 查看详细
     *
     * @param id
     * @return
     */
    public Consultation get(int id) {


        Consultation result =  mapper.selectByPrimaryKey(id);
        if(result != null && result.getReport() != null) {

            result.getReport().getDocPath().replace(Constants.CONSULTATION_SERVICE_REPORT_PATH,Constants.CONSULTATION_SERVICE_REPORT_STATIC_PATH);
        }
        return result;
    }

    @Transactional(value="transactionManager2",readOnly = false)
    public Consultation updateStatus(int id, int oldStatus, int newStatus) {
        Consultation item = mapper.selectByPrimaryKey(id);

        if (item.getStatus() == oldStatus) {
            item.setStatus(newStatus);
            OpeRecord tor = new OpeRecord();
            tor.setType(1);
            tor.setFlowId(item.getId());
            tor.setOperatorId(item.getCompId());
            tor.setOperatorName(item.getConsulationMan());
            tor.setCurrStep(item.getStatus());
            tor.setOperatorType(1);
            tor.setOperate(ConsultationStatus.TYPE_PAYED.getName());
            tor.setMark("(企业)" + item.getConsulationMan() + "向(专家)" + item.getExpertName() + ConsultationStatus.TYPE_PAYED.getName() + "订单号:" + item.getId());
            tor.setCreateTime(new Date());
            opeRecordMapper.insert(tor);
            mapper.updateByPrimaryKeySelective(item);
        }
        return item;
    }

    /**
     * 审核处理
     * @param id
     * @param flag
     * @param cancelCheckMark  取消 审核备注
     * @return
     */
    @Transactional(value="transactionManager2",readOnly = false)
    public boolean serviceConsultationCheck(int id, boolean flag, String cancelCheckMark) {
        if (id == 0) {

            return false;
        }
        Consultation conService = mapper.selectByPrimaryKey(id);

        OpeRecord tor = new OpeRecord();
        tor.setCreateTime(new Date());
        tor.setCurrStep(conService.getStatus());
        tor.setFlowId(conService.getId());
        // 审核通过
        if (flag) {
            // 取消预约
            conService.setCancelStatus(ConsultationCancelStatus.TYPE_FINISH.getValue());
            conService.setCancelCheckMark(cancelCheckMark);//取消的审核备注
            tor.setMark("(企业)" + conService.getConsulationMan() + "审核通过取消(专家)" + conService.getExpertName() + "的咨询服务!订单号:" + conService.getId());

        } else {// 审核失败

            conService.setCancelStatus(ConsultationCancelStatus.TYPE_FAIL.getValue());
            conService.setCancelCheckMark(cancelCheckMark);
            tor.setMark("(企业)" + conService.getConsulationMan() + "审核拒绝取消(专家)" + conService.getExpertName() + "的咨询服务!订单号:" + conService.getId());
        }
        tor.setOperate(ConsultationStatus.TYPE_FINISH.getName());
        tor.setOperatorId(conService.getCompId());
        tor.setOperatorName(conService.getConsulationMan());
        tor.setOperatorType(1);
        tor.setType(1);
        opeRecordMapper.insert(tor);
        mapper.updateByPrimaryKeySelective(conService);//更新咨询服务
        return true;
    }
}
