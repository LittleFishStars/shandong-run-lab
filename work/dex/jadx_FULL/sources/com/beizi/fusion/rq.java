package com.beizi.fusion;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rq implements tq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f27735a;

    public rq(IBinder iBinder) {
        this.f27735a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f27735a;
    }

    @Override // com.beizi.fusion.tq
    public String getOAID() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f27735a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable unused) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            string = null;
        }
        parcelObtain2.recycle();
        parcelObtain.recycle();
        return string;
    }
}
