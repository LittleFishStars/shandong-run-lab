package com.hailiang.advlib.open.oaid.hl.hl.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hl.hl.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0768a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public void c() throws RemoteException {
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String d() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public boolean e() throws RemoteException {
            return false;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public String f() throws RemoteException {
            return null;
        }

        @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
        public boolean g() throws RemoteException {
            return false;
        }
    }

    @Keep
    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f32579a = "com.bun.lib.MsaIdInterface";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;
        static final int f = 5;
        static final int g = 6;

        /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hl.hl.a$b$a, reason: collision with other inner class name */
        @Keep
        public static class C0769a implements a {
            public static a b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f32580a;

            public C0769a(IBinder iBinder) {
                this.f32580a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String a() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f32579a);
                    if (this.f32580a.transact(3, parcelObtain, parcelObtain2, 0) || b.h() == null) {
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32580a;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public void c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f32579a);
                    if (this.f32580a.transact(6, parcelObtain, parcelObtain2, 0) || b.h() == null) {
                        parcelObtain2.readException();
                    } else {
                        b.h().c();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String d() throws RemoteException {
                return null;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public boolean e() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f32579a);
                    if (!this.f32580a.transact(1, parcelObtain, parcelObtain2, 0) && b.h() != null) {
                        return b.h().e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public String f() throws RemoteException {
                return null;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hl.hl.a
            public boolean g() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f32579a);
                    if (!this.f32580a.transact(2, parcelObtain, parcelObtain2, 0) && b.h() != null) {
                        return b.h().g();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String h() {
                return b.f32579a;
            }
        }

        public b() {
            attachInterface(this, f32579a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f32579a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0769a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0769a.b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0769a.b = aVar;
            return true;
        }

        public static a h() {
            return C0769a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(f32579a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(f32579a);
                    boolean zE = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(f32579a);
                    boolean zG = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(zG ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(f32579a);
                    String strA = a();
                    parcel2.writeNoException();
                    parcel2.writeString(strA);
                    return true;
                case 4:
                    parcel.enforceInterface(f32579a);
                    String strF = f();
                    parcel2.writeNoException();
                    parcel2.writeString(strF);
                    return true;
                case 5:
                    parcel.enforceInterface(f32579a);
                    String strD = d();
                    parcel2.writeNoException();
                    parcel2.writeString(strD);
                    return true;
                case 6:
                    parcel.enforceInterface(f32579a);
                    c();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a() throws RemoteException;

    void c() throws RemoteException;

    String d() throws RemoteException;

    boolean e() throws RemoteException;

    String f() throws RemoteException;

    boolean g() throws RemoteException;
}
