package com.byazt.ete;

import android.os.Bundle;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 129})
public class bm {
    public long da;
    public Bundle m;
    public String my;
    public int n;
    public int nu;
    public com.byazt.vvt.ve.c qy;
    public String rh;
    public long sl;
    public long t;
    public int uj;
    public String ve;
    public String rl = com.byazt.aas.nb.sp();
    public int c = -1;
    public int tt = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f28481a = null;
    public int sp = 1;
    public long x = System.currentTimeMillis();
    public long i = System.currentTimeMillis();
    public JSONObject u = null;
    public int yp = -1;
    public com.byazt.omf.qy z = com.byazt.omf.qy.c("");
    public boolean gt = false;

    public bm c() {
        bm bmVar = new bm();
        bmVar.c = this.c;
        bmVar.tt = this.tt;
        bmVar.f28481a = this.f28481a;
        bmVar.sp = this.sp;
        bmVar.x = this.x;
        bmVar.da = this.da;
        bmVar.sl = this.sl;
        bmVar.t = this.t;
        bmVar.yp = this.yp;
        bmVar.my = this.my;
        return bmVar;
    }

    public String tt() {
        return this.rl;
    }

    public void c(String str) {
        this.rl = str;
    }

    public void c(String str, boolean z) {
        com.byazt.omf.qy qyVar;
        if (!z || (qyVar = this.z) == null || str == null) {
            return;
        }
        qyVar.tt("cst_".concat(str));
    }

    public void c(String str, long j, boolean z) {
        com.byazt.omf.qy qyVar;
        if (!z || (qyVar = this.z) == null || str == null) {
            return;
        }
        qyVar.c("cst_".concat(str), j);
    }

    public void c(int i, String str, int i2, com.byazt.dj.tt ttVar) {
        this.qy = new com.byazt.vvt.ve.c(i, str, i2, System.currentTimeMillis(), ttVar);
    }

    public void c(Object obj, int i) {
        int size = obj != null ? 1 : 0;
        try {
            if (obj instanceof List) {
                size = ((List) obj).size();
            }
        } catch (Exception unused) {
        }
        com.byazt.vvt.ve.c cVar = this.qy;
        if (cVar != null) {
            cVar.c(size);
            com.byazt.vvt.ve.c(this.qy, i);
            this.qy = null;
        }
    }
}
