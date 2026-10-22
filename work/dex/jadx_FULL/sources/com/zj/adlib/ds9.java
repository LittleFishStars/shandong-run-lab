package com.zj.adlib;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ds9 {
    public static void a(View view) {
        view.setFocusable(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setFocusable(false);
            if (childAt instanceof ViewGroup) {
                a(childAt);
            }
        }
    }

    public static boolean b() {
        return TextUtils.getLayoutDirectionFromLocale(Utils.a().getResources().getConfiguration().getLocales().get(0)) == 1;
    }

    public static View c(@LayoutRes int i) {
        return ((LayoutInflater) Utils.a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }

    public static void d(Runnable runnable) {
        i.T0(runnable);
    }

    public static void e(Runnable runnable, long j) {
        i.U0(runnable, j);
    }

    public static void f(View view, boolean z) {
        g(view, z, null);
    }

    public static void g(View view, boolean z, View... viewArr) {
        if (view == null) {
            return;
        }
        if (viewArr != null) {
            for (View view2 : viewArr) {
                if (view == view2) {
                    return;
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                g(viewGroup.getChildAt(i), z, viewArr);
            }
        }
        view.setEnabled(z);
    }
}
