package com.igexin.push.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.util.Base64;
import com.getui.gtc.base.GtcProvider;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f38153a = Integer.MIN_VALUE;
    private static String b = "GT_PM";
    private static Object c;

    private static int a() {
        int i = f38153a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (GtcProvider.context() != null) {
            try {
                Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
                Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), Integer.TYPE);
                declaredMethod.setAccessible(true);
                int iIntValue = ((Integer) declaredMethod.invoke(cls, Integer.valueOf(Process.myUid()))).intValue();
                f38153a = iIntValue;
                return iIntValue;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return 0;
    }

    private static PackageInfo a(Object obj, String str, int i) {
        PackageInfo packageInfo = null;
        try {
            IBinder iBinderAsBinder = ((IInterface) obj).asBinder();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(iBinderAsBinder.getInterfaceDescriptor());
                parcelObtain.writeString(str);
                parcelObtain.writeLong(i);
                parcelObtain.writeInt(a());
                iBinderAsBinder.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                packageInfo = parcelObtain2.readInt() != 0 ? (PackageInfo) PackageInfo.CREATOR.createFromParcel(parcelObtain2) : null;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return packageInfo;
    }

    public static PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfoA = a(str, i, a());
        if (packageInfoA != null) {
            return packageInfoA;
        }
        throw new PackageManager.NameNotFoundException(str + " not found");
    }

    private static PackageInfo a(String str, int i, int i2) {
        try {
            if (c == null) {
                c = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke(null, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 33) {
                return a(c, str, i);
            }
            String str2 = new String(Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
            Class<?> cls = c.getClass();
            Class<?> cls2 = Integer.TYPE;
            return (PackageInfo) cls.getMethod(str2, String.class, cls2, cls2).invoke(c, str, Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
