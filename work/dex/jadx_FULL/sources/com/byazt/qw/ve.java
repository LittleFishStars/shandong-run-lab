package com.byazt.qw;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.rh;
import com.byazt.ukr.yp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 726, 54})
public class ve implements com.byazt.aas.c.tt {
    public static volatile ve tt;
    public float u;
    public final ConcurrentHashMap<Integer, uj> ve = new ConcurrentHashMap<>();
    public final Map<String, Float> uj = new ConcurrentHashMap();
    public uj n = null;
    public JSONArray sp = new JSONArray();
    public final String x = "realtime_feature";
    public long i = 0;
    public long da = 0;
    public long sl = 0;
    public long t = 0;
    public long c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f28988a = da.c();

    private ve() {
        com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        if (cVarVe != null) {
            cVarVe.c(this);
        }
    }

    private Handler sl() {
        return this.f28988a;
    }

    public static ve ve() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    public void a() {
        long jSp = sp();
        if (jSp != this.c) {
            c.c(c.n);
            this.c = jSp;
        }
    }

    public float da() {
        if (this.u == 0.0f) {
            this.u = DeviceUtils.x();
        }
        return this.u;
    }

    public long i() {
        return this.da;
    }

    public JSONArray n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.ve.keySet().isEmpty()) {
            this.sp = new JSONArray();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                try {
                    Iterator<Integer> it = this.ve.keySet().iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        uj ujVar = this.ve.get(Integer.valueOf(iIntValue));
                        if (ujVar != null && ujVar.c().length() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("slot_type", iIntValue);
                            jSONObject.put("event_cnts", ujVar.c());
                            jSONArray.put(jSONObject);
                        }
                    }
                    if (this.n != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("slot_type", -1);
                        jSONObject2.put("event_cnts", this.n.c());
                        jSONArray.put(jSONObject2);
                    }
                } catch (JSONException e) {
                    m.ve(e.getMessage());
                }
            } catch (Throwable th) {
                m.ve(th.getMessage());
            }
            this.sp = jSONArray;
        }
        if (gt.tt().hj()) {
            double dCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("cost", dCurrentTimeMillis);
                jSONObject3.put("feature_cnt", this.sp.length());
            } catch (JSONException e2) {
                m.ve(e2.getMessage());
            }
            yp.c().da(jSONObject3);
        }
        return this.sp;
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        if (!com.byazt.omf.x.m().d() && gt.tt().ri()) {
            sl().post(new Runnable() { // from class: com.byazt.qw.ve.4
                @Override // java.lang.Runnable
                public void run() {
                    c.c(c.ve, c.a(), 0L);
                    if (ve.this.n != null) {
                        ve.this.n.tt();
                    }
                    Iterator it = ve.this.ve.values().iterator();
                    while (it.hasNext()) {
                        ((uj) it.next()).tt();
                    }
                    ve.this.da = System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        if (!com.byazt.omf.x.m().d() && gt.tt().ri()) {
            sl().post(new Runnable() { // from class: com.byazt.qw.ve.5
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.u = DeviceUtils.x();
                    c.c(c.tt, 0L, c.sp());
                    c.c(c.f28985a);
                    ve.this.i = System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    public long sp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.c == 0) {
            this.c = timeInMillis;
        }
        return timeInMillis;
    }

    public void uj() {
        c();
        tt();
        c.c(c.c, 0L, 0L);
        c.c(c.uj);
    }

    public long x() {
        return this.i;
    }

    public long tt() {
        if (this.t == 0) {
            this.t = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - rh.n);
        }
        return this.t;
    }

    public long c() {
        if (this.sl == 0) {
            this.sl = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return this.sl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, @NonNull String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !gt.tt().ri()) {
            return;
        }
        if (i > 0 && i <= 10) {
            uj ujVar = this.ve.get(Integer.valueOf(i));
            if (ujVar == null) {
                ujVar = new uj(str2);
                this.ve.put(Integer.valueOf(i), ujVar);
            }
            ujVar.c(str, str3);
            return;
        }
        if (this.n == null) {
            this.n = new uj(str2);
        }
        this.n.c(str, str3);
    }

    public void c(@NonNull final String str, @NonNull final String str2, final String str3, final JSONObject jSONObject, final String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !gt.tt().ri()) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
            case "show":
            case "skip":
            case "click":
            case "feed_continue":
            case "feed_break":
            case "feed_pause":
            case "play_start":
                sl().post(new Runnable() { // from class: com.byazt.qw.ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String strOptString = str3;
                            int iOptInt = 0;
                            if (jSONObject != null) {
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject.optString("req_id");
                                }
                                iOptInt = jSONObject.optInt("ad_slot_type", 0);
                            } else if (str4 != null) {
                                JSONObject jSONObject2 = new JSONObject(str4);
                                if (TextUtils.isEmpty(strOptString)) {
                                    strOptString = jSONObject2.optString("req_id");
                                }
                                iOptInt = jSONObject2.optInt("ad_slot_type", 0);
                            }
                            ve.this.c(str, str2, strOptString, iOptInt);
                        } catch (Exception e) {
                            m.c(e);
                        }
                    }
                });
                break;
        }
    }

    public void c(@NonNull final String str, final ic icVar) {
        if (!TextUtils.isEmpty(str) && gt.tt().ri() && "videoPercent30".equals(str)) {
            sl().post(new Runnable() { // from class: com.byazt.qw.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    ic icVar2 = icVar;
                    if (icVar2 != null) {
                        String strUj = icVar2.uj();
                        if (TextUtils.isEmpty(strUj)) {
                            return;
                        }
                        ve.this.c(str, strUj, icVar.qy(), nb.sl(icVar));
                    }
                }
            });
        }
    }

    public void c(@NonNull final String str, final ic icVar, final String str2) {
        if (TextUtils.isEmpty(str) || !gt.tt().ri()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            sl().post(new Runnable() { // from class: com.byazt.qw.ve.3
                @Override // java.lang.Runnable
                public void run() {
                    ic icVar2 = icVar;
                    if (icVar2 != null) {
                        String strUj = icVar2.uj();
                        if (TextUtils.isEmpty(strUj)) {
                            return;
                        }
                        int iSl = nb.sl(icVar);
                        ve.this.c(str, strUj, icVar.qy() + str2, iSl);
                    }
                }
            });
        }
    }

    public void c(ic icVar, float f) {
        if (icVar != null) {
            this.uj.put(nb.c(icVar, ""), Float.valueOf(f));
        }
    }

    public float c(String str) {
        Float f;
        if (TextUtils.isEmpty(str) || (f = this.uj.get(str)) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }
}
