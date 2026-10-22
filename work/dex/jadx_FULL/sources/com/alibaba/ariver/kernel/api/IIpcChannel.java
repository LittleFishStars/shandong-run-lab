package com.alibaba.ariver.kernel.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alibaba.ariver.kernel.ipc.IpcMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IIpcChannel extends IInterface {

    public static abstract class Stub extends Binder implements IIpcChannel {
        static final int TRANSACTION_isFinishing = 2;
        static final int TRANSACTION_sendMessage = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f24193a = "com.alibaba.ariver.kernel.api.IIpcChannel";

        public static class Proxy implements IIpcChannel {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f24194a;

            public Proxy(IBinder iBinder) {
                this.f24194a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24194a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f24193a;
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public boolean isFinishing() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f24193a);
                    this.f24194a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.ariver.kernel.api.IIpcChannel
            public void sendMessage(IpcMessage ipcMessage) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.f24193a);
                    if (ipcMessage != null) {
                        parcelObtain.writeInt(1);
                        ipcMessage.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24194a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f24193a);
        }

        public static IIpcChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f24193a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IIpcChannel)) ? new Proxy(iBinder) : (IIpcChannel) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f24193a);
                sendMessage(parcel.readInt() != 0 ? IpcMessage.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f24193a);
                return true;
            }
            parcel.enforceInterface(f24193a);
            boolean zIsFinishing = isFinishing();
            parcel2.writeNoException();
            parcel2.writeInt(zIsFinishing ? 1 : 0);
            return true;
        }
    }

    boolean isFinishing();

    void sendMessage(IpcMessage ipcMessage);
}
