package com.byazt.nbs;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28815a;
    public JSONObject aw;
    public double bm;
    public com.byazt.hr.sp bx;
    public String c;
    public int cu;
    public double d;
    public int eo;
    public String gr;
    public String gt;
    public int gu;
    public int h;
    public int ic;
    public long l;
    public int lo;
    public double lr;
    public int m;
    public boolean md;
    public String my;
    public long n;
    public int nb;
    public long nu;
    public int or;
    public boolean p;
    public com.byazt.hr.i pf;
    public int qp;
    public int qy;
    public int rh;
    public int rl;
    public long sp;
    public int sv;
    public int tt;
    public long uj;
    public int ve;
    public String x;
    public long yv;
    public int z;
    public int zb;
    public int zm;
    public List<da> i = new CopyOnWriteArrayList();
    public Map<Integer, List<da>> da = new HashMap();
    public Map<Integer, List<da>> sl = new HashMap();
    public List<Integer> t = new ArrayList();
    public double u = -1.0d;
    public double yp = -1.0d;
    public int hd = 1000;
    public int pu = 0;
    public int lt = 2;
    public int to = 0;
    public int tk = 0;
    public long kp = 0;
    public int b = 0;
    public Map<String, Object> q = new HashMap();

    public double a() {
        return this.bm;
    }

    public long aw() {
        return this.f28815a;
    }

    public int bm() {
        return this.zb;
    }

    public long bx() {
        return this.uj;
    }

    public int c() {
        return this.b;
    }

    public String cu() {
        return this.x;
    }

    public int d() {
        return this.rh;
    }

    public int da() {
        int iMin = Math.min(this.hd, 1000);
        if (iMin <= 0) {
            return 1000;
        }
        return iMin;
    }

    public String eo() {
        return this.my;
    }

    public int gr() {
        return this.gu;
    }

    public int gt() {
        return this.qp;
    }

    public long gu() {
        return this.yv;
    }

    public long h() {
        return this.nu;
    }

    public int hd() {
        return this.eo;
    }

    public int i() {
        return this.ic;
    }

    public long ic() {
        return this.sp;
    }

    public List<da> l() {
        return this.i;
    }

    public String lo() {
        return this.gt;
    }

    public Map<Integer, List<da>> lr() {
        return this.sl;
    }

    public int lt() {
        int i = this.cu;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public int m() {
        return this.pu;
    }

    public Map<Integer, List<da>> md() {
        HashMap map = new HashMap();
        Map<Integer, List<da>> map2 = this.da;
        if (map2 != null) {
            for (Map.Entry<Integer, List<da>> entry : map2.entrySet()) {
                map.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: my, reason: merged with bridge method [inline-methods] */
    public tt clone() {
        tt ttVar = new tt();
        ttVar.c = this.c;
        ttVar.tt = this.tt;
        ttVar.ve = this.ve;
        ttVar.uj = this.uj;
        ttVar.n = this.n;
        ttVar.f28815a = this.f28815a;
        ttVar.sp = this.sp;
        ttVar.x = this.x;
        ttVar.nu = this.nu;
        ttVar.gu = this.gu;
        ttVar.gt = this.gt;
        ttVar.rh = this.rh;
        ttVar.my = this.my;
        ttVar.rl = this.rl;
        ttVar.qy = this.qy;
        ttVar.gr = this.gr;
        ttVar.zm = this.zm;
        ttVar.yv = this.yv;
        ttVar.h = this.h;
        ttVar.d = this.d;
        ttVar.or = this.or;
        ttVar.cu = this.cu;
        ttVar.qp = this.qp;
        ttVar.eo = this.eo;
        ttVar.zb = this.zb;
        ttVar.sv = this.sv;
        ttVar.bx = this.bx;
        ttVar.pf = this.pf;
        ttVar.nb = this.nb;
        ttVar.p = this.p;
        ttVar.md = this.md;
        ttVar.aw = this.aw;
        ttVar.u = this.u;
        ttVar.m = this.m;
        ttVar.i = new CopyOnWriteArrayList(this.i);
        ttVar.da = new HashMap(this.da);
        ttVar.z = this.z;
        ttVar.t = new ArrayList(this.t);
        ttVar.q = new HashMap(this.q);
        ttVar.sl = new HashMap(this.sl);
        ttVar.ic = this.ic;
        ttVar.hd = this.hd;
        ttVar.yp = this.yp;
        ttVar.l = this.l;
        ttVar.bm = this.bm;
        ttVar.lr = this.lr;
        ttVar.pu = this.pu;
        ttVar.lt = this.lt;
        ttVar.to = this.to;
        ttVar.tk = this.tk;
        ttVar.b = this.b;
        ttVar.kp = this.kp;
        return ttVar;
    }

    public double n() {
        return this.lr;
    }

    public String nb() {
        return this.c;
    }

    public int nu() {
        int i = this.lt;
        if (i < 2) {
            return 2;
        }
        return i;
    }

    public boolean or() {
        return this.md;
    }

    public double p() {
        return this.yp;
    }

    public int pf() {
        return this.tt;
    }

    public int pu() {
        return this.or;
    }

    public List<Integer> qp() {
        return this.t;
    }

    public String qy() {
        return this.gr;
    }

    public tt rh() {
        List<String> listC = com.byazt.vx.i.c();
        tt ttVar = new tt();
        ttVar.c = this.c;
        com.byazt.vx.i.c(listC, "mRitId");
        ttVar.tt = this.tt;
        com.byazt.vx.i.c(listC, "mRitType");
        ttVar.ve = this.ve;
        com.byazt.vx.i.c(listC, "mLookType");
        ttVar.uj = this.uj;
        com.byazt.vx.i.c(listC, "mMinWaitTime");
        ttVar.n = this.n;
        com.byazt.vx.i.c(listC, "mLayerTimeOut");
        ttVar.f28815a = this.f28815a;
        com.byazt.vx.i.c(listC, "mTotalTimeOut");
        ttVar.sp = this.sp;
        com.byazt.vx.i.c(listC, "mCacheTimeOut");
        ttVar.x = this.x;
        com.byazt.vx.i.c(listC, "mVersion");
        ttVar.nu = this.nu;
        com.byazt.vx.i.c(listC, "mWaterFallId");
        ttVar.gu = this.gu;
        com.byazt.vx.i.c(listC, "reqType");
        ttVar.gt = this.gt;
        com.byazt.vx.i.c(listC, "mWaterfallAbTestParam");
        ttVar.rh = this.rh;
        com.byazt.vx.i.c(listC, "segmentId");
        ttVar.my = this.my;
        com.byazt.vx.i.c(listC, "segmentVersion");
        ttVar.rl = this.rl;
        com.byazt.vx.i.c(listC, "preLoadSortControl");
        ttVar.qy = this.qy;
        com.byazt.vx.i.c(listC, "preShowSortControl");
        ttVar.gr = this.gr;
        com.byazt.vx.i.c(listC, "waterfallExtra");
        ttVar.zm = this.zm;
        com.byazt.vx.i.c(listC, "mMultilevelAfterP");
        ttVar.yv = this.yv;
        com.byazt.vx.i.c(listC, "mMultilevelTimeOut");
        ttVar.h = this.h;
        com.byazt.vx.i.c(listC, "mRefreshTime");
        ttVar.d = this.d;
        com.byazt.vx.i.c(listC, "mBidFloor");
        ttVar.or = this.or;
        com.byazt.vx.i.c(listC, "mParallelType");
        ttVar.cu = this.cu;
        com.byazt.vx.i.c(listC, "mReqParallelNum");
        ttVar.qp = this.qp;
        com.byazt.vx.i.c(listC, "mAdCount");
        ttVar.eo = this.eo;
        com.byazt.vx.i.c(listC, "serverSideVerifyPreRequestTime");
        ttVar.zb = this.zb;
        com.byazt.vx.i.c(listC, "serverSideRewardType");
        ttVar.sv = this.sv;
        com.byazt.vx.i.c(listC, "mAdPrime");
        ttVar.lt = this.lt;
        com.byazt.vx.i.c(listC, "mRefreshNum");
        ttVar.pu = this.pu;
        com.byazt.vx.i.c(listC, "mIsRefresh");
        ttVar.bx = this.bx;
        com.byazt.vx.i.c(listC, "mIntervalFreqctlBean");
        ttVar.pf = this.pf;
        com.byazt.vx.i.c(listC, "mIntervalPacingBean");
        ttVar.nb = this.nb;
        com.byazt.vx.i.c(listC, "mWaterFallTimingMode");
        ttVar.l = this.l;
        com.byazt.vx.i.c(listC, "mReqInterval");
        ttVar.bm = this.bm;
        com.byazt.vx.i.c(listC, "mTotalTimeoutRate");
        ttVar.lr = this.lr;
        com.byazt.vx.i.c(listC, "mLayerTimeoutRate");
        ttVar.q = new HashMap(this.q);
        ttVar.ic = this.ic;
        ttVar.hd = this.hd;
        ttVar.yp = this.yp;
        ttVar.sl = new HashMap(this.sl);
        com.byazt.vx.i.tt(listC, "AdsenseRitConfig");
        ttVar.to = this.to;
        com.byazt.vx.i.c(listC, "mBehaviorTTL");
        ttVar.tk = this.tk;
        com.byazt.vx.i.c(listC, "mIsSamste");
        ttVar.b = this.b;
        com.byazt.vx.i.c(listC, "fillStrategy");
        return ttVar;
    }

    public double rl() {
        return this.d;
    }

    public com.byazt.hr.sp sl() {
        return this.bx;
    }

    public long sp() {
        return this.l;
    }

    public long sv() {
        return this.n;
    }

    public com.byazt.hr.i t() {
        return this.pf;
    }

    public int to() {
        return this.to;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.c + "', mIsSpeed=" + yp() + ", mHasServerbidding=" + this.p + ", mHasClientOrMultiLevel=" + this.md + ", mRitType=" + this.tt + ", mLookType=" + this.ve + ", mMinWaitTime=" + this.uj + ", mLayerTimeOut=" + this.n + ", mTotalTimeOut=" + this.f28815a + ", mWaterFallConfigList=" + this.i + ", mWaterFallConfMap=" + this.da + ", mLoadSortLevelList=" + this.t + ", mCurrentCommonAdMaxCpm=" + this.u + ", mTotalLoadLevelCount=" + this.z + ", mTotalWaterFallCount=" + this.m + ", mWaterfallAbTestParam=" + this.gt + ", mServerSideVerifyPreRequestTime=" + this.eo + ", mServerSideVerifyRewardType=" + this.zb + '}';
    }

    public long tt() {
        return this.kp;
    }

    public boolean u() {
        return this.nb == 1;
    }

    public int uj() {
        return this.lo;
    }

    public int ve() {
        return this.tk;
    }

    public Map<String, Object> x() {
        return this.q;
    }

    public boolean yp() {
        return this.or == 3;
    }

    public double yv() {
        return this.u;
    }

    public boolean z() {
        return this.sv == 1;
    }

    public boolean zb() {
        return this.p;
    }

    public int zm() {
        return this.m;
    }

    private static Long gr(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return 5000L;
            }
            if (i != 5) {
                return (i == 7 || i == 8) ? 600000L : 10000L;
            }
        }
        return 10000L;
    }

    private static Long gu(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    public void a(int i) {
        this.sv = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public void da(int i) {
        this.qp = i;
    }

    public void gt(int i) {
        this.or = i;
    }

    public void i(int i) {
        this.lt = i;
    }

    public void m(int i) {
        this.tt = i;
    }

    public void n(int i) {
        this.hd = i;
    }

    public void nu(int i) {
        this.ve = i;
    }

    public void qy(int i) {
        this.to = i;
    }

    public void rl(int i) {
        this.cu = i;
    }

    public int sl(int i) {
        if (i() == 2) {
            int iC = com.byazt.psp.uj.c(this.c, i, x());
            if (this.h != 0 && iC != 0) {
                return iC;
            }
        }
        return this.h;
    }

    public void sp(int i) {
        this.nb = i;
    }

    public void t(int i) {
        this.h = i;
    }

    public void tt(int i) {
        this.tk = i;
    }

    public void u(int i) {
        this.zm = i;
    }

    public void uj(int i) {
        this.ic = i;
    }

    public void ve(int i) {
        this.lo = i;
    }

    public void x(int i) {
        this.pu = i;
    }

    public void yp(int i) {
        this.gu = i;
    }

    public void z(int i) {
        this.rh = i;
    }

    public void a(long j) {
        this.n = j;
    }

    public void c(long j) {
        this.kp = j;
    }

    public void n(double d) {
        this.yp = d;
    }

    public void sp(long j) {
        this.f28815a = j;
    }

    public void tt(double d) {
        if (d < 0.01d || d > 1.0d) {
            d = 0.01d;
        }
        this.bm = d;
    }

    public void uj(double d) {
        this.u = d;
    }

    public void ve(double d) {
        this.d = d;
    }

    public void x(long j) {
        this.sp = j;
    }

    public static tt sp(String str) {
        if (TextUtils.isEmpty(str)) {
            com.byazt.eu.tt.c("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return c(new JSONObject(str), true);
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public da a(String str) {
        List<da> list;
        if (!TextUtils.isEmpty(str) && (list = this.i) != null && list.size() != 0) {
            for (da daVar : this.i) {
                if (str.equals(daVar.rh())) {
                    return daVar;
                }
            }
        }
        return null;
    }

    public void c(double d) {
        if (d < 0.1d || d > 1.0d) {
            d = 0.1d;
        }
        this.lr = d;
    }

    public void n(long j) {
        this.uj = j;
    }

    public void tt(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.l = j;
    }

    public void uj(long j) {
        this.nu = j;
    }

    public void ve(long j) {
        this.yv = j;
    }

    public void c(com.byazt.hr.sp spVar) {
        this.bx = spVar;
    }

    public void n(String str) {
        this.gt = str;
    }

    public void tt(String str) {
        this.my = str;
    }

    public void uj(String str) {
        this.c = str;
    }

    public void ve(String str) {
        this.x = str;
    }

    private void uj(List<da> list) {
        int iYv;
        List<da> arrayList;
        if (list == null) {
            return;
        }
        this.sl.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            da daVar = list.get(i2);
            if (daVar != null) {
                if (daVar.yv() != i) {
                    arrayList = new ArrayList<>();
                    iYv = daVar.yv();
                } else {
                    iYv = i;
                    arrayList = this.sl.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(daVar);
                    this.sl.put(Integer.valueOf(iYv), arrayList);
                }
                i = iYv;
            }
        }
    }

    private void ve(List<da> list) {
        int iYv;
        List<da> arrayList;
        if (list == null) {
            return;
        }
        this.sl.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            da daVar = list.get(i2);
            if (daVar != null) {
                if (daVar.my() == 0) {
                    arrayList = new ArrayList<>();
                    iYv = daVar.p();
                } else if (daVar.yv() != i) {
                    arrayList = new ArrayList<>();
                    iYv = daVar.yv();
                } else {
                    iYv = i;
                    arrayList = this.sl.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(daVar);
                    this.sl.put(Integer.valueOf(iYv), arrayList);
                }
                i = iYv;
            }
        }
    }

    public void c(com.byazt.hr.i iVar) {
        this.pf = iVar;
    }

    public void tt(boolean z) {
        this.md = z;
    }

    public void c(String str) {
        this.gr = str;
    }

    public void tt(List<da> list) {
        int iYv;
        List<da> arrayList;
        ve(list);
        this.i = list;
        if (list == null) {
            return;
        }
        this.z = 0;
        this.da.clear();
        this.t.clear();
        this.m = this.i.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            da daVar = list.get(i2);
            if (daVar != null) {
                if (daVar.my() == 0) {
                    this.z++;
                    arrayList = new ArrayList<>();
                    iYv = daVar.p();
                } else if (daVar.yv() != i) {
                    this.z++;
                    arrayList = new ArrayList<>();
                    iYv = daVar.yv();
                } else {
                    iYv = i;
                    arrayList = this.da.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(daVar);
                    this.da.put(Integer.valueOf(iYv), arrayList);
                }
                i = iYv;
            }
        }
        this.t.addAll(this.da.keySet());
    }

    public void c(boolean z) {
        this.p = z;
    }

    public void c(List<da> list) {
        int iYv;
        List<da> arrayList;
        uj(list);
        this.i = list;
        if (list == null) {
            return;
        }
        this.z = 0;
        this.da.clear();
        this.t.clear();
        this.m = this.i.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            da daVar = list.get(i2);
            if (daVar != null) {
                if (daVar.yv() != i) {
                    this.z++;
                    arrayList = new ArrayList<>();
                    iYv = daVar.yv();
                } else {
                    iYv = i;
                    arrayList = this.da.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(daVar);
                    this.da.put(Integer.valueOf(iYv), arrayList);
                }
                i = iYv;
            }
        }
        this.t.addAll(this.da.keySet());
    }

    public void c(JSONObject jSONObject) {
        this.aw = jSONObject;
    }

    public static tt c(JSONObject jSONObject, boolean z) {
        String str = null;
        if (jSONObject == null) {
            return null;
        }
        tt ttVar = new tt();
        ttVar.c(jSONObject);
        ttVar.ve(jSONObject.optDouble("bid_floor", AudioStats.AUDIO_AMPLITUDE_NONE));
        ttVar.uj(jSONObject.optString("rit_id"));
        ttVar.ve(jSONObject.optString("version"));
        ttVar.uj(jSONObject.optLong("waterfall_id", -1L));
        ttVar.m(jSONObject.optInt("rit_type"));
        ttVar.nu(jSONObject.optInt("look_type", 1));
        ttVar.n(jSONObject.optLong("time_min", gu(ttVar.pf()).longValue()));
        ttVar.a(jSONObject.optLong("layer_time_out", 2000L));
        ttVar.sp(jSONObject.optLong("total_time_out", gr(ttVar.pf()).longValue()));
        ttVar.ve(jSONObject.optLong("multilevel_time_out", 2000L));
        ttVar.x(jSONObject.optLong("cache_time_out", 3000L));
        int i = 0;
        ttVar.yp(jSONObject.optInt("req_type", 0));
        com.byazt.ix.uj.c().c(ttVar.nb(), ttVar.gr());
        ttVar.z(jSONObject.optInt("segment_id"));
        ttVar.tt(jSONObject.optString("segment_version"));
        ttVar.c(jSONObject.optString("waterfall_extra"));
        ttVar.u(jSONObject.optInt("multilevel_after_p", 1));
        ttVar.t(jSONObject.optInt("refresh_time", 0));
        ttVar.x(jSONObject.optInt("is_refresh", 0));
        ttVar.i(jSONObject.optInt("refresh_num", 2));
        ttVar.gt(jSONObject.optInt("parallel_type", 1));
        ttVar.a(jSONObject.optInt("is_adprime", 0));
        ttVar.rl(jSONObject.optInt("req_parallel_num", 1));
        ttVar.rh(jSONObject.optInt("reward_start_time", 15000));
        ttVar.my(jSONObject.optInt("reward_callback_type"));
        ttVar.tt(jSONObject.optLong("req_interval", 1000L));
        ttVar.tt(jSONObject.optDouble("total_time_rate", 0.01d));
        ttVar.c(jSONObject.optDouble("layer_time_rate", 0.1d));
        ttVar.ve(jSONObject.optInt("support_render_control", 0));
        ttVar.qy(jSONObject.optInt("behavior_ttl"));
        ttVar.c(jSONObject.optLong("save_time"));
        int iOptInt = jSONObject.optInt("ad_count", 0);
        if (iOptInt < 0) {
            iOptInt = 0;
        } else if (iOptInt > 3) {
            iOptInt = 3;
        }
        ttVar.da(iOptInt);
        ttVar.uj(jSONObject.optInt("group_type"));
        ttVar.n(jSONObject.optInt("bidding_time_out", 1000));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("waterfall_abtest");
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("waterfall_ab_version");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString.trim()) || TextUtils.equals(strOptString.trim(), "null")) {
                jSONObjectOptJSONObject.remove("waterfall_ab_version");
            }
            ttVar.n(jSONObjectOptJSONObject.toString());
        }
        int iOptInt2 = jSONObject.optInt("waterfall_timing_mode");
        ttVar.sp(iOptInt2);
        if (ttVar.u()) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (jSONObjectOptJSONObject2 != null) {
                ttVar.c(new com.byazt.hr.i(ttVar.nb(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONObjectOptJSONObject2.optString("waterfall_show_pacing"), jSONObjectOptJSONObject2.optString("waterfall_show_pacing_rule_id")));
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            ttVar.c(new com.byazt.hr.sp(ttVar.nb(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONArrayOptJSONArray == null ? "[]" : jSONArrayOptJSONArray.toString()));
        }
        ttVar.tt(jSONObject.optInt("is_smaste", 0));
        ttVar.c(jSONObject.optInt("fill_strategy", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            int i2 = 0;
            while (i2 < jSONArrayOptJSONArray2.length()) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    da daVar = new da();
                    daVar.ve(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME));
                    if (com.byazt.bp.tt.tt().ve(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME))) {
                        daVar.uj(jSONObject2.optString("custom_adn_name"));
                    } else {
                        daVar.uj(str);
                    }
                    daVar.x(ttVar.lo());
                    String strOptString2 = jSONObject2.optString("adn_slot_id");
                    daVar.n(strOptString2);
                    if (!z && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(ttVar.nb())) {
                        com.byazt.qv.uj.tt.put(strOptString2, ttVar.nb());
                    }
                    daVar.c(jSONObject2.optInt("is_refresh", i));
                    int iOptInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    daVar.tt(iOptInt3);
                    if (daVar.uj()) {
                        JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("show_pacing_rule");
                        if (jSONObjectOptJSONObject3 != null) {
                            daVar.c(new com.byazt.hr.i(ttVar.nb(), strOptString2, "", "", iOptInt3, jSONObjectOptJSONObject3.optString("pacing"), jSONObjectOptJSONObject3.optString("rule_id")));
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                        try {
                            daVar.c(new com.byazt.hr.sp(ttVar.nb(), strOptString2, "", jSONObject2.optString("show_freqctl_rules_version"), iOptInt3, jSONArrayOptJSONArray3 == null ? "[]" : jSONArrayOptJSONArray3.toString()));
                        } catch (JSONException e) {
                            e = e;
                            i = 0;
                            m.c(e);
                            i2++;
                            str = null;
                        }
                    }
                    daVar.da(jSONObject2.optInt("req_bidding_type"));
                    daVar.sp(jSONObject2.optString("slot_cpm", "0"));
                    daVar.a(jSONObject2.optString("discount"));
                    daVar.tt(jSONObject2.optString("exchange_rate"));
                    daVar.sl(jSONObject2.optInt("load_sort"));
                    daVar.t(jSONObject2.optInt("show_sort"));
                    daVar.uj(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.byazt.ix.uj.c().c(ttVar.nb(), daVar.rh(), daVar.x());
                    com.byazt.hk.c.c().c(ttVar.nb(), daVar.rh(), daVar.x());
                    try {
                        daVar.x(jSONObject2.optInt("if_is_ready", 1));
                        com.byazt.ix.uj.c().tt(ttVar.nb(), daVar.rh(), daVar.t());
                        com.byazt.hk.c.c().tt(ttVar.nb(), daVar.rh(), daVar.t());
                        daVar.n(jSONObject2.optInt("if_reuse_ads", 0));
                        com.byazt.hk.c.c().ve(ttVar.nb(), daVar.rh(), daVar.i());
                        i = 0;
                        daVar.sp(jSONObject2.optInt("if_pre_request", 0));
                        com.byazt.hk.c.c().a(ttVar.nb(), daVar.rh(), daVar.sl());
                        daVar.i(ttVar.pf());
                        daVar.c("%1$s%2$sAdapter");
                        daVar.a(jSONObject2.optInt("origin_type"));
                        daVar.ve(jSONObject2.optInt("sub_adtype"));
                        daVar.c(tt(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                        try {
                            if (daVar.my() == 1) {
                                try {
                                    ttVar.tt(true);
                                } catch (JSONException e2) {
                                    e = e2;
                                    m.c(e);
                                    i2++;
                                    str = null;
                                }
                            } else {
                                if (daVar.my() == 2) {
                                    try {
                                        ttVar.c(true);
                                    } catch (JSONException e3) {
                                        e = e3;
                                        m.c(e);
                                        i2++;
                                        str = null;
                                    }
                                } else if (daVar.my() == 3) {
                                    ttVar.tt(true);
                                } else if (daVar.my() != 100) {
                                    if (ttVar.yv() == -1.0d || ttVar.yv() < daVar.gr()) {
                                        ttVar.uj(daVar.gr());
                                    }
                                    if (ttVar.p() == -1.0d || ttVar.p() > daVar.gr()) {
                                        ttVar.n(daVar.gr());
                                    }
                                }
                                daVar.da(jSONObject2.optString("customer_adapter_json"));
                                arrayList.add(daVar);
                                i2++;
                                str = null;
                            }
                            daVar.da(jSONObject2.optString("customer_adapter_json"));
                            arrayList.add(daVar);
                        } catch (JSONException e4) {
                            e = e4;
                            m.c(e);
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        i = 0;
                    }
                } catch (JSONException e6) {
                    e = e6;
                }
                i2++;
                str = null;
            }
        }
        Collections.sort(arrayList);
        if (ttVar.yp()) {
            ttVar.tt(arrayList);
        } else {
            ttVar.c(arrayList);
        }
        return ttVar;
    }

    private static Map<String, String> tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys == null) {
                return null;
            }
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                    map.put(next, strOptString);
                }
            }
            if (map.size() == 0) {
                return null;
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public void my(int i) {
        this.zb = i;
    }

    public void rh(int i) {
        this.eo = i;
    }
}
