package com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1034a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39302a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1035a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39303a;

            public C1035a(IBinder iBinder) {
                this.f39303a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.coolpad.deviceidsupport.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this.f39303a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1034a.f39302a;
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
                return this.f39303a;
            }
        }
    }

    String a(String str) throws RemoteException;
}
