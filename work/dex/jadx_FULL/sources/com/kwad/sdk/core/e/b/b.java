package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface b extends IInterface {

    public static class a extends Binder implements b {
        private IBinder aUQ;

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        public final void a(c cVar) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aUQ.transact(2, parcelObtain, parcelObtain2, 0);
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "gets + " + this.aUQ);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public final void b(c cVar) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aUQ.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
