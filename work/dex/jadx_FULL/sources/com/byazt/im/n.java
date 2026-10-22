package com.byazt.im;

import com.byazt.ete.bm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 46})
public class n extends c {
    public static int n = 2;
    public static int uj = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.dj.tt f28655a;
    public com.byazt.tdq.n i;
    public bm sp;
    public String x;

    public n(com.byazt.dj.tt ttVar, bm bmVar, com.byazt.tdq.n nVar) {
        this.f28655a = ttVar;
        this.sp = bmVar;
        if (ttVar != null) {
            this.x = ttVar.uj();
        }
        this.i = nVar;
    }

    public String a() {
        return this.x;
    }

    public bm n() {
        return this.sp;
    }

    public com.byazt.tdq.n sp() {
        return this.i;
    }

    public com.byazt.dj.tt uj() {
        return this.f28655a;
    }
}
