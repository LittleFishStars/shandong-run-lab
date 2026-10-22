package com.byazt.ukr;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 13})
public class tt {
    public static final Set<String> sp;
    public static List<com.byazt.fo.c> x;
    public static final String c = UUID.randomUUID().toString();
    public static AtomicInteger tt = new AtomicInteger(0);
    public static String n = "_create";
    public static final AtomicBoolean ve = new AtomicBoolean(false);
    public static final AtomicBoolean uj = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f29090a = new AtomicBoolean(false);

    static {
        HashSet hashSet = new HashSet();
        sp = hashSet;
        hashSet.add("click_start");
        hashSet.add("download_start");
        hashSet.add("download_finish");
        hashSet.add("install_finish");
        hashSet.add("click");
        hashSet.add("show");
        x = new CopyOnWriteArrayList();
    }

    public static void c(Context context, boolean z) {
        if (ve.compareAndSet(false, true)) {
            tt(context, z);
            com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.ukr.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.epi.c.ve("csj");
                    tt.uj.set(true);
                }
            }, com.byazt.omf.x.m().a() ? 20000L : 30000L);
        }
    }

    private static void tt(Context context, boolean z) {
        if (context == null) {
            return;
        }
        int i = gt.tt().to();
        if (i <= 0 || i == Integer.MAX_VALUE) {
            i = 100;
        }
        int iSv = gt.tt().sv();
        if (iSv > i) {
            iSv = 5;
            i = 10;
        }
        com.byazt.epi.c.c(new com.byazt.vb.c.C0555c().ve(com.byazt.rz.c.c(iSv, i)).c(com.byazt.rz.c.c(1, i)).tt(com.byazt.rz.c.c(1, i)).tt(z).c("csj").c(gt.tt().aw()).c(context).c(new i()).c(x.c).c(gt.tt().bm()).tt(com.byazt.xo.c.n()).c());
    }

    public static void uj() {
        try {
            com.byazt.epi.c.c("csj", false);
        } catch (Exception e) {
            m.uj(n, e.getMessage());
        }
    }

    public static com.byazt.nv.c ve() {
        return u.c;
    }

    public static void c() {
        com.byazt.epi.c.c(false, "csj");
    }

    public static void c(com.byazt.fo.c cVar, String str, int i) {
        if (gt.tt().cl()) {
            return;
        }
        if (com.byazt.epi.c.c("csj")) {
            x.add(cVar);
            com.byazt.lj.ve.reportEvent(cVar);
            c(gt.getContext(), com.byazt.ue.tt.c());
        } else {
            c(cVar);
            com.byazt.lj.ve.reportEvent(cVar);
        }
    }

    private static void c(com.byazt.vb.tt ttVar) {
        if (f29090a.compareAndSet(false, true) && !x.isEmpty()) {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                com.byazt.epi.c.c(x.get(i), "csj");
            }
            x.clear();
        }
        com.byazt.epi.c.c(ttVar, "csj");
    }

    private static void c(String str, com.byazt.fo.c cVar) {
        if (gt.tt().zb()) {
            try {
                cVar.ve(com.byazt.ml.c.tt(str));
            } catch (Exception e) {
                m.ve(e.getMessage());
            }
        }
    }

    public static void tt() {
        com.byazt.epi.c.c(x.c, "csj");
    }

    public static void c(com.byazt.ddx.c cVar, final String str) {
        if (!gt.tt().cl() || sp.contains(str)) {
            final com.byazt.fo.c cVar2 = new com.byazt.fo.c(cVar.uj(), cVar);
            cVar2.tt(cVar.a() ? (byte) 1 : (byte) 2);
            cVar2.c((byte) 0);
            c(cVar.ve(), cVar2);
            if (com.byazt.epi.c.c("csj")) {
                x.add(cVar2);
                com.byazt.lj.ve.reportEvent(cVar2);
                c(gt.getContext(), com.byazt.ue.tt.c());
            } else {
                c(cVar2);
                com.byazt.lj.ve.reportEvent(cVar2);
            }
            final com.byazt.whk.ve veVar = (com.byazt.whk.ve) com.byazt.ut.uj.getService("pitaya");
            if (veVar != null) {
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("csj-pitaya-applog") { // from class: com.byazt.ukr.tt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            veVar.onAppLogEvent(str, cVar2.sp());
                        } catch (Throwable th) {
                            m.uj("AdLogSwitchUtils", "pitaya onAppLogEvent error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public static void c(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        if (list == null || list.size() == 0) {
            return;
        }
        list.size();
        if (com.byazt.epi.c.c("csj")) {
            c(gt.getContext(), com.byazt.ue.tt.c());
        }
        com.byazt.epi.c.c("csj", str, c(list, ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getOAID(false)), z, map, jSONObject);
    }

    public static List<String> c(List<String> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(list);
            list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                String strReplace = (String) arrayList.get(i);
                if (!TextUtils.isEmpty(strReplace)) {
                    if (strReplace.contains("{OAID}") || strReplace.contains("__OAID__")) {
                        strReplace = strReplace.replace("{OAID}", str).replace("__OAID__", str);
                    }
                    list.add(strReplace);
                }
            }
        }
        return list;
    }

    public static void c(String str) {
        if (com.byazt.epi.c.c("csj")) {
            c(gt.getContext(), com.byazt.ue.tt.c());
        }
        com.byazt.epi.c.c("csj", str);
    }
}
