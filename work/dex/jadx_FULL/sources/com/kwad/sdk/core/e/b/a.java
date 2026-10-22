package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kwad.sdk.core.e.b.a$a, reason: collision with other inner class name */
    public static final class C1284a implements a {
        private final IBinder aUQ;

        public C1284a(IBinder iBinder) {
            this.aUQ = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aUQ;
        }

        public final String getID() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
                this.aUQ.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } catch (Exception unused) {
                return null;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
