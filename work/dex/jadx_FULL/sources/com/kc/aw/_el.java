package com.kc.aw;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface _el extends IInterface {

    @Keep
    public static abstract class _a extends Binder implements _el {
        public static final int _a = 0;

        /* JADX INFO: renamed from: com.kc.aw._el$_a$_a, reason: collision with other inner class name */
        @Keep
        public static final class C0942_a implements _el {
            public IBinder _a;

            public C0942_a(IBinder iBinder) {
                this._a = iBinder;
            }

            @Override // com.kc.aw._el
            public final String _a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    parcelObtain.writeString(str);
                    if (!this._a.transact(2, parcelObtain, parcelObtain2, 0)) {
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

    String _a(String str);
}
