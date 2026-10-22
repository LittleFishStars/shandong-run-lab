package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.vtd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "BarcodeScannerOptionsParcelCreator")
public final class zzvl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvl> CREATOR = new vtd();

    @SafeParcelable.Field(getter = "getSupportedFormats", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "isAllPotentialBarcodesEnabled", id = 2)
    private final boolean zzb;

    @SafeParcelable.Constructor
    public zzvl(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zza);
        lu7.g(parcel, 2, this.zzb);
        lu7.b(parcel, iA);
    }
}
