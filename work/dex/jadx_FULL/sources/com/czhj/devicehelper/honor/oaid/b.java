package com.czhj.devicehelper.honor.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f29374a = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* JADX INFO: renamed from: com.czhj.devicehelper.honor.oaid.b$a$a, reason: collision with other inner class name */
        public static class C0615a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f29375a;

            public C0615a(IBinder iBinder) {
                this.f29375a = iBinder;
            }

            @Override // com.czhj.devicehelper.honor.oaid.b
            public void a(com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a abstractBinderC0614a) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain2.writeInterfaceToken(a.f29374a);
                        if (abstractBinderC0614a == null) {
                            abstractBinderC0614a = null;
                        }
                        parcelObtain2.writeStrongBinder(abstractBinderC0614a);
                        this.f29375a.transact(2, parcelObtain2, parcelObtain, 0);
                        parcelObtain.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain2;
                        parcelObtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29375a;
            }

            @Override // com.czhj.devicehelper.honor.oaid.b
            public void b(com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a abstractBinderC0614a) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcel = null;
                try {
                    Parcel parcelObtain2 = Parcel.obtain();
                    try {
                        parcelObtain2.writeInterfaceToken(a.f29374a);
                        if (abstractBinderC0614a == null) {
                            abstractBinderC0614a = null;
                        }
                        parcelObtain2.writeStrongBinder(abstractBinderC0614a);
                        this.f29375a.transact(3, parcelObtain2, parcelObtain, 0);
                        parcelObtain.readException();
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcel = parcelObtain2;
                        parcelObtain.recycle();
                        parcel.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    void a(com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a abstractBinderC0614a) throws RemoteException;

    void b(com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a abstractBinderC0614a) throws RemoteException;
}
