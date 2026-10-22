package com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1040a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39308a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1041a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39309a;

            public C1041a(IBinder iBinder) {
                this.f39309a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.samsung.android.deviceidservice.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    if (!this.f39309a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1040a.f39308a;
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
                return this.f39309a;
            }
        }
    }

    String a() throws RemoteException;
}
