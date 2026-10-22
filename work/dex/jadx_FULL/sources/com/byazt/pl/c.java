package com.byazt.pl;

import android.text.TextUtils;
import com.byazt.nbs.da;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 86, 20})
public class c {
    public static Map<String, C0503c> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.byazt.pl.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 86, 44})
    public static class C0503c {
        public String c;
        public String tt;
        public Map<String, String> uj;
        public double ve;

        public C0503c(String str, String str2, double d, Map<String, String> map) {
            this.c = str2;
            this.ve = d;
            this.uj = map;
            this.tt = str;
        }
    }

    public static void c(com.byazt.ll.tt ttVar, da daVar, Map<String, Object> map) {
        C0503c c0503c;
        if (ttVar == null || daVar == null || map == null || !daVar.or() || !"baidu".equals(daVar.z()) || (c0503c = c.get(ttVar.gt())) == null) {
            return;
        }
        map.put(MediationConstant.BIDDING_WIN_ADN, c0503c.c);
        map.put(MediationConstant.BIDDING_WIN_PRICE, Double.valueOf(c0503c.ve));
        Boolean boolValueOf = Boolean.valueOf(com.byazt.bp.tt.tt().y());
        map.put(MediationConstant.BIDDING_IS_OPEN_ECPM, boolValueOf);
        if (boolValueOf.booleanValue()) {
            map.put(MediationConstant.BIDDING_REQUEST_ID_MAP, c0503c.uj);
            map.put(MediationConstant.BIDDING_WIN_ADN_ID, c0503c.tt);
        }
    }

    public static void c(com.byazt.ll.tt ttVar, com.byazt.nbs.tt ttVar2, List<com.byazt.yl.ve> list, List<com.byazt.yl.ve> list2) {
        HashMap map;
        com.byazt.yl.ve next;
        if (ttVar == null || ttVar2 == null || list == null || list.size() == 0 || !ttVar.or() || !c(ttVar2)) {
            return;
        }
        Iterator<com.byazt.yl.ve> it = list.iterator();
        while (true) {
            map = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && "baidu".equals(next.getAdNetWorkName())) {
                break;
            }
        }
        if (next == null) {
            next = list.get(0);
        }
        if (next != null) {
            if (com.byazt.bp.tt.tt().y() && (list2 != null || list2.size() != 0)) {
                map = new HashMap();
                for (com.byazt.yl.ve veVar : list2) {
                    map.put(veVar.getAdNetworkSlotId(), veVar.getReqId());
                }
            }
            c.put(ttVar2.nb(), new C0503c(next.getAdNetworkSlotId(), next.getAdNetWorkName(), next.getCpm(), map));
        }
    }

    private static boolean c(com.byazt.nbs.tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        for (da daVar : ttVar.l()) {
            if (TextUtils.equals(daVar.z(), "baidu") && daVar.or()) {
                return true;
            }
        }
        return false;
    }
}
