package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c1 implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f26612a;

    public c1(v vVar) {
        this.f26612a = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new b1(this.f26612a.b());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        try {
            return a();
        } catch (IOException e) {
            throw new q(e.getMessage(), e);
        }
    }
}
