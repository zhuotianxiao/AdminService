package cn.fundview.modules.util;

import cn.fundview.common.config.Global;

/**
 * 常量类   
 *    
 * 项目名称：AdminService   
 * 类名称：Constants   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月7日 上午8:46:30   
 * 修改人：lict    
 * 修改时间：2015年9月7日 上午8:46:30   
 * 修改备注：   
 * @version    
 *
 */
public class Constants {
	
	//缓存key
	public static final String CACHE_EXPERT_LIST = "expertList";
	
	//缓存key
	public static final String CACHE_KYORG_LIST = "kyOrgList";
	
	public static final String CACHE_ACHV_LIST = "achvList"; //成果
	
	public static final String CACHE_ACHV_JOIN_LIST = "achvJoinList"; //成果对接


    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final int ADMIN_DEFAULT_PAGE_SIZE = 10;

    public static final String ADMIN_SESSION = "admin_session";

    public static final String USER_SESSION = "user_session";

    public static final String TEMP_UPLOAD_PATH = "/temp";// 临时上传图片地址

    public static final String STATIC_PATH = Global.getConfig("static.domain");// 相对静态项目路径"/static"
    // 改成静态域名

    public static final String AUTO_LOGIN_KEY = "FENGJINGAUTOLOGIN";// 用户自动登录key

    // 用户默认头像
    public static final String USER_DEFAULT_IOGO = Constants.STATIC_PATH
            + "/lib/img/user-logo.png";
    // 企业默认头像
    public static final String COMPAY_DEFAULT_LOGO = Constants.STATIC_PATH
            + "/lib/img/company-logo.png";
    // 成果默认图片
    public static final String ACHV_DEFAULT_LOGO = Constants.STATIC_PATH
            + "/lib/img/achv-default.jpg";
    // 活动默认图片
    public static final String EXHIBITION_DEFAULT_LOGO = Constants.STATIC_PATH
            + "/front-page/uploads/exhibition-default.png";
    /**
     *
     *  总体比例0.75 左右   375 / 500

     企业, 机构  104 * 78(首页),  160 * 120(搜索页和详细页) ,  70* 52 (右侧)
     专家  104 * 78(栏目页顶部) ,  160* 120(搜索页和详细页),   70* 52 (右侧),  125 * 90(首页和栏目页下面)
     课题与成果 104 * 78(首页) ,  160 * 120 (搜索页和详细页),  330* 248 (幻灯片), 		 230 * 172(成果详细右侧)

     LOGO 在生产缩略图时 统一扩大了到1.3倍.
     成果课题在生产缩略图时 由于图片太大,所以不需要放大.
     *
     *
     */
    // *********************************企业
    // 企业logo 原路径
    public static final String COMP_LOGO_ORI_PATH = "/upload/comp/logo/";//

    // 企业logo 缩略图路径 104 * 78 , 80 * 60 , 156 * 117
    public static final String COMP_LOGO_THUMP_PATH = "/thumb/comp/logo/";//

    // 企业 营业执照 原路径
    public static final String COMP_LICENCE_ORI_PATH = "/upload/comp/licence/";//

    // 企业 营业执照 缩略图路径 156 * 117
    public static final String COMP_LICENCE_THUMP_PATH = "/thumb/comp/licence/";//

    // *********************************专家
    // 专家logo 原路径
    public static final String EXPERT_LOGO_ORI_PATH = "/upload/expert/logo/";//

    // 专家logo 缩略图路径 大小: 64*64 80*60 104 * 78 , 156 * 117
    public static final String EXPERT_LOGO_THUMP_PATH = "/thumb/expert/logo/";//

    // *********************************新闻
    // 新闻logo 原路径
    public static final String NEWS_LOGO_ORI_PATH = "/upload/news/logo/";//

    // 新闻logo 缩略图路径 大小: 64*64 80*60 104 * 78 , 156 * 117
    public static final String NEWS_LOGO_THUMP_PATH = "/thumb/news/logo/";//

    // *********************************成果图片
    // 成果 原路径
    public static final String ACHV_ORI_PATH = "/upload/achv/img/";//

    // 成果 缩略图路径 104*78 , 幻灯片: 320 * 225 小图 60 * 45

    public static final String ACHV_THUMP_PATH = "/thumb/achv/img/";//

    // *********************************服务机构图片
    // 服务机构 原路径
    public static final String SERVICE_ORG_ORI_PATH = "/upload/serviceorg/logo/";//

    // 服务机构 缩略图路径 104 * 78
    public static final String SERVICE_ORG_THUMP_PATH = "/thumb/serviceorg/logo/";//


    // *********************************资金申请 图片及文件
    // 资金图片和文件 原路径
    public static final String CAPITAL_ORI_PATH = "/upload/capital/";//

    // 资金图片 压缩图片
    public static final String CAPITAL_ORI_THUMP_PATH = "/thumb/capital/";//

    // *********************************金融 机构图片
    // 金融机构 原路径
    public static final String FINANCE_ORG_PATH = "/upload/financeorg/logo/";//

    // 金融机构 营业执照 原路径
    public static final String FINANCE_LICENCE_ORI_PATH = "/upload/finance/licence/";//

    // 金融机构 营业执照 缩略图路径 156 * 117
    public static final String FINANCE_LICENCE_THUMP_PATH = "/thumb/finance/licence/";//

