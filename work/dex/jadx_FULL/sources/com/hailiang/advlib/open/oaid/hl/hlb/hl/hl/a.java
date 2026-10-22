package com.hailiang.advlib.open.oaid.hl.hlb.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0772a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    @Keep
    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f32583a = "com.samsung.android.deviceidservice.IDeviceIdService";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;

        /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a$b$a, reason: collision with other inner class name */
        @Keep
        public static class C0773a implements a {
            public static a b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f32584a;

            public C0773a(IBinder iBinder) {
                this.f32584a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
            public String a() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (this.f32584a.transact(1, parcelObtain, parcelObtain2, 0) || b.h() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.h().a();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
            public String a(String str) throws RemoteException {
                return null;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32584a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a
            public String b(String str) throws RemoteException {
                return null;
            }

            public String h() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }
        }

        public b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0773a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0773a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0773a.b = aVar;
            return true;
        }

        public static a h() {
            return C0773a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String strA;
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = a();
            } else if (i == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = b(parcel.readString());
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                    return true;
                }
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                strA = a(parcel.readString());
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
