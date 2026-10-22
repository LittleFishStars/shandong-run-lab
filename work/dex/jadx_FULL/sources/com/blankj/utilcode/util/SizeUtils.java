package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class SizeUtils {

    public interface OnGetSizeListener {
        void a(View view);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f28176a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnGetSizeListener f1342a;

        public a(OnGetSizeListener onGetSizeListener, View view) {
            this.f1342a = onGetSizeListener;
            this.f28176a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnGetSizeListener onGetSizeListener = this.f1342a;
            if (onGetSizeListener != null) {
                onGetSizeListener.a(this.f28176a);
            }
        }
    }

    public SizeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static float a(float f, int i) {
        float f2;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (i == 0) {
            return f;
        }
        if (i == 1) {
            f2 = displayMetrics.density;
        } else if (i == 2) {
            f2 = displayMetrics.scaledDensity;
        } else if (i == 3) {
            f *= displayMetrics.xdpi;
            f2 = 0.013888889f;
        } else if (i == 4) {
            f2 = displayMetrics.xdpi;
        } else {
            if (i != 5) {
                return 0.0f;
            }
            f *= displayMetrics.xdpi;
            f2 = 0.03937008f;
        }
        return f * f2;
    }

    public static int b(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(View view, OnGetSizeListener onGetSizeListener) {
        view.post(new a(onGetSizeListener, view));
    }

    public static int d(View view) {
        return f(view)[1];
    }

    public static int e(View view) {
        return f(view)[0];
    }

    public static int[] f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static int g(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int h(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int i(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
