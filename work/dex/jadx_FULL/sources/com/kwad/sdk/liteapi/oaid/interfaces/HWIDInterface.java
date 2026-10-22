package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.alipay.sdk.m.d.b;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface HWIDInterface extends IInterface {

    public static final class a implements HWIDInterface {
        private IBinder aUQ;

        public a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final boolean getBoos() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z = false;
            try {
                parcelObtain.writeInterfaceToken(b.f25422a);
                this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Exception e) {
                LiteApiLogger.printStackTrace(e);
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
            return z;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HWIDInterface
        public final String getIDs() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken(b.f25422a);
                    this.aUQ.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    string = null;
                }
                return string;
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        }
    }

    boolean getBoos();

    String getIDs();
}
