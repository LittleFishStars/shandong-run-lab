package com.kc.dw.core.webview.jsbridge.bean;

import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.domain.SsdAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GetH5AdInfoResBean implements Serializable {
    private static final long serialVersionUID = 1;
    private AppInfoBean app_info;
    private String app_name;
    private String content;
    private int creative_type;
    private String from_logo;
    private String h5_ext;
    private String icon;
    private int reward_tmp_time;
    private String[] srcUrls;
    private int target_type;
    private String title;
    private String uuid;
    private String video_cover;

    @Keep
    public static class AppInfoBean implements Serializable {
        private static final long serialVersionUID = 1;
        private String app_intro;
        private String app_intro_url;
        private String app_name;
        private List<SsdAdInfo.PermissionBean> app_permission;
        private String app_permission_url;
        private String app_size;
        private String app_ver;
        private String developer;
        private String package_name;
        private String privacy_agreement;
    }

    public static GetH5AdInfoResBean make(AdSlot adSlot, String str) {
        GetH5AdInfoResBean getH5AdInfoResBean = new GetH5AdInfoResBean();
        if (adSlot instanceof BaseAdSlot) {
            BaseAdSlot baseAdSlot = (BaseAdSlot) adSlot;
            getH5AdInfoResBean.srcUrls = baseAdSlot.getImageUrls();
            getH5AdInfoResBean.video_cover = baseAdSlot.getVideo_cover();
            getH5AdInfoResBean.creative_type = baseAdSlot.getAdPatternType();
            getH5AdInfoResBean.target_type = baseAdSlot.getInteractionType();
            getH5AdInfoResBean.h5_ext = baseAdSlot.getH5Ext();
            getH5AdInfoResBean.uuid = baseAdSlot.getReq_id();
            getH5AdInfoResBean.app_name = str;
            getH5AdInfoResBean.title = baseAdSlot.getTitle();
            getH5AdInfoResBean.content = baseAdSlot.getDesc();
            getH5AdInfoResBean.icon = baseAdSlot.getIconUrl();
            getH5AdInfoResBean.app_info = makeAppInfoBean(baseAdSlot);
            getH5AdInfoResBean.reward_tmp_time = baseAdSlot.getReward_tmp_time();
            getH5AdInfoResBean.from_logo = baseAdSlot.getFromLogo();
        }
        return getH5AdInfoResBean;
    }

    private static AppInfoBean makeAppInfoBean(BaseAdSlot baseAdSlot) {
        AppInfoBean appInfoBean = new AppInfoBean();
        appInfoBean.app_name = baseAdSlot.getAppName();
        appInfoBean.app_intro = baseAdSlot.getApp_intro();
        appInfoBean.app_intro_url = baseAdSlot.getApp_intor_url();
        appInfoBean.app_ver = baseAdSlot.getApp_ver();
        appInfoBean.app_size = baseAdSlot.getApp_size();
        appInfoBean.app_permission = baseAdSlot.getApp_permission();
        appInfoBean.app_permission_url = baseAdSlot.getApp_permission_url();
        appInfoBean.privacy_agreement = baseAdSlot.getPrivacy_agreement();
        appInfoBean.developer = baseAdSlot.getDeveloper();
        appInfoBean.package_name = baseAdSlot.getPackageName();
        return appInfoBean;
    }
}
