package com.alibaba.alibcprotocol.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.TypedValue;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.business.a;
import com.alibaba.alibcprotocol.extension.ParamInterceptorCenter;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.param.AlibcDegradeType;
import com.alibaba.alibcprotocol.param.AlibcShowParams;
import com.alibaba.alibcprotocol.param.AlibcTaokeParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ActionDO;
import com.alibaba.alibcprotocol.route.model.BizPatternDO;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.FuncDO;
import com.alibaba.alibcprotocol.route.model.MiscDO;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibcprotocol.route.model.SuiteDO;
import com.alibaba.alibcprotocol.route.model.UrlTypeDO;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.quv.AbsServerManager;
import com.zj.adlib.xh9;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcProtocolUtils {
    public static final String APPLINK_INTERCEPTOR_CLASS = "com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor";
    public static final String H5_INTERCEPTOR_CLASS = "com.alibaba.alibcwebview.AlibcH5Interceptor";
    public static final String LOGIN_INTERCEPTOR_CLASS = "com.alibaba.alibclogin.interceptor.AlibcLoginInterceptor";
    public static final String UCC_LOGIN_INTERCEPTOR_CLASS = "com.alibaba.alibcucclogin.interceptor.AlibcUccLoginInterceptor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23636a = "AlibcProtocolUtils";

    private static boolean a(SharedPreferences sharedPreferences) {
        try {
            long j = sharedPreferences.getLong(AlibcCommonConstant.BC_LAUNCH_START_TIME, 0L);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (System.currentTimeMillis() - j <= 86400000) {
                return true;
            }
            editorEdit.putLong(AlibcCommonConstant.BC_LAUNCH_START_TIME, System.currentTimeMillis()).apply();
            return false;
        } catch (Throwable th) {
            AlibcLogger.e(f23636a, "sp operation exception: " + th.getMessage());
            return false;
        }
    }

    public static void addBizParams(Bundle bundle, AlibcBizParams alibcBizParams) {
        Map<String, String> extParams;
        if (alibcBizParams == null || (extParams = alibcBizParams.getExtParams()) == null) {
            return;
        }
        for (Map.Entry<String, String> entry : extParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                bundle.putString(key, value);
            }
        }
    }

    public static void addShowParams(Bundle bundle, AlibcShowParams alibcShowParams) {
        if (alibcShowParams != null) {
            bundle.putString("backUrl", alibcShowParams.getBackUrl());
            bundle.putSerializable("openType", alibcShowParams.getOpenType());
            bundle.putString("title", alibcShowParams.getTitle());
            bundle.putSerializable("clientType", TextUtils.isEmpty(alibcShowParams.getClientType()) ? "taobao" : alibcShowParams.getClientType());
            AlibcDegradeType degradeType = getDegradeType(alibcShowParams);
            String degradeUrl = getDegradeUrl(alibcShowParams, degradeType, alibcShowParams.getClientType());
            bundle.putSerializable("degradeType", degradeType);
            bundle.putString("degradeH5Url", degradeUrl);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void addTaokeParams(Map<String, String> map, AlibcTaokeParams alibcTaokeParams) {
        HashMap map2 = new HashMap(16);
        a(map2, alibcTaokeParams);
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    public static boolean allowLaunch() {
        MiscDO misc;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        return config == null || (misc = config.getMisc()) == null || !"0".equals(misc.getAl());
    }

    private static int b() {
        MiscDO miscDOA = a();
        if (miscDOA == null) {
            return 0;
        }
        String launchTimes = miscDOA.getLaunchTimes();
        try {
            return Integer.parseInt(launchTimes);
        } catch (NumberFormatException unused) {
            AlibcLogger.e(f23636a, "launchTimes format illegal: " + launchTimes);
            return 0;
        }
    }

    public static void buildTaokeParams(AlibcTaokeParams alibcTaokeParams, Map<String, Object> map) {
        a(map, alibcTaokeParams);
    }

    private static boolean c(String str, String str2) {
        String[] strArrSplit = str2.split("&");
        boolean z = false;
        boolean z2 = false;
        for (String str3 : str.split("&")) {
            for (String str4 : strArrSplit) {
                if (str4.equals(str3) && str4.contains("pageId=")) {
                    z = true;
                }
                if (str4.equals(str3) && str4.contains("pagePath=")) {
                    z2 = true;
                }
            }
        }
        return z && z2;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        if (i2 == 0 || i == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iRound = Math.round(i3 / i2);
        int iRound2 = Math.round(i4 / i);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static boolean checkNative(RouteRequest routeRequest) {
        List<ActionDO> actionList;
        if (allowLaunch() && !verifyInSuite(routeRequest) && (actionList = routeRequest.getActionList()) != null && actionList.size() > 0) {
            Iterator<ActionDO> it = actionList.iterator();
            while (it.hasNext()) {
                if ("native".equals(it.next().getOpenType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void convertUrl(String str, NetworkRequestListener networkRequestListener) {
        a aVar = new a();
        Map<String, Object> jSONObject = new JSONObject();
        jSONObject.put("url", (Object) str);
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, AlibcTradeContext.getInstance().taokeParams);
        jSONObject2.put("sourceType", (Object) "miniapp");
        jSONObject2.put("appkey", (Object) AlibcBaseTradeCommon.getAppKey());
        jSONObject.put(LoginConstants.EXT, (Object) jSONObject2);
        aVar.sendRequest(jSONObject, networkRequestListener);
    }

    public static int dp2px(int i, Context context) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a1 A[Catch: Exception -> 0x010b, all -> 0x0125, TryCatch #0 {Exception -> 0x010b, blocks: (B:17:0x0070, B:19:0x0076, B:21:0x007c, B:23:0x008c, B:25:0x0096, B:27:0x00a6, B:29:0x00ac, B:26:0x00a1), top: B:39:0x0070, outer: #1 }] */
    public static synchronized void executePreLaunch(Context context, String str, final long j) {
        List arrayList;
        Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.alibaba.alibcprotocol.utils.AlibcProtocolUtils.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message == null) {
                    AlibcLogger.e(AlibcProtocolUtils.f23636a, "trigger launch fail");
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_LAUNCH_TB, "", "", new JSONObject());
                    return;
                }
                AlibcLogger.i(AlibcProtocolUtils.f23636a, "tb launch result: " + message.arg1);
                long jCurrentTimeMillis = System.currentTimeMillis() - j;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.LAUNCH_TB, (Object) Integer.valueOf(message.arg1));
                jSONObject.put("costTime", (Object) Long.valueOf(jCurrentTimeMillis));
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_LAUNCH_TB, "", "", jSONObject);
            }
        };
        MiscDO miscDOA = a();
        if (!(miscDOA != null ? "YES".equalsIgnoreCase(miscDOA.getLaunchSwitch()) : false)) {
            AlibcLogger.i(f23636a, "launch switch is off");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(AlibcCommonConstant.BC_LAUNCH_GROUP, 0);
        if (!a(sharedPreferences)) {
            context.getSharedPreferences(AlibcCommonConstant.BC_LAUNCH_GROUP, 0).edit().putInt(AlibcCommonConstant.BC_LAUNCH_COUNT, 0).apply();
        }
        int i = sharedPreferences.getInt(AlibcCommonConstant.BC_LAUNCH_COUNT, 0);
        int iB = b();
        AlibcLogger.i(f23636a, "current times: " + i + ", config times: " + iB);
        if (i < iB) {
            try {
                if (Build.VERSION.SDK_INT <= 28 || AlibcCommonUtils.isForeGround(context, str)) {
                    String lowerCase = Build.BRAND.trim().toLowerCase();
                    MiscDO miscDOA2 = a();
                    if (miscDOA2 != null) {
                        String launchExBrand = miscDOA2.getLaunchExBrand();
                        if (TextUtils.isEmpty(launchExBrand)) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = Arrays.asList(launchExBrand.split(","));
                        }
                    } else {
                        arrayList = new ArrayList();
                    }
                    if (!arrayList.contains(lowerCase)) {
                        Intent intent = new Intent();
                        ComponentName componentName = new ComponentName(AlibcProtocolConstant.APPLINK_PACKAGE_NAME, "com.taobao.adaemon.NewTriggerActivity");
                        Bundle bundle = new Bundle();
                        bundle.putString("origin", context.getPackageName());
                        bundle.putInt("type", 1);
                        bundle.putInt(xh9.WEBSITE_PARAMS_CHANNEL, 1);
                        bundle.putBoolean("main", true);
                        bundle.putBinder(AbsServerManager.BUNDLE_BINDER, new Messenger(handler).getBinder());
                        intent.putExtras(bundle);
                        intent.setComponent(componentName);
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        context.getSharedPreferences(AlibcCommonConstant.BC_LAUNCH_GROUP, 0).edit().putInt(AlibcCommonConstant.BC_LAUNCH_COUNT, i + 1).apply();
                    }
                }
            } catch (Exception e) {
                AlibcLogger.e(f23636a, "pre launch exception: " + e.getMessage());
            }
        }
    }

    public static String getApplinkType(boolean z, boolean z2) {
        if (z) {
            return z2 ? "0" : "1";
        }
        return z2 ? "2" : "3";
    }

    public static String getBizType(String str) {
        List<BizPatternDO> bizPattern;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null || (bizPattern = config.getBizPattern()) == null || bizPattern.size() <= 0) {
            return "";
        }
        for (BizPatternDO bizPatternDO : bizPattern) {
            String bizCode = bizPatternDO.getBizCode();
            if (urlCheck(bizPatternDO.getPattern(), str)) {
                return bizCode;
            }
        }
        return "";
    }

    public static AlibcDegradeType getDegradeType(AlibcShowParams alibcShowParams) {
        MiscDO misc;
        AlibcDegradeType alibcDegradeType = AlibcDegradeType.Download;
        if (alibcShowParams != null && alibcShowParams.getDegradeType() != null) {
            return alibcShowParams.getDegradeType();
        }
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null || (misc = config.getMisc()) == null) {
            return alibcDegradeType;
        }
        String failMode = misc.getFailMode();
        if ("H5".equals(failMode)) {
            return AlibcDegradeType.H5;
        }
        return "NONE".equals(failMode) ? AlibcDegradeType.NONE : alibcDegradeType;
    }

    public static String getDegradeUrl(AlibcShowParams alibcShowParams, AlibcDegradeType alibcDegradeType, String str) {
        String degradeUrl = alibcShowParams.getDegradeUrl();
        if (!TextUtils.isEmpty(degradeUrl) || !AlibcDegradeType.H5.equals(alibcDegradeType)) {
            return degradeUrl;
        }
        AlibcDegradeType alibcDegradeType2 = AlibcDegradeType.Download;
        if ("taobao".equals(str)) {
            return AlibcProtocolConstant.TAOBAO_CLIENT_URL;
        }
        return "tmall".equals(str) ? AlibcProtocolConstant.TMALL_CLIENT_URL : degradeUrl;
    }

    public static List<String> getSuiteList() {
        List<SuiteDO> suites;
        PageDO page = AlibcConfigService.getInstance().getPage();
        ArrayList arrayList = new ArrayList();
        if (page != null && (suites = page.getSuites()) != null) {
            for (SuiteDO suiteDO : suites) {
                String code = suiteDO.getCode();
                String type = suiteDO.getType();
                Iterator<FuncDO> it = suiteDO.getFuncs().iterator();
                while (it.hasNext()) {
                    String code2 = it.next().getCode();
                    if ("dynamic_miniapp".equals(type)) {
                        if (!TextUtils.isEmpty(code) && !TextUtils.isEmpty(code2)) {
                            arrayList.add("suite://" + code + WVNativeCallbackUtil.SEPERATER + code2);
                        }
                    } else if (!TextUtils.isEmpty(code2)) {
                        arrayList.add(code2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static String handleShopUrl(String str, String str2) {
        AlibcBizParams alibcBizParams;
        if (!"shop".equals(str2) || (alibcBizParams = AlibcTradeContext.getInstance().bizParams) == null) {
            return str;
        }
        String sellerId = alibcBizParams.getSellerId();
        if (!str.contains("shop_id")) {
            return str;
        }
        return str.replaceFirst("shop_id=\\d+", "user_id=" + sellerId);
    }

    public static boolean matchUrl(String str, String str2) {
        Uri uri = Uri.parse(str2);
        String queryParameter = uri.getQueryParameter(TRiverConstants.KEY_APP_ID);
        String queryParameter2 = uri.getQueryParameter("page");
        String queryParameter3 = uri.getQueryParameter("query");
        Uri uri2 = Uri.parse(str);
        String queryParameter4 = uri2.getQueryParameter(TRiverConstants.KEY_APP_ID);
        String queryParameter5 = uri2.getQueryParameter("page");
        String queryParameter6 = uri2.getQueryParameter("query");
        byte b = (TextUtils.isEmpty(queryParameter2) || TextUtils.isEmpty(queryParameter3)) ? (byte) -1 : (byte) 3;
        if (TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter3)) {
            b = 2;
        }
        if (!TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
            b = 1;
        }
        if (TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
            b = 0;
        }
        if (!TextUtils.isEmpty(queryParameter4) && !TextUtils.isEmpty(queryParameter) && queryParameter4.equals(queryParameter)) {
            if (3 == b) {
                if (!TextUtils.isEmpty(queryParameter5) && !TextUtils.isEmpty(queryParameter6)) {
                    return c(queryParameter3, queryParameter6) & b(queryParameter2, queryParameter5);
                }
            } else {
                if (2 == b) {
                    if (TextUtils.isEmpty(queryParameter6)) {
                        return false;
                    }
                    return c(queryParameter3, queryParameter6);
                }
                if (1 == b && !TextUtils.isEmpty(queryParameter5)) {
                    return b(queryParameter2, queryParameter5);
                }
            }
        }
        return false;
    }

    public static Map<String, Object> obj2Map(AlibcShowParams alibcShowParams, AlibcTaokeParams alibcTaokeParams, String str, boolean z, Bundle bundle) {
        Set<String> setKeySet;
        HashMap map = new HashMap(16);
        if ("detail".equals(str)) {
            map.put("module", "detail");
        } else if ("shop".equals(str)) {
            map.put("module", "shop");
        } else {
            map.put("module", "h5");
        }
        if (!z) {
            if (alibcShowParams != null) {
                String clientType = TextUtils.isEmpty(alibcShowParams.getClientType()) ? "taobao" : alibcShowParams.getClientType();
                AlibcDegradeType degradeType = getDegradeType(alibcShowParams);
                String degradeUrl = getDegradeUrl(alibcShowParams, degradeType, clientType);
                map.put("degradeType", degradeType);
                map.put("backUrl", alibcShowParams.getBackUrl());
                map.put("degradeH5Url", degradeUrl);
                map.put("clientType", clientType);
            }
            buildTaokeParams(alibcTaokeParams, map);
        } else if (bundle != null && (setKeySet = bundle.keySet()) != null && setKeySet.size() > 0) {
            for (String str2 : setKeySet) {
                Object obj = bundle.get(str2);
                if (!TextUtils.isEmpty(str2) && obj != null) {
                    map.put(str2, obj);
                }
            }
        }
        return map;
    }

    public static Map<String, Object> parseParams(String str) {
        try {
            return (Map) JSON.toJavaObject(JSON.parseObject(str), Map.class);
        } catch (Exception unused) {
            try {
                AlibcLogger.e(f23636a, "isInstall parse params error, params: " + str);
                int length = str.length();
                if ("} bc_hybrid:".equals(str.substring(length - 12, length))) {
                    String strSubstring = str.substring(0, length - 11);
                    try {
                        return (Map) JSON.toJavaObject(JSON.parseObject(strSubstring), Map.class);
                    } catch (Exception unused2) {
                        AlibcLogger.e(f23636a, "isInstall parse params error, params: " + strSubstring);
                        return null;
                    }
                }
                return null;
            } catch (Throwable th) {
                AlibcLogger.e(f23636a, th.getMessage());
                return null;
            }
        }
    }

    public static String parseTriverParam(String str, String str2) {
        return Uri.parse(Uri.parse(str).getQueryParameter("page")).getQueryParameter(str2);
    }

    public static String reAssembleUrl(String str, Map<String, String> map, boolean z, Map<String, Object> map2) throws Exception {
        if (TextUtils.isEmpty(str) || !(str.contains("page=") || str.contains("query="))) {
            AlibcLogger.e(f23636a, "url is empty or url is invalid miniapp without 'page=' or 'query'");
            throw new Exception("url is empty or url is invalid miniapp without 'page=' or 'query='");
        }
        if (map == null || map.size() <= 0) {
            AlibcLogger.e(f23636a, "params is empty, do not need to be assembled");
            return str;
        }
        if (str.contains("?")) {
            return a(str, map, z, map2);
        }
        AlibcLogger.e(f23636a, "url is invalid without key-value pairs!");
        throw new Exception("url is invalid without key-value pairs!");
    }

    public static void sendTraceLog(boolean z, String str, String str2, String str3, String str4, Map<String, String> map) {
        if (z) {
            AlibcLogger.flowLog(str, str2, str3, str4, map);
        } else {
            AlibcLogger.errorLog(str, str2, str3, str4, map);
        }
    }

    public static boolean urlCheck(String[] strArr, String str) {
        return AlibcUrlCheck.regularCheck(strArr, str);
    }

    public static boolean verifyAppInstalled(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean verifyInSuite(RouteRequest routeRequest) {
        List<ActionDO> actionList;
        if (routeRequest == null || (actionList = routeRequest.getActionList()) == null || actionList.size() <= 0) {
            return false;
        }
        for (ActionDO actionDO : actionList) {
            if ("native".equals(actionDO.getOpenType())) {
                String targetPath = actionDO.getParam().getTargetPath();
                return !TextUtils.isEmpty(targetPath) ? a(targetPath, routeRequest.getPageType()) : a(routeRequest.getRawUrl(), routeRequest.getPageType());
            }
        }
        return false;
    }

    public static boolean verifyMiniappUrl(AlibcShowParams alibcShowParams, String str) {
        if (alibcShowParams == null) {
            return false;
        }
        String degradeUrl = alibcShowParams.getDegradeUrl();
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null) {
            return false;
        }
        for (UrlTypeDO urlTypeDO : config.getUrlTypeConfig()) {
            String[] pattern = urlTypeDO.getPattern();
            if ("miniapp".equals(urlTypeDO.getType()) && AlibcUrlCheck.regularCheck(pattern, degradeUrl)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.ERROR_TYPE, (Object) "1");
                if ("url".equals(str)) {
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_URL, "1200", AlibcProtocolConstant.URL_IS_MINIAPP_MSG, jSONObject);
                    return true;
                }
                if ("code".equals(str)) {
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_OPEN_BY_CODE, "1200", AlibcProtocolConstant.URL_IS_MINIAPP_MSG, jSONObject);
                    return true;
                }
                if (!AlibcProtocolConstant.CALL_TYPE_COMPONENT.equals(str)) {
                    return true;
                }
                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_GET_COMPONENT_BY_CODE, "1200", AlibcProtocolConstant.URL_IS_MINIAPP_MSG, jSONObject);
                return true;
            }
        }
        return false;
    }

    public static boolean verifySignValid(String str, String str2) {
        String mD5Sign = AlibcCommonUtils.getMD5Sign(str2);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(mD5Sign);
    }

    public static void addTaokeParams(Bundle bundle, AlibcTaokeParams alibcTaokeParams) {
        HashMap map = new HashMap(16);
        a(map, alibcTaokeParams);
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    private static boolean b(String str, String str2) {
        int iIndexOf = str2.indexOf("?");
        if (-1 != iIndexOf) {
            str2 = str2.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf("?");
        if (-1 != iIndexOf2) {
            str = str.substring(0, iIndexOf2);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(str2);
    }

    private static MiscDO a() {
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config != null) {
            return config.getMisc();
        }
        return null;
    }

    private static boolean a(String str, String str2) {
        List<SuiteDO> suites;
        PageDO page = AlibcConfigService.getInstance().getPage();
        if (page == null || (suites = page.getSuites()) == null || suites.size() <= 0) {
            return false;
        }
        Iterator<SuiteDO> it = suites.iterator();
        while (it.hasNext()) {
            for (FuncDO funcDO : it.next().getFuncs()) {
                if ("miniapp".equals(str2)) {
                    if (matchUrl(str, funcDO.getBaseUrl())) {
                        return true;
                    }
                } else {
                    String baseUrl = funcDO.getBaseUrl();
                    Uri uri = Uri.parse(str);
                    String authority = uri.getAuthority();
                    String path = uri.getPath();
                    String scheme = uri.getScheme();
                    StringBuilder sb = new StringBuilder(50);
                    sb.append(scheme);
                    sb.append("://");
                    sb.append(authority);
                    sb.append(path);
                    if (sb.toString().equals(baseUrl)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void b(Uri uri, Map<String, String> map, StringBuilder sb, boolean z, Map<String, Object> map2) {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("page=");
        StringBuilder sb3 = new StringBuilder(50);
        String queryParameter = uri.getQueryParameter("page");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        if (queryParameter.contains(PluginParamModel.PLUGIN_PAGE_PREFIX)) {
            sb3.append(queryParameter.substring(0, queryParameter.indexOf("?") + 1));
            String query = Uri.parse(queryParameter).getQuery();
            if (!TextUtils.isEmpty(query)) {
                sb3.append(query);
                ArrayList arrayList = new ArrayList();
                for (String str : query.split("&")) {
                    arrayList.add(str.split("=")[0]);
                }
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!arrayList.contains(key)) {
                            sb3.append("&");
                            sb3.append(key);
                            sb3.append("=");
                            sb3.append(Uri.encode(value, "utf-8"));
                        }
                    }
                }
                String string = sb3.toString();
                if (z) {
                    string = ParamInterceptorCenter.interceptParams(string, map2);
                }
                sb2.append(URLEncoder.encode(string, "UTF-8"));
            } else {
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        sb3.append(entry2.getKey());
                        sb3.append("=");
                        sb3.append(Uri.encode(entry2.getValue(), "utf-8"));
                        sb3.append("&");
                    }
                }
                String string2 = sb3.toString();
                if (z) {
                    string2 = ParamInterceptorCenter.interceptParams(string2, map2);
                }
                sb2.append(URLEncoder.encode(string2.substring(0, string2.length() - 1), "UTF-8"));
            }
        } else {
            sb3.append(queryParameter);
            if (!queryParameter.contains("?")) {
                sb3.append("?");
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry3 : map.entrySet()) {
                        sb3.append(entry3.getKey());
                        sb3.append("=");
                        sb3.append(Uri.encode(entry3.getValue(), "utf-8"));
                        sb3.append("&");
                    }
                }
                String string3 = sb3.toString();
                if (z) {
                    string3 = ParamInterceptorCenter.interceptParams(string3, map2);
                }
                sb2.append(URLEncoder.encode(string3.substring(0, string3.length() - 1), "UTF-8"));
            } else {
                String strSubstring = queryParameter.substring(queryParameter.indexOf("?") + 1);
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : strSubstring.split("&")) {
                    arrayList2.add(str2.split("=")[0]);
                }
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry4 : map.entrySet()) {
                        String key2 = entry4.getKey();
                        String value2 = entry4.getValue();
                        if (!arrayList2.contains(key2)) {
                            sb3.append("&");
                            sb3.append(key2);
                            sb3.append("=");
                            sb3.append(Uri.encode(value2, "utf-8"));
                        }
                    }
                }
                String string4 = sb3.toString();
                if (z) {
                    string4 = ParamInterceptorCenter.interceptParams(string4, map2);
                }
                sb2.append(URLEncoder.encode(string4, "UTF-8"));
            }
        }
        sb.append(sb2.toString());
        sb.append("&");
    }

    public static boolean verifyMiniappUrl(String str) {
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null) {
            return false;
        }
        for (UrlTypeDO urlTypeDO : config.getUrlTypeConfig()) {
            String[] pattern = urlTypeDO.getPattern();
            if ("miniapp".equals(urlTypeDO.getType()) && AlibcUrlCheck.regularCheck(pattern, str)) {
                return true;
            }
        }
        return false;
    }

    private static String a(String str, Map<String, String> map, boolean z, Map<String, Object> map2) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, str.indexOf("?") + 1));
        Uri uri = Uri.parse(str);
        String encodedQuery = uri.getEncodedQuery();
        if (!TextUtils.isEmpty(encodedQuery)) {
            for (String str2 : encodedQuery.split("&")) {
                if (str2.contains("page=")) {
                    b(uri, map, sb, z, map2);
                } else if (str2.contains("query=")) {
                    a(uri, map, sb, z, map2);
                } else {
                    sb.append(str2);
                    sb.append("&");
                }
            }
            return sb.substring(0, sb.length() - 1);
        }
        throw new Exception("url is invalid! url = " + str);
    }

    private static void a(Uri uri, Map<String, String> map, StringBuilder sb, boolean z, Map<String, Object> map2) {
        StringBuilder sb2 = new StringBuilder(50);
        String queryParameter = uri.getQueryParameter("query");
        sb2.append(queryParameter);
        ArrayList arrayList = new ArrayList();
        for (String str : queryParameter.split("&")) {
            arrayList.add(str.split("=")[0]);
        }
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!arrayList.contains(key)) {
                    sb2.append("&");
                    sb2.append(key);
                    sb2.append("=");
                    sb2.append(value);
                }
            }
        }
        String string = sb2.toString();
        if (z) {
            string = ParamInterceptorCenter.interceptParams(string, map2);
        }
        sb.append("query=" + URLEncoder.encode(string, "UTF-8"));
        sb.append("&");
    }

    private static void a(Map<String, Object> map, AlibcTaokeParams alibcTaokeParams) {
        if (alibcTaokeParams != null) {
            if (!TextUtils.isEmpty(alibcTaokeParams.pid)) {
                map.put("pid", alibcTaokeParams.pid);
            }
            if (!TextUtils.isEmpty(alibcTaokeParams.subPid)) {
                map.put("subPid", alibcTaokeParams.subPid);
            }
            if (!TextUtils.isEmpty(alibcTaokeParams.unionId)) {
                map.put("unionId", alibcTaokeParams.unionId);
            }
            if (!TextUtils.isEmpty(alibcTaokeParams.relationId)) {
                map.put("relationId", alibcTaokeParams.relationId);
            }
            if (!TextUtils.isEmpty(alibcTaokeParams.materialSourceUrl)) {
                map.put("materialSourceUrl", alibcTaokeParams.materialSourceUrl);
            }
            Map<String, String> map2 = alibcTaokeParams.extParams;
            if (map2 != null) {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        map.put(key, value);
                    }
                }
            }
        }
    }
}
