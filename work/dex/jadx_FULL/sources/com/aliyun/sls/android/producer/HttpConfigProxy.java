package com.aliyun.sls.android.producer;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alipay.sdk.m.y.l;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class HttpConfigProxy {
    private static final Map<String, String> PLUGIN_USER_AGENTS = new LinkedHashMap();

    static {
        addPluginUserAgent("sls-android-sdk", BuildConfig.VERSION_NAME);
    }

    private HttpConfigProxy() {
    }

    public static void addPluginUserAgent(String plugin, String version) {
        PLUGIN_USER_AGENTS.put(plugin, version);
    }

    public static String getUserAgent() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : PLUGIN_USER_AGENTS.entrySet()) {
            sb.append(entry.getKey());
            sb.append(WVNativeCallbackUtil.SEPERATER);
            sb.append(entry.getValue());
            sb.append(l.b);
        }
        return sb.substring(0, sb.length() - 1);
    }
}
