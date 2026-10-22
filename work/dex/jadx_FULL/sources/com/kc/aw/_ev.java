package com.kc.aw;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface _ev extends IInterface {

    @Keep
    public static abstract class _a extends Binder implements _ev {
        public static final int _a = 0;

        /* JADX INFO: renamed from: com.kc.aw._ev$_a$_a, reason: collision with other inner class name */
        @Keep
        public static final class C0943_a implements _ev {
            public IBinder _a;

            public C0943_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // com.kc.aw._ev
            public final String _b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.creator.IdsSupplier");
                    if (!this._a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = _a._a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this._a;
            }
        }
    }

    String _b();
}
