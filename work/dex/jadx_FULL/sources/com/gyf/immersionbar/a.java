package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f32545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f6799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6800a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f6801b;
    public final int c;
    public final int d;

    public a(Activity activity) {
        this.f6801b = activity.getResources().getConfiguration().orientation == 1;
        this.f32545a = j(activity);
        this.f6799a = c(activity, b.f6802a);
        this.b = b(activity);
        int iE = e(activity);
        this.c = iE;
        this.d = h(activity);
        this.f6800a = iE > 0;
    }

    public static int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals(b.f6802a))) {
                    return dimensionPixelSize2;
                }
                float f = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    public static int f(@NonNull Context context) {
        return c(context, context.getResources().getConfiguration().orientation == 1 ? b.f6803b : b.f6804c);
    }

    public static int i(@NonNull Context context) {
        return c(context, b.f6805d);
    }

    public int a() {
        return this.b;
    }

    @TargetApi(14)
    public final int b(Activity activity) {
        View viewFindViewById = activity.getWindow().findViewById(R.id.action_bar_container);
        int measuredHeight = viewFindViewById != null ? viewFindViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    public int d() {
        return this.c;
    }

    @TargetApi(14)
    public final int e(Context context) {
        if (l((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    public int g() {
        return this.d;
    }

    @TargetApi(14)
    public final int h(Context context) {
        if (l((Activity) context)) {
            return c(context, b.f6805d);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final float j(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.density;
        return Math.min(f / f2, displayMetrics.heightPixels / f2);
    }

    public int k() {
        return this.f6799a;
    }

    @TargetApi(14)
    public final boolean l(Activity activity) {
        d.a aVarA = d.a(activity);
        if (!aVarA.b && aVarA.f6812a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    public boolean m() {
        return this.f6800a;
    }

    public boolean n() {
        return this.f32545a >= 600.0f || this.f6801b;
    }
}
