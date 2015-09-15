package cn.fundview.modules.model;

import cn.fundview.common.persistence.DataEntity;

public class TcDict extends DataEntity<TcDict> {

	private static final long serialVersionUID = -3380425157290703829L;

	private String dictKey;

	private String dictValue;

	private String dictType;

	private Integer dictSort;

	private String delFlag;

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey == null ? null : dictKey.trim();
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue == null ? null : dictValue.trim();
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType == null ? null : dictType.trim();
	}

	public Integer getDictSort() {
		return dictSort;
	}

	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}
}