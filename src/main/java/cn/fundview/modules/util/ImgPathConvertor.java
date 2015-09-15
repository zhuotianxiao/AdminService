package cn.fundview.modules.util;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 图片路径转换工具类
 */
public final class ImgPathConvertor {

    /**
     * 企业前台展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontCompLogoThumbFile(String srcFile, int w, int h) {
        String url = null;

        if (StringUtils.isNotBlank(srcFile)) {
            return Constants.STATIC_PATH
                    + srcFile.replace(Constants.COMP_LOGO_ORI_PATH,
                    Constants.COMP_LOGO_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.COMPAY_DEFAULT_LOGO;
        }
        return url;
    }


    /**
     * 专家前台展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontExpertLogoThumbFile(String srcFile, int w,
                                                     int h) {
        String url = null;

        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.EXPERT_LOGO_ORI_PATH,
                    Constants.EXPERT_LOGO_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.USER_DEFAULT_IOGO;
        }
        return url;
    }

    /**
     * 成果展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontAchvThumbFile(String srcFile, int w, int h) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.ACHV_ORI_PATH,
                    Constants.ACHV_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.ACHV_DEFAULT_LOGO;
        }
        return url;
    }

    /**
     * 成果专利展示图片路径转换
     *
     * @param srcFile
     * @return
     */
    public static String getFrontAchvZlThumbFile(String srcFile) {

        String url = null;
        System.out.println(srcFile);
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH + srcFile.replace(Constants.ACHV_ZL_ORI_PATH, Constants.ACHV_ZL_THUMB_PATH);
        }
        if (StringUtils.isBlank(url)) {
            url = "";
        }
        return url;

    }

    /**
     * 课题专利展示图片路径转换
     *
     * @param srcFile
     * @return
     */
    public static String getFrontKtZlThumbFile(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.KT_ZL_ORI_PATH,
                    Constants.KT_ZL_THUMB_PATH);
        }
        if (StringUtils.isBlank(url)) {
            url = "";
        }
        return url;

    }

    /**
     * 资金需求专利图片路径转换
     *
     * @param srcFile
     * @return
     */
    public static String getFundPatentThumbFile(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.FUND_PATENT_ORI_PATH,
                    Constants.FUND_PATENT_THUMB_PATH);
        }
        if (StringUtils.isBlank(url)) {
            url = "";
        }
        return url;

    }

    /**
     * 课题展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontKtThumbFile(String srcFile, int w, int h) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.KT_ORI_PATH,
                    Constants.KT_THUMB_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.ACHV_DEFAULT_LOGO;
        }
        return url;

    }


    /**
     * 新闻 展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontNewsThumbFile(String srcFile, int w,
                                               int h) {
        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.NEWS_LOGO_ORI_PATH,
                    Constants.NEWS_LOGO_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.COMPAY_DEFAULT_LOGO;
        }
        return url;
    }


    /**
     * 资金申请 展示图片路径转换
     *
     * @param srcFile
     * @return
     */
    public static String getFrontCapitalThumbFile(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.CAPITAL_ORI_PATH,
                    Constants.CAPITAL_ORI_THUMP_PATH);
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.ACHV_DEFAULT_LOGO;
        }
        return url;

    }

    /**
     * 企业借款 资料 展示图片路径转换
     *
     * @param srcFile
     * @return
     */
    public static String getFrontLoanThumbFile(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.COMP_LOAN_ORI_PATH,
                    Constants.COMP_LOAN_THUMP_PATH);
        }
        return url;

    }

    /**
     * 企业借款 认证扫描件
     *
     * @param srcFile
     * @return
     */
    public static String getLoanCompAuthImgThumb(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.COMP_LOAN_ORI_AUTH_SCAN,
                    Constants.COMP_LOAN_THUMB_AUTH_SCAN);
        }
        return url;

    }

    /**
     * 新闻
     *
     * @param srcFile
     * @return
     */
    public static String getLoanNewImgThumb(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.NEWS_LOGO_ORI_PATH,
                    Constants.NEWS_LOGO_THUMP_PATH);
        }
        return url;

    }

    /**
     * 素材
     *
     * @param srcFile
     * @return
     */
    public static String getLoanWxFodderThumb(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.WX_ORI_PATH,
                    Constants.WX_THUMB_PATH);
        }
        return url;

    }

    /**
     * 金融机构执业执照
     *
     * @param srcFile
     * @return
     */
    public static String getFinanceLicenceThumb(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.FINANCE_LICENCE_ORI_PATH,
                    Constants.FINANCE_LICENCE_THUMP_PATH);
        }
        return url;

    }

    /**
     * 金融机构申请 展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontFinanceOrgThumbFile(String srcFile, int w,
                                                     int h) {
        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.FINANCE_ORG_PATH,
                    Constants.FINANCE_ORG_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.COMPAY_DEFAULT_LOGO;
        }
        return url;
    }

    /**
     * 企业营业执照
     *
     * @param srcFile
     * @return
     */
    public static String getFrontCompLicenceThumbFile(String srcFile) {

        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.COMP_LICENCE_ORI_PATH,
                    Constants.COMP_LICENCE_THUMP_PATH);
        }
        return url;

    }

    /**
     * 会展活动 展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontExhibitionOrgThumbFile(String srcFile, int w,
                                                        int h) {
        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.EXHIBITION_PATH,
                    Constants.EXHIBITION_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.EXHIBITION_DEFAULT_LOGO;
        }
        return url;
    }

    /**
     * 科研机构 展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontKyOrgLogoThumbFile(String srcFile, int w,
                                                    int h) {
        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.KY_ORG_PATH,
                    Constants.KY_ORG_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.COMPAY_DEFAULT_LOGO;
        }
        return url;
    }

    /**
     * 政府 展示图片路径转换
     *
     * @param srcFile
     * @param w
     * @param h
     * @return
     */
    public static String getFrontGovLogoThumbFile(String srcFile, int w,
                                                  int h) {
        String url = null;
        if (StringUtils.isNotBlank(srcFile)) {
            url = Constants.STATIC_PATH
                    + srcFile.replace(Constants.GOV_ORG_PATH,
                    Constants.GOV_ORG_THUMP_PATH).replace(".",
                    "_" + w + "_" + h + ".");
        }
        if (StringUtils.isBlank(url)) {
            url = Constants.COMPAY_DEFAULT_LOGO;
        }
        return url;
    }

    /**
     * 检查是否包含 该ID , true 已关注, false 未关注
     *
     * @param list
     * @param id
     * @return
     */
    public static boolean checkIsInclude(List<Integer> list, Integer id) {

        if (list != null) {
            return list.contains(id);
        }
        return false;
    }

    /**
     * 咨询Logo
     *
     * @param srcFilePath
     * @param w
     * @param h
     * @return
     */
    public static String getConsultationLogoThumbFile(String srcFilePath, int w, int h) {
        if (StringUtils.isNotBlank(srcFilePath)) {
            return Constants.STATIC_PATH
                    + srcFilePath.replace(Constants.CONSULTATION_LOGO_SRC_PATH,
                    Constants.CONSULTATION_LOGO_THUMB_PATH).replace(".", "_" + w + "_" + h + ".");

        }
        return null;
    }

    public static String getConsultationImgThumbFile(String srcFilePath, int w, int h) {
        if (StringUtils.isNotBlank(srcFilePath)) {
            return Constants.STATIC_PATH
                    + srcFilePath.replace(Constants.CONSULTATION_IMG_SRC_PATH,
                    Constants.CONSULTATION_IMG_THUMB_PATH).replace(".", "_" + w + "_" + h + ".");

        }
        return null;
    }


    /**
     * 资讯logo
     *
     * @param srcFilePath
     * @return String
     */
    public static String showConsultationLogoThumbFile(String srcFilePath) {
        return getConsultationLogoThumbFile(srcFilePath, Constants.CONSULTATION_LOGO_WIDTH, Constants.CONSULTATION_LOGO_HEIGHT);
    }

    /**
     * 资讯图片
     *
     * @param srcFilePath
     * @return String
     */
    public static String showConsultationImgThumbFile(String srcFilePath) {
        return getConsultationImgThumbFile(srcFilePath, Constants.CONSULTATION_IMG_WIDTH, Constants.CONSULTATION_IMG_HEIGHT);
    }

    public static String getConsultationPdfPath(String uploadPath) {

        String url = null;
        if (StringUtils.isNotBlank(uploadPath)) {
            url = Constants.STATIC_PATH
                    + uploadPath.replace(Constants.CONSULTATION_SERVICE_REPORT_PATH,
                    Constants.CONSULTATION_SERVICE_REPORT_STATIC_PATH);
        }
        return url;
    }
}
