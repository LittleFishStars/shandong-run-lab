package com.zj.adlib;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibcprotocol.BCErrorEnum;
import com.alibaba.alibcprotocol.TRiverConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.business.ParseSclickBusiness;
import com.alibaba.alibcprotocol.business.TBLiteJudgeBusiness;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.param.AlibcDegradeType;
import com.alibaba.alibcprotocol.param.OpenType;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.model.ActionDO;
import com.alibaba.alibcprotocol.route.model.ParamDO;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baichuan.nb_trade.utils.AlibcBizUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zza extends com.baichuan.nb_trade.distribute.b {
    public static final String b = "zza";
    public static String c = "";

    public class a implements NetworkRequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeContext f46374a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcComponentReRenderCallback f21129a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f21130a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ com.baichuan.nb_trade.distribute.d f21131a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f21133a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f21134a;

        public a(AlibcTradeContext alibcTradeContext, RouteRequest routeRequest, String str, boolean z, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
            this.f46374a = alibcTradeContext;
            this.f21130a = routeRequest;
            this.f21133a = str;
            this.f21134a = z;
            this.f21131a = dVar;
            this.f21129a = alibcComponentReRenderCallback;
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onError(int i, NetworkResponse networkResponse) {
            String str = networkResponse.errorCode;
            String str2 = networkResponse.errorMsg;
            AlibcLogger.e(zza.b, "code=" + str + ", msg=" + str2);
            zza.this.h(this.f21130a, this.f21133a, this.f46374a, this.f21134a, this.f21131a, this.f21129a);
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onSuccess(int i, NetworkResponse networkResponse) {
            String strValueOf = String.valueOf(networkResponse.data.get("data"));
            if ("taobaolite".equals(strValueOf)) {
                this.f46374a.showParams.setClientType(strValueOf);
            }
            zza.this.h(this.f21130a, this.f21133a, this.f46374a, this.f21134a, this.f21131a, this.f21129a);
        }
    }

    public class b implements NetworkRequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeContext f46375a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcComponentReRenderCallback f21135a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f21136a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ com.baichuan.nb_trade.distribute.d f21137a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f21139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f21140a;

        public b(AlibcTradeContext alibcTradeContext, RouteRequest routeRequest, String str, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback, boolean z) {
            this.f46375a = alibcTradeContext;
            this.f21136a = routeRequest;
            this.f21139a = str;
            this.f21137a = dVar;
            this.f21135a = alibcComponentReRenderCallback;
            this.f21140a = z;
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onError(int i, NetworkResponse networkResponse) {
            String str = networkResponse.errorCode;
            String str2 = networkResponse.errorMsg;
            AlibcLogger.e(zza.b, "code=" + str + ", msg=" + str2);
            zza.this.g(this.f21136a, this.f21139a, this.f46375a, this.f21137a, this.f21135a, this.f21140a, false);
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onSuccess(int i, NetworkResponse networkResponse) {
            Map<String, Object> map = networkResponse.data;
            if (map != null) {
                try {
                    JSONArray jSONArray = (JSONArray) map.get("resultList");
                    if (jSONArray != null && jSONArray.size() > 0) {
                        Iterator<Object> it = jSONArray.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObject = ((JSONObject) it.next()).getJSONObject("paramMap");
                            if (jSONObject != null && "103".equals(jSONObject.getString("ut"))) {
                                this.f46375a.showParams.setClientType("taobaolite");
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    AlibcLogger.e(zza.b, "parse exception: " + e);
                }
            }
            zza.this.g(this.f21136a, this.f21139a, this.f46375a, this.f21137a, this.f21135a, this.f21140a, false);
        }
    }

    public class c implements CpsCommitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f46376a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeContext f21141a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcComponentReRenderCallback f21142a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f21143a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ com.baichuan.nb_trade.distribute.d f21144a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f21146a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f21147a;

        public c(long j, String str, RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback, boolean z) {
            this.f46376a = j;
            this.f21146a = str;
            this.f21143a = routeRequest;
            this.f21141a = alibcTradeContext;
            this.f21144a = dVar;
            this.f21142a = alibcComponentReRenderCallback;
            this.f21147a = z;
        }

        @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
        public final void onFail(String str, String str2) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f46376a;
            HashMap map = new HashMap();
            map.put("【方法名】", "NativeHandler@executeAdConvert");
            map.put("【入参】", "url: " + this.f21146a + "\nrecoveryId: " + zza.c + "\nrequest: " + this.f21143a.toString());
            map.put("【返回】", "code: " + str + "\nmsg: " + str2 + "\ncost: " + jCurrentTimeMillis + "ms");
            map.put(AlibcCommonConstant.OPEN_ERROR_CODE, AlibcCommonConstant.CPS_CONVERT_URL_FAIL);
            AlibcProtocolUtils.sendTraceLog(false, "baichuan", "OPEN@EXECUTE_EXECUTE_ADCONVERT", "BC_API_CALL", "执行转链", map);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f21146a);
            jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) zza.c);
            jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, str, str2, jSONObject);
            zza.this.g(this.f21143a, this.f21146a, this.f21141a, this.f21144a, this.f21142a, this.f21147a, false);
        }

        @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
        public final void onSuccess(Map<String, String> map) {
            String str = map.get("url");
            String str2 = map.get("status");
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f46376a;
            HashMap map2 = new HashMap();
            map2.put("【方法名】", "NativeHandler@executeAdConvert");
            map2.put("【入参】", "url: " + this.f21146a + "\nrecoveryId: " + zza.c + "\nrequest: " + this.f21143a.toString());
            map2.put("【返回】", "url: " + str + "\nstatus: " + str2 + "\ncost: " + jCurrentTimeMillis + "ms");
            AlibcProtocolUtils.sendTraceLog(true, "baichuan", "OPEN@EXECUTE_ADCONVERT_SUCCESS", "BC_API_CALL", "执行转链", map2);
            if (TextUtils.isEmpty(str)) {
                boolean z = "3".equals(str2) && AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, this.f21146a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", (Object) str2);
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f21146a);
                jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) zza.c);
                jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
                AlibcUserTracker.getInstance().trackAlarm(z, UserTrackConstant.E_CONVERT_UNION, "code_empty", "empty url", jSONObject);
                zza.this.g(this.f21143a, this.f21146a, this.f21141a, this.f21144a, this.f21142a, this.f21147a, false);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", (Object) str2);
            jSONObject2.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f21146a);
            jSONObject2.put(UserTrackConstant.RECOVERY_ID, (Object) zza.c);
            jSONObject2.put(UserTrackConstant.RESULT_URL, (Object) str);
            jSONObject2.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_UNION, "", "", jSONObject2);
            zza.this.g(this.f21143a, str, this.f21141a, this.f21144a, this.f21142a, this.f21147a, true);
        }
    }

    public class d implements NetworkRequestListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f46377a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeContext f21148a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcComponentReRenderCallback f21149a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcDegradeType f21150a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f21151a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ com.baichuan.nb_trade.distribute.d f21152a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f21154a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f21155a;
        public final /* synthetic */ String b;

        public d(long j, String str, AlibcTradeContext alibcTradeContext, AlibcDegradeType alibcDegradeType, String str2, RouteRequest routeRequest, Map map, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
            this.f46377a = j;
            this.f21154a = str;
            this.f21148a = alibcTradeContext;
            this.f21150a = alibcDegradeType;
            this.b = str2;
            this.f21151a = routeRequest;
            this.f21155a = map;
            this.f21152a = dVar;
            this.f21149a = alibcComponentReRenderCallback;
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onError(int i, NetworkResponse networkResponse) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f46377a;
            AlibcLogger.e(zza.b, "covert fail: code = " + networkResponse.errorCode + ", msg = " + networkResponse.errorMsg);
            zza.this.e(this.f21148a, this.f21150a, this.b, this.f21151a, this.f21154a, this.f21155a, this.f21152a, this.f21149a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
            jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) zza.c);
            jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f21154a);
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, networkResponse.errorCode, networkResponse.errorMsg, jSONObject);
        }

        @Override // com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener
        public final void onSuccess(int i, NetworkResponse networkResponse) {
            if (networkResponse != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f46377a;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
                jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) zza.c);
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f21154a);
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_MINIAPP_TO_H5, "", "", jSONObject);
                Map<String, Object> map = networkResponse.data;
                if (map != null) {
                    String strValueOf = String.valueOf(map.get("result"));
                    AlibcLogger.i(zza.b, "convert h5 url: " + strValueOf);
                    if (TextUtils.isEmpty(strValueOf)) {
                        return;
                    }
                    zza.this.e(this.f21148a, this.f21150a, this.b, this.f21151a, strValueOf, this.f21155a, this.f21152a, this.f21149a);
                }
            }
        }
    }

    public class e implements AppLinkOpenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeContext f46378a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcComponentReRenderCallback f21156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcDegradeType f21157a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f21158a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ com.baichuan.nb_trade.distribute.d f21159a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f21161a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f21162a;
        public final /* synthetic */ String b;

        public e(AlibcDegradeType alibcDegradeType, String str, AlibcTradeContext alibcTradeContext, RouteRequest routeRequest, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback, String str2, Map map) {
            this.f21157a = alibcDegradeType;
            this.f21161a = str;
            this.f46378a = alibcTradeContext;
            this.f21158a = routeRequest;
            this.f21159a = dVar;
            this.f21156a = alibcComponentReRenderCallback;
            this.b = str2;
            this.f21162a = map;
        }

        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
        public final void getLinkUrl(boolean z, String str, String str2, int i) {
            zza.f(this.f21157a, this.f21161a, z, str2, i, this.f46378a, this.f21158a, this.f21159a, this.f21156a);
            HashMap map = new HashMap();
            map.put("【方法名】", "NativeHandler@executeApplink");
            map.put("【入参】", "url: " + this.b + "\nparams: " + JSON.toJSONString(this.f21162a));
            StringBuilder sb = new StringBuilder("targetClient: ");
            sb.append(str);
            sb.append("\ncode: ");
            sb.append(i);
            sb.append("\nmsg: ");
            sb.append(z ? "唤端成功" : "唤端失败");
            map.put("【返回】", sb.toString());
            AlibcProtocolUtils.sendTraceLog(z, "baichuan", z ? "OPEN@EXECUTE_APPLINK_SUCCESS" : "OPEN@EXECUTE_APPLINK_FAIL", "BC_API_CALL", "执行唤端", map);
        }

        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
        public final void supportFail(String str, String str2) {
            this.f21159a.a(Integer.parseInt(str), str2);
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.matches("^\\d+$")) {
            return str;
        }
        Long lAnalyseItemId = 0L;
        try {
            lAnalyseItemId = AlibcSecurityGuard.getInstance().analyseItemId(str);
        } catch (Exception e2) {
            AlibcLogger.e(b, "入参itemId=" + str + ", 异常：" + e2.getMessage());
        }
        return (lAnalyseItemId == null || lAnalyseItemId.longValue() == 0) ? str : String.valueOf(lAnalyseItemId);
    }

    public static /* synthetic */ void f(AlibcDegradeType alibcDegradeType, String str, boolean z, String str2, int i, AlibcTradeContext alibcTradeContext, RouteRequest routeRequest, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        UserTrackUtils.sendApplinkUserTrack(alibcTradeContext.trackParams, z, i, str, -1);
        if (z) {
            dVar.a(i, "call app success");
            return;
        }
        routeRequest.setLaunchApp(false);
        routeRequest.setRawUrl(str2);
        if (AlibcDegradeType.NONE.equals(alibcDegradeType)) {
            AlibcLogger.e(b, "唤端失败降级类型为NONE");
        } else {
            dVar.a(routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback);
        }
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final boolean a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext) {
        String str = b;
        AlibcLogger.i(str, "native handler execute shouldHandle");
        if (!AlibcBizUtils.assertInComponents("applink_sdk")) {
            return false;
        }
        if (!AlibcSdkManager.getInstance().verifySdkExist("applink_sdk")) {
            AlibcLogger.e(str, "applink sdk not exist");
            return false;
        }
        if (!AlibcProtocolUtils.allowLaunch()) {
            AlibcLogger.i(str, "not allow launch");
            return false;
        }
        List<ActionDO> actionList = routeRequest.getActionList();
        if (actionList == null || actionList.size() <= 0) {
            AlibcLogger.i(str, "action list is empty");
            return OpenType.Native.equals(alibcTradeContext.showParams.getOpenType());
        }
        for (ActionDO actionDO : actionList) {
            String openType = actionDO.getOpenType();
            ParamDO param = actionDO.getParam();
            if ("native".equals(openType)) {
                if (param != null && param.getForce()) {
                    AlibcLogger.i(b, "force to launch");
                    return true;
                }
                if (!AlibcProtocolUtils.verifyInSuite(routeRequest)) {
                    return true;
                }
                AlibcLogger.i(b, "in suite");
                TRiverConstant.BC_LINK_CODE = BCErrorEnum.CODE_IN_SUITE_LAUNCH.getValue() | TRiverConstant.BC_LINK_CODE;
                return false;
            }
        }
        return false;
    }

    public final void e(AlibcTradeContext alibcTradeContext, AlibcDegradeType alibcDegradeType, String str, RouteRequest routeRequest, String str2, Map<String, Object> map, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        AlibcTradeContext.getInstance().context = null;
        WeakReference<Activity> weakReference = alibcTradeContext.mActivity;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(alibcTradeContext.mActivity.get(), str2, map, new e(alibcDegradeType, str, alibcTradeContext, routeRequest, dVar, alibcComponentReRenderCallback, str2, map));
    }

    public final void g(RouteRequest routeRequest, String str, AlibcTradeContext alibcTradeContext, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback, boolean z, boolean z2) {
        Map<String, Object> mapObj2Map = AlibcProtocolUtils.obj2Map(alibcTradeContext.showParams, alibcTradeContext.taokeParams, routeRequest.getBizType(), false, null);
        AlibcDegradeType alibcDegradeType = (AlibcDegradeType) mapObj2Map.get("degradeType");
        String applinkType = AlibcProtocolUtils.getApplinkType(z2, z);
        if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, str) || !z || z2) {
            e(alibcTradeContext, alibcDegradeType, applinkType, routeRequest, str, mapObj2Map, dVar, alibcComponentReRenderCallback);
        } else {
            AlibcProtocolUtils.convertUrl(str, new d(System.currentTimeMillis(), str, alibcTradeContext, alibcDegradeType, applinkType, routeRequest, mapObj2Map, dVar, alibcComponentReRenderCallback));
        }
    }

    public final void h(RouteRequest routeRequest, String str, AlibcTradeContext alibcTradeContext, boolean z, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).executeConvert(routeRequest, str, c, new c(System.currentTimeMillis(), str, routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback, z));
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, com.baichuan.nb_trade.distribute.d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        String strGenerateRecoverId;
        AlibcLogger.i(b, "native handler execute handle");
        String bizType = routeRequest.getBizType();
        boolean zEquals = "miniapp".equals(routeRequest.getPageType());
        String targetUrl = AlibcBizUtils.getTargetUrl(routeRequest);
        if (!"detail".equals(bizType) && !"shop".equals(bizType)) {
            if ("taobaolite".equals(bizType)) {
                String strD = d(Uri.parse(targetUrl).getQueryParameter("id"));
                TBLiteJudgeBusiness tBLiteJudgeBusiness = new TBLiteJudgeBusiness();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ALPParamConstant.ITMEID, (Object) strD);
                tBLiteJudgeBusiness.sendRequest(jSONObject, new a(alibcTradeContext, routeRequest, targetUrl, zEquals, dVar, alibcComponentReRenderCallback));
                return;
            }
            if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, targetUrl)) {
                if (AlibcUrlCheck.regularCheck(AlibcProtocolConstant.SCLICK_URL_PATTERNS, targetUrl)) {
                    ParseSclickBusiness parseSclickBusiness = new ParseSclickBusiness();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("floorId", (Object) "43676");
                    HashMap map = new HashMap();
                    map.put("invokerName", "baichuan");
                    map.put("url", targetUrl);
                    map.put("invokeType", "MTOP");
                    jSONObject2.put("variableMap", (Object) JSON.toJSONString(map));
                    parseSclickBusiness.sendRequest(jSONObject2, new b(alibcTradeContext, routeRequest, targetUrl, dVar, alibcComponentReRenderCallback, zEquals));
                    return;
                }
                g(routeRequest, targetUrl, alibcTradeContext, dVar, alibcComponentReRenderCallback, zEquals, false);
                return;
            }
            g(routeRequest, targetUrl, alibcTradeContext, dVar, alibcComponentReRenderCallback, zEquals, false);
            return;
        }
        String clickId = "";
        if (zEquals) {
            try {
                strGenerateRecoverId = AlibcBizUtils.generateRecoverId();
            } catch (Exception e2) {
                AlibcLogger.e(b, "found exception: " + e2.getMessage());
                dVar.a(-100, "[NativeHandler]url is invalid");
                return;
            }
        } else {
            strGenerateRecoverId = "";
        }
        c = strGenerateRecoverId;
        if (zEquals && AlibcSdkManager.getInstance().verifySdkExist("ad_sdk")) {
            clickId = ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).getClickId(targetUrl, true);
        }
        HashMap map2 = new HashMap(16);
        if (zEquals) {
            map2.put("clickId", clickId);
            map2.put(AlibcProtocolConstant.RECOVER_ID, c);
        }
        h(routeRequest, com.baichuan.nb_trade.distribute.b.a(zEquals, targetUrl, bizType, map2), alibcTradeContext, zEquals, dVar, alibcComponentReRenderCallback);
    }
}
