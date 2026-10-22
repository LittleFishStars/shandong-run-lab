package com.alibaba.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IAnalytics extends IInterface {
    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(Transaction transaction, String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void a(String str, String str2, String str3) throws RemoteException;

    void a(String str, String str2, String str3, double d) throws RemoteException;

    void a(String str, String str2, String str3, String str4) throws RemoteException;

    void a(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void a(boolean z, boolean z2, String str, String str2) throws RemoteException;

    /* JADX INFO: renamed from: a */
    boolean mo81a(String str, String str2) throws RemoteException;

    void b(int i) throws RemoteException;

    void b(Transaction transaction, String str) throws RemoteException;

    void b(String str, String str2, double d) throws RemoteException;

    void b(String str, String str2, String str3) throws RemoteException;

    boolean b(String str, String str2) throws RemoteException;

    void c(int i) throws RemoteException;

    void c(String str, String str2, double d) throws RemoteException;

    void c(String str, String str2, String str3) throws RemoteException;

    boolean c(String str, String str2) throws RemoteException;

    void d(int i) throws RemoteException;

    boolean d(String str, String str2) throws RemoteException;

    void destroy() throws RemoteException;

    void dispatchLocalHits() throws RemoteException;

    void e(int i) throws RemoteException;

    void enableLog(boolean z) throws RemoteException;

    void f(int i) throws RemoteException;

    void g(int i) throws RemoteException;

    String getValue(String str) throws RemoteException;

    void h(int i) throws RemoteException;

    void i(int i) throws RemoteException;

    void init() throws RemoteException;

    void removeGlobalProperty(String str) throws RemoteException;

    void saveCacheDataToLocal() throws RemoteException;

    String selfCheck(String str) throws RemoteException;

    void setAppVersion(String str) throws RemoteException;

    void setChannel(String str) throws RemoteException;

    void setGlobalProperty(String str, String str2) throws RemoteException;

    void setSampling(int i) throws RemoteException;

    void setSessionProperties(Map map) throws RemoteException;

    void transferLog(Map map) throws RemoteException;

    void triggerUpload() throws RemoteException;

    void turnOffRealTimeDebug() throws RemoteException;

    void turnOnDebug() throws RemoteException;

    void turnOnRealTimeDebug(Map map) throws RemoteException;

    void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException;

    void updateSessionProperties(Map map) throws RemoteException;

    void updateUserAccount(String str, String str2, String str3) throws RemoteException;

    public static abstract class Stub extends Binder implements IAnalytics {
        public Stub() {
            attachInterface(this, "com.alibaba.analytics.IAnalytics");
        }

        public static IAnalytics a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.alibaba.analytics.IAnalytics");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAnalytics)) ? new a(iBinder) : (IAnalytics) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.alibaba.analytics.IAnalytics");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    updateUserAccount(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    setAppVersion(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    setChannel(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    updateSessionProperties(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    setSessionProperties(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    turnOnDebug();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                    transferLog(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 10:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            dispatchLocalHits();
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            saveCacheDataToLocal();
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            String value = getValue(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeString(value);
                            return true;
                        case 13:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            init();
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            enableLog(parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 16:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            turnOnRealTimeDebug(parcel.readHashMap(getClass().getClassLoader()));
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            turnOffRealTimeDebug();
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            destroy();
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            triggerUpload();
                            parcel2.writeNoException();
                            return true;
                        case 20:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            setSampling(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 21:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            g(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 22:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 23:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 24:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 25:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 26:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 27:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            updateMeasure(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 28:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 29:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            b(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 30:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            boolean zMo81a = mo81a(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(zMo81a ? 1 : 0);
                            return true;
                        case 31:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 32:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 33:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            e(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 34:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            f(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 35:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            boolean zC = c(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(zC ? 1 : 0);
                            return true;
                        case 36:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            b(parcel.readString(), parcel.readString(), parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 37:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            c(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 38:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            d(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 39:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            boolean zB = b(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(zB ? 1 : 0);
                            return true;
                        case 40:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 41:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 42:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 43:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 44:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            b(parcel.readString(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 45:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            c(parcel.readString(), parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 46:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            h(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 47:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            i(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 48:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            boolean zD = d(parcel.readString(), parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(zD ? 1 : 0);
                            return true;
                        case 49:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            c(parcel.readString(), parcel.readString(), parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 50:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readDouble());
                            parcel2.writeNoException();
                            return true;
                        case 51:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DimensionValueSet.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MeasureValueSet.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 52:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            a(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 53:
                            parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                            b(parcel.readInt() != 0 ? Transaction.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            switch (i) {
                                case 55:
                                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                                    String strSelfCheck = selfCheck(parcel.readString());
                                    parcel2.writeNoException();
                                    parcel2.writeString(strSelfCheck);
                                    return true;
                                case 56:
                                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                                    setGlobalProperty(parcel.readString(), parcel.readString());
                                    parcel2.writeNoException();
                                    return true;
                                case 57:
                                    parcel.enforceInterface("com.alibaba.analytics.IAnalytics");
                                    removeGlobalProperty(parcel.readString());
                                    parcel2.writeNoException();
                                    return true;
                                default:
                                    return super.onTransact(i, parcel, parcel2, i2);
                            }
                    }
            }
        }

        public static class a implements IAnalytics {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f23742a;

            public a(IBinder iBinder) {
                this.f23742a = iBinder;
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23742a;
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void b(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean c(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void d(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void destroy() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void dispatchLocalHits() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void e(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void enableLog(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.f23742a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void f(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void g(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public String getValue(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    this.f23742a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void h(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void i(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void init() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void removeGlobalProperty(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    this.f23742a.transact(57, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void saveCacheDataToLocal() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public String selfCheck(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    this.f23742a.transact(55, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setAppVersion(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    this.f23742a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setChannel(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    this.f23742a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setGlobalProperty(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(56, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setSampling(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void setSessionProperties(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeMap(map);
                    this.f23742a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void transferLog(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeMap(map);
                    this.f23742a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void triggerUpload() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOffRealTimeDebug() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOnDebug() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    this.f23742a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void turnOnRealTimeDebug(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeMap(map);
                    this.f23742a.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeDouble(d);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeDouble(d3);
                    this.f23742a.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateSessionProperties(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeMap(map);
                    this.f23742a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void updateUserAccount(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f23742a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(boolean z, boolean z2, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    int i = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void b(String str, String str2, double d) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d);
                    this.f23742a.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean d(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void c(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.f23742a.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public boolean b(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void c(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f23742a.transact(45, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, MeasureSet measureSet) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f23742a.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void b(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f23742a.transact(44, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void c(String str, String str2, double d) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d);
                    this.f23742a.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void b(Transaction transaction, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    if (transaction != null) {
                        parcelObtain.writeInt(1);
                        transaction.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.f23742a.transact(53, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f23742a.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        parcelObtain.writeInt(1);
                        measureSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeInt(i);
                    this.f23742a.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            /* JADX INFO: renamed from: a */
            public boolean mo81a(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, double d) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeDouble(d);
                    this.f23742a.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, String str3, double d) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeDouble(d);
                    this.f23742a.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.f23742a.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.f23742a.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.f23742a.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.f23742a.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeDouble(d);
                    this.f23742a.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        parcelObtain.writeInt(1);
                        dimensionValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (measureValueSet != null) {
                        parcelObtain.writeInt(1);
                        measureValueSet.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f23742a.transact(51, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.alibaba.analytics.IAnalytics
            public void a(Transaction transaction, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.alibaba.analytics.IAnalytics");
                    if (transaction != null) {
                        parcelObtain.writeInt(1);
                        transaction.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.f23742a.transact(52, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
