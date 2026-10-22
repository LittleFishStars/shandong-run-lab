package com.alibaba.alibcwebview.jsbridge;

import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23728a = new c("0");
    public static final c b = new c("6");
    public static final c c = new c("2");
    public static final c d = new c("1");
    public static final c e = new c("4");
    public static final c f = new c("7");
    private static final String j = "c";
    JSONObject g = new JSONObject();
    String h = "6";
    String i;

    public c() {
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", (Object) this.h);
            jSONObject.put("msg", (Object) this.i);
            jSONObject.put("data", (Object) this.g);
        } catch (Exception e2) {
            AlibcLogger.e(j, "object to json string exception: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    private c(String str) {
        this.i = str;
    }
}
