package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class un {
    public static void a(Context context, View view, String str, int i, String str2, int i2) {
        view.setBackground(a(context, str, i, str2, i2));
    }

    private static Drawable a(Context context, String str, int i, String str2, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (no.d(str)) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(0);
        }
        if (i2 > 0) {
            gradientDrawable.setCornerRadius(gn.a.a(context, i2));
        }
        if (i > 0 && no.d(str2)) {
            gradientDrawable.setStroke(gn.a.a(context, i), Color.parseColor(str2));
        }
        return gradientDrawable;
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (no.f(str)) {
            return (int) (i * no.k(str));
        }
        return no.i(str);
    }
}
