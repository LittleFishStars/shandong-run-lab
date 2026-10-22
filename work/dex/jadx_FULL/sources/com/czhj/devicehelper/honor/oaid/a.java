package com.czhj.devicehelper.honor.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.czhj.devicehelper.honor.oaid.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0614a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f29373a = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        public AbstractBinderC0614a() {
            attachInterface(this, f29373a);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(f29373a);
                int i3 = parcel.readInt();
                long j = parcel.readLong();
                boolean z = parcel.readInt() != 0;
                a(i3, j, z, parcel.readFloat(), parcel.readDouble(), parcel.readString());
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(f29373a);
                    return true;
                }
                parcel.enforceInterface(f29373a);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);
}
