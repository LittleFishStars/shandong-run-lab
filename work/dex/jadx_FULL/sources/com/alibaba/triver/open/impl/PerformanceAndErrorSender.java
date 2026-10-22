package com.alibaba.triver.open.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.monitor.ErrReportBean;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.monitor.d;
import com.alibaba.triver.open.proxy.IMonitorProxy;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PerformanceAndErrorSender implements IPerformanceAndErrorTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25060a = "TRiver";
    private static final String b = "TRiver_______TRiver";
    private static final int c = 2;
    private final Integer d = 61004;
    private final String e = "RV_PERFORMANCE";
    private final String f = null;
    private boolean g = true;

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendErr(Context context, ErrReportBean errReportBean) {
        try {
            if (((IMonitorProxy) RVProxy.get(IMonitorProxy.class)).hitSampling("Page_TRVError", errReportBean.arg1, errReportBean.arg2, errReportBean.arg3)) {
                RVLogger.d(RVLogger.makeLogTag(d.f25020a), "error: [type]" + errReportBean.errorType + ", [aggregationType]" + errReportBean.aggregationType + ", [msg]" + errReportBean.errorDetail);
                if (errReportBean.args == null) {
                    errReportBean.args = new HashMap();
                }
                errReportBean.args.put(UserTrackConstant.ERROR_TYPE, errReportBean.errorType);
                errReportBean.args.put("aggregationType", errReportBean.aggregationType);
                errReportBean.args.put("exceptionCode", errReportBean.errorAggregationCode);
                errReportBean.args.put("exceptionId", errReportBean.errorId);
                errReportBean.args.put("exceptionDetail", errReportBean.errorDetail);
                Map<String, String> map = errReportBean.args;
                Throwable th = errReportBean.throwable;
                map.put("throwable", th != null ? th.getLocalizedMessage() : null);
                Map<String, String> map2 = errReportBean.args;
                Thread thread = errReportBean.thread;
                map2.put("thread", thread != null ? thread.getName() : null);
                errReportBean.args.put("exceptionVersion", errReportBean.version);
                UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("Page_TRVError", 19999, errReportBean.arg1, errReportBean.arg2, errReportBean.arg3, errReportBean.args).build());
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerf(String str, String str2) {
        if (((IMonitorProxy) RVProxy.get(IMonitorProxy.class)).hitSampling("Page_TRVPerf", null, null, null)) {
            RVLogger.d(RVLogger.makeLogTag(d.f25020a), "performance: [topic]" + str + ", [content]" + str2);
            HashMap map = new HashMap();
            map.put("topic", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject object = JSON.parseObject(str2);
                for (String str3 : object.keySet()) {
                    map.put(str3, object.get(str3).toString());
                }
            }
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("Page_TRVPerf", 19999, (String) null, (String) null, (String) null, map).build());
        }
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerfStageLog(String str, String str2) {
        RVLogger.printPerformanceLog(str, str2);
    }

    @Override // com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker
    public void sendPerfV2(String str) {
    }
}
