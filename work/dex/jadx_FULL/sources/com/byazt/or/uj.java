package com.byazt.or;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 15})
public class uj {
    public static Drawable c(Context context, com.byazt.aq.sp spVar) {
        if (context == null || spVar == null) {
            return null;
        }
        return c(context, (int) x.c(context, spVar.nu()), spVar.m(), spVar.md());
    }

    public static Drawable c(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
