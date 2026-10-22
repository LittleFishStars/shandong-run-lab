package com.zj.adlib;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class hr9 extends ViewEvent<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42187a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public hr9(@NonNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(view);
        this.f42187a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    @NonNull
    @CheckResult
    public static hr9 c(@NonNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new hr9(view, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int b() {
        return this.d;
    }

    public int d() {
        return this.f42187a;
    }

    public int e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hr9)) {
            return false;
        }
        hr9 hr9Var = (hr9) obj;
        return hr9Var.a() == a() && hr9Var.f42187a == this.f42187a && hr9Var.b == this.b && hr9Var.c == this.c && hr9Var.d == this.d && hr9Var.e == this.e && hr9Var.f == this.f && hr9Var.g == this.g && hr9Var.h == this.h;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((((((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f42187a) * 37) + this.b) * 37) + this.c) * 37) + this.d) * 37) + this.e) * 37) + this.f) * 37) + this.g) * 37) + this.h;
    }

    public int i() {
        return this.c;
    }

    public int j() {
        return this.b;
    }

    public String toString() {
        return "ViewLayoutChangeEvent{left=" + this.f42187a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ", oldLeft=" + this.e + ", oldTop=" + this.f + ", oldRight=" + this.g + ", oldBottom=" + this.h + '}';
    }
}
