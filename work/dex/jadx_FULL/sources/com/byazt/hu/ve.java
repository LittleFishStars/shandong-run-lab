package com.byazt.hu;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 54})
public class ve<P, R> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ve<R, ?> f28630a;
    public P c;
    public ve<?, P> n;
    public R tt;
    public SoftReference<c<P, R>> uj;
    public int ve;

    public interface c<PARAM, RESULT> {
        RESULT c(PARAM param);
    }

    private ve(int i, c<P, R> cVar, P p) {
        this.ve = i;
        this.uj = new SoftReference<>(cVar);
        this.c = p;
    }

    public static <P, R> ve<P, R> c(c<P, R> cVar, P p) {
        return new ve<>(2, cVar, p);
    }

    private R tt() {
        return this.tt;
    }

    @Override // java.lang.Runnable
    public void run() {
        ve<?, P> veVar;
        if (this.ve == 0 && !u.tt()) {
            com.byazt.di.x.c().tt().post(this);
            return;
        }
        if (this.ve == 1 && u.tt()) {
            com.byazt.di.n.c().c(this);
            return;
        }
        if (this.ve == 2 && u.tt()) {
            com.byazt.di.n.c().tt(this);
            return;
        }
        if (this.c == null && (veVar = this.n) != null) {
            this.c = veVar.tt();
        }
        c<P, R> cVar = this.uj.get();
        if (cVar == null) {
            return;
        }
        this.tt = cVar.c(this.c);
        ve<R, ?> veVar2 = this.f28630a;
        if (veVar2 != null) {
            veVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> ve<R, NR> c(int i, c<R, NR> cVar) {
        ve veVar = (ve<R, ?>) new ve(i, cVar, null);
        this.f28630a = veVar;
        veVar.n = this;
        return veVar;
    }

    public <NR> ve<R, NR> c(c<R, NR> cVar) {
        return c(0, cVar);
    }

    public void c() {
        ve<?, P> veVar = this.n;
        if (veVar != null) {
            veVar.c();
        } else {
            run();
        }
    }
}
