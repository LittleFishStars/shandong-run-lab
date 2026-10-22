package com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IAdvertisingIdService extends IInterface {

    @Keep
    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() throws RemoteException {
            return null;
        }

        @Override // com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            return false;
        }
    }

    @Keep
    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        public static final String DESCRIPTOR = dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/joufsobm/JBewfsujtjohJeTfswjdf");
        public static final int TRANSACTION_getId = 1;
        public static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        @Keep
        public static class Proxy implements IAdvertisingIdService {
            public static IAdvertisingIdService sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/joufsobm/JBewfsujtjohJeTfswjdf"));
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getId();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/joufsobm/JBewfsujtjohJeTfswjdf");
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/joufsobm/JBewfsujtjohJeTfswjdf"));
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLimitAdTrackingEnabled(z);
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
            attachInterface(this, dexg.dexa("dpn/hpphmf/boespje/hnt/bet/jefoujgjfs/joufsobm/JBewfsujtjohJeTfswjdf"));
        }

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAdvertisingIdService)) ? new Proxy(iBinder) : (IAdvertisingIdService) iInterfaceQueryLocalInterface;
        }

        public static IAdvertisingIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdvertisingIdService iAdvertisingIdService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException(dexg.dexa("tfuEfgbvmuJnqm)*!dbmmfe!uxjdf"));
            }
            if (iAdvertisingIdService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAdvertisingIdService;
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
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
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
            boolean zIsLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zIsLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException;
}
