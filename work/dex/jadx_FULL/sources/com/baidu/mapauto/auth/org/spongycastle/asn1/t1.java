package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class t1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f26644a;
    public int b;

    public t1(int i, InputStream inputStream) {
        this.f26644a = inputStream;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public final void b() {
        InputStream inputStream = this.f26644a;
        if (inputStream instanceof q1) {
            q1 q1Var = (q1) inputStream;
            q1Var.f = true;
            q1Var.c();
        }
    }
}
