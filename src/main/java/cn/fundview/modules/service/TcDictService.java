package cn.fundview.modules.service;

import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.TcDictMapper;
import cn.fundview.modules.model.TcDict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 平台字段service 
 *    
 * 项目名称：AdminService   
 * 类名称：TcDictService   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月8日 下午2:43:57   
 * 修改人：lict    
 * 修改时间：2015年9月8日 下午2:43:57   
 * 修改备注：   
 * @version    
 *
 */
@Service
@Transactional(value="transactionManager2",readOnly = true)
public class TcDictService extends CrudService<TcDictMapper, TcDict> {
	
	public String getDictValue(String key, String type, String defaultVal) {
		
		TcDict param = new TcDict();
		param.setDictKey(key);
		param.setDictType(type);
		List<TcDict> result = dao.getTcDictsByTypeAndKey(param);
		if(result == null || result.size() == 0) {
			
			return defaultVal;
		}else {
			
			StringBuilder sbs = new StringBuilder();
			for(TcDict item : result) {
				
				sbs.append(item.getDictValue()).append("、");
			}
			if(sbs.length() > 0) {
				
				sbs.deleteCharAt(sbs.length()-1);
			}
			return sbs.toString();
		}
	}
}
