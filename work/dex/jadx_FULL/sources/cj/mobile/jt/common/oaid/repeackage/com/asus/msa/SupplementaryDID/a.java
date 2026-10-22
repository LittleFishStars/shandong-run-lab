package cj.mobile.jt.common.oaid.repeackage.com.asus.msa.SupplementaryDID;

import android.os.IBinder;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f22347a;

    public a(IBinder iBinder) {
        this.f22347a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f22347a;
    }

    @Override // cj.mobile.jt.common.oaid.repeackage.com.asus.msa.SupplementaryDID.c
    public final String c() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            if (!this.f22347a.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i = b.f22348a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // cj.mobile.jt.common.oaid.repeackage.com.asus.msa.SupplementaryDID.c
    public final boolean f() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            if (!this.f22347a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = b.f22348a;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
