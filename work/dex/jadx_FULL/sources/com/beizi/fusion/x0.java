package com.beizi.fusion;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class x0 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder f28002a;

    public x0(IBinder iBinder) {
        this.f28002a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f28002a;
    }

    public String b() {
        String string;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IDidAidlInterface.Stub.DESCRIPTOR);
            this.f28002a.transact(3, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            string = parcelObtain2.readString();
        } catch (Throwable th) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            th.printStackTrace();
            string = null;
        }
        parcelObtain.recycle();
        parcelObtain2.recycle();
        return string;
    }
}
