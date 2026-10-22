package cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IDeviceIdService extends IInterface {

    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
        public String getAAID(String str) throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
        public String getVAID(String str) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDeviceIdService {
        public static final String DESCRIPTOR = dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf");
        public static final int TRANSACTION_getAAID = 3;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getVAID = 2;

        public static class Proxy implements IDeviceIdService {
            public static IDeviceIdService sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
            public String getAAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf"));
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
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
                return dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf");
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
            public String getOAID() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf"));
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.samsung.android.deviceidservice.IDeviceIdService
            public String getVAID(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf"));
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVAID(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, dexc.dexa("dpn/tbntvoh/boespje/efwjdfjetfswjdf/JEfwjdfJeTfswjdf"));
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) iInterfaceQueryLocalInterface;
        }

        public static IDeviceIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdService iDeviceIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexc.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
            }
            if (iDeviceIdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDeviceIdService;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i == 1) {
                parcel.enforceInterface(str);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                String vaid = getVAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            String aaid = getAAID(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    String getAAID(String str) throws RemoteException;

    String getOAID() throws RemoteException;

    String getVAID(String str) throws RemoteException;
}
