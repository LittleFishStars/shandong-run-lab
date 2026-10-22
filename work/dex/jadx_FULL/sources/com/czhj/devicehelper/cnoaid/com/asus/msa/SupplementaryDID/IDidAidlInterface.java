package com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IDidAidlInterface extends IInterface {

    public static class Default implements IDidAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getAAID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        static final int TRANSACTION_getAAID = 5;
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_getUDID = 2;
        static final int TRANSACTION_getVAID = 4;
        static final int TRANSACTION_isSupport = 1;

        public static class Proxy implements IDidAidlInterface {
            public static IDidAidlInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getAAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.asus.msa.SupplementaryDID.IDidAidlInterface";
            }

            @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
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

            @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getUDID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUDID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getVAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
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

            @Override // com.czhj.devicehelper.cnoaid.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupport();
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
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDidAidlInterface)) ? new Proxy(iBinder) : (IDidAidlInterface) iInterfaceQueryLocalInterface;
        }

        public static IDidAidlInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDidAidlInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDidAidlInterface;
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
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean zIsSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupport ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                udid = getUDID();
            } else if (i == 3) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                udid = getOAID();
            } else if (i == 4) {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                udid = getVAID();
            } else {
                if (i != 5) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    return true;
                }
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                udid = getAAID();
            }
            parcel2.writeNoException();
            parcel2.writeString(udid);
            return true;
        }
    }

    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupport() throws RemoteException;
}
