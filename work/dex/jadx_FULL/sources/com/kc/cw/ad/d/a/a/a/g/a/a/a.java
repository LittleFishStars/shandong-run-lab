package com.kc.cw.ad.d.a.a.a.g.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alipay.sdk.m.d.b;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.g.a.a.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC0995a extends Binder implements a {

        /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.g.a.a.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0996a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f38780a;
            private IBinder b;

            public C0996a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.kc.cw.ad.d.a.a.a.g.a.a.a
            public String a() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f25422a);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0995a.c() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0995a.c().a();
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

            @Override // com.kc.cw.ad.d.a.a.a.g.a.a.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f25422a);
                    if (!this.b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0995a.c() != null) {
                        return AbstractBinderC0995a.c().b();
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.f25422a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0996a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a c() {
            return C0996a.f38780a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(b.f25422a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(b.f25422a);
                return true;
            }
            parcel.enforceInterface(b.f25422a);
            boolean zB = b();
            parcel2.writeNoException();
            parcel2.writeInt(zB ? 1 : 0);
            return true;
        }
    }

    String a() throws RemoteException;

    boolean b() throws RemoteException;
}
