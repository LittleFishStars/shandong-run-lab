package com.byazt.sw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.aas.nb;
import com.byazt.afw.da;
import com.byazt.afw.i;
import com.byazt.afw.nu;
import com.byazt.afw.sl;
import com.byazt.afw.sp;
import com.byazt.afw.x;
import com.byazt.afw.yp;
import com.byazt.afw.z;
import com.byazt.bv.BaseConstants;
import com.byazt.bzd.t;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.fk.n;
import com.byazt.jzl.a;
import com.byazt.nr.m;
import com.byazt.whk.u;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 868, 15})
public class uj {
    public static final Map<com.byazt.oce.c, nu> c = Collections.synchronizedMap(new WeakHashMap());

    public static void n(final com.byazt.oce.c cVar, final nu.c cVar2) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.11
            @Override // java.lang.Runnable
            public void run() {
                nu.c cVar3;
                if (cVar == null || (cVar3 = cVar2) == null) {
                    return;
                }
                if (cVar3.t() <= 0) {
                    m.c("VideoEventManager", "Cancel log report when buffer count is 0");
                    return;
                }
                nu nuVar = (nu) uj.c.get(cVar);
                if (nuVar == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jUj = cVar2.uj();
                if (jUj <= 0) {
                    return;
                }
                yp ypVar = new yp();
                ypVar.c(cVar2.ve());
                ypVar.tt(jUj);
                ypVar.c(cVar2.t());
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_ACTION"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, ypVar);
                ttVar.c(cVar2.u());
                uj.tt(ttVar, "play_buffer");
            }
        });
    }

    public static void uj(com.byazt.afw.tt<da> ttVar) {
        tt(ttVar, "load_video_cancel");
    }

    public static void ve(com.byazt.afw.tt<sl> ttVar) {
        tt(ttVar, "load_video_error");
    }

    private static boolean n(com.byazt.afw.tt ttVar) {
        ic icVarC;
        com.byazt.dj.tt ttVarIj;
        if (ttVar == null || !ttVar.n() || (icVarC = ttVar.c()) == null || (ttVarIj = icVarC.ij()) == null) {
            return false;
        }
        String strQy = ttVarIj.qy();
        if (TextUtils.isEmpty(strQy)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strQy);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString("name");
                if ("content_did".equalsIgnoreCase(strOptString)) {
                    z = true;
                } else if ("content_utmsource".equalsIgnoreCase(strOptString)) {
                    z2 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(strOptString)) {
                    z3 = true;
                }
            }
            return z && z2 && z3;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    public static void uj(final com.byazt.oce.c cVar, final nu.c cVar2) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.10
            @Override // java.lang.Runnable
            public void run() {
                nu.c cVar3;
                com.byazt.oce.c cVar4 = cVar;
                if (cVar4 == null || (cVar3 = cVar2) == null) {
                    return;
                }
                uj.n(cVar4, cVar3);
                nu nuVar = (nu) uj.c.get(cVar);
                if (nuVar == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                if (jUj <= 0) {
                    return;
                }
                sp spVar = new sp();
                spVar.tt(cVar2.ve());
                spVar.c(jUj);
                spVar.c(cVar2.sl());
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_ACTION"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, spVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    u.c(jTt, icVarN, aVarUj);
                    uj.tt(ttVar, uj.tt(icVarN, "feed_over"), jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
                uj.c.remove(cVar);
            }
        });
    }

    public static void ve(final com.byazt.oce.c cVar, final nu.c cVar2) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.8
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                com.byazt.afw.ve veVar = new com.byazt.afw.ve();
                veVar.ve(cVar2.ve());
                veVar.uj(jUj);
                veVar.tt(cVar2.sp());
                veVar.ve(cVar2.x());
                veVar.tt(com.byazt.bzd.sl.c(icVarN.xx()).getCachedSize(aVarUj));
                veVar.c(jTt);
                veVar.c(cVar2.i());
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_START"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, veVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    uj.tt(ttVar, "endcard_skip", jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
                ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uj.c.remove(cVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void tt(com.byazt.afw.tt<com.byazt.afw.u> ttVar) {
        tt(ttVar, "load_video_success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String uj(a aVar) {
        return new File(aVar.getCacheParentDir(), aVar.getFileNameKey()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long ve(a aVar) {
        if (aVar == null) {
            return 0L;
        }
        n videoH265 = aVar.isH265() ? aVar.getVideoH265() : aVar.getVideoH264();
        if (videoH265 != null) {
            return Double.valueOf(videoH265.getVideo_duration() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(ic icVar, String str) {
        if (icVar == null || !nb.x(icVar) || !nb.i(icVar)) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
                return "play_over";
            case "feed_play":
                return "play";
            case "feed_break":
                return "play_break";
            default:
                return str;
        }
    }

    public static JSONObject c(a aVar, String str, int i, int i2, ic icVar, long j) {
        n videoH264;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (t.c(icVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (aVar != null) {
                if (com.byazt.ex.c.c(icVar)) {
                    jSONObject.put("codec", icVar.aw());
                    videoH264 = null;
                } else if (aVar.isH265()) {
                    videoH264 = aVar.getVideoH265();
                    jSONObject.put("codec", "h265");
                } else {
                    videoH264 = aVar.getVideoH264();
                }
                if (videoH264 != null) {
                    jSONObject.put(CropKey.VIDEO_RESOLUTION, videoH264.getResolution());
                    jSONObject.put("video_size", Long.valueOf(videoH264.getSize()));
                    String video_url = videoH264.getVideo_url();
                    jSONObject.put("video_url", video_url);
                    jSONObject.put("is_expired", nb.z(video_url));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (nb.z(icVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", videoH264.getPlay_speed_ratio());
                    if (videoH264.getStart() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        jSONObject.put("start", videoH264.getStart());
                    }
                }
            }
            if (icVar != null) {
                jSONObject.put("dynamic_join_type", icVar.il());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void tt(final com.byazt.oce.c cVar, final nu.c cVar2) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.6
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                if (jUj <= 0 || jTt <= 0) {
                    return;
                }
                com.byazt.afw.a aVar = new com.byazt.afw.a();
                aVar.c(cVar2.ve());
                aVar.tt(jUj);
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_ACTION"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, aVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    uj.tt(ttVar, "feed_continue", jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(com.byazt.afw.tt ttVar, String str) {
        tt(ttVar, str, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final com.byazt.afw.tt ttVar, String str, JSONObject jSONObject) {
        if (ttVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (ttVar.n() && !TextUtils.isEmpty(ttVar.tt()) && !n(ttVar)) {
            String strTt = ttVar.tt();
            strTt.hashCode();
            switch (strTt) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        tt.c(str, ttVar.c());
        com.byazt.ddx.uj.c(ttVar.c(), ttVar.tt(), str, jSONObject, new com.byazt.ya.c() { // from class: com.byazt.sw.uj.2
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectVe = ttVar.ve();
                if (ttVar.uj() != null) {
                    ttVar.uj().a_(jSONObjectVe);
                }
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObjectVe.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final ic icVar, final a aVar, final nu.c cVar) {
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.sw.uj.3
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", uj.ve(aVar));
                jSONObject.put("player_duration", cVar.uj());
                jSONObject.put("cache_path_type", com.byazt.bzd.sl.uj());
                jSONObject.put("url", aVar.getUrl());
                jSONObject.put("path", uj.uj(aVar));
                jSONObject.put("player_type", aVar.getPlayerType());
                return com.byazt.qal.tt.tt().c("pangle_video_play_state").c(nb.sl(icVar)).tt(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    public static synchronized a tt(com.byazt.oce.c cVar) {
        if (cVar == null) {
            return null;
        }
        nu nuVar = c.get(cVar);
        if (nuVar == null) {
            return null;
        }
        return nuVar.uj();
    }

    public static void c(com.byazt.afw.tt<com.byazt.afw.t> ttVar) {
        tt(ttVar, "load_video_start");
    }

    public static int c(ic icVar, a aVar, long j) {
        int iXx = icVar.xx();
        com.byazt.fk.c cVarC = com.byazt.bzd.sl.c(iXx);
        if (iXx != 0) {
            if (iXx == 1) {
                return cVarC.isVideoCached(aVar) ? 1 : 2;
            }
            return 3;
        }
        boolean zIsPreloadAll = aVar.isPreloadAll();
        int preloadSize = aVar.getPreloadSize();
        long videoSize = aVar.getVideoSize();
        if (zIsPreloadAll) {
            preloadSize = (int) videoSize;
        }
        int pitayaCacheSize = aVar.getPitayaCacheSize();
        if (pitayaCacheSize > 0) {
            preloadSize = pitayaCacheSize;
        }
        boolean z = j >= ((long) preloadSize);
        boolean z2 = j >= videoSize;
        if (j == 0) {
            return 2;
        }
        if (z2) {
            return 4;
        }
        return (!z || preloadSize == 0) ? 1 : 5;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static void c(final ic icVar, final com.byazt.oce.c cVar, final a aVar, final boolean z, final String str) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.1
            @Override // java.lang.Runnable
            public void run() {
                ic icVar2 = icVar;
                if (icVar2 == null || cVar == null || aVar == null) {
                    return;
                }
                long cachedSize = com.byazt.bzd.sl.c(icVar2.xx()).getCachedSize(aVar);
                int iC = uj.c(icVar, aVar, cachedSize);
                uj.c.put(cVar, new nu(SystemClock.elapsedRealtime(), str, iC, aVar, icVar));
                com.byazt.afw.m mVar = new com.byazt.afw.m();
                if (cachedSize > 0) {
                    mVar.c(cachedSize);
                }
                mVar.c(z);
                u.c(iC, cachedSize, icVar, aVar);
                a aVar2 = aVar;
                JSONObject jSONObjectC = uj.c(aVar2, str, iC, aVar2.getPlayerType(), icVar, 0L);
                uj.c(jSONObjectC, aVar.getExtra("EXTRA_PLAY_START"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVar, nb.tt(icVar), jSONObjectC, mVar);
                ttVar.c(aVar.getPlayerType() == -1);
                uj.tt(ttVar, "play_start");
            }
        });
    }

    public static void c(final com.byazt.oce.c cVar, final nu.c cVar2) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.4
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                if (!t.c(icVarN) || my.tt(icVarN)) {
                    if (!cVar2.u()) {
                        uj.tt(icVarN, aVarUj, cVar2);
                    }
                    i iVar = new i();
                    iVar.tt(cVar2.yp() ? 1 : 0);
                    iVar.c(cVar2.z() ? 1 : 0);
                    iVar.tt(com.byazt.bzd.sl.c(icVarN.xx()).getCachedSize(aVarUj));
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - nuVar.c();
                    iVar.c(jElapsedRealtime);
                    JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, jElapsedRealtime);
                    uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_START"));
                    com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, iVar);
                    ttVar.c(cVar2.u());
                    uj.tt(ttVar, uj.tt(icVarN, "feed_play"));
                }
            }
        });
    }

    public static String c(com.byazt.oce.c cVar) {
        nu nuVar;
        if (cVar == null || (nuVar = c.get(cVar)) == null) {
            return "empty";
        }
        String strTt = nuVar.tt();
        return TextUtils.isEmpty(strTt) ? "empty" : strTt;
    }

    public static void c(final com.byazt.oce.c cVar, final nu.c cVar2, final int i) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.5
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                if (jUj <= 0 || jTt <= 0) {
                    return;
                }
                x xVar = new x();
                xVar.c(cVar2.ve());
                xVar.tt(jUj);
                xVar.c(i);
                xVar.c(cVar2.m());
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_ACTION"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, xVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    uj.tt(ttVar, "feed_pause", jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        });
    }

    public static void c(final com.byazt.oce.c cVar, final nu.c cVar2, final String str, final int i, final boolean z) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.7
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                if (jUj < 0) {
                    return;
                }
                z zVar = new z();
                zVar.ve(cVar2.ve());
                zVar.uj(jUj);
                zVar.ve(cVar2.n());
                zVar.uj(cVar2.a());
                zVar.tt(i);
                zVar.tt(com.byazt.bzd.sl.c(icVarN.xx()).getCachedSize(aVarUj));
                zVar.c(str);
                JSONArray jSONArrayC = cVar2.c();
                if (jSONArrayC != null) {
                    zVar.c(jSONArrayC);
                }
                zVar.c(jTt);
                zVar.c(cVar2.i());
                zVar.c(z);
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, aVarUj.getExtra("EXTRA_PLAY_START"));
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, zVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    uj.tt(ttVar, "play_error", jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
                ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uj.c.remove(cVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void c(final com.byazt.oce.c cVar, final nu.c cVar2, final Map<String, Object> map, final int i) {
        ve.c().c(new Runnable() { // from class: com.byazt.sw.uj.9
            @Override // java.lang.Runnable
            public void run() {
                nu nuVar;
                if (cVar == null || cVar2 == null || (nuVar = (nu) uj.c.get(cVar)) == null) {
                    return;
                }
                a aVarUj = nuVar.uj();
                ic icVarN = nuVar.n();
                if (aVarUj == null || icVarN == null) {
                    return;
                }
                long jTt = cVar2.tt();
                long jUj = cVar2.uj();
                if (jUj <= 0) {
                    return;
                }
                com.byazt.afw.n nVar = new com.byazt.afw.n();
                nVar.tt(cVar2.ve());
                nVar.c(jUj);
                nVar.tt(cVar2.da());
                nVar.ve(cVar2.sl());
                nVar.c(i);
                JSONObject jSONObjectC = uj.c(aVarUj, nuVar.tt(), nuVar.ve(), aVarUj.getPlayerType(), icVarN, SystemClock.elapsedRealtime() - nuVar.c());
                uj.c(jSONObjectC, map);
                com.byazt.afw.tt ttVar = new com.byazt.afw.tt(icVarN, nb.tt(icVarN), jSONObjectC, nVar);
                ttVar.c(cVar2.u());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jTt);
                    jSONObject.put("percent", cVar2.i());
                    u.c(jTt, icVarN, aVarUj);
                    uj.tt(ttVar, uj.tt(icVarN, "feed_break"), jSONObject);
                } catch (JSONException e) {
                    m.c(e);
                }
                uj.c.remove(cVar);
            }
        });
    }

    public static void c(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }
}
