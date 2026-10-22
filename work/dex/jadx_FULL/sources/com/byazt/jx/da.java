package com.byazt.jx;

import android.graphics.PointF;
import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 72})
public class da implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.kd.tt f28704a;
    public final String c;
    public final boolean da;
    public final com.byazt.kd.tt i;
    public final com.byazt.kd.tt n;
    public final boolean sl;
    public final com.byazt.kd.tt sp;
    public final c tt;
    public final com.byazt.kd.u<PointF, PointF> uj;
    public final com.byazt.kd.tt ve;
    public final com.byazt.kd.tt x;

    public enum c {
        STAR(1),
        POLYGON(2);

        public final int ve;

        c(int i) {
            this.ve = i;
        }

        public static c c(int i) {
            for (c cVar : values()) {
                if (cVar.ve == i) {
                    return cVar;
                }
            }
            return null;
        }
    }

    public da(String str, c cVar, com.byazt.kd.tt ttVar, com.byazt.kd.u<PointF, PointF> uVar, com.byazt.kd.tt ttVar2, com.byazt.kd.tt ttVar3, com.byazt.kd.tt ttVar4, com.byazt.kd.tt ttVar5, com.byazt.kd.tt ttVar6, boolean z, boolean z2) {
        this.c = str;
        this.tt = cVar;
        this.ve = ttVar;
        this.uj = uVar;
        this.n = ttVar2;
        this.f28704a = ttVar3;
        this.sp = ttVar4;
        this.x = ttVar5;
        this.i = ttVar6;
        this.da = z;
        this.sl = z2;
    }

    public com.byazt.kd.tt a() {
        return this.sp;
    }

    public String c() {
        return this.c;
    }

    public boolean da() {
        return this.sl;
    }

    public c getType() {
        return this.tt;
    }

    public boolean i() {
        return this.da;
    }

    public com.byazt.kd.tt n() {
        return this.f28704a;
    }

    public com.byazt.kd.tt sp() {
        return this.x;
    }

    public com.byazt.kd.tt tt() {
        return this.ve;
    }

    public com.byazt.kd.tt uj() {
        return this.n;
    }

    public com.byazt.kd.u<PointF, PointF> ve() {
        return this.uj;
    }

    public com.byazt.kd.tt x() {
        return this.i;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.yp(xVar, veVar, this);
    }
}
