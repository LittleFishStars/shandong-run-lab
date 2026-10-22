package com.kc.cw.ad.c.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface c extends IInterface {

    @Keep
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: com.kc.cw.ad.c.h.c$a$a, reason: collision with other inner class name */
        @Keep
        public static class C0979a implements c {
            public static c b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f38750a;

            public C0979a(IBinder iBinder) {
                this.f38750a = iBinder;
            }

            @Override // com.kc.cw.ad.c.h.c
            public String a(String str, String str2, String str3) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.f38750a.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.a().a(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38750a;
            }
        }

        public static c a() {
            return C0979a.b;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0979a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
