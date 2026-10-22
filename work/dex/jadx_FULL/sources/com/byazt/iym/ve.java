package com.byazt.iym;

import android.content.Context;
import android.view.View;
import com.byazt.kt.RecyclerView;
import com.byazt.kt.i;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 54})
public class ve extends com.byazt.kt.n {
    public c gr;
    public int gt;
    public int gu;
    public final i my;
    public boolean qy;
    public boolean rh;
    public int rl;
    public final RecyclerView.sl zm;

    public interface c {
        void c();

        void c(boolean z, int i);

        void c(boolean z, int i, boolean z2);
    }

    public ve(Context context, int i, boolean z) {
        super(context, i, z);
        this.qy = false;
        this.rh = true;
        this.zm = new RecyclerView.sl() { // from class: com.byazt.iym.ve.1
            @Override // com.byazt.kt.RecyclerView.sl
            public void c(View view) {
                if (ve.this.gr == null || ve.this.my() != 1) {
                    return;
                }
                ve.this.gr.c();
            }

            @Override // com.byazt.kt.RecyclerView.sl
            public void tt(View view) {
                if (ve.this.gr != null) {
                    ve.this.gr.c(ve.this.gt >= 0, ve.this.uj(view));
                }
            }
        };
        this.my = new i();
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void sl(int i) {
        boolean z;
        c cVar;
        this.rl = i;
        if (i == 0) {
            View viewC = this.my.c(this);
            if (viewC != null) {
                int iUj = uj(viewC);
                z = this.gu == iUj;
                this.gu = iUj;
            } else {
                z = true;
            }
            if (this.qy) {
                this.qy = false;
                if (!z && (cVar = this.gr) != null) {
                    boolean z2 = this.gt >= 0;
                    int i2 = this.gu;
                    cVar.c(z2, i2, i2 == h() - 1);
                }
            }
        }
        if (i == 2) {
            this.qy = true;
        }
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void ve(RecyclerView recyclerView) {
        super.ve(recyclerView);
        this.my.c(recyclerView);
        recyclerView.c(this.zm);
    }

    @Override // com.byazt.kt.n, com.byazt.kt.RecyclerView.i
    public void c(RecyclerView recyclerView, RecyclerView.m mVar) {
        super.c(recyclerView, mVar);
        try {
            n nVar = (n) recyclerView.ve(this.gu);
            if (nVar != null) {
                nVar.h();
            }
        } catch (Exception e) {
            m.ve("cubic detached exception:" + e.getMessage());
        }
    }

    public void tt(boolean z) {
        this.rh = z;
    }

    @Override // com.byazt.kt.n, com.byazt.kt.RecyclerView.i
    public int tt(int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        this.gt = i;
        return super.tt(i, mVar, gtVar);
    }

    @Override // com.byazt.kt.n, com.byazt.kt.RecyclerView.i
    public int c(int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        this.gt = i;
        return super.c(i, mVar, gtVar);
    }

    public void c(c cVar) {
        this.gr = cVar;
    }
}
