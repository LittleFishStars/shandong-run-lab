package com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IDidAidlInterface extends IInterface {

    @Keep
    public static class Default implements IDidAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getAAID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getUDID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getVAID() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() throws RemoteException {
            return false;
        }
    }

    @Keep
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        public static final String DESCRIPTOR = dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf");
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 1;

        @Keep
        public static class Proxy implements IDidAidlInterface {
            public static IDidAidlInterface sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getAAID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getAAID();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf");
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getOAID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
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

            @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getUDID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
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

            @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getVAID() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getVAID();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
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
            attachInterface(this, dexg.dexa("dpn/btvt/ntb/TvqqmfnfoubszEJE/JEjeBjemJoufsgbdf"));
        }

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDidAidlInterface)) ? new Proxy(iBinder) : (IDidAidlInterface) iInterfaceQueryLocalInterface;
        }

        public static IDidAidlInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexg.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
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
            String str = DESCRIPTOR;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(str);
                boolean zIsSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(zIsSupport ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(str);
                String udid = getUDID();
                parcel2.writeNoException();
                parcel2.writeString(udid);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(str);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(str);
                String vaid = getVAID();
                parcel2.writeNoException();
                parcel2.writeString(vaid);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(str);
            String aaid = getAAID();
            parcel2.writeNoException();
            parcel2.writeString(aaid);
            return true;
        }
    }

    String getAAID() throws RemoteException;

    String getOAID() throws RemoteException;

    String getUDID() throws RemoteException;

    String getVAID() throws RemoteException;

    boolean isSupport() throws RemoteException;
}
