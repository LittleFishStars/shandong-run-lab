package com.aliyun.tea.okhttp;

import com.aliyun.tea.utils.StringUtils;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClientHelper {
    public static final ConcurrentHashMap<String, OkHttpClient> clients = new ConcurrentHashMap<>();

    public static OkHttpClient creatClient(Map<String, Object> map) {
        return new OkHttpClientBuilder().connectTimeout(map).readTimeout(map).connectionPool(map).certificate(map).proxy(map).proxyAuthenticator(map).buildOkHttpClient();
    }

    public static String getClientKey(String str, int i) {
        return String.format("%s:%d", str, Integer.valueOf(i));
    }

    public static OkHttpClient getOkHttpClient(String str, int i, Map<String, Object> map) throws Exception {
        String clientKey;
        if (map.get("httpProxy") != null || map.get("httpsProxy") != null) {
            URL url = new URL(String.valueOf(map.get("httpProxy") == null ? map.get("httpsProxy") : map.get("httpProxy")));
            clientKey = StringUtils.isEmpty((CharSequence) url.getUserInfo()) ? getClientKey(url.getHost(), url.getPort()) : getClientKey(url.getHost(), url.getPort(), url.getUserInfo());
        } else if (map.get("socks5Proxy") != null) {
            URI uri = new URI(String.valueOf(map.get("socks5Proxy")));
            clientKey = StringUtils.isEmpty((CharSequence) uri.getUserInfo()) ? getClientKey(uri.getHost(), uri.getPort()) : getClientKey(uri.getHost(), uri.getPort(), uri.getUserInfo());
        } else {
            clientKey = getClientKey(str, i);
        }
        ConcurrentHashMap<String, OkHttpClient> concurrentHashMap = clients;
        OkHttpClient okHttpClient = concurrentHashMap.get(clientKey);
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient okHttpClientCreatClient = creatClient(map);
        concurrentHashMap.put(clientKey, okHttpClientCreatClient);
        return okHttpClientCreatClient;
    }

    public static String getClientKey(String str, int i, String str2) {
        return String.format("%s@%s:%d", str2, str, Integer.valueOf(i));
    }
}
