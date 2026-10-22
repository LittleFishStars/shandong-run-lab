package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p0 extends zzgy {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ int a(Object obj) {
        return ((o0) obj).a();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ int b(Object obj) {
        return ((o0) obj).b();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        zzed zzedVar = (zzed) obj;
        o0 o0Var = zzedVar.zzc;
        if (o0Var != o0.c()) {
            return o0Var;
        }
        o0 o0VarF = o0.f();
        zzedVar.zzc = o0VarF;
        return o0VarF;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ Object d(Object obj) {
        return ((zzed) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (o0.c().equals(obj2)) {
            return obj;
        }
        if (o0.c().equals(obj)) {
            return o0.e((o0) obj, (o0) obj2);
        }
        ((o0) obj).d((o0) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* bridge */ /* synthetic */ void f(Object obj, int i, long j) {
        ((o0) obj).j(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void g(Object obj) {
        ((zzed) obj).zzc.h();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void h(Object obj, Object obj2) {
        ((zzed) obj).zzc = (o0) obj2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void i(Object obj, zzhq zzhqVar) throws IOException {
        ((o0) obj).k(zzhqVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final /* synthetic */ void j(Object obj, zzhq zzhqVar) throws IOException {
        ((o0) obj).l(zzhqVar);
    }
}
