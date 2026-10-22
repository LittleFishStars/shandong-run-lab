package com.efs.sdk.memleaksdk.monitor.shark;

import java.io.File;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Pattern f29646a = Pattern.compile("Threads:\\s*(\\d+)\\s*");
    static Pattern b = Pattern.compile("MemTotal:\\s*(\\d+)\\s*kB");
    static Pattern c = Pattern.compile("MemFree:\\s*(\\d+)\\s*kB");
    static Pattern d = Pattern.compile("MemAvailable:\\s*(\\d+)\\s*kB");
    public static c e = new c();
    public static c f = new c();
    public static b g = new b();
    public static b h = new b();
    public static a i = new a();
    public static a j = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29647a;
        public long b;
        public long c;
        public long d;
        public float e;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29648a;
        public int b;
        public int c;
        public float d;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29649a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            return 0;
        }
        MatchResult matchResult = matcher.toMatchResult();
        if (matchResult.groupCount() > 0) {
            try {
                return Integer.parseInt(matchResult.group(1));
            } catch (NumberFormatException e2) {
                g.b("UMonitor.Java", "match value parse failed", e2);
            }
        }
        return 0;
    }

    public static void a() {
        j = i;
        h = g;
        f = e;
        i = new a();
        e = new c();
        g = new b();
        i.f29647a = Runtime.getRuntime().maxMemory();
        i.b = Runtime.getRuntime().totalMemory();
        i.c = Runtime.getRuntime().freeMemory();
        a aVar = i;
        long j2 = aVar.b - aVar.c;
        aVar.d = j2;
        aVar.e = (j2 * 1.0f) / aVar.f29647a;
        e.a(new File("/proc/meminfo"), new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.internal.ah.1
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                if (str.startsWith("MemTotal")) {
                    ah.g.f29648a = ah.b(str, ah.b);
                    return true;
                }
                if (str.startsWith("MemFree")) {
                    ah.g.b = ah.b(str, ah.c);
                    return true;
                }
                if (!str.startsWith("MemAvailable")) {
                    return true;
                }
                ah.g.c = ah.b(str, ah.d);
                return true;
            }
        });
        e.a(new File("/proc/self/status"), new e.a() { // from class: com.efs.sdk.memleaksdk.monitor.internal.ah.2
            @Override // com.efs.sdk.memleaksdk.monitor.internal.e.a
            public boolean a(String str) {
                if (ah.e.f29649a != 0) {
                    return false;
                }
                if (!str.startsWith("Threads")) {
                    return true;
                }
                ah.e.f29649a = ah.b(str, ah.f29646a);
                return true;
            }
        });
        b bVar = g;
        bVar.d = (bVar.c * 1.0f) / bVar.f29648a;
        g.b("UMonitor.Java", "---- Monitor Memory ----");
        Locale locale = Locale.US;
        g.b("UMonitor.Java", String.format(locale, "java heap max:%d used ratio:%f%%", Long.valueOf(i.f29647a), Float.valueOf(i.e * 100.0f)));
        g.b("UMonitor.Java", String.format(locale, "process threads:%d", Integer.valueOf(e.f29649a)));
        g.b("UMonitor.Java", String.format(locale, "mem info total:%dkB free:%dkB available:%dkB, ratio: %.1f%%", Integer.valueOf(g.f29648a), Integer.valueOf(g.b), Integer.valueOf(g.c), Float.valueOf(g.d * 100.0f)));
    }
}
