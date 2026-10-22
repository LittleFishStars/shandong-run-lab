package com.byazt.eu;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 34})
public class a {
    public static float c = -1.0f;
    public static int n = -1;
    public static int tt = -1;
    public static int uj = -1;
    public static float ve = -1.0f;

    static {
        c(com.byazt.bp.tt.getContext());
    }

    public static void c(Context context) {
        Context context2 = context == null ? com.byazt.bp.tt.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        c = displayMetrics.density;
        tt = displayMetrics.densityDpi;
        ve = displayMetrics.scaledDensity;
        uj = displayMetrics.widthPixels;
        n = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = uj;
            int i2 = n;
            if (i > i2) {
                uj = i2;
                n = i;
                return;
            }
            return;
        }
        int i3 = uj;
        int i4 = n;
        if (i3 < i4) {
            uj = i4;
            n = i3;
        }
    }

    public static int n(Context context) {
        c(context);
        return tt;
    }

    public static int tt(Context context) {
        c(context);
        return uj;
    }

    public static float uj(Context context) {
        c(context);
        return c;
    }

    public static int ve(Context context) {
        c(context);
        return n;
    }

    public static int tt(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f) {
        c(context);
        float fUj = uj(context);
        if (fUj <= 0.0f) {
            fUj = 1.0f;
        }
        return (int) ((f / fUj) + 0.5f);
    }
}
