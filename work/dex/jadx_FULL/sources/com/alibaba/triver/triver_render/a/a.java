package com.alibaba.triver.triver_render.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionRequestPoint;
import com.alibaba.ariver.resource.api.extension.ResourcePerceptionResponsePoint;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.tracedebug.TRTraceDebug;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements android.taobao.windvane.extra.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private App f25197a;
    private HashMap<String, Integer> b = new HashMap<>();

    public a(App app) {
        this.f25197a = app;
    }

    @Override // android.taobao.windvane.extra.b.a
    public void a() {
    }

    @Override // android.taobao.windvane.extra.b.a
    public void a(String str, long j) {
        if (this.f25197a == null) {
            return;
        }
        try {
            if (!TextUtils.equals(str, "finishLoad") && !TextUtils.equals(str, "firstScreenPaint")) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.f25197a, str, a(j, false));
                return;
            }
            long j2 = this.f25197a.getSceneParams().getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP);
            TRTraceDebug tRTraceDebugCreate = ExtensionPoint.as(TRTraceDebug.class).node(this.f25197a).create();
            if (tRTraceDebugCreate != null) {
                tRTraceDebugCreate.receiveStartUpTime(a(j2, true), j);
            }
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("firstScreenPaint", "firstScreenPaint");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.extra.b.a
    public void b() {
    }

    @Override // android.taobao.windvane.extra.b.a
    public void b(String str, long j) {
        try {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(this.f25197a, str, String.valueOf(j));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.extra.b.a
    public void b(String str, int i) {
        int iIntValue;
        if (this.b.get(str) == null || TextUtils.isEmpty(str)) {
            iIntValue = 0;
        } else {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            String str2 = "URL: " + str + "，statusCode：" + this.b.get(str);
            App app = this.f25197a;
            rVMonitor.flowLog("WEBVIEW_RESOURCE_FINISHED", str2, "RENDER", app != null ? app.getAppId() : "", null, null);
            iIntValue = this.b.get(str).intValue();
            this.b.remove(str);
        }
        int i2 = iIntValue;
        ResourcePerceptionResponsePoint resourcePerceptionResponsePoint = (ResourcePerceptionResponsePoint) ExtensionPoint.as(ResourcePerceptionResponsePoint.class).node(this.f25197a).create();
        if (resourcePerceptionResponsePoint != null) {
            resourcePerceptionResponsePoint.onResourceResponse(str, i2, null, null, System.currentTimeMillis(), i);
        }
    }

    @Override // android.taobao.windvane.extra.b.a
    public void a(String str, Object obj) {
        try {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(this.f25197a, str, String.valueOf(obj));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.taobao.windvane.extra.b.a
    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
                String str2 = "URL: " + str;
                App app = this.f25197a;
                rVMonitor.flowLog("WEBVIEW_RESOURCE_START", str2, "RENDER", app != null ? app.getAppId() : "", null, null);
            }
            ResourcePerceptionRequestPoint resourcePerceptionRequestPoint = (ResourcePerceptionRequestPoint) ExtensionPoint.as(ResourcePerceptionRequestPoint.class).node(this.f25197a).create();
            if (resourcePerceptionRequestPoint != null) {
                resourcePerceptionRequestPoint.onResourceRequest(str, null, null, System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.taobao.windvane.extra.b.a
    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, new Integer(i));
    }

    public static long a(long j, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        return z ? j + jCurrentTimeMillis : j - jCurrentTimeMillis;
    }
}
