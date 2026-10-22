package com.alibaba.alibcwebview;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static final String d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, List<String>> f23701a = new LinkedHashMap();
    String b;
    String c;

    public a(String str) {
        this.c = str;
        a();
    }

    public static String a(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(30);
        boolean z = false;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(Uri.encode(entry.getKey()));
                sb.append("=");
                sb.append(Uri.encode(value.get(i)));
            }
        }
        return sb.toString();
    }

    private void a() {
        int iIndexOf;
        try {
            int iIndexOf2 = this.c.indexOf("#");
            if (-1 == iIndexOf2) {
                this.b = null;
            } else if (iIndexOf2 != this.c.length() - 1) {
                this.b = this.c.substring(iIndexOf2 + 1);
            }
            int iIndexOf3 = this.c.indexOf("?");
            this.f23701a.clear();
            if (-1 == iIndexOf3 || iIndexOf3 == this.c.length() - 1) {
                return;
            }
            if (-1 == iIndexOf2 || iIndexOf3 < iIndexOf2) {
                for (String str : (iIndexOf2 == -1 ? this.c.substring(iIndexOf3 + 1) : this.c.substring(iIndexOf3 + 1, iIndexOf2)).split("[\\&]")) {
                    if (!TextUtils.isEmpty(str) && -1 != (iIndexOf = str.indexOf("=")) && iIndexOf != str.length() - 1) {
                        String strDecode = Uri.decode(str.substring(0, iIndexOf));
                        String strDecode2 = Uri.decode(str.substring(iIndexOf + 1));
                        List<String> list = this.f23701a.get(strDecode);
                        if (list == null) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(strDecode2);
                            this.f23701a.put(strDecode, arrayList);
                        } else {
                            list.add(strDecode2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            AlibcLogger.e(d, "parse url exception: " + e.getMessage());
        }
    }
}
