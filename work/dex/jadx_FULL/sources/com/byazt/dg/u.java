package com.byazt.dg;

import android.graphics.Path;
import com.byazt.zy.my;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 67})
public class u extends c<com.byazt.jx.yp, Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<my> f28399a;
    public final Path n;
    public final com.byazt.jx.yp uj;

    public u(List<com.byazt.vc.c<com.byazt.jx.yp>> list) {
        super(list);
        this.uj = new com.byazt.jx.yp();
        this.n = new Path();
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public Path c(com.byazt.vc.c<com.byazt.jx.yp> cVar, float f) {
        this.uj.c(cVar.c, cVar.tt, f);
        com.byazt.jx.yp ypVarC = this.uj;
        List<my> list = this.f28399a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ypVarC = this.f28399a.get(size).c(ypVarC);
            }
        }
        com.byazt.kk.i.c(ypVarC, this.n);
        return this.n;
    }

    public void c(List<my> list) {
        this.f28399a = list;
    }
}
