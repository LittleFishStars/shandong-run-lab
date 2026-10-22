package com.alibaba.triver.inside.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.byazt.hv.TTDownloadField;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverEnvProxy implements RVEnvironmentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24994a = "TriverEnvProxy";
    private static Application b;
    private Activity c;
    private int d = 0;

    public TriverEnvProxy() {
        getApplicationContext().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.triver.inside.impl.TriverEnvProxy.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                TriverEnvProxy.this.c = activity;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (TriverEnvProxy.this.d == 0) {
                    TriverEnvProxy.this.c = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                TriverEnvProxy.this.c = activity;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                TriverEnvProxy.this.c = activity;
                TriverEnvProxy.access$104(TriverEnvProxy.this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                TriverEnvProxy.access$106(TriverEnvProxy.this);
            }
        });
    }

    private static Application a() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return null;
        }
    }

    public static /* synthetic */ int access$104(TriverEnvProxy triverEnvProxy) {
        int i = triverEnvProxy.d + 1;
        triverEnvProxy.d = i;
        return i;
    }

    public static /* synthetic */ int access$106(TriverEnvProxy triverEnvProxy) {
        int i = triverEnvProxy.d - 1;
        triverEnvProxy.d = i;
        return i;
    }

    public static void init(Application application) {
        b = application;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String convertPlatform(String str) {
        return TextUtils.equals("1", str) ? "AP" : "TB";
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String defaultPlatform() {
        return "TB";
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    @Nullable
    public String extractAppIdFromUrl(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppCurrency() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppExternalStoragePath() {
        return com.alibaba.triver.embed.video.a.a.a(getApplicationContext());
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppGroup() {
        return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_APP_GROUP);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppLanguage() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public int getAppLayoutDirection() {
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppName() {
        return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName");
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getAppRegion() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public Application getApplicationContext() {
        if (b == null) {
            b = a();
        }
        return b;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public int getLpid() {
        try {
            if (ProcessUtils.isMainProcess()) {
                return 0;
            }
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    String str = runningAppProcessInfo.processName;
                    if (!TextUtils.isEmpty(str)) {
                        return Integer.valueOf(str.substring(str.length() - 1)).intValue();
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return 0;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getProductId() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public String getProductVersion() {
        return ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appVersion");
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public Resources getResources(@Nullable String str) {
        return getApplicationContext().getResources();
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public WeakReference<Activity> getTopActivity() {
        return new WeakReference<>(this.c);
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public boolean isBackgroundRunning() {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVEnvironmentService
    public void openUrl(String str) {
    }
}
