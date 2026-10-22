package com.byazt.aq;

import android.text.TextUtils;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 71})
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28297a;
    public String c;
    public List<x> da;
    public n i;
    public float n;
    public x sl;
    public float sp;
    public List<List<x>> t;
    public float tt;
    public String u;
    public float uj;
    public float ve;
    public float x;
    public boolean yp;
    public Map<String, String> z = new HashMap();
    public Map<Integer, String> m = new HashMap();

    public float a() {
        return this.tt;
    }

    public String c() {
        return this.u;
    }

    public n da() {
        return this.i;
    }

    public boolean gr() {
        return this.i.n().yf() < 0 || this.i.n().f() < 0 || this.i.n().dz() < 0 || this.i.n().ma() < 0;
    }

    public Map<String, String> gt() {
        return this.z;
    }

    public String gu() {
        return this.i.n().gu();
    }

    public float i() {
        return this.sp;
    }

    public float m() {
        a aVarN = this.i.n();
        return yp() + aVarN.nu() + aVarN.yp() + (aVarN.t() * 2.0f);
    }

    public boolean my() {
        return this.yp;
    }

    public float n() {
        return this.n;
    }

    public List<List<x>> nu() {
        return this.t;
    }

    public boolean qy() {
        return TextUtils.equals(this.i.n().md(), "flex");
    }

    public boolean rh() {
        List<x> list = this.da;
        return list == null || list.size() <= 0;
    }

    public void rl() {
        List<List<x>> list = this.t;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<x> list2 : this.t) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.t = arrayList;
    }

    public List<x> sl() {
        return this.da;
    }

    public float sp() {
        return this.ve;
    }

    public x t() {
        return this.sl;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.c + "', x=" + this.tt + ", y=" + this.ve + ", width=" + this.f28297a + ", height=" + this.sp + ", remainWidth=" + this.x + ", rootBrick=" + this.i + ", childrenBrickUnits=" + this.da + '}';
    }

    public Map<Integer, String> tt() {
        return this.m;
    }

    public int u() {
        a aVarN = this.i.n();
        return aVarN.l() + aVarN.lo();
    }

    public float uj() {
        return this.uj;
    }

    public String ve() {
        return this.c;
    }

    public float x() {
        return this.f28297a;
    }

    public int yp() {
        a aVarN = this.i.n();
        return aVarN.bm() + aVarN.lr();
    }

    public float z() {
        a aVarN = this.i.n();
        return u() + aVarN.z() + aVarN.m() + (aVarN.t() * 2.0f);
    }

    public void a(float f) {
        this.sp = f;
    }

    public void c(String str) {
        this.u = str;
    }

    public void n(float f) {
        this.f28297a = f;
    }

    public void sp(float f) {
        this.x = f;
    }

    public void tt(String str) {
        this.c = str;
    }

    public void uj(float f) {
        this.ve = f;
    }

    public void ve(float f) {
        this.tt = f;
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.m.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void tt(float f) {
        this.n = f;
    }

    public void ve(String str) {
        this.i.n().a(str);
    }

    public void tt(List<List<x>> list) {
        this.t = list;
    }

    public void c(float f) {
        this.uj = f;
    }

    public void c(n nVar) {
        this.i = nVar;
    }

    public void c(List<x> list) {
        this.da = list;
    }

    public void c(x xVar) {
        this.sl = xVar;
    }

    public void c(boolean z) {
        this.yp = z;
    }

    public void c(String str, String str2) {
        this.z.put(str, str2);
    }

    public String c(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.getType());
        sb.append(u15.f19942b);
        sb.append(this.c);
        if (this.i.n() != null) {
            sb.append(u15.f19942b);
            sb.append(this.i.n().cf());
        }
        sb.append(u15.f19942b);
        sb.append(i);
        if (this.i.n() != null) {
            sb.append(u15.f19942b);
            String strNb = this.i.n().nb();
            strNb.hashCode();
            switch (strNb) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String strNb2 = this.i.n().nb();
            strNb2.hashCode();
            if (strNb2.equals("17") || strNb2.equals("18")) {
                i2 = (i2 * 10) + 2;
            }
            String strNb3 = this.i.n().nb();
            strNb3.hashCode();
            switch (strNb3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
