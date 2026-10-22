package com.alibaba.ariver.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.biz.StartParamChangePoint;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StartParamsBridgeExtension implements BridgeExtension {
    public static final String SCAN_TYPE_KEY = "useScan";
    public static final String SCHEME_INNER_SOURCE = "schemeInnerSource";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24115a = "AriverAPI:StartParamsBridgeExtension";
    private static final int b = 12;
    private static final List<String> c;

    static {
        ArrayList arrayList = new ArrayList();
        c = arrayList;
        arrayList.add(RVParams.CUSTOM_PARAMS);
        arrayList.add(RVParams.LONG_BIZ_SCENARIO);
        arrayList.add(RVStartParams.KEY_BACK_BEHAVIOR);
        arrayList.add("gestureBack");
        arrayList.add(RVParams.LONG_BOUNCE_TOP_COLOR);
        arrayList.add("bounceBottomColor");
        arrayList.add("pullRefreshStyle");
        arrayList.add(RVParams.LONG_TITLE_IMAGE);
        arrayList.add(RVParams.LONG_DEFAULT_TITLE);
        arrayList.add("transparentTitle");
        arrayList.add(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO);
        arrayList.add(RVParams.LONG_TITLE_BAR_COLOR);
        arrayList.add(RVParams.LONG_TITLE_SCROLLDISTANCE);
        arrayList.add(RVParams.LONG_NAV_SEARCH_BAR_TYPE);
        arrayList.add(RVParams.LONG_NAV_SEARCH_BAR_PLACEHOLDER);
        arrayList.add(RVParams.LONG_NAV_SEARCH_BAR_VALUE);
        arrayList.add(RVParams.LONG_NAV_SEARCH_BAR_MAX_LENGTH);
        arrayList.add("fullscreen");
        arrayList.add("landscape");
        arrayList.add(RVParams.LONG_TITLE_COLOR);
        arrayList.add("hideCloseButton");
        arrayList.add(RVParams.LONG_REPORTURL);
        arrayList.add("feedBackExtParams");
        arrayList.add(RVParams.LONG_SHOW_DOMAIN);
        arrayList.add(RVParams.LONG_PULL_REFRESH);
        arrayList.add(RVParams.LONG_SHOW_OPTION_MENU);
        arrayList.add(RVParams.BIZ_SCENARIO);
        arrayList.add(RVParams.BACK_BEHAVIOR);
        arrayList.add("gb");
        arrayList.add(RVParams.BOUNCE_TOP_COLOR);
        arrayList.add("bbc");
        arrayList.add("pr");
        arrayList.add("prs");
        arrayList.add(RVParams.TITLE_IMAGE);
        arrayList.add(RVParams.DEFAULT_TITLE);
        arrayList.add(RVParams.SHOW_OPTION_MENU);
        arrayList.add(RVParams.TRANSPARENT_TITLE);
        arrayList.add(RVParams.TRANSPARENT_TITLE_TEXTAUTO);
        arrayList.add(RVParams.TITLE_BAR_COLOR);
        arrayList.add(RVParams.TITLE_SCROLLDISTANCE);
        arrayList.add(RVParams.NAV_SEARCH_BAR_TYPE);
        arrayList.add(RVParams.NAV_SEARCH_BAR_PLACEHOLDER);
        arrayList.add(RVParams.NAV_SEARCH_BAR_VALUE);
        arrayList.add(RVParams.NAV_SEARCH_BAR_MAX_LENGTH);
        arrayList.add("fs");
        arrayList.add(RVStartParams.KEY_LANDSCAPE_SHORT);
        arrayList.add(RVParams.TITLE_COLOR);
        arrayList.add("hcb");
        arrayList.add("ru");
        arrayList.add("fbp");
    }

    public static boolean enableAddUseScan() {
        return !"no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_enableAddUseScan", ""));
    }

    public static void removeBridgeTimeParam(JSONObject jSONObject) {
        if (jSONObject == null || "no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_removeBridgeTimeParam", ""))) {
            return;
        }
        jSONObject.remove("perf_prepare_time");
        jSONObject.remove("perf_open_app_time");
        jSONObject.remove("is_preload");
        jSONObject.remove("is_local");
        jSONObject.remove("LITE_PROCESS_ID");
        jSONObject.remove("REALLY_STARTAPP");
        jSONObject.remove("REALLY_DOSTARTAPP");
        jSONObject.remove(RVParams.LONG_PACKAGE_LOADING_SHOWN);
        jSONObject.remove(RVParams.LONG_SAFEPAY_CONTEXT);
        jSONObject.remove(RVParams.LONG_REPORTURL);
        if (jSONObject.containsKey(SCHEME_INNER_SOURCE) && enableAddUseScan()) {
            jSONObject.remove(SCHEME_INNER_SOURCE);
        }
        if (jSONObject.containsKey(SCAN_TYPE_KEY) && enableAddUseScan()) {
            jSONObject.remove(SCAN_TYPE_KEY);
        }
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse getStartupParams(@BindingNode(Page.class) Page page, @BindingNode(App.class) App app, @BindingParam({CachedContentIndex.a.e}) String[] strArr) {
        Bundle startParams;
        if (page == null || page.getStartParams() == null) {
            if (app == null || app.getStartParams() == null) {
                return new BridgeResponse.Error(12, "page or app is null");
            }
            startParams = app.getStartParams();
        } else {
            startParams = page.getStartParams();
        }
        JSONObject jSONObject = BundleUtils.toJSONObject(startParams);
        if (jSONObject.isEmpty()) {
            return new BridgeResponse.Error(12, "params is null");
        }
        removeBridgeTimeParam(jSONObject);
        if (strArr == null) {
            return new BridgeResponse(jSONObject);
        }
        if (strArr.length <= 0) {
            return new BridgeResponse.Error(2, LangResourceUtil.getString(R.string.ariver_jsapi_invalid_api_params));
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : strArr) {
            Object value = JSONUtils.getValue(jSONObject, str, null);
            if (value == null) {
                RVLogger.e(f24115a, "getStartupParam but cannot find key: " + str);
            } else {
                jSONObject2.put(str, value);
            }
        }
        return new BridgeResponse(jSONObject2);
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

    @ActionFilter
    @AutoCallback
    public BridgeResponse setStartParam(@BindingParam({"content"}) String str, @BindingNode(Page.class) Page page) {
        if (page == null || page.getStartParams() == null) {
            return BridgeResponse.INVALID_PARAM;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length >= 2) {
                        String str3 = strArrSplit[0];
                        String str4 = strArrSplit[1];
                        if (!c.contains(str3)) {
                            RVLogger.d(f24115a, "not put key : " + str3 + " value : " + str4);
                            return new BridgeResponse.Error(2, LangResourceUtil.getString(R.string.ariver_jsapi_invalid_api_params) + u15.f19942b + str3);
                        }
                        synchronized (page.getStartParams()) {
                            page.getStartParams().putString(str3, str4);
                            RVLogger.d(f24115a, "set startParam [key] " + str3 + " [value] " + str4);
                            ((StartParamChangePoint) ExtensionPoint.as(StartParamChangePoint.class).node(page).create()).onStartParamChange(str3, str4);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f24115a, th);
        }
        return BridgeResponse.SUCCESS;
    }
}
