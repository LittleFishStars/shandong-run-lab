package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface zb extends IInterface {

    public static abstract class a extends Binder implements zb {

        /* JADX INFO: renamed from: com.beizi.fusion.zb$a$a, reason: collision with other inner class name */
        public static class C0340a implements zb {
            public static zb b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f28104a;

            public C0340a(IBinder iBinder) {
                this.f28104a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28104a;
            }

            @Override // com.beizi.fusion.zb
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (!this.f28104a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.beizi.fusion.zb
            public boolean isSupport() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (!this.f28104a.transact(3, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().isSupport();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zb)) ? new C0340a(iBinder) : (zb) iInterfaceQueryLocalInterface;
        }

        public static zb b() {
            return C0340a.b;
        }
    }

    String getOAID();

    boolean isSupport();
}
