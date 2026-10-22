package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.dcc;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "CalendarDateTimeParcelCreator")
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new dcc();

    @SafeParcelable.Field(getter = "getYear", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getMonth", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getDay", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getHours", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "getMinutes", id = 5)
    private final int zze;

    @SafeParcelable.Field(getter = "getSeconds", id = 6)
    private final int zzf;

    @SafeParcelable.Field(getter = "isUtc", id = 7)
    private final boolean zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getRawValue", id = 8)
    private final String zzh;

    @SafeParcelable.Constructor
    public zzap(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) int i6, @SafeParcelable.Param(id = 7) boolean z, @Nullable @SafeParcelable.Param(id = 8) String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = z;
        this.zzh = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zza);
        lu7.F(parcel, 2, this.zzb);
        lu7.F(parcel, 3, this.zzc);
        lu7.F(parcel, 4, this.zzd);
        lu7.F(parcel, 5, this.zze);
        lu7.F(parcel, 6, this.zzf);
        lu7.g(parcel, 7, this.zzg);
        lu7.Y(parcel, 8, this.zzh, false);
        lu7.b(parcel, iA);
    }
}
