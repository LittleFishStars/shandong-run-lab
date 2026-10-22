package com.getui.gtc.dyc.a.a;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.log.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Logger f30335a;

    /* JADX INFO: renamed from: com.getui.gtc.dyc.a.a.a$a, reason: collision with other inner class name */
    public static class C0655a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f30336a = new a();
    }

    private a() {
        Logger logger = new Logger(GtcProvider.context());
        this.f30335a = logger;
        logger.setGlobalTag("gtc.dyc");
        this.f30335a.setFileEnableProperty("dyc.fileLog");
        this.f30335a.setLogcatEnable(false);
        this.f30335a.setLogFileNameSuffix("gtc");
        this.f30335a.setStackOffset(1);
    }

    public static Logger a() {
        return C0655a.f30336a.f30335a;
    }

    public static void a(String str) {
        C0655a.f30336a.f30335a.e(str);
    }

    public static void a(Throwable th) {
        C0655a.f30336a.f30335a.w(th);
    }

    public static void c(Throwable th) {
        C0655a.f30336a.f30335a.e(th);
    }
}
