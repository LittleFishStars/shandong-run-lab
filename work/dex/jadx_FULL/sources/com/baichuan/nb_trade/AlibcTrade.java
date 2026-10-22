package com.baichuan.nb_trade;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.alibcprotocol.AlibcTradeHelper;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.callback.AlibcTradeCallback;
import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.param.AlibcTaokeParams;
import com.alibaba.alibcprotocol.route.RequestFactory;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcSoLoadProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcToolProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.sdk.RouteCenter;
import com.alibaba.alibcprotocol.sdk.RouteInnerCallback;
import com.alibaba.alibcprotocol.sdk.RouteResult;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.baichuan.nb_trade.base.AlibcBizConstant;
import com.baichuan.nb_trade.callback.AlibcRouteCallback;
import com.baichuan.nb_trade.callback.AlibcTradeInitCallback;
import com.baichuan.nb_trade.core.AlibcTradeSDK;
import com.baichuan.nb_trade.distribute.HandlerCenter;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.zj.adlib.tga;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcTrade {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26218a = "AlibcTrade";

    public static class a implements AlibcTradeInitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26219a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeCallback f1206a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcShowParams f1207a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTaokeParams f1208a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f1209a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f1210a;

        public a(Context context, String str, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map map, AlibcTradeCallback alibcTradeCallback) {
            this.f26219a = context;
            this.f1209a = str;
            this.f1207a = alibcShowParams;
            this.f1208a = alibcTaokeParams;
            this.f1210a = map;
            this.f1206a = alibcTradeCallback;
        }

        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public final void onFailure(int i, String str) {
            this.f1206a.onFailure(i, str);
        }

        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public final void onSuccess() {
            AlibcTrade.l(this.f26219a, this.f1209a, this.f1207a, this.f1208a, this.f1210a, this.f1206a);
        }
    }

    public static class b implements AlibcTradeCallback {
        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public final void onFailure(int i, String str) {
            AlibcLogger.e(AlibcTrade.f26218a, "code = " + i + ", msg = " + str);
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public final void onSuccess(int i, Object obj) {
        }
    }

    public static class c implements RouteRequestCallback {
        @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
        public final void onBuildComplete(String str) {
            AlibcLogger.i(AlibcTrade.f26218a, "build request complete");
        }

        @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
        public final void onBuildFail(int i, String str) {
            AlibcLogger.e(AlibcTrade.f26218a, "build request fail: code = " + i + ", msg = " + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.ERROR_TYPE, (Object) "2");
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_URL, String.valueOf(i), str, jSONObject);
        }
    }

    public static class d implements AlibcRouteCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeCallback f26220a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JSONObject f1211a;

        public d(AlibcTradeCallback alibcTradeCallback, JSONObject jSONObject) {
            this.f26220a = alibcTradeCallback;
            this.f1211a = jSONObject;
        }

        @Override // com.baichuan.nb_trade.callback.AlibcRouteCallback
        public final void onRouteComplete(int i, String str) {
            AlibcLogger.i(AlibcTrade.f26218a, "route complete: code = " + i + ", msg = " + str);
            if (this.f26220a != null) {
                if (i < 0) {
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_URL, String.valueOf(i), "", this.f1211a);
                    this.f26220a.onFailure(i, str);
                } else {
                    AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_OPEN_BY_URL, String.valueOf(i), "", this.f1211a);
                    this.f26220a.onSuccess(i, new Object());
                }
            }
        }
    }

    public static class e implements AlibcTradeInitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26221a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeCallback f1212a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcBizParams f1213a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcShowParams f1214a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTaokeParams f1215a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f1216a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f1217a;

        public e(Context context, String str, AlibcBizParams alibcBizParams, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map map, AlibcTradeCallback alibcTradeCallback) {
            this.f26221a = context;
            this.f1216a = str;
            this.f1213a = alibcBizParams;
            this.f1214a = alibcShowParams;
            this.f1215a = alibcTaokeParams;
            this.f1217a = map;
            this.f1212a = alibcTradeCallback;
        }

        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public final void onFailure(int i, String str) {
            this.f1212a.onFailure(i, str);
        }

        @Override // com.baichuan.nb_trade.callback.AlibcTradeInitCallback
        public final void onSuccess() {
            AlibcTrade.openByCodeOld(this.f26221a, this.f1216a, this.f1213a, this.f1214a, this.f1215a, this.f1217a, this.f1212a);
        }
    }

    public static class f implements AlibcTradeCallback {
        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public final void onFailure(int i, String str) {
            AlibcLogger.e(AlibcTrade.f26218a, "code = " + i + ", msg = " + str);
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcTradeCallback
        public final void onSuccess(int i, Object obj) {
        }
    }

    public static class g implements RouteRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeCallback f26222a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JSONObject f1218a;

        public g(AlibcTradeCallback alibcTradeCallback, JSONObject jSONObject) {
            this.f26222a = alibcTradeCallback;
            this.f1218a = jSONObject;
        }

        @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
        public final void onBuildComplete(String str) {
            AlibcLogger.i(AlibcTrade.f26218a, "build request complete：node = " + str);
        }

        @Override // com.alibaba.alibcprotocol.callback.RouteRequestCallback
        public final void onBuildFail(int i, String str) {
            AlibcLogger.e(AlibcTrade.f26218a, "build request fail: code = " + i + ", msg = " + str);
            this.f26222a.onFailure(i, str);
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_CODE, String.valueOf(i), str, this.f1218a);
        }
    }

    public static class h implements RouteInnerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeCallback f26223a;

        public h(AlibcTradeCallback alibcTradeCallback) {
            this.f26223a = alibcTradeCallback;
        }

        @Override // com.alibaba.alibcprotocol.sdk.RouteInnerCallback
        public final void onRouteFail() {
        }

        @Override // com.alibaba.alibcprotocol.sdk.RouteInnerCallback
        public final void onRouteSuccess(RouteResult routeResult) {
            this.f26223a.onSuccess(100000, (JSONObject) routeResult.getResult());
        }
    }

    public static class i implements AlibcRouteCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeCallback f26224a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JSONObject f1219a;

        public i(JSONObject jSONObject, AlibcTradeCallback alibcTradeCallback) {
            this.f1219a = jSONObject;
            this.f26224a = alibcTradeCallback;
        }

        @Override // com.baichuan.nb_trade.callback.AlibcRouteCallback
        public final void onRouteComplete(int i, String str) {
            AlibcLogger.i(AlibcTrade.f26218a, "route complete: code = " + i + ", msg = " + str);
            if (i < 0) {
                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_CODE, String.valueOf(i), "", this.f1219a);
                this.f26224a.onFailure(i, str);
            } else {
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_OPEN_BY_CODE, String.valueOf(i), "", this.f1219a);
                this.f26224a.onSuccess(i, new Object());
            }
        }
    }

    public static Map<String, String> b(String str, AlibcBizParams alibcBizParams) {
        HashMap map = new HashMap();
        Map<String, String> extParams = alibcBizParams.getExtParams();
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri uri = Uri.parse(str);
                if ("suite".equals(uri.getScheme())) {
                    map.put("suite_type", "1");
                    String host = uri.getHost();
                    String path = uri.getPath();
                    if (!TextUtils.isEmpty(host)) {
                        map.put(UserTrackConstant.SUITE_CODE, host);
                        extParams.put(UserTrackConstant.SUITE_CODE, host);
                    }
                    if (!TextUtils.isEmpty(path)) {
                        if (WVNativeCallbackUtil.SEPERATER.equals(path.substring(path.length() - 1))) {
                            map.put("pageCode", path.substring(1, path.length() - 1));
                        } else {
                            map.put("pageCode", path.substring(1));
                        }
                    }
                } else {
                    map.put("suite_type", "0");
                    map.put("pageCode", str);
                    extParams.put(UserTrackConstant.SUITE_CODE, str);
                }
            } catch (Exception e2) {
                AlibcLogger.e(f26218a, "parse url exception: " + e2.getMessage());
                HashMap map2 = new HashMap();
                map2.put("套件CODE", str);
                map2.put("errorMsg", "解析套件code异常");
                map2.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SUITE_CODE_PARSE_EXCEPTION);
                AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@PARSE_CODE_FAIL", "BC_API_CALL", "解析套件code异常", map2);
            }
        }
        return map;
    }

    public static void buildTradeContext(Context context, AlibcBizParams alibcBizParams, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            AlibcTradeContext.getInstance().mActivity = new WeakReference<>(activity);
            AlibcTradeContext.getInstance().mRawActivity = new WeakReference<>(activity);
        }
        AlibcTradeContext.getInstance().context = context;
        f(alibcBizParams, map);
        AlibcTradeContext.getInstance().bizParams = alibcBizParams;
        AlibcTradeContext.getInstance().showParams = alibcShowParams;
        AlibcTradeContext.getInstance().taokeParams = alibcTaokeParams;
        AlibcTradeContext.getInstance().trackParams = AlibcTradeHelper.createUrlParams(map);
        AlibcTradeContext.getInstance().convertedUrls = new ConcurrentHashMap<>(16);
    }

    public static void c(Context context) {
        PageDO page = AlibcConfigService.getInstance().getPage();
        if (NetWorkUtils.isWifiConnected(context)) {
            if (page == null || page.getMisc() == null) {
                AlibcConfigService.getInstance().refreshConfig(context, AlibcProtocolConstant.REQUEST_SUITE_CONFIG);
            }
        }
    }

    public static synchronized void d(Context context, String str, AlibcBizParams alibcBizParams, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(UserTrackConstant.SUITE_CODE, (Object) str);
        jSONObject.put("openType", (Object) "code");
        AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_ENTRANCE_CALL, 1, jSONObject);
        if (j(alibcTradeCallback, "code")) {
            return;
        }
        if (AlibcProtocolUtils.verifyMiniappUrl(alibcShowParams, "code")) {
            alibcTradeCallback.onFailure(1200, AlibcProtocolConstant.URL_IS_MINIAPP_MSG);
        }
        if ("suite://bc.suite.live/bc.template.live.list".equals(str) || AlibcBizConstant.LIVE_ROOM_SUITE_CODE.equals(str)) {
            ((IAlibcSoLoadProxy) AlibcProxy.get(IAlibcSoLoadProxy.class)).loadSo(AlibcBaseTradeCommon.context, "live_so", "liveZip", ILivePush.ClickType.LIVE);
        }
        RouteRequest routeRequestBuildRequest = RequestFactory.buildRequest(new RouteRequest("", b(str, alibcBizParams)), alibcBizParams, new g(alibcTradeCallback, jSONObject));
        if (routeRequestBuildRequest != null && !TextUtils.isEmpty(routeRequestBuildRequest.getRawUrl())) {
            h(routeRequestBuildRequest, jCurrentTimeMillis);
            i(routeRequestBuildRequest.getRawUrl(), routeRequestBuildRequest);
            buildTradeContext(context, alibcBizParams, alibcShowParams, alibcTaokeParams, map);
            if (k(routeRequestBuildRequest.getRawUrl())) {
                RouteCenter.route(routeRequestBuildRequest, null, new h(alibcTradeCallback));
                return;
            }
            HandlerCenter.getInstance().route(routeRequestBuildRequest, AlibcTradeContext.getInstance(), new i(jSONObject, alibcTradeCallback), null);
        }
    }

    public static void f(AlibcBizParams alibcBizParams, Map<String, String> map) {
        if (alibcBizParams != null) {
            Map<String, String> extParams = alibcBizParams.getExtParams();
            if (extParams == null) {
                alibcBizParams.setExtParams(new HashMap(16));
                extParams = alibcBizParams.getExtParams();
            }
            for (Map.Entry<String, String> entry : AlibcTradeHelper.createUrlParams(map).entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    extParams.put(key, value);
                }
            }
            alibcBizParams.setExtParams(extParams);
        }
    }

    public static void g(AlibcTaokeParams alibcTaokeParams) {
        if (alibcTaokeParams == null || TextUtils.isEmpty(alibcTaokeParams.pid)) {
            HashMap map = new HashMap();
            map.put("errorMsg", "淘客参数对象或pid参数为空");
            map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.TAOKE_PARAM_ERROR);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@CHECK_TAOKEPARAM_FAIL", "BC_API_CALL", "淘客参数对象或pid参数为空", map);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("pid", TextUtils.isEmpty(alibcTaokeParams.pid) ? "" : alibcTaokeParams.pid);
        map2.put("relationId", TextUtils.isEmpty(alibcTaokeParams.relationId) ? "" : alibcTaokeParams.relationId);
        map2.put("subPid", TextUtils.isEmpty(alibcTaokeParams.subPid) ? "" : alibcTaokeParams.subPid);
        map2.put("unionId", TextUtils.isEmpty(alibcTaokeParams.unionId) ? "" : alibcTaokeParams.unionId);
        map2.put("materialSourceUrl", TextUtils.isEmpty(alibcTaokeParams.materialSourceUrl) ? "" : alibcTaokeParams.materialSourceUrl);
        Map<String, String> map3 = alibcTaokeParams.extParams;
        if (map3 != null) {
            for (Map.Entry<String, String> entry : map3.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    map2.put(key, value);
                }
            }
        }
        AlibcLogger.flowLog("baichuan", "OPEN_BY_CODE@CHECK_TAOKEPARAM_SUCCESS", "BC_API_CALL", "检查淘客参数", map2);
    }

    public static void h(RouteRequest routeRequest, long j) {
        Map<String, Object> map = routeRequest.getExtParams() == null ? new HashMap<>() : routeRequest.getExtParams();
        map.put("startTime", Long.valueOf(j));
        routeRequest.setExtParams(map);
    }

    public static void i(String str, RouteRequest routeRequest) {
        try {
            Uri uri = Uri.parse(str);
            String queryParameter = uri == null ? "" : uri.getQueryParameter("disableNav");
            Map<String, Object> extParams = routeRequest.getExtParams();
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            extParams.put("disableNav", queryParameter);
        } catch (Throwable th) {
            AlibcLogger.e(f26218a, "parse disableNav exception: " + th.getMessage());
        }
    }

    public static boolean j(AlibcTradeCallback alibcTradeCallback, String str) {
        MiscDO misc;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null || (misc = config.getMisc()) == null || misc.getSt() != 0) {
            return false;
        }
        String em = TextUtils.isEmpty(misc.getEm()) ? AlibcProtocolConstant.SDK_VERSION_INVALID_MSG : misc.getEm();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(UserTrackConstant.ERROR_TYPE, (Object) "0");
        if ("code".equals(str)) {
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_URL, "1300", em, jSONObject);
        } else if ("url".equals(str)) {
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_CODE, "1300", em, jSONObject);
        }
        alibcTradeCallback.onFailure(1300, em);
        return true;
    }

    public static boolean k(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            uri.getAuthority();
            return "bcNative".equals(scheme);
        } catch (Throwable th) {
            AlibcLogger.i(f26218a, "parse url exception: " + th.getMessage());
            return false;
        }
    }

    public static synchronized void l(Context context, String str, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        if (tga.getInitState() == 0) {
            alibcTradeCallback.onFailure(1500, AlibcProtocolConstant.SDK_NOT_INITIALIZED_MSG);
            HashMap map2 = new HashMap();
            map2.put("errorMsg", "SDK没有初始化");
            map2.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SDK_NOT_INITIALIZED);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@SDK_NOT_INITIALIZED", "BC_API_CALL", "SDK没有初始化", map2);
            return;
        }
        if (tga.getInitState() == 3) {
            alibcTradeCallback.onFailure(1600, AlibcProtocolConstant.SDK_INITIAL_FAIL_MSG);
            HashMap map3 = new HashMap();
            map3.put("errorMsg", "SDK初始化失败");
            map3.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SDK_INITIAL_FAIL);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@SDK_INITIAL_FAIL", "BC_API_CALL", "SDK初始化失败", map3);
            return;
        }
        if (alibcTradeCallback == null) {
            alibcTradeCallback = new b();
        }
        AlibcTradeCallback alibcTradeCallback2 = alibcTradeCallback;
        if (AlibcUrlCheck.regularCheck(new String[]{"^http(s)?://oauth\\.(.*)\\.taobao.com/authorize?(.*)", "^http(s)?://oauth\\.taobao.com/authorize?(.*)"}, str)) {
            Toast.makeText(context, "请使用Auth授权API进行授权", 0).show();
            return;
        }
        ((IAlibcToolProxy) AlibcProxy.get(IAlibcToolProxy.class)).startTraceLogcat(context);
        g(alibcTaokeParams);
        c(context);
        m(context, str, alibcShowParams, alibcTaokeParams, map, alibcTradeCallback2);
    }

    public static synchronized void m(Context context, String str, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str)) {
            str2 = "union";
        } else {
            str2 = AlibcProtocolUtils.verifyMiniappUrl(str) ? "miniapp" : "h5";
        }
        jSONObject.put(UserTrackConstant.URL_TYPE, (Object) str2);
        jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
        jSONObject.put("openType", (Object) "url");
        AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_ENTRANCE_CALL, 1, jSONObject);
        if (j(alibcTradeCallback, "url")) {
            return;
        }
        if (AlibcProtocolUtils.verifyMiniappUrl(alibcShowParams, "url") && alibcTradeCallback != null) {
            alibcTradeCallback.onFailure(1200, AlibcProtocolConstant.URL_IS_MINIAPP_MSG);
        }
        RouteRequest routeRequestBuildRequest = RequestFactory.buildRequest(new RouteRequest(str, ""), null, new c());
        if (routeRequestBuildRequest != null && !TextUtils.isEmpty(routeRequestBuildRequest.getRawUrl())) {
            h(routeRequestBuildRequest, jCurrentTimeMillis);
            i(routeRequestBuildRequest.getRawUrl(), routeRequestBuildRequest);
            buildTradeContext(context, null, alibcShowParams, alibcTaokeParams, map);
            HandlerCenter.getInstance().route(routeRequestBuildRequest, AlibcTradeContext.getInstance(), new d(alibcTradeCallback, jSONObject), null);
        }
    }

    public static synchronized void openByCode(Context context, String str, AlibcBizParams alibcBizParams, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        AlibcTradeSDK.checkIsInit(AlibcTradeCommon.sApplication, new e(context, str, alibcBizParams, alibcShowParams, alibcTaokeParams, map, alibcTradeCallback));
    }

    public static synchronized void openByCodeOld(Context context, String str, AlibcBizParams alibcBizParams, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        AlibcBizParams alibcBizParams2;
        if (tga.getInitState() == 0) {
            alibcTradeCallback.onFailure(1500, AlibcProtocolConstant.SDK_NOT_INITIALIZED_MSG);
            HashMap map2 = new HashMap();
            map2.put("errorMsg", "SDK没有初始化");
            map2.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SDK_NOT_INITIALIZED);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@SDK_NOT_INITIALIZED", "BC_API_CALL", "SDK没有初始化", map2);
            return;
        }
        if (tga.getInitState() == 3) {
            alibcTradeCallback.onFailure(1600, AlibcProtocolConstant.SDK_INITIAL_FAIL_MSG);
            HashMap map3 = new HashMap();
            map3.put("errorMsg", "SDK初始化失败");
            map3.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.SDK_INITIAL_FAIL);
            AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@SDK_INITIAL_FAIL", "BC_API_CALL", "SDK初始化失败", map3);
            return;
        }
        if (alibcTradeCallback == null) {
            alibcTradeCallback = new f();
        }
        AlibcTradeCallback alibcTradeCallback2 = alibcTradeCallback;
        ((IAlibcToolProxy) AlibcProxy.get(IAlibcToolProxy.class)).startTraceLogcat(context);
        g(alibcTaokeParams);
        if (alibcBizParams == null) {
            alibcBizParams2 = new AlibcBizParams();
            alibcBizParams2.setExtParams(new HashMap());
        } else {
            if (alibcBizParams.getExtParams() == null) {
                alibcBizParams.setExtParams(new HashMap());
            }
            alibcBizParams2 = alibcBizParams;
        }
        if (AlibcBizConstant.LIVE_ROOM_SUITE_CODE.equals(str)) {
            Map<String, String> extParams = alibcBizParams2.getExtParams();
            if (extParams != null) {
                String str2 = extParams.get("id");
                if (TextUtils.isEmpty(str2) || "null".equals(str2)) {
                    HashMap map4 = new HashMap();
                    map4.put("errorMsg", "直播间套件的直播间id为空");
                    map4.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.BIZ_PARAM_ERROR);
                    AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@CHECK_BIZEPARAM_FAIL", "BC_API_CALL", "直播间套件的直播间id为空", map4);
                }
            }
        } else if (AlibcBizConstant.DETAIL_SUITE_CODE.equals(str)) {
            String id = alibcBizParams2.getId();
            if (TextUtils.isEmpty(id) || "null".equals(id)) {
                HashMap map5 = new HashMap();
                map5.put("errorMsg", "详情套件的详情id为空");
                map5.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.BIZ_PARAM_ERROR);
                AlibcLogger.errorLog("baichuan", "OPEN_BY_CODE@CHECK_BIZEPARAM_FAIL", "BC_API_CALL", "详情套件的详情id为空", map5);
            }
        }
        c(context);
        d(context, str, alibcBizParams, alibcShowParams, alibcTaokeParams, map, alibcTradeCallback2);
    }

    public static synchronized void openByUrl(Context context, String str, AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, Map<String, String> map, AlibcTradeCallback alibcTradeCallback) {
        AlibcTradeSDK.checkIsInit(AlibcTradeCommon.sApplication, new a(context, str, alibcShowParams, alibcTaokeParams, map, alibcTradeCallback));
    }
}
