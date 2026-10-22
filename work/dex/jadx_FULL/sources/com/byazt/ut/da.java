package com.byazt.ut;

import com.byazt.nr.m;
import com.byazt.ukr.yp;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 834, 72})
public class da implements i {
    public static final da c = new da();
    public Map<String, Object> tt = new ConcurrentHashMap(1);

    @Override // com.byazt.ut.i
    public void c(String str, Throwable th) {
        m.c("AutoService_boost", "onServiceCreateFailed:".concat(String.valueOf(str)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CachedContentIndex.a.e, str);
            jSONObject.put("msg", "sv cr failed");
        } catch (JSONException unused) {
        }
        yp.c().c("ats_b", jSONObject, th);
    }

    @Override // com.byazt.ut.i
    public void tt(String str, Object obj, Object obj2, int i, int i2) {
        m.c("AutoService_boost", "onShareServiceUpdate:" + str + " oldVersion=" + i + " newVersion=" + i2);
    }

    @Override // com.byazt.ut.i
    public void c(sl slVar, int i, String str, Throwable th) {
        m.c("AutoService_boost", "onServiceProxyCreateFailed:" + slVar.f29108a + " " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CachedContentIndex.a.e, slVar.f29108a);
            jSONObject.put("msg", str);
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        yp.c().c("ats_b_proxy", jSONObject, th);
    }

    @Override // com.byazt.ut.i
    public void c(sl slVar, Object obj, Object obj2, boolean z, JSONObject jSONObject, Throwable th) {
        Map<String, Object> map;
        if (slVar == null || obj2 == null || (map = this.tt) == null) {
            return;
        }
        map.put(slVar.f29108a, obj2);
    }

    @Override // com.byazt.ut.i
    public void c(String str, Object obj, int i, int i2) {
        m.c("AutoService_boost", "onServiceRegMsgUpdate:" + str + " " + i + " " + i2);
    }

    @Override // com.byazt.ut.i
    public void c(int i, String str, Throwable th) {
        m.tt("AutoService_boost", "onServiceException:" + str + " , code=" + i, th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", str);
            jSONObject.put("code", i);
        } catch (JSONException unused) {
        }
        yp.c().c("ats_b_e", jSONObject, th);
    }

    @Override // com.byazt.ut.i
    public void c(String str, Object obj, int i) {
        m.c("AutoService_boost", "onServiceCreate:" + str + " " + i);
    }

    @Override // com.byazt.ut.i
    public void c(String str, Object obj, Object obj2, int i, int i2) {
        m.c("AutoService_boost", "onServiceUpdate:" + str + " oldVersion=" + i + " newVersion=" + i2);
    }

    public Map<String, Object> c() {
        return this.tt;
    }
}
