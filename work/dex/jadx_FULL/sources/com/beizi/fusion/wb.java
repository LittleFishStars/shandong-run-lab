package com.beizi.fusion;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface wb extends IInterface {

    public static abstract class a extends Binder implements wb {

        /* JADX INFO: renamed from: com.beizi.fusion.wb$a$a, reason: collision with other inner class name */
        public static class C0327a implements wb {
            public static wb b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f27906a;

            public C0327a(IBinder iBinder) {
                this.f27906a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27906a;
            }

            @Override // com.beizi.fusion.wb
            public String getOAID(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f27906a.transact(2, parcelObtain, parcelObtain2, 0) && a.b() != null) {
                        return a.b().getOAID(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static wb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof wb)) ? new C0327a(iBinder) : (wb) iInterfaceQueryLocalInterface;
        }

        public static wb b() {
            return C0327a.b;
        }
    }

    String getOAID(String str);
}
