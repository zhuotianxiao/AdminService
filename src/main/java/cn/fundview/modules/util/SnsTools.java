package cn.fundview.modules.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.shcm.bean.BalanceResultBean;
import com.shcm.bean.SendResultBean;
import com.shcm.send.DataApi;
import com.shcm.send.OpenApi;

/**
 * @author Chinafish
 * 
 */
public class SnsTools {

	private final Logger logger = Logger.getLogger(SnsTools.class);

	private static String sOpenUrl = "http://smsapi.c123.cn/OpenPlatform/OpenApi";
	private static String sDataUrl = "http://smsapi.c123.cn/DataPlatform/DataApi";

	// 接口帐号
	private static final String account = "1001@500903510001";

	// 接口密钥
	private static final String authkey = "0291E918BD17FCFFC6F75B8007338330";

	// 通道组编号
	private static final int cgid = 1201;

	// 默认使用的签名编号(未指定签名编号时传此值到服务器)
	private static final int csid = 0;

	private static List<SendResultBean> sendOnce(String mobile, String content)
			throws Exception {
		// 发送短信
		return OpenApi.sendOnce(mobile, content, 0, 0, null);
	}

	/**
	 * 封装发送短信
	 * 
	 * @param mobile
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public boolean sendMsg(String mobile, String content) throws Exception {
		// 发送参数
		OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);

		// 状态及回复参数
		DataApi.initialzeAccount(sDataUrl, account, authkey);

		// 取帐户余额
		BalanceResultBean br = OpenApi.getBalance();
		if (br == null) {
			logger.error("获取可用余额时发生异常!");
			return false;
		}

		if (br.getResult() < 1) {
			logger.error("获取可用余额失败: " + br.getErrMsg());
			return false;
		}
		logger.error("可用条数: " + br.getRemain());

		List<SendResultBean> listItem = sendOnce(mobile, content);
		if (listItem != null) {
			for (SendResultBean t : listItem) {
				if (t.getResult() < 1) {
					logger.error("发送提交失败: " + t.getErrMsg());
					return false;
				}

				logger.info("发送成功: 消息编号<" + t.getMsgId() + "> 总数<"
						+ t.getTotal() + "> 余额<" + t.getRemain() + ">");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// 发送参数
		OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);

		// 状态及回复参数
		DataApi.initialzeAccount(sDataUrl, account, authkey);

		// 取帐户余额
		BalanceResultBean br = OpenApi.getBalance();
		if (br == null) {
			System.out.println("获取可用余额时发生异常!");
			return;
		}

		if (br.getResult() < 1) {
			System.out.println("获取可用余额失败: " + br.getErrMsg());
			return;
		}
		System.out.println("可用条数: " + br.getRemain());

		/*
		 * // 更新接口密钥 UpdateResultBean ur = OpenApi.updateKey();
		 * if(ur.getResult() < 1) { System.out.println("更新接口密钥失败: " +
		 * br.getErrMsg()); return; } System.out.println("已成功更新密钥,新接口密钥为: " +
		 * ur.getAuthKey());
		 */

		List<SendResultBean> listItem = sendOnce("15966635671", "Java接口测试内容");
		if (listItem != null) {
			for (SendResultBean t : listItem) {
				if (t.getResult() < 1) {
					System.out.println("发送提交失败: " + t.getErrMsg());
					return;
				}

				System.out.println("发送成功: 消息编号<" + t.getMsgId() + "> 总数<"
						+ t.getTotal() + "> 余额<" + t.getRemain() + ">");
			}
		}

		/*
		 * // 循环获取状态报告和回复 while(true) { List<SendStateBean> listSendState =
		 * DataApi.getSendState(); if(listSendState != null) { for(SendStateBean
		 * t:listSendState) { System.out.println("状态报告 => 序号<" + t.getId() + ">
		 * 消息编号<" + t.getMsgId() + "> 手机号码<" + t.getMobile() + "> 结果<" +
		 * (t.getStatus() > 1 ? "发送成功" : t.getStatus() > 0 ? "发送失败" : "未知状态") + ">
		 * 运营商返回<" + t.getDetail() + ">"); } } // 取回复 List<ReplyBean>
		 * listReply = DataApi.getReply(); if(listReply != null) { for(ReplyBean
		 * t:listReply) { System.out.println("回复信息 => 序号<" + t.getId() + ">
		 * 消息编号<" + t.getMsgId() + "> 回复时间<" + t.getReplyTime() + "> 手机号码<" +
		 * t.getMobile() + "> 回复内容<" + t.getContent() + ">"); } }
		 * Thread.sleep(6000); }
		 */
	}
}
