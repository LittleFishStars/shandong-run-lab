package com.czhj.volley.toolbox;

import android.text.TextUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class StringUtil {
    public static String clsName = null;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    public static String f29502cn = "q1vljpre1fq";
    public static String dc = "gf1vljpre1fq";
    public static String rtb = "uwefdooedfn1vljpre1fq";
    public static String s = "vljpre";
    public static String sad = "vljpreDg";
    public static String service = "dgvhuylfh1vljpre1fq";
    public static String tb_service = "wp1vljpre1fq";
    public static String tp = "wudfnws1vljpre1fq";
    public static String track = "wudfn1vljpre1fq";
    public static Map<String, String> urlMap;

    static {
        HashMap map = new HashMap();
        urlMap = map;
        clsName = "frp1f}km";
        map.put(decode(service), "adservice.sigmob.cn");
        urlMap.put(decode(dc), "dc.sigmob.cn");
        urlMap.put(decode(track), "track.sigmob.cn");
        urlMap.put(decode(tp), "tracktp.sigmob.cn");
        urlMap.put(decode(f29502cn), "n.sigmob.cn");
        urlMap.put(decode(rtb), "rtbcallback.sigmob.cn");
        urlMap.put(decode(tb_service), "tm.sigmob.cn");
    }

    public static String decode(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 3);
        }
        return new String(bytes);
    }

    public static String getUrl(String str) {
        if (StringUtil.class.getName().startsWith(decode(clsName))) {
            return str;
        }
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(str) && str.contains(key)) {
                try {
                    String host = new URL(str).getHost();
                    if (host != null && host.toLowerCase().equals(key)) {
                        return str.replace(key, value);
                    }
                } catch (Throwable unused) {
                    return str.replace(key, value);
                }
            }
        }
        return str;
    }

    public static String scheme() {
        return decode(sad);
    }
}
