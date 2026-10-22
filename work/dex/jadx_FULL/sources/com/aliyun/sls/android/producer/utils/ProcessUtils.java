package com.aliyun.sls.android.producer.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ProcessUtils {
    private static String sProcessName;

    public static String getCurrentProcessName(Context context) throws Throwable {
        if (!TextUtils.isEmpty(sProcessName)) {
            return sProcessName;
        }
        String processNameByApplication = getProcessNameByApplication();
        if (!TextUtils.isEmpty(processNameByApplication)) {
            sProcessName = processNameByApplication;
            return processNameByApplication;
        }
        String processNameViaLinuxFile = getProcessNameViaLinuxFile();
        if (!TextUtils.isEmpty(processNameViaLinuxFile)) {
            sProcessName = processNameViaLinuxFile;
            return processNameViaLinuxFile;
        }
        String processNameViaActivityManager = getProcessNameViaActivityManager(context);
        if (TextUtils.isEmpty(processNameViaActivityManager)) {
            return sProcessName;
        }
        sProcessName = processNameViaActivityManager;
        return processNameViaActivityManager;
    }

    private static String getProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    private static String getProcessNameViaActivityManager(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static String getProcessNameViaLinuxFile() throws Throwable {
        FileInputStream fileInputStream;
        int i;
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/" + Process.myPid() + "/cmdline");
            try {
                i = fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception unused) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                i = 0;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (i > 0) {
            return new String(bArr, 0, i).trim();
        }
        return null;
    }

    public static boolean isInProcess(Context context, String processName) {
        return processName != null && processName.equalsIgnoreCase(getCurrentProcessName(context));
    }

    public static boolean isMainProcess(Context context) {
        return isInProcess(context, context.getPackageName());
    }
}
