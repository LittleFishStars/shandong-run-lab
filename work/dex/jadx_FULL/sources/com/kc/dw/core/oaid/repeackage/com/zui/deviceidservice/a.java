package com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1042a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39310a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1043a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39311a;

            public C1043a(IBinder iBinder) {
                this.f39311a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (!this.f39311a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1042a.f39310a;
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
                return this.f39311a;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.zui.deviceidservice.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.v0.a.AbstractBinderC0208a.f25517a);
                    if (!this.f39311a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1042a.f39310a;
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

    boolean b() throws RemoteException;
}
