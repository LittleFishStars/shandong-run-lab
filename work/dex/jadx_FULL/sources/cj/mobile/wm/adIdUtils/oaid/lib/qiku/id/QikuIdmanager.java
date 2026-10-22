package cj.mobile.wm.adIdUtils.oaid.lib.qiku.id;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QikuIdmanager {
    public static int CODE_GET_OAID = 4;
    public static int CODE_IS_SUPPORTED = 2;
    public static final int CODE_LIMIT_READ_OAID = 9;
    public static final int CODE_RESET_OAID = 8;
    public IBinder mIBinder;

    public QikuIdmanager() {
        Method declaredMethod;
        this.mIBinder = null;
        try {
            Class<?> cls = Class.forName(dexc.dexa("boespje/pt/TztufnQspqfsujft"));
            if (!((String) cls.getMethod(dexc.dexa("hfu"), String.class, String.class).invoke(cls, dexc.dexa("sp/cvjme/vjwfstjpo"), "")).contains(dexc.dexa("471VJ")) || (declaredMethod = Class.forName(dexc.dexa("boespje/pt/TfswjdfNbobhfs")).getDeclaredMethod(dexc.dexa("hfuTfswjdf"), String.class)) == null) {
                return;
            }
            this.mIBinder = (IBinder) declaredMethod.invoke(null, dexc.dexa("rjlvje"));
        } catch (Throwable th) {
            OAIDLog.printE(dexc.dexa("RjlvJenbobhfs!joju!gbjm-") + th);
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
}
