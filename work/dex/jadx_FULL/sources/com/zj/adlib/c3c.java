package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c3c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f40894a;

    public c3c(Uri uri) {
        this.f40894a = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c3c) {
            return i76.b(((c3c) obj).f40894a, this.f40894a);
        }
        return false;
    }

    public final int hashCode() {
        return i76.c(this.f40894a);
    }
}
