package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.zud;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "ContactInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zud();

    @SafeParcelable.Field(id = 2)
    public zzp zza;

    @SafeParcelable.Field(id = 3)
    public String zzb;

    @SafeParcelable.Field(id = 4)
    public String zzc;

    @SafeParcelable.Field(id = 5)
    public zzq[] zzd;

    @SafeParcelable.Field(id = 6)
    public zzn[] zze;

    @SafeParcelable.Field(id = 7)
    public String[] zzf;

    @SafeParcelable.Field(id = 8)
    public zzi[] zzg;

    public zzl() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.S(parcel, 2, this.zza, i, false);
        lu7.Y(parcel, 3, this.zzb, false);
        lu7.Y(parcel, 4, this.zzc, false);
        lu7.c0(parcel, 5, this.zzd, i, false);
        lu7.c0(parcel, 6, this.zze, i, false);
        lu7.Z(parcel, 7, this.zzf, false);
        lu7.c0(parcel, 8, this.zzg, i, false);
        lu7.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 2) zzp zzpVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) zzq[] zzqVarArr, @SafeParcelable.Param(id = 6) zzn[] zznVarArr, @SafeParcelable.Param(id = 7) String[] strArr, @SafeParcelable.Param(id = 8) zzi[] zziVarArr) {
        this.zza = zzpVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzqVarArr;
        this.zze = zznVarArr;
        this.zzf = strArr;
        this.zzg = zziVarArr;
    }
}
