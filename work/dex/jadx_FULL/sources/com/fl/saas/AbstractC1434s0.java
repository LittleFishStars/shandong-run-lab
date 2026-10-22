package com.fl.saas;

import android.text.TextUtils;
import com.alibaba.baichuan.log.TLogConstant;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fl.saas.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1434s0 {
    public static String a(String str, C1415j c1415j) {
        int i;
        try {
            if (TextUtils.isEmpty(str) || c1415j == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TLogConstant.PERSIST_TASK_ID, c1415j.w2);
            if (!"mit".equals(str)) {
                if ("click".equals(str)) {
                    jSONObject.put("type", "click");
                    jSONObject2.put("down_x", c1415j.E1);
                    jSONObject2.put("down_y", c1415j.F1);
                    jSONObject2.put("up_x", c1415j.G1);
                    jSONObject2.put("up_y", c1415j.H1);
                    jSONObject2.put("abs_down_x", c1415j.I1);
                    jSONObject2.put("abs_down_y", c1415j.J1);
                    jSONObject2.put("abs_up_x", c1415j.K1);
                    jSONObject2.put("abs_up_y", c1415j.L1);
                    jSONObject2.put("clickArea", c1415j.o2);
                    jSONObject2.put("DOWN_TIME", c1415j.R1);
                    jSONObject2.put("UP_TIME", c1415j.S1);
                    jSONObject2.put("shake_x", c1415j.M1);
                    jSONObject2.put("shake_y", c1415j.N1);
                    jSONObject2.put("shake_z", c1415j.O1);
                    jSONObject2.put("clickTypeValue", c1415j.s0);
                    i = c1415j.n2;
                }
                return jSONObject.toString();
            }
            jSONObject.put("type", "mit");
            jSONObject2.put("place_id", c1415j.i);
            jSONObject2.put("reqTime", c1415j.l);
            jSONObject2.put("task_type", c1415j.m);
            jSONObject2.put("trackId", c1415j.r);
            jSONObject2.put("realWidth", c1415j.P1);
            jSONObject2.put("realHeight", c1415j.Q1);
            jSONObject2.put("width", c1415j.v1);
            jSONObject2.put("height", c1415j.w1);
            i = c1415j.n2;
            jSONObject2.put("maxShowRatio", i);
            jSONObject.put("msg", jSONObject2.toString());
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
