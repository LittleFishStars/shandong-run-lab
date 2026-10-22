package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class by {
    private static final Handler brv = new Handler(Looper.getMainLooper());
    private static long oe = 400;

    public static void a(Runnable runnable, Object obj, long j) {
        Handler handler = brv;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.obj = obj;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public static void b(Runnable runnable) {
        brv.removeCallbacks(runnable);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception unused) {
        }
    }

    public static boolean ir(String str) {
        return TextUtils.isEmpty(str) || str.contains(" ") || !URLUtil.isNetworkUrl(str);
    }

    public static void postOnUiThread(Runnable runnable) {
        brv.post(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            brv.post(runnable);
        }
    }

    public static void runOnUiThreadDelay(Runnable runnable, long j) {
        brv.postDelayed(runnable, j);
    }

    public static void s(Object obj) {
        brv.removeCallbacksAndMessages(obj);
    }

    public static void t(Object obj) {
        brv.removeCallbacksAndMessages(obj);
    }

    @SuppressLint({"MissingPermission"})
    public static void vibrate(Context context, Vibrator vibrator, long j) {
        if (vibrator != null) {
            try {
                if (aw.aA(context, "android.permission.VIBRATE") == 0) {
                    vibrator.vibrate(VibrationEffect.createOneShot(j, -1));
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    public static String y(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            return TextUtils.isEmpty(stackTraceString) ? th.toString() : stackTraceString;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void b(Context context, Vibrator vibrator) {
        if (vibrator == null || aw.aA(context, "android.permission.VIBRATE") != 0) {
            return;
        }
        vibrator.cancel();
    }

    @SuppressLint({"MissingPermission"})
    public static void a(Context context, Vibrator vibrator) {
        vibrate(context, vibrator, oe);
    }
}
