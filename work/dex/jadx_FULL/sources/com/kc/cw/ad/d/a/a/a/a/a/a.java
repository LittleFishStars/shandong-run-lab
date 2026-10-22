package com.kc.cw.ad.d.a.a.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.a.a.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC0983a extends Binder implements a {

        /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.a.a.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0984a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f38774a;
            private IBinder b;

            public C0984a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.kc.cw.ad.d.a.a.a.a.a.a
            public String a(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    parcelObtain.writeString(str);
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0983a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0983a.d().a(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.a.a.a
            public boolean a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0983a.d() != null) {
                        return AbstractBinderC0983a.d().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.kc.cw.ad.d.a.a.a.a.a.a
            public String b() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (this.b.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC0983a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0983a.d().b();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.a.a.a
            public String b(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    parcelObtain.writeString(str);
                    if (this.b.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC0983a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0983a.d().b(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.a.a.a
            public String c() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (this.b.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0983a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0983a.d().c();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0984a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a d() {
            return C0984a.f38774a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean zA = a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            }
            parcel.enforceInterface("com.android.creator.IdsSupplier");
            String strB2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB2);
            return true;
        }
    }

    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c() throws RemoteException;
}
