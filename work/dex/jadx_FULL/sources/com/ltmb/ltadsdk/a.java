package com.ltmb.ltadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ltmb.ltadsdk.core.download.SYDownloadProcessor;
import com.ltmb.ltadsdk.core.download.SYDownloadService;
import com.ltmb.ltadsdk.core.download.SYDownloadTask;
import com.ltmb.ltadsdk.pkg.hb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.ltmb.ltadsdk.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC1318a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f40289a = 0;

        /* JADX INFO: renamed from: com.ltmb.ltadsdk.a$a$a, reason: collision with other inner class name */
        public static class C1319a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f40290a;

            public C1319a(IBinder iBinder) {
                this.f40290a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f40290a;
            }
        }

        public AbstractBinderC1318a() {
            attachInterface(this, "com.ltmb.ltadsdk.ISYDownloadProxy");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.ltmb.ltadsdk.ISYDownloadProxy");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    ((SYDownloadService.a) this).b(parcel.readInt() != 0 ? SYDownloadTask.INSTANCE.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    SYDownloadTask sYDownloadTaskA = parcel.readInt() != 0 ? hb.CREATOR.a(parcel) : null;
                    if (sYDownloadTaskA != null) {
                        SYDownloadProcessor sYDownloadProcessorA = SYDownloadProcessor.l.a();
                        sYDownloadProcessorA.getClass();
                        Intrinsics.checkNotNullParameter(sYDownloadTaskA, "config");
                        sYDownloadProcessorA.f = sYDownloadTaskA;
                    }
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    SYDownloadTask sYDownloadTaskA2 = ((SYDownloadService.a) this).a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (sYDownloadTaskA2 != null) {
                        parcel2.writeInt(1);
                        sYDownloadTaskA2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    SYDownloadTask sYDownloadTaskC = ((SYDownloadService.a) this).c(parcel.readString());
                    parcel2.writeNoException();
                    if (sYDownloadTaskC != null) {
                        parcel2.writeInt(1);
                        sYDownloadTaskC.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    ((SYDownloadService.a) this).b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    ((SYDownloadService.a) this).d(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                    ((SYDownloadService.a) this).a(parcel.readInt() != 0 ? SYDownloadTask.INSTANCE.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
