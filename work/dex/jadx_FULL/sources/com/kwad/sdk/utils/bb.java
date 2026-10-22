package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bb {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
                sb.append("&");
            }
        }
        String string = sb.toString();
        String strSubstring = string.substring(0, string.length() - 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str.contains("?") ? "&" : "?");
        return sb2.toString() + strSubstring;
    }
}
