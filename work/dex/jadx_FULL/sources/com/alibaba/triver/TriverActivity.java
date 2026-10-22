package com.alibaba.triver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.activity.ActivityHelper;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.console.DebugConsolePoint;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.app.TriverLoadingController;
import com.alibaba.triver.app.d;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.container.ContainerAnimModel;
import com.alibaba.triver.container.TriverContainerHelper;
import com.alibaba.triver.impl.InitializerPrinter;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IReloadable;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.StatusBarUtils;
import com.alibaba.triver.kit.api.utils.TRLanguageManager;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.point.TriverAnalyticsPoint;
import com.alibaba.triver.point.TriverLifecyclePoint;
import com.alibaba.triver.trace.c;
import com.taobao.accs.client.GlobalClientInfo;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverActivity extends FragmentActivity {
    private static final String c = "TriverActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ActivityHelper f24602a;
    protected TriverContainerHelper b;
    private String e;
    private String f;
    private int g;
    private long h;
    private long i;
    private String j;
    private volatile long k;
    private boolean l;
    private boolean d = false;
    private long m = 0;
    private Set<a> n = Collections.synchronizedSet(new HashSet());
    private com.alibaba.triver.engine.a o = new com.alibaba.triver.engine.a();
    private long p = System.currentTimeMillis();

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        IConfigProxy iConfigProxy = (IConfigProxy) RVProxy.get(IConfigProxy.class);
        if (iConfigProxy != null && !"true".equals(iConfigProxy.getConfigsByGroupAndName("triver_common_config", "i18nEnable", ""))) {
            TRLanguageManager.getInstance().updateLanguage(this);
        }
        this.h = SystemClock.elapsedRealtime();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            if (TROrangeController.enableActivityBackKeyIntercept() && 4 == keyEvent.getKeyCode()) {
                Iterator<a> it = this.n.iterator();
                while (it.hasNext()) {
                    if (it.next().a(keyEvent)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        ActivityHelper activityHelper;
        a(this.e, this.i);
        if (this.f24602a != null) {
            OnPreloadPoint onPreloadPoint = (OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create();
            ActivityHelper activityHelper2 = this.f24602a;
            onPreloadPoint.closeAppPointPreload(activityHelper2 != null ? activityHelper2.getApp() : null);
            com.alibaba.triver.trace.b.a(c.f, c.O, TRiverUtils.getSessionId(this.f24602a.getApp()), this.e, (JSONObject) null);
        }
        super.finish();
        ActivityHelper activityHelper3 = this.f24602a;
        if (activityHelper3 != null) {
            activityHelper3.doCommonDestroy();
        }
        TriverContainerHelper triverContainerHelper = this.b;
        if (triverContainerHelper != null) {
            triverContainerHelper.b();
        }
        if (TROrangeController.enableVConsole() && (activityHelper = this.f24602a) != null && activityHelper.getApp() != null) {
            ((DebugConsolePoint) ExtensionPoint.as(DebugConsolePoint.class).node(this.f24602a.getApp()).create()).removeConsoleView();
        }
        com.alibaba.triver.engine.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
        }
        d();
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.G, null, "AppExit", this.e, null, null);
        com.alibaba.triver.trace.b.a(c.d, c.G, TRiverUtils.getSessionId(b()), b(), (JSONObject) null);
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        a(this.e, this.i);
        OnPreloadPoint onPreloadPoint = (OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create();
        ActivityHelper activityHelper = this.f24602a;
        onPreloadPoint.closeAppPointPreload(activityHelper != null ? activityHelper.getApp() : null);
        super.finishAndRemoveTask();
        ActivityHelper activityHelper2 = this.f24602a;
        if (activityHelper2 != null) {
            activityHelper2.doCommonDestroy();
        }
        TriverContainerHelper triverContainerHelper = this.b;
        if (triverContainerHelper != null) {
            triverContainerHelper.b();
        }
        d();
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.G, null, "AppExit", this.e, null, null);
        com.alibaba.triver.trace.b.a(c.d, c.G, TRiverUtils.getSessionId(b()), b(), (JSONObject) null);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        a(this.e, this.i);
        boolean zMoveTaskToBack = super.moveTaskToBack(z);
        if (zMoveTaskToBack) {
            OnPreloadPoint onPreloadPoint = (OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create();
            ActivityHelper activityHelper = this.f24602a;
            onPreloadPoint.closeAppPointPreload(activityHelper != null ? activityHelper.getApp() : null);
            if (this.f24602a != null) {
                ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onMoveBackground(this.e, this.f, null);
                IpcClientUtils.sendMsgToServerByApp(this.f24602a.getApp(), 101, null);
                d();
            }
            TriverContainerHelper triverContainerHelper = this.b;
            if (triverContainerHelper != null) {
                triverContainerHelper.e();
            }
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.H, null, "AppExit", this.e, null, null);
            com.alibaba.triver.trace.b.a(c.d, c.H, TRiverUtils.getSessionId(b()), b(), (JSONObject) null);
        }
        return zMoveTaskToBack;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TriverContainerHelper triverContainerHelper = this.b;
        if (triverContainerHelper != null) {
            triverContainerHelper.a(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        StartClientBundle startClientBundle;
        final Bundle bundle2;
        super.onCreate(bundle);
        try {
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.skipPage(this);
            }
        } catch (RuntimeException e) {
            RVLogger.d(Log.getStackTraceString(e));
        }
        Triver.initNecessary(getApplication());
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Container", "Activity onCreate");
        KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
        if (kVStorageProxy instanceof IReloadable) {
            ((IReloadable) kVStorageProxy).reload();
        }
        this.m = System.currentTimeMillis();
        try {
            if (TROrangeController.enableIDEPush() && GlobalClientInfo.getInstance(this).getService("taobao-mini-application") == null) {
                GlobalClientInfo.getInstance(this).registerService("taobao-mini-application", "com.alibaba.triver.TRACCSService");
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        final Intent intent = getIntent();
        try {
            intent.getExtras().setClassLoader(getClassLoader());
            startClientBundle = (StartClientBundle) BundleUtils.getParcelable(intent.getExtras(), RVConstants.EXTRA_ARIVER_START_BUNDLE);
            if (startClientBundle != null) {
                try {
                    bundle2 = startClientBundle.startParams;
                } catch (Exception e2) {
                    e = e2;
                    RVLogger.e(c, e);
                    bundle2 = null;
                }
            } else {
                bundle2 = null;
            }
        } catch (Exception e3) {
            e = e3;
            startClientBundle = null;
        }
        if (bundle2 != null) {
            HashMap map = new HashMap();
            map.put("startParamsBundle", startClientBundle);
            map.put("context", this);
            ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).createActivityPreload(map);
        }
        RVInitializer.setPrinter(new InitializerPrinter());
        RVInitializer.init(getApplication());
        ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).setToolsOpen(false);
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onCreate();
        try {
            if (intent == null) {
                TriverToastUtils.showToast(this, getString(R.string.triver_system_error));
                if (isTaskRoot()) {
                    RVLogger.e(c, "intent is null, finishAndRemoveTask");
                    finishAndRemoveTask();
                    return;
                } else {
                    RVLogger.e(c, "intent is null, finish");
                    finish();
                    return;
                }
            }
            intent.setExtrasClassLoader(getClassLoader());
            this.i = intent.getLongExtra("record_token", -1L);
            this.e = intent.getStringExtra("record_id");
            com.alibaba.triver.trace.b.a(c.d, c.C, TRiverUtils.getSessionId(bundle2), this.e, (JSONObject) null);
            if (intent.getExtras() == null) {
                TriverToastUtils.showToast(this, getString(R.string.triver_system_error));
                if (isTaskRoot()) {
                    RVLogger.e(c, "startClientBundle is null, finishAndRemoveTask");
                    finishAndRemoveTask();
                } else {
                    RVLogger.e(c, "startClientBundle is null, finish");
                    finish();
                }
                a(this.e, this.i);
                b(this.e, this.i);
                return;
            }
            intent.getExtras().setClassLoader(getClassLoader());
            if (startClientBundle == null) {
                TriverToastUtils.showToast(this, getString(R.string.triver_system_error));
                if (isTaskRoot()) {
                    RVLogger.e(c, "startClientBundle is null, finishAndRemoveTask");
                    finishAndRemoveTask();
                } else {
                    RVLogger.e(c, "startClientBundle is null, finish");
                    finish();
                }
                a(this.e, this.i);
                b(this.e, this.i);
                return;
            }
            if (bundle2 != null) {
                try {
                    if (CommonUtils.isApkDebug(this) && bundle2.getBoolean(TRiverConstants.KEY_ANALYTICS_ENABLE, true)) {
                        ((TriverAnalyticsPoint) ExtensionPoint.as(TriverAnalyticsPoint.class).create()).onStartSuccess(this, bundle2);
                    }
                } catch (Throwable unused) {
                }
                this.l = bundle2.getBoolean("needTargetAppStatus", false);
                this.j = bundle2.getString(RVStartParams.KEY_CHINFO);
                this.g = "1".equals(bundle2.getString(TRiverConstants.KEY_LOADING_TYPE)) ? 1 : 0;
                this.e = bundle2.getString(TRiverConstants.KEY_APP_ID);
                this.f = bundle2.getString(TRiverConstants.KEY_ORI_URL);
            }
            Bundle bundle3 = startClientBundle.sceneParams;
            if (bundle3 == null || !bundle3.getBoolean(ITriverToolsProxy.IS_TOOLS_OPEN)) {
                ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).setToolsOpen(false);
            } else {
                ((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).setToolsOpen(true);
            }
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.y, null, TrackId.Stub_AppStart, this.e, null, null);
            com.alibaba.triver.trace.b.a(c.d, c.y, TRiverUtils.getSessionId(bundle2), this.e, (JSONObject) null);
            ContainerAnimModel containerAnimModel = (ContainerAnimModel) getIntent().getSerializableExtra(TRiverConstants.KEY_CONTAINER_ANIM);
            if (containerAnimModel != null) {
                overridePendingTransition(containerAnimModel.frontEnterAnim, containerAnimModel.backgroundEnterAnim);
            }
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Container", "First loading show");
            com.alibaba.triver.trace.b.a(c.f, c.M, TRiverUtils.getSessionId(bundle2), this.e, (JSONObject) null);
            ActivityHelper activityHelper = new ActivityHelper(this) { // from class: com.alibaba.triver.TriverActivity.1
                @Override // com.alibaba.ariver.app.activity.ActivityHelper
                public AppContext createAppContext(App app, FragmentActivity fragmentActivity) {
                    LaunchMonitorData launchMonitorData = new LaunchMonitorData();
                    if (app != null) {
                        app.setData(LaunchMonitorData.class, launchMonitorData);
                    }
                    launchMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_FINISH);
                    com.alibaba.triver.trace.b.a(c.f, c.N, TRiverUtils.getSessionId(bundle2), TriverActivity.this.e, (JSONObject) null);
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Container", "End app create");
                    if (app != null) {
                        app.putLongValue("startContainerTime", TriverActivity.this.m);
                    }
                    if (TriverActivity.this.o != null) {
                        TriverActivity.this.o.a(app);
                    }
                    TriverLoadingController triverLoadingController = new TriverLoadingController(TriverActivity.this, app, intent.getBooleanExtra("hideAppLoading", false));
                    triverLoadingController.a(TriverActivity.this.g);
                    triverLoadingController.a(TriverActivity.this.findViewById(R.id.triver_loading_container));
                    return new d(getApp(), triverLoadingController, (ViewGroup) fragmentActivity.findViewById(R.id.trv_fragment_container), (ViewGroup) fragmentActivity.findViewById(R.id.trv_tab_container), TriverActivity.this);
                }
            };
            this.f24602a = activityHelper;
            activityHelper.setupParams(getIntent());
            setContentView(R.layout.triver_activity_main);
            this.f24602a.onCreate();
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Container", "Start app create");
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(this.f24602a.getApp(), "appStartType", "normal");
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.f24602a.getApp(), PerfId.attachContext, this.h);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(this.f24602a.getApp(), PerfId.activityCreated);
            StatusBarUtils.changeStyle(this, true);
            com.alibaba.triver.ipc.a.a((AppNode) this.f24602a.getApp());
            TriverContainerHelper triverContainerHelper = new TriverContainerHelper(this);
            this.b = triverContainerHelper;
            triverContainerHelper.a(this.f24602a.getApp());
            this.b.a(this.f24602a.getApp(), getApplicationContext());
        } catch (Exception e4) {
            RVLogger.e(c, "onCreate fail:", e4);
            TriverToastUtils.showToast(this, getString(R.string.triver_system_error));
            if (isTaskRoot()) {
                RVLogger.e(c, "onCreate exception, finishAndRemoveTask");
                finishAndRemoveTask();
            } else {
                RVLogger.e(c, "onCreate exception, finish");
                finish();
            }
            a(this.e, this.i);
            b(this.e, this.i);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.doCommonDestroy();
            TriverContainerHelper triverContainerHelper = this.b;
            if (triverContainerHelper != null) {
                triverContainerHelper.a();
            }
            super.onDestroy();
        } else {
            super.onDestroy();
        }
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onDestroy(this.e, this.f, null);
        if (this.l) {
            Intent intent = new Intent(TRiverConstants.ACTION_NOTIFY_TARGET_APP_STATUS);
            intent.putExtra("appId", this.e);
            intent.putExtra("targetAppStatus", "cancel");
            sendBroadcast(intent);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (TRiverUrlUtils.isShop(this.f) && System.currentTimeMillis() - this.p < TBShopOrangeController.shopBackWaitTime()) {
                return true;
            }
            if (!TRiverUrlUtils.isShop(this.f) && System.currentTimeMillis() - this.p < TROrangeController.miniAppBackWaitTime()) {
                return true;
            }
        }
        ActivityHelper activityHelper = this.f24602a;
        return activityHelper != null ? activityHelper.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.alibaba.triver.trace.b.a(c.d, c.A, TRiverUtils.getSessionId(b()), this.e, (JSONObject) null);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.A, null, TrackId.Stub_AppStart, this.e, null, null);
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onMoveForeground(this.e, this.f, null);
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onNewIntent(intent);
        }
        setIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onPause(this.e, this.f, null);
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onPause();
        }
        TriverContainerHelper triverContainerHelper = this.b;
        if (triverContainerHelper != null) {
            triverContainerHelper.d();
        }
        if (TRiverUrlUtils.isShop(this.f)) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.taobao.shop.TB_SHOP_AC_PAUSE"));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Intent intent = new Intent(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT);
        intent.putExtra(RequestPermission.REQUEST_CODE, i);
        intent.putExtra(RequestPermission.GRANT_RESULTS, iArr);
        intent.putExtra(RequestPermission.PERMISSIONS, strArr);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onRequestPermissionResult(i, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.pageAppearDonotSkip(this);
            }
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onResume(this.e, this.f, null);
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onResume();
        }
        TriverContainerHelper triverContainerHelper = this.b;
        if (triverContainerHelper != null) {
            triverContainerHelper.c();
        }
        if (TRiverUrlUtils.isShop(this.f)) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.taobao.shop.TB_SHOP_AC_RESUME"));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onStop();
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            activityHelper.onUserLeaveHint();
        }
    }

    private void d() {
        ContainerAnimModel containerAnimModel;
        if (getIntent() == null || (containerAnimModel = (ContainerAnimModel) getIntent().getSerializableExtra(TRiverConstants.KEY_CONTAINER_ANIM)) == null) {
            return;
        }
        overridePendingTransition(containerAnimModel.frontExitAnim, containerAnimModel.backgroundExitAnim);
    }

    public String a() {
        return this.e;
    }

    public App b() {
        ActivityHelper activityHelper = this.f24602a;
        if (activityHelper != null) {
            return activityHelper.getApp();
        }
        return null;
    }

    public long c() {
        return this.i;
    }

    private void a(String str, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_START_TOKEN, j);
            bundle.putString("appId", str);
            IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 202, bundle);
        } catch (Exception e) {
            RVLogger.e(c, "startClientBundle is null, finish", e);
        }
    }

    private void b(String str, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putLong(RVConstants.EXTRA_START_TOKEN, j);
            bundle.putString("appId", str);
            IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 2, bundle);
        } catch (Exception e) {
            RVLogger.e(c, "startClientBundle is null, finish", e);
        }
    }

    public void a(a aVar) {
        this.n.add(aVar);
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.n.remove(aVar);
        }
    }
}
