package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ue7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ue7 f45130a = new ue7(false);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20053a;

    public ue7(boolean z) {
        this.f20053a = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ue7.class == obj.getClass() && this.f20053a == ((ue7) obj).f20053a;
    }

    public int hashCode() {
        return !this.f20053a ? 1 : 0;
    }
}
