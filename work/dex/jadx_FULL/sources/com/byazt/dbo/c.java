package com.byazt.dbo;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 961, 20})
public class c {
    public String sp;
    public final int t;
    public a x;
    public final AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f28382a = new AtomicBoolean(false);
    public List<ic> c = new ArrayList();
    public List<ic> tt = new ArrayList();
    public List<ic> ve = new ArrayList();
    public List<String> uj = new ArrayList();
    public long i = -1;
    public long da = -1;
    public long sl = -1;
    public final Runnable u = new Runnable() { // from class: com.byazt.dbo.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f28382a.get()) {
                return;
            }
            c.this.n.set(true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(c.this.tt);
            for (ic icVar : c.this.ve) {
                int iC = c.this.c(icVar);
                if (iC == 2) {
                    icVar.i(100009L);
                    arrayList.add(icVar);
                } else if (iC == 1) {
                    icVar.i(100008L);
                } else {
                    icVar.i(100003L);
                    arrayList2.add(icVar);
                }
            }
            if (!arrayList.isEmpty() && c.this.x != null) {
                c.this.x.ve(arrayList);
            }
            c.this.tt(arrayList2);
        }
    };

    public c(int i) {
        this.t = i;
    }

    private void uj(List<ic> list) {
        list.size();
        Iterator<ic> it = list.iterator();
        while (it.hasNext()) {
            ve(it.next());
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.tt(list);
        }
        c();
    }

    private void ve(long j) {
        this.sl = j;
    }

    public void tt(long j) {
        this.da = j;
    }

    private JSONObject tt(int i, List<ic> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<ic> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(tt(it.next()));
            }
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    private void ve(List<ic> list) {
        list.size();
        Iterator<ic> it = list.iterator();
        while (it.hasNext()) {
            ve(it.next());
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.c(list);
        }
        c();
    }

    public void c() {
        this.x = null;
        da.ve().removeCallbacks(this.u);
    }

    public void c(long j) {
        this.i = j;
    }

    public void c(List<ic> list, a aVar) {
        this.x = aVar;
        c(list);
    }

    private void ve(ic icVar) {
        ve(System.currentTimeMillis());
        if (icVar.xw() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String strTt = nb.tt(this.t);
            long j = this.da;
            long j2 = this.i;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.sl;
            long j4 = this.da;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.sl;
            long j6 = this.i;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.sp);
            jSONObject.put("creative_check_duration", icVar.ym() != null ? icVar.ym().optLong("creative_check_duration", 0L) : -1L);
            ve.c(icVar, jSONObject, false);
            com.byazt.ddx.uj.ve(icVar, strTt, jSONObject);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e6  */
    private void c(List<ic> list) {
        int i;
        boolean z;
        boolean z2;
        this.c = list;
        this.tt.clear();
        this.ve.clear();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        for (ic icVar : list) {
            this.uj.add(icVar.sf());
            JSONObject jSONObjectYm = icVar.ym();
            if (jSONObjectYm == null) {
                icVar.x(-1L);
                this.tt.add(icVar);
            } else {
                int iOptInt = jSONObjectYm.optInt("cache_correct_type", i2);
                int iOptInt2 = jSONObjectYm.optInt("is_need_cache_correct", i2);
                int iOptInt3 = jSONObjectYm.optInt("is_need_cache_check", i2);
                int i3 = iOptInt == 1 ? 1 : i2;
                int i4 = iOptInt2 == 1 ? 1 : i2;
                int i5 = iOptInt3 == 1 ? 1 : i2;
                if (i3 == 0) {
                    this.tt.add(icVar);
                    icVar.x(0L);
                } else if (i4 == 0 && i5 == 0) {
                    this.tt.add(icVar);
                    icVar.x(2L);
                    icVar.i(100002L);
                } else if (i4 == 0) {
                    this.ve.add(icVar);
                    icVar.x(3L);
                    z3 = true;
                } else {
                    long jOptLong = jSONObjectYm.optLong("creative_check_duration", 0L);
                    if (jOptLong > 0) {
                        z = z3;
                        z2 = Math.abs(((double) (System.currentTimeMillis() / 1000)) - nb.z(icVar)) <= ((double) jOptLong);
                        if (z2) {
                            if (i5 == 0) {
                                this.tt.add(icVar);
                                icVar.x(4L);
                                icVar.i(100002L);
                                z3 = z;
                            } else {
                                this.ve.add(icVar);
                                icVar.x(6L);
                                z3 = true;
                            }
                        } else if (i5 == 0) {
                            this.ve.add(icVar);
                            icVar.x(5L);
                            z4 = true;
                            z3 = z;
                        } else {
                            this.ve.add(icVar);
                            icVar.x(7L);
                            z3 = true;
                            z4 = true;
                        }
                        i2 = 0;
                    } else {
                        z = z3;
                    }
                    if (z2) {
                        if (i5 == 0) {
                            this.tt.add(icVar);
                            icVar.x(4L);
                            icVar.i(100002L);
                            z3 = z;
                        } else {
                            this.ve.add(icVar);
                            icVar.x(6L);
                            z3 = true;
                        }
                    } else if (i5 == 0) {
                        this.ve.add(icVar);
                        icVar.x(5L);
                        z4 = true;
                        z3 = z;
                    } else {
                        this.ve.add(icVar);
                        icVar.x(7L);
                        z3 = true;
                        z4 = true;
                    }
                    i2 = 0;
                }
            }
            z = z3;
            z3 = z;
            i2 = 0;
        }
        boolean z5 = z3;
        if (!this.ve.isEmpty() && (z5 || z4)) {
            if (z5 && z4) {
                i = 3;
            } else if (z5) {
                i = 1;
            } else {
                i = z4 ? 2 : 0;
            }
            c(i, this.ve);
            return;
        }
        ve(this.tt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(List<ic> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.uj) {
            for (ic icVar : list) {
                if (str.equals(icVar.sf())) {
                    arrayList.add(icVar);
                }
            }
        }
        uj(arrayList);
    }

    private JSONObject tt(ic icVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strUj = icVar.uj();
            String strW_ = icVar.w_();
            Map<String, Object> mapYt = icVar.yt();
            String string = "";
            if (mapYt != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapYt.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            c(strUj, strW_, string, icVar.qy(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void c(final int i, final List<ic> list) {
        Iterator<ic> it = list.iterator();
        long jMin = 2147483647L;
        while (it.hasNext()) {
            JSONObject jSONObjectYm = it.next().ym();
            long jOptLong = jSONObjectYm == null ? 0L : jSONObjectYm.optLong("correct_interface_timeout", 0L);
            if (jOptLong > 0) {
                jMin = Math.min(jMin, jOptLong);
            }
        }
        if (jMin == 2147483647L) {
            jMin = 0;
        }
        if (jMin > 0) {
            da.ve().postDelayed(this.u, jMin);
        }
        gt.c().c(tt(i, list), new tt<n>() { // from class: com.byazt.dbo.c.2
            @Override // com.byazt.dbo.tt
            public void c(n nVar, long j, long j2) {
                try {
                    c.this.c(i, list, nVar, j);
                } catch (Exception e) {
                    m.c(e);
                    e.getMessage();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, List<ic> list, n nVar, long j) throws JSONException {
        a aVar;
        if (this.n.get()) {
            return;
        }
        this.f28382a.set(true);
        if (nVar == null || nVar.c()) {
            uj(Collections.emptyList());
            return;
        }
        if (j != 20000) {
            Iterator<ic> it = list.iterator();
            while (it.hasNext()) {
                it.next().i(100001L);
            }
            tt(this.c);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = nVar.tt;
        for (ic icVar : list) {
            String strC = n.c(icVar.uj(), icVar.qy());
            JSONObject jSONObject = TextUtils.isEmpty(strC) ? null : map.get(strC);
            if (jSONObject == null) {
                icVar.i(100004L);
                arrayList.add(icVar);
            } else {
                icVar.da(jSONObject.optLong("cali_timestamp", 0L));
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String strOptString = jSONObject.optString(LoginConstants.EXT);
                            String strOptString2 = jSONObject.optString("media_ext");
                            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                                icVar.gr(strOptString);
                                icVar.c(c(new JSONObject(strOptString2), icVar.yt()));
                            } else {
                                icVar.i(100006L);
                                arrayList.add(icVar);
                            }
                        }
                        icVar.i(100000L);
                        arrayList.add(icVar);
                    } else {
                        arrayList2.add(icVar);
                        this.sp = jSONObject.optString(MediationConstant.KEY_REASON);
                        icVar.i(100007L);
                    }
                } else {
                    icVar.i(100005L);
                    arrayList.add(icVar);
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ve((ic) it2.next());
        }
        if (!arrayList2.isEmpty() && (aVar = this.x) != null) {
            aVar.ve(arrayList2);
        }
        arrayList.addAll(this.tt);
        tt(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(ic icVar) {
        JSONObject jSONObjectYm = icVar == null ? null : icVar.ym();
        int iOptInt = jSONObjectYm == null ? 0 : jSONObjectYm.optInt("cache_correct_fallback_type", 0);
        if (iOptInt == 0 || iOptInt == 1 || iOptInt == 2) {
            return iOptInt;
        }
        return 0;
    }

    public static Map<String, Object> c(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private void c(String str, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String upperCase = com.byazt.nr.a.tt("id=" + str + "&timestamp=" + iCurrentTimeMillis + "&ext=" + str2 + "&media_ext=" + str3 + "&req_id=" + str4).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put("timestamp", iCurrentTimeMillis);
        jSONObject.put(LoginConstants.EXT, str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put(UserTrackConstant.SIGN, upperCase);
    }
}
