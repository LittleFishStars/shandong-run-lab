package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfi;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qpc {
    public static final int a(int i, Object obj, Object obj2) {
        zzfi zzfiVar = (zzfi) obj;
        if (zzfiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzfiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object b(Object obj, Object obj2) {
        zzfi zzfiVarZzb = (zzfi) obj;
        zzfi zzfiVar = (zzfi) obj2;
        if (!zzfiVar.isEmpty()) {
            if (!zzfiVarZzb.zze()) {
                zzfiVarZzb = zzfiVarZzb.zzb();
            }
            zzfiVarZzb.zzd(zzfiVar);
        }
        return zzfiVarZzb;
    }
}
