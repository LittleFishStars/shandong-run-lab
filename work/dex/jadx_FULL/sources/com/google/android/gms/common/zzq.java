package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.bic;
import com.zj.adlib.cvd;
import com.zj.adlib.hpd;
import com.zj.adlib.lu7;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new hpd();

    @SafeParcelable.Field(getter = "getResult", id = 1)
    private final boolean zza;

    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getStatusValue", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getFirstPartyStatusValue", id = 4)
    private final int zzd;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2) {
        this.zza = z;
        this.zzb = str;
        this.zzc = cvd.a(i) - 1;
        this.zzd = bic.a(i2) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.g(parcel, 1, this.zza);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.F(parcel, 3, this.zzc);
        lu7.F(parcel, 4, this.zzd);
        lu7.b(parcel, iA);
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final int zzc() {
        return bic.a(this.zzd);
    }

    public final int zzd() {
        return cvd.a(this.zzc);
    }
}
