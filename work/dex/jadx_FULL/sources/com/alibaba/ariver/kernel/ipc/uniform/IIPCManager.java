package com.alibaba.ariver.kernel.ipc.uniform;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IIPCManager extends IInterface {

    public static abstract class Stub extends Binder implements IIPCManager {
        private static final String DESCRIPTOR = "com.alibaba.ariver.kernel.ipc.uniform.IIPCManager";
        static final int TRANSACTION_call = 1;

        public static class Proxy implements IIPCManager {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f24291a;

            public Proxy(IBinder iBinder) {
                this.f24291a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24291a;
            }

            @Override // com.alibaba.ariver.kernel.ipc.uniform.IIPCManager
            public IPCResult call(IPCParameter iPCParameter) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iPCParameter != null) {
                        parcelObtain.writeInt(1);
                        iPCParameter.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24291a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? IPCResult.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIPCManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IIPCManager)) ? new Proxy(iBinder) : (IIPCManager) iInterfaceQueryLocalInterface;
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
            IPCResult iPCResultCall = call(parcel.readInt() != 0 ? IPCParameter.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (iPCResultCall != null) {
                parcel2.writeInt(1);
                iPCResultCall.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    IPCResult call(IPCParameter iPCParameter);
}
