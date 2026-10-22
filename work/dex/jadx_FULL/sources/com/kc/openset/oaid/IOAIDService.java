package com.kc.openset.oaid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IOAIDService extends IInterface {

    @Keep
    public static class Default implements IOAIDService {
        static {
            OSETSDKProtected.interface11(4474);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.IOAIDService
        public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

        @Override // com.kc.openset.oaid.IOAIDService
        public native void getOAID(IOAIDCallBack iOAIDCallBack);

        @Override // com.kc.openset.oaid.IOAIDService
        public native void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack);
    }

    @Keep
    public static abstract class Stub extends Binder implements IOAIDService {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1835);

        @Keep
        public static class a implements IOAIDService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IOAIDService f39768a;
            private final IBinder b;

            static {
                OSETSDKProtected.interface11(4475);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.IOAIDService
            public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

            @Override // com.kc.openset.oaid.IOAIDService
            public native void getOAID(IOAIDCallBack iOAIDCallBack);

            @Override // com.kc.openset.oaid.IOAIDService
            public native void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack);
        }

        static {
            OSETSDKProtected.interface11(4476);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1835));
        }

        public static native IOAIDService asInterface(IBinder iBinder);

        public static native IOAIDService getDefaultImpl();

        public static native boolean setDefaultImpl(IOAIDService iOAIDService);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    void basicTypes(int i, long j, boolean z, float f, double d, String str);

    void getOAID(IOAIDCallBack iOAIDCallBack);

    void isOAIDTrackingLimited(IOAIDCallBack iOAIDCallBack);
}
