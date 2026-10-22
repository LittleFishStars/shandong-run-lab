package com.zj.adlib;

import android.os.Vibrator;
import androidx.annotation.RequiresPermission;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pm9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Vibrator f44016a;

    public pm9() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void a() {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        try {
            vibratorB.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Vibrator b() {
        if (f44016a == null) {
            f44016a = (Vibrator) Utils.a().getSystemService("vibrator");
        }
        return f44016a;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void c(long j) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(j);
    }

    @RequiresPermission("android.permission.VIBRATE")
    public static void d(long[] jArr, int i) {
        Vibrator vibratorB = b();
        if (vibratorB == null) {
            return;
        }
        vibratorB.vibrate(jArr, i);
    }
}
