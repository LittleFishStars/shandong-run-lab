package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITriverAppMonitorProxy extends Proxiable {
    void commitMajorAPIAlarm(boolean z, App app, String str, String str2, String str3, JSONObject jSONObject);

    void commitTRiverPreloadPerf(TriverLaunchPointer triverLaunchPointer, String str, boolean z, long j, int i);

    void commitTriverComponent(TriverLaunchPointer triverLaunchPointer, String str, String str2);

    void commitTriverDownLoadResource(AppModel appModel, String str, String str2, boolean z, boolean z2, boolean z3);

    void commitTriverJSAPI(TriverLaunchPointer triverLaunchPointer, String str, Double d, String str2);

    void commitTriverLaunch(TriverLaunchPointer triverLaunchPointer);

    void commitTriverLaunch(TriverLaunchPointer triverLaunchPointer, String str);

    void commitTriverPageLaunch(TriverLaunchPointer triverLaunchPointer);

    void commitTriverPerf(TriverLaunchPointer triverLaunchPointer);

    void commitTriverPerf(TriverLaunchPointer triverLaunchPointer, double d);

    void commitTriverPluginResourceCache(PluginModel pluginModel, String str, String str2, boolean z, boolean z2, boolean z3);

    void commitTriverResourceCache(AppModel appModel, String str, String str2, boolean z, boolean z2, boolean z3);

    void commitTriverShopPerf(TriverLaunchPointer triverLaunchPointer, String str, String str2, String str3, double d);

    void trackAlarm(boolean z, String str, String str2, String str3, String str4, String str5);

    void trackCounter(String str, String str2, int i, String str3);

    void trackStat(String str, TriverLaunchPointer triverLaunchPointer);

    void trackStat(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
}
