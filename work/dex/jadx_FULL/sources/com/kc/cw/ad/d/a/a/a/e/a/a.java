package com.kc.cw.ad.d.a.a.a.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.e.a.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC0991a extends Binder implements a {

        /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a.a.e.a.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0992a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f38778a;
            private IBinder b;

            public C0992a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.kc.cw.ad.d.a.a.a.e.a.a
            public String a(String str, String str2, String str3) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC0991a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = AbstractBinderC0991a.a().a(str, str2, str3);
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
        }

        public static a a() {
            return C0992a.f38778a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0992a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String strA = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
