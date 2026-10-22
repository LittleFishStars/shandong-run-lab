package com.byazt.ete;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.dj.tt f28513a;
    public String c;
    public long da;
    public long i;
    public ArrayList<Integer> n;
    public long sl;
    public int sp;
    public JSONObject t;
    public int tt;
    public String uj;
    public int ve = 1;
    public long x;

    public int a() {
        return this.ve;
    }

    public String c() {
        return this.c;
    }

    public long da() {
        return this.i;
    }

    public long i() {
        return this.x;
    }

    public JSONObject n() {
        return this.t;
    }

    public long sl() {
        return this.da;
    }

    public com.byazt.dj.tt sp() {
        return this.f28513a;
    }

    public long t() {
        return this.sl;
    }

    public int tt() {
        return this.tt;
    }

    public String uj() {
        return this.uj;
    }

    public int ve() {
        return this.sp;
    }

    public ArrayList<Integer> x() {
        return this.n;
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public void uj(long j) {
        this.sl = j;
    }

    public void ve(int i) {
        this.ve = i;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void tt(String str) {
        this.uj = str;
    }

    public void ve(long j) {
        this.da = j;
    }

    public void c(JSONObject jSONObject) {
        this.t = jSONObject;
    }

    public void tt(long j) {
        this.i = j;
    }

    public void c(com.byazt.dj.tt ttVar) {
        this.f28513a = ttVar;
    }

    public void c(ArrayList<Integer> arrayList) {
        this.n = arrayList;
    }

    public static void c(tt ttVar) {
        int iTt;
        if (ttVar == null || ttVar.sp() == null || (iTt = ttVar.tt()) >= 0 || iTt == -8) {
            return;
        }
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.tt.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObjectN = tt.this.n();
                if (jSONObjectN == null) {
                    jSONObjectN = new JSONObject();
                }
                jSONObjectN.put("from", tt.this.a());
                jSONObjectN.put("err_code", tt.this.tt());
                jSONObjectN.put("err_msg", tt.this.uj());
                jSONObjectN.put("server_res_str", tt.this.c());
                if (tt.this.x() != null && tt.this.x().size() > 0) {
                    jSONObjectN.put("mate_unavailable_code_list", new JSONArray((Collection) tt.this.x()).toString());
                }
                com.byazt.nr.m.c("AdLogInfoModel", "rd_client_custom_error = ", jSONObjectN);
                return com.byazt.qal.tt.tt().c("rd_client_custom_error").c(tt.this.sp().gt()).tt(jSONObjectN.toString());
            }
        }, "rd_client_custom_error");
    }

    public void c(long j) {
        this.x = j;
    }
}
