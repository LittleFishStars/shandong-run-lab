package com.zj.adlib;

import android.widget.SeekBar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.widget.SeekBarChangeEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class t38 extends SeekBarChangeEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19701a;

    public t38(@NonNull SeekBar seekBar, int i, boolean z) {
        super(seekBar);
        this.f44840a = i;
        this.f19701a = z;
    }

    @NonNull
    @CheckResult
    public static t38 b(@NonNull SeekBar seekBar, int i, boolean z) {
        return new t38(seekBar, i, z);
    }

    public boolean c() {
        return this.f19701a;
    }

    public int d() {
        return this.f44840a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t38)) {
            return false;
        }
        t38 t38Var = (t38) obj;
        return t38Var.a() == a() && t38Var.f44840a == this.f44840a && t38Var.f19701a == this.f19701a;
    }

    public int hashCode() {
        return ((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f44840a) * 37) + (this.f19701a ? 1 : 0);
    }

    public String toString() {
        return "SeekBarProgressChangeEvent{view=" + a() + ", progress=" + this.f44840a + ", fromUser=" + this.f19701a + '}';
    }
}
