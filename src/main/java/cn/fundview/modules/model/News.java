package cn.fundview.modules.model;

import java.util.Date;

/**
 * 项目名称：AdminService
 * 类描述：新闻实体模型
 * 创建人：wangjian
 * 创建时间：2015年9月11日
 * 修改人：wangjian
 * 修改时间：2015年9月11日
 * 修改备注：
 */
public class News {
    private Integer id;

    private String title;

    private String intro;

    private Date publishDate;

    private String publisherId;

    private Integer newsSort;

    private String imgUrl;

    private String source;

    private String tags;

    private Byte recommend;

    private Byte hot;

    private Byte latest;

    private Integer recommendNum;

    private Integer latestNum;

    private Integer hotNum;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getNewsSort() {
        return newsSort;
    }

    public void setNewsSort(Integer newsSort) {
        this.newsSort = newsSort;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Byte getRecommend() {
        return recommend;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    public Byte getHot() {
        return hot;
    }

    public void setHot(Byte hot) {
        this.hot = hot;
    }

    public Byte getLatest() {
        return latest;
    }

    public void setLatest(Byte latest) {
        this.latest = latest;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getLatestNum() {
        return latestNum;
    }

    public void setLatestNum(Integer latestNum) {
        this.latestNum = latestNum;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}