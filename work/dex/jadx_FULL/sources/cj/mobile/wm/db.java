package cj.mobile.wm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface db extends IInterface {

    public static abstract class dexa extends Binder implements db {

        /* JADX INFO: renamed from: cj.mobile.wm.db$dexa$dexa, reason: collision with other inner class name */
        public static class C0081dexa implements db {
            public static db dexb;
            public IBinder dexa;

            public C0081dexa(IBinder iBinder) {
                this.dexa = iBinder;
            }

            @Override // cj.mobile.wm.db
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.insightvision.openadsdk.openid.brand.zui.deviceidservice.IDeviceidInterface");
                    if (!this.dexa.transact(1, parcelObtain, parcelObtain2, 0) && dexa.dexa() != null) {
                        return dexa.dexa().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.dexa;
            }
        }

        public static db dexa() {
            return C0081dexa.dexb;
        }

        public static db dexa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.insightvision.openadsdk.openid.brand.zui.deviceidservice.IDeviceidInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof db)) ? new C0081dexa(iBinder) : (db) iInterfaceQueryLocalInterface;
        }
    }

    String a();
}
