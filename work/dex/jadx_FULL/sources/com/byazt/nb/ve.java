package com.byazt.nb;

import android.graphics.Typeface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 54})
public class ve {
    public final String c;
    public Typeface n;
    public final String tt;
    public final float uj;
    public final String ve;

    public ve(String str, String str2, String str3, float f) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        this.uj = f;
    }

    public String c() {
        return this.c;
    }

    public String tt() {
        return this.tt;
    }

    public Typeface uj() {
        return this.n;
    }

    public String ve() {
        return this.ve;
    }

    public void c(Typeface typeface) {
        this.n = typeface;
    }
}
