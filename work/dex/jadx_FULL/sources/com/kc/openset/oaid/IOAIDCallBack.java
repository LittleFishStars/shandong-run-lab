package com.kc.openset.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IOAIDCallBack extends IInterface {

    @Keep
    public static class Default implements IOAIDCallBack {
        static {
            OSETSDKProtected.interface11(4470);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void handleResult(int i, Bundle bundle);
    }

    @Keep
    public static abstract class Stub extends Binder implements IOAIDCallBack {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1833);
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_handleResult = 2;

        @Keep
        public static class a implements IOAIDCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IOAIDCallBack f39767a;
            private final IBinder b;

            static {
                OSETSDKProtected.interface11(4471);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.IOAIDCallBack
            public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

            @Override // com.kc.openset.oaid.IOAIDCallBack
            public native void handleResult(int i, Bundle bundle);
        }

        static {
            OSETSDKProtected.interface11(4472);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1833));
        }

        public static native IOAIDCallBack asInterface(IBinder iBinder);

        public static native IOAIDCallBack getDefaultImpl();

        public static native boolean setDefaultImpl(IOAIDCallBack iOAIDCallBack);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    void basicTypes(int i, long j, boolean z, float f, double d, String str);

    void handleResult(int i, Bundle bundle);
}
