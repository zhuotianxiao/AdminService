package cn.fundview.modules.dao;

import cn.fundview.common.persistence.CrudDao;
import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Expert;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface ExpertMapper extends  CrudDao<Expert>{
	
	/**
	 * 查询全部列表
	 * 
	 * @return ExpertItem
	 *
	 */
	public List<Expert> findAllListItem();
	
	/**
	 * 获取专家的简单信息(不含intro)
	 * 
	 * @param param
	 * @return Expert
	 *
	 */
	public Expert getSimple(Expert param);

	public List<Expert> getGuestExpertStatus(Expert param);

	public List<Map<String,Integer>> countAllExpertByArea();

}