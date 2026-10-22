package com.zj.adlib;

import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.widget.AdapterViewSelectionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a10 extends AdapterViewSelectionEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f15138a;
    public final View b;

    public a10(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        super(adapterView);
        this.b = view;
        this.f40429a = i;
        this.f15138a = j;
    }

    @NonNull
    @CheckResult
    public static AdapterViewSelectionEvent b(@NonNull AdapterView<?> adapterView, @NonNull View view, int i, long j) {
        return new a10(adapterView, view, i, j);
    }

    public long c() {
        return this.f15138a;
    }

    public int d() {
        return this.f40429a;
    }

    @NonNull
    public View e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a10)) {
            return false;
        }
        a10 a10Var = (a10) obj;
        return a10Var.a() == a() && a10Var.b == this.b && a10Var.f40429a == this.f40429a && a10Var.f15138a == this.f15138a;
    }

    public int hashCode() {
        int iHashCode = (((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.b.hashCode()) * 37) + this.f40429a) * 37;
        long j = this.f15138a;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "AdapterViewItemSelectionEvent{view=" + a() + ", selectedView=" + this.b + ", position=" + this.f40429a + ", id=" + this.f15138a + '}';
    }
}
