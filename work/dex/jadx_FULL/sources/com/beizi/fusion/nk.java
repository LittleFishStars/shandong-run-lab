package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface nk extends IInterface {

    public static abstract class a extends Binder implements nk {

        /* JADX INFO: renamed from: com.beizi.fusion.nk$a$a, reason: collision with other inner class name */
        public static class C0317a implements nk {
            public static nk b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27564a;

            public C0317a(IBinder iBinder) {
                this.f27564a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27564a;
            }

            @Override // com.beizi.fusion.nk
            public String getOaid() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
                    if (!this.f27564a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOaid();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.beizi.fusion.nk
            public boolean isOaidTrackLimited() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
                    if (!this.f27564a.transact(2, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().isOaidTrackLimited();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static nk a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.d.b.f25422a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof nk)) ? new C0317a(iBinder) : (nk) iInterfaceQueryLocalInterface;
        }

        public static nk b() {
            return C0317a.b;
        }
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
