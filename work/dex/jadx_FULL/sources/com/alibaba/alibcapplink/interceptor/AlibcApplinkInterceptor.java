package com.alibaba.alibcapplink.interceptor;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.alibcapplink.a;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.business.ParseSclickBusiness;
import com.alibaba.alibcprotocol.business.TBLiteJudgeBusiness;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.manager.AlibcInterceptCenter;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.model.ActionDO;
import com.alibaba.alibcprotocol.route.model.ParamDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcApplinkInterceptor implements AlibcInterceptCenter.IUrlInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23556a = "AlibcApplinkInterceptor";
    private boolean b = true;
    private Activity c;

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> b(String str) {
        HashMap map = new HashMap(16);
        map.put("clickId", str);
        return map;
    }

    @Override // com.alibaba.alibcprotocol.manager.AlibcInterceptCenter.IUrlInterceptor
    public boolean interceptor(final RouteRequest routeRequest, final Bundle bundle) {
        boolean z;
        final String str;
        String triverParam;
        ParamDO param;
        if (routeRequest == null) {
            return false;
        }
        final AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
        WeakReference<Activity> weakReference = alibcTradeContext.mActivity;
        Activity activity = weakReference != null ? weakReference.get() : null;
        this.c = activity;
        if (activity == null) {
            WeakReference<Activity> weakReference2 = alibcTradeContext.mRawActivity;
            Activity activity2 = weakReference2 != null ? weakReference2.get() : null;
            this.c = activity2;
            if (activity2 == null) {
                AlibcLogger.i(f23556a, "activity is null");
                return false;
            }
        }
        if (!AlibcProtocolUtils.allowLaunch() || AlibcProtocolUtils.verifyInSuite(routeRequest)) {
            return false;
        }
        if (!AlibcSdkManager.getInstance().verifySdkExist("applink_sdk")) {
            AlibcLogger.e(f23556a, "applink sdk not exist");
            return false;
        }
        List<ActionDO> actionList = routeRequest.getActionList();
        if (actionList == null || actionList.size() <= 0) {
            return false;
        }
        Iterator<ActionDO> it = actionList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if ("native".equals(it.next().getOpenType())) {
                z = true;
                break;
            }
        }
        if (!z) {
            return false;
        }
        final String bizType = routeRequest.getBizType();
        final boolean zEquals = "miniapp".equals(routeRequest.getPageType());
        alibcTradeContext.showParams.setClientType("taobao");
        String rawUrl = routeRequest.getRawUrl();
        Iterator<ActionDO> it2 = actionList.iterator();
        loop1: while (true) {
            str = rawUrl;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                ActionDO next = it2.next();
                if ("native".equals(next.getOpenType()) && (param = next.getParam()) != null) {
                    rawUrl = param.getTargetPath();
                    if (!TextUtils.isEmpty(rawUrl)) {
                        break;
                    }
                }
            }
        }
        if ("detail".equals(bizType) || "shop".equals(bizType)) {
            if (zEquals) {
                try {
                    triverParam = AlibcProtocolUtils.parseTriverParam(str, AlibcProtocolConstant.RECOVER_ID);
                } catch (Exception unused) {
                    AlibcLogger.e(f23556a, "[ApplinkInterceptor]url is invalid");
                }
            } else {
                triverParam = "";
            }
            String strB = b(zEquals, str, bizType, b(zEquals ? ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(str, true) : ""));
            if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                a(zEquals, bizType, strB, triverParam, routeRequest, alibcTradeContext, bundle);
            } else {
                a(routeRequest, strB, alibcTradeContext, zEquals, false, bundle);
            }
        } else if ("taobaolite".equals(bizType)) {
            String strA = a.a(Uri.parse(str).getQueryParameter("id"));
            TBLiteJudgeBusiness tBLiteJudgeBusiness = new TBLiteJudgeBusiness();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ALPParamConstant.ITMEID, (Object) strA);
            tBLiteJudgeBusiness.sendRequest(jSONObject, new NetworkRequestListener() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.1
                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onError(int i, NetworkResponse networkResponse) {
                    String str2 = networkResponse.errorCode;
                    String str3 = networkResponse.errorMsg;
                    AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "code=" + str2 + ", msg=" + str3);
                    try {
                        String triverParam2 = zEquals ? AlibcProtocolUtils.parseTriverParam(str, AlibcProtocolConstant.RECOVER_ID) : "";
                        String strB2 = AlibcApplinkInterceptor.b(zEquals, str, bizType, AlibcApplinkInterceptor.b(zEquals ? ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(str, true) : ""));
                        if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                            AlibcApplinkInterceptor.this.a(zEquals, bizType, strB2, triverParam2, routeRequest, alibcTradeContext, bundle);
                        } else {
                            AlibcApplinkInterceptor.this.a(routeRequest, strB2, alibcTradeContext, zEquals, false, bundle);
                        }
                    } catch (Exception unused2) {
                    }
                }

                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onSuccess(int i, NetworkResponse networkResponse) {
                    String strValueOf = String.valueOf(networkResponse.data.get("data"));
                    if (!"taobaolite".equals(strValueOf)) {
                        try {
                            String triverParam2 = zEquals ? AlibcProtocolUtils.parseTriverParam(str, AlibcProtocolConstant.RECOVER_ID) : "";
                            String strB2 = AlibcApplinkInterceptor.b(zEquals, str, bizType, AlibcApplinkInterceptor.b(zEquals ? ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(str, true) : ""));
                            if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                                AlibcApplinkInterceptor.this.a(zEquals, bizType, strB2, triverParam2, routeRequest, alibcTradeContext, bundle);
                                return;
                            } else {
                                AlibcApplinkInterceptor.this.a(routeRequest, strB2, alibcTradeContext, zEquals, false, bundle);
                                return;
                            }
                        } catch (Exception unused2) {
                            AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "[ApplinkInterceptor]url is invalid");
                            return;
                        }
                    }
                    try {
                        String triverParam3 = zEquals ? AlibcProtocolUtils.parseTriverParam(str, AlibcProtocolConstant.RECOVER_ID) : "";
                        String strB3 = AlibcApplinkInterceptor.b(zEquals, str, bizType, AlibcApplinkInterceptor.b(zEquals ? ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(str, true) : ""));
                        alibcTradeContext.showParams.setClientType(strValueOf);
                        if (AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
                            AlibcApplinkInterceptor.this.a(zEquals, bizType, strB3, triverParam3, routeRequest, alibcTradeContext, bundle);
                        } else {
                            AlibcApplinkInterceptor.this.a(routeRequest, strB3, alibcTradeContext, zEquals, false, bundle);
                        }
                    } catch (Exception unused3) {
                        AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "[ApplinkInterceptor]url is invalid");
                    }
                }
            });
        } else if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.SCLICK_URL_PATTERNS, str)) {
            ParseSclickBusiness parseSclickBusiness = new ParseSclickBusiness();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("floorId", (Object) "43676");
            HashMap map = new HashMap();
            map.put("invokerName", "baichuan");
            if (str.startsWith("https") || str.startsWith("http")) {
                map.put("url", str);
            } else {
                map.put("url", "https:" + str);
            }
            map.put("invokeType", "MTOP");
            jSONObject2.put("variableMap", (Object) JSON.toJSONString(map));
            parseSclickBusiness.sendRequest(jSONObject2, new NetworkRequestListener() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.2
                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onError(int i, NetworkResponse networkResponse) {
                    String str2 = networkResponse.errorCode;
                    String str3 = networkResponse.errorMsg;
                    AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "code=" + str2 + ", msg=" + str3);
                    AlibcApplinkInterceptor.this.a(routeRequest, str, alibcTradeContext, zEquals, false, bundle);
                }

                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onSuccess(int i, NetworkResponse networkResponse) {
                    Map<String, Object> map2 = networkResponse.data;
                    if (map2 != null) {
                        try {
                            JSONArray jSONArray = (JSONArray) map2.get("resultList");
                            if (jSONArray != null && jSONArray.size() > 0) {
                                Iterator<Object> it3 = jSONArray.iterator();
                                while (it3.hasNext()) {
                                    JSONObject jSONObject3 = ((JSONObject) it3.next()).getJSONObject("paramMap");
                                    if (jSONObject3 != null && "103".equals(jSONObject3.getString("ut"))) {
                                        alibcTradeContext.showParams.setClientType("taobaolite");
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "parse exception: " + e);
                        }
                    }
                    AlibcApplinkInterceptor.this.a(routeRequest, str, alibcTradeContext, zEquals, false, bundle);
                }
            });
        } else {
            a(routeRequest, str, alibcTradeContext, zEquals, false, bundle);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(boolean z, String str, String str2, Map<String, String> map) {
        if (z) {
            HashMap map2 = new HashMap();
            map2.put("bizType", str2);
            return AlibcProtocolUtils.reAssembleUrl(str, map, true, map2);
        }
        return AlibcProtocolUtils.handleShopUrl(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final String str, final String str2, final String str3, final RouteRequest routeRequest, final AlibcTradeContext alibcTradeContext, final Bundle bundle) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).executeConvert(z, str, str2, str3, new CpsCommitCallback() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.3
            @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
            public final void onFail(String str4, String str5) {
                AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "convert fail: cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", code = " + str4 + ", msg = " + str5);
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str2);
                jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, str4, str5, jSONObject);
                AlibcApplinkInterceptor.this.a(routeRequest, str2, alibcTradeContext, z, false, bundle);
                HashMap map = new HashMap();
                map.put("【方法名】", "AlibcApplinkInterceptor@executeAdConvert");
                map.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                StringBuilder sb = new StringBuilder("code: ");
                sb.append(str4);
                sb.append("\nmsg: ");
                sb.append(str5);
                map.put("【返回】", sb.toString());
                AlibcProtocolUtils.sendTraceLog(true, "baichuan", "APPLINK_INTERCEPTOR@EXECUTE_ADCONVERT_FAIL", "BC_API_CALL", "执行转链", map);
            }

            @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
            public final void onSuccess(Map<String, String> map) {
                String str4 = map.get("url");
                String str5 = map.get("status");
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                AlibcLogger.i(AlibcApplinkInterceptor.f23556a, "convert success:  cost time = " + jCurrentTimeMillis2 + ", convertedUrl = " + str4 + ", status = " + str5);
                HashMap map2 = new HashMap();
                map2.put("【方法名】", "AlibcApplinkInterceptor@executeAdConvert");
                map2.put("【入参】", "url: " + str2 + "\nrecoveryId: " + str3 + "\nbizType: " + str + "\nminiappType: " + z);
                StringBuilder sb = new StringBuilder("result: ");
                sb.append(JSON.toJSONString(map));
                map2.put("【返回】", sb.toString());
                AlibcProtocolUtils.sendTraceLog(true, "baichuan", "APPLINK_INTERCEPTOR@EXECUTE_ADCONVERT_SUCCESS", "BC_API_CALL", "执行转链", map2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", (Object) str5);
                jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) str3);
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str2);
                jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                jSONObject.put(UserTrackConstant.RESULT_URL, (Object) str4);
                if (TextUtils.isEmpty(str4)) {
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, "code_empty", "url empty", jSONObject);
                    AlibcApplinkInterceptor.this.a(routeRequest, str2, alibcTradeContext, z, true, bundle);
                } else {
                    AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_UNION, "", "", jSONObject);
                    AlibcApplinkInterceptor.this.a(routeRequest, str4, alibcTradeContext, z, true, bundle);
                }
            }
        });
    }

    public static /* synthetic */ void b() {
        AlibcLogger.i(f23556a, "applink is not exist: how to handle url loading?");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final RouteRequest routeRequest, final String str, AlibcTradeContext alibcTradeContext, boolean z, boolean z2, final Bundle bundle) {
        String strDecode;
        final Map<String, Object> mapObj2Map = AlibcProtocolUtils.obj2Map(alibcTradeContext.showParams, alibcTradeContext.taokeParams, routeRequest.getBizType(), z, bundle);
        boolean zRegularCheck = AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str);
        final String applinkType = AlibcProtocolUtils.getApplinkType(z2, z);
        if (zRegularCheck) {
            ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(this.c, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.4
                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public final void getLinkUrl(boolean z3, String str2, String str3, int i) {
                    AlibcApplinkInterceptor.a(AlibcApplinkInterceptor.this, routeRequest, z3, i, str2, applinkType, str, bundle);
                    HashMap map = new HashMap();
                    map.put("【方法名】", "AlibcApplinkInterceptor@executeApplink");
                    map.put("【入参】", "url: " + str + "\nparams: " + JSON.toJSONString(mapObj2Map));
                    StringBuilder sb = new StringBuilder("targetClient: ");
                    sb.append(str2);
                    sb.append("\ncode: ");
                    sb.append(i);
                    sb.append("\nmsg: ");
                    sb.append(z3 ? "唤端成功" : "唤端失败");
                    map.put("【返回】", sb.toString());
                    if (!z3) {
                        map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.EXECUTE_APPLINK_FAIL);
                    }
                    AlibcProtocolUtils.sendTraceLog(z3, "baichuan", z3 ? "APPLINK_INTERCEPTOR@EXECUTE_APPLINK_SUCCESS" : "APPLINK_INTERCEPTOR@EXECUTE_APPLINK_FAIL", "BC_API_CALL", "执行唤端", map);
                }

                @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                public final void supportFail(String str2, String str3) {
                    AlibcApplinkInterceptor.b();
                }
            });
            return;
        }
        if (z && !z2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            AlibcProtocolUtils.convertUrl(str, new NetworkRequestListener() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.5
                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onError(int i, NetworkResponse networkResponse) {
                    AlibcLogger.e(AlibcApplinkInterceptor.f23556a, "covert fail: code = " + networkResponse.errorCode + ", msg = " + networkResponse.errorMsg);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                    jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, networkResponse.errorCode, networkResponse.errorMsg, jSONObject);
                    ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(AlibcApplinkInterceptor.this.c, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.5.2
                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void getLinkUrl(boolean z3, String str2, String str3, int i2) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            AlibcApplinkInterceptor.a(AlibcApplinkInterceptor.this, routeRequest, z3, i2, str2, applinkType, str, bundle);
                        }

                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void supportFail(String str2, String str3) {
                            AlibcApplinkInterceptor.b();
                        }
                    });
                }

                @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
                public final void onSuccess(int i, NetworkResponse networkResponse) {
                    Map<String, Object> map;
                    if (networkResponse == null || (map = networkResponse.data) == null) {
                        return;
                    }
                    final String strValueOf = String.valueOf(map.get("result"));
                    AlibcLogger.i(AlibcApplinkInterceptor.f23556a, "convert h5 url: " + strValueOf);
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis2));
                    jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) strValueOf);
                    AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, "", "", jSONObject);
                    if (TextUtils.isEmpty(strValueOf)) {
                        return;
                    }
                    ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(AlibcApplinkInterceptor.this.c, strValueOf, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.5.1
                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void getLinkUrl(boolean z3, String str2, String str3, int i2) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            AlibcApplinkInterceptor.a(AlibcApplinkInterceptor.this, routeRequest, z3, i2, str2, applinkType, strValueOf, bundle);
                        }

                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void supportFail(String str2, String str3) {
                            AlibcApplinkInterceptor.b();
                        }
                    });
                }
            });
            return;
        }
        try {
            HashMap map = new HashMap();
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme)) {
                map.put("linkKey", scheme);
            }
            String encodedQuery = uri.getEncodedQuery();
            if (!TextUtils.isEmpty(encodedQuery)) {
                for (String str2 : encodedQuery.split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length > 1) {
                        String str3 = strArrSplit[0];
                        if (ALPParamConstant.H5URL.equals(str3)) {
                            strDecode = URLDecoder.decode(strArrSplit[1], "utf-8");
                        } else {
                            strDecode = strArrSplit[1];
                        }
                        map.put(str3, strDecode);
                    }
                }
            }
            if (map.size() == 0) {
                AlibcLogger.e(f23556a, "不满足协议规范");
                return;
            }
            String str4 = (String) map.get("linkKey");
            if ("https".equals(str4) || "http".equals(str4)) {
                ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(this.c, str, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibcapplink.interceptor.AlibcApplinkInterceptor.6
                    @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                    public final void getLinkUrl(boolean z3, String str5, String str6, int i) {
                        AlibcApplinkInterceptor.a(AlibcApplinkInterceptor.this, routeRequest, z3, i, str5, applinkType, str, bundle);
                    }

                    @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                    public final void supportFail(String str5, String str6) {
                        AlibcApplinkInterceptor.b();
                    }
                });
            }
        } catch (Exception e) {
            AlibcLogger.e(f23556a, "解析协议异常: " + e.getMessage());
        }
    }

    public static /* synthetic */ void a(AlibcApplinkInterceptor alibcApplinkInterceptor, RouteRequest routeRequest, boolean z, int i, String str, String str2, String str3, Bundle bundle) {
        Activity activity;
        UserTrackUtils.sendApplinkUserTrack(null, z, i, str2, -1);
        if (z) {
            AlibcLogger.i(f23556a, "launch success");
            if (!AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str3) || (activity = alibcApplinkInterceptor.c) == null) {
                return;
            }
            activity.finish();
            return;
        }
        AlibcLogger.e(f23556a, "launch app fail: code = " + i);
        if ("taobao".equals(str)) {
            AlibcContainerManager.loadUrl(routeRequest, "h5", AlibcProtocolConstant.TAOBAO_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        } else if ("tmall".equals(str)) {
            AlibcContainerManager.loadUrl(routeRequest, "h5", AlibcProtocolConstant.TMALL_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        } else {
            AlibcContainerManager.loadUrl(routeRequest, "h5", AlibcProtocolConstant.TAOBAO_CLIENT_URL, bundle != null ? bundle.getString(RVParams.SESSION_ID) : "");
        }
    }
}
