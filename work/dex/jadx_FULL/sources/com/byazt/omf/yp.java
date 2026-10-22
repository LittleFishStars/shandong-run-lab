package com.byazt.omf;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface yp extends IInterface {
    void c(String str, int i) throws RemoteException;

    void c(String str, m mVar) throws RemoteException;

    void c(String str, nu nuVar) throws RemoteException;

    void c(String str, sl slVar) throws RemoteException;

    void c(String str, t tVar) throws RemoteException;

    void c(String str, u uVar) throws RemoteException;

    void c(String str, z zVar) throws RemoteException;

    void c(String str, String str2) throws RemoteException;

    void c(String str, String str2, long j, long j2, String str3, String str4) throws RemoteException;

    void c(String str, String str2, Bundle bundle) throws RemoteException;

    void tt(String str, nu nuVar) throws RemoteException;

    void tt(String str, String str2, Bundle bundle) throws RemoteException;

    Bundle ve(String str, String str2, Bundle bundle) throws RemoteException;

    @com.byazt.zqa.c(c = {0, 1, 31, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static abstract class c extends Binder implements yp {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IListenerManager");
        }

        public static yp c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof yp)) ? new C0493c(iBinder) : (yp) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IListenerManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), m.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), u.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    tt(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), nu.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    tt(parcel.readString(), nu.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), sl.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), t.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    c(parcel.readString(), z.c.c(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    Bundle bundleVe = ve(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleVe != null) {
                        parcel2.writeInt(1);
                        bundleVe.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        public static yp c() {
            return C0493c.c;
        }

        /* JADX INFO: renamed from: com.byazt.omf.yp$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 31, 1318})
        public static class C0493c implements yp {
            public static yp c;
            public IBinder tt;

            public C0493c(IBinder iBinder) {
                this.tt = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.tt;
            }

            @Override // com.byazt.omf.yp
            public void c(String str, m mVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    if (this.tt.transact(1, parcelObtain, parcelObtain2, 0) || c.c() == null) {
                        parcelObtain2.readException();
                    } else {
                        c.c().c(str, mVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void tt(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.tt.transact(4, parcelObtain, parcelObtain2, 0) || c.c() == null) {
                        parcelObtain2.readException();
                    } else {
                        c.c().tt(str, str2, bundle);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public Bundle ve(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.tt.transact(13, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        return c.c().ve(str, str2, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.tt.transact(2, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, str2, bundle);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void tt(String str, nu nuVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(nuVar != null ? nuVar.asBinder() : null);
                    if (!this.tt.transact(6, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().tt(str, nuVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, u uVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.tt.transact(3, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, uVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, nu nuVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(nuVar != null ? nuVar.asBinder() : null);
                    if (!this.tt.transact(5, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, nuVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, String str2, long j, long j2, String str3, String str4) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    try {
                        if (!this.tt.transact(7, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                            c.c().c(str, str2, j, j2, str3, str4);
                        } else {
                            parcelObtain2.readException();
                        }
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, sl slVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(slVar != null ? slVar.asBinder() : null);
                    if (!this.tt.transact(8, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, slVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (!this.tt.transact(9, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, t tVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.tt.transact(10, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, tVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.tt.transact(11, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, str2);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.byazt.omf.yp
            public void c(String str, z zVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zVar != null ? zVar.asBinder() : null);
                    if (!this.tt.transact(12, parcelObtain, parcelObtain2, 0) && c.c() != null) {
                        c.c().c(str, zVar);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
