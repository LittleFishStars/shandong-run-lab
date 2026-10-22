package com.byazt.gqp;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 34})
public final class a {
    public final String[] c;

    @com.byazt.zqa.c(c = {0, 1, 323, 464})
    public static final class c {
        public final List<String> c = new ArrayList(20);

        private void ve(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.byazt.na.da.c("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.na.da.c("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public a c() {
            return new a(this);
        }

        public c tt(String str, String str2) {
            try {
                ve(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                                sb.append(cCharAt);
                            } else {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.byazt.nr.m.c(e);
                        return this;
                    }
                }
                return this;
            }
            return c(str, str2);
        }

        public c c(String str, String str2) {
            this.c.add(str);
            this.c.add(str2.trim());
            return this;
        }
    }

    public a(String[] strArr) {
        this.c = strArr;
    }

    public int c() {
        return this.c.length / 2;
    }

    public String tt(int i) {
        return this.c[(i * 2) + 1];
    }

    public String c(int i) {
        return this.c[i * 2];
    }

    public Map<String, List<String>> tt() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iC = c();
        for (int i = 0; i < iC; i++) {
            String lowerCase = c(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(tt(i));
        }
        return treeMap;
    }

    public a(c cVar) {
        List<String> list = cVar.c;
        this.c = (String[]) list.toArray(new String[list.size()]);
    }
}
