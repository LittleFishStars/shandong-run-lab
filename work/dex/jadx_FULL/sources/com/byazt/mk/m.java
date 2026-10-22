package com.byazt.mk;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 130})
public final class m {
    public static z c;
    public static long tt;

    private m() {
    }

    public static z c() {
        synchronized (m.class) {
            z zVar = c;
            if (zVar == null) {
                return new z();
            }
            c = zVar.f28794a;
            zVar.f28794a = null;
            tt -= 8192;
            return zVar;
        }
    }

    public static void c(z zVar) {
        if (zVar.f28794a == null && zVar.sp == null) {
            if (zVar.uj) {
                return;
            }
            synchronized (m.class) {
                long j = tt;
                if (j + 8192 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                tt = j + 8192;
                zVar.f28794a = c;
                zVar.ve = 0;
                zVar.tt = 0;
                c = zVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
