package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.gud;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "CalendarDateTimeCreator")
@SafeParcelable.Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new gud();

    @SafeParcelable.Field(id = 2)
    public int zza;

    @SafeParcelable.Field(id = 3)
    public int zzb;

    @SafeParcelable.Field(id = 4)
    public int zzc;

    @SafeParcelable.Field(id = 5)
    public int zzd;

    @SafeParcelable.Field(id = 6)
    public int zze;

    @SafeParcelable.Field(id = 7)
    public int zzf;

    @SafeParcelable.Field(id = 8)
    public boolean zzg;

    @SafeParcelable.Field(id = 9)
    public String zzh;

    public zzj() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 2, this.zza);
        lu7.F(parcel, 3, this.zzb);
        lu7.F(parcel, 4, this.zzc);
        lu7.F(parcel, 5, this.zzd);
        lu7.F(parcel, 6, this.zze);
        lu7.F(parcel, 7, this.zzf);
        lu7.g(parcel, 8, this.zzg);
        lu7.Y(parcel, 9, this.zzh, false);
        lu7.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) int i6, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = z;
        this.zzh = str;
    }
}
