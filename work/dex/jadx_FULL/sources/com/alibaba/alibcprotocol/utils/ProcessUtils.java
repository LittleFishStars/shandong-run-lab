package com.alibaba.alibcprotocol.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.byazt.hv.TTDownloadField;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProcessUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f23638a;

    public static boolean isComponentProcess(Context context) {
        String str;
        if (f23638a == null) {
            if (context == null) {
                str = null;
                break;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == Process.myPid()) {
                    str = next.processName;
                    break;
                }
            }
            f23638a = Boolean.valueOf(!TextUtils.isEmpty(str) && str.contains(":wml"));
        }
        AlibcLogger.d("ProcessUtils", "isComponentProcess: " + f23638a);
        return f23638a.booleanValue();
    }
}
