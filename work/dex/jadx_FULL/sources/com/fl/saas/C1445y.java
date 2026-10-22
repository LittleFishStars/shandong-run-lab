package com.fl.saas;

import java.io.File;

/* JADX INFO: renamed from: com.fl.saas.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class C1445y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f30211a;
    public final N b;
    public final E c;
    public final X0 d;
    public final Q e;

    public C1445y(File file, N n, E e, X0 x0, Q q) {
        this.f30211a = file;
        this.b = n;
        this.c = e;
        this.d = x0;
        this.e = q;
    }

    public File a(String str) {
        return new File(this.f30211a, this.b.a(str));
    }
}
