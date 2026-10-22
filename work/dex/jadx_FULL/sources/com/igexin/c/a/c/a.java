package com.igexin.c.a.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;
import com.igexin.c.a.d.g;
import com.igexin.push.config.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    private static volatile a b;
    private static final List<String> c = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Logger f37831a;

    private a() {
        try {
            this.f37831a = new Logger(GtcProvider.context());
            this.f37831a.setGlobalTag("gtsdk");
            this.f37831a.setLogcatEnable(false);
            this.f37831a.setLogFileNameSuffix("GTSDK");
            this.f37831a.setStackOffset(1);
            this.f37831a.setFileEnableProperty("sdk.debug");
            List<String> list = c;
            list.add(g.h);
            list.add("ScheduleQueue");
        } catch (Throwable unused) {
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public static void a(String str, String str2) {
        try {
            if (a().f37831a == null || str == null || c.contains(str)) {
                return;
            }
            a().f37831a.e(str + "|" + str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Object... objArr) {
        try {
            if (a().f37831a != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                a().f37831a.filelog(1, null, str, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th) {
        try {
            if (a().f37831a != null) {
                a().f37831a.e(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z) {
        try {
            e.a(Boolean.valueOf(z));
            if (a().f37831a != null) {
                a().f37831a.setLogcatEnable(false);
                a().f37831a.setFileEnableProperty("sdk.debug");
            }
        } catch (Throwable unused) {
        }
    }

    private static Logger b() {
        return a().f37831a;
    }

    public static void b(String str, String str2) {
        try {
            if (a().f37831a == null || str == null || c.contains(str)) {
                return;
            }
            a().f37831a.d(str + "|" + str2);
        } catch (Throwable unused) {
        }
    }

    private static void c(String str, String str2) {
        try {
            if (a().f37831a == null || str == null || c.contains(str)) {
                return;
            }
            a().f37831a.logcat(2, null, str2, null);
        } catch (Throwable unused) {
        }
    }

    private static void d(String str, String str2) {
        try {
            if (a().f37831a == null || str == null || c.contains(str)) {
                return;
            }
            a().f37831a.logcat(3, null, str2, null);
        } catch (Throwable unused) {
        }
    }

    private static void e(String str, String str2) {
        try {
            if (a().f37831a == null || str == null || c.contains(str)) {
                return;
            }
            a().f37831a.logcat(4, null, str2, null);
        } catch (Throwable unused) {
        }
    }
}
