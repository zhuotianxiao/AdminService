package cn.fundview.modules.dao;

import cn.fundview.common.persistence.annotation.MyBatisDao;
import cn.fundview.modules.model.Company;
import cn.fundview.modules.model.Expert;

import java.util.List;
import java.util.Map;

/**
 * 平台企业Dao
 */
@MyBatisDao
public interface CompanyMapper {
    /**
     * 查询全部列表
     *
     * @return ExpertItem
     *
     */
    public List<Company> getList();

    /**
     * 获取企业的简单信息(不含intro)
     *
     * @param param
     * @return Expert
     *
     */
    public Company getSimple(Company param);


    /**
     * 获取企业的详细信息()
     *
     * @param param
     * @return Expert
     *
     */
    public Company get(Company param);

    /**
     * 有选择的更新 企业信息
     * @param company
     */
    public void updateByPrimaryKeySelective(Company company);

    /**
     * 查询等待认证审核的企业列表
     * @return
     */
    public List<Company> getUnCheckCompList(Company param);

    /**
     * 根据地区统计企业数
     * @return
     */
    public List<Map<String,Integer>> countAllCompByArea();
}