package com.alibaba.triver.open;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.taobao.windvane.WindVaneSDK;
import android.taobao.windvane.b.g;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.base.ILogService;
import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVAppParams;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.service.WVUCService;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.view.EmbedViewHelper;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.TRiverSDK;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.open.api.DowngradeEnum;
import com.alibaba.triver.open.container.OpenEmbedViewHolder;
import com.alibaba.triver.open.preload.DataPreloadJob;
import com.alibaba.triver.open.proxy.IRouterProxy;
import com.taobao.uc.UCSoSettings;
import com.uc.webview.export.extension.UCCore;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.intf.Mtop;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverSDK {
    private static final String TAG = "TriverSDK";
    public static final String UC_CORE_URL_32 = "https://bcsdk.alicdn.com/8.6.2.58-U4-3-thin279/release/armeabi-v7a/libkernelu4_zip_uc.so";
    public static final String UC_CORE_URL_64 = "https://bcsdk.alicdn.com/8.6.2.58-U4-3-thin279/release/arm64-v8a/libkernelu4_zip_uc.so";
    public static final String UC_CORE_URL_DEBUG_32 = "https://bcsdk.alicdn.com/8.6.2.58-U4-3-thin279/debug/armeabi-v7a/libkernelu4_zip_uc.so";
    public static final String UC_CORE_URL_DEBUG_64 = "https://bcsdk.alicdn.com/8.6.2.58-U4-3-thin279/debug/arm64-v8a/libkernelu4_zip_uc.so";
    private static final String UC_KEY_SECRET = "AHSwIQJLjQfWVojz9qJuLs2PyBLqbdOUfZgLt7kI8OWZBY9W8z/IYC0k1GoOV7R2ONcFVURtQWj5OrK7BV8Bjw==";
    private static volatile boolean sEnable4G;
    private static volatile boolean sInit;

    /* JADX INFO: renamed from: com.alibaba.triver.open.TriverSDK$1, reason: invalid class name */
    public static class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f25021a;
        final /* synthetic */ Uri b;
        final /* synthetic */ Bundle c;
        final /* synthetic */ JSONObject d;

        public AnonymousClass1(Context context, Uri uri, Bundle bundle, JSONObject jSONObject) {
            this.f25021a = context;
            this.b = uri;
            this.c = bundle;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            double d = TextUtils.equals(TriverSDK.UC_CORE_URL_64, WVCore.c().b()) ? 20.0d : 16.5d;
            Context context = this.f25021a;
            if (context == null || !(context instanceof Activity) || ((Activity) context).isFinishing()) {
                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_UCCORE_DOWNLOAD, "ERROR_FINISH", "uc core not available activity cancel", new JSONObject());
                ((IRouterProxy) RVProxy.get(IRouterProxy.class)).downgrade(this.f25021a, null, this.b.toString(), DowngradeEnum.UC_CORE.getKey());
                return;
            }
            new AlertDialog.Builder(this.f25021a).setMessage("正在使用移动网络下载UC内核，预计消耗" + d + "M流量").setPositiveButton(com.ipd.dsp.internal.b1.b.a.n, new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.open.TriverSDK.1.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    Triver.openApp(anonymousClass1.f25021a, anonymousClass1.b, anonymousClass1.c);
                    ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.triver.open.TriverSDK.1.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                final CountDownLatch countDownLatch = new CountDownLatch(1);
                                g.a().a(new android.taobao.windvane.b.b() { // from class: com.alibaba.triver.open.TriverSDK.1.2.1.1
                                    @Override // android.taobao.windvane.b.b
                                    public void a() {
                                        super.a();
                                        countDownLatch.countDown();
                                    }
                                });
                                TriverSDK.enable4GDownload();
                                UCCore.startDownload();
                                try {
                                    countDownLatch.await(TROrangeController.waitUCInitTime() * 6, TimeUnit.MILLISECONDS);
                                } catch (InterruptedException e) {
                                    RVLogger.w(Log.getStackTraceString(e));
                                }
                                if (!WVUCWebView.getUCSDKSupport()) {
                                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_UCCORE_DOWNLOAD, "ERROR_TIMEOUT", "init failed 4G timeout", AnonymousClass1.this.d);
                                } else {
                                    AnonymousClass1.this.d.put("costTime", (Object) String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                                    AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_UCCORE_DOWNLOAD, "", "", AnonymousClass1.this.d);
                                }
                            } catch (Throwable th) {
                                AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_UCCORE_DOWNLOAD, "ERROR_EXCEPTION", "init failed on exception" + th.getLocalizedMessage(), AnonymousClass1.this.d);
                                RVLogger.w(Log.getStackTraceString(th));
                            }
                        }
                    });
                }
            }).setNegativeButton("取消并退出", new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.open.TriverSDK.1.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_UCCORE_DOWNLOAD, "Error_CANCEL", "uc core not available on cancel download", AnonymousClass1.this.d);
                    IRouterProxy iRouterProxy = (IRouterProxy) RVProxy.get(IRouterProxy.class);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    iRouterProxy.downgrade(anonymousClass1.f25021a, null, anonymousClass1.b.toString(), DowngradeEnum.UC_CORE.getKey());
                }
            }).setCancelable(false).create().show();
        }
    }

    public interface InitResultCallback {
        void onFail(String str, String str2);

        void onSuccess();
    }

    public static class a implements c {
        @Override // com.alibaba.triver.open.TriverSDK.c
        public void a(Context context) {
        }

        @Override // com.alibaba.triver.open.TriverSDK.c
        public void b(Context context) {
            TriverSDK.initPreload();
        }

        @Override // com.alibaba.triver.open.TriverSDK.c
        public void c(Context context) {
            TriverSDK.initWindVane(context);
        }

        @Override // com.alibaba.triver.open.TriverSDK.c
        public void d(Context context) {
        }
    }

    public static class b implements OpenEmbedViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EmbedViewHelper f25027a;
        private Bundle b;
        private View c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;

        private b() {
            this.d = false;
            this.e = true;
            this.f = true;
            this.g = true;
        }

        public void a(View view) {
            this.c = view;
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public View getContentView() {
            return this.c;
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public Bundle getRestoreBundle() {
            return this.b;
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public void onActivityResult(int i, int i2, Intent intent) {
            EmbedViewHelper embedViewHelper = this.f25027a;
            if (embedViewHelper != null) {
                embedViewHelper.onActivityResult(i, i2, intent);
            }
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public void onDestroy() {
            EmbedViewHelper embedViewHelper = this.f25027a;
            if (embedViewHelper != null) {
                embedViewHelper.onDestroy();
                this.d = false;
                this.e = true;
                this.f = true;
            }
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public void onPause() {
            EmbedViewHelper embedViewHelper = this.f25027a;
            if (embedViewHelper == null || this.f || this.e) {
                return;
            }
            embedViewHelper.onPause();
            this.d = false;
            this.e = true;
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public void onResume() {
            EmbedViewHelper embedViewHelper = this.f25027a;
            if (embedViewHelper == null || this.d) {
                return;
            }
            embedViewHelper.onResume();
            this.d = true;
            this.e = false;
            this.f = false;
        }

        @Override // com.alibaba.triver.open.container.OpenEmbedViewHolder
        public void onStop() {
            EmbedViewHelper embedViewHelper = this.f25027a;
            if (embedViewHelper == null || this.f) {
                return;
            }
            embedViewHelper.onStop();
            this.d = false;
            this.e = true;
            this.f = true;
        }

        public void a(EmbedViewHelper embedViewHelper) {
            this.f25027a = embedViewHelper;
        }

        public void a(Bundle bundle) {
            this.b = bundle;
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public interface c {
        void a(Context context);

        void b(Context context);

        void c(Context context);

        void d(Context context);
    }

    public static class d implements ILogService {
        private d() {
        }

        @Override // android.taobao.windvane.base.ILogService
        public void a(String str, String str2) {
            RVLogger.d(str, str2);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void b(String str, String str2) {
            RVLogger.e(str, str2);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void c(String str, String str2) {
            RVLogger.d(str, str2);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void d(String str, String str2) {
            RVLogger.d(str, str2);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void e(String str, String str2) {
            RVLogger.w(str, str2);
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.taobao.windvane.base.ILogService
        public void a(String str, String str2, Throwable th) {
            RVLogger.d(str, str2 + Log.getStackTraceString(th));
        }

        @Override // android.taobao.windvane.base.ILogService
        public void b(String str, String str2, Throwable th) {
            RVLogger.e(str, str2, th);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void c(String str, String str2, Throwable th) {
            RVLogger.d(str, str2);
        }

        @Override // android.taobao.windvane.base.ILogService
        public void d(String str, String str2, Throwable th) {
            RVLogger.d(str, str2 + Log.getStackTraceString(th));
        }

        @Override // android.taobao.windvane.base.ILogService
        public void e(String str, String str2, Throwable th) {
            RVLogger.w(str, str2, th);
        }

        @Override // android.taobao.windvane.base.ILogService
        public boolean a(int i) {
            return ILogService.LogLevelEnum.DEBUG.getLogLevel() <= i;
        }
    }

    public static class e extends WVUCService {
        public e(Context context) {
            super(context);
        }

        @Override // android.taobao.windvane.extra.service.WVUCService, android.taobao.windvane.base.IUCService
        public int getCorePolicy() {
            return 1;
        }

        @Override // android.taobao.windvane.extra.service.WVUCService, android.taobao.windvane.base.IUCService
        public boolean open4GDownload() {
            return TriverSDK.sEnable4G;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.taobao.windvane.extra.service.WVUCService, android.taobao.windvane.base.IUCService
        public void updateConfig(android.taobao.windvane.extra.core.b bVar) {
            bVar.j = "0^^*,map,camera,ai-camera,canvas,weex-view";
        }
    }

    public static void enable4GDownload() {
        sEnable4G = true;
    }

    public static void init(Application application, InitResultCallback initResultCallback) {
        init(application, null, initResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initPreload() {
        PreloadScheduler preloadScheduler = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType = PreloadScheduler.PointType.PRELOAD_RESOURCE;
        preloadScheduler.registerPreLoadJob(pointType, com.alibaba.triver.open.preload.a.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType, com.alibaba.triver.open.preload.c.class);
        PreloadScheduler preloadScheduler2 = PreloadScheduler.getInstance();
        PreloadScheduler.PointType pointType2 = PreloadScheduler.PointType.CLOSE_APP;
        preloadScheduler2.registerPreLoadJob(pointType2, com.alibaba.triver.open.preload.c.class);
        PreloadScheduler.getInstance().registerPreLoadJob(pointType2, com.alibaba.triver.open.preload.b.class);
        PreloadScheduler.getInstance().registerPreLoadJob(PreloadScheduler.PointType.DATA_PREFETCH, DataPreloadJob.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initWindVane(Context context) {
        try {
            UCSoSettings.getInstance().setUCCoreRelease64(UC_CORE_URL_64).setUCCoreRelease32(UC_CORE_URL_32).setUCCoreDebug64(UC_CORE_URL_DEBUG_64).setUCCoreDebug32(UC_CORE_URL_DEBUG_32);
            WVAppParams wVAppParams = new WVAppParams();
            wVAppParams.appKey = Mtop.instance("OPEN", context).getMtopConfig().appKey;
            wVAppParams.ttid = Mtop.instance("OPEN", context).getMtopConfig().ttid;
            wVAppParams.appVersion = "5.0.2.5";
            wVAppParams.ucsdkappkeySec = new String[]{UC_KEY_SECRET};
            new WindVaneSDK.ServiceBuilder().register(IBridgeDelegateService.class, WVBridgeDelegateImpl.class).registerObj(IUCService.class, new e(context)).registerObj(ILogService.class, new d(null)).init(context, wVAppParams);
        } catch (Exception e2) {
            RVLogger.e(TAG, "init WindVane in triver exception: " + e2.getMessage());
        }
    }

    public static void openApp(Context context, Uri uri, Bundle bundle) {
        if (sInit && TRiverUtils.isTriverUrl(uri)) {
            RVLogger.e("AriverPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:openApp] [Info:open MiniApp] [TimeStamp:" + System.currentTimeMillis() + "]", null);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, false);
            bundle2.putBundle(TRiverConstants.KEY_OVER_PARAMS, bundle);
            bundle2.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, SystemClock.elapsedRealtime());
            openAppInner(context, uri, bundle2);
        }
    }

    private static void openAppInner(Context context, Uri uri, Bundle bundle) {
        if (TextUtils.equals("wifi", WVCore.c(GlobalConfig.context))) {
            Triver.openApp(context, uri, bundle);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (!WVUCWebView.getUCSDKSupport()) {
            jSONObject.put("core_type", (Object) "download");
            ExecutorUtils.runOnMain(new AnonymousClass1(context, uri, bundle, jSONObject));
        } else {
            jSONObject.put("core_type", (Object) "exist");
            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_UCCORE_DOWNLOAD, "", "", jSONObject);
            Triver.openApp(context, uri, bundle);
        }
    }

    public static void preloadResource(Context context, JSONObject jSONObject) {
        if (sInit) {
            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.PRELOAD_RESOURCE, jSONObject);
        }
    }

    public static void renderApp(FragmentActivity fragmentActivity, Uri uri, Bundle bundle, final TriverRenderCallback triverRenderCallback) {
        if (!sInit) {
            if (triverRenderCallback != null) {
                triverRenderCallback.onFailure("AC_INIT_FAILED", "uninit");
                return;
            }
            return;
        }
        final b bVar = new b(null);
        com.alibaba.triver.b bVar2 = new com.alibaba.triver.b(fragmentActivity) { // from class: com.alibaba.triver.open.TriverSDK.2
            @Override // com.alibaba.ariver.app.view.EmbedViewHelper
            public AppContext createAppContext(App app, FragmentActivity fragmentActivity2) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, PerfId.viewCreate, this.f24672a);
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, PerfId.viewCreated);
                return new com.alibaba.triver.open.container.b(app, fragmentActivity2, 0, new com.alibaba.triver.open.container.c() { // from class: com.alibaba.triver.open.TriverSDK.2.1
                    @Override // com.alibaba.triver.open.container.c
                    public void a(View view) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (triverRenderCallback != null) {
                            bVar.a(view);
                            bVar.a(new Bundle());
                            AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                            triverRenderCallback.onSuccess(bVar);
                        }
                    }

                    @Override // com.alibaba.triver.open.container.c
                    public int b() {
                        TriverRenderCallback triverRenderCallback2 = triverRenderCallback;
                        if (triverRenderCallback2 != null) {
                            return triverRenderCallback2.getWidth();
                        }
                        return 0;
                    }

                    @Override // com.alibaba.triver.open.container.c
                    public int c() {
                        TriverRenderCallback triverRenderCallback2 = triverRenderCallback;
                        if (triverRenderCallback2 != null) {
                            return triverRenderCallback2.getHeight();
                        }
                        return 0;
                    }

                    @Override // com.alibaba.triver.open.container.c
                    public void a(String str, String str2) {
                        TriverRenderCallback triverRenderCallback2 = triverRenderCallback;
                        if (triverRenderCallback2 != null) {
                            triverRenderCallback2.onFailure(str, str2);
                        }
                    }

                    @Override // com.alibaba.triver.open.container.c
                    public void a() {
                        TriverRenderCallback triverRenderCallback2 = triverRenderCallback;
                        if (triverRenderCallback2 != null) {
                            triverRenderCallback2.onRefresh();
                        }
                    }
                });
            }
        };
        bVar.a(bVar2);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, false);
        bundle2.putBundle(TRiverConstants.KEY_OVER_PARAMS, bundle);
        bundle2.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, SystemClock.elapsedRealtime());
        bVar2.a(uri, bundle2);
        RVLogger.d(TAG, "renderApp: " + uri);
        bVar.onResume();
    }

    public static void init(Application application, c cVar, InitResultCallback initResultCallback) {
        if (!sInit) {
            sInit = true;
            if (cVar == null) {
                cVar = new a();
            }
            cVar.a(application);
            cVar.c(application);
            TRiverSDK.init(application);
            if (!ProcessUtils.isMainProcess()) {
                RVInitializer.registerBizHandler();
            }
            cVar.b(application);
            cVar.d(application);
            com.alibaba.triver.appinfo.core.c.a();
            com.alibaba.triver.appinfo.core.c.b();
        }
        initResultCallback.onSuccess();
    }

    public static void openApp(Context context, Uri uri, Bundle bundle, a aVar) {
        Bundle bundle2 = new Bundle();
        if (!sInit) {
            if (aVar == null) {
                aVar = new a();
            }
            aVar.a(context);
            aVar.c(context);
            Application application = AlibcBaseTradeCommon.context;
            if (application != null) {
                TRiverSDK.init(application);
            }
            if (!ProcessUtils.isMainProcess()) {
                RVInitializer.registerBizHandler();
            }
            aVar.b(context);
            aVar.d(context);
            com.alibaba.triver.appinfo.core.c.a();
            com.alibaba.triver.appinfo.core.c.b();
            sInit = true;
        }
        if (sInit && TRiverUtils.isTriverUrl(uri)) {
            RVLogger.e("AriverPerformance", "[Thread:" + Thread.currentThread().getName() + "] [Stage:openApp] [Info:open MiniApp] [TimeStamp:" + System.currentTimeMillis() + "]", null);
            bundle2.putBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, false);
            bundle2.putBundle(TRiverConstants.KEY_OVER_PARAMS, bundle);
            bundle2.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, SystemClock.elapsedRealtime());
            bundle2.putString(RVParams.SESSION_ID, bundle.getString(RVParams.SESSION_ID));
            openAppInner(context, uri, bundle2);
        }
    }
}
