package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.eud;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "SmsParcelCreator")
public final class zzvg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvg> CREATOR = new eud();

    @Nullable
    @SafeParcelable.Field(getter = "getMessage", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzvg(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.Y(parcel, 1, this.zza, false);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.b(parcel, iA);
    }

    @Nullable
    public final String zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
