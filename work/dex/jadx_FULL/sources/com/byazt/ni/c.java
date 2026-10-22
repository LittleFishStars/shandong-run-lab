package com.byazt.ni;

import android.text.TextUtils;
import com.byazt.ix.uj;
import com.byazt.nbs.da;
import com.byazt.nbs.tt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2518, 20})
public class c {
    public static tt c(tt ttVar, String str) {
        if (ttVar == null || TextUtils.isEmpty(str) || ttVar.l() == null || ttVar.l().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (da daVar : ttVar.l()) {
            if (str.equals(daVar.rh())) {
                arrayList.add(daVar.n());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        da daVar2 = arrayList.get(0);
        if (daVar2 != null && daVar2.zb() && !MediationConstant.ADN_PANGLE.equals(daVar2.z())) {
            for (da daVar3 : ttVar.l()) {
                if (daVar3.zb() && MediationConstant.ADN_PANGLE.equals(daVar3.z())) {
                    arrayList.add(daVar3.n());
                    break;
                }
            }
        }
        tt ttVarRh = ttVar.rh();
        if (ttVarRh.yp()) {
            ttVarRh.tt(arrayList);
        } else {
            ttVarRh.c(arrayList);
        }
        da daVar4 = arrayList.get(0);
        daVar4.n(0);
        if (daVar4.my() == 0) {
            ttVarRh.uj(daVar4.gr());
        }
        if (daVar4.my() == 2) {
            ttVarRh.c(true);
        }
        if (daVar4.my() == 1 || daVar4.my() == 3) {
            ttVarRh.tt(true);
        }
        ttVarRh.yp(0);
        uj.c().c(ttVarRh.nb(), 0);
        com.byazt.hk.c.c().ve(ttVarRh.nb(), str, 0);
        return ttVarRh;
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
