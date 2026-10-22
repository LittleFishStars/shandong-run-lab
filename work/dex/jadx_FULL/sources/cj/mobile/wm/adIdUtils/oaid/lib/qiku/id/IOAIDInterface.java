package cj.mobile.wm.adIdUtils.oaid.lib.qiku.id;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IOAIDInterface extends IInterface {

    public static class Default implements IOAIDInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public String getAAID() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public boolean isSupported() throws RemoteException {
            return false;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public boolean limitReadOAID() throws RemoteException {
            return false;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public void resetOAID() throws RemoteException {
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
        public void shutDown() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOAIDInterface {
        public static final String DESCRIPTOR = dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf");
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupported = 1;
        public static final int TRANSACTION_limitReadOAID = 8;
        public static final int TRANSACTION_resetOAID = 7;
        public static final int TRANSACTION_shutDown = 6;

        public static class Proxy implements IOAIDInterface {
            public static IOAIDInterface sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public String getAAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
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
                return dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf");
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
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

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public String getUDID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
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

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public String getVAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
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

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public boolean isSupported() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
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

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public boolean limitReadOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().limitReadOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public void resetOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().resetOAID();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.qiku.id.IOAIDInterface
            public void shutDown() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().shutDown();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, dexc.dexa("dpn/rjlv/je/JPBJEJoufsgbdf"));
        }

        public static IOAIDInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOAIDInterface)) ? new Proxy(iBinder) : (IOAIDInterface) iInterfaceQueryLocalInterface;
        }

        public static IOAIDInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOAIDInterface iOAIDInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexc.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
            }
            if (iOAIDInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOAIDInterface;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    boolean zIsSupported = isSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupported ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String vaid = getVAID();
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String aaid = getAAID();
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    shutDown();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    resetOAID();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(str);
                    boolean zLimitReadOAID = limitReadOAID();
                    parcel2.writeNoException();
                    parcel2.writeInt(zLimitReadOAID ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupported() throws RemoteException;

    boolean limitReadOAID() throws RemoteException;

    void resetOAID() throws RemoteException;

    void shutDown() throws RemoteException;
}
