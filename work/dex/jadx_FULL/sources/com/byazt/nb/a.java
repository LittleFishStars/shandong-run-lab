package com.byazt.nb;

import com.byazt.ga.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 34})
public class a {
    public static final a c = new a();
    public final yp<String, com.byazt.ga.a> tt = new yp<>(20);

    public static a c() {
        return c;
    }

    public com.byazt.ga.a c(String str) {
        if (str == null) {
            return null;
        }
        return this.tt.c(str);
    }

    public void c(String str, com.byazt.ga.a aVar) {
        if (str == null) {
            return;
        }
        this.tt.c(str, aVar);
    }

    public void c(int i) {
        this.tt.c(i);
    }
}
