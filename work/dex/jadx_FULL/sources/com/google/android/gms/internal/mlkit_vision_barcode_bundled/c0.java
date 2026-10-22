package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.drc;
import com.zj.adlib.rmc;
import com.zj.adlib.upc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c0 implements zzgi {
    public static final zzfm b = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzfm f31372a;

    public c0() {
        zzfm zzfmVar;
        zzfm[] zzfmVarArr = new zzfm[2];
        zzfmVarArr[0] = q.c();
        try {
            zzfmVar = (zzfm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfmVar = b;
        }
        zzfmVarArr[1] = zzfmVar;
        b0 b0Var = new b0(zzfmVarArr);
        byte[] bArr = rmc.f19385a;
        this.f31372a = b0Var;
    }

    public static boolean b(zzfl zzflVar) {
        return zzflVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgi
    public final zzgh a(Class cls) {
        m0.d(cls);
        zzfl zzflVarA = this.f31372a.a(cls);
        if (zzflVarA.a()) {
            return zzed.class.isAssignableFrom(cls) ? f0.j(m0.W(), o.b(), zzflVarA.b()) : f0.j(m0.V(), o.a(), zzflVarA.b());
        }
        if (zzed.class.isAssignableFrom(cls)) {
            return b(zzflVarA) ? e0.H(cls, zzflVarA, drc.b(), zzfc.d(), m0.W(), o.b(), upc.b()) : e0.H(cls, zzflVarA, drc.b(), zzfc.d(), m0.W(), null, upc.b());
        }
        return b(zzflVarA) ? e0.H(cls, zzflVarA, drc.a(), zzfc.c(), m0.V(), o.a(), upc.a()) : e0.H(cls, zzflVarA, drc.a(), zzfc.c(), m0.V(), null, upc.a());
    }
}
