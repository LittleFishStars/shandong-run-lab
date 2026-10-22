package com.byazt.pct;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 130})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28937a;
    public final int c;
    public final String n;
    public final String sp;
    public final String tt;
    public final String uj;
    public final String ve;
    public final String x;

    @com.byazt.zqa.c(c = {0, 1, 124, 600})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28938a;
        public String c;
        public String n;
        public String sp;
        public String tt;
        public String uj;
        public String ve;

        private c() {
        }

        public c a(String str) {
            this.f28938a = str;
            return this;
        }

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c n(String str) {
            this.n = str;
            return this;
        }

        public c sp(String str) {
            this.sp = str;
            return this;
        }

        public c tt(String str) {
            this.tt = str;
            return this;
        }

        public c uj(String str) {
            this.uj = str;
            return this;
        }

        public c ve(String str) {
            this.ve = str;
            return this;
        }

        public m c() {
            return new m(this);
        }
    }

    public static c c() {
        return new c();
    }

    public String toString() {
        return "methodName: " + this.uj + ", params: " + this.n + ", callbackId: " + this.f28937a + ", type: " + this.ve + ", version: " + this.tt + ", ";
    }

    private m(String str, int i) {
        this.tt = null;
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.f28937a = str;
        this.sp = null;
        this.c = i;
        this.x = null;
    }

    public static m c(String str, int i) {
        return new m(str, i);
    }

    public static boolean c(m mVar) {
        return mVar == null || mVar.c != 1 || TextUtils.isEmpty(mVar.uj) || TextUtils.isEmpty(mVar.n);
    }

    private m(c cVar) {
        this.tt = cVar.c;
        this.ve = cVar.tt;
        this.uj = cVar.ve;
        this.n = cVar.uj;
        this.f28937a = cVar.n;
        this.sp = cVar.f28938a;
        this.c = 1;
        this.x = cVar.sp;
    }
}
