package com.byazt.dj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 54})
public class ve {
    public PluginValueSet c;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 24})
    public static class c {
        public final com.byazt.yxi.uj c = com.byazt.yxi.uj.c();

        public c c(double d) {
            this.c.c(262001, Double.valueOf(d));
            return this;
        }

        public c tt(double d) {
            this.c.c(262002, Double.valueOf(d));
            return this;
        }

        public ve c() {
            return new ve(this.c.tt());
        }
    }

    public ve(SparseArray<Object> sparseArray) {
        this.c = com.byazt.rl.c.c(sparseArray).tt();
    }

    public double c() {
        return this.c.doubleValue(262001);
    }

    public double tt() {
        return this.c.doubleValue(262002);
    }
}
