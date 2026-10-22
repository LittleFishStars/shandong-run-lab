package com.baidu.platform.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements ParamBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<String, String> f26803a;

    public a a(String str, String str2) {
        if (this.f26803a == null) {
            this.f26803a = new LinkedHashMap();
        }
        this.f26803a.put(str, str2);
        return this;
    }

    public String a() {
        Map<String, String> map = this.f26803a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.f26803a.keySet()) {
            String strEncodeUrlParamsValue = AppMD5.encodeUrlParamsValue(this.f26803a.get(str2));
            str = i == 0 ? str + str2 + "=" + strEncodeUrlParamsValue : str + "&" + str2 + "=" + strEncodeUrlParamsValue;
            i++;
        }
        return str;
    }
}
