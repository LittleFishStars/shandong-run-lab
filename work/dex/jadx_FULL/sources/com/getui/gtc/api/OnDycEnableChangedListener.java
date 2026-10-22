package com.getui.gtc.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface OnDycEnableChangedListener extends IInterface {

    public static class Default implements OnDycEnableChangedListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.getui.gtc.api.OnDycEnableChangedListener
        public void onDycEnableChanged(Map map) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements OnDycEnableChangedListener {
        private static final String DESCRIPTOR = "com.getui.gtc.api.OnDycEnableChangedListener";
        static final int TRANSACTION_onDycEnableChanged = 1;

        public static class Proxy implements OnDycEnableChangedListener {
            public static OnDycEnableChangedListener sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.getui.gtc.api.OnDycEnableChangedListener
            public void onDycEnableChanged(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDycEnableChanged(map);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OnDycEnableChangedListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OnDycEnableChangedListener)) ? new Proxy(iBinder) : (OnDycEnableChangedListener) iInterfaceQueryLocalInterface;
        }

        public static OnDycEnableChangedListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OnDycEnableChangedListener onDycEnableChangedListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (onDycEnableChangedListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = onDycEnableChangedListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onDycEnableChanged(parcel.readHashMap(getClass().getClassLoader()));
            parcel2.writeNoException();
            return true;
        }
    }

    void onDycEnableChanged(Map map) throws RemoteException;
}
