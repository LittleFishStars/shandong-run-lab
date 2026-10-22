package com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IDeviceidInterface extends IInterface {

    @Keep
    public static class Default implements IDeviceidInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public String createAAIDForPackageName(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public String getVAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceidInterface {
        public static final String DESCRIPTOR = dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf");
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 3;

        @Keep
        public static class Proxy implements IDeviceidInterface {
            public static IDeviceidInterface sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public String createAAIDForPackageName(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().createAAIDForPackageName(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public String getAAID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getAAID(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf");
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public String getOAID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getOAID();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public String getUDID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getUDID();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public String getVAID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getVAID(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.zui.deviceidservice.IDeviceidInterface
            public boolean isSupport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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
            attachInterface(this, dexg.dexa("dpn/{vj/efwjdfjetfswjdf/JEfwjdfjeJoufsgbdf"));
        }

        public static IDeviceidInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) iInterfaceQueryLocalInterface;
        }

        public static IDeviceidInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceidInterface iDeviceidInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexg.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
            }
            if (iDeviceidInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceidInterface;
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
                    String oaid = getOAID();
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    String udid = getUDID();
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    boolean zIsSupport = isSupport();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupport ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    String strCreateAAIDForPackageName = createAAIDForPackageName(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strCreateAAIDForPackageName);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String createAAIDForPackageName(String str) throws RemoteException;

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean isSupport() throws RemoteException;
}
