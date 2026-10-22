package cj.mobile.jt.common.oaid.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f22353a;

    public a(IBinder iBinder) {
        this.f22353a = iBinder;
    }

    @Override // cj.mobile.jt.common.oaid.repeackage.com.google.android.gms.ads.identifier.internal.c
    public final boolean a(boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcelObtain.writeInt(z ? 1 : 0);
            if (!this.f22353a.transact(2, parcelObtain, parcelObtain2, 0)) {
                int i = b.f22354a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f22353a;
    }

    @Override // cj.mobile.jt.common.oaid.repeackage.com.google.android.gms.ads.identifier.internal.c
    public final String i() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (!this.f22353a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = b.f22354a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
