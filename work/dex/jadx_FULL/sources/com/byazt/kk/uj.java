package com.byazt.kk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 15})
public class uj {
    private static float c(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float tt(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int c(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fTt = tt(((i >> 16) & 255) / 255.0f);
        float fTt2 = tt(((i >> 8) & 255) / 255.0f);
        float fTt3 = tt((i & 255) / 255.0f);
        float fTt4 = tt(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fTt5 = fTt2 + ((tt(((i2 >> 8) & 255) / 255.0f) - fTt2) * f);
        float fTt6 = fTt3 + (f * (tt((i2 & 255) / 255.0f) - fTt3));
        return (Math.round(c(fTt + ((fTt4 - fTt) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(c(fTt5) * 255.0f) << 8) | Math.round(c(fTt6) * 255.0f);
    }
}
