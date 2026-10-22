package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class z implements d, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26655a;
    public final v b;

    public z(int i, v vVar) {
        this.f26655a = i;
        this.b = vVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() throws IOException {
        return new y(this.f26655a, this.b.b());
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
