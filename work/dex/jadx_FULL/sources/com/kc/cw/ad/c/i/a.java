package com.kc.cw.ad.c.i;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.cw.ad.c.i.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC0980a extends Binder implements a {

        /* JADX INFO: renamed from: com.kc.cw.ad.c.i.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0981a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f38754a;
            private IBinder b;

            public C0981a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.kc.cw.ad.c.i.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    if (!this.b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0980a.b() != null) {
                        return AbstractBinderC0980a.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.cw.ad.c.i.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0980a.b() != null) {
                        return AbstractBinderC0980a.b().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.kc.cw.ad.c.i.a
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    parcelObtain.writeString(str);
                    if (!this.b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0980a.b() != null) {
                        return AbstractBinderC0980a.b().b(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0981a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a b() {
            return C0981a.f38754a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String strA;
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                strA = a();
            } else if (i == 2) {
                parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                strA = a(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    return true;
                }
                parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                strA = b(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;
}
