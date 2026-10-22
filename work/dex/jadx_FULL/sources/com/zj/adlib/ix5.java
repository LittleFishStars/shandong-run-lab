package com.zj.adlib;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.huachenjie.c.HcjNative;
import huachenjie.sdk.http.interceptor.SignInterceptor;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ix5 extends SignInterceptor {
    public ix5(@NonNull hq1 params) {
        super(params);
    }

    public String getSign(Map<String, Object> map) {
        String jSONString;
        try {
            jSONString = JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            jSONString = "";
        }
        return HcjNative.signRequest(jSONString, l43.b());
    }
}
