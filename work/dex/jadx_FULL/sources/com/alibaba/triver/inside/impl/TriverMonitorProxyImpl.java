package com.alibaba.triver.inside.impl;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.app.e;
import com.alibaba.triver.app.g;
import com.alibaba.triver.kit.api.monitor.ErrReportBean;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.monitor.d;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.PageUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverMonitorProxyImpl implements ITriverMonitorProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24998a = "TriverMonitorProxyImpl";

    public TriverMonitorProxyImpl() throws Exception {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("firstScreenPaint");
            arrayList.add("screenPaint_");
            arrayList.add("uc_t2_time");
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).setPerformanceStageReentrantWhiteList(arrayList);
        } catch (Exception e) {
            if (CommonUtils.isApkDebug()) {
                throw e;
            }
            RVLogger.e(f24998a, e);
        }
    }

    private boolean a(Object obj) {
        RVLogger.d(RVLogger.makeLogTag(d.f25020a), d.k);
        UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(obj);
        if (!(obj instanceof Page)) {
            return true;
        }
        Page page = (Page) obj;
        g gVar = new g(page, new e(page.getApp()));
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("miniapp_object_type", (Object) (gVar.isHomePage() ? "index" : "subpage"));
        jSONObject.put("miniapp_id", (Object) gVar.getApp().getAppId());
        if (gVar.getApp().getTemplateId() != null) {
            jSONObject.put("miniapp_template_id", (Object) gVar.getApp().getTemplateId());
        }
        map.put("utparam-cnt", jSONObject.toJSONString());
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(obj, map);
        return true;
    }

    private boolean b(Object obj) {
        RVLogger.d(RVLogger.makeLogTag(d.f25020a), d.k);
        HashMap map = null;
        Activity activity = obj instanceof Activity ? (Activity) obj : null;
        if (obj instanceof Page) {
            Page page = (Page) obj;
            g gVar = new g(page, new e(page.getApp()));
            HashMap map2 = new HashMap();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("miniapp_object_type", (Object) (gVar.isHomePage() ? "index" : "subpage"));
            jSONObject.put("miniapp_id", (Object) gVar.getApp().getAppId());
            if (gVar.getApp().getTemplateId() != null) {
                jSONObject.put("miniapp_template_id", (Object) gVar.getApp().getTemplateId());
            }
            map2.put("utparam-cnt", jSONObject.toJSONString());
            PageContext pageContext = page.getPageContext();
            if (pageContext != null) {
                activity = pageContext.getActivity();
            }
            map = map2;
        }
        if (activity != null) {
            UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(activity);
        }
        if (map == null || activity == null) {
            return true;
        }
        UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, map);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void addData2Performance(App app, String str, String str2) throws Exception {
        try {
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addData2Performance(app, PageUtils.getRecentUrl(app), str, str2);
        } catch (Exception e) {
            if (CommonUtils.isApkDebug()) {
                throw e;
            }
            RVLogger.e(f24998a, "addData2Performance with name=" + str + " data=" + str2, e);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void addDatas2Performance(App app, String str, Map<String, String> map) throws Exception {
        try {
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addDatas2Performance(app, PageUtils.getRecentUrl(app), str, map);
        } catch (Exception e) {
            if (CommonUtils.isApkDebug()) {
                throw e;
            }
            RVLogger.e(f24998a, "addData2Performance with name=" + str + " datas=" + map, e);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void addEvent2Performance(App app, String str, Map<String, String> map) throws Exception {
        try {
            RVLogger.d(RVLogger.makeLogTag(d.f25020a), "eventPerformance name:" + str + ", timestamp:" + SystemClock.elapsedRealtime());
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).addEvent2Performance(app, PageUtils.getRecentUrl(app), str, map);
        } catch (Exception e) {
            if (CommonUtils.isApkDebug()) {
                throw e;
            }
            RVLogger.e(f24998a, "addData2Performance with name=" + str, e);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void addStagePerformance(App app, String str) throws Exception {
        try {
            RVLogger.d(RVLogger.makeLogTag(d.f25020a), "stagePerformance name:" + str + ", timestamp:" + SystemClock.elapsedRealtime());
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(app, PageUtils.getRecentUrl(app), str);
        } catch (Exception e) {
            if (CommonUtils.isApkDebug()) {
                throw e;
            }
            RVLogger.e(f24998a, "addData2Performance with name=" + str, e);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean controlHit(String str, Map<String, String> map) {
        try {
            UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(d.b, str);
            uTControlHitBuilder.setProperties(map);
            UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, "controlHit", e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean customAdvance(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        try {
            return customAdvance(str, str2, str3, str4, str5, map, null);
        } catch (Exception e) {
            RVLogger.e(f24998a, d.i, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void error(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        ErrReportBean errReportBean = new ErrReportBean();
        errReportBean.errorType = str;
        errReportBean.aggregationType = "CONTENT";
        if (TextUtils.isEmpty(str2) && ErrId.RV_TYPE_JSAPI_RESULT_ERROR.equals(str)) {
            String str4 = "" + map2.get("jsapiName");
            errReportBean.errorAggregationCode = str4;
            if (com.alibaba.ariver.remotedebug.b.e.equals(str4)) {
                return;
            }
        } else {
            errReportBean.errorAggregationCode = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            errReportBean.errorDetail = JSON.toJSONString(map) + LoginConstants.UNDER_LINE + JSON.toJSONString(map2);
        } else {
            errReportBean.errorDetail = str3;
        }
        errReportBean.version = "0.0.1";
        HashMap map3 = new HashMap();
        if (map != null) {
            map3.put("commonDatas", JSON.toJSONString(map));
        } else {
            RVLogger.e(d.f25020a, "error report but without common datas");
        }
        if (map2 != null) {
            map3.put("extDatas", JSON.toJSONString(map2));
        }
        errReportBean.args = map3;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendErr(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), errReportBean);
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean pageAppear(Object obj) {
        return b(obj);
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean pageDisappear(Object obj) {
        PageContext pageContext;
        RVLogger.d(RVLogger.makeLogTag(d.f25020a), d.l);
        if ((obj instanceof Page) && (pageContext = ((Page) obj).getPageContext()) != null) {
            obj = pageContext.getActivity();
        }
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(obj);
        return true;
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean skipPage(Object obj) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().skipPage(obj);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.j, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updateNextPageProperties(Object obj, Map<String, String> map) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageProperties(map);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.f, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updateNextPageUtparam(Object obj, String str) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(str);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.h, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updatePageName(Object obj, String str) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(obj, str);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.c, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updatePageProperties(Object obj, Map<String, String> map) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(obj, map);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.e, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updatePageUrl(Object obj, String str) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageUrl(obj, Uri.parse(str));
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.d, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean updatePageUtparam(Object obj, String str) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().updatePageUtparam(obj, str);
            return true;
        } catch (Exception e) {
            RVLogger.e(f24998a, d.g, e);
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public boolean customAdvance(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, Object> map2) {
        try {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str2, Integer.parseInt(str), str3, str4, str5, map).build());
            return true;
        } catch (NumberFormatException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy
    public void addStagePerformance(App app, String str, long j) throws Exception {
        try {
            RVLogger.e(RVLogger.makeLogTag(d.f25020a), "stagePerformance name:" + str + ", timestamp:" + j);
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(app, PageUtils.getRecentUrl(app), str, j);
        } catch (Exception e) {
            if (!CommonUtils.isApkDebug()) {
                RVLogger.e(f24998a, "addData2Performance with name=" + str, e);
                return;
            }
            throw e;
        }
    }
}
