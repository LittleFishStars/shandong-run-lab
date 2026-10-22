package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ci extends IInterface {

    public static abstract class a extends Binder implements ci {

        /* JADX INFO: renamed from: com.beizi.fusion.ci$a$a, reason: collision with other inner class name */
        public static class C0304a implements ci {
            public static ci b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27143a;

            public C0304a(IBinder iBinder) {
                this.f27143a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27143a;
            }

            @Override // com.beizi.fusion.ci
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27143a.transact(3, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.beizi.fusion.ci
            public boolean isSupported() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f27143a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().isSupported();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static ci a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ci)) ? new C0304a(iBinder) : (ci) iInterfaceQueryLocalInterface;
        }

        public static ci b() {
            return C0304a.b;
        }
    }

    String getOAID();

    boolean isSupported();
}
