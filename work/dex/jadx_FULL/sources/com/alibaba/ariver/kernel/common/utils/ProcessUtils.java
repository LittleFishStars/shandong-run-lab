package com.alibaba.ariver.kernel.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProcessUtils {
    public static final String ACTIVITY_THREAD = "android.app.ActivityThread";
    public static final String CURRENT_ACTIVITY_THREAD = "currentActivityThread";
    public static final String GET_PROCESS_NAME = "getProcessName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f24282a;
    private static Boolean b;
    private static Context c;
    private static String d;

    @Nullable
    public static Context getContext() {
        Context context = c;
        if (context != null) {
            return context;
        }
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService != null) {
            return rVEnvironmentService.getApplicationContext();
        }
        return null;
    }

    public static int getPid() {
        return Process.myPid();
    }

    public static String getProcessName() {
        try {
            String str = d;
            if (str != null && str.length() > 0) {
                return d;
            }
            try {
                d = (String) ReflectUtils.invokeMethod(ReflectUtils.invokeMethod(ACTIVITY_THREAD, CURRENT_ACTIVITY_THREAD), GET_PROCESS_NAME);
                RVLogger.d("AriverKernel", "getProcessName from ActivityThread: " + d);
            } catch (Throwable th) {
                RVLogger.e("AriverKernel", "getProcessName error!", th);
            }
            if (d == null) {
                Context context = getContext();
                if (context == null) {
                    return null;
                }
                int iMyPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        d = runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e("AriverKernel", "getProcessName error", e);
        }
        return d;
    }

    public static boolean isInTestProcess() {
        return "robolectric".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean isMainProcess() {
        if (isInTestProcess()) {
            return true;
        }
        if (f24282a == null) {
            Context context = getContext();
            if (context == null) {
                RVLogger.w("AriverKernel", "Context is null in isMainProcess()");
                return true;
            }
            String processName = getProcessName();
            f24282a = Boolean.valueOf(TextUtils.equals(processName, context.getPackageName()));
            RVLogger.d("AriverKernel", "isMainProcess " + f24282a + " processName: " + processName + " stack: " + Log.getStackTraceString(new Throwable("Just Print!")));
        }
        return f24282a.booleanValue();
    }

    public static boolean isTinyProcess() {
        if (b == null) {
            String processName = getProcessName();
            b = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.contains("lite"));
        }
        return b.booleanValue();
    }

    public static void setAppContext(Context context) {
        c = context;
    }
}
