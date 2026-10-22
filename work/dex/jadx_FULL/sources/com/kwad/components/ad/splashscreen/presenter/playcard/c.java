package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.am;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private am Kq;
    private am Kr;
    private am Ks;
    private am Kt;
    private am Ku;
    private am Kv;
    private float Kg = 1.0f;
    private int Kw = 34;
    private int Kx = 19;
    private int Ky = 8;
    private int Kz = 12;

    public static c c(float f) {
        c cVar = new c();
        cVar.Kq = am.a(174, 0, 0, 0, 0, 0);
        cVar.Kr = am.a(33, 33, 0, 0, 0, 0);
        cVar.Ks = am.a(0, 26, 0, 11, 0, 0);
        cVar.Kt = am.a(174, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 0, 6, 0, 0);
        cVar.Ku = am.a(0, 0, 0, 6, 0, 0);
        cVar.Kv = am.a(0, 0, 0, 7, 0, 0);
        cVar.Kw = 21;
        cVar.Kx = 12;
        cVar.Ky = 6;
        cVar.Kg = f;
        cVar.Kz = 8;
        return cVar;
    }

    public static c nI() {
        c cVar = new c();
        cVar.Kq = am.a(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 0, 0, 0, 0, 0);
        cVar.Kr = am.a(53, 53, 0, 0, 0, 0);
        cVar.Ks = am.a(0, 43, 0, 11, 0, 0);
        cVar.Kt = am.a(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 274, 0, 8, 0, 0);
        cVar.Ku = am.a(0, 0, 0, 8, 0, 0);
        cVar.Kv = am.a(0, 0, 0, 10, 0, 0);
        return cVar;
    }

    public final am W(Context context) {
        return this.Kq.c(context, this.Kg);
    }

    public final am X(Context context) {
        return this.Kr.c(context, this.Kg);
    }

    public final am Y(Context context) {
        return this.Ks.c(context, this.Kg);
    }

    public final am Z(Context context) {
        return this.Kt.c(context, this.Kg);
    }

    public final am aa(Context context) {
        return this.Ku.c(context, this.Kg);
    }

    public final am ab(Context context) {
        return this.Kv.c(context, this.Kg);
    }

    public final int ac(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Kw) * this.Kg);
    }

    public final int ad(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Kx) * this.Kg);
    }

    public final int ae(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.Ky) * this.Kg);
    }

    public final int nJ() {
        return this.Kz;
    }
}
