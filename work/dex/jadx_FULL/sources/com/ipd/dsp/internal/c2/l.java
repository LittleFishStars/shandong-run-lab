package com.ipd.dsp.internal.c2;

import android.text.TextUtils;
import com.aliyun.openapiutil.Client;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l {
    public static String a(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        try {
            ArrayList arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator() { // from class: com.zj.adlib.xhb
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
                }
            });
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Map.Entry entry = (Map.Entry) obj;
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(str)) {
                    if (value == null || TextUtils.isEmpty(String.valueOf(value))) {
                        value = "";
                    } else if (value instanceof String) {
                        value = URLEncoder.encode((String) value, "utf-8").replaceAll("\\+", "%20");
                    }
                    sb.append(str);
                    sb.append("=");
                    sb.append(value);
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.lastIndexOf("&"));
            }
        } catch (Throwable th) {
            r.a(th);
        }
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return a(messageDigest.digest());
        } catch (Throwable th) {
            r.a(th);
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
