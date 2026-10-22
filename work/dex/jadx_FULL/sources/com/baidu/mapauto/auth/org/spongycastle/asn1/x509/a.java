package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.d;
import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f26652a;
    public d b;

    public a(s sVar) {
        if (sVar.size() < 1 || sVar.size() > 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        this.f26652a = m.a(sVar.a(0));
        this.b = sVar.size() == 2 ? sVar.a(1) : null;
    }

    public static a a(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(s.a(obj));
        }
        return null;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f26614a.addElement(this.f26652a);
        d dVar = this.b;
        if (dVar != null) {
            eVar.f26614a.addElement(dVar);
        }
        return new z0(eVar);
    }
}
