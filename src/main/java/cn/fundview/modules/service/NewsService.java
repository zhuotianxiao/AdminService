package cn.fundview.modules.service;

import cn.fundview.modules.dao.NewsMapper;
import cn.fundview.modules.model.News;
import cn.fundview.setting.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 后台管理新闻服务类
 * Created by 健 on 2015/9/11.
 */
@Service
@Transactional(value = "transactionManager2")
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> findAll(){
        return newsMapper.selectAll();
    }

    public News get(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    public void save(News news) {
        news.setPublishDate(new Date());
        news.setPublisherId(UserUtils.getUser().getId());
        newsMapper.insertSelective(news);
    }

    public void delete(News news) {
        newsMapper.deleteByPrimaryKey(news.getId());
    }
}
