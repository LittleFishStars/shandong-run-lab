package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23121a = 112;
    public static final int b = R.id.statusbarutil_fake_status_bar_view;
    public static final int c = R.id.statusbarutil_translucent_view;
    public static final int d = -123;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f23122a;

        public a(CoordinatorLayout coordinatorLayout) {
            this.f23122a = coordinatorLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23122a.requestLayout();
        }
    }

    public static int a(@ColorInt int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (i2 / 255.0f);
        return ((int) (((double) ((i & 255) * f)) + 0.5d)) | (((int) (((double) (((i >> 16) & 255) * f)) + 0.5d)) << 16) | (-16777216) | (((int) (((double) (((i >> 8) & 255) * f)) + 0.5d)) << 8);
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        a(activity, drawerLayout, i, 112);
    }

    public static void b(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
        activity.getWindow().setStatusBarColor(a(i, i2));
    }

    public static void c(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View childAt = viewGroup.getChildAt(0);
        int iA = a((Context) activity);
        if (childAt == null || !(childAt instanceof CoordinatorLayout)) {
            viewGroup.setPadding(0, iA, 0, 0);
            viewGroup.setBackgroundColor(a(i, i2));
        } else {
            ((CoordinatorLayout) childAt).setStatusBarBackgroundColor(a(i, i2));
        }
        g(activity);
    }

    public static void d(Activity activity, @ColorInt int i) {
        b(activity, i, 112);
    }

    @Deprecated
    public static void e(Activity activity, @ColorInt int i) {
        h(activity);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View viewFindViewById = viewGroup.findViewById(b);
        if (viewFindViewById != null) {
            if (viewFindViewById.getVisibility() == 8) {
                viewFindViewById.setVisibility(0);
            }
            viewFindViewById.setBackgroundColor(i);
        } else {
            viewGroup.addView(b(activity, i));
        }
        c(activity);
    }

    public static void f(Activity activity, int i) {
        c(activity, i, 112);
    }

    public static void g(Activity activity, @ColorInt int i) {
        b(activity, i, 0);
    }

    public static void h(Activity activity, @IntRange(from = 0, to = 255) int i) {
        f(activity);
        a(activity, i);
    }

    public static void i(Activity activity, @IntRange(from = 0, to = 255) int i) {
        h(activity);
        a(activity, i);
    }

    public static void a(Activity activity, DrawerLayout drawerLayout, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
        activity.getWindow().setStatusBarColor(0);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View viewFindViewById = viewGroup.findViewById(b);
        if (viewFindViewById != null) {
            if (viewFindViewById.getVisibility() == 8) {
                viewFindViewById.setVisibility(0);
            }
            viewFindViewById.setBackgroundColor(i);
        } else {
            viewGroup.addView(b(activity, i), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), a((Context) activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
        a(drawerLayout, viewGroup);
        a(activity, i2);
    }

    public static void d(Activity activity) {
        h(activity, 112);
    }

    public static void f(Activity activity) {
        h(activity);
        c(activity);
    }

    public static void g(Activity activity) {
        activity.getWindow().setStatusBarColor(0);
        activity.getWindow().getDecorView().setSystemUiVisibility(1280);
    }

    public static void d(Activity activity, DrawerLayout drawerLayout, @IntRange(from = 0, to = 255) int i) {
        c(activity, drawerLayout);
        a(activity, i);
    }

    @TargetApi(19)
    public static void h(Activity activity) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
        activity.getWindow().addFlags(134217728);
        activity.getWindow().setStatusBarColor(0);
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        View viewFindViewById = viewGroup.findViewById(b);
        if (viewFindViewById != null) {
            if (viewFindViewById.getVisibility() == 8) {
                viewFindViewById.setVisibility(0);
            }
            viewFindViewById.setBackgroundColor(a(i, 112));
        } else {
            viewGroup.addView(b(activity, i), 0);
        }
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
        }
        a(drawerLayout, viewGroup);
    }

    public static void d(Activity activity, View view) {
        b(activity, 0, view);
    }

    @Deprecated
    public static void e(Activity activity) {
        activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
        c(activity);
    }

    public static void c(Activity activity, DrawerLayout drawerLayout, @ColorInt int i) {
        a(activity, drawerLayout, i, 0);
    }

    public static void c(Activity activity, DrawerLayout drawerLayout) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(TTAdConstant.KEY_CLICK_AREA);
        activity.getWindow().setStatusBarColor(0);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, a((Context) activity), 0, 0);
        }
        a(drawerLayout, viewGroup);
    }

    @Deprecated
    public static void b(Activity activity, DrawerLayout drawerLayout) {
        activity.getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
        drawerLayout.setFitsSystemWindows(false);
    }

    public static void a(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) drawerLayout.getChildAt(1);
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        viewGroup2.setFitsSystemWindows(false);
    }

    public static void c(Activity activity, View view) {
        a(activity, 0, view);
    }

    public static void c(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void a(Activity activity, DrawerLayout drawerLayout) {
        d(activity, drawerLayout, 112);
    }

    public static void a(Activity activity, View view) {
        a(activity, 112, view);
    }

    public static void b(Activity activity, View view) {
        b(activity, 112, view);
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        g(activity);
        a(activity, i);
        if (view != null) {
            Object tag = view.getTag(-123);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(-123, Boolean.TRUE);
            }
        }
    }

    public static void b(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        a(activity, i, view);
    }

    public static void b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View viewFindViewById = viewGroup.findViewById(b);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = viewGroup.findViewById(c);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
    }

    public static View c(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setId(c);
        return view;
    }

    public static View b(Activity activity, @ColorInt int i) {
        return a(activity, i, 0);
    }

    @TargetApi(19)
    public static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View viewFindViewById = viewGroup.findViewById(b);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View viewFindViewById = viewGroup.findViewById(c);
        if (viewFindViewById != null) {
            if (viewFindViewById.getVisibility() == 8) {
                viewFindViewById.setVisibility(0);
            }
            viewFindViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
            return;
        }
        viewGroup.addView(c(activity, i));
    }

    public static View a(Activity activity, @ColorInt int i, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(a(i, i2));
        view.setId(b);
        return view;
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android"));
    }
}
