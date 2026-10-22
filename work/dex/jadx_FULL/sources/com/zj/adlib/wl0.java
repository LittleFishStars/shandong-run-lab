package com.zj.adlib;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.drawerlayout.widget.DrawerLayout;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.gyf.immersionbar.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class wl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45618a = -123;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20462a = "TAG_STATUS_BAR";
    public static final String b = "TAG_OFFSET";

    public wl0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void A(@NonNull Activity activity, boolean z) {
        B(activity.getWindow(), z);
    }

    public static void B(@NonNull Window window, boolean z) {
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(j(id))) {
                childAt.setVisibility(z ? 0 : 4);
            }
        }
        if (z) {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4611));
        } else {
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    @RequiresPermission("android.permission.EXPAND_STATUS_BAR")
    public static void C(boolean z) {
        n(z ? "expandNotificationsPanel" : "collapsePanels");
    }

    public static View D(@NonNull Activity activity, @ColorInt int i) {
        return E(activity, i, false);
    }

    public static View E(@NonNull Activity activity, @ColorInt int i, boolean z) {
        S(activity);
        return c(activity, i, z);
    }

    public static View F(@NonNull Window window, @ColorInt int i) {
        return G(window, i, false);
    }

    public static View G(@NonNull Window window, @ColorInt int i, boolean z) {
        T(window);
        return d(window, i, z);
    }

    public static void H(@NonNull View view, @ColorInt int i) {
        Activity activityH = i.H(view.getContext());
        if (activityH == null) {
            return;
        }
        S(activityH);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = k();
        view.setBackgroundColor(i);
    }

    public static void I(@NonNull DrawerLayout drawerLayout, @NonNull View view, @ColorInt int i) {
        J(drawerLayout, view, i, false);
    }

    public static void J(@NonNull DrawerLayout drawerLayout, @NonNull View view, @ColorInt int i, boolean z) {
        Activity activityH = i.H(view.getContext());
        if (activityH == null) {
            return;
        }
        S(activityH);
        drawerLayout.setFitsSystemWindows(false);
        H(view, i);
        int childCount = drawerLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            drawerLayout.getChildAt(i2).setFitsSystemWindows(false);
        }
        if (z) {
            l(activityH);
        } else {
            E(activityH, i, false);
        }
    }

    public static void K(@NonNull View view) {
        Activity activityH = i.H(view.getContext());
        if (activityH == null) {
            return;
        }
        S(activityH);
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, k()));
        } else {
            layoutParams.width = -1;
            layoutParams.height = k();
        }
    }

    public static void L(@NonNull Activity activity, boolean z) {
        M(activity.getWindow(), z);
    }

    public static void M(@NonNull Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static void N(@NonNull Activity activity, boolean z) {
        O(activity.getWindow(), z);
    }

    public static void O(@NonNull Window window, boolean z) {
        if (z) {
            window.clearFlags(1024);
            P(window);
            b(window);
        } else {
            window.addFlags(1024);
            m(window);
            R(window);
        }
    }

    public static void P(@NonNull Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(f20462a);
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(0);
    }

    public static void Q(@NonNull View view) {
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - k(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        view.setTag(-123, Boolean.FALSE);
    }

    public static void R(@NonNull Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(b);
        if (viewFindViewWithTag == null) {
            return;
        }
        Q(viewFindViewWithTag);
    }

    public static void S(@NonNull Activity activity) {
        T(activity.getWindow());
    }

    public static void T(@NonNull Window window) {
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }

    public static void a(@NonNull View view) {
        view.setTag(b);
        Object tag = view.getTag(-123);
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + k(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(-123, Boolean.TRUE);
        }
    }

    public static void b(@NonNull Window window) {
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(b);
        if (viewFindViewWithTag == null) {
            return;
        }
        a(viewFindViewWithTag);
    }

    public static View c(@NonNull Activity activity, int i, boolean z) {
        return d(activity.getWindow(), i, z);
    }

    public static View d(@NonNull Window window, int i, boolean z) {
        ViewGroup viewGroup = z ? (ViewGroup) window.getDecorView() : (ViewGroup) window.findViewById(R.id.content);
        View viewFindViewWithTag = viewGroup.findViewWithTag(f20462a);
        if (viewFindViewWithTag == null) {
            View viewE = e(window.getContext(), i);
            viewGroup.addView(viewE);
            return viewE;
        }
        if (viewFindViewWithTag.getVisibility() == 8) {
            viewFindViewWithTag.setVisibility(0);
        }
        viewFindViewWithTag.setBackgroundColor(i);
        return viewFindViewWithTag;
    }

    public static View e(@NonNull Context context, int i) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, k()));
        view.setBackgroundColor(i);
        view.setTag(f20462a);
        return view;
    }

    public static int f() {
        TypedValue typedValue = new TypedValue();
        if (Utils.a().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, Utils.a().getResources().getDisplayMetrics());
        }
        return 0;
    }

    @RequiresApi(21)
    public static int g(@NonNull Activity activity) {
        return h(activity.getWindow());
    }

    @RequiresApi(21)
    public static int h(@NonNull Window window) {
        return window.getNavigationBarColor();
    }

    public static int i() {
        Resources resources = Utils.a().getResources();
        int identifier = resources.getIdentifier(b.f6803b, "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String j(int i) {
        try {
            return Utils.a().getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        Resources resources = Utils.a().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(b.f6802a, "dimen", "android"));
    }

    public static void l(@NonNull Activity activity) {
        m(activity.getWindow());
    }

    public static void m(@NonNull Window window) {
        View viewFindViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(f20462a);
        if (viewFindViewWithTag == null) {
            return;
        }
        viewFindViewWithTag.setVisibility(8);
    }

    public static void n(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.a().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean o(@NonNull Activity activity) {
        return p(activity.getWindow());
    }

    public static boolean p(@NonNull Window window) {
        return (window.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    public static boolean q(@NonNull Activity activity) {
        return r(activity.getWindow());
    }

    public static boolean r(@NonNull Window window) {
        boolean z;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(j(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return z;
        }
        if (i.A0() && Build.VERSION.SDK_INT < 29) {
            try {
                return Settings.Global.getInt(Utils.a().getContentResolver(), b.m) == 0;
            } catch (Exception unused) {
            }
        }
        return (viewGroup.getSystemUiVisibility() & 2) == 0;
    }

    public static boolean s(@NonNull Activity activity) {
        return t(activity.getWindow());
    }

    public static boolean t(@NonNull Window window) {
        return (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public static boolean u(@NonNull Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }

    public static boolean v() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.y == point.y && point2.x == point.x) ? false : true;
    }

    @RequiresApi(21)
    public static void w(@NonNull Activity activity, @ColorInt int i) {
        x(activity.getWindow(), i);
    }

    @RequiresApi(21)
    public static void x(@NonNull Window window, @ColorInt int i) {
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i);
    }

    public static void y(@NonNull Activity activity, boolean z) {
        z(activity.getWindow(), z);
    }

    public static void z(@NonNull Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }
}
