package com.czhj.devicehelper.cnoaid.com.qiku.id;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.acse.ottn.p3;
import com.blankj.utilcode.util.e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class QikuIdmanager {
    public static int CODE_GET_AAID = 6;
    public static int CODE_GET_OAID = 4;
    public static int CODE_GET_UDID = 3;
    public static int CODE_GET_VAID = 5;
    public static int CODE_IS_SUPPORTED = 2;
    public static final int CODE_LIMIT_READ_OAID = 9;
    public static final int CODE_RESET_OAID = 8;
    public static int CODE_SHUTDOWN = 7;
    static final String TAG = "QikuIdmanager";
    private IBinder mIBinder;

    public QikuIdmanager() {
        Method declaredMethod;
        this.mIBinder = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            if (!((String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, e.f, "")).contains("360UI") || (declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.mIBinder = (IBinder) declaredMethod.invoke(null, "qikuid");
        } catch (Exception e) {
            Log.e(TAG, "Failure get qikuid service", e);
        }
    }

    public String getAAID() {
        if (this.mIBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.mIBinder.transact(CODE_GET_AAID, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String getOAID() {
        if (this.mIBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.mIBinder.transact(CODE_GET_OAID, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String getUDID() {
        if (this.mIBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.mIBinder.transact(CODE_GET_UDID, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public String getVAID() {
        if (this.mIBinder == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.mIBinder.transact(CODE_GET_VAID, parcelObtain, parcelObtain2, 0);
            return parcelObtain2.readString();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    public boolean isLimited() {
        if (this.mIBinder != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.mIBinder.transact(9, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readBoolean();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public boolean isSupported() {
        if (this.mIBinder != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                this.mIBinder.transact(CODE_IS_SUPPORTED, parcelObtain, parcelObtain2, 0);
                return parcelObtain2.readInt() == 1;
            } catch (RemoteException e) {
                e.printStackTrace();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return false;
    }

    public void shutDown() {
        if (this.mIBinder != null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    this.mIBinder.transact(CODE_SHUTDOWN, parcelObtain, parcelObtain2, 0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
    }
}
