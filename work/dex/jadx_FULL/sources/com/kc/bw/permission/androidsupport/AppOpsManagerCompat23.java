package com.kc.bw.permission.androidsupport;

import android.app.AppOpsManager;
import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppOpsManagerCompat23 {
    public static int noteOp(Context context, String str, int i, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteOp(str, i, str2);
    }

    public static int noteProxyOp(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static String permissionToOp(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
