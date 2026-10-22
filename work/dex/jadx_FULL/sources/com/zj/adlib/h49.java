package com.zj.adlib;

import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h49 extends ViewEvent<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f16931a;
    public final int b;
    public final int c;

    public h49(@NonNull TextView textView, @NonNull CharSequence charSequence, int i, int i2, int i3) {
        super(textView);
        this.f16931a = charSequence;
        this.f42050a = i;
        this.b = i2;
        this.c = i3;
    }

    @NonNull
    @CheckResult
    public static h49 d(@NonNull TextView textView, @NonNull CharSequence charSequence, int i, int i2, int i3) {
        return new h49(textView, charSequence, i, i2, i3);
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int e() {
        return this.f42050a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f49)) {
            return false;
        }
        h49 h49Var = (h49) obj;
        return h49Var.a() == a() && this.f16931a.equals(h49Var.f16931a) && this.f42050a == h49Var.f42050a && this.b == h49Var.b && this.c == h49Var.c;
    }

    @NonNull
    public CharSequence f() {
        return this.f16931a;
    }

    public int hashCode() {
        return ((((((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f16931a.hashCode()) * 37) + this.f42050a) * 37) + this.b) * 37) + this.c;
    }

    public String toString() {
        return "TextViewBeforeTextChangeEvent{text=" + ((Object) this.f16931a) + ", start=" + this.f42050a + ", count=" + this.b + ", after=" + this.c + ", view=" + a() + '}';
    }
}
