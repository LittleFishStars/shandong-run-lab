package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.idc;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "WiFiParcelCreator")
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new idc();

    @Nullable
    @SafeParcelable.Field(getter = "getSsid", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getEncryptionType", id = 3)
    private final int zzc;

    @SafeParcelable.Constructor
    public zzaz(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) int i) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.Y(parcel, 1, this.zza, false);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.F(parcel, 3, this.zzc);
        lu7.b(parcel, iA);
    }
}
