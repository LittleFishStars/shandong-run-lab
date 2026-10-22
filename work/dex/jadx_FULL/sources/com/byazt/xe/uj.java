package com.byazt.xe;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.byazt.uq.sp;
import com.byazt.uq.x;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 15})
public class uj implements n.c {
    public static volatile IBinder c;
    public static volatile Object tt;

    public interface c {
    }

    @com.byazt.zqa.c(c = {0, 1, 1093, 153})
    public static class tt extends ResultReceiver {
        public c c;

        public tt(c cVar) {
            super(null);
            this.c = cVar;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    private static String[] c(String... strArr) {
        return strArr;
    }

    private static void tt(String str, int i) {
        if (str == null) {
            return;
        }
        String strTt = com.byazt.th.ve.tt(str, i);
        String strN = com.byazt.th.ve.n(str, i);
        c(strTt, strN);
        c(Zeus.getAppApplication().getPackageName(), strN, com.byazt.xe.tt.c());
    }

    private static void ve(String str, String str2, String str3) {
        if (tt == null || str == null || str2 == null || str3 == null) {
            return;
        }
        c(tt, "notifyDexLoad", new Object[]{str, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(str2), str3}, new Class[]{String.class, List.class, List.class, String.class});
    }

    @Override // com.byazt.xe.n.c
    public boolean c(String str, int i) {
        c();
        tt(str, i);
        boolean zC = c("speed", str, i);
        ve(str, i);
        return zC;
    }

    private static void c() {
        PackageManager packageManager;
        Field fieldC;
        IBinder iBinderAsBinder;
        if (c == null && (fieldC = c((packageManager = Zeus.getAppApplication().getPackageManager()), "mPM")) != null) {
            Object objC = c(fieldC, packageManager);
            tt = objC;
            if ((objC instanceof IInterface) && (iBinderAsBinder = ((IInterface) tt).asBinder()) != null) {
                c = iBinderAsBinder;
            }
        }
    }

    private static void ve(String str, int i) {
        if (str == null) {
            return;
        }
        tt(com.byazt.th.ve.sp(str, i), com.byazt.th.ve.a(str, i));
        tt(com.byazt.th.ve.n(str, i));
        tt();
    }

    private static void tt(String str, String str2, String str3) {
        if (tt == null || str == null || str2 == null || str3 == null) {
            return;
        }
        c(tt, "notifyDexLoad", new Object[]{str, Collections.singletonMap(str2, "PCL[]"), str3}, new Class[]{String.class, Map.class, String.class});
    }

    private static void tt() {
        c(ve(), (c) null);
    }

    private static void tt(String str, String str2) {
        try {
            sp.c(str, str2);
        } catch (Exception unused) {
        }
    }

    private static String[] ve() {
        return c("reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName());
    }

    private static void tt(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static boolean c(String str, String str2, int i) {
        String strN = com.byazt.th.ve.n(str2, i);
        String str3 = com.byazt.th.ve.x(str2, i) + File.separator + com.byazt.xe.tt.c(strN);
        for (int i2 = 1; i2 <= 3; i2++) {
            c(c(str), (c) null);
            if (com.byazt.xe.tt.c(str3)) {
                return true;
            }
        }
        return false;
    }

    private static void c(String str, String str2, String str3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 30) {
            tt(str, str2, str3);
        } else if (i == 29) {
            ve(str, str2, str3);
        }
    }

    private static void c(String[] strArr, c cVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeFileDescriptor(FileDescriptor.in);
        parcelObtain.writeFileDescriptor(FileDescriptor.out);
        parcelObtain.writeFileDescriptor(FileDescriptor.err);
        parcelObtain.writeStringArray(strArr);
        parcelObtain.writeStrongBinder(null);
        new tt(cVar).writeToParcel(parcelObtain, 0);
        try {
            c.transact(1598246212, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } catch (Exception unused) {
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    private static String[] c(String str) {
        return c("compile", "-m", str, "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName());
    }

    private static void c(String str, String str2) {
        try {
            x.c(str, str2);
        } catch (Exception unused) {
        }
    }

    public static Field c(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return c(obj.getClass(), str);
    }

    public static Field c(Class<?> cls, String str) {
        return FieldUtils.getField(cls, str);
    }

    public static Object c(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object c(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
