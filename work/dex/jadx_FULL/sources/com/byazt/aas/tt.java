package com.byazt.aas;

import android.os.SystemClock;
import android.text.TextUtils;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 13})
public class tt {
    public static volatile tt c;
    public com.byazt.iy.n da;
    public com.byazt.iy.n i;
    public com.byazt.iy.n sp;
    public com.byazt.iy.n x;
    public volatile int sl = 0;
    public int t = 0;
    public int u = 0;
    public final Map<String, Integer> tt = new HashMap();
    public final ConcurrentHashMap<String, Integer> ve = new ConcurrentHashMap<>();
    public final Map<String, Long> uj = new HashMap();
    public final ConcurrentHashMap<String, Long> n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f28278a = SystemClock.elapsedRealtime();

    private tt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.iy.n a() {
        if (this.i == null) {
            this.i = eo.c("activity_foreground_time");
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.iy.n n() {
        if (this.x == null) {
            this.x = eo.c("activity_adshow_count");
        }
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.iy.n sp() {
        if (this.da == null) {
            this.da = eo.c("activity_recorder");
        }
        return this.da;
    }

    public void tt(final String str) {
        com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.tt.1
            @Override // java.lang.Runnable
            public void run() {
                tt.this.uj().put(str, tt.this.uj().get(str, 0) + 1);
                if (tt.this.sl == 0) {
                    tt ttVar = tt.this;
                    ttVar.sl = ttVar.sp().get("histRunningCount", 0) + 1;
                    tt.this.sp().put("histRunningCount", tt.this.sl);
                }
            }
        });
    }

    public void uj(final String str) {
        com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.tt.3
            @Override // java.lang.Runnable
            public void run() {
                tt.this.n().put(str, tt.this.n().get(str, 0) + 1);
            }
        });
    }

    public void ve(String str) {
        Long lRemove;
        if (TextUtils.isEmpty(str) || (lRemove = this.n.remove(str)) == null) {
            return;
        }
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - lRemove.longValue()) / 1000;
        if (jElapsedRealtime >= 0) {
            Long l = this.uj.get(str);
            if (l == null || l.longValue() < 0) {
                l = 0L;
            }
            this.uj.put(str, Long.valueOf(l.longValue() + jElapsedRealtime));
            c(str, jElapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.iy.n uj() {
        if (this.sp == null) {
            this.sp = eo.c("activity_resume_count");
        }
        return this.sp;
    }

    public void tt() {
        if (this.n.size() == 1) {
            for (String str : this.n.keySet()) {
                Integer num = this.ve.get(str);
                this.ve.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                uj(str);
            }
        }
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.tt.get(str);
        this.tt.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.n.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.n.size() > 1) {
            this.t++;
        }
        tt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        try {
            Map all = uj().getAll();
            if (all == null) {
                return;
            }
            Iterator it = all.values().iterator();
            int iIntValue = 0;
            while (it.hasNext()) {
                iIntValue += ((Integer) it.next()).intValue();
            }
            if (iIntValue != 0 && iIntValue % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.tt.keySet()) {
                    Integer num = this.tt.get(str);
                    Long l = this.uj.get(str);
                    Integer num2 = this.ve.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str);
                        jSONObject.put("rc", num != null ? num.intValue() : 0);
                        jSONObject.put(AliyunLogKey.KEY_FILE_TYPE, l != null ? l.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.byazt.nr.m.c(e);
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map all2 = a().getAll();
                Map all3 = n().getAll();
                if (all2 != null && all3 != null) {
                    for (String str2 : all.keySet()) {
                        Integer num3 = (Integer) all.get(str2);
                        Long l2 = (Long) all2.get(str2);
                        Integer num4 = (Integer) all3.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str2);
                            jSONObject2.put("rc", num3 != null ? num3.intValue() : 0);
                            jSONObject2.put(AliyunLogKey.KEY_FILE_TYPE, l2 != null ? l2.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e2) {
                            com.byazt.nr.m.c(e2);
                        }
                    }
                }
                final long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.f28278a) / 1000;
                com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.tt.4
                    @Override // com.byazt.ee.c
                    public com.byazt.qal.c c() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", jElapsedRealtime);
                        jSONObject3.put("hrc", tt.this.sl);
                        jSONObject3.put("drc", tt.this.t);
                        return com.byazt.qal.tt.tt().c("ad_activity_record").tt(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    public void c(final String str, final long j) {
        com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.tt.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = tt.this.a().get(str, 0L);
                tt.this.a().put(str, (j2 >= 0 ? j2 : 0L) + j);
                tt.this.ve();
                tt.this.c(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int i = this.u;
        if (i == 0) {
            try {
                Map all = a().getAll();
                if (all != null) {
                    Iterator it = all.values().iterator();
                    while (it.hasNext()) {
                        this.u = (int) (((long) this.u) + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.u = -1;
            }
        } else {
            this.u = (int) (((long) i) + j);
        }
        gr.c(this.u, this.sl);
    }
}
