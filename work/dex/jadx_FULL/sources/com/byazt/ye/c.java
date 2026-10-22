package com.byazt.ye;

import android.text.TextUtils;
import com.byazt.eu.uj;
import com.byazt.nbs.da;
import com.byazt.nbs.tt;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2105, 20})
public class c {
    public static void c(tt ttVar, com.byazt.iz.tt ttVar2, List<da> list) {
        boolean z;
        if (ttVar == null || ttVar2 == null || list == null || list.size() == 0) {
            return;
        }
        for (ve veVar : ttVar2.t()) {
            Iterator<da> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                da next = it.next();
                if (veVar != null && next != null && veVar.getAdNetworkSlotId().equals(next.rh())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, uj.c(ttVar) + "已经响应的广告: " + veVar.getAdNetworkSlotId() + "  没有在severBidding的waterFall列表中，需要被移除掉");
                ttVar2.t().remove(veVar);
                ttVar2.u().add(veVar);
            }
        }
        com.byazt.eu.tt.uj(MediationConstant.TAG, uj.c(ttVar) + "已经响应的广告被serverBidding过滤完还剩: " + ttVar2.t().size());
    }

    public static boolean c(com.byazt.iz.c cVar, List<da> list, String str) {
        if (list == null || cVar == null || TextUtils.isEmpty(str) || cVar.tt() != 1) {
            return false;
        }
        Iterator<da> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().rh())) {
                return false;
            }
        }
        return true;
    }
}
