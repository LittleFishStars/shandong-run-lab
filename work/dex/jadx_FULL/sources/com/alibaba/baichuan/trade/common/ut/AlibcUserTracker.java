package com.alibaba.baichuan.trade.common.ut;

import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcUserTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24564a = "AlibcUserTracker";
    private static volatile AlibcUserTracker d;
    private boolean b;
    private AlibcBaseUserTracker c;

    private AlibcUserTracker() {
        if (a()) {
            this.c = new AppMonitorUserTracker();
        }
    }

    private static boolean a() {
        return true;
    }

    public static AlibcUserTracker getInstance() {
        if (d == null) {
            synchronized (AlibcUserTracker.class) {
                if (d == null) {
                    d = new AlibcUserTracker();
                }
            }
        }
        return d;
    }

    public synchronized AlibcUserTrackerResult init() {
        AlibcUserTrackerResult alibcUserTrackerResult = new AlibcUserTrackerResult();
        if (this.b) {
            return new AlibcUserTrackerResult(2);
        }
        if (AlibcSecurityGuard.getInstance().selfCheck()) {
            return new AlibcUserTrackerResult(1);
        }
        AlibcBaseUserTracker alibcBaseUserTracker = this.c;
        if (alibcBaseUserTracker != null && alibcBaseUserTracker.init()) {
            AlibcLogger.i(f24564a, "ut sdk init success");
            this.b = true;
            if (AlibcBaseTradeCommon.isDebug()) {
                this.c.turnOnDebug();
            }
            alibcUserTrackerResult = new AlibcUserTrackerResult(0);
        }
        return alibcUserTrackerResult;
    }

    public boolean keyPointHit() {
        if (this.b) {
            return this.c.keyPointHit();
        }
        return false;
    }

    public boolean normalPointHit() {
        if (this.b) {
            return this.c.normalPointHit();
        }
        return false;
    }

    public void sendCustomHit(String str, String str2, Map<String, String> map) {
        if (this.b) {
            this.c.sendCustomHit(str, str2, map);
        }
    }

    public void sendInitHit4DAU(String str, String str2) {
        if (this.b) {
            this.c.sendInitHit4DAU(str, str2);
        }
    }

    public void setMonitorSampling(int i) {
        if (this.b) {
            this.c.setMonitorSampling(i);
        }
    }

    public void setSampling(int i) {
        if (this.b) {
            this.c.setSampling(i);
        }
    }

    public void trackAlarm(boolean z, String str, String str2, String str3, JSONObject jSONObject) {
        if (this.b) {
            this.c.trackAlarm(z, str, str2, str3, jSONObject);
        }
    }

    public void trackCounter(String str, int i, JSONObject jSONObject) {
        if (this.b) {
            this.c.trackCounter(str, i, jSONObject);
        }
    }

    public void trackStat(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.b) {
            this.c.trackStat(str, jSONObject, jSONObject2);
        }
    }

    public void turnOffDebug() {
        if (this.b) {
            this.c.turnOffDebug();
        }
    }

    public void turnOnDebug() {
        if (this.b) {
            this.c.turnOnDebug();
        }
    }

    public static class AlibcUserTrackerResult {
        public static final int UT_INIT_AD = 2;
        public static final int UT_INIT_FAIL = 1;
        public static final int UT_INIT_SUCCESS = 0;
        public int errCode;
        public String errMsg;
        public int result;

        public AlibcUserTrackerResult() {
            this.result = 1;
        }

        public AlibcUserTrackerResult(int i) {
            this.result = i;
        }

        public AlibcUserTrackerResult(int i, int i2, String str) {
            this.result = i;
            this.errCode = i2;
            this.errMsg = str;
        }

        public AlibcUserTrackerResult(int i, String str) {
            this.result = 1;
            this.errCode = i;
            this.errMsg = str;
        }
    }
}
