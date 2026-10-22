package com.google.mlkit.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.dvd;
import com.zj.adlib.i76;
import com.zj.adlib.l7c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class RemoteModelSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f32451a;

    @KeepForSdk
    public RemoteModelSource(@Nullable String str) {
        this.f32451a = str;
    }

    @Nullable
    public final String a() {
        return this.f32451a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(getClass())) {
            return i76.b(this.f32451a, ((RemoteModelSource) obj).f32451a);
        }
        return false;
    }

    public int hashCode() {
        return i76.c(this.f32451a);
    }

    @NonNull
    public String toString() {
        dvd dvdVarB = l7c.b("RemoteModelSource");
        dvdVarB.a("firebaseModelName", this.f32451a);
        return dvdVarB.toString();
    }
}
