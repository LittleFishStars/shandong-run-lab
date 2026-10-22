package com.zj.adlib;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class qr9 extends ViewEvent<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44288a;
    public final int b;
    public final int c;
    public final int d;

    public qr9(@NonNull View view, int i, int i2, int i3, int i4) {
        super(view);
        this.f44288a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @NonNull
    @CheckResult
    public static qr9 b(@NonNull View view, int i, int i2, int i3, int i4) {
        return new qr9(view, i, i2, i3, i4);
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.f44288a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qr9)) {
            return false;
        }
        qr9 qr9Var = (qr9) obj;
        return qr9Var.a() == a() && qr9Var.f44288a == this.f44288a && qr9Var.b == this.b && qr9Var.c == this.c && qr9Var.d == this.d;
    }

    public int f() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f44288a) * 37) + this.b) * 37) + this.c) * 37) + this.d;
    }

    public String toString() {
        return "ViewScrollChangeEvent{scrollX=" + this.f44288a + ", scrollY=" + this.b + ", oldScrollX=" + this.c + ", oldScrollY=" + this.d + '}';
    }
}
