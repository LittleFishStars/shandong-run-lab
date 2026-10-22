package com.getui.gtc.dim.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Logger f30327a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f30328a = new b(0);
    }

    private b() {
        Logger logger = new Logger(GtcProvider.context());
        this.f30327a = logger;
        logger.setGlobalTag("gtc.dim");
        logger.setFileEnableProperty("dim.fileLog");
        logger.setLogcatEnable(false);
        logger.setLogFileNameSuffix("gtc");
        logger.setStackOffset(1);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static void a(String str) {
        a.f30328a.f30327a.d(str);
    }

    public static void a(String str, Throwable th) {
        a.f30328a.f30327a.e(str, th);
    }

    public static void a(Throwable th) {
        a.f30328a.f30327a.w(th);
    }

    public static void b(String str) {
        a.f30328a.f30327a.w(str);
    }

    public static void b(Throwable th) {
        a.f30328a.f30327a.e(th);
    }
}
