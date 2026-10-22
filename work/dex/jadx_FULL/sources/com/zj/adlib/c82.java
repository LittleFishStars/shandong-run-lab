package com.zj.adlib;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class c82 {
    public static String a(double value, int scale) {
        return scale > 0 ? BigDecimal.valueOf(value).setScale(scale, 4).toString() : new DecimalFormat("###################.###########").format(value);
    }

    public static String b(double value, int scale) {
        return scale > 0 ? BigDecimal.valueOf(value).setScale(scale, 3).toString() : new DecimalFormat("###################.###########").format(value);
    }

    public static boolean c(double divideNum1, double divideNum2, int scale) {
        if (divideNum2 == AudioStats.AUDIO_AMPLITUDE_NONE || scale < 0) {
            return false;
        }
        BigDecimal bigDecimalDivide = BigDecimal.valueOf(divideNum1).divide(BigDecimal.valueOf(divideNum2), scale, 5);
        return new BigDecimal(bigDecimalDivide.intValue()).compareTo(bigDecimalDivide) == 0;
    }
}
