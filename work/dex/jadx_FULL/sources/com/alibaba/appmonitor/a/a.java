package com.alibaba.appmonitor.a;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.u;
import com.alibaba.analytics.core.selfmonitor.exception.AppMonitorException;
import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a {
    public static boolean W = false;
    static volatile boolean X = false;
    private static Application b;
    private static Map<String, String> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.alibaba.appmonitor.a.a$a, reason: collision with other inner class name */
    public static class C0137a {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return com.alibaba.appmonitor.c.b.a().a(str, str2, Boolean.TRUE, (Map<String, String>) null);
        }

        public static void commitFail(String str, String str2, String str3, String str4) {
            commitFail(str, str2, null, str3, str4);
        }

        public static void commitSuccess(String str, String str2) {
            commitSuccess(str, str2, null);
        }

        public static void setSampling(int i) {
            com.alibaba.appmonitor.c.b.a().a(EventType.ALARM, i);
        }

        public static void setStatisticsInterval(int i) {
            EventType eventType = EventType.ALARM;
            eventType.setStatisticsInterval(i);
            a.setStatisticsInterval(eventType, i);
        }

        public static void commitFail(String str, String str2, String str3, String str4, String str5) {
            String str6;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    HashMap map = new HashMap();
                    map.put("_status", "0");
                    if (a.X && com.alibaba.analytics.core.d.m110m()) {
                        EventType eventType = EventType.ALARM;
                        if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().a(str, str2, Boolean.FALSE, map))) {
                            j.d("commitFail ", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                            if (!com.alibaba.appmonitor.c.b.a().c(eventType, str, str2)) {
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3, str4, str5);
                                return;
                            }
                            if (com.alibaba.analytics.core.selfmonitor.e.a().a(eventType, str, str2)) {
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3, str4, str5);
                                str6 = str + "_abtest";
                            } else {
                                str6 = str;
                            }
                            Context context = com.alibaba.analytics.core.d.a().getContext();
                            com.alibaba.appmonitor.b.d.a().a(eventType, new com.alibaba.appmonitor.b.a(str6, str2, str3, str4, str5, false, com.alibaba.analytics.core.e.b.getAccess(context), com.alibaba.analytics.core.e.b.getAccsssSubType(context)));
                            return;
                        }
                    }
                    j.d("log discard !", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                    return;
                }
                j.w("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void commitSuccess(String str, String str2, String str3) {
            String str4;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.X && com.alibaba.analytics.core.d.m110m()) {
                        EventType eventType = EventType.ALARM;
                        if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().a(str, str2, Boolean.TRUE, (Map<String, String>) null))) {
                            j.d("commitSuccess", "module", str, "monitorPoint", str2, "arg", str3);
                            if (!com.alibaba.appmonitor.c.b.a().c(eventType, str, str2)) {
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3);
                                return;
                            }
                            Context context = com.alibaba.analytics.core.d.a().getContext();
                            if (com.alibaba.analytics.core.selfmonitor.e.a().a(eventType, str, str2)) {
                                str4 = str + "_abtest";
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3);
                            } else {
                                str4 = str;
                            }
                            com.alibaba.appmonitor.b.d.a().a(eventType, new com.alibaba.appmonitor.b.a(str4, str2, str3, null, null, true, com.alibaba.analytics.core.e.b.getAccess(context), com.alibaba.analytics.core.e.b.getAccsssSubType(context)));
                            return;
                        }
                    }
                    j.d("log discard !", "module", str, "monitorPoint", str2, "arg", str3);
                    return;
                }
                j.w("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }
    }

    public static class b {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return com.alibaba.appmonitor.c.b.a().b(EventType.COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, null, d);
        }

        public static void setSampling(int i) {
            com.alibaba.appmonitor.c.b.a().a(EventType.COUNTER, i);
        }

        public static void setStatisticsInterval(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.setStatisticsInterval(eventType, i);
        }

        public static void commit(String str, String str2, String str3, double d) {
            String str4;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.X && com.alibaba.analytics.core.d.m110m()) {
                        EventType eventType = EventType.COUNTER;
                        if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, str, str2))) {
                            j.d("commitCount", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                            if (!com.alibaba.appmonitor.c.b.a().c(eventType, str, str2)) {
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3, d);
                                return;
                            }
                            Context context = com.alibaba.analytics.core.d.a().getContext();
                            if (com.alibaba.analytics.core.selfmonitor.e.a().a(eventType, str, str2)) {
                                com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, str3, d);
                                str4 = str + "_abtest";
                            } else {
                                str4 = str;
                            }
                            com.alibaba.appmonitor.b.d.a().a(eventType, new com.alibaba.appmonitor.b.b(str4, str2, str3, d, com.alibaba.analytics.core.e.b.getAccess(context), com.alibaba.analytics.core.e.b.getAccsssSubType(context)));
                            return;
                        }
                    }
                    j.d("log discard !", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                    return;
                }
                j.w("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }
    }

    public static class c {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return com.alibaba.appmonitor.c.b.a().b(EventType.COUNTER, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.X && com.alibaba.analytics.core.d.m110m()) {
                        EventType eventType = EventType.COUNTER;
                        if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, str, str2))) {
                            j.d("commitOffLineCount", "module", str, "monitorPoint", str2, "value", Double.valueOf(d));
                            com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, (String) null, d);
                            return;
                        }
                    }
                    j.d("log discard !", "");
                    return;
                }
                j.w("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void setSampling(int i) {
            com.alibaba.appmonitor.c.b.a().a(EventType.COUNTER, i);
        }

        public static void setStatisticsInterval(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.setStatisticsInterval(eventType, i);
        }
    }

    public static class d {
        public static void begin(String str, String str2, String str3) {
            try {
                if (a.X && com.alibaba.analytics.core.d.m110m()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, str, str2))) {
                        j.d("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        com.alibaba.appmonitor.event.e.a().a(Integer.valueOf(eventType.getEventId()), str, str2, str3);
                        return;
                    }
                }
                j.d("log discard !", "");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            return com.alibaba.appmonitor.c.b.a().b(EventType.STAT, str, str2);
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static void end(String str, String str2, String str3) {
            try {
                if (a.X && com.alibaba.analytics.core.d.m110m()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, str, str2))) {
                        j.d("statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        com.alibaba.appmonitor.event.e.a().e(str, str2, str3);
                        return;
                    }
                }
                j.d("log discard !", " module ", str, "monitorPoint", str2, " measureName", str3);
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void setSampling(int i) {
            com.alibaba.appmonitor.c.b.a().a(EventType.STAT, i);
        }

        public static void setStatisticsInterval(int i) {
            EventType eventType = EventType.STAT;
            eventType.setStatisticsInterval(i);
            a.setStatisticsInterval(eventType, i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        
            if (com.alibaba.appmonitor.c.b.a().a(r0, r6, r7, r8 != null ? r8.getMap() : null) != false) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, double d) {
            try {
                if (a.X && com.alibaba.analytics.core.d.m110m()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen()) {
                        if (!a.W) {
                        }
                        j.d("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                        com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(str, str2);
                        if (aVarA != null) {
                            List<Measure> measures = aVarA.m144a().getMeasures();
                            if (measures.size() == 1) {
                                commit(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.appmonitor.pool.a.a().a(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), d));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                j.d("log discard !", "");
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            if (com.alibaba.appmonitor.c.b.a().a(r0, r11, r12, r13 != null ? r13.getMap() : null) != false) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void commit(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
            try {
                if (a.X && com.alibaba.analytics.core.d.m110m()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen()) {
                        if (!a.W) {
                        }
                        j.d("statEvent commit", "module", str, "monitorPoint", str2);
                        if (com.alibaba.appmonitor.c.b.a().c(eventType, str, str2)) {
                            Context context = com.alibaba.analytics.core.d.a().getContext();
                            com.alibaba.appmonitor.b.d.a().a(eventType, new com.alibaba.appmonitor.b.e(str, str2, dimensionValueSet, measureValueSet, com.alibaba.analytics.core.e.b.getAccess(context), com.alibaba.analytics.core.e.b.getAccsssSubType(context)));
                            return;
                        }
                        com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str, str2, measureValueSet, dimensionValueSet);
                        if (com.alibaba.analytics.core.selfmonitor.e.a().e(str, str2)) {
                            com.alibaba.appmonitor.event.e.a().a(eventType.getEventId(), str + "_abtest", str2, measureValueSet, dimensionValueSet);
                            return;
                        }
                        return;
                    }
                }
                j.d("log discard !", "module", str, "monitorPoint", str2);
            } catch (Throwable th) {
                ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.alibaba.analytics.core.d.a().a((IUTRequestAuthentication) (z ? new UTSecurityThridRequestAuthentication(str, str2) : new UTBaseRequestAuthentication(str, str2, z2)));
    }

    public static Map<String, String> c() {
        return c;
    }

    public static synchronized void destroy() {
        try {
            j.d("AppMonitorDelegate", "start destory");
            if (X) {
                com.alibaba.appmonitor.a.d.T();
                com.alibaba.appmonitor.a.d.destroy();
                com.alibaba.appmonitor.a.c.destroy();
                Application application = b;
                if (application != null) {
                    com.alibaba.analytics.core.e.b.h(application.getApplicationContext());
                }
                X = false;
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void enableLog(boolean z) {
        j.d("AppMonitorDelegate", "[enableLog]");
        j.setDebug(z);
    }

    public static synchronized void init(Application application) {
        j.d("AppMonitorDelegate", "start init");
        try {
            if (!X) {
                b = application;
                com.alibaba.appmonitor.a.c.init();
                com.alibaba.appmonitor.a.d.init();
                com.alibaba.appmonitor.a.b.init(application);
                X = true;
            }
        } catch (Throwable unused) {
            destroy();
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet) {
        register(str, str2, measureSet, (DimensionSet) null);
    }

    public static void removeGlobalProperty(String str) {
        c.remove(str);
    }

    public static void setGlobalProperty(String str, String str2) {
        if (u.isEmpty(str) || str2 == null) {
            return;
        }
        c.put(str, str2);
    }

    public static void setSampling(int i) {
        j.d("AppMonitorDelegate", "[setSampling]");
        for (EventType eventType : EventType.values()) {
            eventType.setDefaultSampling(i);
            com.alibaba.appmonitor.c.b.a().a(eventType, i);
        }
    }

    public static void setStatisticsInterval(int i) {
        for (EventType eventType : EventType.values()) {
            eventType.setStatisticsInterval(i);
            setStatisticsInterval(eventType, i);
        }
    }

    public static synchronized void triggerUpload() {
        try {
            j.d("AppMonitorDelegate", "triggerUpload");
            if (X && com.alibaba.analytics.core.d.m110m()) {
                com.alibaba.appmonitor.a.d.T();
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void updateMeasure(String str, String str2, String str3, double d2, double d3, double d4) {
        com.alibaba.appmonitor.model.a aVarA;
        j.d("AppMonitorDelegate", "[updateMeasure]");
        try {
            if (!X || u.isBlank(str) || u.isBlank(str2) || (aVarA = com.alibaba.appmonitor.model.b.a().a(str, str2)) == null || aVarA.m144a() == null) {
                return;
            }
            aVarA.m144a().upateMeasure(new Measure(str3, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
        } catch (Exception unused) {
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, boolean z) {
        register(str, str2, measureSet, null, z);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        register(str, str2, measureSet, dimensionSet, false);
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (X) {
                if (!u.isBlank(str) && !u.isBlank(str2)) {
                    com.alibaba.appmonitor.model.a aVar = new com.alibaba.appmonitor.model.a(str, str2, measureSet, dimensionSet, z);
                    com.alibaba.appmonitor.model.b.a().a(aVar);
                    com.alibaba.appmonitor.b.d.a().a(aVar);
                    MeasureSet measureSetA = com.alibaba.analytics.core.selfmonitor.e.a().a(str, str2);
                    if (measureSetA != null) {
                        com.alibaba.appmonitor.model.b.a().a(new com.alibaba.appmonitor.model.a(str + "_abtest", str2, measureSetA, dimensionSet, false));
                        return;
                    }
                    return;
                }
                j.d("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (W) {
                    throw new AppMonitorException("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void setStatisticsInterval(EventType eventType, int i) {
        try {
            if (X && eventType != null) {
                com.alibaba.appmonitor.a.d.c(eventType.getEventId(), i);
                if (i > 0) {
                    eventType.setOpen(true);
                } else {
                    eventType.setOpen(false);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }
}
