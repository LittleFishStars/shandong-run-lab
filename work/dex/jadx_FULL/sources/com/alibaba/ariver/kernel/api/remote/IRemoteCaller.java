package com.alibaba.ariver.kernel.api.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IRemoteCaller extends IInterface {

    public static abstract class Stub extends Binder implements IRemoteCaller {
        private static final String DESCRIPTOR = "com.alibaba.ariver.kernel.api.remote.IRemoteCaller";
        static final int TRANSACTION_remoteCall = 1;

        public static class Proxy implements IRemoteCaller {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f24215a;

            public Proxy(IBinder iBinder) {
                this.f24215a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24215a;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.alibaba.ariver.kernel.api.remote.IRemoteCaller
            public RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteCallArgs != null) {
                        parcelObtain.writeInt(1);
                        remoteCallArgs.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24215a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? RemoteCallResult.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteCaller asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteCaller)) ? new Proxy(iBinder) : (IRemoteCaller) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            RemoteCallResult remoteCallResultRemoteCall = remoteCall(parcel.readInt() != 0 ? RemoteCallArgs.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (remoteCallResultRemoteCall != null) {
                parcel2.writeInt(1);
                remoteCallResultRemoteCall.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs);
}
