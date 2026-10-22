package com.getui.gtc.dyc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Callback extends IInterface {

    public static abstract class a extends Binder implements Callback {

        /* JADX INFO: renamed from: com.getui.gtc.dyc.Callback$a$a, reason: collision with other inner class name */
        public static class C0653a implements Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static Callback f30330a;
            private IBinder c;

            public C0653a(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void a(Map map, Map map2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    parcelObtain.writeMap(map);
                    parcelObtain.writeMap(map2);
                    if (this.c.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(map, map2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    parcelObtain.writeString(str);
                    if (this.c.transact(2, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().b(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.getui.gtc.dyc.Callback");
        }

        public static Callback a() {
            return C0653a.f30330a;
        }

        public static Callback a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.getui.gtc.dyc.Callback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Callback)) ? new C0653a(iBinder) : (Callback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                ClassLoader classLoader = getClass().getClassLoader();
                a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.getui.gtc.dyc.Callback");
                    return true;
                }
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                b(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(Map map, Map map2) throws RemoteException;

    void b(String str) throws RemoteException;
}
