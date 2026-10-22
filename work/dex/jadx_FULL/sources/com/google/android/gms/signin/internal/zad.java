package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import com.zj.adlib.e2c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 3:
                e2c.b(parcel);
                break;
            case 4:
                e2c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                e2c.b(parcel);
                break;
            case 7:
                e2c.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) e2c.a(parcel, zak.CREATOR);
                e2c.b(parcel);
                zab(zakVar);
                break;
            case 9:
                e2c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
