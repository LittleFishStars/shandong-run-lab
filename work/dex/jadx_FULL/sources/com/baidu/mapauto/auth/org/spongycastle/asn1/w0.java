package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class w0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o1 f26650a;

    public w0(o1 o1Var) {
        this.f26650a = o1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new v0(this.f26650a.c());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.o
    public final InputStream b() {
        return this.f26650a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("IOException converting stream to byte array: ");
            sbA.append(e.getMessage());
            throw new q(sbA.toString(), e);
        }
    }
}
