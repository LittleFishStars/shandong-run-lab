package com.acse.ottn;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f23133a;

    public static void a(Application application) {
        f23133a = application;
    }

    public static Application b() {
        return f23133a;
    }

    public static void c(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static void d(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(1, 2);
    }

    public static void a() {
        n4.c().b();
    }

    public static void b(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    public static boolean a(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                if (runningAppProcessInfo.importance == 400) {
                    Log.i("后台", runningAppProcessInfo.processName);
                    return true;
                }
                Log.i("前台", runningAppProcessInfo.processName);
                break;
            }
        }
        return false;
    }

    public static void a(Activity activity) {
        activity.getWindow().setSoftInputMode(3);
    }

    public static void a(View view, Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
    }
}
