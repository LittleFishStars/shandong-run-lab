package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class v1 implements com.kc.dw.cache.media.download.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.bquery.e f39413a;
    public final String b;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f39414a;
        public final v1 b;

        public a(v1 v1Var, File file) {
            this.b = v1Var;
            this.f39414a = file;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            v1 v1Var = this.b;
            com.kc.dw.core.bquery.e eVar = v1Var.f39413a;
            if (eVar != null) {
                String str = v1Var.b;
                File file = this.f39414a;
                x1.a aVar = ((u1) eVar).f39410a;
                if (aVar != null) {
                    aVar.a(str, file, false);
                }
                ((u1) this.b.f39413a).a(4, "save error. unknown");
            }
        }
    }

    public v1(com.kc.dw.core.bquery.e eVar, String str) {
        this.f39413a = eVar;
        this.b = str;
    }

    @Override // com.kc.dw.cache.media.download.f
    public void a() {
        File fileA = null;
        boolean z = false;
        try {
            fileA = com.kc.dw.core.bquery.c.a(this.b, (String) null);
            if (fileA != null && fileA.exists() && fileA.length() > 0) {
                z = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z) {
            SdkHandler.runOnMainThread(new a(this, fileA));
            return;
        }
        com.kc.dw.core.bquery.e eVar = this.f39413a;
        if (eVar != null) {
            ((u1) eVar).a(4, "save error. unknown");
        }
    }

    @Override // com.kc.dw.cache.media.download.f
    public void a(int i, String str) {
        com.kc.dw.core.bquery.e eVar = this.f39413a;
        if (eVar != null) {
            ((u1) eVar).a(i, str);
        }
    }

    @Override // com.kc.dw.cache.media.download.f
    public void a(long j) {
        SdkHandler.runOnMainThread(new w1(this.f39413a));
    }

    @Override // com.kc.dw.cache.media.download.f
    public void a(long j, int i) {
    }
}
