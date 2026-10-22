package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xgc implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdb zzdbVar = (zzdb) obj;
        zzdb zzdbVar2 = (zzdb) obj2;
        zzcw it = zzdbVar.iterator();
        zzcw it2 = zzdbVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo = Integer.valueOf(it.j0() & 255).compareTo(Integer.valueOf(it2.j0() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzdbVar.zzd()).compareTo(Integer.valueOf(zzdbVar2.zzd()));
    }
}
