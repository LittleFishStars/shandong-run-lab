package com.byazt.fp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve extends IInterface {
    String c() throws RemoteException;

    String c(String str) throws RemoteException;

    String tt() throws RemoteException;

    String tt(String str) throws RemoteException;

    boolean ve() throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 218, 24})
    public static abstract class c extends Binder implements ve {
        public static ve c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ve)) ? new C0408c(iBinder) : (ve) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                String strTt = tt();
                parcel2.writeNoException();
                parcel2.writeString(strTt);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                boolean zVe = ve();
                parcel2.writeNoException();
                parcel2.writeInt(zVe ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                String strC2 = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strC2);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                return true;
            }
            parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
            String strTt2 = tt(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strTt2);
            return true;
        }

        /* JADX INFO: renamed from: com.byazt.fp.ve$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 218, 1241})
        public static class C0408c implements ve {
            public IBinder c;

            public C0408c(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.byazt.fp.ve
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.ve
            public String tt() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    this.c.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.ve
            public boolean ve() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    this.c.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.ve
            public String c(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    parcelObtain.writeString(str);
                    this.c.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.fp.ve
            public String tt(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    parcelObtain.writeString(str);
                    this.c.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
