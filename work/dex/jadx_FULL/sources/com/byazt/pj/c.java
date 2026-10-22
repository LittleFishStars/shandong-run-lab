package com.byazt.pj;

import android.graphics.Rect;
import android.view.View;
import com.byazt.cd.x;
import com.byazt.kt.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1693, 20})
public class c {
    public static int c = 0;
    public static int tt = 1;
    public n.c ve;
    public int uj = 60;
    public int n = tt;

    private int tt(View view) {
        int iC = (int) (((double) x.c(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iC);
    }

    public int c(RecyclerView recyclerView) {
        n.c cVar;
        View viewVe;
        n.c cVar2 = null;
        com.byazt.kt.n nVar = recyclerView.getLayoutManager() instanceof com.byazt.kt.n ? (com.byazt.kt.n) recyclerView.getLayoutManager() : null;
        if (nVar != null) {
            int iSl = nVar.sl();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iDa = nVar.da(); iDa <= iSl; iDa++) {
                Object objVe = recyclerView.ve(iDa);
                if ((objVe instanceof n.c) && (viewVe = (cVar = (n.c) objVe).ve()) != null && c(viewVe, this.uj)) {
                    if (this.n == c) {
                        cVar.Q_();
                        this.ve = cVar;
                        return iDa;
                    }
                    linkedHashMap.put(Integer.valueOf(iDa), cVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iTt = tt(((n.c) entry.getValue()).ve());
                if (iTt < i) {
                    n.c cVar3 = (n.c) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    cVar2 = cVar3;
                    i = iTt;
                }
            }
            n.c cVar4 = this.ve;
            if (cVar4 != cVar2) {
                if (cVar4 != null) {
                    cVar4.P_();
                }
                this.ve = cVar2;
            }
            n.c cVar5 = this.ve;
            if (cVar5 != null) {
                cVar5.Q_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void c() {
        n.c cVar = this.ve;
        if (cVar == null || cVar.ve() == null || c(this.ve.ve(), this.uj)) {
            return;
        }
        this.ve.P_();
    }

    private int c(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean c(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && c(view) >= i;
    }
}
