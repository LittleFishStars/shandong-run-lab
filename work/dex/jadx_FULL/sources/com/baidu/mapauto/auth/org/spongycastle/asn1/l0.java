package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f26628a;

    public l0(char[] cArr) {
        this.f26628a = cArr;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(30);
        pVar.b(this.f26628a.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.f26628a;
            if (i == cArr.length) {
                return;
            }
            char c = cArr[i];
            pVar.a((byte) (c >> '\b'));
            pVar.a((byte) c);
            i++;
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof l0)) {
            return false;
        }
        char[] cArr = this.f26628a;
        char[] cArr2 = ((l0) rVar).f26628a;
        if (cArr != cArr2) {
            if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
                return false;
            }
            for (int i = 0; i != cArr.length; i++) {
                if (cArr[i] != cArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return (this.f26628a.length * 2) + u1.a(this.f26628a.length * 2) + 1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        char[] cArr = this.f26628a;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    public final String toString() {
        return new String(this.f26628a);
    }
}
