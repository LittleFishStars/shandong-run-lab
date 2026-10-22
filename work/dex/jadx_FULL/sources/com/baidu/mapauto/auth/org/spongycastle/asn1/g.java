package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f26618a;

    public g(String str) {
        super(str);
    }

    public g(String str, IllegalArgumentException illegalArgumentException) {
        super(str);
        this.f26618a = illegalArgumentException;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f26618a;
    }
}
