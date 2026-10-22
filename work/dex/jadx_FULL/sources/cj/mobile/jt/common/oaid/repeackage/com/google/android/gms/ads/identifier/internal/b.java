package cj.mobile.jt.common.oaid.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class b extends Binder implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22354a = 0;

    public b() {
        attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String strI = i();
            parcel2.writeNoException();
            parcel2.writeString(strI);
            return true;
        }
        if (i != 2) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return true;
        }
        parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        boolean zA = a(parcel.readInt() != 0);
        parcel2.writeNoException();
        parcel2.writeInt(zA ? 1 : 0);
        return true;
    }
}
