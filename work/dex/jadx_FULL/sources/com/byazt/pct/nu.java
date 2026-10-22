package com.byazt.pct;

import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.UiThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 137})
public class nu {
    public static qy c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28939a;
    public final List<yp> n;
    public final c tt;
    public final da uj;
    public final com.byazt.nl.uj ve;

    public nu(da daVar) {
        qy qyVar;
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        this.f28939a = false;
        this.uj = daVar;
        rl rlVarC = (!daVar.x || (qyVar = c) == null) ? null : qyVar.c(daVar.sl);
        if (daVar.c != null) {
            c cVar = daVar.tt;
            if (cVar == null) {
                this.tt = new zm();
            } else {
                this.tt = cVar;
            }
        } else {
            this.tt = daVar.tt;
        }
        this.tt.c(daVar.ve());
        this.tt.c(daVar, rlVarC);
        this.ve = daVar.c;
        arrayList.add(daVar.da);
        i.c(daVar.f28936a);
        gr.c(daVar.sp);
    }

    public static da c(com.byazt.nl.uj ujVar) {
        return new da(ujVar);
    }

    private void tt() {
        if (this.f28939a) {
            i.c(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void c(String str, T t) {
        tt();
        this.tt.c(str, t);
    }

    public nu c(String str, n<?, ?> nVar) {
        return c(str, (String) null, nVar);
    }

    @UiThread
    public nu c(String str, String str2, n<?, ?> nVar) {
        tt();
        this.tt.f28935a.c(str, nVar);
        return this;
    }

    public nu c(String str, uj.tt ttVar) {
        return c(str, (String) null, ttVar);
    }

    @UiThread
    public nu c(String str, String str2, uj.tt ttVar) {
        tt();
        this.tt.f28935a.c(str, ttVar);
        return this;
    }

    public boolean c(String str) {
        sp spVar;
        c cVar = this.tt;
        if (cVar == null || (spVar = cVar.f28935a) == null) {
            return false;
        }
        return spVar.c(str);
    }

    public void c() {
        if (this.f28939a) {
            return;
        }
        this.tt.ve();
        this.f28939a = true;
        Iterator<yp> it = this.n.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
