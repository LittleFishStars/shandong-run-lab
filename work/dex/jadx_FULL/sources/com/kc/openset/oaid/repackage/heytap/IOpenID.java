package com.kc.openset.oaid.repackage.heytap;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IOpenID extends IInterface {

    @Keep
    public static class Default implements IOpenID {
        static {
            OSETSDKProtected.interface11(4540);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.heytap.IOpenID
        public native String getSerID(String str, String str2, String str3);
    }

    @Keep
    public static abstract class Stub extends Binder implements IOpenID {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1993);
        static final int TRANSACTION_getSerID = 1;

        @Keep
        public static class a implements IOpenID {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IOpenID f39802a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4541);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.heytap.IOpenID
            public native String getSerID(String str, String str2, String str3);
        }

        static {
            OSETSDKProtected.interface11(4542);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1993));
        }

        public static native IOpenID asInterface(IBinder iBinder);

        public static native IOpenID getDefaultImpl();

        public static native boolean setDefaultImpl(IOpenID iOpenID);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getSerID(String str, String str2, String str3);
}
