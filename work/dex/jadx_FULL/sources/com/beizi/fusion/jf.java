package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface jf extends IInterface {

    public static abstract class a extends Binder implements jf {

        /* JADX INFO: renamed from: com.beizi.fusion.jf$a$a, reason: collision with other inner class name */
        public static class C0311a implements jf {
            public static jf b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27431a;

            public C0311a(IBinder iBinder) {
                this.f27431a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27431a;
            }

            @Override // com.beizi.fusion.jf
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f27431a.transact(3, parcelObtain, parcelObtain2, 0) && a.b() != null) {
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

        public static jf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof jf)) ? new C0311a(iBinder) : (jf) iInterfaceQueryLocalInterface;
        }

        public static jf b() {
            return C0311a.b;
        }
    }

    String getOAID();
}
