package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.lu7;
import com.zj.adlib.utd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "BarcodeParcelCreator")
public final class zzvj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvj> CREATOR = new utd();

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
    private final zzvc zzg;

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneParcel", id = 8)
    private final zzvf zzh;

    @Nullable
    @SafeParcelable.Field(getter = "getSmsParcel", id = 9)
    private final zzvg zzi;

    @Nullable
    @SafeParcelable.Field(getter = "getWiFiParcel", id = 10)
    private final zzvi zzj;

    @Nullable
    @SafeParcelable.Field(getter = "getUrlBookmarkParcel", id = 11)
    private final zzvh zzk;

    @Nullable
    @SafeParcelable.Field(getter = "getGeoPointParcel", id = 12)
    private final zzvd zzl;

    @Nullable
    @SafeParcelable.Field(getter = "getCalendarEventParcel", id = 13)
    private final zzuz zzm;

    @Nullable
    @SafeParcelable.Field(getter = "getContactInfoParcel", id = 14)
    private final zzva zzn;

    @Nullable
    @SafeParcelable.Field(getter = "getDriverLicenseParcel", id = 15)
    private final zzvb zzo;

    @SafeParcelable.Constructor
    public zzvj(@SafeParcelable.Param(id = 1) int i, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr, @Nullable @SafeParcelable.Param(id = 5) Point[] pointArr, @SafeParcelable.Param(id = 6) int i2, @Nullable @SafeParcelable.Param(id = 7) zzvc zzvcVar, @Nullable @SafeParcelable.Param(id = 8) zzvf zzvfVar, @Nullable @SafeParcelable.Param(id = 9) zzvg zzvgVar, @Nullable @SafeParcelable.Param(id = 10) zzvi zzviVar, @Nullable @SafeParcelable.Param(id = 11) zzvh zzvhVar, @Nullable @SafeParcelable.Param(id = 12) zzvd zzvdVar, @Nullable @SafeParcelable.Param(id = 13) zzuz zzuzVar, @Nullable @SafeParcelable.Param(id = 14) zzva zzvaVar, @Nullable @SafeParcelable.Param(id = 15) zzvb zzvbVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzvcVar;
        this.zzh = zzvfVar;
        this.zzi = zzvgVar;
        this.zzj = zzviVar;
        this.zzk = zzvhVar;
        this.zzl = zzvdVar;
        this.zzm = zzuzVar;
        this.zzn = zzvaVar;
        this.zzo = zzvbVar;
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

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Nullable
    public final zzuz zzc() {
        return this.zzm;
    }

    @Nullable
    public final zzva zzd() {
        return this.zzn;
    }

    @Nullable
    public final zzvb zze() {
        return this.zzo;
    }

    @Nullable
    public final zzvc zzf() {
        return this.zzg;
    }

    @Nullable
    public final zzvd zzg() {
        return this.zzl;
    }

    @Nullable
    public final zzvf zzh() {
        return this.zzh;
    }

    @Nullable
    public final zzvg zzi() {
        return this.zzi;
    }

    @Nullable
    public final zzvh zzj() {
        return this.zzk;
    }

    @Nullable
    public final zzvi zzk() {
        return this.zzj;
    }

    @Nullable
    public final String zzl() {
        return this.zzb;
    }

    @Nullable
    public final String zzm() {
        return this.zzc;
    }

    @Nullable
    public final byte[] zzn() {
        return this.zzd;
    }

    @Nullable
    public final Point[] zzo() {
        return this.zze;
    }
}
