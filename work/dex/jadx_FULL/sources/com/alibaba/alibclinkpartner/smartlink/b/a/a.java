package com.alibaba.alibclinkpartner.smartlink.b.a;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibclinkpartner.smartlink.config.ALSLContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {
    public abstract String a();

    public Map<String, String> b() {
        HashMap map = new HashMap();
        map.put(ALPParamConstant.TTID, TextUtils.isEmpty(ALSLContext.instance().TTID) ? "unknown" : ALSLContext.instance().TTID);
        map.put("appkey", TextUtils.isEmpty(ALSLContext.instance().appkey) ? "unknown" : ALSLContext.instance().appkey);
        map.put("appName", TextUtils.isEmpty(ALSLContext.instance().appName) ? "unknown" : ALSLContext.instance().appName);
        map.put("appVersion", TextUtils.isEmpty(ALSLContext.instance().appVersion) ? "unknown" : ALSLContext.instance().appVersion);
        map.put(ALPParamConstant.PACKAGENAME, TextUtils.isEmpty(ALSLContext.instance().packageName) ? "unknown" : ALSLContext.instance().packageName);
        map.put("sdkVersion", ALSLContext.instance().ALSLSDKVersion);
        map.put("source", "alsl");
        return map;
    }
}
