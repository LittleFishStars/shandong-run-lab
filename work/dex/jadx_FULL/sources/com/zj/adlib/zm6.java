package com.zj.adlib;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class zm6 extends ps4<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Path f46294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps4<PointF> f21091a;

    public zm6(k35 k35Var, ps4<PointF> ps4Var) {
        super(k35Var, ps4Var.f18928a, ps4Var.f18932b, ps4Var.f18925a, ps4Var.f18931b, ps4Var.f18934c, ps4Var.f44051a, ps4Var.f18927a);
        this.f21091a = ps4Var;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        T t;
        T t2;
        T t3 = ((ps4) this).f18932b;
        boolean z = (t3 == 0 || (t2 = ((ps4) this).f18928a) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = ((ps4) this).f18928a;
        if (t4 == 0 || (t = ((ps4) this).f18932b) == 0 || z) {
            return;
        }
        ps4<PointF> ps4Var = this.f21091a;
        this.f46294a = vj9.d((PointF) t4, (PointF) t, ps4Var.f18924a, ps4Var.f18930b);
    }

    @Nullable
    public Path j() {
        return this.f46294a;
    }
}
