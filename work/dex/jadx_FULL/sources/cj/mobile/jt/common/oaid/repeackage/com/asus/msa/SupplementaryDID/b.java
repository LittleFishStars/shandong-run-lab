package cj.mobile.jt.common.oaid.repeackage.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class b extends Binder implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22348a = 0;

    public b() {
        attachInterface(this, IDidAidlInterface.Stub.DESCRIPTOR);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString(IDidAidlInterface.Stub.DESCRIPTOR);
            return true;
        }
        if (i == 1) {
            parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            boolean zF = f();
            parcel2.writeNoException();
            parcel2.writeInt(zF ? 1 : 0);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            String strD = d();
            parcel2.writeNoException();
            parcel2.writeString(strD);
            return true;
        }
        if (i == 3) {
            parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            String strC = c();
            parcel2.writeNoException();
            parcel2.writeString(strC);
            return true;
        }
        if (i == 4) {
            parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            String strB = b();
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }
        if (i != 5) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
        String strA = a();
        parcel2.writeNoException();
        parcel2.writeString(strA);
        return true;
    }
}
