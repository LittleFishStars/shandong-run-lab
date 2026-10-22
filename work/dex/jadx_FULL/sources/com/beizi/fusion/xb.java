package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface xb extends IInterface {

    public static abstract class a extends Binder implements xb {

        /* JADX INFO: renamed from: com.beizi.fusion.xb$a$a, reason: collision with other inner class name */
        public static class C0334a implements xb {
            public static xb b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f28029a;

            public C0334a(IBinder iBinder) {
                this.f28029a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28029a;
            }

            @Override // com.beizi.fusion.xb
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    if (!this.f28029a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static xb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof xb)) ? new C0334a(iBinder) : (xb) iInterfaceQueryLocalInterface;
        }

        public static xb b() {
            return C0334a.b;
        }
    }

    String getOAID();
}
