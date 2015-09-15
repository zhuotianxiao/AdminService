/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.fundview.common.filter;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;
import cn.fundview.common.utils.CacheUtils;

/**
 * 页面高速缓存过滤器
 * @author wangjian
 * @version 2013-8-5
 */
public class PageCachingFilter extends SimplePageCachingFilter {

	@Override
	protected CacheManager getCacheManager() {
		return CacheUtils.getCacheManager();
	}
	
}