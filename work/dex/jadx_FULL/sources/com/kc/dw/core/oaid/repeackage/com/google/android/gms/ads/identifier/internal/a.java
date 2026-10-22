package com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1036a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39304a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1037a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39305a;

            public C1037a(IBinder iBinder) {
                this.f39305a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a
            public boolean a(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.f39305a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1036a.f39304a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39305a;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.google.android.gms.ads.identifier.internal.a
            public String c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f39305a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1036a.f39304a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    boolean a(boolean z) throws RemoteException;

    String c() throws RemoteException;
}
