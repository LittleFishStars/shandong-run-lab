package com.igexin.push.f.b;

import com.igexin.push.core.j;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38122a = -2147483642;
    private static final String b = "HeartBeatTimerTask";
    private static b c;

    public b() {
        super(j.a().b(), (byte) 0);
        this.p = true;
    }

    public static b g() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private static void q() {
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return f38122a;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        if (this.m) {
            return;
        }
        i();
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        com.igexin.push.core.e.P = System.currentTimeMillis();
        if (!com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.a("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!", new Object[0]);
            i();
        } else {
            System.currentTimeMillis();
            com.igexin.c.a.c.a.a("heartbeatReq", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.f();
        }
    }

    public final void i() {
        a(j.a().b(), TimeUnit.MILLISECONDS);
    }
}
