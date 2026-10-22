package com.byazt.vx;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr {
    public static String c;

    public static boolean c(Context context) {
        try {
            String packageName = context.getPackageName();
            return !TextUtils.isEmpty(packageName) && packageName.equalsIgnoreCase(tt(context));
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public static String tt(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strC = c();
        c = strC;
        if (!TextUtils.isEmpty(strC)) {
            return c;
        }
        String strTt = tt();
        c = strTt;
        if (!TextUtils.isEmpty(strTt)) {
            return c;
        }
        String strVe = ve(context);
        c = strVe;
        return strVe;
    }

    private static String ve(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
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
        return null;
    }

    private static String c() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    private static String tt() {
        try {
            Method declaredMethod = Class.forName(ProcessUtils.ACTIVITY_THREAD, false, Application.class.getClassLoader()).getDeclaredMethod(TRiverConstants.KEY_CURRENT_PROCESS_NAME, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }
}
