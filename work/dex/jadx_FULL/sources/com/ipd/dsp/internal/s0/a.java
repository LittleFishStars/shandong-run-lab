package com.ipd.dsp.internal.s0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ipd.dsp.internal.c2.r;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static void a(Fragment fragment) {
        if (fragment != null) {
            View view = fragment.getView();
            a(view);
            b(fragment.getContext(), view);
        }
    }

    @SuppressLint({"BlockedPrivateApi"})
    public static void b(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || Build.VERSION.SDK_INT >= 29 || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (!(obj instanceof View)) {
                    continue;
                } else if (!context.equals(((View) obj).getContext())) {
                    return;
                } else {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
    }

    public static void a(Context context, View view) {
        a(view);
        b(context, view);
    }

    public static void a(Activity activity) {
        if (activity != null) {
            a(activity, activity.getWindow());
        }
    }

    public static void a(Context context, Window window) {
        if (window != null) {
            View decorView = window.getDecorView();
            a(decorView);
            b(context, decorView);
        }
    }

    public static synchronized void a(View view) {
        if (view != null) {
            if (view instanceof WebView) {
                try {
                    ((WebView) view).destroy();
                    return;
                } catch (Throwable th) {
                    r.a(th);
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
