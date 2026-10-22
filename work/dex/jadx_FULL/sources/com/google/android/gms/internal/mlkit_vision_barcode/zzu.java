package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.qtd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "BarcodeCreator")
@SafeParcelable.Reserved({1})
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new qtd();

    @SafeParcelable.Field(id = 2)
    public int zza;

    @SafeParcelable.Field(id = 3)
    public String zzb;

    @SafeParcelable.Field(id = 4)
    public String zzc;

    @SafeParcelable.Field(id = 5)
    public int zzd;

    @SafeParcelable.Field(id = 6)
    public Point[] zze;

    @SafeParcelable.Field(id = 7)
    public zzn zzf;

    @SafeParcelable.Field(id = 8)
    public zzq zzg;

    @SafeParcelable.Field(id = 9)
    public zzr zzh;

    @SafeParcelable.Field(id = 10)
    public zzt zzi;

    @SafeParcelable.Field(id = 11)
    public zzs zzj;

    @SafeParcelable.Field(id = 12)
    public zzo zzk;

    @SafeParcelable.Field(id = 13)
    public zzk zzl;

    @SafeParcelable.Field(id = 14)
    public zzl zzm;

    @SafeParcelable.Field(id = 15)
    public zzm zzn;

    @SafeParcelable.Field(id = 16)
    public byte[] zzo;

    @SafeParcelable.Field(id = 17)
    public boolean zzp;

    @SafeParcelable.Field(id = 18)
    public double zzq;

    public zzu() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 2, this.zza);
        lu7.Y(parcel, 3, this.zzb, false);
        lu7.Y(parcel, 4, this.zzc, false);
        lu7.F(parcel, 5, this.zzd);
        lu7.c0(parcel, 6, this.zze, i, false);
        lu7.S(parcel, 7, this.zzf, i, false);
        lu7.S(parcel, 8, this.zzg, i, false);
        lu7.S(parcel, 9, this.zzh, i, false);
        lu7.S(parcel, 10, this.zzi, i, false);
        lu7.S(parcel, 11, this.zzj, i, false);
        lu7.S(parcel, 12, this.zzk, i, false);
        lu7.S(parcel, 13, this.zzl, i, false);
        lu7.S(parcel, 14, this.zzm, i, false);
        lu7.S(parcel, 15, this.zzn, i, false);
        lu7.m(parcel, 16, this.zzo, false);
        lu7.g(parcel, 17, this.zzp);
        lu7.r(parcel, 18, this.zzq);
        lu7.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzu(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) Point[] pointArr, @SafeParcelable.Param(id = 7) zzn zznVar, @SafeParcelable.Param(id = 8) zzq zzqVar, @SafeParcelable.Param(id = 9) zzr zzrVar, @SafeParcelable.Param(id = 10) zzt zztVar, @SafeParcelable.Param(id = 11) zzs zzsVar, @SafeParcelable.Param(id = 12) zzo zzoVar, @SafeParcelable.Param(id = 13) zzk zzkVar, @SafeParcelable.Param(id = 14) zzl zzlVar, @SafeParcelable.Param(id = 15) zzm zzmVar, @SafeParcelable.Param(id = 16) byte[] bArr, @SafeParcelable.Param(id = 17) boolean z, @SafeParcelable.Param(id = 18) double d) {
        this.zza = i;
        this.zzb = str;
        this.zzo = bArr;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = pointArr;
        this.zzp = z;
        this.zzq = d;
        this.zzf = zznVar;
        this.zzg = zzqVar;
        this.zzh = zzrVar;
        this.zzi = zztVar;
        this.zzj = zzsVar;
        this.zzk = zzoVar;
        this.zzl = zzkVar;
        this.zzm = zzlVar;
        this.zzn = zzmVar;
    }
}
