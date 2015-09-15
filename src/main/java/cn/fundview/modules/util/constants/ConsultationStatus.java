package cn.fundview.modules.util.constants;

/**
 * 咨询状态
 * <p/>
 * 项目名称：agr-join-v4
 * 类名称：ConsultationStatus
 * 类描述：
 * 创建人：lict
 * 创建时间：2015年7月29日 下午2:44:13
 * 修改人：lict
 * 修改时间：2015年7月29日 下午2:44:13
 * 修改备注：
 */
public enum ConsultationStatus {

    TYPE_INIT(0, "初始化"), TYPE_SUBMIT(1, "提交预约申请"), TYPE_EXPERT_SURE(2, "专家确认"), TYPE_SURE_FAIL(10, "专家确认失败"), TYPE_PAYED(3, "支付完成"), TYPE_SUBMIT_REPORT(4, "提交服务报告"), TYPE_FINISH(5, "服务完成");

    ConsultationStatus(int value, String name) {

        this.value = value;
        this.name = name;
    }

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNames(int value) {

        for (ConsultationStatus c : ConsultationStatus.values()) {

            if (c.getValue() == value) {

                return c.name;

            }

        }

        return null;

    }
}
