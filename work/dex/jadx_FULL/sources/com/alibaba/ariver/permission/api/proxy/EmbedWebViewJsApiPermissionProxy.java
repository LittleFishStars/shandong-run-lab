package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface EmbedWebViewJsApiPermissionProxy extends Proxiable {
    boolean shouldInterceptJSApiCall(String str, Page page, String str2, String str3, JSONObject jSONObject);
}
