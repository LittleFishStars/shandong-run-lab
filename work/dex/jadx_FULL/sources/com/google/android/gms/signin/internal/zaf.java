package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.zj.adlib.e2c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i) throws RemoteException {
        Parcel parcelZaa = zaa();
        parcelZaa.writeInt(i);
        zac(7, parcelZaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel parcelZaa = zaa();
        e2c.e(parcelZaa, iAccountAccessor);
        parcelZaa.writeInt(i);
        e2c.c(parcelZaa, z);
        zac(9, parcelZaa);
    }

    public final void zag(zai zaiVar, zae zaeVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        e2c.d(parcelZaa, zaiVar);
        e2c.e(parcelZaa, zaeVar);
        zac(12, parcelZaa);
    }
}
