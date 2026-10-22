package com.zj.adlib;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class p49 extends ViewEvent<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f18771a;
    public final int b;
    public final int c;

    public p49(@NonNull TextView textView, @NonNull CharSequence charSequence, int i, int i2, int i3) {
        super(textView);
        this.f18771a = charSequence;
        this.f43903a = i;
        this.b = i2;
        this.c = i3;
    }

    @NonNull
    @CheckResult
    public static p49 d(@NonNull TextView textView, @NonNull CharSequence charSequence, int i, int i2, int i3) {
        return new p49(textView, charSequence, i, i2, i3);
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int e() {
        return this.f43903a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p49)) {
            return false;
        }
        p49 p49Var = (p49) obj;
        return p49Var.a() == a() && this.f18771a.equals(p49Var.f18771a) && this.f43903a == p49Var.f43903a && this.b == p49Var.b && this.c == p49Var.c;
    }

    @NonNull
    public CharSequence f() {
        return this.f18771a;
    }

    public int hashCode() {
        return ((((((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f18771a.hashCode()) * 37) + this.f43903a) * 37) + this.b) * 37) + this.c;
    }

    public String toString() {
        return "TextViewTextChangeEvent{text=" + ((Object) this.f18771a) + ", start=" + this.f43903a + ", before=" + this.b + ", count=" + this.c + ", view=" + a() + '}';
    }
}
