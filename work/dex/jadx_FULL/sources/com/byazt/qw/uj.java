package com.byazt.qw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 726, 15})
public class uj implements Comparable<uj> {
    public int n;
    public int sp;
    public final String tt;
    public int ve;
    public long yp;
    public final ArrayList<Long> c = new ArrayList<>();
    public final ArrayList<Long> uj = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Long> f28987a = new ArrayList<>();
    public final ArrayList<Long> x = new ArrayList<>();
    public final HashMap<String, n> i = new HashMap<>();
    public int da = 0;
    public int sl = 0;
    public final HashMap<String, n> t = new HashMap<>();
    public int u = 0;

    public uj(String str) {
        this.tt = str;
    }

    private void tt(@NonNull JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<Integer> listGl = gt.tt().gl();
        long j = 60000;
        if (listGl != null) {
            int i = 0;
            while (i < listGl.size()) {
                int iIntValue = listGl.get(i).intValue();
                long j2 = jElapsedRealtime - (((long) iIntValue) * j);
                Iterator<String> it = this.t.keySet().iterator();
                long jC = 0;
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    HashSet hashSet3 = hashSet2;
                    n nVar = this.t.get(it.next());
                    if (nVar != null) {
                        jC += nVar.c(j2, jElapsedRealtime);
                    }
                    hashSet2 = hashSet3;
                    it = it2;
                }
                HashSet hashSet4 = hashSet2;
                if (jC != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", "lpstay_".concat(String.valueOf(iIntValue)));
                    jSONObject.put("v", jC);
                    jSONArray.put(jSONObject);
                }
                i++;
                hashSet2 = hashSet4;
                j = 60000;
            }
        }
        HashSet hashSet5 = hashSet2;
        if (listGl != null) {
            int i2 = 0;
            while (i2 < listGl.size()) {
                int iIntValue2 = listGl.get(i2).intValue();
                long j3 = jElapsedRealtime - (((long) iIntValue2) * 60000);
                Iterator<String> it3 = this.i.keySet().iterator();
                long jC2 = 0;
                while (it3.hasNext()) {
                    List<Integer> list = listGl;
                    n nVar2 = this.i.get(it3.next());
                    if (nVar2 != null) {
                        jC2 += nVar2.c(j3, jElapsedRealtime);
                    }
                    listGl = list;
                }
                List<Integer> list2 = listGl;
                if (jC2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("t", "vstay_".concat(String.valueOf(iIntValue2)));
                    jSONObject2.put("v", jC2);
                    jSONArray.put(jSONObject2);
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    this.t.remove((String) it4.next());
                }
                Iterator it5 = hashSet5.iterator();
                while (it5.hasNext()) {
                    this.i.remove((String) it5.next());
                }
                i2++;
                listGl = list2;
            }
        }
        if (gt.tt().ts() && this.da != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", "vstay_0");
            jSONObject3.put("v", this.da);
            jSONArray.put(jSONObject3);
        }
        if (gt.tt().ts() && this.u != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("t", "lpstay_0");
            jSONObject4.put("v", this.u);
            jSONArray.put(jSONObject4);
        }
        if (this.sl != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("t", "v30p");
            jSONObject5.put("v", this.sl);
            jSONArray.put(jSONObject5);
        }
    }

    public void c(@NonNull String str, @Nullable String str2) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (nVar = this.t.get(str2)) != null) {
                    nVar.uj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (nVar2 = this.t.get(str2)) != null) {
                    nVar2.ve(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    n nVar7 = this.t.get(str2);
                    if (nVar7 == null) {
                        nVar7 = new n();
                        this.t.put(str2, nVar7);
                    }
                    nVar7.c(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (nVar3 = this.i.get(str2)) != null && nVar3.c() != n.n) {
                    nVar3.tt(SystemClock.elapsedRealtime());
                    if (gt.tt().ts()) {
                        this.da = (int) (((long) this.da) + nVar3.c(this.yp, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "show":
                this.c.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (gt.tt().ts()) {
                    this.ve++;
                    break;
                }
                break;
            case "click":
                this.uj.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (gt.tt().ts()) {
                    this.n++;
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (nVar4 = this.i.get(str2)) != null) {
                    nVar4.uj(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (nVar5 = this.i.get(str2)) != null) {
                    nVar5.ve(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (nVar6 = this.t.get(str2)) != null && nVar6.c() != n.n) {
                    nVar6.tt(SystemClock.elapsedRealtime());
                    if (gt.tt().ts()) {
                        this.u = (int) (((long) this.u) + nVar6.c(this.yp, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (gt.tt().ts()) {
                    this.sl++;
                    break;
                }
                break;
            case "dislike":
                this.x.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "play_start":
                this.f28987a.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (gt.tt().ts()) {
                    this.sp++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    n nVar8 = this.i.get(str2);
                    if (nVar8 == null) {
                        nVar8 = new n();
                        this.i.put(str2, nVar8);
                    }
                    nVar8.c(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    public void tt() {
        this.yp = SystemClock.elapsedRealtime();
        this.sl = 0;
        this.n = 0;
        this.ve = 0;
        this.u = 0;
        this.da = 0;
        this.sp = 0;
    }

    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            c(jSONArray);
            tt(jSONArray);
        } catch (Throwable th) {
            m.ve(th.getMessage());
        }
        return jSONArray;
    }

    private void c(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) throws JSONException {
        int size = arrayList.size() - 1;
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            long j2 = j - (((long) iIntValue) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", str + iIntValue);
                jSONObject.put("v", i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void c(@NonNull JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c("show_", jSONArray, this.c, gt.tt().gl(), jElapsedRealtime);
        c("click_", jSONArray, this.uj, gt.tt().gl(), jElapsedRealtime);
        c("play_", jSONArray, this.f28987a, gt.tt().gl(), jElapsedRealtime);
        c("dis_", jSONArray, this.x, gt.tt().gl(), jElapsedRealtime);
        if (gt.tt().ts() && this.ve != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", "show_0");
            jSONObject.put("v", this.ve);
            jSONArray.put(jSONObject);
        }
        if (gt.tt().ts() && this.n != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("t", "click_0");
            jSONObject2.put("v", this.n);
            jSONArray.put(jSONObject2);
        }
        if (!gt.tt().ts() || this.sp == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("t", "play_0");
        jSONObject3.put("v", this.sp);
        jSONArray.put(jSONObject3);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(uj ujVar) {
        return ujVar.ve - this.ve;
    }
}
