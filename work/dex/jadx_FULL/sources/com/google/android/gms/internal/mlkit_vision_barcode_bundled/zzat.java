package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.ncc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "EmailParcelCreator")
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new ncc();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getAddress", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getSubject", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getBody", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public zzat(@SafeParcelable.Param(id = 1) int i, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zza);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.Y(parcel, 3, this.zzc, false);
        lu7.Y(parcel, 4, this.zzd, false);
        lu7.b(parcel, iA);
    }
}
