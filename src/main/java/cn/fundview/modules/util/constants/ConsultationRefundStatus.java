package cn.fundview.modules.util.constants;

/**
 * 退款申请状态
 *    
 * 项目名称：agr-join-v4   
 * 类名称：ConsultationRefundStatus   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年7月29日 下午2:41:01   
 * 修改人：lict    
 * 修改时间：2015年7月29日 下午2:41:01   
 * 修改备注：   
 * @version    
 *
 */
public enum ConsultationRefundStatus {
	
	TYPE_NO_APPLY(0, "未申请"),TYPE_APPLY(1, "已申请"),TYPE_SUCCESS(3, "退款成功"),TYPE_FAIL(4, "退款失败");
	private ConsultationRefundStatus(int value, String name) {
		
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
}
