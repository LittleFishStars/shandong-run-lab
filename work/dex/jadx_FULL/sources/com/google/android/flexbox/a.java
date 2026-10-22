package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5434a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5436b;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5432a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f5435b = Integer.MAX_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Integer> f5433a = new ArrayList();

    public int a() {
        return this.g;
    }

    public int b() {
        return this.l;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.h - this.i;
    }

    public int e() {
        return this.e;
    }

    public float f() {
        return this.f31201a;
    }

    public float g() {
        return this.b;
    }

    public void h(View view, int leftDecoration, int topDecoration, int rightDecoration, int bottomDecoration) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f5432a = Math.min(this.f5432a, (view.getLeft() - flexItem.getMarginLeft()) - leftDecoration);
        this.f5435b = Math.min(this.f5435b, (view.getTop() - flexItem.getMarginTop()) - topDecoration);
        this.c = Math.max(this.c, view.getRight() + flexItem.getMarginRight() + rightDecoration);
        this.d = Math.max(this.d, view.getBottom() + flexItem.getMarginBottom() + bottomDecoration);
    }
}
