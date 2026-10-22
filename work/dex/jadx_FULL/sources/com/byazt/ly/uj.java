package com.byazt.ly;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.yf.yp;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface uj extends tt {
    void checkVersion();

    void clearInitStatus();

    String getAdapterVersion();

    String getBiddingToken(Context context, Map<String, Object> map);

    Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map);

    String getNetworkSdkPluginVersion();

    String getNetworkSdkVersion();

    long initDuration();

    int initStatus();

    void setPrivacyConfig(yp ypVar, SparseArray<Object> sparseArray);

    void setThemeStatus(Map<String, Object> map);

    int showOpenOrInstallAppDialog(com.byazt.yf.ve veVar);
}
