package com.byazt.hk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.db.tt;
import com.byazt.eu.n;
import com.byazt.ix.sp;
import com.byazt.nbs.da;
import com.byazt.nbs.i;
import com.byazt.ng.a;
import com.byazt.nr.m;
import com.byazt.vx.h;
import com.byazt.vx.yv;
import com.byazt.yf.sl;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2109, 20})
public class c extends com.byazt.yt.c {
    public static volatile c x;
    public final String[] c = {MediationConstant.ADN_UNITY, MediationConstant.ADN_KS};
    public final Map<String, Integer> tt = new HashMap();
    public final Map<String, Integer> ve = new HashMap();
    public final Map<String, CopyOnWriteArrayList<sp>> uj = new ConcurrentHashMap();
    public final Map<String, da> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f28606a = new HashMap();
    public final Map<String, Integer> sp = new HashMap();
    public final Comparator<sp> i = new Comparator<sp>() { // from class: com.byazt.hk.c.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(sp spVar, sp spVar2) {
            ve veVar;
            if (spVar == null || spVar2 == null || (veVar = spVar.c) == null || spVar2.c == null) {
                return 0;
            }
            return ((int) veVar.getFillTime()) - ((int) spVar2.c.getFillTime());
        }
    };

    /* JADX INFO: renamed from: com.byazt.hk.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 2109, 44})
    public class C0421c implements tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f28609a;
        public int c;
        public com.byazt.dv.tt n;
        public long sp = System.currentTimeMillis();
        public da uj;
        public final com.byazt.ll.tt ve;

        public C0421c(com.byazt.ll.tt ttVar, da daVar, com.byazt.dv.tt ttVar2, i iVar, int i) {
            this.ve = ttVar;
            this.uj = daVar;
            this.n = ttVar2;
            this.c = i;
            this.f28609a = iVar;
        }

        @Override // com.byazt.db.tt
        public void nativeDislikeClick(ve veVar, String str) {
        }

        @Override // com.byazt.db.tt
        public void notifyLoadFail(com.byazt.pp.c cVar) {
            if (cVar != null && this.uj != null) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load失败 --- " + this.uj.nu() + ", " + this.uj.rh() + ", " + com.byazt.yl.c.c(this.uj.u(), this.uj.a()) + ", errCode: " + cVar.ve + ",msg=" + cVar.uj);
                cVar.c("is_dex_adapter", Integer.valueOf(this.n.pf() ? 1 : 0));
            }
            a.c(cVar, this.ve, this.uj, this.c, 4, 1, c.c().c(this.uj.rh()), System.currentTimeMillis() - this.sp, (String) null, (String) null, (String) null, 0L);
        }

        @Override // com.byazt.db.tt
        public void notifyLoadSuccess(List<ve> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ve veVar : list) {
                if (veVar != null) {
                    da daVar = this.uj;
                    com.byazt.qv.ve.c(veVar, this.ve, this.n, this.f28609a, daVar != null ? c.this.c(daVar.rh()) : "");
                    veVar.setFillTime(SystemClock.elapsedRealtime());
                    arrayList.add(new sp(veVar, 0L, this.ve));
                }
            }
            if (arrayList.size() > 0) {
                ve veVar2 = ((sp) arrayList.get(0)).c;
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load成功 --- " + veVar2.getAdNetWorkName() + ", adType: " + com.byazt.yl.c.c(veVar2.getAdType(), veVar2.getSubAdType()) + ", adnSlotId: " + veVar2.getAdNetworkSlotId() + ", ad个数: " + arrayList.size());
                c.this.c(veVar2.getAdNetworkSlotId(), (List<sp>) arrayList, false);
            }
            a.c(list.get(0), 20000, "load success", System.currentTimeMillis() - this.sp, this.ve, this.c, list.size(), 0, null, -1L, -1L);
        }

        @Override // com.byazt.db.tt
        public void notifyVideoCache(List<ve> list, com.byazt.pp.c cVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (ve veVar : list) {
                da daVar = this.uj;
                com.byazt.qv.ve.c(veVar, this.ve, this.n, this.f28609a, daVar != null ? c.this.c(daVar.rh()) : "");
                veVar.setCacheSuccess(true);
            }
            ve veVar2 = list.get(0);
            if (veVar2 != null) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告cache成功 --- " + veVar2.getAdNetWorkName() + ", adType: " + com.byazt.yl.c.c(veVar2.getAdType(), veVar2.getSubAdType()) + ", adnSlotId: " + veVar2.getAdNetworkSlotId() + ", ad个数: " + list.size());
            }
            a.c(this.ve, veVar2, this.uj);
        }
    }

    private c() {
    }

    public void a(String str, String str2, int i) {
        this.ve.put(str + LoginConstants.UNDER_LINE + str2, Integer.valueOf(i));
    }

    public int n(String str, String str2, int i) {
        if (i == 2) {
            return 0;
        }
        Integer num = this.tt.get(str + LoginConstants.UNDER_LINE + str2);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void tt() {
        n.c(new Runnable() { // from class: com.byazt.hk.c.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int iGr;
                String strGt;
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用lowMemory，start clean");
                int i2 = 0;
                int i3 = 0;
                for (Map.Entry entry : c.this.uj.entrySet()) {
                    List<sp> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理前, 缓存总数: " + list.size());
                        int i4 = 1;
                        int i5 = 0;
                        for (sp spVar : list) {
                            if (spVar != null && spVar.c != null) {
                                if (spVar.uj() != null) {
                                    strGt = spVar.uj().gt();
                                    iGr = spVar.uj().gr();
                                } else {
                                    iGr = i4;
                                    strGt = "";
                                }
                                if (spVar.c.isHasShown() || !spVar.c.isReady(strGt)) {
                                    list.remove(spVar);
                                    i5++;
                                }
                                i4 = iGr;
                            }
                        }
                        if (list.size() > i4) {
                            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理无效广告后仍需清理，缓存总数: " + list.size() + "，adCount: " + i4 + ", invalidCnt: " + i5);
                            i = 0;
                            for (sp spVar2 : list) {
                                if (list.size() <= i4) {
                                    break;
                                }
                                list.remove(spVar2);
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理后，缓存总数: " + list.size() + ", adCount: " + i4 + ", invalidCnt: " + i5 + ", foceCleanCnt：" + i);
                        i2 += i5;
                        i3 += i;
                    }
                    yv.c(i2, i3);
                }
            }
        });
    }

    public boolean uj(String str, String str2, int i) {
        if (i == 2) {
            return false;
        }
        Integer num = this.tt.get(str + LoginConstants.UNDER_LINE + str2);
        return num != null && (num.intValue() == 1 || num.intValue() == 2);
    }

    public void ve(String str, String str2, int i) {
        this.tt.put(str + LoginConstants.UNDER_LINE + str2, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<sp>> tt(List<ve> list, String str, com.byazt.ll.tt ttVar, int i, ve veVar) {
        HashMap map = new HashMap();
        for (ve veVar2 : list) {
            if (veVar2 != null && veVar2 != veVar) {
                veVar2.setUseFromCache(false);
            }
            if (veVar2 != null && veVar2 != veVar && n(str, veVar2.getAdNetworkSlotId(), i) == 2 && veVar2.isReady(str) && !veVar2.isHasShown()) {
                List list2 = (List) map.get(veVar2.getAdNetworkSlotId());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new sp(veVar2, 0L, ttVar));
                    map.put(veVar2.getAdNetworkSlotId(), arrayList);
                } else {
                    list2.add(new sp(veVar2, 0L, ttVar));
                }
            }
        }
        return map;
    }

    public boolean ve(String str, String str2) {
        Integer num = this.ve.get(str + LoginConstants.UNDER_LINE + str2);
        return num != null && num.intValue() == 1;
    }

    public da n(String str, String str2) {
        return this.n.get(str + LoginConstants.UNDER_LINE + str2);
    }

    public void uj(String str, String str2) {
        this.f28606a.put(str, str2);
    }

    public static c c() {
        if (x == null) {
            synchronized (c.class) {
                if (x == null) {
                    x = new c();
                }
            }
        }
        return x;
    }

    public void ve() {
        this.uj.clear();
    }

    public void c(String str, String str2, da daVar, int i) {
        if (daVar != null) {
            this.n.put(str + LoginConstants.UNDER_LINE + str2, daVar);
        }
        this.sp.put(str2, Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int tt(String str, com.byazt.ll.tt ttVar, boolean z) {
        boolean zC;
        int i;
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.uj.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String strGt = ttVar != null ? ttVar.gt() : "";
            ArrayList arrayList = new ArrayList();
            sp spVar = null;
            Object[] objArr = false;
            for (sp spVar2 : copyOnWriteArrayList) {
                Integer numIsReadyStatus = spVar2.c.isReadyStatus();
                int iIntValue = numIsReadyStatus != null ? numIsReadyStatus.intValue() : 0;
                if (iIntValue == 4) {
                    zC = c(strGt, spVar2.c);
                } else {
                    zC = iIntValue != 2;
                }
                if (!zC) {
                    if (com.byazt.yt.c.c(spVar2.uj(), ttVar, spVar2.c)) {
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:复用成功：--------" + spVar2.c.getAdNetWorkName() + ", adSlotId: " + str);
                        objArr = true;
                    } else {
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:AdSlot不符合 -------: " + spVar2.c.getAdNetWorkName() + ", adSlotId: " + str);
                        i = 6;
                    }
                } else {
                    copyOnWriteArrayList.remove(spVar2);
                    com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:广告过期了 -------: " + spVar2.c.getAdNetWorkName() + ", adSlotId: " + str);
                    i = 5;
                }
                if (spVar == null) {
                    spVar = spVar2;
                }
                com.byazt.ix.c cVar = new com.byazt.ix.c();
                cVar.uj(spVar2.c.getLoadSort());
                cVar.n(spVar2.c.getShowSort());
                cVar.tt(spVar2.c.getAdNetworkSlotId());
                cVar.tt(i);
                cVar.c(spVar2.c.isHasShown() ? 1 : 0);
                arrayList.add(cVar);
            }
            if (objArr == true) {
                return 3;
            }
            if (z && spVar != null) {
                a.c(ttVar, spVar.c, c(arrayList));
            }
            return 2;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    public String c(String str) {
        return this.f28606a.get(str);
    }

    public void c(final String str, final com.byazt.ll.tt ttVar, final Map<String, Object> map, final boolean z, final sl slVar, final i iVar, final Context context) {
        n.c(new Runnable() { // from class: com.byazt.hk.c.2
            @Override // java.lang.Runnable
            public void run() {
                String adNetWorkName;
                String strC;
                sp spVar;
                List<sp> list = (List) c.this.uj.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (sp spVar2 : list) {
                        if (spVar2 != null && spVar2.c.isHasShown()) {
                            list.remove(spVar2);
                            arrayList.add(spVar2);
                        }
                    }
                }
                boolean z2 = false;
                if (com.byazt.eu.tt.tt()) {
                    if (arrayList.size() <= 0 || (spVar = (sp) arrayList.get(0)) == null) {
                        adNetWorkName = "";
                        strC = adNetWorkName;
                    } else {
                        strC = com.byazt.yl.c.c(spVar.c.getAdType(), spVar.c.getSubAdType());
                        adNetWorkName = spVar.c.getAdNetWorkName();
                    }
                    StringBuilder sb = new StringBuilder("--==-- 广告复用:show时缓存移除 -----：");
                    sb.append(adNetWorkName);
                    sb.append(", ");
                    sb.append(strC);
                    sb.append(", ");
                    sb.append(str);
                    sb.append(arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0");
                    com.byazt.eu.tt.c(MediationConstant.TAG, sb.toString());
                }
                com.byazt.ll.tt ttVar2 = ttVar;
                String strGt = ttVar2 != null ? ttVar2.gt() : "";
                com.byazt.ll.tt ttVar3 = ttVar;
                int iMy = ttVar3 != null ? ttVar3.my() : 0;
                com.byazt.ll.tt ttVar4 = ttVar;
                boolean z3 = ttVar4 == null || ttVar4.my() == 1;
                if (!com.byazt.bp.tt.tt().c(strGt, str, iMy) && z) {
                    z2 = true;
                }
                if (!ttVar.tk() && z2 && !z3 && c.this.ve(strGt, str)) {
                    c.this.c(str, ttVar, (Map<String, Object>) map, context, slVar, iVar);
                    return;
                }
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + str);
            }
        });
    }

    public void c(final List<ve> list, final String str, final com.byazt.ll.tt ttVar, final int i, final ve veVar) {
        if (list == null || list.isEmpty() || ttVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        n.c(new Runnable() { // from class: com.byazt.hk.c.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : c.this.tt(list, str, ttVar, i, veVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<sp> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        c.this.c(str2, list2, true);
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用，show后放回复用池：adnSlotId:" + str2 + ", 个数：" + list2.size());
                    }
                }
            }
        });
    }

    public void c(String str, List<sp> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.uj.get(str);
        if (copyOnWriteArrayList != null) {
            for (sp spVar : list) {
                if (!c(copyOnWriteArrayList, spVar)) {
                    copyOnWriteArrayList.add(spVar);
                }
            }
        } else {
            this.uj.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z) {
            h.c(this.uj.get(str), this.i);
        }
    }

    private boolean c(List<sp> list, sp spVar) {
        for (sp spVar2 : list) {
            if (spVar2 != null && spVar != null && spVar2.c == spVar.c) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<sp> c(String str, com.byazt.ll.tt ttVar, int i) {
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.uj.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int iGr = ttVar != null ? ttVar.gr() : 1;
        ArrayList arrayList = new ArrayList();
        int iN = n(ttVar != null ? ttVar.gt() : "", str, i);
        if (iN == 1) {
            for (int i2 = 0; arrayList.size() < iGr && i2 < copyOnWriteArrayList.size(); i2++) {
                if (!copyOnWriteArrayList.get(i2).ve() && com.byazt.yt.c.c(copyOnWriteArrayList.get(i2).uj(), ttVar, copyOnWriteArrayList.get(i2).c)) {
                    arrayList.add(copyOnWriteArrayList.get(i2));
                }
            }
            for (int i3 = 0; arrayList.size() < iGr && i3 < copyOnWriteArrayList.size(); i3++) {
                if (copyOnWriteArrayList.get(i3).ve() && com.byazt.yt.c.c(copyOnWriteArrayList.get(i3).uj(), ttVar, copyOnWriteArrayList.get(i3).c)) {
                    arrayList.add(copyOnWriteArrayList.get(i3));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((sp) it.next()).c(true);
            }
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 复用模式1，不从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        } else if (iN == 2) {
            for (sp spVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iGr) {
                    break;
                }
                if (spVar.sp() && spVar.c != null) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 复用模式2，广告：" + spVar.tt() + "  adnName:" + spVar.c.getAdnName() + " showSort:" + spVar.c.getShowSort() + " 暂不可用， 已经被使用中...");
                }
                if (com.byazt.yt.c.c(spVar.uj(), ttVar, spVar.c) && !spVar.sp()) {
                    copyOnWriteArrayList.remove(spVar);
                    arrayList.add(spVar);
                }
            }
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 复用模式2，从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((sp) it2.next()).tt(true);
        }
        return arrayList;
    }

    public int tt(String str) {
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.uj.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return 0;
        }
        return copyOnWriteArrayList.size();
    }

    public synchronized int c(String str, com.byazt.ll.tt ttVar, boolean z) {
        if (tt(ttVar != null ? ttVar.gt() : "", str) == 0) {
            return tt(str, ttVar, z);
        }
        CopyOnWriteArrayList<sp> copyOnWriteArrayList = this.uj.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            sp spVar = null;
            ArrayList arrayList = z ? new ArrayList() : null;
            boolean z2 = false;
            for (sp spVar2 : copyOnWriteArrayList) {
                int iC = c(spVar2, spVar2.uj(), ttVar, "广告复用");
                if (iC == -1) {
                    z2 = true;
                } else {
                    if (iC != 6) {
                        copyOnWriteArrayList.remove(spVar2);
                    }
                    if (z) {
                        if (spVar == null) {
                            spVar = spVar2;
                        }
                        com.byazt.ix.c cVar = new com.byazt.ix.c();
                        cVar.uj(spVar2.c.getLoadSort());
                        cVar.n(spVar2.c.getShowSort());
                        cVar.tt(spVar2.c.getAdNetworkSlotId());
                        cVar.tt(iC);
                        cVar.c(spVar2.c.isHasShown() ? 1 : 0);
                        arrayList.add(cVar);
                    }
                }
            }
            if (z2) {
                return 3;
            }
            if (z && spVar != null) {
                a.c(ttVar, spVar.c, c(arrayList));
            }
            return 2;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    private String c(List<com.byazt.ix.c> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).c());
                if (i == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用：adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, com.byazt.ll.tt ttVar, Map<String, Object> map, Context context, sl slVar, i iVar) {
        String strC;
        if (ttVar == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        if (context == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，context为null -------: " + str);
            return;
        }
        da daVarN = n(ttVar.gt(), str);
        if (daVarN != null) {
            try {
                strC = com.byazt.oi.ve.c(daVarN.sp(), com.byazt.oi.ve.c(daVarN.z()), com.byazt.yl.c.c(daVarN.u(), daVarN.a()));
            } catch (Throwable th) {
                m.c(th);
                strC = null;
            }
        } else {
            strC = null;
        }
        if (!TextUtils.isEmpty(strC) && com.byazt.oi.ve.tt(strC) && daVarN != null) {
            for (String str2 : this.c) {
                if (TextUtils.equals(str2, daVarN.z())) {
                    com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，" + str2 + "为单例模式 -------: " + str);
                    return;
                }
            }
            int iIntValue = this.sp.get(str) != null ? this.sp.get(str).intValue() : -1;
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求开始 -------: " + str);
            com.byazt.dv.tt ttVarC = com.byazt.dv.tt.c(daVarN, (com.byazt.pq.c) null);
            ttVarC.ve(4);
            ttVarC.tt(1);
            com.byazt.db.c cVarC = com.byazt.qv.ve.c(ttVarC, ttVar, new C0421c(ttVar, daVarN, ttVarC, iVar, iIntValue));
            if (cVarC != null) {
                if (!com.byazt.hr.sl.c().ve(ttVar.gt(), daVarN.rh())) {
                    com.byazt.eu.tt.c("TMe", "adn 代码位预请求触发次数拦截............");
                    Pair<String, String> pairC = com.byazt.hr.sl.c().c(ttVar.gt(), daVarN.rh());
                    if (pairC != null) {
                        com.byazt.bnd.tt ttVar2 = new com.byazt.bnd.tt(41041, com.byazt.pp.c.c(41041), (String) pairC.second, (String) pairC.first);
                        a.c(daVarN, ttVar, c().c(daVarN.rh()), true, 2, iIntValue, 4, 1, ttVar2, -1L, false, false, 0L);
                        a.c(ttVar2, ttVar, daVarN, iIntValue, 4, 1, c().c(daVarN.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                        return;
                    }
                    return;
                }
                a.c(daVarN, ttVar, c().c(daVarN.rh()), ttVarC.n(), 3, ttVarC.ve(), 4, 1, null, ttVarC.uj(), false, false, 0L);
                cVarC.adnStartLoad(context, ttVarC, ttVar, com.byazt.qv.ve.c(ttVarC, ttVar, map));
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求已发完 -------: " + str);
                return;
            }
            a.c(daVarN, ttVar, 4, 1);
            return;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + strC + ", wfcBean: " + daVarN + ", adnSlotId: " + str);
    }
}
