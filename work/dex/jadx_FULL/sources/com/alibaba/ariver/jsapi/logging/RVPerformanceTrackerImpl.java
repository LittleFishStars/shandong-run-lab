package com.alibaba.ariver.jsapi.logging;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVPerformanceTrackerImpl implements RVPerformanceTracker {
    public static final String RV_PERFORMANCE_APP_STARTUP_TYPE = "RV_APP_STARTUP";
    public static final String RV_PERFORMANCE_PAGE_TYPE = "RV_APP_PAGE";
    public static final String TAG = "RVPerformanceTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, b> f24153a = new ConcurrentHashMap();
    private Map<String, b> b = new ConcurrentHashMap();
    private List<String> c;

    private void a(String str, String str2, Long l, String str3) {
        String str4 = str2 + l;
        if (RV_PERFORMANCE_APP_STARTUP_TYPE.equals(str)) {
            str4 = str2 + l;
            if (this.f24153a.containsKey(str4)) {
                RVLogger.d(TAG, "app start perf already init");
                return;
            }
        }
        if (RV_PERFORMANCE_PAGE_TYPE.equals(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = a.f24154a;
            }
            str4 = str2 + l + str3;
            if (this.b.containsKey(str4)) {
                RVLogger.d(TAG, "page perf already init");
                return;
            }
        }
        b bVar = new b();
        bVar.a(str2);
        bVar.b(str);
        bVar.a(l);
        if (RV_PERFORMANCE_APP_STARTUP_TYPE.equals(str)) {
            this.f24153a.put(str4, bVar);
        } else {
            this.b.put(str4, bVar);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addData2Performance(App app, String str, String str2, String str3) {
        b bVarA = a(app);
        b bVarA2 = a(app, str);
        if (bVarA != null) {
            bVarA.a(str2, str3);
        }
        if (bVarA2 != null) {
            bVarA2.a(str2, str3);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addDatas2Performance(App app, String str, String str2, Map<String, String> map) {
        b bVarA = a(app);
        b bVarA2 = a(app, str);
        if (bVarA != null) {
            bVarA.a(str2, map);
        }
        if (bVarA2 != null) {
            bVarA2.a(str2, map);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addEvent2Performance(App app, String str, String str2, Map<String, String> map) {
        b bVarA = a(app);
        b bVarA2 = a(app, str);
        if (bVarA != null) {
            bVarA.b(str2, map);
        }
        if (bVarA2 != null) {
            bVarA2.b(str2, map);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void init(String str, String str2, Long l, String str3) {
        try {
            a(str, str2, l, str3);
        } catch (Throwable th) {
            RVLogger.e(TAG, "performance logger init error.", th);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void setPerformanceStageReentrantWhiteList(List<String> list) {
        this.c = list;
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (RVKernelUtils.isDebug()) {
            RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", str2, Long.valueOf(jElapsedRealtime)));
        }
        track(app, str, str2, jElapsedRealtime);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void uploadPerfLog(App app, String str, String str2) {
        try {
            a(app, str, str2);
        } catch (Throwable th) {
            RVLogger.e(TAG, "doLogStartup error!", th);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2, long j) {
        if (RVKernelUtils.isDebug()) {
            RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", str2, Long.valueOf(j)));
        }
        track(app, str, str2, null, null, j);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2, Map<String, Object> map, Map<String, Object> map2, long j) {
        long jElapsedRealtime = j < 0 ? SystemClock.elapsedRealtime() : j;
        if (RVKernelUtils.isDebug()) {
            RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", str2, Long.valueOf(jElapsedRealtime)));
        }
        String strA = a.a(app);
        String strA2 = a.a(app, str);
        b bVar = this.f24153a.get(strA);
        b bVar2 = this.b.get(strA2);
        if (bVar != null) {
            if (PerfId.firstScreen.equals(str2)) {
                if (!bVar.f24155a) {
                    bVar.a(str2, str, map, map2, jElapsedRealtime, this.c);
                    bVar.f24155a = true;
                }
            } else {
                bVar.a(str2, str, map, map2, jElapsedRealtime, this.c);
            }
        }
        if (bVar2 == null) {
            b bVar3 = this.b.get(a.a(app, ""));
            if (bVar3 != null) {
                bVar3.a(str2, str, map, map2, jElapsedRealtime, this.c);
                return;
            }
            return;
        }
        bVar2.a(str2, str, map, map2, jElapsedRealtime, this.c);
    }

    private synchronized void a(App app, String str, String str2) {
        String strA;
        b bVar;
        RVLogger.debug(TAG, "logPerf : " + app.getAppId() + ", " + str + ", " + str2);
        if (RV_PERFORMANCE_PAGE_TYPE.equals(str2)) {
            strA = a.a(app, str);
            bVar = this.b.get(strA);
            if (bVar == null) {
                strA = a.a(app, "");
                bVar = this.b.get(strA);
            }
        } else {
            strA = a.a(app);
            bVar = this.f24153a.get(strA);
        }
        if (bVar == null) {
            return;
        }
        bVar.a(app);
        if (!TextUtils.isEmpty(str)) {
            bVar.c().put("url", str);
        }
        HashMap map = new HashMap(bVar.c());
        HashMap map2 = new HashMap(bVar.d());
        HashMap map3 = new HashMap(bVar.b());
        HashMap map4 = new HashMap(bVar.e());
        bVar.f();
        if (RV_PERFORMANCE_APP_STARTUP_TYPE.equals(str2)) {
            this.f24153a.remove(strA);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performance(RV_PERFORMANCE_APP_STARTUP_TYPE, map, map2, map3, map4);
        } else {
            this.b.remove(strA);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).performance(RV_PERFORMANCE_PAGE_TYPE, map, map2, map3, map4);
        }
    }

    private b a(App app, String str) {
        b bVar = this.b.get(a.a(app, str));
        if (bVar != null) {
            return bVar;
        }
        return this.b.get(a.a(app, ""));
    }

    private b a(App app) {
        return this.f24153a.get(a.a(app));
    }
}
