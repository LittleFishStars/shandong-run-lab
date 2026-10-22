package com.byazt.hy;

import android.graphics.Bitmap;
import com.byazt.omf.sp;
import com.byazt.ukr.yp;
import com.byazt.yj.gr;
import com.byazt.yj.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 604, 54})
public class ve implements gr<Bitmap> {
    public boolean c;
    public com.byazt.qal.tt tt;

    public ve(boolean z) {
        this.c = z;
        if (z) {
            this.tt = com.byazt.qal.tt.tt();
        }
    }

    public void c(String str) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.ve(str);
    }

    @Override // com.byazt.yj.gr
    public void onFailed(int i, String str, Throwable th) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.tt(201).sp(sp.c(201));
        yp.c().c(this.tt);
    }

    @Override // com.byazt.yj.gr
    public void onSuccess(m<Bitmap> mVar) {
        if (!this.c || this.tt == null) {
            return;
        }
        if (mVar == null || mVar.getResult() == null) {
            this.tt.tt(202).sp(sp.c(202));
            yp.c().c(this.tt);
        }
    }

    public void tt(String str) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.a(str);
    }

    public void uj(String str) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.x(str);
    }

    public void ve(String str) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.uj(str);
    }

    public void c(int i) {
        com.byazt.qal.tt ttVar;
        if (!this.c || (ttVar = this.tt) == null) {
            return;
        }
        ttVar.c(i);
    }
}
