package com.kwai.adclient.kscommerciallogger.snapshot;

import com.ali.auth.third.login.LoginConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class c {
    private final String bvd;
    private final LinkedList<d> bve;
    private int bvf;
    private final int bvg;
    private long bvh;

    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Ys() {
        return this.bvh;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.bvd.equals(((c) obj).bvd);
    }

    public final String getName() {
        return this.bvd;
    }

    public int hashCode() {
        return Objects.hash(this.bvd);
    }

    public synchronized d iM(String str) {
        d dVar;
        if (this.bve.size() >= this.bvg) {
            this.bve.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(LoginConstants.UNDER_LINE);
        int i = this.bvf;
        this.bvf = i + 1;
        sb.append(i);
        dVar = new d(sb.toString());
        this.bve.addLast(dVar);
        this.bvh = System.currentTimeMillis();
        return dVar;
    }

    public synchronized JSONObject iN(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.bve.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().Yr());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.bvd);
            jSONObject.put("spans", jSONArray);
            this.bvh = System.currentTimeMillis();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public c(String str, int i) {
        this.bvd = str == null ? "" : str;
        this.bve = new LinkedList<>();
        this.bvg = Math.min(i, 30);
        this.bvh = System.currentTimeMillis();
    }
}
