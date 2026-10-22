package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.zj.adlib.e2c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zal extends com.google.android.gms.internal.base.zaa implements IInterface {
    public zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zak zakVar) throws RemoteException {
        Parcel parcelZaa = zaa();
        e2c.e(parcelZaa, zakVar);
        zad(1, parcelZaa);
    }
}
