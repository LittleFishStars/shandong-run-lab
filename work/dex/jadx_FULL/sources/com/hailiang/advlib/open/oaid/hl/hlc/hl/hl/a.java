package com.hailiang.advlib.open.oaid.hl.hlc.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0774a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
        public boolean b() throws RemoteException {
            return false;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
        public String getOaid() throws RemoteException {
            return null;
        }
    }

    @Keep
    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f32585a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        static final int b = 1;
        static final int c = 2;

        /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a$b$a, reason: collision with other inner class name */
        @Keep
        public static class C0775a implements a {
            public static a b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f32586a;

            public C0775a(IBinder iBinder) {
                this.f32586a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32586a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f32586a.transact(2, parcelObtain, parcelObtain2, 0) && b.h() != null) {
                        return b.h().b();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a
            public String getOaid() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (this.f32586a.transact(1, parcelObtain, parcelObtain2, 0) || b.h() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.h().getOaid();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String h() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }
        }

        public b() {
            attachInterface(this, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0775a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0775a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0775a.b = aVar;
            return true;
        }

        public static a h() {
            return C0775a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            }
            parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean zB = b();
            parcel2.writeNoException();
            parcel2.writeInt(zB ? 1 : 0);
            return true;
        }
    }

    boolean b() throws RemoteException;

    String getOaid() throws RemoteException;
}
