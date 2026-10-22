package com.zj.adlib;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d2c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iI0 = SafeParcelReader.i0(parcel);
        ArrayList arrayListL = null;
        String strG = null;
        boolean zP = false;
        String strG2 = null;
        while (parcel.dataPosition() < iI0) {
            int iX = SafeParcelReader.X(parcel);
            int iO = SafeParcelReader.O(iX);
            if (iO == 1) {
                arrayListL = SafeParcelReader.L(parcel, iX, Feature.CREATOR);
            } else if (iO == 2) {
                zP = SafeParcelReader.P(parcel, iX);
            } else if (iO == 3) {
                strG2 = SafeParcelReader.G(parcel, iX);
            } else if (iO != 4) {
                SafeParcelReader.h0(parcel, iX);
            } else {
                strG = SafeParcelReader.G(parcel, iX);
            }
        }
        SafeParcelReader.N(parcel, iI0);
        return new ApiFeatureRequest(arrayListL, zP, strG2, strG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ApiFeatureRequest[i];
    }
}
