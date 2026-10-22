package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a0 {
    public static final a0 b = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public a0 f31338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final Runnable f5741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final Executor f5742a;

    public a0() {
        this.f5741a = null;
        this.f5742a = null;
    }

    public a0(Runnable runnable, Executor executor) {
        this.f5741a = runnable;
        this.f5742a = executor;
    }
}
