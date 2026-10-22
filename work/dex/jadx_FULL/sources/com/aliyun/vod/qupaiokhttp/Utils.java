package com.aliyun.vod.qupaiokhttp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class Utils {
    public static String getFullUrl(String str, List<Part> list, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        int i = 0;
        if (stringBuffer.indexOf("?", 0) < 0 && list.size() > 0) {
            stringBuffer.append("?");
        }
        for (Part part : list) {
            String key = part.getKey();
            String value = part.getValue();
            if (z) {
                try {
                    key = URLEncoder.encode(key, "UTF-8");
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            stringBuffer.append(key);
            stringBuffer.append("=");
            stringBuffer.append(value);
            i++;
            if (i != list.size()) {
                stringBuffer.append("&");
            }
        }
        return stringBuffer.toString();
    }
}
