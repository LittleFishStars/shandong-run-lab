package com.byazt.wo;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1953, 13})
public class tt {
    public byte[] c;
    public JSONObject n;
    public Map<String, String> tt;
    public int uj;
    public JSONObject ve;

    public JSONObject c() {
        return this.n;
    }

    public Map<String, String> n() {
        return this.tt;
    }

    public int tt() {
        return this.uj;
    }

    public JSONObject uj() {
        return this.ve;
    }

    public byte[] ve() {
        return this.c;
    }

    public void c(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public void tt(JSONObject jSONObject) {
        this.ve = jSONObject;
    }

    public void c(int i) {
        this.uj = i;
    }

    public void c(byte[] bArr) {
        this.c = bArr;
    }

    public void c(Map<String, String> map) {
        this.tt = map;
    }
}
