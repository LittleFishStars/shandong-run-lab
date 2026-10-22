package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i0 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26624a;
    public final int b;
    public final v c;

    public i0(boolean z, int i, v vVar) {
        this.f26624a = z;
        this.b = i;
        this.c = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return this.c.a(this.f26624a, this.b);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            throw new q(e.getMessage());
        }
    }
}
