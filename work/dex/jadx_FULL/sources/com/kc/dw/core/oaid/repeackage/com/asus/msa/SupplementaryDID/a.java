package com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a$a, reason: collision with other inner class name */
    @Keep
    public static abstract class AbstractBinderC1030a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f39298a = 0;

        /* JADX INFO: renamed from: com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a$a$a, reason: collision with other inner class name */
        @Keep
        public static class C1031a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f39299a;

            public C1031a(IBinder iBinder) {
                this.f39299a = iBinder;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.f39299a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1030a.f39298a;
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
                return this.f39299a;
            }

            @Override // com.kc.dw.core.oaid.repeackage.com.asus.msa.SupplementaryDID.a
            public boolean b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                    if (!this.f39299a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = AbstractBinderC1030a.f39298a;
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
