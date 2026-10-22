package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class x00 extends ViewEvent<AdapterView<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f20586a;
    public final View b;

    public x00(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        super(adapterView);
        this.b = view;
        this.f45721a = i;
        this.f20586a = j;
    }

    @NonNull
    @CheckResult
    public static x00 c(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        return new x00(adapterView, view, i, j);
    }

    @NonNull
    public View b() {
        return this.b;
    }

    public long d() {
        return this.f20586a;
    }

    public int e() {
        return this.f45721a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x00)) {
            return false;
        }
        x00 x00Var = (x00) obj;
        return x00Var.a() == a() && x00Var.b == this.b && x00Var.f45721a == this.f45721a && x00Var.f20586a == this.f20586a;
    }

    public int hashCode() {
        int iHashCode = (((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.b.hashCode()) * 37) + this.f45721a) * 37;
        long j = this.f20586a;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "AdapterViewItemLongClickEvent{view=" + a() + ", clickedView=" + this.b + ", position=" + this.f45721a + ", id=" + this.f20586a + '}';
    }
}
