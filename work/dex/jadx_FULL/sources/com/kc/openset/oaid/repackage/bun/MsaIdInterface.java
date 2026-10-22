package com.kc.openset.oaid.repackage.bun;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface MsaIdInterface extends IInterface {

    @Keep
    public static class Default implements MsaIdInterface {
        static {
            OSETSDKProtected.interface11(4528);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native String getAAID();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native String getVAID();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native boolean isDataArrived();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native boolean isSupported();

        @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
        public native void shutDown();
    }

    @Keep
    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1990);
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isDataArrived = 2;
        static final int TRANSACTION_isSupported = 1;
        static final int TRANSACTION_shutDown = 6;

        @Keep
        public static class a implements MsaIdInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static MsaIdInterface f39799a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4529);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native String getAAID();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native String getVAID();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native boolean isDataArrived();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native boolean isSupported();

            @Override // com.kc.openset.oaid.repackage.bun.MsaIdInterface
            public native void shutDown();
        }

        static {
            OSETSDKProtected.interface11(4530);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1990));
        }

        public static native MsaIdInterface asInterface(IBinder iBinder);

        public static native MsaIdInterface getDefaultImpl();

        public static native boolean setDefaultImpl(MsaIdInterface msaIdInterface);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
