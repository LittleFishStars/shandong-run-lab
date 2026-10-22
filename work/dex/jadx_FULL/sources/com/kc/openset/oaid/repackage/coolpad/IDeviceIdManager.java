package com.kc.openset.oaid.repackage.coolpad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IDeviceIdManager extends IInterface {

    @Keep
    public static class Default implements IDeviceIdManager {
        static {
            OSETSDKProtected.interface11(4532);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getAAID(String str);

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getCoolOsVersion();

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getIMEI(String str);

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getOAID(String str);

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getUDID(String str);

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native String getVAID(String str);

        @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
        public native boolean isCoolOs();
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1991);
        static final int TRANSACTION_getAAID = 4;
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getIMEI = 5;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_getUDID = 1;
        static final int TRANSACTION_getVAID = 3;
        static final int TRANSACTION_isCoolOs = 6;

        @Keep
        public static class a implements IDeviceIdManager {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IDeviceIdManager f39800a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4533);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getAAID(String str);

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getCoolOsVersion();

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getIMEI(String str);

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getOAID(String str);

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getUDID(String str);

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native String getVAID(String str);

            @Override // com.kc.openset.oaid.repackage.coolpad.IDeviceIdManager
            public native boolean isCoolOs();
        }

        static {
            OSETSDKProtected.interface11(4534);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1991));
        }

        public static native IDeviceIdManager asInterface(IBinder iBinder);

        public static native IDeviceIdManager getDefaultImpl();

        public static native boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID(String str);

    String getCoolOsVersion();

    String getIMEI(String str);

    String getOAID(String str);

    String getUDID(String str);

    String getVAID(String str);

    boolean isCoolOs();
}
