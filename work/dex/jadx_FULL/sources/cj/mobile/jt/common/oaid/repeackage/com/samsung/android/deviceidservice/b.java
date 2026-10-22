package cj.mobile.jt.common.oaid.repeackage.com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class b extends Binder implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22358a = 0;

    public b() {
        attachInterface(this, com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            String strC = c();
            parcel2.writeNoException();
            parcel2.writeString(strC);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            parcel.readString();
            String strB = b();
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }
        if (i != 3) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
            return true;
        }
        parcel.enforceInterface(com.alipay.sdk.m.p0.a.AbstractBinderC0200a.f25485a);
        parcel.readString();
        String strA = a();
        parcel2.writeNoException();
        parcel2.writeString(strA);
        return true;
    }
}
