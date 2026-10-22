package com.byazt.oj;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 13})
public class tt implements com.byazt.tm.n {
    public List<uj> c = new ArrayList();

    public tt(View view, List<com.byazt.aq.c> list) {
        Iterator<com.byazt.aq.c> it = list.iterator();
        while (it.hasNext()) {
            uj ujVarC = ve.c().c(view, it.next());
            if (ujVarC != null) {
                this.c.add(ujVarC);
            }
        }
    }

    public void c() {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                it.next().ve();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.byazt.tm.n
    public void tt() {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                it.next().tt();
            } catch (Exception unused) {
            }
        }
    }
}
