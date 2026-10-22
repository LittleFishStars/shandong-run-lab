package com.alibaba.baichuan.trade.common.mtop;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.baichuan.log.LogLevel;
import com.alibaba.baichuan.log.TLog;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.model.Environment;
import com.alibaba.baichuan.trade.common.security.AlibcSecurityGuard;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Handler f24550a = new Handler(Looper.getMainLooper());
    private final int b = 10000;
    private int c = 10000;

    /* JADX INFO: renamed from: com.alibaba.baichuan.trade.common.mtop.b$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24555a;

        static {
            int[] iArr = new int[Environment.values().length];
            f24555a = iArr;
            try {
                iArr[Environment.PRE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24555a[Environment.SANDBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24555a[Environment.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static MtopRequest b(NetworkRequest networkRequest) {
        if (TextUtils.isEmpty(networkRequest.apiVersion)) {
            networkRequest.apiVersion = "1.0";
        }
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(networkRequest.apiName);
        mtopRequest.setVersion(networkRequest.apiVersion);
        mtopRequest.setNeedEcode(networkRequest.needLogin);
        mtopRequest.setNeedSession(true);
        if (networkRequest.paramMap != null) {
            try {
                JSONObject object = JSON.parseObject(mtopRequest.getData());
                if (object == null) {
                    object = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : networkRequest.paramMap.entrySet()) {
                    if (entry.getValue() != null) {
                        object.put(entry.getKey(), (Object) entry.getValue().toString());
                    }
                }
                mtopRequest.setData(object.toJSONString());
            } catch (Exception e) {
                AlibcLogger.e("MtopNetWorkImpl", "json parse exception: " + e.getMessage());
            }
        }
        return mtopRequest;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.a
    public final boolean a(int i) {
        if (i > 0) {
            this.c = i;
        }
        if (AlibcSecurityGuard.getInstance().selfCheck()) {
            return false;
        }
        MtopSetting.setAuthCode("OPEN", "baichuan");
        MtopSetting.setAppKeyIndex("OPEN", 0, 0);
        MtopSetting.setAppVersion("OPEN", "5.0.2.5");
        MtopSetting.setMtopDomain("OPEN", "acs4baichuan.m.taobao.com", "acs4baichuan.wapa.taobao.com", "acs4baichuan.waptest.taobao.com");
        MtopSetting.setLogAdapterImpl(new LogAdapter() { // from class: com.alibaba.baichuan.trade.common.mtop.b.1
            public final String getLogLevel() {
                return LogLevel.D.toString();
            }

            public final void printLog(int i2, String str, String str2, Throwable th) {
                if (i2 == 2) {
                    TLog.logd(str, str2);
                    return;
                }
                if (i2 == 4) {
                    TLog.logi(str, str2);
                } else if (i2 == 8) {
                    TLog.logw(str, str2, th);
                } else {
                    if (i2 != 16) {
                        return;
                    }
                    TLog.loge(str, str2, th);
                }
            }

            public final void traceLog(String str, String str2) {
                TLog.traceLog(str, str2);
            }
        });
        TBSdkLog.setTLogEnabled(true);
        Mtop.instance("OPEN", AlibcBaseTradeCommon.context, AlibcBaseTradeCommon.ttid);
        MtopSetting.setAppKey("OPEN", AlibcBaseTradeCommon.getAppKey());
        a(String.format("2014_%s_%s@baichuan_android_%s", "0", AlibcBaseTradeCommon.getAppKey(), "5.0.2.5"));
        int i2 = AnonymousClass4.f24555a[AlibcBaseTradeCommon.getEnvironment().ordinal()];
        if (i2 == 1) {
            Mtop.getMtopInstance("OPEN").switchEnvMode(EnvModeEnum.PREPARE);
        } else if (i2 == 2) {
            Mtop.getMtopInstance("OPEN").switchEnvMode(EnvModeEnum.TEST_SANDBOX);
        } else if (i2 != 3) {
            Mtop.getMtopInstance("OPEN").switchEnvMode(EnvModeEnum.ONLINE);
        } else {
            Mtop.getMtopInstance("OPEN").switchEnvMode(EnvModeEnum.TEST);
        }
        return true;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.c
    public final boolean sendRequest(final NetworkRequestListener networkRequestListener, final NetworkRequest networkRequest) {
        if (networkRequest == null) {
            if (networkRequestListener != null) {
                AlibcLogger.e("MtopNetWorkImpl", "network request is null");
                networkRequestListener.onError(-1, null);
            } else {
                AlibcLogger.e("MtopNetWorkImpl", "listener and request are both null");
            }
            return false;
        }
        final MtopBusiness mtopBusinessA = a(networkRequest);
        AlibcLogger.i("MtopNetWorkImpl", "设置超时时间为: " + this.c);
        final Timer timer = new Timer();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        timer.schedule(new TimerTask() { // from class: com.alibaba.baichuan.trade.common.mtop.b.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    mtopBusinessA.cancelRequest();
                    b.this.f24550a.post(new Runnable() { // from class: com.alibaba.baichuan.trade.common.mtop.b.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AlibcLogger.e("MtopNetWorkImpl", "超时未响应api: " + networkRequest.apiName);
                            NetworkResponse networkResponse = new NetworkResponse();
                            networkResponse.errorCode = "-1";
                            networkResponse.errorMsg = "超时未响应";
                            networkRequestListener.onError(-1, networkResponse);
                        }
                    });
                }
            }
        }, this.c);
        mtopBusinessA.registerListener(new IRemoteBaseListener() { // from class: com.alibaba.baichuan.trade.common.mtop.b.3
            public final void onError(int i, MtopResponse mtopResponse, Object obj) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    timer.cancel();
                    b.b(mtopResponse);
                    networkRequestListener.onError(networkRequest.requestType, b.a(mtopResponse));
                }
            }

            public final void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    timer.cancel();
                    b.b(mtopResponse);
                    networkRequestListener.onSuccess(networkRequest.requestType, b.a(mtopResponse));
                }
            }

            public final void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    timer.cancel();
                    b.b(mtopResponse);
                    networkRequestListener.onError(networkRequest.requestType, b.a(mtopResponse));
                }
            }
        }).startRequest();
        return true;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.c
    public final NetworkResponse sendRequest(NetworkRequest networkRequest) {
        if (networkRequest == null) {
            return null;
        }
        return a(a(networkRequest).syncRequest());
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.a
    public final void b() {
        TBSdkLog.setTLogEnabled(false);
        TBSdkLog.setPrintLog(false);
    }

    public static /* synthetic */ void b(MtopResponse mtopResponse) {
        if (mtopResponse.isApiSuccess()) {
            AlibcLogger.d("MtopNetWorkImpl", "网络请求成功");
            return;
        }
        if (mtopResponse.isSessionInvalid()) {
            AlibcLogger.e("MtopNetWorkImpl", "session失效，执行自动登录或登录繁忙: retCode = " + mtopResponse.getRetCode() + ", msg = " + mtopResponse.getRetMsg());
            return;
        }
        if (!mtopResponse.isSystemError() && !mtopResponse.isNetworkError() && !mtopResponse.isExpiredRequest() && !mtopResponse.is41XResult() && !mtopResponse.isApiLockedResult() && !mtopResponse.isMtopSdkError()) {
            AlibcLogger.e("MtopNetWorkImpl", "业务错误: retCode = " + mtopResponse.getRetCode() + ", msg = " + mtopResponse.getRetMsg());
            return;
        }
        AlibcLogger.e("MtopNetWorkImpl", "系统错误、网络错误、防刷、防雪崩: retCode = " + mtopResponse.getRetCode() + ", msg = " + mtopResponse.getRetMsg());
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.a
    public final void a(String str) {
        Mtop.getMtopInstance("OPEN").registerTtid(str);
    }

    private static MtopBusiness a(NetworkRequest networkRequest) {
        String str;
        Mtop mtopInstance = Mtop.getMtopInstance("OPEN");
        MtopRequest mtopRequestB = b(networkRequest);
        if (networkRequest != null && !TextUtils.isEmpty(networkRequest.ttid)) {
            str = networkRequest.ttid;
        } else {
            str = AlibcBaseTradeCommon.ttid;
        }
        MtopBusiness mtopBusinessBuild = MtopBusiness.build(mtopInstance, mtopRequestB, str);
        if (networkRequest.needWua) {
            mtopBusinessBuild.useWua();
        }
        if (networkRequest.needAuth && !networkRequest.isVip) {
            mtopBusinessBuild.setNeedAuth(networkRequest.authParams, true);
        }
        if (networkRequest.isPost) {
            mtopBusinessBuild.reqMethod(MethodEnum.POST);
        }
        Map<String, String> map = networkRequest.extHeaders;
        if (map != null && map.size() > 0) {
            mtopBusinessBuild.headers(networkRequest.extHeaders);
        }
        boolean z = networkRequest.showAuthUI;
        if (!z) {
            mtopBusinessBuild.showAuthUI = z;
        }
        Map<String, String> map2 = networkRequest.extQueries;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    mtopBusinessBuild.addHttpQueryParameter(key, value);
                }
            }
        }
        mtopBusinessBuild.setSocketTimeoutMilliSecond(15000);
        mtopBusinessBuild.setConnectionTimeoutMilliSecond(15000);
        mtopBusinessBuild.setOpenBiz("baichuan");
        return mtopBusinessBuild;
    }

    public static NetworkResponse a(MtopResponse mtopResponse) {
        NetworkResponse networkResponse = new NetworkResponse();
        if (mtopResponse == null) {
            return networkResponse;
        }
        networkResponse.byteData = mtopResponse.getBytedata();
        networkResponse.httpCode = String.valueOf(mtopResponse.getResponseCode());
        networkResponse.errorCode = mtopResponse.getRetCode();
        networkResponse.errorMsg = mtopResponse.getRetMsg();
        networkResponse.isSuccess = mtopResponse.isApiSuccess();
        networkResponse.ret = mtopResponse.getRet();
        if (mtopResponse.getDataJsonObject() != null) {
            try {
                String string = mtopResponse.getDataJsonObject().toString();
                networkResponse.data = (Map) JSON.parseObject(string, Map.class);
                networkResponse.jsonData = string;
            } catch (Exception e) {
                AlibcLogger.e("MtopNetWorkImpl", "parse object exception: " + e.getMessage());
            }
        }
        return networkResponse;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.a
    public final void a() {
        TBSdkLog.setTLogEnabled(true);
        TBSdkLog.setPrintLog(true);
    }
}
