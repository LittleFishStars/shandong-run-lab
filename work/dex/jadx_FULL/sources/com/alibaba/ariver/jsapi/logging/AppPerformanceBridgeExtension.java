package com.alibaba.ariver.jsapi.logging;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.TinyAppLifecyclePoint;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppPerformanceBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24151a = "AriverAPI:AppPerformanceBridgeExtension";

    @Keep
    public static class PerformanceEntry {
        public String name;
        public long value;
    }

    private BridgeResponse a(Page page, String str, int i, long j, Map<String, Object> map) {
        RVLogger.d(f24151a, "handleAppPerfEvent: state = " + str + " loadTime = " + i);
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        if (TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED.equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_pageLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_bizPhase_t2);
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_PageLoad);
            page.setPageLoaded();
            if (SplashUtils.useSuperSplash(page.getStartParams()) && page.getApp() != null && page.getApp().getAppContext() != null) {
                page.getApp().getAppContext().getSplashView().exit(null);
            }
            ((TinyAppLifecyclePoint) ExtensionPoint.as(TinyAppLifecyclePoint.class).node(page).create()).onPageLoaded(page);
        }
        if ("renderFrameworkLoaded".equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_renderFrameworkLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_appxPhase_appLoaded);
        }
        if (TriverAppMonitorConstants.KEY_STAGE_APP_LOADED.equals(str)) {
            RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appxPhase_appLoaded);
            RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_appxPhase_pageLoaded);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (j > 0) {
            jElapsedRealtime = j - (System.currentTimeMillis() - SystemClock.elapsedRealtime());
        }
        Event trackId = new Event.Stub(jElapsedRealtime).setTrackId("js_" + str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                trackId.putAttr("js_" + str2, map.get(str2));
            }
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).event(page, trackId);
        if (i > 0) {
            ((EventTracker) RVProxy.get(EventTracker.class)).event(page, new Event.Cost(i).setTrackId("js_" + str + "_cost"));
        }
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse onAppPerfEvent(@BindingNode(Page.class) Page page, @BindingParam({"state"}) String str, @BindingParam(intDefault = -1, name = {"loadTime"}) int i, @BindingParam(longDefault = -1, name = {"time"}) long j, @BindingParam({"data"}) Map<String, Object> map) {
        return a(page, str, i, j, map);
    }

    @ActionFilter("monitorH5Performance")
    public BridgeResponse onBizPerfEvent(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingApiContext ApiContext apiContext) {
        if (jSONObject == null) {
            return BridgeResponse.SUCCESS;
        }
        JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "data", null);
        if (jSONArray == null || jSONArray.size() <= 0) {
            return BridgeResponse.SUCCESS;
        }
        if (page == null) {
            return BridgeResponse.SUCCESS;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if ("availableTime".equals(JSONUtils.getString(jSONObject2, "name"))) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = JSONUtils.getLong(jSONObject2, "value");
                    if (j > 0) {
                        jElapsedRealtime = j - (System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    }
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_AvailableTime);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(page, TrackId.Stub_Page_Biz_Ready, jElapsedRealtime);
                }
            } catch (Throwable th) {
                RVLogger.e(f24151a, "monitorH5Performance error!", th);
            }
        }
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse onCubeAppPerfEvent(@BindingNode(Page.class) Page page, @BindingParam({"state"}) String str, @BindingParam(intDefault = -1, name = {"loadTime"}) int i, @BindingParam(longDefault = -1, name = {"time"}) long j, @BindingParam({"data"}) Map<String, Object> map) {
        return a(page, str, i, j, map);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
