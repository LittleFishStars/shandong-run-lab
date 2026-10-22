package cj.mobile.wm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ya extends IInterface {

    public static abstract class dexa extends Binder implements ya {

        /* JADX INFO: renamed from: cj.mobile.wm.ya$dexa$dexa, reason: collision with other inner class name */
        public static class C0085dexa implements ya {
            public static ya dexb;
            public IBinder dexa;

            public C0085dexa(IBinder iBinder) {
                this.dexa = iBinder;
            }

            @Override // cj.mobile.wm.ya
            public String a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
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

        public static ya dexa() {
            return C0085dexa.dexb;
        }

        public static ya dexa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ya)) ? new C0085dexa(iBinder) : (ya) iInterfaceQueryLocalInterface;
        }
    }

    String a();
}
