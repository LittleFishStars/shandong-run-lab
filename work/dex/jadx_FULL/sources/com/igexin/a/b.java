package com.igexin.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37777a = "com.igexin.push.extension.distribution.gws.action.guard.WakeCallback";
    private static final int c = 1;
    private IBinder b;

    public b(IBinder iBinder) {
        this.b = iBinder;
    }

    private IBinder a() {
        return this.b;
    }

    public final void a(Bundle bundle) throws RemoteException {
        if (this.b == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(f37777a);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            this.b.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
