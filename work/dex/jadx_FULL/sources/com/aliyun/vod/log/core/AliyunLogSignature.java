package com.aliyun.vod.log.core;

import android.text.TextUtils;
import com.aliyun.vod.log.util.Base64Coder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AliyunLogSignature {

    public static class ParamsComparator implements Comparator<String> {
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static List<String> getAllParams(Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                arrayList.add(percentEncode(str) + "=" + percentEncode(str2));
            }
        }
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                String str4 = map2.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    arrayList.add(percentEncode(str3) + "=" + percentEncode(str4));
                }
            }
        }
        return arrayList;
    }

    public static String getCQS(List<String> list) {
        Collections.sort(list, new ParamsComparator());
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i);
            if (i != list.size() - 1) {
                str = str + "&";
            }
        }
        return str;
    }

    public static String hmacSHA1Signature(String str, String str2) {
        try {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec((str + "&").getBytes(), "HmacSHA1");
                Mac mac = Mac.getInstance("HmacSHA1");
                mac.init(secretKeySpec);
                return new String(newStringByBase64(mac.doFinal(str2.getBytes())));
            } catch (Exception e) {
                throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
            }
        } catch (SignatureException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String newStringByBase64(byte[] bArr) throws UnsupportedEncodingException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new String(Base64Coder.encode(bArr, 2));
    }

    public static String percentEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
