package com.zj.adlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class zz9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46373a = Process.myUid();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Method f21128a;
    public static final Method b;
    public static final Method c;
    public static final Method d;
    public static final Method e;
    public static final Method f;
    public static final Method g;
    public static final Method h;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f21128a = method;
        if (is6.g()) {
            try {
                method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
                method2 = null;
            }
        } else {
            method2 = null;
        }
        b = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        c = method3;
        try {
            method4 = WorkSource.class.getMethod(p3.f, Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        d = method4;
        if (is6.g()) {
            try {
                method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused5) {
                method5 = null;
            }
        } else {
            method5 = null;
        }
        e = method5;
        if (is6.o()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f = method6;
        if (is6.o()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e3) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e3);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        g = method7;
        if (is6.o()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                method8.setAccessible(true);
            } catch (Exception unused6) {
            }
        }
        h = method8;
    }

    @KeepForSdk
    public static void a(@NonNull WorkSource workSource, int i, @NonNull String str) {
        Method method = b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = f21128a;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static WorkSource b(@NonNull Context context, @NonNull String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = w0a.a(context).c(str, 0);
                if (applicationInfoC == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i = applicationInfoC.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static WorkSource c(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfoC = w0a.a(context).c(str, 0);
            if (applicationInfoC == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i = applicationInfoC.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = f;
        if (method2 == null || (method = g) == null) {
            a(workSource, i, str);
        } else {
            try {
                Object objInvoke = method2.invoke(workSource, new Object[0]);
                int i2 = f46373a;
                if (i != i2) {
                    method.invoke(objInvoke, Integer.valueOf(i), str);
                }
                method.invoke(objInvoke, Integer.valueOf(i2), str2);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e2);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int d(@NonNull WorkSource workSource, int i) {
        Method method = d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, Integer.valueOf(i));
                yw6.l(objInvoke);
                return ((Integer) objInvoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String e(@NonNull WorkSource workSource, int i) {
        Method method = e;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> f(@NonNull WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int i = workSource == null ? 0 : i(workSource);
        if (i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                String strE = e(workSource, i2);
                if (!zs8.b(strE)) {
                    yw6.l(strE);
                    arrayList.add(strE);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static boolean g(@NonNull Context context) {
        return (context == null || context.getPackageManager() == null || w0a.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    @KeepForSdk
    public static boolean h(@NonNull WorkSource workSource) {
        Method method = h;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                yw6.l(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e2) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e2);
            }
        }
        return i(workSource) == 0;
    }

    @KeepForSdk
    public static int i(@NonNull WorkSource workSource) {
        Method method = c;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                yw6.l(objInvoke);
                return ((Integer) objInvoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }
}
