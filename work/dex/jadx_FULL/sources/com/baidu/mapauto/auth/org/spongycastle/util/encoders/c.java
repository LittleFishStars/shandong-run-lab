package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f26662a;

    public c(String str, Exception exc) {
        super(str);
        this.f26662a = exc;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f26662a;
    }
}
