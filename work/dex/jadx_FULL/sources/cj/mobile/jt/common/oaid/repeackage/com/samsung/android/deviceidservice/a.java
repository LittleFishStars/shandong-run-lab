package cj.mobile.jt.common.oaid.repeackage.com.samsung.android.deviceidservice;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f22357a;

    public a(IBinder iBinder) {
        this.f22357a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f22357a;
    }

    @Override // cj.mobile.jt.common.oaid.repeackage.com.samsung.android.deviceidservice.c
    public final String c() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            if (!this.f22357a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = b.f22358a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
