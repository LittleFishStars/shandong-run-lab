package com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IDeviceIdManager extends IInterface {

    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isCoolOs = 6;

        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCoolOsVersion();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCoolOs();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceIdManager)) ? new Proxy(iBinder) : (IDeviceIdManager) iInterfaceQueryLocalInterface;
        }

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDeviceIdManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdManager;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String oaid = getOAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i == 6) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zIsCoolOs = isCoolOs();
                parcel2.writeNoException();
                parcel2.writeInt(zIsCoolOs ? 1 : 0);
                return true;
            }
            if (i != 7) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            String coolOsVersion = getCoolOsVersion();
            parcel2.writeNoException();
            parcel2.writeString(coolOsVersion);
            return true;
        }
    }

    String getCoolOsVersion() throws RemoteException;

    String getOAID(String str) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
