package com.fl.saas.common.rest;

import com.alipay.sdk.m.n.c;
import com.fl.saas.config.http.HttpUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.json.Yson;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdHttpUtils extends HttpUtils {
    private static volatile AdHttpUtils instance;

    public static AdHttpUtils getInstance() {
        if (instance == null) {
            synchronized (AdHttpUtils.class) {
                if (instance == null) {
                    instance = new AdHttpUtils();
                }
            }
        }
        return instance;
    }

    public static String reqObjToStr(Object obj) {
        String strEncrypt = AesUtils.encrypt(new Yson().toJson(obj));
        LogcatUtil.d("YdSDK_REQ", strEncrypt);
        return strEncrypt;
    }

    @Override // com.fl.saas.config.http.HttpUtils
    public Map<String, String> getHeaders() {
        HashMap map = new HashMap();
        map.put("sdkVersion", "2.9.0");
        map.put(c.m, "4.4");
        map.put("sdkVersionCode", "29004");
        return map;
    }
}
