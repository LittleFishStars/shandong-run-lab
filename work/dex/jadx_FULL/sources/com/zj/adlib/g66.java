package com.zj.adlib;

import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class g66<V> extends t01<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<f66<V>> f41833a;

    public g66(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f41833a = new LinkedList<>();
    }

    @Override // com.zj.adlib.t01
    public void a(V v) {
        f66<V> f66VarPoll = this.f41833a.poll();
        if (f66VarPoll == null) {
            f66VarPoll = new f66<>();
        }
        f66VarPoll.c(v);
        ((t01) this).f19689a.add(f66VarPoll);
    }

    @Override // com.zj.adlib.t01
    public V h() {
        f66<V> f66Var = (f66) ((t01) this).f19689a.poll();
        V vB = f66Var.b();
        f66Var.a();
        this.f41833a.add(f66Var);
        return vB;
    }
}
