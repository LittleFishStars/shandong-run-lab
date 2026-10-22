package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.zj.adlib.lu7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j implements Parcelable.Creator {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, getServiceRequest.zzc);
        lu7.F(parcel, 2, getServiceRequest.zzd);
        lu7.F(parcel, 3, getServiceRequest.zze);
        lu7.Y(parcel, 4, getServiceRequest.zzf, false);
        lu7.B(parcel, 5, getServiceRequest.zzg, false);
        lu7.c0(parcel, 6, getServiceRequest.zzh, i, false);
        lu7.k(parcel, 7, getServiceRequest.zzi, false);
        lu7.S(parcel, 8, getServiceRequest.zzj, i, false);
        lu7.c0(parcel, 10, getServiceRequest.zzk, i, false);
        lu7.c0(parcel, 11, getServiceRequest.zzl, i, false);
        lu7.g(parcel, 12, getServiceRequest.zzm);
        lu7.F(parcel, 13, getServiceRequest.zzn);
        lu7.g(parcel, 14, getServiceRequest.zzo);
        lu7.Y(parcel, 15, getServiceRequest.zza(), false);
        lu7.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        Feature[] featureArr2 = featureArr;
        int iZ = 0;
        int iZ2 = 0;
        int iZ3 = 0;
        boolean zP = false;
        int iZ4 = 0;
        boolean zP2 = false;
        String strG = null;
        IBinder iBinderY = null;
        Account account = null;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    iZ2 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 3:
                    iZ3 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 4:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    iBinderY = SafeParcelReader.Y(parcel, iX);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.K(parcel, iX, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.g(parcel, iX);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.C(parcel, iX, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.K(parcel, iX, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.K(parcel, iX, Feature.CREATOR);
                    break;
                case 12:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 13:
                    iZ4 = SafeParcelReader.Z(parcel, iX);
                    break;
                case 14:
                    zP2 = SafeParcelReader.P(parcel, iX);
                    break;
                case 15:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new GetServiceRequest(iZ, iZ2, iZ3, strG, iBinderY, scopeArr, bundle, account, featureArr, featureArr2, zP, iZ4, zP2, strG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
