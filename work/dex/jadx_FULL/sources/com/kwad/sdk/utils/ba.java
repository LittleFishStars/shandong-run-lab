package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.hv.TTDownloadField;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ba {
    private static String bpX = "";
    private static volatile Boolean bpY;

    private static String VY() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String VZ() {
        try {
            Object objCallStaticMethod = ab.callStaticMethod(Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()), TRiverConstants.KEY_CURRENT_PROCESS_NAME, new Object[0]);
            return objCallStaticMethod instanceof String ? (String) objCallStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String dM(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(bpX)) {
            return bpX;
        }
        String strVY = VY();
        bpX = strVY;
        if (!TextUtils.isEmpty(strVY)) {
            return bpX;
        }
        String strVZ = VZ();
        bpX = strVZ;
        if (!TextUtils.isEmpty(strVZ)) {
            return bpX;
        }
        String strDM = dM(context);
        bpX = strDM;
        return strDM;
    }

    public static boolean isInMainProcess(Context context) {
        if (bpY == null) {
            String processName = getProcessName(context);
            bpY = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return bpY.booleanValue();
    }
}
