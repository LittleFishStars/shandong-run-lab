package com.alibaba.triver.kit.api.common;

import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRVMSizeUtil {
    private static Method sReadProcLinesMethod;
    private static boolean sReadProcLinesMethodFetched;

    private static void fetchReadProcLinesMethod() {
        if (sReadProcLinesMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("readProcLines", String.class, String[].class, long[].class);
            sReadProcLinesMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
        sReadProcLinesMethodFetched = true;
    }

    public static final int getVmSizeForPid(int i) {
        long[] jArr = {-1};
        readProcLines("/proc/" + i + "/status", new String[]{"VmSize:"}, jArr);
        return (int) jArr[0];
    }

    public static void readProcLines(String str, String[] strArr, long[] jArr) {
        fetchReadProcLinesMethod();
        Method method = sReadProcLinesMethod;
        if (method != null) {
            try {
                method.invoke(null, str, strArr, jArr);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
