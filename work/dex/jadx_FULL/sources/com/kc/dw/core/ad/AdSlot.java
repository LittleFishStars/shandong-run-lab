package com.kc.dw.core.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface AdSlot {
    String getAppName();

    String getApp_feature();

    String getApp_intro();

    String getApp_privacy();

    String getApp_size();

    String getApp_ver();

    String[] getClickUrl();

    String getClickid();

    String getDeep_link();

    String getDeveloper();

    int getDirect_market();

    String[] getDn_active();

    String[] getDn_inst_start();

    String[] getDn_inst_succ();

    String[] getDn_start();

    String[] getDn_succ();

    String getDpSign();

    String[] getDp_fail();

    String[] getDp_start();

    String[] getDp_succ();

    String[] getErrorUrl();

    String getIcon();

    int getInteractionType();

    String[] getMonitorUrl();

    String getPackageName();

    String getPayment_types();

    String getPrivacy_agreement();

    float getScore();

    String[] getWx_fail();

    String getWx_path();

    String[] getWx_start();

    String[] getWx_succ();

    String getWx_username();

    String[] getdUrl();

    void setDp_start(String[] strArr);

    void setImageUrls(String[] strArr);

    void setdUrl(String[] strArr);
}
