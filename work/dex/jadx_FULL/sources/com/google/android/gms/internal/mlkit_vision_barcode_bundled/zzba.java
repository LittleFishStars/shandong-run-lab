package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.ubc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "BarcodeParcelCreator")
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new ubc();

    @SafeParcelable.Field(getter = "getFormat", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getDisplayValue", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getRawValue", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getRawBytes", id = 4)
    private final byte[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getCornerPoints", id = 5)
    private final Point[] zze;

    @SafeParcelable.Field(getter = "getValueType", id = 6)
    private final int zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getEmailParcel", id = 7)
    private final zzat zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzaw zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzax zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzaz zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzay zzk;

    @Nullable
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzau zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzaq zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzar zzn;

    @Nullable
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzas zzo;

    @SafeParcelable.Constructor
    public zzba(@SafeParcelable.Param(id = 1) int i, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i2, @Nullable @SafeParcelable.Param(id = 7) zzat zzatVar, @Nullable @SafeParcelable.Param(id = 8) zzaw zzawVar, @Nullable @SafeParcelable.Param(id = 9) zzax zzaxVar, @Nullable @SafeParcelable.Param(id = 10) zzaz zzazVar, @Nullable @SafeParcelable.Param(id = 11) zzay zzayVar, @Nullable @SafeParcelable.Param(id = 12) zzau zzauVar, @Nullable @SafeParcelable.Param(id = 13) zzaq zzaqVar, @Nullable @SafeParcelable.Param(id = 14) zzar zzarVar, @Nullable @SafeParcelable.Param(id = 15) zzas zzasVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzatVar;
        this.zzh = zzawVar;
        this.zzi = zzaxVar;
        this.zzj = zzazVar;
        this.zzk = zzayVar;
        this.zzl = zzauVar;
        this.zzm = zzaqVar;
        this.zzn = zzarVar;
        this.zzo = zzasVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zza);
        lu7.Y(parcel, 2, this.zzb, false);
        lu7.Y(parcel, 3, this.zzc, false);
        lu7.m(parcel, 4, this.zzd, false);
        lu7.c0(parcel, 5, this.zze, i, false);
        lu7.F(parcel, 6, this.zzf);
        lu7.S(parcel, 7, this.zzg, i, false);
        lu7.S(parcel, 8, this.zzh, i, false);
        lu7.S(parcel, 9, this.zzi, i, false);
        lu7.S(parcel, 10, this.zzj, i, false);
        lu7.S(parcel, 11, this.zzk, i, false);
        lu7.S(parcel, 12, this.zzl, i, false);
        lu7.S(parcel, 13, this.zzm, i, false);
        lu7.S(parcel, 14, this.zzn, i, false);
        lu7.S(parcel, 15, this.zzo, i, false);
        lu7.b(parcel, iA);
    }
}
