package com.alibaba.analytics.core.selfmonitor.exception;

import com.alibaba.analytics.a.u;
import com.alibaba.analytics.core.d;
import com.alibaba.appmonitor.a.e;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.event.g;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coremedia.iso.boxes.MetaBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExceptionEventBuilder {

    public enum ExceptionType {
        UT,
        AP,
        COMMON
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m133a(ExceptionType exceptionType, Throwable th) {
        if (th != null) {
            try {
                g gVar = (g) a.a().a(g.class, new Object[0]);
                EventType eventType = EventType.ALARM;
                gVar.eventId = eventType.getEventId();
                HashMap map = new HashMap();
                map.put(MetaBox.TYPE, e.d());
                ReuseJSONArray reuseJSONArray = (ReuseJSONArray) a.a().a(ReuseJSONArray.class, new Object[0]);
                reuseJSONArray.add(a(exceptionType, th));
                map.put("data", reuseJSONArray);
                gVar.w.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(map));
                gVar.aI = "APPMONITOR";
                gVar.aJ = a(exceptionType);
                com.alibaba.appmonitor.d.a.a(gVar);
                a.a().a(reuseJSONArray);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private static String a(ExceptionType exceptionType) {
        if (ExceptionType.UT == exceptionType) {
            return "ut-exception";
        }
        return ExceptionType.COMMON == exceptionType ? "ut-common-exception" : "sdk-exception";
    }

    private static JSONObject a(ExceptionType exceptionType, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) a.a().a(ReuseJSONObject.class, new Object[0]);
        if (d.a().getContext() != null) {
            jSONObject.put("pname", (Object) com.alibaba.analytics.a.a.getCurProcessName(d.a().getContext()));
        }
        jSONObject.put("page", (Object) "APPMONITOR");
        jSONObject.put("monitorPoint", (Object) a(exceptionType));
        jSONObject.put("arg", (Object) th.getClass().getSimpleName());
        jSONObject.put("successCount", (Object) 0);
        jSONObject.put("failCount", (Object) 1);
        ArrayList arrayList = new ArrayList();
        String strA = a(th);
        if (strA != null) {
            JSONObject jSONObject2 = (JSONObject) a.a().a(ReuseJSONObject.class, new Object[0]);
            jSONObject2.put("errorCode", (Object) strA);
            jSONObject2.put("errorCount", (Object) 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", (Object) arrayList);
        return jSONObject;
    }

    private static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String string = sb.toString();
        return u.isBlank(string) ? th.toString() : string;
    }
}
