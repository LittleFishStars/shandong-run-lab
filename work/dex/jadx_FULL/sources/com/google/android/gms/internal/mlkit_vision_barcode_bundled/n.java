package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bkc;
import com.zj.adlib.hlc;
import com.zj.adlib.qjc;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n extends zzdp {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final int a(Map.Entry entry) {
        return ((hlc) entry.getKey()).K;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final bkc b(Object obj) {
        return ((zzdz) obj).zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final bkc c(Object obj) {
        return ((zzdz) obj).t();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final Object d(qjc qjcVar, zzfo zzfoVar, int i) {
        return qjcVar.b(zzfoVar, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final void e(Object obj) {
        ((zzdz) obj).zza.g();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final void f(zzhq zzhqVar, Map.Entry entry) throws IOException {
        hlc hlcVar = (hlc) entry.getKey();
        zzho zzhoVar = zzho.zza;
        switch (hlcVar.f42156a.ordinal()) {
            case 0:
                zzhqVar.a(hlcVar.K, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                zzhqVar.i(hlcVar.K, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                zzhqVar.m(hlcVar.K, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                zzhqVar.F(hlcVar.K, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzhqVar.k(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                zzhqVar.e(hlcVar.K, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                zzhqVar.g(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                zzhqVar.n(hlcVar.K, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                zzhqVar.E(hlcVar.K, (String) entry.getValue());
                break;
            case 9:
                zzhqVar.C(hlcVar.K, entry.getValue(), g0.a().b(entry.getValue().getClass()));
                break;
            case 10:
                zzhqVar.z(hlcVar.K, entry.getValue(), g0.a().b(entry.getValue().getClass()));
                break;
            case 11:
                zzhqVar.H(hlcVar.K, (zzdb) entry.getValue());
                break;
            case 12:
                zzhqVar.G(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzhqVar.k(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                zzhqVar.r(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzhqVar.u(hlcVar.K, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                zzhqVar.x(hlcVar.K, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                zzhqVar.A(hlcVar.K, ((Long) entry.getValue()).longValue());
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdp
    public final boolean g(zzfo zzfoVar) {
        return zzfoVar instanceof zzdz;
    }
}
