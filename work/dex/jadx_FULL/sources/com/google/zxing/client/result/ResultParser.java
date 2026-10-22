package com.google.zxing.client.result;

import com.zj.adlib.cz2;
import com.zj.adlib.jb3;
import com.zj.adlib.lf9;
import com.zj.adlib.mw9;
import com.zj.adlib.n29;
import com.zj.adlib.of9;
import com.zj.adlib.qs7;
import com.zj.adlib.r10;
import com.zj.adlib.ss7;
import com.zj.adlib.ts7;
import com.zj.adlib.tt3;
import com.zj.adlib.u44;
import com.zj.adlib.ug7;
import com.zj.adlib.vk9;
import com.zj.adlib.wk9;
import com.zj.adlib.x07;
import com.zj.adlib.y39;
import com.zj.adlib.yk9;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class ResultParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f32503a = "\ufeff";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ResultParser[] f6727a = {new c(), new a(), new d(), new r10(), new vk9(), new b(), new wk9(), new cz2(), new ts7(), new n29(), new qs7(), new ss7(), new tt3(), new mw9(), new of9(), new lf9(), new u44(), new x07(), new jb3(), new yk9()};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f6726a = Pattern.compile("\\d+");
    public static final Pattern b = Pattern.compile("&");
    public static final Pattern c = Pattern.compile("=");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f6728a = new String[0];

    public static void a(CharSequence charSequence, Map<String, String> map) {
        String[] strArrSplit = c.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], h(strArrSplit[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static int b(CharSequence charSequence, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    public static String[] c(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int iIndexOf = str2.indexOf(str, i);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            boolean z2 = true;
            ArrayList arrayList2 = arrayList;
            int length3 = length2;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (b(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strUnescapeBackslash = unescapeBackslash(str2.substring(length2, iIndexOf2));
                    if (z) {
                        strUnescapeBackslash = strUnescapeBackslash.trim();
                    }
                    if (!strUnescapeBackslash.isEmpty()) {
                        arrayList2.add(strUnescapeBackslash);
                    }
                    length3 = iIndexOf2 + 1;
                }
                z2 = false;
            }
            i = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(f6728a);
    }

    public static String d(String str, String str2, char c2, boolean z) {
        String[] strArrC = c(str, str2, c2, z);
        if (strArrC == null) {
            return null;
        }
        return strArrC[0];
    }

    public static Map<String, String> f(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        HashMap map = new HashMap(3);
        for (String str2 : b.split(str.substring(iIndexOf + 1))) {
            a(str2, map);
        }
        return map;
    }

    public static ParsedResult g(ug7 ug7Var) {
        for (ResultParser resultParser : f6727a) {
            ParsedResult parsedResultE = resultParser.e(ug7Var);
            if (parsedResultE != null) {
                return parsedResultE;
            }
        }
        return new y39(ug7Var.g(), null);
    }

    public static String getMassagedText(ug7 ug7Var) {
        String strG = ug7Var.g();
        return strG.startsWith(f32503a) ? strG.substring(1) : strG;
    }

    public static String h(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static boolean isStringOfDigits(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && f6726a.matcher(charSequence).matches();
    }

    public static boolean isSubstringOfDigits(CharSequence charSequence, int i, int i2) {
        int i3;
        return charSequence != null && i2 > 0 && charSequence.length() >= (i3 = i2 + i) && f6726a.matcher(charSequence.subSequence(i, i3)).matches();
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    public static String[] maybeWrap(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    public static int parseHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static String unescapeBackslash(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    public abstract ParsedResult e(ug7 ug7Var);

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }
}
