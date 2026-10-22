package com.byazt.gp;

import android.text.TextUtils;
import com.byazt.nbs.da;
import com.byazt.qv.sp;
import com.byazt.vx.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2424, 13})
public class tt implements c {
    @Override // com.byazt.gp.c
    public boolean c(com.byazt.iz.tt ttVar, com.byazt.yl.ve veVar, List<da> list) {
        if (veVar == null || ttVar == null) {
            return false;
        }
        if (ttVar.nu().a(sp.c(ttVar.m(), veVar)) == 0) {
            return true;
        }
        return c(veVar, list);
    }

    public boolean c(com.byazt.yl.ve veVar, List<da> list) {
        if (veVar == null || TextUtils.isEmpty(veVar.getAdNetworkSlotId()) || !veVar.isNormalAd() || p.c(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !p.tt(arrayList) && veVar.getAdNetworkSlotId().equals(((da) arrayList.get(0)).rh());
    }
}
