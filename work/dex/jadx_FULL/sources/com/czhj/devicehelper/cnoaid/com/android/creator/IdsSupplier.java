package com.czhj.devicehelper.cnoaid.com.android.creator;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IdsSupplier extends IInterface {

    public static class Default implements IdsSupplier {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
        public String getUDID(String str) throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
        public boolean isSupported() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IdsSupplier {
        private static final String DESCRIPTOR = "com.android.creator.IdsSupplier";
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupported = 1;

        public static class Proxy implements IdsSupplier {
            public static IdsSupplier sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
            public String getAAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAAID(str);
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

            @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
            public String getUDID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUDID(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
            public String getVAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.cnoaid.com.android.creator.IdsSupplier
            public boolean isSupported() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupported();
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

        public static IdsSupplier asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IdsSupplier)) ? new Proxy(iBinder) : (IdsSupplier) iInterfaceQueryLocalInterface;
        }

        public static IdsSupplier getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IdsSupplier idsSupplier) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (idsSupplier == null) {
                return false;
            }
            Proxy.sDefaultImpl = idsSupplier;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String udid;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean zIsSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupported ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                udid = getUDID(parcel.readString());
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                udid = getOAID();
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                udid = getVAID();
            } else {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                udid = getAAID(parcel.readString());
            }
            parcel2.writeNoException();
            parcel2.writeString(udid);
            return true;
        }
    }

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID(String str) throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupported() throws RemoteException;
}
