package com.zj.adlib;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.alibaba.android.arouter.utils.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class yn1 {
    @ColorInt
    public static int a(@ColorInt Integer startColor, @ColorInt Integer endColor, float alpha) {
        int iRed = Color.red(startColor.intValue());
        int iGreen = Color.green(startColor.intValue());
        int iBlue = Color.blue(startColor.intValue());
        int iAlpha = Color.alpha(startColor.intValue());
        int iRed2 = Color.red(endColor.intValue());
        int iGreen2 = Color.green(endColor.intValue());
        int iBlue2 = Color.blue(endColor.intValue());
        return Color.argb(iAlpha + Math.round((Color.alpha(endColor.intValue()) - iAlpha) * alpha), iRed + Math.round((iRed2 - iRed) * alpha), iGreen + Math.round((iGreen2 - iGreen) * alpha), iBlue + Math.round((iBlue2 - iBlue) * alpha));
    }

    public static boolean b(String color) {
        return !TextUtils.isEmpty(color) && color.length() >= 7 && color.length() <= 9 && color.startsWith("#");
    }
}
