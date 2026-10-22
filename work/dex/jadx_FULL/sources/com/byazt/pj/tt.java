package com.byazt.pj;

import android.graphics.Rect;
import android.view.View;
import com.byazt.kt.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1693, 13})
public abstract class tt extends RecyclerView.yp {
    public boolean c = false;
    public c tt;
    public int ve;

    public tt(c cVar) {
        this.tt = cVar;
    }

    public abstract void c();

    public abstract void c(int i, int i2);

    public abstract void c(int i, View view);

    @Override // com.byazt.kt.RecyclerView.yp
    public void c(RecyclerView recyclerView, int i) {
        super.c(recyclerView, i);
        com.byazt.kt.n nVar = (com.byazt.kt.n) recyclerView.getLayoutManager();
        if (i == 0) {
            int iSl = nVar.sl();
            if (!c(nVar.tt(iSl), 50)) {
                iSl--;
            }
            int iMax = Math.max(0, Math.max(iSl, this.ve));
            for (int iMin = Math.min(this.ve, iSl); iMin <= iMax; iMin++) {
                c(iMin, nVar.tt(iMin));
            }
            this.ve = iSl;
            int iH = nVar.h();
            this.tt.c(recyclerView);
            if ((iSl == iH - 1 && this.c) || iH == 1) {
                c();
            }
        }
        tt(recyclerView, i);
    }

    public abstract void tt(RecyclerView recyclerView, int i);

    private int c(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean c(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && c(view) >= i;
    }

    @Override // com.byazt.kt.RecyclerView.yp
    public void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        if (i2 == 0) {
            com.byazt.kt.n nVar = (com.byazt.kt.n) recyclerView.getLayoutManager();
            this.ve = nVar.da();
            int iSl = nVar.sl();
            if (!c(nVar.tt(iSl), 50)) {
                iSl--;
            }
            int iMax = Math.max(0, Math.max(iSl, this.ve));
            for (int i3 = this.ve; i3 <= iMax; i3++) {
                c(i3, nVar.tt(i3));
            }
        }
        this.c = i2 > 0;
        this.tt.c();
        c(i, i2);
    }
}
