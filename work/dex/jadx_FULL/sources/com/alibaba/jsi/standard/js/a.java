package com.alibaba.jsi.standard.js;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f24577a;
    private com.alibaba.jsi.standard.b c = null;
    private int d = -1;
    private String e = null;
    boolean b = false;

    public a(long j) {
        this.f24577a = j;
    }

    private void h() {
        if (this.b) {
            throw new RuntimeException("Arguments has been detached: " + this);
        }
    }

    public int a() {
        h();
        if (this.d == -1) {
            Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 700, this.f24577a);
            if (objCmd == null || !(objCmd instanceof Long)) {
                this.d = 0;
            } else {
                this.d = ((Long) objCmd).intValue();
            }
        }
        return this.d;
    }

    public com.alibaba.jsi.standard.b b() {
        Object objCmd;
        h();
        if (this.c == null && (objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 702, this.f24577a)) != null && (objCmd instanceof Long)) {
            this.c = com.alibaba.jsi.standard.b.a(((Long) objCmd).longValue());
        }
        return this.c;
    }

    public w c() {
        h();
        Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 703, this.f24577a);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public String d() {
        Object objCmd;
        h();
        if (this.e == null && (objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 704, this.f24577a)) != null && (objCmd instanceof String)) {
            this.e = (String) objCmd;
        }
        return this.e;
    }

    public boolean e() {
        h();
        return Bridge.cmd((com.alibaba.jsi.standard.b) null, 705, this.f24577a) != null;
    }

    public w f() {
        h();
        Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 706, this.f24577a);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public w[] g() {
        h();
        Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, this.f24577a);
        if (objCmd == null || !(objCmd instanceof w[])) {
            return null;
        }
        return (w[]) objCmd;
    }

    public w a(int i) {
        h();
        Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 701, this.f24577a, i);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }
}
