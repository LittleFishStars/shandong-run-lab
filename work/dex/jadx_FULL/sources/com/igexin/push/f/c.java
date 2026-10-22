package com.igexin.push.f;

import com.igexin.push.g.j;
import com.igexin.sdk.main.FeedbackImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements com.igexin.push.f.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38126a = "com.igexin.push.f.c";
    private static final long c = 3600000;
    public long b = 0;

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
        this.b = j;
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        com.igexin.c.a.c.a.a("start cron-keep task", new Object[0]);
        FeedbackImpl.getInstance().clearFeedbackMessage();
        com.igexin.push.core.e.c.a().d();
        com.igexin.push.core.e.c.a().c();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.j();
        j.h();
        j.i();
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        return System.currentTimeMillis() - this.b > 3600000;
    }
}
