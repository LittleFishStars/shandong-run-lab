package com.getui.gtc.i.c;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f30379a;

    /* JADX INFO: renamed from: com.getui.gtc.i.c.a$a, reason: collision with other inner class name */
    public static class C0658a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f30380a = new a(0);
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f30379a = logger;
        logger.setGlobalTag("gtc");
        logger.setFileEnableProperty("gtc.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static void a(String str) {
        C0658a.f30380a.f30379a.d(str);
    }

    public static void a(String str, Throwable th) {
        C0658a.f30380a.f30379a.e(str, th);
    }

    public static void a(Throwable th) {
        C0658a.f30380a.f30379a.d(th);
    }

    public static void b(String str) {
        C0658a.f30380a.f30379a.w(str);
    }

    public static void b(Throwable th) {
        C0658a.f30380a.f30379a.w(th);
    }

    public static void c(String str) {
        C0658a.f30380a.f30379a.e(str);
    }

    public static void c(Throwable th) {
        C0658a.f30380a.f30379a.e(th);
    }

    public static void d(String str) {
        C0658a.f30380a.f30379a.filelog(2, null, str, null);
    }

    public static void d(Throwable th) {
        C0658a.f30380a.f30379a.filelog(2, null, null, th);
    }
}
