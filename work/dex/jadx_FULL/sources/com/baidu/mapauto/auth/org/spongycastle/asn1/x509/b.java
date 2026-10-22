package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f26653a;
    public m0 b;

    @Deprecated
    public b(s sVar) {
        if (sVar.size() != 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        Enumeration enumerationI = sVar.i();
        this.f26653a = a.a(enumerationI.nextElement());
        this.b = m0.a(enumerationI.nextElement());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f26614a.addElement(this.f26653a);
        eVar.f26614a.addElement(this.b);
        return new z0(eVar);
    }
}
