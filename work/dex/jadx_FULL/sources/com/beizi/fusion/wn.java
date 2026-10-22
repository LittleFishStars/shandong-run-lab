package com.beizi.fusion;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class wn {
    public static void a(View view, String str, int i, String str2, int i2) {
        view.setBackground(a(str, i, str2, i2));
    }

    public static void a(View view, String str, int i, String str2, float[] fArr) {
        view.setBackground(a(str, i, str2, fArr));
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

    private static Drawable a(String str, int i, String str2, float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            gradientDrawable.setColor(Color.parseColor(str));
        } else {
            gradientDrawable.setColor(Color.parseColor("#00000000"));
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float f = fArr[i2];
            if (f >= 0.0f) {
                fArr2[i2] = f;
            } else {
                fArr2[i2] = 0.0f;
            }
        }
        gradientDrawable.setCornerRadii(fArr2);
        if (i > 0 && !TextUtils.isEmpty(str2) && str2.startsWith("#")) {
            gradientDrawable.setStroke(i, Color.parseColor(str2));
        }
        return gradientDrawable;
    }
}
