package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u00 extends ViewEvent<AdapterView<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f19925a;
    public final View b;

    public u00(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        super(adapterView);
        this.b = view;
        this.f45036a = i;
        this.f19925a = j;
    }

    @NonNull
    @CheckResult
    public static u00 c(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        return new u00(adapterView, view, i, j);
    }

    @NonNull
    public View b() {
        return this.b;
    }

    public long d() {
        return this.f19925a;
    }

    public int e() {
        return this.f45036a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u00)) {
            return false;
        }
        u00 u00Var = (u00) obj;
        return u00Var.a() == a() && u00Var.b == this.b && u00Var.f45036a == this.f45036a && u00Var.f19925a == this.f19925a;
    }

    public int hashCode() {
        int iHashCode = (((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.b.hashCode()) * 37) + this.f45036a) * 37;
        long j = this.f19925a;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "AdapterViewItemClickEvent{view=" + a() + ", clickedView=" + this.b + ", position=" + this.f45036a + ", id=" + this.f19925a + '}';
    }
}
