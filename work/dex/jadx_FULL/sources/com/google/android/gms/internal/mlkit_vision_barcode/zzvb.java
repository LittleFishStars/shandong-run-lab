package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.ztd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "DriverLicenseParcelCreator")
public final class zzvb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvb> CREATOR = new ztd();

    @Nullable
    @SafeParcelable.Field(getter = "getDocumentType", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getFirstName", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getMiddleName", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getLastName", id = 4)
    private final String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getGender", id = 5)
    private final String zze;

    @Nullable
    @SafeParcelable.Field(getter = "getAddressStreet", id = 6)
    private final String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getAddressCity", id = 7)
    private final String zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getAddressState", id = 8)
    private final String zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getAddressZip", id = 9)
    private final String zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getLicenseNumber", id = 10)
    private final String zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getIssueDate", id = 11)
    private final String zzk;

    @Nullable
    @SafeParcelable.Field(getter = "getExpiryDate", id = 12)
    private final String zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getBirthDate", id = 13)
    private final String zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getIssuingCountry", id = 14)
    private final String zzn;

    @SafeParcelable.Constructor
    public zzvb(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) String str5, @Nullable @SafeParcelable.Param(id = 6) String str6, @Nullable @SafeParcelable.Param(id = 7) String str7, @Nullable @SafeParcelable.Param(id = 8) String str8, @Nullable @SafeParcelable.Param(id = 9) String str9, @Nullable @SafeParcelable.Param(id = 10) String str10, @Nullable @SafeParcelable.Param(id = 11) String str11, @Nullable @SafeParcelable.Param(id = 12) String str12, @Nullable @SafeParcelable.Param(id = 13) String str13, @Nullable @SafeParcelable.Param(id = 14) String str14) {
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.Y(parcel, 1, this.zza, false);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.Y(parcel, 3, this.zzc, false);
        lu7.Y(parcel, 4, this.zzd, false);
        lu7.Y(parcel, 5, this.zze, false);
        lu7.Y(parcel, 6, this.zzf, false);
        lu7.Y(parcel, 7, this.zzg, false);
        lu7.Y(parcel, 8, this.zzh, false);
        lu7.Y(parcel, 9, this.zzi, false);
        lu7.Y(parcel, 10, this.zzj, false);
        lu7.Y(parcel, 11, this.zzk, false);
        lu7.Y(parcel, 12, this.zzl, false);
        lu7.Y(parcel, 13, this.zzm, false);
        lu7.Y(parcel, 14, this.zzn, false);
        lu7.b(parcel, iA);
    }

    @Nullable
    public final String zza() {
        return this.zzg;
    }

    @Nullable
    public final String zzb() {
        return this.zzh;
    }

    @Nullable
    public final String zzc() {
        return this.zzf;
    }

    @Nullable
    public final String zzd() {
        return this.zzi;
    }

    @Nullable
    public final String zze() {
        return this.zzm;
    }

    @Nullable
    public final String zzf() {
        return this.zza;
    }

    @Nullable
    public final String zzg() {
        return this.zzl;
    }

    @Nullable
    public final String zzh() {
        return this.zzb;
    }

    @Nullable
    public final String zzi() {
        return this.zze;
    }

    @Nullable
    public final String zzj() {
        return this.zzk;
    }

    @Nullable
    public final String zzk() {
        return this.zzn;
    }

    @Nullable
    public final String zzl() {
        return this.zzd;
    }

    @Nullable
    public final String zzm() {
        return this.zzj;
    }

    @Nullable
    public final String zzn() {
        return this.zzc;
    }
}
