package cn.fundview.modules.service;

import cn.fundview.common.service.CrudService;
import cn.fundview.modules.dao.AccountMapper;
import cn.fundview.modules.dao.ExpertConsulationMapper;
import cn.fundview.modules.dao.ExpertMapper;
import cn.fundview.modules.dao.TcDictMapper;
import cn.fundview.modules.model.Account;
import cn.fundview.modules.model.Expert;
import cn.fundview.modules.model.ExpertConsulation;
import cn.fundview.modules.util.Constants;
import cn.fundview.setting.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value = "expertService")
@Transactional(value="transactionManager2",readOnly = true)
public class ExpertService extends CrudService<ExpertMapper, Expert> {

	@Resource(name = "accountMapper")
	private AccountMapper accountMapper;

	@Resource(name = "tcDictMapper")
	private TcDictMapper tcDictMapper;

	@Resource(name = "expertConsulationMapper")
	private ExpertConsulationMapper consultationMapper;

	public List<Expert> listAll() {
		// TODO Auto-generated method stub

		// 从缓存拿 (session 缓存)
		@SuppressWarnings("unchecked")
		List<Expert> list = null;// (List<ExpertItem>)
										// UserUtils.getCache(Constants.CACHE_EXPERT_LIST);
		if (list == null) {

			// 从数据库拿
			list = dao.findAllListItem();
			// 写缓存
//			UserUtils.putCache(Constants.CACHE_EXPERT_LIST, list);
		}
		return list;
	}

	@Transactional(value="transactionManager2",readOnly = false)
	public boolean validExpert(String id, boolean flag) {
		// TODO Auto-generated method stub

		Account account = new Account();
		account.setId(id);
		account.setValid(flag);
		accountMapper.valid(account);

		// 更新专家
		Expert expert = new Expert();
		expert.setId(id + "");
		expert.setUpdateDate(new Date());
		expert.setValid(flag ? 1 : 0);
		dao.update(expert);
		// 更新缓存
		// List<ExpertItem> list = dao.findAllListItem();
		// UserUtils.putCache(Constants.CACHE_EXPERT_LIST,list);
		return true;
	}

	public Expert get(String id) {

		Expert param = new Expert();
		param.setId(id);
		return dao.getSimple(param);
	}

	/**
	 * 更新专家认证信息,包括专家账户
	 * 
	 * @param param
	 * @return boolean
	 * 
	 */

	@Transactional(value="transactionManager2",readOnly = false)
	public boolean updateExpert(Expert param) {

		dao.update(param);// 更新专家手机号和name
		if (param.getAccount() != null) {
			param.getAccount().setId(param.getId());
			accountMapper.update(param.getAccount());
		}
		return true;
	}


	/**
	 * 查询指定专家的咨询服务产品
	 * @param param
	 * @return
	 */
	public ExpertConsulation getConsultation(ExpertConsulation param) {

		 return consultationMapper.selectByPrimaryKey(param);
	}


	/**
	 * 查询待审核的咨询专家
	 * @return
	 */
	public List<Expert> getGuestExpertStatus(Expert param){

		return dao.getGuestExpertStatus(param);
	}

	public List<Map<String,Integer>> countAllExpertByArea() {

		return dao.countAllExpertByArea();
	}
}
