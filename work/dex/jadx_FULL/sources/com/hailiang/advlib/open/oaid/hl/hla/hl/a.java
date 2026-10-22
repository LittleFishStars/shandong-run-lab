package com.hailiang.advlib.open.oaid.hl.hla.hl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hla.hl.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0770a implements a {
        @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.a
        public String a(String str, String str2, String str3) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    @Keep
    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f32581a = "com.heytap.openid.IOpenID";
        static final int b = 1;

        /* JADX INFO: renamed from: com.hailiang.advlib.open.oaid.hl.hla.hl.a$b$a, reason: collision with other inner class name */
        @Keep
        public static class C0771a implements a {
            public static a b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f32582a;

            public C0771a(IBinder iBinder) {
                this.f32582a = iBinder;
            }

            @Override // com.hailiang.advlib.open.oaid.hl.hla.hl.a
            public String a(String str, String str2, String str3) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f32581a);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.f32582a.transact(1, parcelObtain, parcelObtain2, 0) || b.h() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = b.h().a(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32582a;
            }

            public String h() {
                return b.f32581a;
            }
        }

        public b() {
            attachInterface(this, f32581a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f32581a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0771a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0771a.b != null || aVar == null) {
                return false;
            }
            C0771a.b = aVar;
            return true;
        }

        public static a h() {
            return C0771a.b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f32581a);
                return true;
            }
            parcel.enforceInterface(f32581a);
            String strA = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
