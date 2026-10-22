package com.kc.openset.oaid.repackage.zui;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IDeviceidInterface extends IInterface {

    @Keep
    public static class Default implements IDeviceidInterface {
        static {
            OSETSDKProtected.interface11(4560);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native String createAAIDForPackageName(String str);

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native String getAAID(String str);

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native String getUDID();

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native String getVAID(String str);

        @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
        public native boolean isSupport();
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceidInterface {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(2003);
        static final int TRANSACTION_createAAIDForPackageName = 6;
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 1;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupport = 3;

        @Keep
        public static class a implements IDeviceidInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IDeviceidInterface f39807a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4561);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native String createAAIDForPackageName(String str);

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native String getAAID(String str);

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native String getUDID();

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native String getVAID(String str);

            @Override // com.kc.openset.oaid.repackage.zui.IDeviceidInterface
            public native boolean isSupport();
        }

        static {
            OSETSDKProtected.interface11(4562);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(2003));
        }

        public static native IDeviceidInterface asInterface(IBinder iBinder);

        public static native IDeviceidInterface getDefaultImpl();

        public static native boolean setDefaultImpl(IDeviceidInterface iDeviceidInterface);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String createAAIDForPackageName(String str);

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);

    boolean isSupport();
}
