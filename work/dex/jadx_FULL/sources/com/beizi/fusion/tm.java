package com.beizi.fusion;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class tm implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f27791a;

    public tm(IBinder iBinder) {
        this.f27791a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f27791a;
    }

    public String b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            this.f27791a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return null;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
