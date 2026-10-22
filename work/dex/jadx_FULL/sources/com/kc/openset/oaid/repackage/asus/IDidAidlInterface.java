package com.kc.openset.oaid.repackage.asus;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IDidAidlInterface extends IInterface {

    @Keep
    public static class Default implements IDidAidlInterface {
        static {
            OSETSDKProtected.interface11(4524);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
        public native String getAAID();

        @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
        public native String getUDID();

        @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
        public native String getVAID();

        @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
        public native boolean isSupport();
    }

    @Keep
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1989);
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupport = 1;

        @Keep
        public static class a implements IDidAidlInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IDidAidlInterface f39798a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4525);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
            public native String getAAID();

            @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
            public native String getUDID();

            @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
            public native String getVAID();

            @Override // com.kc.openset.oaid.repackage.asus.IDidAidlInterface
            public native boolean isSupport();
        }

        static {
            OSETSDKProtected.interface11(4526);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1989));
        }

        public static native IDidAidlInterface asInterface(IBinder iBinder);

        public static native IDidAidlInterface getDefaultImpl();

        public static native boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID();

    String getOAID();

    String getUDID();

    String getVAID();

    boolean isSupport();
}
