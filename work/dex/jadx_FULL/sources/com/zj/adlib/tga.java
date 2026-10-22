package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclogin.AlibcLogin;
import com.alibaba.alibcprotocol.CommonListenerManager;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.route.proxy.IAlibcLoginProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcToolProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.network.NetWorkUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackParams;
import com.alibaba.baichuan.trade.common.ut.UserTrackUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.fastjson.JSONObject;
import com.baichuan.nb_trade.callback.AlibcTradeInitCallback;
import com.baichuan.nb_trade.core.AlibcTradeBaseBiz;
import com.baichuan.nb_trade.impl.AlibcCommonListenerImpl;
import com.baichuan.nb_trade.model.InitResult;
import com.baichuan.nb_trade.model.InitState;
import com.baichuan.nb_trade.utils.AlibcBizUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class tga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InitResult f44916a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static InitState f19810a = new InitState();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19811a = "tga";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlibcTradeInitCallback f44917a;

        public a(AlibcTradeInitCallback alibcTradeInitCallback) {
            this.f44917a = alibcTradeInitCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f44917a.onSuccess();
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f44918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeInitCallback f19812a;

        public b(AlibcTradeInitCallback alibcTradeInitCallback, JSONObject jSONObject) {
            this.f19812a = alibcTradeInitCallback;
            this.f44918a = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f19812a.onSuccess();
            boolean zIsAppInstalled = AlibcCommonUtils.isAppInstalled(AlibcBaseTradeCommon.context, AlibcProtocolConstant.APPLINK_PACKAGE_NAME);
            boolean zIsLogin = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).isLogin();
            UserTrackUtils.sendUserTrack("api_sdkInit_aliTradesdk_5.0.2.5", new UserTrackParams.UTBuilder().setSuccess("1").setSessionValid(zIsLogin ? "1" : "0").setTbInstalled(zIsAppInstalled ? "1" : "0").build().getProps());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.SESSION_VALID, zIsLogin ? "1" : "0");
            jSONObject.put(UserTrackConstant.TB_INSTALLED, (Object) (zIsAppInstalled ? "1" : "0"));
            jSONObject.put("costTime", (Object) this.f44918a.toJSONString());
            jSONObject.put(UserTrackConstant.SDK_TYPE, (Object) "ultimate");
            jSONObject.putAll(this.f44918a);
            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_SDK_INIT, "", "", jSONObject);
            AlibcUserTracker.getInstance().sendInitHit4DAU("19", "5.0.2.5");
            tga.a(AlibcBaseTradeCommon.context);
            CommonListenerManager.registerListener("pushWindow", new AlibcCommonListenerImpl());
            Application application = AlibcBaseTradeCommon.context;
            AlibcProtocolUtils.executePreLaunch(application, application.getPackageName(), System.currentTimeMillis());
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f44919a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeInitCallback f19813a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ InitResult f19814a;

        public c(InitResult initResult, AlibcTradeInitCallback alibcTradeInitCallback, JSONObject jSONObject) {
            this.f19814a = initResult;
            this.f19813a = alibcTradeInitCallback;
            this.f44919a = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InitResult initResultNewFailureResult = this.f19814a;
            if (initResultNewFailureResult == null) {
                initResultNewFailureResult = InitResult.newFailureResult(-1, AlibcProtocolConstant.UNKNOWN_ERROR);
            }
            this.f19813a.onFailure(initResultNewFailureResult.errCode, initResultNewFailureResult.errMsg);
            UserTrackUtils.sendUserTrack("api_sdkInit_aliTradesdk_5.0.2.5", new UserTrackParams.UTBuilder().setSuccess("0").setErrCode(String.valueOf(initResultNewFailureResult.errCode)).setErrMsg(initResultNewFailureResult.errMsg).build().getProps());
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll(this.f44919a);
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_SDK_INIT, String.valueOf(initResultNewFailureResult.errCode), initResultNewFailureResult.errMsg, jSONObject);
            AlibcUserTracker.getInstance().sendInitHit4DAU("19", "5.0.2.5");
            tga.a(AlibcBaseTradeCommon.context);
            CommonListenerManager.unRegisterListener("pushWindow");
        }
    }

    public static boolean a(AlibcTradeInitCallback alibcTradeInitCallback) {
        if (f19810a.isInitialing()) {
            return false;
        }
        if (!f19810a.isInitialized()) {
            return true;
        }
        ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new a(alibcTradeInitCallback));
        return false;
    }

    public static void b(AlibcTradeInitCallback alibcTradeInitCallback, JSONObject jSONObject) {
        f19810a.setState(2);
        ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new b(alibcTradeInitCallback, jSONObject));
    }

    public static void c(AlibcTradeInitCallback alibcTradeInitCallback, InitResult initResult, JSONObject jSONObject) {
        f19810a.setState(3);
        ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new c(initResult, alibcTradeInitCallback, jSONObject));
    }

    public static boolean d() {
        return true;
    }

    public static int getInitState() {
        return f19810a.state;
    }

    public static void setChannel(String str, String str2) {
        AlibcTradeBaseBiz.setChannel(AlibcBizUtils.getChannel(str2, str));
    }

    public static /* synthetic */ void a(Context context) {
        Map<String, Object> userInfo;
        if (AlibcCommonUtils.isOpenAnalysisTool() && AlibcCommonUtils.isApkDebug(context)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("appkey", AlibcBaseTradeCommon.getAppKey());
            map.put("sdkVersion", "5.0.2.5");
            map.put("ttid", AlibcBaseTradeCommon.ttid);
            map.put("utdid", AlibcBaseTradeCommon.getUtdid());
            map.put("isLogin", AlibcLogin.getInstance().isLogin() ? "已登录" : "未登录");
            if (AlibcLogin.getInstance().isLogin() && (userInfo = ((IAlibcLoginProxy) AlibcProxy.get(IAlibcLoginProxy.class)).getUserInfo()) != null) {
                map.put(LoginConstants.PARAN_LOGIN_INFO, "openId=" + userInfo.get("userId") + ", nick=" + userInfo.get("nick"));
            }
            map.put("topAuthAbility", d() ? "请迁移TOP NATIVE授权" : "暂不支持");
            String netWorkType = NetWorkUtils.getNetWorkType(AlibcBaseTradeCommon.context);
            String str = (NetWorkUtils.isNetWorkAvailable(AlibcBaseTradeCommon.context) && NetWorkUtils.isNetWorkOnline(AlibcBaseTradeCommon.context)) ? "网络可用" : "网络不可用";
            if (!TextUtils.isEmpty(netWorkType)) {
                str = str + ": " + netWorkType;
            }
            map.put("netAvailable", str);
            List<String> suiteList = AlibcProtocolUtils.getSuiteList();
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = suiteList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            map.put("suiteList", sb.toString());
            ((IAlibcToolProxy) AlibcProxy.get(IAlibcToolProxy.class)).saveAppInfo(context, map, "bc_info");
        }
    }
}
