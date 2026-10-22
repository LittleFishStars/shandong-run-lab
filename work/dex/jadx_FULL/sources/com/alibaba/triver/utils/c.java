package com.alibaba.triver.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25268a = "PerformanceUtils";

    public static float a(int i, Context context) {
        int totalPss;
        if (i == 0) {
            return 0.0f;
        }
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessMemoryInfo(new int[]{i});
            if (processMemoryInfo.length <= 0 || (totalPss = processMemoryInfo[0].getTotalPss()) < 0) {
                return 0.0f;
            }
            return totalPss / 1024.0f;
        } catch (Exception e) {
            TaoLog.e(f25268a, "getMemoryData fail: " + e.toString());
            return 0.0f;
        }
    }

    public static int a(String str, Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return 0;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (!TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo.pid;
                }
            }
        } catch (Exception e) {
            RVLogger.e(f25268a, "IsInMultiProcess exception:", e);
        }
        return 0;
    }

    public static float a(Context context) {
        return a(Process.myPid(), context);
    }

    public static long a() {
        int iCeil = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            iCeil = ((int) Math.ceil((Double.valueOf(bufferedReader.readLine().split("\\s+")[1]).doubleValue() / 1024.0d) / 1024.0d)) * 1024;
            bufferedReader.close();
        } catch (Exception e) {
            TaoLog.e(f25268a, "getDeviceTotalMemory fail: " + e.toString());
        }
        return iCeil;
    }
}
