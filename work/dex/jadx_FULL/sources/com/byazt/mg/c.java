package com.byazt.mg;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.hv.TTDownloadField;
import com.zj.adlib.u15;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 20})
public final class c {
    public static String c = null;
    public static boolean n = false;
    public static Class<?> tt;
    public static Field uj;
    public static Field ve;

    public static int a(Context context) {
        Class<?> clsSp = sp(context);
        if (uj == null && clsSp != null) {
            try {
                uj = clsSp.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = uj;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static long c(int i) {
        if (i < 0) {
            return 0L;
        }
        return ((long) i) * 1024;
    }

    public static boolean c(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            return (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    @NonNull
    public static String n(Context context) {
        Class<?> clsSp = sp(context);
        if (ve == null && clsSp != null) {
            try {
                ve = clsSp.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = ve;
        if (field == null) {
            return "";
        }
        try {
            return (String) field.get(null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    @Nullable
    private static Class<?> sp(Context context) {
        if (tt == null && !n) {
            try {
                tt = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            n = true;
        }
        return tt;
    }

    public static boolean tt(Context context) {
        String strUj = uj(context);
        if (strUj != null && strUj.contains(u15.f19942b)) {
            return false;
        }
        if (strUj == null || !strUj.equals(context.getPackageName())) {
            return strUj != null && strUj.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    @Nullable
    public static String uj(Context context) {
        String str = c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            c = t.c(context);
        } catch (Throwable unused) {
        }
        String str2 = c;
        return str2 == null ? "" : str2;
    }

    public static boolean ve(Context context) {
        return false;
    }

    private static void tt(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        jSONObject2.put("availMem", memoryInfo.availMem);
        jSONObject2.put("lowMemory", memoryInfo.lowMemory);
        jSONObject2.put("threshold", memoryInfo.threshold);
        jSONObject2.put("totalMem", sp.c(memoryInfo));
        jSONObject.put("sys_memory_info", jSONObject2);
    }

    @Nullable
    public static ActivityManager.ProcessErrorStateInfo c(Context context, int i) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SystemClock.sleep(200L);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        return processErrorStateInfo;
                    }
                }
            }
        }
        return null;
    }

    public static void c(@NonNull Context context, @NonNull JSONObject jSONObject) {
        try {
            c(jSONObject);
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                tt(jSONObject, activityManager);
            }
            c(jSONObject, activityManager);
        } catch (Throwable unused) {
        }
    }

    private static void c(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
        jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime runtime = Runtime.getRuntime();
        jSONObject2.put("max_memory", runtime.maxMemory());
        jSONObject2.put("free_memory", runtime.freeMemory());
        jSONObject2.put("total_memory", runtime.totalMemory());
        if (activityManager != null) {
            jSONObject2.put("memory_class", activityManager.getMemoryClass());
            jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
        }
        jSONObject.put("app_memory_info", jSONObject2);
    }

    private static void c(@NonNull JSONObject jSONObject) throws JSONException {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("dalvikPrivateDirty", c(memoryInfo.dalvikPrivateDirty));
        jSONObject2.put("dalvikPss", c(memoryInfo.dalvikPss));
        jSONObject2.put("dalvikSharedDirty", c(memoryInfo.dalvikSharedDirty));
        jSONObject2.put("nativePrivateDirty", c(memoryInfo.nativePrivateDirty));
        jSONObject2.put("nativePss", c(memoryInfo.nativePss));
        jSONObject2.put("nativeSharedDirty", c(memoryInfo.nativeSharedDirty));
        jSONObject2.put("otherPrivateDirty", c(memoryInfo.otherPrivateDirty));
        jSONObject2.put("otherPss", c(memoryInfo.otherPss));
        jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
        jSONObject2.put("totalPrivateClean", tt.c(memoryInfo));
        jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
        jSONObject2.put("totalPss", c(memoryInfo.getTotalPss()));
        jSONObject2.put("totalSharedClean", tt.tt(memoryInfo));
        jSONObject2.put("totalSharedDirty", c(memoryInfo.getTotalSharedDirty()));
        jSONObject2.put("totalSwappablePss", c(tt.ve(memoryInfo)));
        jSONObject.put("memory_info", jSONObject2);
    }
}
