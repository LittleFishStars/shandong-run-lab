package com.alibaba.triver.appinfo.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24642a = "triver_app_info_sync";
    public static final String b = "importantList";
    public static final String c = "maxAsyncSeconds";
    public static final String d = "maxSyncSeconds";

    public static void a(Context context) {
        a();
        b();
        try {
            ((IConfigProxy) RVProxy.get(IConfigProxy.class)).registerListener(f24642a, new IConfigProxy.ConfigListener() { // from class: com.alibaba.triver.appinfo.core.c.1
                @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy.ConfigListener
                public void onConfigUpdate(Map<String, String> map) {
                    c.a();
                }
            });
            ((IConfigProxy) RVProxy.get(IConfigProxy.class)).registerListener("triver_common_config", new IConfigProxy.ConfigListener() { // from class: com.alibaba.triver.appinfo.core.c.2
                @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy.ConfigListener
                public void onConfigUpdate(Map<String, String> map) {
                    c.b();
                }
            });
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    public static void b() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        if (configsByGroup == null || configsByGroup.isEmpty()) {
            return;
        }
        try {
            String str = configsByGroup.get(c);
            String str2 = configsByGroup.get(d);
            b.a(TextUtils.isEmpty(str2) ? -1L : Long.parseLong(str2), !TextUtils.isEmpty(str) ? Long.parseLong(str) : -1L);
        } catch (Exception e) {
            RVLogger.e(com.alibaba.triver.appinfo.channel.a.f24632a, "updateLoadSeconds error", e);
        }
    }

    public static void a() {
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(f24642a);
        if (configsByGroup == null || configsByGroup.isEmpty()) {
            return;
        }
        String str = configsByGroup.get(b);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            List list = (List) JSON.parseObject(str, new TypeReference<List<AcceleratorConfig.ConfigItem>>() { // from class: com.alibaba.triver.appinfo.core.c.3
            }, new Feature[0]);
            if (list != null) {
                b.a((List<AcceleratorConfig.ConfigItem>) list);
            }
        } catch (Exception e) {
            RVLogger.e(com.alibaba.triver.appinfo.channel.a.f24632a, "updateConfig parse error", e);
        }
    }
}
