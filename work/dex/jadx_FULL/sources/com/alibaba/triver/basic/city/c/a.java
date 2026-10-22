package com.alibaba.triver.basic.city.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import com.gyf.immersionbar.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static int a(Context context, String str) {
        try {
            int identifier = context.getResources().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return Math.round((context.getResources().getDimensionPixelSize(identifier) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density);
            }
            return 0;
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context) {
        boolean z = context.getResources().getConfiguration().orientation == 1;
        if (a((Activity) context)) {
            return a(context, z ? b.f6803b : b.f6804c);
        }
        return 0;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context) {
        return a(context, b.f6802a);
    }

    private static boolean a(Activity activity) {
        if (Settings.Global.getInt(activity.getContentResolver(), b.f6806e, 0) != 0) {
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
}
