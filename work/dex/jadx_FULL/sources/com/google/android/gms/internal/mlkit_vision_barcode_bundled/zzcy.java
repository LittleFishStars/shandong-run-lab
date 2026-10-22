package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.rgc;
import com.zj.adlib.rmc;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class zzcy extends zzcx {
    protected final byte[] zza;

    public zzcy(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdb) || zzd() != ((zzdb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzcy)) {
            return obj.equals(this);
        }
        zzcy zzcyVar = (zzcy) obj;
        int iZzp = zzp();
        int iZzp2 = zzcyVar.zzp();
        if (iZzp == 0 || iZzp2 == 0 || iZzp == iZzp2) {
            return zzg(zzcyVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcx
    public final boolean zzg(zzdb zzdbVar, int i, int i2) {
        if (i2 > zzdbVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzdbVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzdbVar.zzd());
        }
        if (!(zzdbVar instanceof zzcy)) {
            return zzdbVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzcy zzcyVar = (zzcy) zzdbVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzcyVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzcyVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzi(int i, int i2, int i3) {
        return rmc.b(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        return u0.f(i, this.zza, iZzc, i3 + iZzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final zzdb zzk(int i, int i2) {
        int iZzo = zzdb.zzo(i, i2, zzd());
        return iZzo == 0 ? zzdb.zzb : new zzcv(this.zza, zzc() + i, iZzo);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final void zzm(rgc rgcVar) throws IOException {
        ((k) rgcVar).C(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean zzn() {
        int iZzc = zzc();
        return u0.h(this.zza, iZzc, zzd() + iZzc);
    }
}
