package com.byazt.eg;

import android.text.TextUtils;
import com.zj.adlib.u15;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 115})
public final class rh {
    public final String[] c;

    public rh(c cVar) {
        List<String> list = cVar.c;
        this.c = (String[]) list.toArray(new String[list.size()]);
    }

    public String c(String str) {
        return c(this.c, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof rh) && Arrays.equals(((rh) obj).c, this.c);
    }

    public int hashCode() {
        return Arrays.hashCode(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iC = c();
        for (int i = 0; i < iC; i++) {
            sb.append(c(i));
            sb.append(": ");
            sb.append(tt(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String tt(int i) {
        return this.c[(i * 2) + 1];
    }

    public Map<String, List<String>> ve() {
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

    @com.byazt.zqa.c(c = {0, 1, 16, 739})
    public static final class c {
        public final List<String> c = new ArrayList(20);

        private void uj(String str, String str2) {
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
                    throw new IllegalArgumentException(com.byazt.kh.ve.c("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.byazt.kh.ve.c("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public c c(String str) {
            int iIndexOf = str.indexOf(u15.f19942b, 1);
            if (iIndexOf != -1) {
                return tt(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            return str.startsWith(u15.f19942b) ? tt("", str.substring(1)) : tt("", str);
        }

        public c tt(String str, String str2) {
            this.c.add(str);
            this.c.add(str2.trim());
            return this;
        }

        public c ve(String str, String str2) {
            try {
                uj(str, str2);
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
            tt(str);
            tt(str, str2);
            return this;
        }

        public c tt(String str) {
            int i = 0;
            while (i < this.c.size()) {
                if (str.equalsIgnoreCase(this.c.get(i))) {
                    this.c.remove(i);
                    this.c.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public c c(String str, String str2) {
            try {
                uj(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
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
            return tt(str, str2);
        }

        public rh c() {
            return new rh(this);
        }
    }

    public int c() {
        return this.c.length / 2;
    }

    public List<String> tt(String str) {
        int iC = c();
        ArrayList arrayList = null;
        for (int i = 0; i < iC; i++) {
            if (str.equalsIgnoreCase(c(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(tt(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private rh(String[] strArr) {
        this.c = strArr;
    }

    public String c(int i) {
        return this.c[i * 2];
    }

    private static String c(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static rh c(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    String str = strArr2[i];
                    if (str != null) {
                        strArr2[i] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str2 = strArr2[i2];
                    String str3 = strArr2[i2 + 1];
                    if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                        throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
                    }
                }
                return new rh(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    public c tt() {
        c cVar = new c();
        Collections.addAll(cVar.c, this.c);
        return cVar;
    }
}
