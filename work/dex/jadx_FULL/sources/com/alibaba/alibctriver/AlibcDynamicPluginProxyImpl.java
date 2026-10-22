package com.alibaba.alibctriver;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.preload.IDynamicPluginParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcDynamicPluginProxyImpl implements IDynamicPluginParam {
    @Override // com.alibaba.triver.preload.IDynamicPluginParam
    public JSONObject addParam() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", (Object) "baichuan");
        jSONObject.put("loadType", (Object) "preload");
        return jSONObject;
    }
}
