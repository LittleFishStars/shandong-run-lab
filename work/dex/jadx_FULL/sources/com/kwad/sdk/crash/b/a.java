package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static Set<String> ben;

    static {
        HashSet hashSet = new HashSet();
        ben = hashSet;
        hashSet.add("commonHT");
        ben.add("reportHT");
        ben.add("IpDirectHelper");
        ben.add("filedownloader serial thread");
        ben.add("RemitHandoverToDB");
        ben.add("source-status-callback");
        ben.add("ObiwanMMAPTracer");
        ben.add("FrameSequence decoding thread");
    }

    private static boolean O(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] strArrQe = e.Qd().Qe();
        if (strArrQe == null || strArrQe.length == 0) {
            return true;
        }
        boolean zA = false;
        for (String str : strArrQe) {
            zA = a(stackTraceElementArr, str);
            if (zA) {
                break;
            }
        }
        if (zA) {
            for (String str2 : e.Qd().Qf()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return zA;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean go(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return gp(str) || str.startsWith("ksad-") || str.startsWith("filedownloader serial thread");
    }

    private static boolean gp(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("kwad.kwadsdk")) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadStr:" + str);
        return true;
    }

    public static boolean gq(String str) {
        if (go(str) || i.cA(str)) {
            return true;
        }
        Set<String> set = ben;
        if (set == null || !set.contains(str)) {
            return false;
        }
        c.d("CrashFilter", "needReportByThreadName:" + str);
        return true;
    }

    public static boolean gr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrQe = e.Qd().Qe();
        if (strArrQe == null || strArrQe.length == 0) {
            return true;
        }
        boolean zContains = false;
        for (String str2 : strArrQe) {
            zContains = str.contains(str2);
            if (zContains) {
                break;
            }
        }
        if (zContains) {
            for (String str3 : e.Qd().Qf()) {
                if (str.contains(str3)) {
                    return false;
                }
            }
        }
        return zContains;
    }

    public static boolean v(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return O(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AnrAndNativeAdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}
