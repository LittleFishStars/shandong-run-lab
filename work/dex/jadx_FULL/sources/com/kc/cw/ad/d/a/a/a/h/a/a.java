package com.kc.cw.ad.d.a.a.a.h.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.h.a.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC0997a extends Binder implements a {

        /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.h.a.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0998a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f38781a;
            private IBinder b;

            public C0998a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public String a() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0997a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0997a.d().a();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public String a(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    parcelObtain.writeString(str);
                    if (this.b.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC0997a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0997a.d().a(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public String b() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (this.b.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC0997a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0997a.d().b();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public String b(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    parcelObtain.writeString(str);
                    if (this.b.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC0997a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0997a.d().b(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public String c(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    parcelObtain.writeString(str);
                    if (this.b.transact(6, parcelObtain, parcelObtain2, 0) || AbstractBinderC0997a.d() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0997a.d().c(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.d.a.a.a.h.a.a
            public boolean c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0997a.d() != null) {
                        return AbstractBinderC0997a.d().c();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0998a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a d() {
            return C0998a.f38781a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 2:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    String strB = b();
                    parcel2.writeNoException();
                    parcel2.writeString(strB);
                    return true;
                case 3:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    boolean zC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    String strA2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strA2);
                    return true;
                case 5:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    String strB2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strB2);
                    return true;
                case 6:
                    parcel.enforceInterface(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    String strC = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strC);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    boolean c() throws RemoteException;
}
