package com.byazt.bl;

import android.graphics.Bitmap;
import com.byazt.yj.eo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 177, 15})
public class uj implements eo {
    public final eo c;
    public final com.byazt.ep.tt tt;

    public uj(eo eoVar) {
        this(eoVar, null);
    }

    public uj(eo eoVar, com.byazt.ep.tt ttVar) {
        this.c = eoVar;
        this.tt = ttVar;
    }

    @Override // com.byazt.yj.c
    public boolean tt(String str) {
        return this.c.tt(str);
    }

    @Override // com.byazt.yj.c
    public boolean c(String str, Bitmap bitmap) {
        return this.c.c(str, bitmap);
    }

    @Override // com.byazt.yj.c
    public Bitmap c(String str) {
        return this.c.c(str);
    }

    @Override // com.byazt.yj.c
    public void c() {
        this.c.c();
    }

    @Override // com.byazt.yj.c
    public void c(double d) {
        this.c.c(d);
    }
}
