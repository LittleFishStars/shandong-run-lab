package com.kc.dw.core.oaid.repeackage.com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.heytap.openid.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1038a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39306a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.heytap.openid.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1039a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39307a;

            public C1039a(IBinder iBinder) {
                this.f39307a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.heytap.openid.a
            public String a(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.f39307a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1038a.f39306a;
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
                return this.f39307a;
            }
        }
    }

    String a(String str, String str2, String str3) throws RemoteException;
}
