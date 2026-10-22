package com.kc.dw.core.oaid.repeackage.com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.bun.lib.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1032a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39300a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.bun.lib.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1033a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39301a;

            public C1033a(IBinder iBinder) {
                this.f39301a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.bun.lib.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f39301a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1032a.f39300a;
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
                return this.f39301a;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.bun.lib.a
            public boolean d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.f39301a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1032a.f39300a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String a() throws RemoteException;

    boolean d() throws RemoteException;
}
