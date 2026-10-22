package com.beizi.fusion;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xg implements zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f28030a;

    public xg(IBinder iBinder) {
        this.f28030a = iBinder;
    }

    @Override // com.beizi.fusion.zg
    public String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
            this.f28030a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } catch (Exception e) {
            om.a(e);
            return null;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
