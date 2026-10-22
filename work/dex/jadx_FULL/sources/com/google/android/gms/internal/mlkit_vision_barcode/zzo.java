package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.u7c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "GeoPointCreator")
@SafeParcelable.Reserved({1})
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new u7c();

    @SafeParcelable.Field(id = 2)
    public double zza;

    @SafeParcelable.Field(id = 3)
    public double zzb;

    public zzo() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.r(parcel, 2, this.zza);
        lu7.r(parcel, 3, this.zzb);
        lu7.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 2) double d, @SafeParcelable.Param(id = 3) double d2) {
        this.zza = d;
        this.zzb = d2;
    }
}
