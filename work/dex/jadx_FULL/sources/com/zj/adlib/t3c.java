package com.zj.adlib;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t3c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        int iZ = 0;
        boolean zP = false;
        boolean zP2 = false;
        boolean zP3 = false;
        ArrayList arrayListL = null;
        Account account = null;
        String strG = null;
        String strG2 = null;
        ArrayList arrayListL2 = null;
        String strG3 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(iX)) {
                case 1:
                    iZ = SafeParcelReader.Z(parcel, iX);
                    break;
                case 2:
                    arrayListL = SafeParcelReader.L(parcel, iX, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.C(parcel, iX, Account.CREATOR);
                    break;
                case 4:
                    zP = SafeParcelReader.P(parcel, iX);
                    break;
                case 5:
                    zP2 = SafeParcelReader.P(parcel, iX);
                    break;
                case 6:
                    zP3 = SafeParcelReader.P(parcel, iX);
                    break;
                case 7:
                    strG = SafeParcelReader.G(parcel, iX);
                    break;
                case 8:
                    strG2 = SafeParcelReader.G(parcel, iX);
                    break;
                case 9:
                    arrayListL2 = SafeParcelReader.L(parcel, iX, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    strG3 = SafeParcelReader.G(parcel, iX);
                    break;
                default:
                    SafeParcelReader.h0(parcel, iX);
                    break;
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new GoogleSignInOptions(iZ, arrayListL, account, zP, zP2, zP3, strG, strG2, arrayListL2, strG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
