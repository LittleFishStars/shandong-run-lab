package com.kc.openset.oaid.repackage.google;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IAdvertisingIdService extends IInterface {

    @Keep
    public static class Default implements IAdvertisingIdService {
        static {
            OSETSDKProtected.interface11(4536);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.google.IAdvertisingIdService
        public native String getId();

        @Override // com.kc.openset.oaid.repackage.google.IAdvertisingIdService
        public native boolean isLimitAdTrackingEnabled(boolean z);
    }

    @Keep
    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1992);
        static final int TRANSACTION_getId = 1;
        static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        @Keep
        public static class a implements IAdvertisingIdService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IAdvertisingIdService f39801a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4537);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.google.IAdvertisingIdService
            public native String getId();

            @Override // com.kc.openset.oaid.repackage.google.IAdvertisingIdService
            public native boolean isLimitAdTrackingEnabled(boolean z);
        }

        static {
            OSETSDKProtected.interface11(4538);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1992));
        }

        public static native IAdvertisingIdService asInterface(IBinder iBinder);

        public static native IAdvertisingIdService getDefaultImpl();

        public static native boolean setDefaultImpl(IAdvertisingIdService iAdvertisingIdService);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getId();

    boolean isLimitAdTrackingEnabled(boolean z);
}
