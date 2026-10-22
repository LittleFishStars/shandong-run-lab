package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.r;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeg;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzft;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hlc implements zzds {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzho f42156a;

    public hlc(zzeg zzegVar, int i, zzho zzhoVar, boolean z, boolean z2) {
        this.K = i;
        this.f42156a = zzhoVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final boolean I() {
        return false;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.K - ((hlc) obj).K;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final zzho h0() {
        return this.f42156a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final zzft t0(zzft zzftVar, zzft zzftVar2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final zzfn u0(zzfn zzfnVar, zzfo zzfoVar) {
        ((r) zzfnVar).p((zzed) zzfoVar);
        return zzfnVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final zzhp x0() {
        return this.f42156a.zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final int zza() {
        return this.K;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds
    public final boolean zzg() {
        return false;
    }
}
