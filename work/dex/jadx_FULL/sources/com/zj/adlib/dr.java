package com.zj.adlib;

import android.widget.AbsListView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding.view.ViewEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dr extends ViewEvent<AbsListView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41259a;
    public final int b;
    public final int c;
    public final int d;

    public dr(@NonNull AbsListView absListView, int i, int i2, int i3, int i4) {
        super(absListView);
        this.f41259a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @NonNull
    @CheckResult
    public static dr b(AbsListView absListView, int i, int i2, int i3, int i4) {
        return new dr(absListView, i, i2, i3, i4);
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f41259a;
    }

    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dr.class != obj.getClass()) {
            return false;
        }
        dr drVar = (dr) obj;
        return this.f41259a == drVar.f41259a && this.b == drVar.b && this.c == drVar.c && this.d == drVar.d;
    }

    public int f() {
        return this.c;
    }

    public int hashCode() {
        return (((((this.f41259a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "AbsListViewScrollEvent{scrollState=" + this.f41259a + ", firstVisibleItem=" + this.b + ", visibleItemCount=" + this.c + ", totalItemCount=" + this.d + '}';
    }
}
