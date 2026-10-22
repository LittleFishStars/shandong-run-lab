package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.xtd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "CalendarEventParcelCreator")
public final class zzuz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuz> CREATOR = new xtd();

    @Nullable
    @SafeParcelable.Field(getter = "getSummary", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDescription", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getLocation", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getOrganizer", id = 4)
    private final String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getStatus", id = 5)
    private final String zze;

    @Nullable
    @SafeParcelable.Field(getter = "getStart", id = 6)
    private final zzuy zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getEnd", id = 7)
    private final zzuy zzg;

    @SafeParcelable.Constructor
    public zzuz(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) String str5, @Nullable @SafeParcelable.Param(id = 6) zzuy zzuyVar, @Nullable @SafeParcelable.Param(id = 7) zzuy zzuyVar2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzuyVar;
        this.zzg = zzuyVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.Y(parcel, 1, this.zza, false);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.Y(parcel, 3, this.zzc, false);
        lu7.Y(parcel, 4, this.zzd, false);
        lu7.Y(parcel, 5, this.zze, false);
        lu7.S(parcel, 6, this.zzf, i, false);
        lu7.S(parcel, 7, this.zzg, i, false);
        lu7.b(parcel, iA);
    }

    @Nullable
    public final zzuy zza() {
        return this.zzg;
    }

    @Nullable
    public final zzuy zzb() {
        return this.zzf;
    }

    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    @Nullable
    public final String zzd() {
        return this.zzc;
    }

    @Nullable
    public final String zze() {
        return this.zzd;
    }

    @Nullable
    public final String zzf() {
        return this.zze;
    }

    @Nullable
    public final String zzg() {
        return this.zza;
    }
}
