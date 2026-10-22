package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ntc extends bvc {
    public ntc(int i) {
        super(i, null);
    }

    @Override // com.zj.adlib.bvc
    public final void b() {
        if (!k()) {
            for (int i = 0; i < c(); i++) {
                ((zzds) h(i).getKey()).zzg();
            }
            Iterator it = d().iterator();
            while (it.hasNext()) {
                ((zzds) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.b();
    }
}
