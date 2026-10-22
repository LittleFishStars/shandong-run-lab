package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface SamsungIDInterface extends IInterface {

    public static class a implements SamsungIDInterface {
        private IBinder aUR;

        public a(IBinder iBinder) {
            this.aUR = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUR;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.SamsungIDInterface
        public final String getID() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
                    this.aUR.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
    }

    String getID();
}
