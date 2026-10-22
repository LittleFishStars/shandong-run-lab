package com.zj.adlib;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j1c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        Uri uri = null;
        String strG5 = null;
        String strG6 = null;
        ArrayList arrayListL = null;
        String strG7 = null;
        String strG8 = null;
        long jC0 = 0;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 3:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 4:
                    strG3 = SafeParcelReader.G(parcel, iX);
                    break;
                case 5:
                    strG4 = SafeParcelReader.G(parcel, iX);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.C(parcel, iX, Uri.CREATOR);
                    break;
                case 7:
                    strG5 = SafeParcelReader.G(parcel, iX);
                    break;
                case 8:
                    jC0 = SafeParcelReader.c0(parcel, iX);
                    break;
                case 9:
                    strG6 = SafeParcelReader.G(parcel, iX);
                    break;
                case 10:
                    arrayListL = SafeParcelReader.L(parcel, iX, Scope.CREATOR);
                    break;
                case 11:
                    strG7 = SafeParcelReader.G(parcel, iX);
                    break;
                case 12:
                    strG8 = SafeParcelReader.G(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new GoogleSignInAccount(iZ, strG, strG2, strG3, strG4, uri, strG5, jC0, strG6, arrayListL, strG7, strG8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
