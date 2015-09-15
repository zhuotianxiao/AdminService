/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.setting.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.fundview.common.utils.CacheUtils;
import cn.fundview.common.utils.SpringContextHolder;
import cn.fundview.modules.dao.TcDictMapper;
import cn.fundview.modules.model.TcDict;
import cn.fundview.setting.dao.DictDao;
import cn.fundview.setting.model.Dict;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 字典工具类
 * @author wangjian
 * @version 2013-5-29
 */
public class DictUtils {
	
	private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
	private static TcDictMapper tcDictMapper = SpringContextHolder.getBean(TcDictMapper.class);//平台字典库

	public static final String CACHE_DICT_MAP = "dictMap";
	public static final String CACHE_TCDICT_MAP = "tcDictMap";
	/**
	 * 单
	 * @param key
	 * @param type
	 * @param defaultValue
	 * @return
	 */
	public static String getTcDictLabel(String key, String type, String defaultValue){
		if (StringUtils.isNotBlank(type)){
			
			TcDict param = new TcDict();
			param.setDictKey(key);
			param.setDictType(type);
			List<TcDict> result = tcDictMapper.getTcDictsByTypeAndKey(param);
			if(result == null || result.size() == 0){
				
				return defaultValue;
			}else {
				
				StringBuilder sbs = new StringBuilder();
				for (TcDict dict : result){
					
					sbs.append(dict.getDictValue()).append("、");
				}
				if(sbs.length() > 0) {
					
					sbs.deleteCharAt(sbs.length()-1);
				}
				
				return sbs.toString();
			}
		}
		return defaultValue;
	}
	public static String getTcDictLabels(String keys, String type, String defaultValue){
		if (StringUtils.isNotBlank(type)&& StringUtils.isNotBlank(keys)){
			List<String> valueList = Lists.newArrayList();
			for (String key : StringUtils.split(keys, ",")) {
				valueList.add(getTcDictLabel(key, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	public static List<Dict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap==null){
			dictMap = Maps.newHashMap();
			for (Dict dict : dictDao.findAllList(new Dict())){
				List<Dict> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getType(), Lists.newArrayList(dict));
				}
			}
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<Dict> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
}
