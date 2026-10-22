package com.beizi.fusion;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a9 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f27000a;

    public a9(IBinder iBinder) {
        this.f27000a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f27000a;
    }

    public boolean b() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        boolean z = false;
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
            this.f27000a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            if (parcelObtain2.readInt() == 0) {
                z = true;
            }
        } catch (Throwable unused) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return z;
    }

    public String c() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
            this.f27000a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            om.a(th);
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
