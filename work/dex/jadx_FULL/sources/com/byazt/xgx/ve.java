package com.byazt.xgx;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1109, 54})
public final class ve {
    public static final String c = "ve";

    private ve() {
    }

    public static boolean c(Context context, String str) {
        return tt(context, str);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    private static boolean tt(Context context, String str) {
        byte b;
        String lowerCase;
        String str2 = c;
        m.uj(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        boolean z = true;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1888586689) {
                if (iHashCode != -63024214) {
                    if (iHashCode == -5573545 && str.equals("android.permission.READ_PHONE_STATE")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                lowerCase = "android:coarse_location";
            } else if (b != 1) {
                lowerCase = b != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state";
            } else {
                lowerCase = "android:fine_location";
            }
            int iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            m.uj(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            try {
                m.uj(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                return false;
            } catch (Exception e) {
                e = e;
                z = false;
                m.ve(c, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)), e);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
