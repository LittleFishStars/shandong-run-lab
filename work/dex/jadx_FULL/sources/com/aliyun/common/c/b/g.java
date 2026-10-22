package com.aliyun.common.c.b;

import android.content.Context;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.conan.AlivcConan;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f25569a = false;
    private static boolean b = false;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlivcEventReporter f25570a;

        public a(AlivcEventReporter alivcEventReporter) {
            this.f25570a = alivcEventReporter;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlivcEventReporter alivcEventReporter = this.f25570a;
            if (alivcEventReporter != null) {
                alivcEventReporter.b();
            }
        }
    }

    public static AlivcEventReporter a(Context context) {
        if (f25569a || context == null || AlivcSdkCore.AlivcLogLevel.AlivcLogClose == AlivcSdkCore.getLogLevel()) {
            return null;
        }
        AlivcConan.a(context);
        com.aliyun.svideosdk.conan.event.b bVar = new com.aliyun.svideosdk.conan.event.b();
        bVar.a(context.getApplicationInfo().labelRes == 0 ? "unknown" : context.getString(context.getApplicationInfo().labelRes));
        bVar.a(com.aliyun.svideosdk.conan.a.AlivcConanBusinessSvideo);
        bVar.a(false);
        AlivcEventReporter alivcEventReporter = new AlivcEventReporter(bVar);
        alivcEventReporter.b("6.7.0");
        alivcEventReporter.a(" + 0 +  + 0");
        if (!b) {
            b = true;
            alivcEventReporter.c();
            Executors.newSingleThreadExecutor().submit(new a(alivcEventReporter));
        }
        return alivcEventReporter;
    }
}
