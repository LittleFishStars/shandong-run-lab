package com.byazt.fid;

import android.os.SystemClock;
import com.byazt.eu.uj;
import com.byazt.hr.sl;
import com.byazt.hr.t;
import com.byazt.hr.ve;
import com.byazt.hr.yp;
import com.byazt.ix.sp;
import com.byazt.nbs.da;
import com.byazt.nbs.tt;
import com.byazt.ng.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2504, 20})
public class c {
    public static boolean c(tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        int iPf = ttVar.pf();
        Map<String, Integer> mapOs = com.byazt.bp.tt.tt().os();
        if (mapOs == null) {
            return false;
        }
        Integer num = mapOs.get(String.valueOf(iPf));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapOs.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean tt(tt ttVar) {
        if (ttVar == null) {
            return false;
        }
        int iPf = ttVar.pf();
        Map<String, Integer> mapOz = com.byazt.bp.tt.tt().oz();
        if (mapOz == null) {
            return false;
        }
        Integer num = mapOz.get(String.valueOf(iPf));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapOz.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0054 A[SYNTHETIC] */
    public static boolean c(com.byazt.iz.tt ttVar, List<Integer> list, Map<Integer, List<da>> map) {
        if (ttVar != null && ttVar.gu() != null) {
            String strGt = ttVar.gu().gt();
            if (list != null && list.size() != 0 && map != null && map.size() != 0) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    List<da> list2 = map.get(Integer.valueOf(it.next().intValue()));
                    if (list2 != null && list2.size() != 0) {
                        for (da daVar : list2) {
                            if (daVar != null) {
                                if (daVar.uj() && !sl.c().ve(strGt, daVar.rh())) {
                                    com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "adn 请求触发次数拦截............");
                                } else if (daVar.uj() && !t.c().ve(strGt, daVar.rh())) {
                                    com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "adn 请求触发时间间隔拦截............");
                                } else if (yp.c().c(strGt, daVar.nu())) {
                                    if (yp.c().c(strGt, daVar.z(), daVar.rh()) != null) {
                                        com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "adn rit_level 请求触发了错误码拦截............");
                                    } else {
                                        c(ttVar, daVar, list2.size());
                                        if (ttVar.my()) {
                                            com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "回溯到了满足数量的广告.......有广告回调成功");
                                            return true;
                                        }
                                    }
                                } else if (ve.c().c(daVar.z(), daVar.rh()) != null) {
                                    com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "adn 请求触发了错误码拦截............");
                                } else {
                                    c(ttVar, daVar, list2.size());
                                    if (ttVar.my()) {
                                        com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "回溯到了满足数量的广告.......有广告回调成功");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (ttVar.sl().size() <= 0 && ttVar.t().size() <= 0 && ttVar.yp().size() <= 0) {
                    return false;
                }
                com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "回溯到了广告.......有广告回调成功");
                return true;
            }
        }
        return false;
    }

    public static void c(com.byazt.iz.tt ttVar, da daVar, int i) {
        if (ttVar == null || ttVar.gu() == null || daVar == null) {
            return;
        }
        com.byazt.ll.tt ttVarGu = ttVar.gu();
        String strGt = ttVarGu.gt();
        com.byazt.eu.tt.tt(MediationConstant.TAG, uj.c(strGt) + "----------总超时后尝试从复用池中查找广告：id:" + daVar.rh() + "   loadSort:" + daVar.yv() + "  showSort:" + daVar.p() + "   adnName:" + daVar.z());
        String strRh = daVar.rh();
        if (daVar.gt() && com.byazt.hk.c.c().uj(strGt, strRh, ttVarGu.n()) && com.byazt.hk.c.c().c(strRh, ttVarGu, true) == 3) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, uj.c(strGt) + "----------可复用：id:" + daVar.rh() + "   loadSort:" + daVar.yv() + "  showSort:" + daVar.p() + "   adnName:" + daVar.z());
            com.byazt.hk.c.c().c(strGt, strRh, daVar, i);
            List<sp> listC = com.byazt.hk.c.c().c(strRh, ttVarGu, ttVarGu.n());
            if (listC == null || listC.size() <= 0) {
                return;
            }
            int mediationRitReqType = listC.get(0).c.getMediationRitReqType(ttVarGu.c());
            a.c(daVar, ttVarGu, com.byazt.hk.c.c().c(strRh), !ttVar.yv(), 4, i, 3, mediationRitReqType, null, -1L, ttVar.n(), true, SystemClock.elapsedRealtime() - ttVar.cu());
            com.byazt.tjo.a.c(ttVar.ve(), ttVar.c(daVar), ttVar.cu());
            ArrayList arrayList = new ArrayList();
            for (sp spVar : listC) {
                spVar.c.setMediationRitReqType(3);
                spVar.c.setMediationRitReqTypeSrc(mediationRitReqType);
                spVar.c.setTimeoutFill(ttVar.n());
                spVar.c.setIsCallback(true);
                c(strGt, spVar.c, strRh);
                arrayList.add(spVar.c);
            }
            a.c(listC.get(0).c, 0, "adn cache命中", 0L, ttVarGu, i, arrayList.size(), 4, null, 0L, -1L);
            com.byazt.tjo.a.c(ttVar.ve(), ttVar.tt(daVar), ttVar.cu());
            com.byazt.qv.c.c(ttVar, arrayList, true);
            com.byazt.yl.ve veVar = arrayList.get(0);
            if (veVar.isPAd()) {
                ttVar.tt(arrayList);
                for (com.byazt.yl.ve veVar2 : arrayList) {
                    com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + ttVar.sl().size() + ",slotId：" + veVar2.getAdNetworkSlotId() + ",广告类型：" + veVar2.getAdNetWorkName() + ",loadSort=" + veVar2.getLoadSort() + ",showSort=" + veVar2.getShowSort() + ",CPM=" + veVar2.getCpm());
                }
                return;
            }
            if (veVar.isNormalAd()) {
                ttVar.tt(arrayList);
                for (com.byazt.yl.ve veVar3 : arrayList) {
                    com.byazt.eu.tt.c(MediationConstant.TAG, uj.c(strGt) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + ttVar.t().size() + ",slotId：" + veVar3.getAdNetworkSlotId() + ",广告类型：" + veVar3.getAdNetWorkName() + ",loadSort=" + veVar3.getLoadSort() + ",showSort=" + veVar3.getShowSort() + ",CPM=" + veVar3.getCpm());
                }
            }
        }
    }

    private static void c(String str, com.byazt.yl.ve veVar, String str2) {
        da daVarN = com.byazt.hk.c.c().n(str, str2);
        if (veVar == null || daVarN == null) {
            return;
        }
        veVar.setLoadSort(daVarN.yv());
        veVar.setShowSort(daVarN.p());
        veVar.setExchangeRate(daVarN.yp());
        veVar.setDiscount(daVarN.gu());
        veVar.setAdNetworkSlotType(daVarN.my());
        veVar.setCpm(daVarN.gr());
        veVar.setSubAdType(daVarN.a());
    }
}
