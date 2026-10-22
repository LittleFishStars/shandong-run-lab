package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f26637a;

    public q(String str) {
        super(str);
    }

    public q(String str, Exception exc) {
        super(str);
        this.f26637a = exc;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f26637a;
    }
}
