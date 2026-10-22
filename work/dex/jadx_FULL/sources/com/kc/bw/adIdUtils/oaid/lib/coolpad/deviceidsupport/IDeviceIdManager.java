package com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IDeviceIdManager extends IInterface {

    @Keep
    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getIMEI(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getUDID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public String getVAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    @Keep
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        public static final String DESCRIPTOR = dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs");
        public static final int TRANSACTION_getAAID = 4;
        public static final int TRANSACTION_getCoolOsVersion = 7;
        public static final int TRANSACTION_getIMEI = 5;
        public static final int TRANSACTION_getOAID = 2;
        public static final int TRANSACTION_getUDID = 1;
        public static final int TRANSACTION_getVAID = 3;
        public static final int TRANSACTION_isCoolOs = 6;

        @Keep
        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getAAID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
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

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    if (this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getCoolOsVersion();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getIMEI(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getIMEI(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs");
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getOAID(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getUDID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getUDID(str);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public String getVAID(String str) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
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

            @Override // com.kc.bw.adIdUtils.oaid.lib.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
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
            attachInterface(this, dexg.dexa("dpn/dppmqbe/efwjdfjetvqqpsu/JEfwjdfJeNbobhfs"));
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
                throw new IllegalStateException(dexg.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
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
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    String udid = getUDID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(udid);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    String oaid = getOAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(oaid);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    String vaid = getVAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(vaid);
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    String aaid = getAAID(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(aaid);
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    String imei = getIMEI(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    boolean zIsCoolOs = isCoolOs();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsCoolOs ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    String coolOsVersion = getCoolOsVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(coolOsVersion);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getAAID(String str) throws RemoteException;

    String getCoolOsVersion() throws RemoteException;

    String getIMEI(String str) throws RemoteException;

    String getOAID(String str) throws RemoteException;

    String getUDID(String str) throws RemoteException;

    String getVAID(String str) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
