package com.byazt.zk;

import com.zj.adlib.c25;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 71})
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29245a;
    public final List<com.byazt.jx.ve> c;
    public final int da;
    public final com.byazt.fs.da gr;
    public final List<com.byazt.vc.c<Float>> gt;
    public final com.byazt.jx.c gu;
    public final com.byazt.kd.t i;
    public final float m;
    public final com.byazt.kd.tt my;
    public final c n;
    public final com.byazt.kd.da nu;
    public final boolean qy;
    public final com.byazt.kd.sl rh;
    public final tt rl;
    public final int sl;
    public final String sp;
    public final int t;
    public final com.byazt.ga.a tt;
    public final float u;
    public final long uj;
    public final String ve;
    public final List<com.byazt.jx.x> x;
    public final float yp;
    public final float z;

    public enum c {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum tt {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public x(List<com.byazt.jx.ve> list, com.byazt.ga.a aVar, String str, long j, c cVar, long j2, String str2, List<com.byazt.jx.x> list2, com.byazt.kd.t tVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.byazt.kd.da daVar, com.byazt.kd.sl slVar, List<com.byazt.vc.c<Float>> list3, tt ttVar, com.byazt.kd.tt ttVar2, boolean z, com.byazt.jx.c cVar2, com.byazt.fs.da daVar2) {
        this.c = list;
        this.tt = aVar;
        this.ve = str;
        this.uj = j;
        this.n = cVar;
        this.f29245a = j2;
        this.sp = str2;
        this.x = list2;
        this.i = tVar;
        this.da = i;
        this.sl = i2;
        this.t = i3;
        this.u = f;
        this.yp = f2;
        this.z = f3;
        this.m = f4;
        this.nu = daVar;
        this.rh = slVar;
        this.gt = list3;
        this.rl = ttVar;
        this.my = ttVar2;
        this.qy = z;
        this.gu = cVar2;
        this.gr = daVar2;
    }

    public String a() {
        return this.ve;
    }

    public com.byazt.ga.a c() {
        return this.tt;
    }

    public List<com.byazt.jx.x> da() {
        return this.x;
    }

    public com.byazt.fs.da gr() {
        return this.gr;
    }

    public com.byazt.kd.sl gt() {
        return this.rh;
    }

    public com.byazt.jx.c gu() {
        return this.gu;
    }

    public float i() {
        return this.m;
    }

    public int m() {
        return this.t;
    }

    public com.byazt.kd.da my() {
        return this.nu;
    }

    public long n() {
        return this.uj;
    }

    public int nu() {
        return this.sl;
    }

    public boolean qy() {
        return this.qy;
    }

    public int rh() {
        return this.da;
    }

    public com.byazt.kd.tt rl() {
        return this.my;
    }

    public c sl() {
        return this.n;
    }

    public String sp() {
        return this.sp;
    }

    public tt t() {
        return this.rl;
    }

    public String toString() {
        return c("");
    }

    public float tt() {
        return this.u;
    }

    public long u() {
        return this.f29245a;
    }

    public List<com.byazt.vc.c<Float>> uj() {
        return this.gt;
    }

    public float ve() {
        return this.yp / this.tt.rh();
    }

    public float x() {
        return this.z;
    }

    public List<com.byazt.jx.ve> yp() {
        return this.c;
    }

    public com.byazt.kd.t z() {
        return this.i;
    }

    public String c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(a());
        sb.append("\n");
        x xVarC = this.tt.c(u());
        if (xVarC != null) {
            sb.append("\t\tParents: ");
            sb.append(xVarC.a());
            x xVarC2 = this.tt.c(xVarC.u());
            while (xVarC2 != null) {
                sb.append(c25.j);
                sb.append(xVarC2.a());
                xVarC2 = this.tt.c(xVarC2.u());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!da().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(da().size());
            sb.append("\n");
        }
        if (rh() != 0 && nu() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(rh()), Integer.valueOf(nu()), Integer.valueOf(m())));
        }
        if (!this.c.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.byazt.jx.ve veVar : this.c) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(veVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
