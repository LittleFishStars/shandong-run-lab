package com.alibaba.baichuan.trade.common.ut;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AlibcBaseUserTracker {
    public boolean init() {
        return false;
    }

    public abstract boolean keyPointHit();

    public abstract boolean normalPointHit();

    public void sendCustomHit(String str, String str2, long j, Map<String, String> map) {
    }

    public void sendCustomHit(String str, String str2, String str3, long j, Map<String, String> map) {
    }

    public void sendCustomHit(String str, String str2, Map<String, String> map) {
    }

    public void sendInitHit4DAU(String str, String str2) {
    }

    public void setChannel(String str) {
    }

    public abstract void setMonitorSampling(int i);

    public abstract void setSampling(int i);

    public void trackAlarm(boolean z, String str, String str2, String str3, JSONObject jSONObject) {
    }

    public void trackCounter(String str, int i, JSONObject jSONObject) {
    }

    public void trackStat(String str, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public void turnOffDebug() {
    }

    public void turnOnDebug() {
    }
}
