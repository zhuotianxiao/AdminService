package cn.fundview.modules.util.constants;

/**
 * 咨询取消状态
 *    
 * 项目名称：agr-join-v4   
 * 类名称：ConsultationCancelStatus   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年7月29日 下午2:38:11   
 * 修改人：lict    
 * 修改时间：2015年7月29日 下午2:38:11   
 * 修改备注：   
 * @version    
 *
 */
public enum ConsultationCancelStatus {
	
	TYPE_NO_CANCEL(0, "未取消"),TYPE_APPLY_CANCEL(1, "申请取消"),TYPE_FAIL(2, "处理失败"),TYPE_FINISH(3, "处理完成");
	private ConsultationCancelStatus(int value, String name) {
		
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

		for (ConsultationCancelStatus c : ConsultationCancelStatus.values()) {

			if (c.getValue() == value) {

				return c.name;
			}
		}
		return null;

	}
}
