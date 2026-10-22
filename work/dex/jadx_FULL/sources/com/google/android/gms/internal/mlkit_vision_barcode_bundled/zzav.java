package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.wcc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "PersonNameParcelCreator")
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new wcc();

    @Nullable
    @SafeParcelable.Field(getter = "getFormattedName", id = 1)
    private final String zza;

    @Nullable
    @SafeParcelable.Field(getter = "getPronunciation", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getPrefix", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getFirst", id = 4)
    private final String zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getMiddle", id = 5)
    private final String zze;

    @Nullable
    @SafeParcelable.Field(getter = "getLast", id = 6)
    private final String zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getSuffix", id = 7)
    private final String zzg;

    @SafeParcelable.Constructor
    public zzav(@Nullable @SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @Nullable @SafeParcelable.Param(id = 5) String str5, @Nullable @SafeParcelable.Param(id = 6) String str6, @Nullable @SafeParcelable.Param(id = 7) String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
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
        lu7.b(parcel, iA);
    }
}
