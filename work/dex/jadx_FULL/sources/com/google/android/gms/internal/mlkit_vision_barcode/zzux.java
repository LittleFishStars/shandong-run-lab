package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.ntd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "AddressParcelCreator")
public final class zzux extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzux> CREATOR = new ntd();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getAddressLines", id = 2)
    private final String[] zzb;

    @SafeParcelable.Constructor
    public zzux(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String[] strArr) {
        this.zza = i;
        this.zzb = strArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zza);
        lu7.Z(parcel, 2, this.zzb, false);
        lu7.b(parcel, iA);
    }

    public final int zza() {
        return this.zza;
    }

    public final String[] zzb() {
        return this.zzb;
    }
}
