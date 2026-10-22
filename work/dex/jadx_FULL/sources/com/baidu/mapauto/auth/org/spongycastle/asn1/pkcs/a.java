package com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs;

import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.j;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f26636a;
    public BigInteger b;

    public a(s sVar) {
        if (sVar.size() != 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        Enumeration enumerationI = sVar.i();
        this.f26636a = j.a(enumerationI.nextElement()).i();
        this.b = j.a(enumerationI.nextElement()).i();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f26614a.addElement(new j(this.f26636a));
        eVar.f26614a.addElement(new j(this.b));
        return new z0(eVar);
    }
}
