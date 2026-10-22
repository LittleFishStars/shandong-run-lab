package com.byazt.mg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.zj.adlib.u15;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 215})
public final class yp {

    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static class c {
        public final PrintWriter c;

        public c(PrintWriter printWriter) {
            this.c = printWriter;
        }

        public Object c() {
            return this.c;
        }

        public void c(Object obj) {
            this.c.println(obj);
        }
    }

    public static String c(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            c(stackTraceElement, sb);
        }
        return sb.toString();
    }

    private static boolean tt(String str) {
        Set<String> setC = n.c();
        if (setC.contains(str)) {
            return true;
        }
        for (String str2 : setC) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ve(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }

    public static StringBuilder c(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(Consts.DOT);
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(u15.f19942b);
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    public static boolean tt(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @NonNull
    public static String c(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (ve(th)) {
                c(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            return stringWriter.toString();
        } catch (Exception unused) {
            return "";
        } finally {
            printWriter.close();
        }
    }

    @Nullable
    public static JSONObject c(String str) {
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!tt(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put(CrashHianalyticsData.THREAD_NAME, key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        z = jSONArray2.length() > 0;
                    }
                    if (z) {
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void c(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        c cVar = new c(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (cVar.c()) {
            cVar.c(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i > 256) {
                    cVar.c("\t... skip " + (stackTrace.length - i) + " lines");
                    break;
                }
                cVar.c("\tat " + stackTraceElement);
                i++;
            }
            for (Throwable th2 : th.getSuppressed()) {
                c(th2, cVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                c(cause, cVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void c(Throwable th, c cVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            cVar.c("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int iMin = Math.min(stackTrace.length, 256);
        int i = iMin - 1;
        int i2 = i;
        for (int iMin2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && iMin2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[iMin2]); iMin2--) {
            i2--;
        }
        int i3 = i - i2;
        cVar.c(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            cVar.c(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            cVar.c("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            cVar.c(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            c(th2, cVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            c(cause, cVar, stackTrace, "Caused by: ", str2, set);
        }
    }
}
