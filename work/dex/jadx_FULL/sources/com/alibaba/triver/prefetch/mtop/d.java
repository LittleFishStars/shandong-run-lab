package com.alibaba.triver.prefetch.mtop;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.utils.URLUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25120a = "ShopFetchCache";
    private static final String b = "tr_shop_mtop_cache";
    private static final String c = "mtopCache";
    private static final String d = "mtopCache_count_to_url_map";
    private static final String e = "mtopCache_url_to_count_map";
    private static final String f = "mtopCache_last_time_map";
    private static d l;
    private SharedPreferences g = null;
    private JSONObject h = null;
    private JSONObject i = null;
    private JSONObject j = null;
    private JSONObject k = null;

    private d() {
        a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        this.g = context.getSharedPreferences(b, 0);
        this.h = c(c);
        this.i = c(d);
        this.j = c(e);
        this.k = c(f);
    }

    private long b(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getLongValue(str);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return 0L;
        }
    }

    private JSONObject c(String str) {
        try {
            String string = this.g.getString(str, null);
            return string == null ? new JSONObject() : JSON.parseObject(string);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f25120a, "getJSONData  error : " + e2.getMessage());
            return new JSONObject();
        }
    }

    private void d(String str) {
        this.k.put(g(str), (Object) Long.valueOf(System.currentTimeMillis()));
    }

    private void e(String str) {
        String strG = g(str);
        int iA = a(str, this.j);
        this.h.remove(str);
        this.j.remove(str);
        this.k.remove(strG);
        JSONArray jSONArray = this.i.getJSONArray(String.valueOf(iA));
        if (jSONArray != null) {
            jSONArray.remove(str);
            if (jSONArray.isEmpty()) {
                this.i.remove(String.valueOf(iA));
            }
        }
    }

    private boolean f(String str) {
        return System.currentTimeMillis() - b(g(str), this.k) <= ((long) ((TBShopOrangeController.getShopFetchCacheTimeByMinute() * 60) * 1000));
    }

    private String g(String str) {
        return str + "_lastTime";
    }

    private void b() {
        int i = Integer.MAX_VALUE;
        try {
            Iterator<String> it = this.i.keySet().iterator();
            while (it.hasNext()) {
                int i2 = Integer.parseInt(it.next());
                if (i2 < i) {
                    i = i2;
                }
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f25120a, "parse min key error : " + e2.getMessage());
            this.h.clear();
            this.i.clear();
            this.j.clear();
        }
        try {
            String strValueOf = String.valueOf(i);
            JSONArray jSONArray = this.i.getJSONArray(strValueOf);
            if (jSONArray == null || jSONArray.size() == 0) {
                return;
            }
            String string = jSONArray.getString(0);
            if (string != null) {
                jSONArray.remove(string);
                this.j.remove(string);
                this.h.remove(string);
            }
            if (jSONArray.size() == 0) {
                this.i.remove(strValueOf);
            }
        } catch (Exception e3) {
            RVLogger.w(Log.getStackTraceString(e3));
            RVLogger.e(f25120a, "delete element error : " + e3.getMessage());
        }
    }

    public static d a() {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d();
                }
            }
        }
        return l;
    }

    private void c() {
        try {
            this.g.edit().putString(c, this.h.toString()).apply();
            this.g.edit().putString(d, this.i.toString()).apply();
            this.g.edit().putString(e, this.j.toString()).apply();
            this.g.edit().putString(f, this.k.toString()).apply();
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f25120a, "updateSpData error : " + e2.getMessage());
        }
    }

    public synchronized String a(String str) {
        String string = null;
        if (!TBShopOrangeController.openMtopShopFetchCache()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strB = b(str);
        try {
            if (this.h.containsKey(strB)) {
                if (!f(strB)) {
                    e(strB);
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("ShopFetch", "cache is invalid");
                    return null;
                }
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("ShopFetch", "cache is valid");
                string = this.h.getString(strB);
                int iA = a(strB, this.j);
                if (iA != 0) {
                    JSONArray jSONArray = this.i.getJSONArray(String.valueOf(iA));
                    if (jSONArray != null) {
                        jSONArray.remove(strB);
                        if (jSONArray.size() == 0) {
                            this.i.remove(String.valueOf(iA));
                        }
                    }
                    int i = iA + 1;
                    JSONArray jSONArray2 = this.i.getJSONArray(String.valueOf(i));
                    if (jSONArray2 == null) {
                        jSONArray2 = new JSONArray();
                    }
                    jSONArray2.add(strB);
                    this.i.put(String.valueOf(i), (Object) jSONArray2);
                    this.j.put(strB, (Object) String.valueOf(i));
                    c();
                }
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f25120a, "getMtopData error : " + e2.getMessage());
        }
        return string;
    }

    public static String b(String str) {
        JSONArray shopUrlHashParam = TBShopOrangeController.getShopUrlHashParam();
        if (str == null) {
            return null;
        }
        if (shopUrlHashParam.size() == 0) {
            return String.valueOf(str.hashCode());
        }
        Map<String, String> urlParams = URLUtils.getUrlParams(str);
        StringBuilder sb = new StringBuilder();
        for (Object obj : shopUrlHashParam) {
            if (obj instanceof String) {
                sb.append(urlParams.get(obj));
            }
        }
        if (sb.length() == 0) {
            return String.valueOf(str.hashCode());
        }
        return String.valueOf(sb.toString().hashCode());
    }

    private int a(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getIntValue(str);
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return 0;
        }
    }

    public synchronized void a(String str, String str2) {
        if (!TBShopOrangeController.openMtopShopFetchCache()) {
            return;
        }
        String strB = b(str);
        try {
            if (!TextUtils.isEmpty(strB) && !TextUtils.isEmpty(str2)) {
                if (!this.h.containsKey(strB)) {
                    if (this.h.size() >= 100) {
                        b();
                    }
                    this.h.put(strB, (Object) str2);
                    this.j.put(strB, (Object) "1");
                    JSONArray jSONArray = this.i.getJSONArray("1");
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    jSONArray.add(strB);
                    this.i.put("1", (Object) jSONArray);
                } else {
                    this.h.put(strB, (Object) str2);
                }
                d(strB);
                c();
            }
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            RVLogger.e(f25120a, "saveMtop error : " + e2.getMessage());
        }
    }
}
