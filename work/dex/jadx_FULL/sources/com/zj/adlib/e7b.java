package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e7b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static e7b f41366a = new e7b();
    }

    public static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0067 A[EDGE_INSN: B:23:0x0067->B:24:0x0068 BREAK  A[LOOP:0: B:5:0x0014->B:96:0x0014]] */
    public static boolean b(Context context, String str, String str2, List<r4b> list, boolean z, r4b r4bVar) {
        String string;
        r4b r4bVar2 = null;
        if (str2 == null) {
            string = "";
            break;
        }
        Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                string = null;
                break;
            }
            Thread next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getName()) && (str2.contains(next.getName()) || next.getName().contains(str2))) {
                StackTraceElement[] stackTrace = next.getStackTrace();
                if (stackTrace != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        stringBuffer.append("at ");
                        stringBuffer.append(stackTraceElement);
                        stringBuffer.append("<br />");
                    }
                    string = stringBuffer.toString();
                    break;
                }
                string = "";
                break;
            }
        }
        if (!TextUtils.isEmpty(string)) {
            loop2: for (int i = 0; list != null && i < list.size(); i++) {
                r4b r4bVar3 = list.get(i);
                if (r4bVar3 != null) {
                    String[] strArrI = r4bVar3.i();
                    for (String str3 : strArrI) {
                        if (!TextUtils.isEmpty(strArrI[i]) && string.contains(str3)) {
                            r4bVar2 = r4bVar3;
                            break loop2;
                        }
                    }
                }
            }
        }
        if (z && r4bVar2 == null) {
            return false;
        }
        String str4 = str + "<br />" + string;
        if (str2 == null) {
            str2 = "";
        }
        String[] strArr = {"AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", "main"};
        JSONArray jSONArray = new JSONArray();
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread != null && !str2.equals(thread.getName())) {
                for (int i2 = 0; i2 < 6; i2++) {
                    String str5 = strArr[i2];
                    String name = thread.getName();
                    if (((TextUtils.isEmpty(str5) || TextUtils.isEmpty(name) || (!str5.contains(name) && !name.contains(str5))) ? false : true) && a(thread) != null) {
                        jSONArray.put(a(thread));
                    }
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", str4);
            jSONObject.put("backStacks", jSONArray);
        } catch (Throwable unused) {
        }
        String string2 = jSONObject.toString();
        if (TextUtils.isEmpty(string2)) {
            return false;
        }
        try {
            if (z || r4bVar2 != null) {
                a7b.f(context, r4bVar2, string2, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
                return true;
            }
            a7b.k(context, r4bVar, string2, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
            return true;
        } catch (Throwable unused2) {
        }
    }
}
