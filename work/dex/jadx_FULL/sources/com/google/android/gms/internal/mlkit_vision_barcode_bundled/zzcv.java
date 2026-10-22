package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzcv extends zzcy {
    private final int zzc;
    private final int zzd;

    public zzcv(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdb.zzo(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcy, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final byte zza(int i) {
        zzdb.zzv(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcy, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcy
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcy, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcy, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
