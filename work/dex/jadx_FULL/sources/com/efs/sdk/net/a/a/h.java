package com.efs.sdk.net.a.a;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f29913a;
    public ByteArrayOutputStream b;
    public a c;
    private final String d;

    public h(f fVar, String str) {
        this.f29913a = fVar;
        this.d = str;
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
