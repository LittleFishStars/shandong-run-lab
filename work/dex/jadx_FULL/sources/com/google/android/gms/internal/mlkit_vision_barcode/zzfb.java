package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzfb implements zzfg {
    private final int zza;
    private final zzff zzb;

    public zzfb(int i, zzff zzffVar) {
        this.zza = i;
        this.zzb = zzffVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzfg.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfg)) {
            return false;
        }
        zzfg zzfgVar = (zzfg) obj;
        return this.zza == zzfgVar.zza() && this.zzb.equals(zzfgVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfg
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfg
    public final zzff zzb() {
        return this.zzb;
    }
}
