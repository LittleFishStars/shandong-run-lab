package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class s extends r implements Iterable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f26641a = new Vector();

    public s() {
    }

    public s(e eVar) {
        for (int i = 0; i != eVar.a(); i++) {
            this.f26641a.addElement(eVar.a(i));
        }
    }

    public d a(int i) {
        return (d) this.f26641a.elementAt(i);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof s)) {
            return false;
        }
        s sVar = (s) rVar;
        if (size() != sVar.size()) {
            return false;
        }
        Enumeration enumerationI = i();
        Enumeration enumerationI2 = sVar.i();
        while (enumerationI.hasMoreElements()) {
            d dVar = (d) enumerationI.nextElement();
            d dVar2 = (d) enumerationI2.nextElement();
            r rVarC = dVar.c();
            r rVarC2 = dVar2.c();
            if (rVarC != rVarC2 && !rVarC.equals(rVarC2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r g() {
        z0 z0Var = new z0();
        z0Var.f26641a = this.f26641a;
        return z0Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r h() {
        l1 l1Var = new l1();
        l1Var.f26641a = this.f26641a;
        return l1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration enumerationI = i();
        int size = size();
        while (enumerationI.hasMoreElements()) {
            size = (size * 17) ^ ((d) enumerationI.nextElement()).hashCode();
        }
        return size;
    }

    public Enumeration i() {
        return this.f26641a.elements();
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] dVarArr = new d[size()];
        for (int i = 0; i != size(); i++) {
            dVarArr[i] = a(i);
        }
        return new com.baidu.mapauto.auth.org.spongycastle.util.a.C0271a(dVarArr);
    }

    public int size() {
        return this.f26641a.size();
    }

    public final String toString() {
        return this.f26641a.toString();
    }

    public static s a(Object obj) {
        if (obj == null || (obj instanceof s)) {
            return (s) obj;
        }
        if (obj instanceof t) {
            return a((Object) ((t) obj).c());
        }
        if (obj instanceof byte[]) {
            try {
                return a((Object) r.a((byte[]) obj));
            } catch (IOException e) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("failed to construct sequence from byte[]: ");
                sbA.append(e.getMessage());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        if (obj instanceof d) {
            r rVarC = ((d) obj).c();
            if (rVarC instanceof s) {
                return (s) rVarC;
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("unknown object in getInstance: ");
        sbA2.append(obj.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
