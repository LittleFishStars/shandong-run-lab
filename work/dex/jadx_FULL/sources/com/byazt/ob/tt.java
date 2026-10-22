package com.byazt.ob;

import com.byazt.ete.ic;
import com.byazt.nc.da;
import com.byazt.omf.gt;
import com.byazt.pro.uj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1485, 13})
public class tt extends com.byazt.vvt.tt<List<da>> {
    public tt(com.byazt.iu.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.vvt.tt
    public /* bridge */ /* synthetic */ void c(com.byazt.dj.tt ttVar, List list, List<da> list2) {
        c2(ttVar, (List<ic>) list, list2);
    }

    @Override // com.byazt.vvt.tt
    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.vvt.tt.c<List<da>> cVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<ic> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new uj(gt.getContext(), it.next(), 6, ttVar));
        }
        if (cVar != null) {
            cVar.c(arrayList);
        }
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public void c2(com.byazt.dj.tt ttVar, List<ic> list, List<da> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ic icVar = list.get(i);
            da daVar = list2.get(i);
            com.byazt.iu.tt ttVar2 = this.c;
            if (ttVar2 != null) {
                ttVar2.tt().c(ttVar, icVar, (Object) daVar, false);
            }
        }
    }
}
