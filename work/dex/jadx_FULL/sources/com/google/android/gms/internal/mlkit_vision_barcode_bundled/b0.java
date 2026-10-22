package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b0 implements zzfm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzfm[] f31371a;

    public b0(zzfm... zzfmVarArr) {
        this.f31371a = zzfmVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzfl a(Class cls) {
        zzfm[] zzfmVarArr = this.f31371a;
        for (int i = 0; i < 2; i++) {
            zzfm zzfmVar = zzfmVarArr[i];
            if (zzfmVar.b(cls)) {
                return zzfmVar.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final boolean b(Class cls) {
        zzfm[] zzfmVarArr = this.f31371a;
        for (int i = 0; i < 2; i++) {
            if (zzfmVarArr[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
