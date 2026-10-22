package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@VisibleForTesting
@NotThreadSafe
public class t01<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Queue f19689a;
    public final int b;
    public int c;

    public t01(int i, int i2, int i3) {
        ax6.o(i > 0);
        ax6.o(i2 >= 0);
        ax6.o(i3 >= 0);
        this.f44820a = i;
        this.b = i2;
        this.f19689a = new LinkedList();
        this.c = i3;
    }

    public void a(V v) {
        this.f19689a.add(v);
    }

    public void b() {
        ax6.o(this.c > 0);
        this.c--;
    }

    @Nullable
    public V c() {
        V vH = h();
        if (vH != null) {
            this.c++;
        }
        return vH;
    }

    public int d() {
        return this.f19689a.size();
    }

    public int e() {
        return this.c;
    }

    public void f() {
        this.c++;
    }

    public boolean g() {
        return this.c + d() > this.b;
    }

    @Nullable
    public V h() {
        return (V) this.f19689a.poll();
    }

    public void i(V v) {
        ax6.i(v);
        ax6.o(this.c > 0);
        this.c--;
        a(v);
    }
}
