package com.jakewharton.rxbinding.view;

import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ViewAttachEvent extends ViewEvent<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Kind f38632a;

    public enum Kind {
        ATTACH,
        DETACH
    }

    public ViewAttachEvent(@NonNull View view, @NonNull Kind kind) {
        super(view);
        this.f38632a = kind;
    }

    @NonNull
    @CheckResult
    public static ViewAttachEvent b(@NonNull View view, @NonNull Kind kind) {
        return new ViewAttachEvent(view, kind);
    }

    @NonNull
    public Kind c() {
        return this.f38632a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ViewAttachEvent)) {
            return false;
        }
        ViewAttachEvent viewAttachEvent = (ViewAttachEvent) obj;
        return viewAttachEvent.a() == a() && viewAttachEvent.c() == c();
    }

    public int hashCode() {
        return ((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + c().hashCode();
    }

    public String toString() {
        return "ViewAttachEvent{view=" + a() + ", kind=" + c() + '}';
    }
}
