package com.byazt.jzl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.dna.z;
import com.byazt.fk.u;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1574, 46})
public class n implements tt {
    public static final AtomicInteger rl = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28714a;
    public StringBuilder c;
    public double da;
    public int gr;
    public int gt;
    public String gu;
    public String i;
    public int m;
    public String my;
    public String n;
    public int nu;
    public int qy;
    public boolean rh;
    public double sl;
    public String sp;
    public long t;
    public JSONArray tt;
    public long u;
    public String uj;
    public String ve;
    public StringBuilder x;
    public long yp;
    public int z;
    public JSONObject zm;

    @com.byazt.zqa.c(c = {0, 1, 1574, 151})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f28715a;
        public String c;
        public double da;
        public int n;
        public int sp;
        public JSONObject t;
        public String tt;
        public String uj;
        public String ve;
        public int x;
        public int i = -1;
        public String sl = "";

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c tt(String str) {
            this.ve = str;
            return this;
        }

        public c uj(String str) {
            this.uj = str;
            return this;
        }

        public c ve(String str) {
            this.tt = str;
            return this;
        }

        public c c(double d) {
            this.da = d;
            return this;
        }

        public c tt(int i) {
            this.sp = i;
            return this;
        }

        public c uj(int i) {
            this.i = i;
            return this;
        }

        public c ve(int i) {
            this.x = i;
            return this;
        }

        public c c(int i) {
            this.n = i;
            return this;
        }

        public c c(long j) {
            this.f28715a = j;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.t = jSONObject;
            return this;
        }

        public n c() {
            return new n(this);
        }
    }

    @Override // com.byazt.jzl.tt
    public void c(int i, int i2, String str) {
        this.nu = i;
        this.gt = i2;
        this.my = str;
    }

    @Override // com.byazt.jzl.tt
    public void tt(String str) {
        int iIndexOf = this.x.indexOf(str);
        if (TextUtils.isEmpty(this.x)) {
            this.x.append(str);
        } else if (iIndexOf == -1) {
            StringBuilder sb = this.x;
            sb.append(",");
            sb.append(str);
        }
    }

    public String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str.hashCode();
        switch (str) {
            case "0501":
                return "created";
            case "0502":
                return "bindview";
            case "0503":
                return "initialized";
            case "0504":
                return "prepared";
            case "0505":
                return "started";
            case "0506":
                return "played";
            case "0507":
                return "paused";
            case "0508":
                return "stopped";
            case "0509":
                return "completed";
            case "0510":
                return "error";
            default:
                return "unknown";
        }
    }

    private n() {
        this.c = new StringBuilder();
        this.tt = new JSONArray();
        this.nu = -8888;
        this.rh = false;
        this.gt = -8888;
        this.qy = 0;
        this.gr = -1;
        this.qy = rl.addAndGet(1);
    }

    @Override // com.byazt.jzl.tt
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", this.n);
            jSONObject.put("cid", this.uj);
            jSONObject.put("adtype", this.f28714a);
            jSONObject.put("req_id", this.ve);
            jSONObject.put("duration", this.sp);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject tt() {
        JSONObject jSONObject = this.zm;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("session_id", this.x.toString());
            jSONObject.put("node_line", this.c.toString());
            jSONObject.put("node_line_detail", this.tt.toString());
            jSONObject.put("video_url", this.i);
            jSONObject.put(CropKey.VIDEO_DURATION, this.da);
            jSONObject.put("video_size", this.sl);
            jSONObject.put("start_duration", this.u - this.t);
            jSONObject.put("play_duration", SystemClock.elapsedRealtime() - this.t);
            jSONObject.put("play_cache_size", this.yp);
            jSONObject.put("play_type", this.z);
            jSONObject.put("player_type", this.m);
            jSONObject.put("video_index", this.qy);
            jSONObject.put("is_audio", this.rh ? 1 : 0);
            jSONObject.put("dynamic_join_type", this.gr);
            int i = this.nu;
            if (i != -8888) {
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i);
            }
            jSONObject.put("error_msg", this.my);
            int i2 = this.gt;
            if (i2 != -8888) {
                jSONObject.put("extra_error_code", i2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.jzl.tt
    public void c(String str) {
        this.c.append(str);
        String strVe = ve(str);
        JSONObject jSONObject = new JSONObject();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.equals("0505", str)) {
            this.t = jElapsedRealtime;
        } else if (TextUtils.equals("0506", str)) {
            this.u = jElapsedRealtime;
        }
        try {
            jSONObject.putOpt("type", strVe);
            jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        this.tt.put(jSONObject);
    }

    private n(c cVar) {
        this.c = new StringBuilder();
        this.tt = new JSONArray();
        this.nu = -8888;
        this.rh = false;
        this.gt = -8888;
        this.qy = 0;
        this.gr = -1;
        this.ve = cVar.tt;
        this.uj = cVar.ve;
        this.n = cVar.uj;
        this.f28714a = cVar.n;
        this.z = cVar.x;
        this.gr = cVar.i;
        this.yp = cVar.f28715a;
        this.m = cVar.sp;
        this.da = cVar.da;
        this.gu = cVar.c;
        this.zm = cVar.t;
        String str = cVar.sl;
        this.x = new StringBuilder(TextUtils.isEmpty(str) ? "" : str);
        this.qy = rl.addAndGet(1);
    }

    @Override // com.byazt.jzl.tt
    public void c(long j, u uVar) {
        z zVar = (z) com.byazt.ut.uj.getService("event");
        if (zVar == null || uVar == null) {
            return;
        }
        this.sl = uVar.getVideoSize();
        this.rh = uVar.isAudio();
        this.sp = String.valueOf(j);
        this.i = uVar.getUrl();
        zVar.onStatsEvent(this.gu, c(), tt());
    }
}
