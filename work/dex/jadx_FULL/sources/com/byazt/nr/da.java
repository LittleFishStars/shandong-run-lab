package com.byazt.nr;

import android.os.Handler;
import com.byazt.dna.qp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 72})
public class da {
    public static volatile Handler c;
    public static volatile Handler tt;
    public static volatile Handler ve;

    public static Handler c() {
        if (tt == null) {
            tt = ((qp) com.byazt.ut.uj.getService("thread_service")).getIOHandler();
        }
        return tt;
    }

    public static Handler tt() {
        if (c == null) {
            c = ((qp) com.byazt.ut.uj.getService("thread_service")).getMainHandler();
        }
        return c;
    }

    public static Handler ve() {
        if (ve == null) {
            ve = ((qp) com.byazt.ut.uj.getService("thread_service")).getCsjMainHandler();
        }
        return ve;
    }
}
