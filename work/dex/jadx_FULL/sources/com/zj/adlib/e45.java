package com.zj.adlib;

import android.graphics.PointF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e45 extends j45<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f41342a;

    public e45() {
        this.f41342a = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF e(a45<PointF> a45Var) {
        T t = ((j45) this).f17325a;
        if (t != 0) {
            return (PointF) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // com.zj.adlib.j45
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final PointF a(a45<PointF> a45Var) {
        this.f41342a.set(up5.k(a45Var.g().x, a45Var.b().x, a45Var.c()), up5.k(a45Var.g().y, a45Var.b().y, a45Var.c()));
        PointF pointFE = e(a45Var);
        this.f41342a.offset(pointFE.x, pointFE.y);
        return this.f41342a;
    }

    public e45(@NonNull PointF pointF) {
        super(pointF);
        this.f41342a = new PointF();
    }
}
