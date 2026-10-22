package com.byazt.cx;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.byazt.nr.m;
import com.byazt.yv.TTEncryptUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2470, 20})
public class c {
    public static InterfaceC0380c c = null;
    public static boolean tt = false;

    /* JADX INFO: renamed from: com.byazt.cx.c$c, reason: collision with other inner class name */
    public interface InterfaceC0380c {
        boolean c();

        boolean tt();

        boolean ve();
    }

    public static String c(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || c == null || tt) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            c(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            c(linkedHashMap, linkedList, "device_id");
            c(linkedHashMap, linkedList, "device_type");
            c(linkedHashMap, linkedList, "device_brand");
            c(linkedHashMap, linkedList, "uuid");
            c(linkedHashMap, linkedList, "openudid");
            String strC = c((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strC)) {
                return str;
            }
            byte[] bytes = strC.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (c.c()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (c.tt() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", c(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return c(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), c((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable th) {
            m.c(th);
            return str;
        }
    }

    private static boolean c(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (c.ve()) {
            return true;
        }
        map.remove(str);
        return true;
    }

    public static void c(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split("&")) {
                        int iIndexOf = str.indexOf("=");
                        if (iIndexOf >= 0) {
                            String strDecode = URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8");
                            List<String> linkedList = map.get(strDecode);
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            linkedList.add(URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                            map.put(strDecode, linkedList);
                        } else {
                            String strDecode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> linkedList2 = map.get(strDecode2);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            linkedList2.add("");
                            map.put(strDecode2, linkedList2);
                        }
                    }
                }
            } catch (Throwable th) {
                m.c(th);
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static Uri c(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(com.google.common.net.c.b);
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String c(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            Object obj = pair.first;
            String strC = (String) obj;
            if (z) {
                strC = c((String) obj, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strC2 : list2) {
                    if (z) {
                        strC2 = strC2 != null ? c(strC2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strC);
                    sb.append("=");
                    sb.append(strC2);
                }
            }
        }
        return sb.toString();
    }

    private static String c(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
