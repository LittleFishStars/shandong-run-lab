package com.igexin.push.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38111a = "NormalModel";

    @Override // com.igexin.push.d.b
    public final long a() {
        long j;
        long j2;
        boolean zA = com.igexin.push.g.c.a();
        com.igexin.push.core.e.n = com.igexin.push.g.c.e();
        boolean z = com.igexin.push.core.e.p;
        boolean z2 = com.igexin.push.core.e.s;
        boolean z3 = com.igexin.push.core.e.n;
        com.igexin.c.a.c.a.a("NormalModel|isSdkOn = " + com.igexin.push.core.e.p + " isPushOn = " + com.igexin.push.core.e.s + " isBlockEndTime = " + zA + " isNetworkAvailable = " + com.igexin.push.core.e.n, new Object[0]);
        if (!com.igexin.push.core.e.n || !com.igexin.push.core.e.p || !com.igexin.push.core.e.s || !zA) {
            com.igexin.c.a.c.a.a(f38111a, "reconnect stop, interval= 20min ++++++");
            com.igexin.c.a.c.a.a("NormalModel|reconnect stop, interval= 20min ++++", new Object[0]);
            return com.igexin.push.config.c.g;
        }
        long j3 = com.igexin.push.core.e.O;
        if (j3 <= 0) {
            j2 = 1;
        } else {
            if (j3 <= 300) {
                j = 150;
            } else if (j3 <= 10000) {
                j = 500;
            } else {
                j = j3 <= 30000 ? com.igexin.push.config.c.j : com.igexin.push.config.c.l;
            }
            j2 = j3 + j;
        }
        com.igexin.push.core.e.O = j2;
        if (com.igexin.push.core.e.O > com.igexin.push.config.c.g) {
            com.igexin.push.core.e.O = com.igexin.push.config.c.g;
        }
        long j4 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("NormalModel|after add auto reconnect delay time = ".concat(String.valueOf(j4)), new Object[0]);
        return j4;
    }
}