    // 金融机构 缩略图路径 104 * 78 , 156 * 117
    public static final String FINANCE_ORG_THUMP_PATH = "/thumb/financeorg/logo/";//

    // *********************************政府机构图片
    // 金融机构 原路径
    public static final String GOV_ORG_PATH = "/upload/gov/logo/";//

    // 金融机构 缩略图路径
    public static final String GOV_ORG_THUMP_PATH = "/thumb/gov/logo/";//

    // *********************************在线会展
    // 在线会展 原路径   135, 70
    public static final String EXHIBITION_PATH = "/upload/exhibition/";//

    // 在线会展 缩略图路径
    public static final String EXHIBITION_THUMP_PATH = "/thumb/exhibition/";//


    // *********************************科研 机构图片
    // 科研机构 原路径
    public static final String KY_ORG_PATH = "/upload/kyorg/logo/";//

    // 科研机构 缩略图路径 104 * 78 , 156 * 117
    public static final String KY_ORG_THUMP_PATH = "/thumb/kyorg/logo/";//


    // ********************************存储短信验证码的key
    public static final String SMS = "sms";

    // ********************************验证短信的发送时间key
    public static final String SMS_TIME = "sms_time";

    // ********************************企业注册验证短信内容
    public static final String COMP_VALID_SMS_CONTNET = "丰景网验证码:";

    //邮箱验证码 key
    public static final String EMAIL_CHECKED_CODE  = "email_checked_code";
    public static final String EMAIL_NAME = "email_name";
    /**企业财务报表数据的存放路径**/
    public static final String LOAN_COMP_FIN_REPORT = "/loan/";
    public static final String LOAN_COMP_FIN_REPORT_LOCAL = "/upload/loan/";//源文件的本地存放路径
    /**企业财务报表数据的存放路径用户资金需求**/
    public static final String FUND_COMP_FIN_REPORT = "/fund/";
    public static final String FUND_COMP_FIN_REPORT_LOCAL = "/upload/fund/";//源文件的本地存放路径

    // 企业 借款人 资料 目录
    //   借款人 资料原路径
    public static final String COMP_LOAN_ORI_PATH = "/upload/comp/loan/";//

    //  借款人 资料 静态项目中目录
    public static final String COMP_LOAN_THUMP_PATH = "/thumb/comp/loan/";//

    //   贷款企业的认证扫描件 原图
    public static final String COMP_LOAN_ORI_AUTH_SCAN = "/upload/comp/loan/auth/";//

    //  贷款企业的认证扫描件 静态项目中的目录
    public static final String COMP_LOAN_THUMB_AUTH_SCAN = "/thumb/comp/loan/auth/";//


    //成果专利扫描件
    public static final String ACHV_ZL_ORI_PATH = "/upload/achv/zl/img/";
    public static final String ACHV_ZL_THUMB_PATH = "/thumb/achv/zl/img/";
    //课题专利扫描件
    public static final String KT_ZL_ORI_PATH = "/upload/kt/zl/img/";
    public static final String KT_ZL_THUMB_PATH = "/thumb/kt/zl/img/";
    //课题图片
    public static final String KT_ORI_PATH = "/upload/expert/kt/img/";
    public static final String KT_THUMB_PATH = "/thumb/expert/kt/img/";

    //微信素材目录
    public static final String WX_ORI_PATH = "/upload/wx/img/";
    public static final String WX_THUMB_PATH = "/thumb/wx/img/";

    //资金需求 专利材料
    public static final String FUND_PATENT_ORI_PATH = "/upload/fund/patent/";
    public static final String FUND_PATENT_THUMB_PATH = "/thumb/fund/patent/";


    /************************************************************/
    public static final String CONSULTATION_LOGO_SRC_PATH = "/upload/consultation_logo/";// 咨询上传原Logo地址
    public static final String CONSULTATION_LOGO_THUMB_PATH = "/thumb/consultation_logo/";// 咨询上传Logo缩略图地址

    public static final String CONSULTATION_IMG_SRC_PATH = "/upload/consultation_img/";// 咨询上传原图片地址
    public static final String CONSULTATION_IMG_THUMB_PATH = "/thumb/consultation_img/";// 咨询上传缩略图地址

    public static final int CONSULTATION_LOGO_WIDTH = 426;
    public static final int CONSULTATION_LOGO_HEIGHT = 240;
    public static final String CONSULTATION_LOGO_THUMBSIZE = "_" + CONSULTATION_LOGO_WIDTH + "_" + CONSULTATION_LOGO_HEIGHT + ".";

    public static final int CONSULTATION_IMG_WIDTH = 426;
    public static final int CONSULTATION_IMG_HEIGHT = 240;
    public static final String CONSULTATION_IMG_THUMBSIZE = "_" + CONSULTATION_IMG_WIDTH + "_" + CONSULTATION_IMG_HEIGHT + ".";

    //专家提交的咨询服务分析总结报告的存储路径/upload/consultation/11/name;  11是咨询id,name 是指定的生成的文件名
    public static final String CONSULTATION_SERVICE_REPORT_PATH = "/upload/consultation/";
    public static final String CONSULTATION_SERVICE_REPORT_STATIC_PATH = "/thumb/consultation";
}
