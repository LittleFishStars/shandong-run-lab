package com.igexin.push.f;

import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements com.igexin.push.f.b.c {
    private static final long b = 360000;
    private static a c = null;
    private static String d = "CheckCondition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f38113a = 0;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private static boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = com.igexin.push.core.e.S;
        if (j <= 0) {
            com.igexin.push.core.e.S = jCurrentTimeMillis - 60000;
            return true;
        }
        if (jCurrentTimeMillis - j <= 60000) {
            return false;
        }
        com.igexin.push.core.e.S = jCurrentTimeMillis;
        return true;
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
        this.f38113a = j;
    }

    public final void a(boolean z) {
        if (!z || d()) {
            b();
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        com.igexin.c.a.c.a.b("CheckConditionTask", "CheckConditionTask start to run check condition status...");
        Message messageObtain = Message.obtain();
        messageObtain.what = com.igexin.push.core.b.T;
        com.igexin.push.core.d.a.f37984a.a(messageObtain);
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        return System.currentTimeMillis() - this.f38113a > b;
    }
}
