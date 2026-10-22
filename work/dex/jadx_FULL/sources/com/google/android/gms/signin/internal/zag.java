package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.zj.adlib.f4c;
import com.zj.adlib.lu7;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "RecordConsentByConsentResultResponseCreator")
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new f4c();

    @SafeParcelable.Field(getter = "getGrantedScopes", id = 1)
    private final List zaa;

    @Nullable
    @SafeParcelable.Field(getter = "getToken", id = 2)
    private final String zab;

    @SafeParcelable.Constructor
    public zag(@SafeParcelable.Param(id = 1) List list, @Nullable @SafeParcelable.Param(id = 2) String str) {
        this.zaa = list;
        this.zab = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zab != null ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.a0(parcel, 1, this.zaa, false);
        lu7.Y(parcel, 2, this.zab, false);
        lu7.b(parcel, iA);
    }
}
