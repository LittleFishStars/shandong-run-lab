package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rmc;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l implements zzhq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzdj f31384a;

    public l(zzdj zzdjVar) {
        byte[] bArr = rmc.f19385a;
        this.f31384a = zzdjVar;
        zzdjVar.f5835a = this;
    }

    public static l L(zzdj zzdjVar) {
        l lVar = zzdjVar.f5835a;
        return lVar != null ? lVar : new l(zzdjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void A(int i, long j) throws IOException {
        this.f31384a.t(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void B(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.m(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iW = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iW += zzdj.w(((Integer) list.get(i3)).intValue());
        }
        this.f31384a.s(iW);
        while (i2 < list.size()) {
            this.f31384a.n(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void C(int i, Object obj, zzgh zzghVar) throws IOException {
        zzdj zzdjVar = this.f31384a;
        zzdjVar.q(i, 3);
        zzghVar.a((zzfo) obj, zzdjVar.f5835a);
        zzdjVar.q(i, 4);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void D(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.g(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.f(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void E(int i, String str) throws IOException {
        this.f31384a.p(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void F(int i, long j) throws IOException {
        this.f31384a.t(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void G(int i, int i2) throws IOException {
        this.f31384a.r(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void H(int i, zzdb zzdbVar) throws IOException {
        this.f31384a.h(i, zzdbVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void I(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.r(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA += zzdj.A(((Integer) list.get(i3)).intValue());
        }
        this.f31384a.s(iA);
        while (i2 < list.size()) {
            this.f31384a.s(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void J(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += zzdj.B(((Long) list.get(i3)).longValue());
        }
        this.f31384a.s(iB);
        while (i2 < list.size()) {
            this.f31384a.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void K(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzew)) {
            while (i2 < list.size()) {
                this.f31384a.p(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzew zzewVar = (zzew) list;
        while (i2 < list.size()) {
            Object objK = zzewVar.k(i2);
            if (objK instanceof String) {
                this.f31384a.p(i, (String) objK);
            } else {
                this.f31384a.h(i, (zzdb) objK);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void a(int i, double d) throws IOException {
        this.f31384a.k(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    @Deprecated
    public final void b(int i) throws IOException {
        this.f31384a.q(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void c(int i, int i2) throws IOException {
        this.f31384a.m(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void d(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdj zzdjVar = this.f31384a;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzdjVar.t(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iB += zzdj.B((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.f31384a.s(iB);
        while (i2 < list.size()) {
            zzdj zzdjVar2 = this.f31384a;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzdjVar2.u((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void e(int i, long j) throws IOException {
        this.f31384a.k(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void f(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.k(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.l(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void g(int i, int i2) throws IOException {
        this.f31384a.i(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void h(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdj zzdjVar = this.f31384a;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                zzdjVar.r(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iA += zzdj.A((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.f31384a.s(iA);
        while (i2 < list.size()) {
            zzdj zzdjVar2 = this.f31384a;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            zzdjVar2.s((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void i(int i, float f) throws IOException {
        this.f31384a.i(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void j(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.i(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.j(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void k(int i, int i2) throws IOException {
        this.f31384a.m(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void l(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f31384a.h(i, (zzdb) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void m(int i, long j) throws IOException {
        this.f31384a.t(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void n(int i, boolean z) throws IOException {
        this.f31384a.g(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void o(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.i(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.j(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void p(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.k(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.l(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void q(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.i(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.j(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void r(int i, int i2) throws IOException {
        this.f31384a.i(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void s(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.m(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iW = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iW += zzdj.w(((Integer) list.get(i3)).intValue());
        }
        this.f31384a.s(iW);
        while (i2 < list.size()) {
            this.f31384a.n(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void t(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int iB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB += zzdj.B(((Long) list.get(i3)).longValue());
        }
        this.f31384a.s(iB);
        while (i2 < list.size()) {
            this.f31384a.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void u(int i, long j) throws IOException {
        this.f31384a.k(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    @Deprecated
    public final void v(int i) throws IOException {
        this.f31384a.q(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void w(int i, Object obj) throws IOException {
        if (obj instanceof zzdb) {
            k kVar = (k) this.f31384a;
            kVar.s(11);
            kVar.r(2, i);
            kVar.h(3, (zzdb) obj);
            kVar.s(12);
            return;
        }
        zzdj zzdjVar = this.f31384a;
        zzfo zzfoVar = (zzfo) obj;
        k kVar2 = (k) zzdjVar;
        kVar2.s(11);
        kVar2.r(2, i);
        kVar2.s(26);
        kVar2.s(zzfoVar.l());
        zzfoVar.k(zzdjVar);
        kVar2.s(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void x(int i, int i2) throws IOException {
        this.f31384a.r(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void y(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f31384a.k(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.f31384a.q(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.f31384a.s(i3);
        while (i2 < list.size()) {
            this.f31384a.l(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhq
    public final void z(int i, Object obj, zzgh zzghVar) throws IOException {
        zzfo zzfoVar = (zzfo) obj;
        k kVar = (k) this.f31384a;
        kVar.s((i << 3) | 2);
        kVar.s(((zzck) zzfoVar).c(zzghVar));
        zzghVar.a(zzfoVar, ((zzdj) kVar).f5835a);
    }
}
