package com.google.android.gms.internal.mlkit_vision_barcode;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public static final z f31362a;

    @CheckForNull
    public static final z b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final Throwable f5777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5778a;

    static {
        if (zzec.f5784a) {
            b = null;
            f31362a = null;
        } else {
            b = new z(false, null);
            f31362a = new z(true, null);
        }
    }

    public z(boolean z, @CheckForNull Throwable th) {
        this.f5778a = z;
        this.f5777a = th;
    }
}
