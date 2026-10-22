package com.alibaba.triver.kit.api;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TinyApp {
    public static final String INTER_APP = "3";
    public static final String SUB_TYPE_BRAND_ZONE = "16";
    public static final String SUB_TYPE_LIGHT_SHOP = "13";
    public static final String SUB_TYPE_STORE = "14";
    public static final String TINY_APP = "1";
    public static final String TINY_CANAL = "10";
    public static final String TINY_SHOP = "2";
    public static final String TINY_TOOLS = "4";

    <T> void addData(Class<T> cls, T t);

    boolean backPressed();

    void exit();

    Page getActivePage();

    String getAppDesc();

    String getAppFrameType();

    String getAppId();

    String getAppKey();

    String getAppLogo();

    String getAppName();

    String getAppSubType();

    String getAppType();

    String getAppVersion();

    <T> T getData(Class<T> cls);

    int getPageCount();

    Bundle getSceneParams();

    Bundle getStartParams();

    long getStartToken();

    String getStartUrl();

    String getTemplateAppKey();

    String getTemplateId();

    @WorkerThread
    boolean hasAuth();

    boolean isEmbedApp();

    boolean isEmbedView();

    boolean isFavorEnable();

    boolean isSpecialFavor();

    boolean isWindmillApp();

    void openPage(String str, Bundle bundle);

    void pop(JSONObject jSONObject);

    void popToHome();

    void restart();

    void sendGlobalEvent(String str, JSONObject jSONObject);
}
