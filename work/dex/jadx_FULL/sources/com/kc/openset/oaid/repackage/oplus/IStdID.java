package com.kc.openset.oaid.repackage.oplus;

import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.repackage.heytap.IOpenID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IStdID extends IOpenID {

    @Keep
    public static abstract class Stub extends IOpenID.Stub {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1994);
        static final int TRANSACTION_getSerID = 1;

        @Keep
        public static class a implements IStdID {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IOpenID f39803a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4544);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.heytap.IOpenID
            public native String getSerID(String str, String str2, String str3);
        }

        static {
            OSETSDKProtected.interface11(4545);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1994));
        }

        public static native IStdID asInterface(IBinder iBinder);

        public static native IOpenID getDefaultImpl();

        public static native boolean setDefaultImpl(IOpenID iOpenID);
    }
}
