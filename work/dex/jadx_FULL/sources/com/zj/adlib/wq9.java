package com.zj.adlib;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewGroupHierarchyChangeEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class wq9 extends ViewGroupHierarchyChangeEvent {
    public wq9(@NonNull ViewGroup viewGroup, View view) {
        super(viewGroup, view);
    }

    @NonNull
    @CheckResult
    public static wq9 c(@NonNull ViewGroup viewGroup, View view) {
        return new wq9(viewGroup, view);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wq9)) {
            return false;
        }
        wq9 wq9Var = (wq9) obj;
        return wq9Var.a() == a() && wq9Var.b() == b();
    }

    public int hashCode() {
        return ((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + b().hashCode();
    }

    public String toString() {
        return "ViewGroupHierarchyChildViewRemoveEvent{view=" + a() + ", child=" + b() + '}';
    }
}
