package com.alibaba.triver.monitor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.triver.kit.api.monitor.ErrReportBean;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverPerformanceAndErrorTracker implements IPerformanceAndErrorTracker {
    public static boolean OPEN_PERFORMANCE_LOG = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25016a = "TRiver_______TRiver";
    private static final int b = 2;
    private static final String c = "triver_performance_statistics";
    private static final String d = "triver_performance_log";
    private static final String e = "triver_performance_statistics_v2";
    private static Object k;
    private final Integer f = 61004;
    private final String g = "RV_PERFORMANCE";
    private final String h = null;
    private boolean i = true;
    private a j = new b();

    static {
        try {
            k = Class.forName("com.taobao.aboat.ReceivePerformance").getDeclaredConstructor(Context.class).newInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        return SendService.getInstance().sendRequest(this.h, System.currentTimeMillis(), (String) null, this.f.intValue(), "RV_PERFORMANCE", str2, str, (Map) null).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        this.j.a(str + f25016a + str2);
    }

    private void c(String str, String str2) {
        Object obj;
        Method declaredMethod;
        try {
            if (TextUtils.isEmpty(str2) || (obj = k) == null || (declaredMethod = obj.getClass().getDeclaredMethod("onReceiveWindmillPerformanceLog", String.class, String.class)) == null) {
                return;
            }
            declaredMethod.invoke(k, str, str2);
        } catch (Throwable th) {
            RVLogger.e(RVLogger.makeLogTag(d.f25020a), th);
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendErr(Context context, ErrReportBean errReportBean) {
        try {
            RVLogger.d(RVLogger.makeLogTag(d.f25020a), "error: [type]" + errReportBean.errorType + ", [aggregationType]" + errReportBean.aggregationType + ", [msg]" + errReportBean.errorDetail);
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.businessType = errReportBean.errorType;
            bizErrorModule.aggregationType = AggregationType.valueOf(errReportBean.aggregationType);
            bizErrorModule.exceptionCode = errReportBean.errorAggregationCode;
            bizErrorModule.exceptionId = errReportBean.errorId;
            bizErrorModule.exceptionDetail = errReportBean.errorDetail;
            bizErrorModule.throwable = errReportBean.throwable;
            bizErrorModule.thread = errReportBean.thread;
            bizErrorModule.exceptionVersion = errReportBean.version;
            bizErrorModule.exceptionArg1 = errReportBean.arg1;
            bizErrorModule.exceptionArg2 = errReportBean.arg2;
            bizErrorModule.exceptionArg3 = errReportBean.arg3;
            if (errReportBean.args != null) {
                HashMap map = new HashMap();
                for (Map.Entry<String, String> entry : errReportBean.args.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
                bizErrorModule.exceptionArgs = map;
            }
            BizErrorReporter.getInstance().send(context, bizErrorModule);
            c(c, JSON.toJSONString(bizErrorModule));
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerf(final String str, final String str2) {
        RVLogger.d(RVLogger.makeLogTag(d.f25020a), "performance: [topic]" + str + ", [content]" + str2);
        c(c, str2);
        c.a(new Runnable() { // from class: com.alibaba.triver.monitor.TriverPerformanceAndErrorTracker.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                boolean zA = false;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 2) {
                        break;
                    }
                    try {
                        zA = TriverPerformanceAndErrorTracker.this.a(str, str2);
                        if (zA) {
                            break;
                        } else {
                            i = i2;
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (!zA) {
                    TriverPerformanceAndErrorTracker.this.b(str, str2);
                    TriverPerformanceAndErrorTracker.this.i = true;
                }
                if (zA && TriverPerformanceAndErrorTracker.this.i) {
                    TriverPerformanceAndErrorTracker.this.a();
                    TriverPerformanceAndErrorTracker.this.i = false;
                }
            }
        });
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerfStageLog(String str, String str2) {
        RVLogger.printPerformanceLog(str, str2);
        if (OPEN_PERFORMANCE_LOG) {
            Log.e("AriverPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:" + str + "] [Info:" + str2 + "] [TimeStamp:" + System.currentTimeMillis() + "]");
            c(d, "[Thread:" + Thread.currentThread().getName() + "] [Stage:" + str + "] [Info:" + str2 + "] [TimeStamp:" + System.currentTimeMillis() + "]");
        }
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerfV2(String str) {
        c(e, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<String> listA = this.j.a();
        if (listA != null) {
            for (String str : listA) {
                if (str != null) {
                    String[] strArrSplit = str.split(f25016a);
                    if (strArrSplit.length >= 2) {
                        a(strArrSplit[0], strArrSplit[1]);
                    }
                }
            }
        }
        this.j.b();
    }
}
