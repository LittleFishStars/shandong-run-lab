package com.zj.adlib;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dz7 extends ViewEvent<SearchView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f41311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16166a;

    public dz7(@NonNull SearchView searchView, @NonNull CharSequence charSequence, boolean z) {
        super(searchView);
        this.f41311a = charSequence;
        this.f16166a = z;
    }

    @NonNull
    @CheckResult
    public static dz7 b(@NonNull SearchView searchView, @NonNull CharSequence charSequence, boolean z) {
        return new dz7(searchView, charSequence, z);
    }

    public boolean c() {
        return this.f16166a;
    }

    @NonNull
    public CharSequence d() {
        return this.f41311a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dz7)) {
            return false;
        }
        dz7 dz7Var = (dz7) obj;
        return dz7Var.a() == a() && dz7Var.f41311a.equals(this.f41311a) && dz7Var.f16166a == this.f16166a;
    }

    public int hashCode() {
        return ((((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + a().hashCode()) * 37) + this.f41311a.hashCode()) * 37) + (this.f16166a ? 1 : 0);
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + a() + ", queryText=" + ((Object) this.f41311a) + ", submitted=" + this.f16166a + '}';
    }
}
