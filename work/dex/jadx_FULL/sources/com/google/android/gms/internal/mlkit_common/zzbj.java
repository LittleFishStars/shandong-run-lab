package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzbj implements zzbo {
    private final int zza;
    private final zzbn zzb;

    public zzbj(int i, zzbn zzbnVar) {
        this.zza = i;
        this.zzb = zzbnVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzbo.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbo)) {
            return false;
        }
        zzbo zzboVar = (zzbo) obj;
        return this.zza == zzboVar.zza() && this.zzb.equals(zzboVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbo
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbo
    public final zzbn zzb() {
        return this.zzb;
    }
}
