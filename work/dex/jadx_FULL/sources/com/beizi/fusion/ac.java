package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ac extends IInterface {

    public static abstract class a extends Binder implements ac {

        /* JADX INFO: renamed from: com.beizi.fusion.ac$a$a, reason: collision with other inner class name */
        public static class C0295a implements ac {
            public static ac b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27002a;

            public C0295a(IBinder iBinder) {
                this.f27002a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27002a;
            }

            @Override // com.beizi.fusion.ac
            public String getOAID() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.f27002a.transact(3, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.beizi.fusion.ac
            public boolean isSupport() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.f27002a.transact(1, parcelObtain, parcelObtain2, 0) && a.b() != null) {
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

        public static ac a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ac)) ? new C0295a(iBinder) : (ac) iInterfaceQueryLocalInterface;
        }

        public static ac b() {
            return C0295a.b;
        }
    }

    String getOAID();

    boolean isSupport();
}
