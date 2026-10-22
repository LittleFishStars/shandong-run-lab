package com.byazt.vm;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.huawei.hms.common.PackageConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 71})
public final class x {

    @com.byazt.zqa.c(c = {0, 1, 165, 62})
    public static class c implements Runnable {
        public final Runnable c;
        public final String tt;
        public final String ve = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public c(Runnable runnable, String str) {
            this.c = runnable;
            this.tt = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } catch (Exception e) {
                com.byazt.yv.da.ve("Thread:" + this.tt + " exception\n" + this.ve, e);
            }
        }
    }

    public static boolean c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null && packageManager.getPackageInfo(PackageConstants.SERVICES_PACKAGE_ALL_SCENE, 0) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static void c(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.byazt.jtc.ve(new c(runnable, str), str).start();
    }
}
