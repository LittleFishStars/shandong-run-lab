package com.kc.openset.oaid.repackage.android;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface IdsSupplier extends IInterface {

    @Keep
    public static class Default implements IdsSupplier {
        static {
            OSETSDKProtected.interface11(4520);
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
        public native String getAAID(String str);

        @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
        public native String getOAID();

        @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
        public native String getUDID(String str);

        @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
        public native String getVAID();

        @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
        public native boolean isSupported();
    }

    @Keep
    public static abstract class Stub extends Binder implements IdsSupplier {
        private static final String DESCRIPTOR = OSETSDKProtected.getString2(1988);
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupported = 1;

        @Keep
        public static class a implements IdsSupplier {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static IdsSupplier f39797a;
            private IBinder b;

            static {
                OSETSDKProtected.interface11(4521);
            }

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
            public native String getAAID(String str);

            @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
            public native String getOAID();

            @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
            public native String getUDID(String str);

            @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
            public native String getVAID();

            @Override // com.kc.openset.oaid.repackage.android.IdsSupplier
            public native boolean isSupported();
        }

        static {
            OSETSDKProtected.interface11(4522);
        }

        public Stub() {
            attachInterface(this, OSETSDKProtected.getString2(1988));
        }

        public static native IdsSupplier asInterface(IBinder iBinder);

        public static native IdsSupplier getDefaultImpl();

        public static native boolean setDefaultImpl(IdsSupplier idsSupplier);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID(String str);

    String getOAID();

    String getUDID(String str);

    String getVAID();

    boolean isSupported();
}
