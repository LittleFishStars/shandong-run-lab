package com.byazt.lbn;

import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 496, 13})
public final class tt {

    @com.byazt.zqa.c(c = {0, 1, 496, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28769a;
        public static final float c;
        public static final int n;
        public static final int tt;
        public static final int uj;
        public static final int ve;

        static {
            float f = gt.getContext().getResources().getDisplayMetrics().density;
            c = f;
            tt = (int) ((228.0f * f) + 0.5f);
            ve = (int) ((160.0f * f) + 0.5f);
            uj = (int) ((15.0f * f) + 0.5f);
            n = (int) ((14.0f * f) + 0.5f);
            f28769a = (int) ((f * 16.0f) + 0.5f);
        }
    }
}
