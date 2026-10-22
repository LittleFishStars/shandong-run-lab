package com.byazt.tdq;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.os;
import com.byazt.ete.x;
import com.byazt.eti.sp;
import com.byazt.im.a;
import com.byazt.im.i;
import com.byazt.omf.gr;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 708, 54})
public class ve extends c {
    public volatile sp sl;
    public static ConcurrentHashMap<String, tt> sp = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, List<String>> x = new ConcurrentHashMap<>();
    public static ReferenceQueue<Object> i = new ReferenceQueue<>();
    public static Map<Object, tt> da = new ConcurrentHashMap();

    private static int a() {
        if (x.c() == null) {
            return 1;
        }
        return x.c().uj();
    }

    private void n() {
        if (a() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = i.poll(); referencePoll != null; referencePoll = i.poll()) {
                tt ttVar = da.get(referencePoll);
                if (ttVar != null) {
                    c(ttVar.ve, ttVar.c);
                }
                da.remove(referencePoll);
            }
        } catch (Exception unused) {
        }
    }

    private void uj() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.sl = new sp(3);
        com.byazt.dz.c.c("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.byazt.tdq.c
    public void tt() {
        if (this.sl == null) {
            synchronized (this) {
                if (this.sl == null) {
                    uj();
                }
            }
        }
    }

    @Override // com.byazt.tdq.c
    public void ve() {
        if (this.sl == null) {
            tt();
        }
        if (this.sl != null) {
            this.sl.c();
        }
    }

    @Override // com.byazt.tdq.c
    public void c(final os osVar, com.byazt.dj.tt ttVar, boolean z) {
        if (ttVar == null || osVar == null || osVar.c() == null) {
            return;
        }
        if (this.sl == null) {
            tt();
        }
        try {
            final String strUj = ttVar.uj();
            com.byazt.dz.c.c("lqmt", "saveCache start >>  rit: " + strUj + "  isUsing: " + z);
            final ic icVarC = osVar.c();
            String strQy = icVarC.qy();
            String strTt = tt(strUj, strQy);
            if (sp.contains(strTt)) {
                return;
            }
            com.byazt.dz.c.c("lqmt", "save-updateMemoryRecord start >>  rit: " + strUj + "  reqId: " + strQy);
            c(strTt, strUj, strQy, z ? 2 : 1);
            c(new Runnable() { // from class: com.byazt.tdq.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ve.this.sl.c(strUj, new sp.tt(com.byazt.nr.c.tt(osVar.tt().ve().toString()), icVarC.xg(), 1000 * icVarC.uv(), icVarC.qy()), false, nb.rh(icVarC), icVarC.fq());
                    com.byazt.dz.c.c("lqmt", "saveMeta >>  rit: " + strUj + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    private String tt(String str, String str2) {
        return str + str2;
    }

    @Override // com.byazt.tdq.c
    public void c(com.byazt.im.sp spVar, final String str, c.InterfaceC0532c interfaceC0532c, n nVar) {
        if (str == null || interfaceC0532c == null) {
            return;
        }
        if (this.sl == null) {
            tt();
        }
        this.f29055a = nVar;
        sp.tt ttVar = null;
        a aVar = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            n();
            List<String> listC = c(str);
            StringBuilder sb = new StringBuilder("readcache start >>  rit: ");
            sb.append(str);
            sb.append("  usedReqIdList: ");
            sb.append(listC == null ? 0 : listC.size());
            com.byazt.dz.c.c("lqmt", sb.toString());
            n nVar2 = this.f29055a;
            final sp.tt ttVarC = this.sl.c(str, nVar2 == null ? 0L : nVar2.c, listC);
            try {
                com.byazt.dz.c.c("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (ttVarC == null) {
                    com.byazt.dz.c.c("lqmt", "readcache-cacheMeta: null ");
                    if (spVar != null) {
                        spVar.uj(0);
                        spVar.tt(1);
                        spVar.c("no cache");
                    }
                    interfaceC0532c.c();
                    return;
                }
                String str2 = ttVarC.n;
                String strTt = tt(str, str2);
                com.byazt.dz.c.c("lqmt", "readcache-mapkey: " + strTt);
                tt ttVar2 = sp.get(strTt);
                if (ttVar2 != null && ttVar2.tt > 1) {
                    com.byazt.dz.c.c("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
                    if (spVar != null) {
                        spVar.uj(0);
                        spVar.tt(1);
                        spVar.c("no cache");
                    }
                    interfaceC0532c.c();
                    return;
                }
                c(strTt, str, str2, 2);
                com.byazt.ete.c cVar = gr.c.c(new JSONObject(com.byazt.nr.c.ve(ttVarC.ve))).x;
                a aVar2 = new a(cVar, true);
                ic icVar = (cVar == null || cVar.tt() == null || cVar.tt().isEmpty()) ? null : cVar.tt().get(0);
                if (icVar != null) {
                    aVar2.c(icVar);
                }
                com.byazt.dz.c.c("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
                if (com.byazt.apd.tt.c().ve(icVar) != 3) {
                    aVar = aVar2;
                } else {
                    aVar2.c((ic) null);
                }
                interfaceC0532c.c(aVar);
                boolean zDa = com.byazt.by.n.c().da();
                com.byazt.dz.c.c("lqmt", "isSplashCacheRemoveChange: " + zDa);
                if (zDa) {
                    return;
                }
                c(new Runnable() { // from class: com.byazt.tdq.ve.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            ve.this.sl.c(str, ttVarC.n);
                            com.byazt.dz.c.c("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + ttVarC.n + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                        } catch (Exception unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
                ttVar = ttVarC;
                ttVarC = ttVar;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.byazt.tdq.c
    public void c(com.byazt.gat.uj<i, com.byazt.im.sp> ujVar, final ic icVar, com.byazt.dj.tt ttVar, boolean z) {
        if (icVar == null || ttVar == null) {
            return;
        }
        if (this.sl == null) {
            tt();
        }
        try {
            com.byazt.dz.c.c("lqmt", "removeCache>> start ");
            final String strUj = ttVar.uj();
            String strQy = icVar.qy();
            String strTt = tt(strUj, strQy);
            if (this.n.get()) {
                com.byazt.dz.c.c("lqmt", "removeCache-mIsRemoveCacheAd: true");
                return;
            }
            this.n.set(true);
            c(strTt, strUj, strQy, 3);
            com.byazt.dz.c.c("lqmt", "removeCache-updateMemoryRecord: 完成");
            c(new Runnable() { // from class: com.byazt.tdq.ve.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ve.this.sl.c(strUj, icVar.qy());
                        com.byazt.dz.c.c("lqmt", "removeCache-deleteCacheMeta  rit: " + strUj + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Throwable unused) {
                    }
                }
            });
            if (ujVar != null) {
                ujVar.c();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.tdq.c
    public void c(String str, ic icVar) {
        if (this.sl == null) {
            tt();
        }
        if (this.sl != null) {
            this.sl.c(str, icVar.qy());
        }
    }

    @Override // com.byazt.tdq.c
    public void c(String str, String str2, boolean z, boolean z2, Object obj) {
        if (a() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2 && z) {
            c(obj, str, str2);
        } else {
            c(str, str2);
        }
    }

    private void c(final Runnable runnable) {
        if (com.byazt.bzd.x.c()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("") { // from class: com.byazt.tdq.ve.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> c(String str) {
        List<String> list = x.get(str);
        StringBuilder sb = new StringBuilder("getUsedReqIdList: list : ");
        sb.append(list == null ? 0 : list.size());
        com.byazt.dz.c.c("lqmt", sb.toString());
        return list;
    }

    private void c(String str, String str2, String str3, int i2) {
        int iA = a();
        com.byazt.dz.c.c("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i2 + ", cacheStrategyType: " + iA);
        if (iA != 3) {
            return;
        }
        sp.put(str, new tt(str3, i2, str2));
        if (i2 <= 1) {
            com.byazt.dz.c.c("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = x.get(str2);
        StringBuilder sb = new StringBuilder("updateMemoryRecord>>: list1 : ");
        sb.append(copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size());
        com.byazt.dz.c.c("lqmt", sb.toString());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (copyOnWriteArrayList.contains(str3)) {
            return;
        } else {
            copyOnWriteArrayList.add(str3);
        }
        com.byazt.dz.c.c("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        x.put(str2, copyOnWriteArrayList);
    }

    private void c(Object obj, String str, String str2) {
        try {
            tt ttVar = sp.get(tt(str, str2));
            if (ttVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, i);
                com.byazt.dz.c.c("lqmt", ttVar.ve + "，uuid：" + ttVar.c + " watching");
                da.put(phantomReference, ttVar);
            }
        } catch (Exception unused) {
        }
    }

    private void c(String str, String str2) {
        sp.remove(tt(str, str2));
        List<String> list = x.get(str);
        StringBuilder sb = new StringBuilder("checkCaches>>: list1 : ");
        sb.append(list == null ? 0 : list.size());
        com.byazt.dz.c.c("lqmt", sb.toString());
        if (list == null) {
            return;
        }
        com.byazt.dz.c.c("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        x.put(str, list);
    }
}
