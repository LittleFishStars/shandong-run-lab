package com.beizi.fusion;

import android.content.Context;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f27173a;
    protected ba b;
    private final ca c;

    public da(Context context, ba baVar) {
        this.f27173a = context;
        this.b = baVar;
        this.c = ca.b.a(b(), context, baVar);
    }

    public ca a() {
        return this.c;
    }

    public abstract d b();

    public Map c() {
        ca caVar = this.c;
        return caVar != null ? caVar.d() : Collections.EMPTY_MAP;
    }

    public void a(ea eaVar) {
        this.c.a(eaVar);
        this.c.h();
    }
}
