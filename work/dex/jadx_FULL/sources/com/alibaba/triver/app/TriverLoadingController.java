package com.alibaba.triver.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.R;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.error.TriverErrors;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.proxy.IAppLoadProxy;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IRouterProxy;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.utils.CommonUtils;
import com.amap.api.maps.model.MyLocationStyle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverLoadingController implements SplashView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAppLoadProxy f24607a;
    private Context b;
    private App c;
    private View d;
    private int e;
    private boolean f;
    private boolean g;
    private SplashView.Status h = SplashView.Status.WAITING;

    public static class DowngradeExtension implements DowngradePoint {
        @Override // com.alibaba.triver.app.TriverLoadingController.DowngradePoint
        public boolean downgradeTo(String str) {
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            if (rVEnvironmentService == null) {
                return false;
            }
            WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
            Context applicationContext = (topActivity == null || topActivity.get() == null) ? rVEnvironmentService.getApplicationContext() : topActivity.get();
            ((IRouterProxy) RVProxy.get(IRouterProxy.class)).openURL(applicationContext, null, str, null, ActivityOptionsCompat.makeCustomAnimation(applicationContext, R.anim.ariver_fragment_translate_in_left, R.anim.ariver_fragment_translate_out_left).toBundle());
            return false;
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onFinalized() {
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onInitialized() {
        }
    }

    @Remote
    public interface DowngradePoint extends Extension {
        boolean downgradeTo(String str);
    }

    public TriverLoadingController(Context context, App app, boolean z) {
        this.f = false;
        this.g = false;
        if (this.f24607a == null) {
            this.f24607a = (IAppLoadProxy) RVProxy.get(IAppLoadProxy.class);
        }
        this.b = context;
        this.c = app;
        this.f = z;
        Bundle startParams = app.getStartParams();
        if (startParams != null) {
            this.g = startParams.getBoolean("needTargetAppStatus", false);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public boolean backPressed() {
        App app;
        if (this.f) {
            return false;
        }
        if (this.f24607a.isShowLoading(this.d) && this.c != null) {
            if (CommonUtils.closePreventBackPressInLoading()) {
                this.c.exit();
            }
            return true;
        }
        if (!this.f24607a.isShowError(this.d) || (app = this.c) == null) {
            return false;
        }
        app.exit();
        return true;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void exit(SplashView.ExitListener exitListener) {
        if (this.f24607a.isShowLoading(this.d)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f24607a.hideAppLoading(this.d);
            } else {
                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        TriverLoadingController.this.f24607a.hideAppLoading(TriverLoadingController.this.d);
                    }
                });
            }
            this.h = SplashView.Status.EXIT;
            if (this.c != null) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(com.alibaba.triver.trace.c.E, null, "AppLoading", this.c.getAppId(), null, null);
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.d, com.alibaba.triver.trace.c.E, TRiverUtils.getSessionId(this.c), this.c, (JSONObject) null);
            }
        }
        if (exitListener != null) {
            exitListener.onExit();
        }
        if (this.g) {
            Intent intent = new Intent(TRiverConstants.ACTION_NOTIFY_TARGET_APP_STATUS);
            intent.putExtra("appId", this.c.getAppId());
            intent.putExtra("targetAppStatus", "success");
            this.b.sendBroadcast(intent);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public SplashView.Status getStatus() {
        View view;
        IAppLoadProxy iAppLoadProxy = this.f24607a;
        return (iAppLoadProxy == null || (view = this.d) == null || !iAppLoadProxy.isShowLoading(view)) ? this.h : SplashView.Status.LOADING;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void showError(String str, String str2, Map<String, String> map) {
        TriverErrors.ErrorWrapper errorWrapperMapError = TriverErrors.mapError(map != null ? map.get(RVConstants.EXTRA_PREPARE_EXCEPTION_STAGE) : "", str, str2);
        String str3 = errorWrapperMapError.errorCode;
        String strSubstring = errorWrapperMapError.errorMsg;
        HashMap map2 = new HashMap();
        map2.put("errorCode", str3);
        map2.put("errorMsg", strSubstring);
        SplashView.Status status = this.h;
        SplashView.Status status2 = SplashView.Status.ERROR;
        if (status == status2) {
            if (this.c != null) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("APP_LOADING_SHOW_ERROR_AGAIN", null, "AppLoading", this.c.getAppId(), null, map2);
                return;
            }
            return;
        }
        if (this.c != null) {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setApp(this.c).setStage(TriverAppMonitorConstants.KEY_STAGE_ERROR_PAGE).setErrorCode(b(str3)).setStartParams(this.c.getStartParams()).setErrorMsg(a(strSubstring)).setStatus(Double.valueOf(1.0d)).create());
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.d, com.alibaba.triver.trace.c.F, TRiverUtils.getSessionId(this.c), this.c, str3, strSubstring, (JSONObject) null);
        }
        App app = this.c;
        if (app != null) {
            LaunchMonitorData launchMonitorData = (LaunchMonitorData) app.getData(LaunchMonitorData.class);
            if (launchMonitorData != null) {
                launchMonitorData.setErrorCode(b(str3));
                launchMonitorData.setErrorMessage(a(strSubstring));
            } else {
                LaunchMonitorData launchMonitorData2 = new LaunchMonitorData();
                launchMonitorData2.setErrorCode(b(str3));
                launchMonitorData2.setErrorMessage(a(strSubstring));
            }
            LaunchMonitorUtils.commitMonitorInSub(this.c);
        }
        if (!errorWrapperMapError.needShowErrorMsg) {
            strSubstring = InternationalUtil.getString(this.b, R.string.triver_wait_title);
        }
        final ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.errorCode = str3;
        if (strSubstring != null && strSubstring.length() > 16) {
            strSubstring = strSubstring.substring(0, 16);
        }
        errorInfo.errorMsg = strSubstring;
        if (TRiverUrlUtils.isShop(this.c)) {
            com.alibaba.triver.engine.c.a(this.c, null);
            return;
        }
        if (map != null) {
            errorInfo.subTitle = map.get("errorSubInfo");
            errorInfo.buttonText = map.get("buttonText");
            errorInfo.buttonUrl = map.get("buttonUrl");
            errorInfo.errorLogo = map.get("errorLogo");
            errorInfo.errorTitle = map.get(MyLocationStyle.ERROR_INFO);
            errorInfo.guideTip = map.get("guideTip");
            errorInfo.guideTipUrl = map.get("guideTipUrl");
            errorInfo.buttonType = map.get("buttonType");
            final String str4 = map.get("downgradeUrl");
            if (!TextUtils.isEmpty(str4)) {
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((DowngradePoint) ExtensionPoint.as(DowngradePoint.class).node(TriverLoadingController.this.c).create()).downgradeTo(str4);
                        handler.postDelayed(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TriverLoadingController.this.c != null) {
                                    TriverLoadingController.this.c.exit();
                                }
                            }
                        }, 500L);
                    }
                }, 300L);
                return;
            }
        }
        if (TriverErrors.isUpdateErrorCode(str3)) {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            String str5 = (configsByGroup == null || TextUtils.isEmpty(configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL))) ? "https://huodong.m.taobao.com/act/snipcode.html" : configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL);
            errorInfo.buttonText = InternationalUtil.getString(this.b, R.string.triver_update_tip);
            errorInfo.buttonUrl = str5;
            if (TextUtils.isEmpty(errorInfo.errorTitle)) {
                errorInfo.errorTitle = InternationalUtil.getString(this.b, R.string.triver_version_too_lower);
                errorInfo.subTitle = InternationalUtil.getString(this.b, R.string.triver_must_update_info);
            }
        }
        if (TextUtils.isEmpty(errorInfo.errorTitle)) {
            errorInfo.errorTitle = errorInfo.errorMsg;
        }
        if (CommonUtils.mtopErrorCheck(errorInfo.errorCode)) {
            errorInfo.buttonAction = ErrorInfo.buttonActionType.refresh;
            if (TextUtils.isEmpty(errorInfo.subTitle)) {
                errorInfo.subTitle = InternationalUtil.getString(this.b, R.string.triver_wait_tip);
            }
        } else {
            errorInfo.buttonAction = ErrorInfo.buttonActionType.back;
            if (TextUtils.isEmpty(errorInfo.subTitle)) {
                errorInfo.subTitle = InternationalUtil.getString(this.b, R.string.triver_wait_tip2);
            }
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(Looper.getMainLooper() == Looper.myLooper() ? ExecutorType.SYNC : ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.4
            @Override // java.lang.Runnable
            public void run() {
                if (TriverLoadingController.this.f24607a.isShowLoading(TriverLoadingController.this.d)) {
                    TriverLoadingController.this.f24607a.hideAppLoading(TriverLoadingController.this.d);
                }
                TriverLoadingController.this.f24607a.onAppLoadError(TriverLoadingController.this.d, new e(TriverLoadingController.this.c), errorInfo);
            }
        });
        this.h = status2;
        if (this.g) {
            Intent intent = new Intent(TRiverConstants.ACTION_NOTIFY_TARGET_APP_STATUS);
            intent.putExtra("appId", this.c.getAppId());
            intent.putExtra("targetAppStatus", "error");
            this.b.sendBroadcast(intent);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void showLoading(final EntryInfo entryInfo) {
        if (this.f) {
            return;
        }
        if (this.f24607a.isShowLoading(this.d)) {
            update(entryInfo);
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f24607a.showAppLoading(this.d, new e(this.c), a(entryInfo));
        } else {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.1
                @Override // java.lang.Runnable
                public void run() {
                    TriverLoadingController.this.f24607a.showAppLoading(TriverLoadingController.this.d, new e(TriverLoadingController.this.c), TriverLoadingController.this.a(entryInfo));
                }
            });
        }
        this.h = SplashView.Status.LOADING;
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.d, com.alibaba.triver.trace.c.D, TRiverUtils.getSessionId(this.c), this.c, (JSONObject) null);
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void update(EntryInfo entryInfo) {
        if (this.f) {
            return;
        }
        final com.alibaba.triver.kit.api.model.EntryInfo entryInfoA = a(entryInfo);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f24607a.updateAppInfo(this.d, entryInfoA);
        } else {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.app.TriverLoadingController.2
                @Override // java.lang.Runnable
                public void run() {
                    TriverLoadingController.this.f24607a.updateAppInfo(TriverLoadingController.this.d, entryInfoA);
                }
            });
        }
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("ERROR_TIMEOUT with elapsed")) {
            return "ERROR_TIMEOUT with elapsed";
        }
        if (str.startsWith("syntax error,")) {
            return "syntax error json";
        }
        return str.startsWith("readIntoPackageException:") ? "readIntoPackageException" : str;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(View view) {
        this.d = view;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("ERROR_TIMEOUT with elapsed")) {
            return "ERROR_TIMEOUT with elapsed";
        }
        if (str.startsWith("syntax error,")) {
            return "syntax error json";
        }
        return str.startsWith("readIntoPackageException:") ? "readIntoPackageException" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alibaba.triver.kit.api.model.EntryInfo a(EntryInfo entryInfo) {
        JSONObject jSONObject;
        com.alibaba.triver.kit.api.model.EntryInfo entryInfo2 = new com.alibaba.triver.kit.api.model.EntryInfo();
        e eVar = new e(this.c);
        entryInfo2.appName = (entryInfo == null || TextUtils.isEmpty(entryInfo.title)) ? eVar.getAppName() : entryInfo.title;
        entryInfo2.appLogo = (entryInfo == null || TextUtils.isEmpty(entryInfo.iconUrl)) ? eVar.getAppLogo() : entryInfo.iconUrl;
        entryInfo2.desc = (entryInfo == null || TextUtils.isEmpty(entryInfo.slogan)) ? eVar.getAppDesc() : entryInfo.slogan;
        entryInfo2.frameType = eVar.getAppFrameType();
        entryInfo2.appType = eVar.getAppType();
        entryInfo2.loadingType = this.e;
        if (entryInfo != null) {
            entryInfo2.extraInfo = entryInfo.extraInfo;
        }
        if (entryInfo != null && (jSONObject = entryInfo.extraInfo) != null && jSONObject.containsKey("extendInfo")) {
            entryInfo2.subBizType = entryInfo.extraInfo.getJSONObject("extendInfo").getString(TRiverConstants.KEY_SUB_BIZ_TYPE);
            if (TextUtils.isEmpty(entryInfo2.appType)) {
                entryInfo2.appType = entryInfo.extraInfo.getJSONObject("extendInfo").getString("bizType");
            }
            if (TextUtils.isEmpty(entryInfo2.frameType)) {
                entryInfo2.frameType = entryInfo.extraInfo.getJSONObject("extendInfo").getString("frameTempType");
            }
        }
        return entryInfo2;
    }
}
