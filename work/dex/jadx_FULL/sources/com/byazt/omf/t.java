package com.byazt.omf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface t extends IInterface {
    void c() throws RemoteException;

    void c(String str) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 31, 125})
    public static abstract class c extends Binder implements t {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        public static t c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof t)) ? new C0491c(iBinder) : (t) iInterfaceQueryLocalInterface;
        }

        public static t tt() {
            return C0491c.c;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                c();
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            c(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.omf.t$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 31, 1538})
        public static class C0491c implements t {
            public static t c;
            public IBinder tt;

            public C0491c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            @Override // com.byazt.omf.t
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (this.tt.transact(1, parcelObtain, parcelObtain2, 0) || c.tt() == null) {
                        parcelObtain2.readException();
                    } else {
                        c.tt().c();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.t
            public void c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    parcelObtain.writeString(str);
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.tt() != null) {
                        c.tt().c(str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
