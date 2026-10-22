package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdConfig {
    int getAgeGroup();

    String getAppId();

    String getAppName();

    TTCustomController getCustomController();

    String getData();

    int[] getDirectDownloadNetworkType();

    @Deprecated
    Object getExtra(String str);

    Map<String, Object> getInitExtra();

    String getKeywords();

    IMediationConfig getMediationConfig();

    int getPluginUpdateConfig();

    int getThemeStatus();

    int getTitleBarTheme();

    boolean isAllowShowNotify();

    boolean isDebug();

    boolean isPaid();

    boolean isSupportMultiProcess();

    boolean isUseMediation();
}
