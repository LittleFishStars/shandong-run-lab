package cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IHonorOAIDInterface extends IInterface {
    public static final int TRANSACTION_GET_OAID = 2;
    public static final String OAID_SERVICE_DESCRIPTOR = dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJETfswjdf");
    public static final String OAID_CALLBACK_DESCRIPTOR = dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJEDbmmCbdl");
    public static final String OAID_FLAG = dexc.dexa("pb`je`gmbh");
    public static final String LIMIT_FLAG = dexc.dexa("pb`je`mjnju`tubuf");

    public static class Proxy implements IHonorOAIDInterface {
        public boolean isLimit;
        public IBinder mRemote;
        public String oaid;

        public Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
            build();
        }

        private void build() {
            Parcel parcelObtain;
            Parcel parcelObtain2 = null;
            try {
                Stub stub = new Stub();
                parcelObtain = Parcel.obtain();
                try {
                    parcelObtain2 = Parcel.obtain();
                    parcelObtain.writeInterfaceToken(dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJETfswjdf"));
                    parcelObtain.writeStrongBinder(stub);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    this.oaid = stub.getOaid();
                    this.isLimit = stub.isLimit();
                    parcelObtain2.recycle();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (parcelObtain2 != null) {
                            parcelObtain2.recycle();
                        }
                        if (parcelObtain != null) {
                            parcelObtain.recycle();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                parcelObtain = null;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mRemote;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface
        public String getOaid() {
            return this.oaid;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface
        public boolean isLimit() {
            return this.isLimit;
        }
    }

    public static class Stub extends Binder implements IHonorOAIDInterface {
        public boolean isLimit;
        public String oaid;

        public Stub() {
            attachInterface(this, dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJEDbmmCbdl"));
        }

        public static IHonorOAIDInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJETfswjdf"));
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHonorOAIDInterface)) ? new Proxy(iBinder) : (IHonorOAIDInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface
        public String getOaid() {
            return this.oaid;
        }

        @Override // cj.mobile.wm.adIdUtils.oaid.lib.honor.cloudservice.oaid.IHonorOAIDInterface
        public boolean isLimit() {
            return this.isLimit;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJEDbmmCbdl"));
                return true;
            }
            parcel.enforceInterface(dexc.dexa("dpn/ijipops/dmpvetfswjdf/pbje/JPBJEDbmmCbdl"));
            int i3 = parcel.readInt();
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            if (i3 != 0 || bundle == null) {
                OAIDLog.print(dexc.dexa("PBJEDbmmCbdl!iboemfSftvmu!fssps!sfuDpef>%!") + i);
            } else {
                this.oaid = bundle.getString(dexc.dexa("pb`je`gmbh"));
                this.isLimit = bundle.getBoolean(dexc.dexa("pb`je`mjnju`tubuf"));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    String getOaid();

    boolean isLimit();
}
