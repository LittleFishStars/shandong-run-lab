package com.kc.openset.oaid.repackage.qiku;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IOAIDInterface extends IInterface {

    @Keep
    public static class Default implements IOAIDInterface {
        static {
            OSETSDKProtected.interface11(4547);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native String getAAID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native String getUDID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native String getVAID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native boolean isSupported();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native boolean limitReadOAID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native void resetOAID();

        @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
        public native void shutDown();
    }

    @Keep
    public static abstract class Stub extends Binder implements IOAIDInterface {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1995);
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupported = 1;
        static final int TRANSACTION_limitReadOAID = 8;
        static final int TRANSACTION_resetOAID = 7;
        static final int TRANSACTION_shutDown = 6;

        @Keep
        public static class a implements IOAIDInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IOAIDInterface f39804a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4548);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native String getAAID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native String getUDID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native String getVAID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native boolean isSupported();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native boolean limitReadOAID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native void resetOAID();

            @Override // com.kc.openset.oaid.repackage.qiku.IOAIDInterface
            public native void shutDown();
        }

        static {
            OSETSDKProtected.interface11(4549);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1995));
        }

        public static native IOAIDInterface asInterface(IBinder iBinder);

        public static native IOAIDInterface getDefaultImpl();

        public static native boolean setDefaultImpl(IOAIDInterface iOAIDInterface);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID();

    String getOAID();

    String getUDID();

    String getVAID();

    boolean isSupported();

    boolean limitReadOAID();

    void resetOAID();

    void shutDown();
}
