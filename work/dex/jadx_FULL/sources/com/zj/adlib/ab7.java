package com.zj.adlib;

import android.widget.RatingBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ab7 extends ViewEvent<RatingBar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f40503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15245a;

    public ab7(@NonNull RatingBar ratingBar, float f, boolean z) {
        super(ratingBar);
        this.f40503a = f;
        this.f15245a = z;
    }

    @NonNull
    @CheckResult
    public static ab7 b(@NonNull RatingBar ratingBar, float f, boolean z) {
        return new ab7(ratingBar, f, z);
    }

    public boolean c() {
        return this.f15245a;
    }

    public float d() {
        return this.f40503a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ab7)) {
            return false;
        }
        ab7 ab7Var = (ab7) obj;
        return ab7Var.a() == a() && ab7Var.f40503a == this.f40503a && ab7Var.f15245a == this.f15245a;
    }

    public int hashCode() {
        return ((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + Float.floatToIntBits(this.f40503a)) * 37) + (this.f15245a ? 1 : 0);
    }

    public String toString() {
        return "RatingBarChangeEvent{view=" + a() + ", rating=" + this.f40503a + ", fromUser=" + this.f15245a + '}';
    }
}
