package com.byazt.oz;

import com.byazt.yj.d;
import com.byazt.yj.eo;
import com.byazt.yj.my;
import com.byazt.yj.qp;
import com.byazt.yj.rh;
import com.byazt.yj.zb;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 213, 46})
public final class n implements my {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.yj.uj f28927a;
    public rh c;
    public qp i;
    public zb n;
    public d sp;
    public ExecutorService tt;
    public eo uj;
    public com.byazt.yj.n ve;
    public com.byazt.yj.tt x;

    @com.byazt.zqa.c(c = {0, 1, 213, 151})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.byazt.yj.uj f28928a;
        public rh c;
        public qp i;
        public zb n;
        public d sp;
        public ExecutorService tt;
        public eo uj;
        public com.byazt.yj.n ve;
        public com.byazt.yj.tt x;

        public c c(com.byazt.yj.tt ttVar) {
            this.x = ttVar;
            return this;
        }

        public c c(ExecutorService executorService) {
            this.tt = executorService;
            return this;
        }

        public c c(com.byazt.yj.n nVar) {
            this.ve = nVar;
            return this;
        }

        public n c() {
            return new n(this);
        }
    }

    public static n da() {
        return new c().c();
    }

    @Override // com.byazt.yj.my
    public zb a() {
        return this.n;
    }

    @Override // com.byazt.yj.my
    public rh c() {
        return this.c;
    }

    @Override // com.byazt.yj.my
    public com.byazt.yj.tt i() {
        return this.x;
    }

    @Override // com.byazt.yj.my
    public eo n() {
        return this.uj;
    }

    @Override // com.byazt.yj.my
    public com.byazt.yj.uj sp() {
        return this.f28927a;
    }

    @Override // com.byazt.yj.my
    public ExecutorService tt() {
        return this.tt;
    }

    @Override // com.byazt.yj.my
    public com.byazt.yj.n uj() {
        return this.ve;
    }

    @Override // com.byazt.yj.my
    public qp ve() {
        return this.i;
    }

    @Override // com.byazt.yj.my
    public d x() {
        return this.sp;
    }

    private n(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f28927a = cVar.f28928a;
        this.x = cVar.x;
        this.sp = cVar.sp;
        this.i = cVar.i;
    }
}
