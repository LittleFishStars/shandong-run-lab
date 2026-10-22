package com.command.core.logwriter;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.material.timepicker.TimeModel;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LogUtils {
    public static boolean DEBUG = false;
    public static String TAG = "LogWriter";

    private static void _d(String str, Object obj) {
        StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
        Log.d(str, targetStackTraceElement.getMethodName() + "(" + targetStackTraceElement.getFileName() + u15.f19942b + targetStackTraceElement.getLineNumber() + ")");
        StringBuilder sb = new StringBuilder();
        sb.append(obj == null ? "null" : obj.toString());
        sb.append("\n\u3000");
        Log.d(str, sb.toString());
    }

    public static void d(@NonNull String str, @NonNull Object... objArr) {
        if (DEBUG) {
            if (str.contains("%s") || str.contains(TimeModel.NUMBER_FORMAT)) {
                _d(TAG, String.format(str, objArr));
            } else {
                _d(str, objArr);
            }
        }
    }

    public static void dd(Object obj) {
        if (DEBUG) {
            Log.e(TAG, obj == null ? "null" : obj.toString());
        }
    }

    private static StackTraceElement getTargetStackTraceElement() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            boolean zEquals = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (z && !zEquals) {
                return stackTraceElement;
            }
            i++;
            z = zEquals;
        }
        return null;
    }
}
