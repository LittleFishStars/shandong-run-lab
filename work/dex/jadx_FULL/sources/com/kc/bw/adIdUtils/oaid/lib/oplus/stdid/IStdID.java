package com.kc.bw.adIdUtils.oaid.lib.oplus.stdid;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.bw.adIdUtils.oaid.lib.heytap.openid.IOpenID;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IStdID extends IOpenID {

    @Keep
    public static abstract class Stub extends IOpenID.Stub {
        public static final String DESCRIPTOR = dexg.dexa("dpn/pqmvt/tueje/JTueJE");
        public static final int TRANSACTION_getSerID = 1;

        @Keep
        public static class Proxy implements IStdID {
            public static IOpenID sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return dexg.dexa("dpn/pqmvt/tueje/JTueJE");
            }

            @Override // com.kc.bw.adIdUtils.oaid.lib.heytap.openid.IOpenID
            public String getSerID(String str, String str2, String str3) throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(dexg.dexa("dpn/pqmvt/tueje/JTueJE"));
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getSerID(str, str2, str3);
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, dexg.dexa("dpn/pqmvt/tueje/JTueJE"));
        }

        public static IStdID asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IStdID)) ? new Proxy(iBinder) : (IStdID) iInterfaceQueryLocalInterface;
        }

        public static IOpenID getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOpenID iOpenID) {
            if (Proxy.sDefaultImpl != null || iOpenID == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOpenID;
            return true;
        }
    }
}
