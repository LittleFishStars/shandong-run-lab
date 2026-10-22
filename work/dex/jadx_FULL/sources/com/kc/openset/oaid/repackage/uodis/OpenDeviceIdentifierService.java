package com.kc.openset.oaid.repackage.uodis;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OpenDeviceIdentifierService extends IInterface {

    @Keep
    public static class Default implements OpenDeviceIdentifierService {
        static {
            OSETSDKProtected.interface11(4556);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.uodis.OpenDeviceIdentifierService
        public native String getOaid();

        @Override // com.kc.openset.oaid.repackage.uodis.OpenDeviceIdentifierService
        public native boolean isOaidTrackLimited();
    }

    @Keep
    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(2002);
        static final int TRANSACTION_getOaid = 1;
        static final int TRANSACTION_isOaidTrackLimited = 2;

        @Keep
        public static class a implements OpenDeviceIdentifierService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static OpenDeviceIdentifierService f39806a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4557);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.uodis.OpenDeviceIdentifierService
            public native String getOaid();

            @Override // com.kc.openset.oaid.repackage.uodis.OpenDeviceIdentifierService
            public native boolean isOaidTrackLimited();
        }

        static {
            OSETSDKProtected.interface11(4558);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(2002));
        }

        public static native OpenDeviceIdentifierService asInterface(IBinder iBinder);

        public static native OpenDeviceIdentifierService getDefaultImpl();

        public static native boolean setDefaultImpl(OpenDeviceIdentifierService openDeviceIdentifierService);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
