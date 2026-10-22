package com.byazt.btt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.afw.sl;
import com.byazt.afw.t;
import com.byazt.bwm.sp;
import com.byazt.ete.ic;
import com.byazt.fk.da;
import com.byazt.fk.u;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.omf.eo;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.byazt.ut.uj;
import com.byazt.whk.i;
import com.byazt.whk.x;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2088, 54})
public class ve {
    public static volatile da c;
    public static volatile da tt;

    private static boolean c(int i) {
        return i == 3 || i == 4;
    }

    private static da tt(a aVar) {
        if (aVar.getPlayerType() == 1) {
            if (tt == null) {
                synchronized (ve.class) {
                    if (tt == null) {
                        tt = tt.c().createVideoPreload();
                    }
                }
            }
            return tt;
        }
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new com.byazt.yqr.c();
                }
            }
        }
        return c;
    }

    private static boolean tt(int i) {
        return i == 8 || i == 7;
    }

    private static void uj(final a aVar, final da.c cVar, final ic icVar) {
        aVar.setConnectTimeOutMills(6000);
        aVar.setReadTimeOutMills(6000);
        aVar.setWriteTimeOutMills(6000);
        if (icVar != null) {
            if (com.byazt.ex.c.c(icVar)) {
                return;
            }
            if (aVar.getPitayaCode() == 400) {
                ve(aVar, icVar);
                return;
            }
            tt(aVar, icVar);
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        da.c cVar2 = new da.c() { // from class: com.byazt.btt.ve.3
            @Override // com.byazt.fk.da.c
            public void cancel(u uVar, int i) {
                da.c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.onVideoPreloadSuccess(uVar, i);
                }
                ic icVar2 = icVar;
                if (icVar2 != null) {
                    ve.ve(aVar, icVar2);
                }
                m.c("VideoPreloadUtils", "pit cancel: ", aVar.getFileNameKey());
            }

            @Override // com.byazt.fk.da.c
            public void onVideoPreloadFail(u uVar, int i, String str) {
                da.c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.onVideoPreloadFail(uVar, i, str);
                }
                if (icVar != null) {
                    ve.tt(aVar, icVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                m.c("VideoPreloadUtils", "pit onVideoPreloadFail: ", aVar.getFileNameKey());
            }

            @Override // com.byazt.fk.da.c
            public void onVideoPreloadSuccess(u uVar, int i) {
                da.c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.onVideoPreloadSuccess(uVar, i);
                }
                if (icVar != null) {
                    ve.c(aVar, icVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                m.c("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", aVar.getFileNameKey());
            }
        };
        try {
            aVar.getPlayerType();
            tt(aVar).execVideoPreload(gt.getContext(), aVar, cVar2);
        } catch (Exception e) {
            if (cVar != null) {
                m.c("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", aVar.getFileNameKey());
                cVar.onVideoPreloadFail(aVar, -1, e.getMessage());
            }
            if (icVar != null) {
                tt(aVar, icVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
            m.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(final a aVar, final da.c cVar, final ic icVar) {
        try {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            int iSl = icVar != null ? nb.sl(icVar) : 0;
            boolean zC = com.byazt.whk.da.c();
            if (!tt(iSl) || !zC) {
                c(aVar, cVar, icVar, jCurrentTimeMillis, zC);
                return;
            }
            if (gt.c(10003) == null) {
                c(aVar, cVar, icVar, jCurrentTimeMillis, zC);
                return;
            }
            com.byazt.whk.ve veVar = (com.byazt.whk.ve) uj.getService("pitaya");
            if (veVar == null || !veVar.isPitayaInitSuccess()) {
                c(aVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - jCurrentTimeMillis);
                uj(aVar, cVar, icVar);
            } else {
                final JSONObject jSONObjectC = new com.byazt.whk.u().c(aVar);
                veVar.runTask("video_cache", jSONObjectC, new x() { // from class: com.byazt.btt.ve.2
                    @Override // com.byazt.whk.x
                    public PluginValueSet c(int i, i iVar) {
                        yp.c();
                        yp.c(iVar == null ? null : iVar.uj(), jSONObjectC);
                        return ve.tt(i, iVar, aVar, cVar, jCurrentTimeMillis, icVar);
                    }
                });
            }
        } catch (Exception e) {
            m.ve("pit predict error:" + e.getMessage());
        }
    }

    private static boolean ve(a aVar) {
        return true;
    }

    public static void c(final a aVar, final da.c cVar) {
        if (aVar == null) {
            tt(null, cVar, null);
            return;
        }
        aVar.getPreloadSize();
        aVar.isPreloadAll();
        final ic icVarC = c(aVar);
        if (aVar.getPreloadSize() <= 0 && !aVar.isPreloadAll()) {
            tt(aVar, cVar, icVarC);
        } else if (com.byazt.bzd.x.c()) {
            com.byazt.bzd.x.c(new sp("csj_vPreload") { // from class: com.byazt.btt.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.ve(aVar, cVar, icVarC);
                }
            });
        } else {
            ve(aVar, cVar, icVarC);
        }
    }

    private static void c(a aVar, da.c cVar, ic icVar, long j, boolean z) {
        c(aVar, -1000, z ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j);
        uj(aVar, cVar, icVar);
    }

    private static void tt(a aVar, da.c cVar, ic icVar) {
        if (cVar != null) {
            cVar.onVideoPreloadSuccess(aVar, -100);
        }
        if (icVar != null) {
            if (tt(nb.sl(icVar)) || c(nb.sl(icVar))) {
                c(aVar, icVar, 0L);
            }
        }
    }

    private static void c(a aVar, int i, int i2, String str, JSONObject jSONObject, long j) {
        JSONObject passThroughJson = aVar.getPassThroughJson();
        try {
            passThroughJson.put("pitaya_cache_size", i);
            passThroughJson.put("pitaya_code", i2);
            passThroughJson.put("pitaya_msg", str);
            passThroughJson.put("ext_plugin_code", eo.tt());
            passThroughJson.put("package", jSONObject);
            passThroughJson.put("run_task_mills", j);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PluginValueSet tt(int i, i iVar, a aVar, da.c cVar, long j, ic icVar) {
        int i2;
        int i3;
        String string;
        try {
            if (iVar == null) {
                c(aVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j);
                uj(aVar, cVar, icVar);
                return null;
            }
            com.byazt.yxi.tt ttVarVe = iVar.ve();
            if (ttVarVe == null) {
                c(aVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j);
                uj(aVar, cVar, icVar);
                return null;
            }
            PluginValueSet pluginValueSetUj = ttVarVe.uj();
            if (pluginValueSetUj == null) {
                c(aVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j);
                uj(aVar, cVar, icVar);
                return null;
            }
            JSONObject jSONObjectC = com.byazt.whk.da.c(pluginValueSetUj, 2);
            pluginValueSetUj.stringValue(5);
            JSONObject jSONObjectC2 = com.byazt.whk.da.c(pluginValueSetUj, 3);
            JSONObject jSONObjectC3 = com.byazt.whk.da.c(pluginValueSetUj, 4);
            if (!ttVarVe.c() || jSONObjectC == null) {
                i2 = -1000;
                i3 = -5;
                string = null;
            } else {
                int iOptInt = jSONObjectC.optInt("pitaya_cache_size", -1);
                int iOptInt2 = jSONObjectC.optInt("pitaya_code", 200);
                string = "success";
                com.byazt.whk.u.c(aVar, jSONObjectC, iOptInt, iOptInt2);
                i2 = iOptInt;
                i3 = iOptInt2;
            }
            if (!ttVarVe.c() && jSONObjectC3 != null) {
                string = jSONObjectC3.toString();
            }
            c(aVar, i2, i3, string, jSONObjectC2, System.currentTimeMillis() - j);
            uj(aVar, cVar, icVar);
            return null;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(a aVar, ic icVar) {
        if (ve(aVar)) {
            String strTt = nb.tt(icVar);
            JSONObject jSONObjectC = com.byazt.sw.uj.c(aVar, null, -1, aVar.getPlayerType(), icVar, -1L);
            com.byazt.afw.da daVar = new com.byazt.afw.da(aVar.getUrl(), aVar.getPreloadSize());
            daVar.c(aVar);
            com.byazt.sw.uj.uj((com.byazt.afw.tt<com.byazt.afw.da>) new com.byazt.afw.tt(icVar, strTt, jSONObjectC, daVar));
        }
    }

    public static ic c(a aVar) {
        if (aVar == null) {
            return null;
        }
        Object extra = aVar.getExtra("material_meta");
        if (extra instanceof ic) {
            return (ic) extra;
        }
        return null;
    }

    public static void c(a aVar, ic icVar, long j) {
        if (ve(aVar)) {
            String strTt = nb.tt(icVar);
            JSONObject jSONObjectC = com.byazt.sw.uj.c(aVar, null, -1, aVar.getPlayerType(), icVar, -1L);
            com.byazt.afw.u uVar = new com.byazt.afw.u();
            uVar.c(aVar.getUrl());
            uVar.c(aVar.getPreloadSize());
            uVar.tt(j);
            uVar.c(aVar);
            if (aVar.getSourceType() == 1) {
                uVar.ve(1L);
            } else {
                uVar.ve(0L);
            }
            com.byazt.sw.uj.tt((com.byazt.afw.tt<com.byazt.afw.u>) new com.byazt.afw.tt(icVar, strTt, jSONObjectC, uVar));
        }
    }

    private static void tt(a aVar, ic icVar) {
        if (ve(aVar)) {
            long videoSize = aVar.isPreloadAll() ? aVar.getVideoSize() : aVar.getPreloadSize();
            String strTt = nb.tt(icVar);
            JSONObject jSONObjectC = com.byazt.sw.uj.c(aVar, null, -1, aVar.getPlayerType(), icVar, -1L);
            t tVar = new t(aVar.getUrl(), videoSize);
            tVar.c(aVar);
            com.byazt.sw.uj.c((com.byazt.afw.tt<t>) new com.byazt.afw.tt(icVar, strTt, jSONObjectC, tVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(a aVar, ic icVar, long j, int i, String str) {
        if (ve(aVar)) {
            String strTt = nb.tt(icVar);
            JSONObject jSONObjectC = com.byazt.sw.uj.c(aVar, null, -1, aVar.getPlayerType(), icVar, -1L);
            sl slVar = new sl();
            slVar.c(aVar.getUrl());
            slVar.c(aVar.getPreloadSize());
            slVar.tt(j);
            slVar.c(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            slVar.tt(str);
            slVar.ve("");
            slVar.c(aVar);
            com.byazt.sw.uj.ve((com.byazt.afw.tt<sl>) new com.byazt.afw.tt(icVar, strTt, jSONObjectC, slVar));
        }
    }
}
