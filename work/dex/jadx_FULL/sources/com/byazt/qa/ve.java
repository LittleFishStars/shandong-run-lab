package com.byazt.qa;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 598, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28966a;
    public float da;
    public int i;
    public int m;
    public int n;
    public boolean nu;
    public boolean rh;
    public float sl;
    public int sp;
    public int t;
    public int u;
    public int x;
    public int z;
    public int c = Integer.MAX_VALUE;
    public int tt = Integer.MAX_VALUE;
    public int ve = Integer.MIN_VALUE;
    public int uj = Integer.MIN_VALUE;
    public List<Integer> yp = new ArrayList();

    public int c() {
        return this.sp;
    }

    public int tt() {
        return this.x - this.i;
    }

    public void c(View view, int i, int i2, int i3, int i4) {
        tt ttVar = (tt) view.getLayoutParams();
        this.c = Math.min(this.c, (view.getLeft() - ttVar.u()) - i);
        this.tt = Math.min(this.tt, (view.getTop() - ttVar.yp()) - i2);
        this.ve = Math.max(this.ve, view.getRight() + ttVar.z() + i3);
        this.uj = Math.max(this.uj, view.getBottom() + ttVar.m() + i4);
    }
}
