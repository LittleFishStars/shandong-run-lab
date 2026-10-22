package com.alibaba.ariver.mtop.monitor;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TRVMonitor extends Proxiable {
    void trackAlarm(boolean z, String str, String str2, String str3, String str4, String str5);

    void trackCounter(String str, String str2, int i, String str3);

    void trackStat(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);
}
