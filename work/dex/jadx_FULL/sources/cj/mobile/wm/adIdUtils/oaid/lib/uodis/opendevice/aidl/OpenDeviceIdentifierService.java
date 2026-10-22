package cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    public static class Default implements OpenDeviceIdentifierService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public String getOaid() throws RemoteException {
            return null;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public boolean isOaidTrackLimited() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {
        public static final String DESCRIPTOR = dexc.dexa("dpn/vpejt/pqfoefwjdf/bjem/PqfoEfwjdfJefoujgjfsTfswjdf");
        public static final int TRANSACTION_getOaid = 1;
        public static final int TRANSACTION_isOaidTrackLimited = 2;

        public static class Proxy implements OpenDeviceIdentifierService {
            public static OpenDeviceIdentifierService sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return dexc.dexa("dpn/vpejt/pqfoefwjdf/bjem/PqfoEfwjdfJefoujgjfsTfswjdf");
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public String getOaid() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/vpejt/pqfoefwjdf/bjem/PqfoEfwjdfJefoujgjfsTfswjdf"));
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOaid();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // cj.mobile.wm.adIdUtils.oaid.lib.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/vpejt/pqfoefwjdf/bjem/PqfoEfwjdfJefoujgjfsTfswjdf"));
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isOaidTrackLimited();
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
            attachInterface(this, dexc.dexa("dpn/vpejt/pqfoefwjdf/bjem/PqfoEfwjdfJefoujgjfsTfswjdf"));
        }

        public static OpenDeviceIdentifierService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OpenDeviceIdentifierService)) ? new Proxy(iBinder) : (OpenDeviceIdentifierService) iInterfaceQueryLocalInterface;
        }

        public static OpenDeviceIdentifierService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OpenDeviceIdentifierService openDeviceIdentifierService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexc.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
            }
            if (openDeviceIdentifierService == null) {
                return false;
            }
            Proxy.sDefaultImpl = openDeviceIdentifierService;
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
                String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(str);
                return true;
            }
            parcel.enforceInterface(str);
            boolean zIsOaidTrackLimited = isOaidTrackLimited();
            parcel2.writeNoException();
            parcel2.writeInt(zIsOaidTrackLimited ? 1 : 0);
            return true;
        }
    }

    String getOaid() throws RemoteException;

    boolean isOaidTrackLimited() throws RemoteException;
}
