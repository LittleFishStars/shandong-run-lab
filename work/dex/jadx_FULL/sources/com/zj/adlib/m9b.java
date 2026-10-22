package com.zj.adlib;

import android.content.Context;
import com.alibaba.ariver.kernel.RVParams;
import com.kwad.sdk.collector.AppStatusRules;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class m9b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<k9b> f43252a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f43253a;
        public final /* synthetic */ String f;

        public a(String str, Context context) {
            this.f = str;
            this.f43253a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (m9b.class) {
                try {
                    String strB = p4b.b(s4b.p(this.f));
                    k9b k9bVarA = nbb.a(m9b.f43252a);
                    nbb.f(this.f43253a, k9bVarA, y6b.j, 50, AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE, "10");
                    if (k9bVarA.f17613a == null) {
                        k9bVarA.f17613a = new y8b(new b9b(new a9b()));
                    }
                    l9b.c(strB, s4b.p(" \"timestamp\":\"" + s4b.c(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + this.f), k9bVarA);
                } catch (Throwable th) {
                    a7b.m(th, "mam", RVParams.ANTI_PHISHING);
                }
            }
        }
    }

    public static void a(String str, Context context) {
        a7b.o().submit(new a(str, context));
    }
}
