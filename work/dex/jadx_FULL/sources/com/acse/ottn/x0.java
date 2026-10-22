package com.acse.ottn;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f23291a = -1;
    public static int b = -1;

    public static int a(Context context) {
        int i = b;
        if (i != -1) {
            return i;
        }
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        b = i2;
        f23291a = displayMetrics.widthPixels;
        return i2;
    }

    public static int b(Context context) {
        int i = f23291a;
        if (i != -1) {
            return i;
        }
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        f23291a = i2;
        b = displayMetrics.heightPixels;
        return i2;
    }

    public static int c(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int d(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int c(Context context, float f) {
        return (int) ((f / context.getApplicationContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int a(Context context, int i) {
        return BitmapFactory.decodeResource(context.getApplicationContext().getResources(), i).getWidth();
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
