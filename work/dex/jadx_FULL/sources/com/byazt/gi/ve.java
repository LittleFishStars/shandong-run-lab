package com.byazt.gi;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byazt.gq.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve extends IInterface {

    @com.byazt.zqa.c(c = {0, 1, 678, 24})
    public static abstract class c extends Binder implements ve {
        public static String c = "";

        /* JADX INFO: renamed from: com.byazt.gi.ve$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 678, 1241})
        public static class C0414c implements ve {
            public IBinder c;

            public C0414c(IBinder iBinder) {
                if (TextUtils.isEmpty(c.c)) {
                    JSONObject jSONObjectI = t.i();
                    String unused = c.c = com.byazt.i.ve.c(jSONObjectI.optString("r"), jSONObjectI.optString("s"));
                }
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.byazt.gi.ve
            public void c(tt ttVar, uj ujVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.c);
                    if (ttVar != null) {
                        parcelObtain.writeInt(1);
                        ttVar.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(ujVar != null ? ujVar.asBinder() : null);
                    this.c.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(c);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(c);
            c(parcel.readInt() != 0 ? tt.CREATOR.createFromParcel(parcel) : null, uj.c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static ve c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ve)) {
                return (ve) iInterfaceQueryLocalInterface;
            }
            return new C0414c(iBinder);
        }
    }

    void c(tt ttVar, uj ujVar) throws RemoteException;
}
