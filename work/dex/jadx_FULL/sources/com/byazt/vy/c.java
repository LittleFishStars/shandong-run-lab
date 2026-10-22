package com.byazt.vy;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.ix.sp;
import com.byazt.ll.tt;
import com.byazt.vx.h;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1870, 20})
public class c {
    public static volatile c tt;
    public final Map<Integer, CopyOnWriteArrayList<sp>> c = new ConcurrentHashMap();
    public final Comparator<sp> ve = new Comparator<sp>() { // from class: com.byazt.vy.c.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(sp spVar, sp spVar2) {
            ve veVar;
            if (spVar != null && spVar2 != null && (veVar = spVar.c) != null && spVar2.c != null) {
                if (veVar.getStrategyCpm() > spVar2.c.getStrategyCpm()) {
                    return -1;
                }
                if (spVar.c.getStrategyCpm() < spVar2.c.getStrategyCpm()) {
                    return 1;
                }
                if (spVar.c.getStrategyCpm() == spVar2.c.getStrategyCpm() && spVar.c.getAdNetworkPlatformId() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private c() {
    }

    public static c c() {
        if (tt == null) {
            synchronized (com.byazt.hk.c.class) {
                if (tt == null) {
                    tt = new c();
                }
            }
        }
        return tt;
    }

    private static boolean tt(List<ve> list, ve veVar) {
        for (ve veVar2 : list) {
            if (veVar != null && veVar2 == veVar) {
                return true;
            }
        }
        return false;
    }

    public synchronized void c(tt ttVar, List<ve> list) {
        if (com.byazt.bp.tt.tt().x()) {
            if (ttVar == null) {
                return;
            }
            if (ttVar.tk()) {
                return;
            }
            StringBuilder sb = new StringBuilder("广告位：");
            sb.append(ttVar.gt());
            sb.append("  type:");
            sb.append(ttVar.my());
            sb.append(" show后把二价广告放入公共缓存池 数量：");
            sb.append(list == null ? "没有二价" : Integer.valueOf(list.size()));
            com.byazt.eu.tt.uj(MediationConstant.TAG, sb.toString());
            if (list != null && !list.isEmpty()) {
                CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.c.get(Integer.valueOf(ttVar.my()));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                for (ve veVar : list) {
                    com.byazt.eu.tt.uj(MediationConstant.TAG, "广告位：" + ttVar.gt() + "  代码位：" + veVar.getAdNetworkSlotId() + "   adnName:" + veVar.getAdnName() + "  loadSort:" + veVar.getLoadSort() + "  showSort:" + veVar.getShowSort() + "  ecpm:" + veVar.getCpm());
                    if (!c(copyOnWriteArrayList, veVar)) {
                        copyOnWriteArrayList.add(new sp(veVar, 0L, ttVar));
                    }
                }
                for (sp spVar : copyOnWriteArrayList) {
                    if (!spVar.n()) {
                        copyOnWriteArrayList.remove(spVar);
                    }
                }
                h.c(copyOnWriteArrayList, this.ve);
                while (3 < copyOnWriteArrayList.size()) {
                    copyOnWriteArrayList.remove(3);
                }
                com.byazt.eu.tt.uj(MediationConstant.TAG, "广告位：" + ttVar.gt() + "  type:" + ttVar.my() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                this.c.put(Integer.valueOf(ttVar.my()), copyOnWriteArrayList);
            }
        }
    }

    public synchronized List<sp> c(tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.c.get(Integer.valueOf(ttVar.my()));
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            int iGr = ttVar.my() == 5 ? ttVar.gr() : 1;
            ArrayList arrayList = new ArrayList();
            for (sp spVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iGr) {
                    break;
                }
                if (spVar.sp() && spVar.c != null) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 公共缓存池，广告：" + spVar.tt() + "  adnName:" + spVar.c.getAdnName() + " showSort:" + spVar.c.getShowSort() + " 暂不可用， 已经被使用中...");
                }
                if (c(ttVar, spVar.uj()) && spVar.n() && !spVar.sp()) {
                    arrayList.add(spVar);
                    copyOnWriteArrayList.remove(spVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((sp) it.next()).tt(true);
            }
            return arrayList;
        }
        return null;
    }

    public static List<ve> c(tt ttVar, List<ve> list, List<ve> list2) {
        if (!com.byazt.bp.tt.tt().x() || ttVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int iGr = ttVar.my() == 5 ? ttVar.gr() : 1;
        ArrayList arrayList = new ArrayList();
        for (ve veVar : list2) {
            if (!tt(list, veVar)) {
                if (arrayList.size() >= iGr) {
                    break;
                }
                if (!veVar.isCustomAd() && !veVar.isServerBiddingAd() && (!veVar.isNormalAd() || veVar.getStrategyCpm() > AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    arrayList.add(veVar);
                }
            }
        }
        return arrayList;
    }

    private boolean c(List<sp> list, ve veVar) {
        for (sp spVar : list) {
            if (spVar != null && veVar != null && spVar.c == veVar) {
                return true;
            }
        }
        return false;
    }

    private boolean c(tt ttVar, tt ttVar2) {
        if (ttVar == null || ttVar2 == null || ttVar.my() != ttVar2.my()) {
            return false;
        }
        if ((ttVar.my() == 7 || ttVar.my() == 10) && ttVar.d() == ttVar2.d()) {
            return true;
        }
        return (ttVar.my() == 1 || ttVar.my() == 5) && ttVar.qy() == ttVar2.qy() && ttVar.gu() == ttVar2.gu();
    }

    public static void c(tt ttVar, String str) {
        if (TextUtils.isEmpty(str) || ttVar == null) {
            return;
        }
        if (TextUtils.isEmpty(ttVar.da())) {
            ttVar.ve(ttVar.gt());
        }
        if (str.equals(ttVar.gt())) {
            return;
        }
        com.byazt.dj.tt.c cVar = new com.byazt.dj.tt.c(new com.byazt.dj.tt(ttVar.qp(), com.byazt.vxy.c.tt()));
        cVar.uj(str);
        ttVar.c(com.byazt.ch.c.c(cVar.c()));
    }
}
