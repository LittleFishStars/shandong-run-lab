package com.kc.openset.oaid.repackage.samsung;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IDeviceIdService extends IInterface {

    @Keep
    public static class Default implements IDeviceIdService {
        static {
            OSETSDKProtected.interface11(4552);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
        public native String getAAID(String str);

        @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
        public native String getVAID(String str);
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceIdService {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(2001);
        static final int TRANSACTION_getAAID = 3;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getVAID = 2;

        @Keep
        public static class a implements IDeviceIdService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IDeviceIdService f39805a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4553);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
            public native String getAAID(String str);

            @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.samsung.IDeviceIdService
            public native String getVAID(String str);
        }

        static {
            OSETSDKProtected.interface11(4554);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(2001));
        }

        public static native IDeviceIdService asInterface(IBinder iBinder);

        public static native IDeviceIdService getDefaultImpl();

        public static native boolean setDefaultImpl(IDeviceIdService iDeviceIdService);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID(String str);

    String getOAID();

    String getVAID(String str);
}
