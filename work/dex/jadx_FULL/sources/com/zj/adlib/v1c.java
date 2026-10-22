package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v1c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Feature f45272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c90 f20162a;

    public /* synthetic */ v1c(c90 c90Var, Feature feature, u1c u1cVar) {
        this.f20162a = c90Var;
        this.f45272a = feature;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof v1c)) {
            v1c v1cVar = (v1c) obj;
            if (i76.b(this.f20162a, v1cVar.f20162a) && i76.b(this.f45272a, v1cVar.f45272a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return i76.c(this.f20162a, this.f45272a);
    }

    public final String toString() {
        return i76.d(this).a(CachedContentIndex.a.e, this.f20162a).a(mm9.f18258b, this.f45272a).toString();
    }
}
