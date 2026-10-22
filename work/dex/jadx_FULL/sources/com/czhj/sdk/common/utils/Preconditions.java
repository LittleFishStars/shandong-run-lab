package com.czhj.sdk.common.utils;

import android.os.Looper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.IllegalFormatException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Preconditions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29447a = "";

    public static final class NoThrow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile boolean f29448a = true;

        public static boolean checkArgument(boolean z) {
            return Preconditions.b(z, f29448a, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.b(z, f29448a, str, "");
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.b(obj, f29448a, (String) null, "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.b(obj, f29448a, str, "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.b(f29448a, str, "");
        }

        public static String getLineInfo() {
            try {
                StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
                return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getMethodName();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    private Preconditions() {
    }

    private static String a(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            SigmobLog.e("Sigmob preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strA = a(str, objArr);
        if (z) {
            throw new NullPointerException(strA);
        }
        SigmobLog.e(strA);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String strA = a(str, objArr);
        if (z) {
            throw new IllegalStateException(strA);
        }
        SigmobLog.e(strA);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String strA = a(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(strA);
        }
        SigmobLog.e(strA);
        return false;
    }

    private static boolean c(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String strA = a(str, objArr);
        if (z2) {
            throw new IllegalStateException(strA);
        }
        SigmobLog.e(strA);
        return false;
    }

    public static void checkNotNull(Object obj) {
        b(obj, true, "Object can not be null.", "");
    }
}
