package com.alibaba.baichuan.trade.common.ut;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.Dimension;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.IUTApplication;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.UTTracker;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.internal.UTTeamWork;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppMonitorUserTracker extends AlibcBaseUserTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24565a = "AppMonitorUserTracker";
    private boolean b = true;
    private String c = "default";
    private boolean d = true;
    private boolean e = true;

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public boolean init() {
        try {
            UTAnalytics.getInstance().setAppApplicationInstance(AlibcBaseTradeCommon.context, new IUTApplication() { // from class: com.alibaba.baichuan.trade.common.ut.AppMonitorUserTracker.1
                public final String getUTAppVersion() {
                    return "5.0.2.5";
                }

                public final String getUTChannel() {
                    return AppMonitorUserTracker.this.c;
                }

                public final IUTCrashCaughtListner getUTCrashCraughtListener() {
                    return null;
                }

                public final IUTRequestAuthentication getUTRequestAuthInstance() {
                    return new UTSecurityThridRequestAuthentication(AlibcBaseTradeCommon.getAppKey(), "baichuan");
                }

                public final boolean isAliyunOsSystem() {
                    return false;
                }

                public final boolean isUTCrashHandlerDisable() {
                    return false;
                }

                public final boolean isUTLogEnable() {
                    return AppMonitorUserTracker.this.b;
                }
            });
            UTAnalytics.getInstance().turnOffAutoPageTrack();
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker == null) {
                return true;
            }
            defaultTracker.setGlobalProperty("aliTradesdk", "5.0.2.5");
            return true;
        } catch (Throwable th) {
            AlibcLogger.e(f24565a, "init ut config exception: msg = " + th.getMessage());
            return false;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public boolean keyPointHit() {
        return this.d;
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public boolean normalPointHit() {
        return this.e;
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, Map<String, String> map) {
        sendCustomHit(str, str2, 60L, map);
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void sendInitHit4DAU(String str, String str2) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("80001");
        HashMap map = new HashMap(16);
        map.put(ze1.k, "trade");
        map.put("version", str2);
        uTCustomHitBuilder.setProperties(map);
        UTAnalytics.getInstance().getTracker(str).send(uTCustomHitBuilder.build());
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void setChannel(String str) {
        this.c = str;
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void setMonitorSampling(int i) {
        AppMonitor.setSampling(10000);
        AppMonitor.Stat.setSampling(10000);
        this.e = i >= new Random().nextInt(10000);
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void setSampling(int i) {
        this.d = i >= new Random().nextInt(10000);
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void trackAlarm(boolean z, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            jSONObject.put("aliTradesdk", "5.0.2.5");
            jSONObject.put(UserTrackConstant.SDK_TYPE, "ultimate");
            jSONObject.put("sdkVersion", "5.0.2.5");
            if (z) {
                AppMonitor.Alarm.commitSuccess("Alibc_UltimateSdk", str, jSONObject.toJSONString());
            } else {
                AppMonitor.Alarm.commitFail("Alibc_UltimateSdk", str, jSONObject.toJSONString(), str2, str3);
            }
        } catch (Throwable th) {
            AlibcLogger.e(f24565a, Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void trackCounter(String str, int i, JSONObject jSONObject) {
        try {
            jSONObject.put("aliTradesdk", "5.0.2.5");
            jSONObject.put(UserTrackConstant.SDK_TYPE, "ultimate");
            jSONObject.put("sdkVersion", "5.0.2.5");
            AppMonitor.Counter.commit("Alibc_UltimateSdk", str, jSONObject.toJSONString(), i);
        } catch (Throwable th) {
            AlibcLogger.e(f24565a, Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void trackStat(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                if (jSONObject.size() > 0 && jSONObject2 != null) {
                    jSONObject.put(UserTrackConstant.SDK_TYPE, "ultimate");
                    jSONObject.put("sdkVersion", "5.0.2.5");
                    DimensionSet dimensionSetCreate = DimensionSet.create();
                    DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
                    for (String str2 : jSONObject.keySet()) {
                        dimensionSetCreate.addDimension(new Dimension(str2));
                        dimensionValueSetCreate.setValue(str2, jSONObject.getString(str2));
                    }
                    MeasureSet measureSetCreate = MeasureSet.create();
                    MeasureValueSet measureValueSetCreate = MeasureValueSet.create();
                    for (String str3 : jSONObject2.keySet()) {
                        measureSetCreate.addMeasure(new Measure(str3));
                        measureValueSetCreate.setValue(str3, jSONObject2.getDoubleValue(str3));
                    }
                    AppMonitor.register("Alibc_UltimateSdk", str, measureSetCreate, dimensionSetCreate, true);
                    AppMonitor.Stat.commit("Alibc_UltimateSdk", str, dimensionValueSetCreate, measureValueSetCreate);
                }
            } catch (Throwable th) {
                AlibcLogger.e(f24565a, Log.getStackTraceString(th));
            }
        }
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void turnOffDebug() {
        this.b = false;
        AppMonitor.enableLog(false);
        UTTeamWork.getInstance().turnOffRealTimeDebug();
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void turnOnDebug() {
        this.b = true;
        AppMonitor.enableLog(true);
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, long j, Map<String, String> map) {
        sendCustomHit("aliTradeUltimateSdk", str, str2, j, map);
    }

    @Override // com.alibaba.baichuan.trade.common.ut.AlibcBaseUserTracker
    public void sendCustomHit(String str, String str2, String str3, long j, Map<String, String> map) {
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
        uTCustomHitBuilder.setDurationOnEvent(j);
        uTCustomHitBuilder.setEventPage(str3);
        uTCustomHitBuilder.setProperties(map);
        Map mapBuild = uTCustomHitBuilder.build();
        if (!TextUtils.isEmpty(str)) {
            str = "aliTradeUltimateSdk";
        }
        UTTracker tracker = UTAnalytics.getInstance().getTracker(str);
        if (tracker != null) {
            tracker.send(mapBuild);
        }
    }
}
