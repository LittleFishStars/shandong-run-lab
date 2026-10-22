package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.ytd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "ContactInfoParcelCreator")
public final class zzva extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzva> CREATOR = new ytd();

    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final zzve zza;

    @Nullable
    @SafeParcelable.Field(getter = "getOrganization", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getPhones", id = 4)
    private final zzvf[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getEmails", id = 5)
    private final zzvc[] zze;

    @Nullable
    @SafeParcelable.Field(getter = "getUrls", id = 6)
    private final String[] zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getAddresses", id = 7)
    private final zzux[] zzg;

    @SafeParcelable.Constructor
    public zzva(@Nullable @SafeParcelable.Param(id = 1) zzve zzveVar, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) zzvf[] zzvfVarArr, @Nullable @SafeParcelable.Param(id = 5) zzvc[] zzvcVarArr, @Nullable @SafeParcelable.Param(id = 6) String[] strArr, @Nullable @SafeParcelable.Param(id = 7) zzux[] zzuxVarArr) {
        this.zza = zzveVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzvfVarArr;
        this.zze = zzvcVarArr;
        this.zzf = strArr;
        this.zzg = zzuxVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.S(parcel, 1, this.zza, i, false);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.Y(parcel, 3, this.zzc, false);
        lu7.c0(parcel, 4, this.zzd, i, false);
        lu7.c0(parcel, 5, this.zze, i, false);
        lu7.Z(parcel, 6, this.zzf, false);
        lu7.c0(parcel, 7, this.zzg, i, false);
        lu7.b(parcel, iA);
    }

    @Nullable
    public final zzve zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    @Nullable
    public final zzux[] zzd() {
        return this.zzg;
    }

    @Nullable
    public final zzvc[] zze() {
        return this.zze;
    }

    @Nullable
    public final zzvf[] zzf() {
        return this.zzd;
    }

    @Nullable
    public final String[] zzg() {
        return this.zzf;
    }
}
