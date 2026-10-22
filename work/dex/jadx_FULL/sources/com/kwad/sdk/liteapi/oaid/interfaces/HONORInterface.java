package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface HONORInterface extends IInterface {

    public static class a extends Binder implements HONORInterface {
        private IBinder aUQ;

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getBoos(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aUQ.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    LiteApiLogger.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORInterface
        public final void getIDs(HONORProxyInterface hONORProxyInterface) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                parcelObtain.writeStrongBinder(hONORProxyInterface != null ? (HONORProxyInterface.a) hONORProxyInterface : null);
                this.aUQ.transact(2, parcelObtain, parcelObtain2, 0);
                LiteApiLogger.d("HONORDeviceIDHelper", "gets + " + this.aUQ);
                parcelObtain2.readException();
            } catch (Throwable th) {
                try {
                    LiteApiLogger.d("HONORDeviceIDHelper", th);
                } finally {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                }
            }
        }
    }

    void getBoos(HONORProxyInterface hONORProxyInterface);

    void getIDs(HONORProxyInterface hONORProxyInterface);
}
