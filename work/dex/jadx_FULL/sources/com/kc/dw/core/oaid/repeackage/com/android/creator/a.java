package com.kc.dw.core.oaid.repeackage.com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.android.creator.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1028a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39296a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.android.creator.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1029a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39297a;

            public C1029a(IBinder iBinder) {
                this.f39297a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.android.creator.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this.f39297a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1028a.f39296a;
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
                return this.f39297a;
            }
        }
    }

    String a() throws RemoteException;
}
