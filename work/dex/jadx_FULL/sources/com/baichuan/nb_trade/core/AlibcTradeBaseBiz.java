package com.baichuan.nb_trade.core;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcGameCallback;
import com.alibaba.alibcprotocol.callback.AlibcLoginCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback;
import com.alibaba.alibcprotocol.extension.ParamInterceptorCenter;
import com.alibaba.alibcprotocol.manager.AlibcSdkManager;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAuthProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcGameProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcSoLoadProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcSDKInitResult;
import com.alibaba.alibcucclogin.AlibcUccLogin;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcTradeBaseBiz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26225a = "AlibcTradeBaseBiz";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CountDownLatch f1220a = null;
    public static String channel = "0";
    public static Map<String, Object> extParams;

    public static class AlibcTradeBizResult {
        public int errCode;
        public String errMsg;
        public boolean isSuccess = false;
    }

    public static class a implements AlibcContainerCallback {
        @Override // com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback
        public final void onInitFail(int i, String str) {
            AlibcLogger.e(AlibcTradeBaseBiz.f26225a, "triver container init fail: code = " + i + ", msg = " + str);
        }

        @Override // com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback
        public final void onInitSuccess() {
            AlibcLogger.saveLog("baichuan", "TRIVER_INIT_SUCCESS", "TRIVER_SDK_INIT", "triver sdk init success", new HashMap(), "normal");
            AlibcLogger.i(AlibcTradeBaseBiz.f26225a, "triver container init success: com.alibaba.alibctriver.container.AlibcTRiverContainer");
        }
    }

    public static class b implements AlibcContainerCallback {
        @Override // com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback
        public final void onInitFail(int i, String str) {
            AlibcLogger.e(AlibcTradeBaseBiz.f26225a, "triver container init fail: code = " + i + ", msg = " + str);
        }

        @Override // com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback
        public final void onInitSuccess() {
            AlibcLogger.saveLog("baichuan", "WEBVIEW_INIT_SUCCESS", "WEBVIEW_SDK_INIT", "webview sdk init success", new HashMap(), "normal");
            AlibcLogger.i(AlibcTradeBaseBiz.f26225a, "webview container init success: com.alibaba.alibcwebview.instance.AlibcWebViewContainer");
        }
    }

    public static class c implements AlibcGameCallback {
        @Override // com.alibaba.alibcprotocol.callback.AlibcGameCallback
        public final void onFail(String str, String str2) {
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcGameCallback
        public final void onSuccess() {
        }
    }

    public static class d implements AlibcLoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f26226a;

        public d(boolean[] zArr) {
            this.f26226a = zArr;
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public final void onFailure(int i, String str) {
            this.f26226a[0] = false;
            AlibcTradeBaseBiz.f1220a.countDown();
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public final void onSuccess(String str, String str2) {
            this.f26226a[0] = true;
            AlibcLogger.saveLog("baichuan", "LOGIN_INIT_SUCCESS", "LOGIN_SDK_INIT", "login sdk init success", new HashMap(), "normal");
            AlibcTradeBaseBiz.f1220a.countDown();
        }
    }

    public static class e implements AlibcLoginCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f26227a;

        public e(boolean[] zArr) {
            this.f26227a = zArr;
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public final void onFailure(int i, String str) {
            this.f26227a[0] = false;
            AlibcTradeBaseBiz.f1220a.countDown();
        }

        @Override // com.alibaba.alibcprotocol.callback.AlibcLoginCallback
        public final void onSuccess(String str, String str2) {
            AlibcLogger.saveLog("baichuan", "UCC_LOGIN_INIT_SUCCESS", "UCC_LOGIN_SDK_INIT", "ucc login sdk init success", new HashMap(), "normal");
            this.f26227a[0] = true;
            AlibcTradeBaseBiz.f1220a.countDown();
        }
    }

    public static String getTTID() {
        return String.format("2014_%s_%s@baichuan_android_%s", channel, AlibcBaseTradeCommon.getAppKey(), "5.0.2.5");
    }

    public static AlibcTradeBizResult init(Map<String, Object> map, JSONObject jSONObject) {
        int i;
        AlibcTradeBizResult alibcTradeBizResult = new AlibcTradeBizResult();
        if (map != null) {
            extParams = map;
            AlibcTradeContext.getInstance().extParams = map;
        }
        ParamInterceptorCenter.registerInterceptor("SHOP_PARAM_INTERCEPTOR", "com.alibaba.alibcprotocol.extension.ParamShopInterceptorImpl");
        long jCurrentTimeMillis = System.currentTimeMillis();
        AlibcConfigService.getInstance().init(AlibcBaseTradeCommon.context);
        jSONObject.put("config_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        AlibcContainerManager.registerContainer("miniapp", AlibcProtocolConstant.TRIVER_CONTAINER, AlibcTradeContext.getInstance(), new a());
        AlibcContainerManager.registerContainer("h5", AlibcProtocolConstant.WEBVIEW_CONTAINER, AlibcTradeContext.getInstance(), new b());
        ((IAlibcGameProxy) AlibcProxy.get(IAlibcGameProxy.class)).init(new c());
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (1 != AlibcSdkManager.getInstance().registerSDK("ad_sdk", AlibcProtocolConstant.AD_CLASS_NAME).result) {
            try {
                ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).init();
                AlibcLogger.saveLog("baichuan", "AD_INIT_SUCCESS", "AD_SDK_INIT", "ad sdk init success", new HashMap(), "normal");
            } catch (Exception unused) {
                alibcTradeBizResult.errCode = 800;
                alibcTradeBizResult.errMsg = AlibcProtocolConstant.AD_INIT_FAIL_ERROR_MSG;
                HashMap map2 = new HashMap();
                map2.put("errorCode", String.valueOf(alibcTradeBizResult.errCode));
                map2.put("errorMsg", String.valueOf(alibcTradeBizResult.errMsg));
                AlibcLogger.saveLog("baichuan", "AD_INIT_FAIL", "AD_SDK_INIT", "ad sdk init fail", map2, "error");
                return alibcTradeBizResult;
            }
        } else {
            AlibcSdkManager.getInstance().unRegisterSdk("ad_sdk");
            AlibcLogger.saveLog("baichuan", "AD_INIT_FAIL", "AD_SDK_INIT", "ad sdk not exist", new HashMap(), "error");
        }
        jSONObject.put("ad_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis2));
        if (1 != AlibcSdkManager.getInstance().registerSDK(AlibcProtocolConstant.AUTH_SDK_TAG, AlibcProtocolConstant.AUTH_CLASS_NAME).result) {
            ((IAlibcAuthProxy) AlibcProxy.get(IAlibcAuthProxy.class)).init();
            AlibcLogger.saveLog("baichuan", "AUTH_INIT_SUCCESS", "AUTH_SDK_INIT", "auth sdk init success", new HashMap(), "normal");
        }
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        try {
            ((IAlibcSoLoadProxy) AlibcProxy.get(IAlibcSoLoadProxy.class)).registerSoLoad(ILivePush.ClickType.LIVE, ILivePush.ClickType.LIVE);
            ((IAlibcSoLoadProxy) AlibcProxy.get(IAlibcSoLoadProxy.class)).initSoLoad(AlibcBaseTradeCommon.context, "live_so", "liveZip");
        } catch (Throwable th) {
            AlibcLogger.e(f26225a, th.getMessage());
        }
        jSONObject.put("so_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis3));
        long jCurrentTimeMillis4 = System.currentTimeMillis();
        if (1 != AlibcSdkManager.getInstance().registerSDK("applink_sdk", AlibcProtocolConstant.APPLINK_CLASS_NAME).result) {
            AlibcSDKInitResult alibcSDKInitResultInit = ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).init();
            if (alibcSDKInitResultInit == null || 1 == alibcSDKInitResultInit.result) {
                alibcTradeBizResult.errCode = 500;
                alibcTradeBizResult.errMsg = AlibcProtocolConstant.APPLINK_INIT_FAIL_ERROR_MSG;
                HashMap map3 = new HashMap();
                map3.put("errorCode", String.valueOf(alibcTradeBizResult.errCode));
                map3.put("errorMsg", alibcTradeBizResult.errMsg);
                AlibcLogger.saveLog("baichuan", "APPLINK_INIT_FAIL", "APPLINK_SDK_INIT", "applink sdk init fail", map3, "error");
                return alibcTradeBizResult;
            }
            AlibcLogger.saveLog("baichuan", "APPLINK_INIT_SUCCESS", "APPLINK_SDK_INIT", "applink sdk init success", new HashMap(), "normal");
        } else {
            AlibcSdkManager.getInstance().unRegisterSdk("applink_sdk");
            AlibcLogger.saveLog("baichuan", "APPLINK_INIT_FAIL", "APPLINK_SDK_INIT", "appLink sdk not exist", new HashMap(), "error");
        }
        jSONObject.put("applink_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis4));
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        boolean[] zArr = {false};
        if (1 != AlibcSdkManager.getInstance().registerSDK("login_sdk", AlibcProtocolConstant.LOGIN_CLASS_NAME).result) {
            f1220a = new CountDownLatch(1);
            ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).init(new d(zArr));
            try {
                CountDownLatch countDownLatch = f1220a;
                if (countDownLatch != null) {
                    countDownLatch.await();
                }
                if (!zArr[0]) {
                    alibcTradeBizResult.errCode = 400;
                    alibcTradeBizResult.errMsg = AlibcProtocolConstant.LOGIN_INIT_FAIL_ERROR_MSG;
                    HashMap map4 = new HashMap();
                    map4.put("cost", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis5));
                    jSONObject.put("login_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis5));
                    map4.put("errorCode", String.valueOf(alibcTradeBizResult.errCode));
                    map4.put("errorMsg", alibcTradeBizResult.errMsg);
                    AlibcLogger.saveLog("baichuan", "LOGIN_INIT_FAIL", "LOGIN_SDK_INIT", "login sdk init fail", map4, "error");
                    return alibcTradeBizResult;
                }
            } catch (InterruptedException e2) {
                AlibcLogger.e(f26225a, "login lock timeout: " + e2.getMessage());
                alibcTradeBizResult.errCode = 400;
                alibcTradeBizResult.errMsg = AlibcProtocolConstant.LOGIN_INIT_FAIL_ERROR_MSG;
                return alibcTradeBizResult;
            }
        } else {
            AlibcSdkManager.getInstance().unRegisterSdk("login_sdk");
            AlibcLogger.saveLog("baichuan", "LOGIN_INIT_FAIL", "LOGIN_SDK_INIT", "login sdk not exist", new HashMap(), "error");
            if (AlibcCommonUtils.verifySdkExist(AlibcProtocolConstant.UCC_LOGIN_CLASS_NAME, "ucc_login_sdk")) {
                AlibcSdkManager.getInstance().registerSDK("ucc_login_sdk", AlibcProtocolConstant.UCC_LOGIN_CLASS_NAME);
                f1220a = new CountDownLatch(1);
                AlibcUccLogin.getInstance().init(map, new e(zArr));
            } else {
                AlibcSdkManager.getInstance().unRegisterSdk("ucc_login_sdk");
                AlibcLogger.saveLog("baichuan", "UCC_LOGIN_INIT_FAIL", "UCC_LOGIN_SDK_INIT", "ucc login sdk not exist", new HashMap(), "error");
            }
        }
        try {
            CountDownLatch countDownLatch2 = f1220a;
            if (countDownLatch2 != null) {
                countDownLatch2.await();
            }
            i = 400;
        } catch (InterruptedException e3) {
            AlibcLogger.e(f26225a, "login lock timeout: " + e3.getMessage());
            i = 400;
            alibcTradeBizResult.errCode = 400;
            alibcTradeBizResult.errMsg = AlibcProtocolConstant.LOGIN_INIT_FAIL_ERROR_MSG;
        }
        if (!zArr[0]) {
            alibcTradeBizResult.errCode = i;
            alibcTradeBizResult.errMsg = AlibcProtocolConstant.LOGIN_INIT_FAIL_ERROR_MSG;
            HashMap map5 = new HashMap();
            map5.put("cost", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis5));
            jSONObject.put("login_cost", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis5));
            map5.put("errorCode", String.valueOf(alibcTradeBizResult.errCode));
            map5.put("errorMsg", alibcTradeBizResult.errMsg);
            AlibcLogger.saveLog("baichuan", "LOGIN_INIT_FAIL", "LOGIN_SDK_INIT", "login sdk init fail", map5, "error");
        }
        alibcTradeBizResult.isSuccess = true;
        return alibcTradeBizResult;
    }

    public static void setChannel(String str) {
        channel = str;
    }

    public static void turnOffDebug() {
        ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).turnOffDebug();
        ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).turnOffDebug();
    }

    public static void turnOnDebug() {
        ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).turnOnDebug();
        ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).turnOnDebug();
    }
}
