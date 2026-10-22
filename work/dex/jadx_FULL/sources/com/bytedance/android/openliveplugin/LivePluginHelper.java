package com.bytedance.android.openliveplugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.widget.Toast;
import com.byazt.bog.a;
import com.byazt.bwm.tt;
import com.byazt.jtc.ve;
import com.bytedance.android.dy.sdk.pangle.PluginStateListener;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.JavaCallsUtils;
import com.bytedance.android.live.base.api.callback.CommonCallback;
import com.bytedance.android.live.base.api.callback.EmptyCallback;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.bytedance.gromore.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LivePluginHelper {
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final String PLAYER_PLUGIN_PACKAGE_NAME = "com.byted.ttm.player";
    private static IOuterLiveService liveRoomService;
    private static ArrayList<ILiveInitCallback> mLiveInitListeners;
    private static EmptyCallback sInstallCallback;
    public static final ScheduledExecutorService sExecutor = tt.ve(new DefaultThreadFactory());
    private static volatile boolean hasLiveInitFinish = false;
    private static boolean runInLiveProcess = false;
    private static boolean stopAppLogOnEnterBackground = false;
    private static WeakReference<Activity> hostActivity = null;
    private static final ILiveInitCallback loadingLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.6
        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            if (!LiveLoadingDialog.dismiss() || LivePluginHelper.hostActivity.get() == null) {
                return;
            }
            Toast.makeText((Context) LivePluginHelper.hostActivity.get(), R.string.live_in_loading_failed, 1).show();
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            if (LiveLoadingDialog.dismiss()) {
                LivePluginHelper.trulyEnterCommerceOrderList();
            }
        }
    };

    public static class DefaultThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        public DefaultThreadFactory() {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = "tob_douyin_live_thread_init";
        }

        public DefaultThreadFactory(String str) {
            this.threadNumber = new AtomicInteger(1);
            this.group = new ThreadGroup("tob_douyin_live_group");
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ve veVar = new ve(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (veVar.isDaemon()) {
                veVar.setDaemon(false);
            }
            if (veVar.getPriority() != 10) {
                veVar.setPriority(10);
            }
            return veVar;
        }
    }

    public static class LiveInitCallback implements ILiveInitCallback {
        public static LiveInitCallback INSTANCE = new LiveInitCallback();

        private LiveInitCallback() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            for (ILiveInitCallback iLiveInitCallback : LivePluginHelper.mLiveInitListeners) {
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFailed(str);
                    } catch (Throwable th) {
                        a.c(th);
                    }
                }
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            LivePluginHelper.logVersionInfo();
            TTLogger.d("live init : LiveInitCallbackWrapper onLiveInitFinish called.");
            LivePluginHelper.initLiveCommerce();
            boolean unused = LivePluginHelper.hasLiveInitFinish = true;
            for (ILiveInitCallback iLiveInitCallback : LivePluginHelper.mLiveInitListeners) {
                if (iLiveInitCallback != null) {
                    try {
                        iLiveInitCallback.onLiveInitFinish();
                    } catch (Throwable th) {
                        a.c(th);
                    }
                }
            }
        }
    }

    private static void adaptEventBus() {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "tryAdaptEventBus", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), ZeusPlatformUtils.getZeusActivityString(), ZeusPlatformUtils.getZeusWrapperString());
    }

    public static void addCustomTag(String str, String str2) {
        ZeusPlatformUtils.addCustomTag(str, str2);
    }

    public static void addInitListener(ILiveInitCallback iLiveInitCallback) {
        if (mLiveInitListeners == null) {
            mLiveInitListeners = new ArrayList<>();
        }
        if (iLiveInitCallback == LiveInitCallback.INSTANCE || mLiveInitListeners.contains(iLiveInitCallback) || iLiveInitCallback == null) {
            return;
        }
        mLiveInitListeners.add(iLiveInitCallback);
    }

    public static void enterCommerceOrderList(Activity activity) {
        hostActivity = new WeakReference<>(activity);
        if (isLiveInited()) {
            trulyEnterCommerceOrderList();
            return;
        }
        ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new PluginStateListener() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.5
            @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
            public void onPluginStateChanged(int i, String str) {
                if ((i == 4 || i == 7 || i == 10) && LiveLoadingDialog.dismiss() && LivePluginHelper.hostActivity.get() != null) {
                    Toast.makeText((Context) LivePluginHelper.hostActivity.get(), R.string.live_in_loading_failed, 1).show();
                }
            }
        });
        addInitListener(loadingLiveInitCallback);
        LiveLoadingDialog.show(hostActivity.get());
        if (liveRoomService == null) {
            getLiveRoomService();
        }
        IOuterLiveService iOuterLiveService = liveRoomService;
        if (iOuterLiveService != null) {
            iOuterLiveService.callExpandMethod("initSDKCoreLogic", new Object[0]);
        }
    }

    public static boolean getApmEnable() {
        return ZeusPlatformUtils.getApmEnable();
    }

    public static String getLiveArgsJsonStr() {
        return (String) JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "getLiveArgsJsonStr", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
    }

    public static IOuterLiveService getLiveRoomService() {
        if (liveRoomService == null) {
            liveRoomService = LiveReflectFacade.getOuterLiveService();
        }
        return liveRoomService;
    }

    public static boolean getStopAppLogOnEnterBackground() {
        return stopAppLogOnEnterBackground;
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
        init(application, str, builder, iLiveInitCallback, true);
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        init(application, str, builder, iLiveInitCallback, z, false);
    }

    public static void init(Application application, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z, boolean z2) {
        if (!ZeusPlatformUtils.hasInitZeus) {
            ZeusPlatformUtils.initZeus(application, z, "com.byted.live.lite");
        } else if (z) {
            ZeusPlatformUtils.fetchPlugin("com.byted.live.lite");
        }
        initLive(application, str, builder, iLiveInitCallback, z2);
    }

    public static void initLive(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback, final boolean z) {
        runInLiveProcess = z;
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2
            @Override // java.lang.Runnable
            public void run() {
                TTLogger.d("live init : async start init live ~~~");
                if (LivePluginHelper.prepare(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTLogger.d("live init : runnable real init live ---- ");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback, z);
                    }
                })) {
                    TTLogger.d("live init : prepared-start real init live ---- ");
                    LivePluginHelper.realInitLivePlugin(application, str, builder, iLiveInitCallback, z);
                }
            }
        });
    }

    public static void initLiveCommerce() {
        try {
            adaptEventBus();
            JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.ecom.live.adapter.ECLiveAdapter", "init", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
        } catch (Exception e) {
            a.c(e);
        }
    }

    public static boolean isLiveInited() {
        return hasLiveInitFinish;
    }

    public static boolean isRunInLiveProcess() {
        return runInLiveProcess;
    }

    public static void logEventV3(String str, JSONObject jSONObject) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "onEventV3", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logVersionInfo() {
        Object objCallStaticMethodWithClassLoader = JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.plugin.LivePluginApplication", "getPluginVersion", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), new Object[0]);
        if (objCallStaticMethodWithClassLoader == null) {
            return;
        }
        try {
            Pair pair = (Pair) objCallStaticMethodWithClassLoader;
            a.ve("live init", "version_info: lib_version_name=2.1.1.4-tob-tob-61440787; sdkApiVersionName=2.1.1.4-tob-tob-61440787; pluginVersionCode=" + ((Long) pair.first).longValue() + "; pluginVersionName=" + ((String) pair.second));
        } catch (Throwable th) {
            a.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean prepare(Runnable runnable) {
        EmptyCallback emptyCallback;
        TTLogger.d("live init : prepare ---- ");
        ZeusPlatformUtils.registerZeusPluginLoadStateListener("com.byted.live.lite", new PluginStateListener() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.4
            @Override // com.bytedance.android.dy.sdk.pangle.PluginStateListener
            public void onPluginStateChanged(int i, String str) {
                if (i != 6 || LivePluginHelper.sInstallCallback == null) {
                    return;
                }
                LivePluginHelper.sInstallCallback.invoke();
            }
        });
        if (ZeusPlatformUtils.isPluginInstalled("com.byted.live.lite") && (emptyCallback = sInstallCallback) != null) {
            emptyCallback.invoke();
        }
        return ZeusPlatformUtils.checkPluginState(runnable, "com.byted.live.lite");
    }

    private static void preparePlayer(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (LivePluginHelper.prepare(runnable)) {
                    runnable.run();
                }
            }
        };
        if (ZeusPlatformUtils.checkPluginState(runnable2, PLAYER_PLUGIN_PACKAGE_NAME)) {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realInitLivePlugin(final Application application, final String str, final ILiveHostContextParam.Builder builder, final ILiveInitCallback iLiveInitCallback, final boolean z) {
        sExecutor.execute(new Runnable() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.1
            @Override // java.lang.Runnable
            public void run() {
                LivePluginHelper.addInitListener(iLiveInitCallback);
                if (LivePluginHelper.getStopAppLogOnEnterBackground()) {
                    HashMap map = new HashMap();
                    map.put("stop_applog_on_background", "1");
                    builder.addHostInitExtra(map);
                }
                LiveReflectFacade.initLiveInPlugin(application, str, builder, z, LiveInitCallback.INSTANCE);
            }
        });
    }

    public static void setApmEnable(boolean z) {
        ZeusPlatformUtils.setApmEnable(z);
    }

    public static void setBoeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setBoeValue", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setHostVersionCodeTag(long j) {
        ZeusPlatformUtils.setHostVersionCodeTag(j);
    }

    public static void setInstallCallback(EmptyCallback emptyCallback) {
        sInstallCallback = emptyCallback;
    }

    public static void setPpeValue(String str) {
        JavaCallsUtils.callStaticMethodWithClassLoader("com.bytedance.android.openlive.OpenLiveBackdoor", "setPpeValue", ZeusPlatformUtils.getPluginClassloader("com.byted.live.lite"), str);
    }

    public static void setStopAppLogOnEnterBackground(boolean z) {
        stopAppLogOnEnterBackground = z;
    }

    public static void trulyEnterCommerceOrderList() {
        TTLogger.d("trulyEnterCommerceOrderList start");
        if (liveRoomService == null) {
            getLiveRoomService();
        }
        if (liveRoomService == null) {
            return;
        }
        try {
            TTLogger.d("callExpandMethod enterCommercePage");
            liveRoomService.callExpandMethod("enterCommercePage", new JSONObject().put("request_page", "order_list"), new CommonCallback<String, String>() { // from class: com.bytedance.android.openliveplugin.LivePluginHelper.7
                @Override // com.bytedance.android.live.base.api.callback.CommonCallback
                public void onFail(String str) {
                    TTLogger.d("get enterCommercePage fail, error msg = ".concat(String.valueOf(str)));
                }

                @Override // com.bytedance.android.live.base.api.callback.CommonCallback
                public void onSuccess(String str) {
                    TTLogger.d("get enterCommercePage success, result = ".concat(String.valueOf(str)));
                    LivePluginHelper.liveRoomService.handleSchema((Context) LivePluginHelper.hostActivity.get(), Uri.parse(str));
                }
            }, 2000L);
        } catch (JSONException e) {
            a.c(e);
        }
    }
}
