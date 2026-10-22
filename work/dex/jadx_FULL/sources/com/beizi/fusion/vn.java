package com.beizi.fusion;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class vn {
    public static void a(View view, String str, int i, String str2, int i2) {
        view.setBackground(a(str, i, str2, i2));
    }

    private static Drawable a(String str, int i, String str2, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        if (i2 > 0) {
            gradientDrawable.setCornerRadius(i2);
        }
        if (i > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
