package com.zj.adlib;

import android.text.Editable;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f49 extends ViewEvent<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Editable f41592a;

    public f49(@NonNull TextView textView, @Nullable Editable editable) {
        super(textView);
        this.f41592a = editable;
    }

    @NonNull
    @CheckResult
    public static f49 b(@NonNull TextView textView, @Nullable Editable editable) {
        return new f49(textView, editable);
    }

    @Nullable
    public Editable c() {
        return this.f41592a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f49)) {
            return false;
        }
        f49 f49Var = (f49) obj;
        return f49Var.a() == a() && this.f41592a.equals(f49Var.f41592a);
    }

    public int hashCode() {
        return ((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f41592a.hashCode();
    }

    public String toString() {
        return "TextViewAfterTextChangeEvent{editable=" + ((Object) this.f41592a) + ", view=" + a() + '}';
    }
}
