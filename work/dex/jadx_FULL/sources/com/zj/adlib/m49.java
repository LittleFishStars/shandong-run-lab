package com.zj.adlib;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m49 extends ViewEvent<TextView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final KeyEvent f18133a;

    public m49(@NonNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
        super(textView);
        this.f43221a = i;
        this.f18133a = keyEvent;
    }

    @NonNull
    @CheckResult
    public static m49 c(@NonNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
        return new m49(textView, i, keyEvent);
    }

    public int b() {
        return this.f43221a;
    }

    @Nullable
    public KeyEvent d() {
        return this.f18133a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m49)) {
            return false;
        }
        m49 m49Var = (m49) obj;
        if (m49Var.a() == a() && m49Var.f43221a == this.f43221a) {
            KeyEvent keyEvent = m49Var.f18133a;
            if (keyEvent != null) {
                if (keyEvent.equals(this.f18133a)) {
                    return true;
                }
            } else if (this.f18133a == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f43221a) * 37;
        KeyEvent keyEvent = this.f18133a;
        return iHashCode + (keyEvent != null ? keyEvent.hashCode() : 0);
    }

    public String toString() {
        return "TextViewEditorActionEvent{view=" + a() + ", actionId=" + this.f43221a + ", keyEvent=" + this.f18133a + '}';
    }
}
