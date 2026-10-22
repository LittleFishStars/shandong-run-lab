package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.doc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y extends zzfc {
    public y() {
        super(null);
    }

    public /* synthetic */ y(doc docVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void a(Object obj, long j) {
        ((zzel) s0.k(obj, j)).p();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void b(Object obj, Object obj2, long j) {
        zzel zzelVarW = (zzel) s0.k(obj, j);
        zzel zzelVar = (zzel) s0.k(obj2, j);
        int size = zzelVarW.size();
        int size2 = zzelVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzelVarW.r()) {
                zzelVarW = zzelVarW.W(size2 + size);
            }
            zzelVarW.addAll(zzelVar);
        }
        if (size > 0) {
            zzelVar = zzelVarW;
        }
        s0.x(obj, j, zzelVar);
    }
}
