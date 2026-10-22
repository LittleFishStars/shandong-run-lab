package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.evd;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "DriverLicenseCreator")
@SafeParcelable.Reserved({1})
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new evd();

    @SafeParcelable.Field(id = 2)
    public String zza;

    @SafeParcelable.Field(id = 3)
    public String zzb;

    @SafeParcelable.Field(id = 4)
    public String zzc;

    @SafeParcelable.Field(id = 5)
    public String zzd;

    @SafeParcelable.Field(id = 6)
    public String zze;

    @SafeParcelable.Field(id = 7)
    public String zzf;

    @SafeParcelable.Field(id = 8)
    public String zzg;

    @SafeParcelable.Field(id = 9)
    public String zzh;

    @SafeParcelable.Field(id = 10)
    public String zzi;

    @SafeParcelable.Field(id = 11)
    public String zzj;

    @SafeParcelable.Field(id = 12)
    public String zzk;

    @SafeParcelable.Field(id = 13)
    public String zzl;

    @SafeParcelable.Field(id = 14)
    public String zzm;

    @SafeParcelable.Field(id = 15)
    public String zzn;

    public zzm() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.Y(parcel, 2, this.zza, false);
        lu7.Y(parcel, 3, this.zzb, false);
        lu7.Y(parcel, 4, this.zzc, false);
        lu7.Y(parcel, 5, this.zzd, false);
        lu7.Y(parcel, 6, this.zze, false);
        lu7.Y(parcel, 7, this.zzf, false);
        lu7.Y(parcel, 8, this.zzg, false);
        lu7.Y(parcel, 9, this.zzh, false);
        lu7.Y(parcel, 10, this.zzi, false);
        lu7.Y(parcel, 11, this.zzj, false);
        lu7.Y(parcel, 12, this.zzk, false);
        lu7.Y(parcel, 13, this.zzl, false);
        lu7.Y(parcel, 14, this.zzm, false);
        lu7.Y(parcel, 15, this.zzn, false);
        lu7.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) String str9, @SafeParcelable.Param(id = 11) String str10, @SafeParcelable.Param(id = 12) String str11, @SafeParcelable.Param(id = 13) String str12, @SafeParcelable.Param(id = 14) String str13, @SafeParcelable.Param(id = 15) String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
    }
}
