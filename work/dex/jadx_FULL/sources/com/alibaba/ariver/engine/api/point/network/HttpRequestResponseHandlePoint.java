package com.alibaba.ariver.engine.api.point.network;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface HttpRequestResponseHandlePoint extends Extension {
    void onHandleResponse(String str, String str2, JSONObject jSONObject);
}
