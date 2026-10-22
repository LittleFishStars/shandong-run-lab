package com.byazt.fq;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.byazt.nr.m;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1576, 91})
public class sp {
    public static Field c;
    public static boolean n;
    public static Method tt;
    public static Field uj;
    public static boolean ve;

    public static boolean a(View view) {
        return view.hasTransientState();
    }

    public static int c(View view) {
        return view.getLayoutDirection();
    }

    public static void da(View view) {
        view.stopNestedScroll();
    }

    public static int i(View view) {
        return view.getImportantForAutofill();
    }

    public static int n(View view) {
        return view.getMinimumHeight();
    }

    public static Display sp(View view) {
        return view.getDisplay();
    }

    public static float tt(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static int uj(View view) {
        return view.getMinimumWidth();
    }

    private static float ve(ViewConfiguration viewConfiguration, Context context) {
        Method method = tt;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                m.c("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static boolean x(View view) {
        return view.isAttachedToWindow();
    }

    public static void c(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int tt(View view) {
        return view.getImportantForAccessibility();
    }

    public static void c(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void tt(View view, int i) {
        view.setImportantForAutofill(i);
    }

    public static float c(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static void c(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static boolean c(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static void ve(View view) {
        view.postInvalidateOnAnimation();
    }
}
