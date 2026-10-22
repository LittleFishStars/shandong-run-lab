package com.zj.adlib;

import com.alipay.sdk.m.y.l;
import com.google.zxing.client.result.ResultParser;
import com.king.zxing.e;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class vk9 extends ResultParser {
    public static final Pattern d = Pattern.compile("BEGIN:VCARD", 2);
    public static final Pattern e = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    public static final Pattern f = Pattern.compile("\r\n[ \t]");
    public static final Pattern g = Pattern.compile("\\\\[nN]");
    public static final Pattern h = Pattern.compile("\\\\([,;\\\\])");
    public static final Pattern i = Pattern.compile("=");
    public static final Pattern j = Pattern.compile(l.b);
    public static final Pattern k = Pattern.compile("(?<!\\\\);+");
    public static final Pattern l = Pattern.compile(",");
    public static final Pattern m = Pattern.compile("[;,]");

    public static String i(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    o(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i2 < length - 2 && (cCharAt = charSequence.charAt(i2 + 1)) != '\r' && cCharAt != '\n') {
                    i2 += 2;
                    char cCharAt3 = charSequence.charAt(i2);
                    int hexDigit = ResultParser.parseHexDigit(cCharAt);
                    int hexDigit2 = ResultParser.parseHexDigit(cCharAt3);
                    if (hexDigit >= 0 && hexDigit2 >= 0) {
                        byteArrayOutputStream.write((hexDigit << 4) + hexDigit2);
                    }
                }
            }
            i2++;
        }
        o(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    public static void j(Iterable<List<String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (iIndexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, iIndexOf);
                    i2++;
                    i3 = iIndexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                n(strArr, 3, sb);
                n(strArr, 1, sb);
                n(strArr, 2, sb);
                n(strArr, 0, sb);
                n(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    public static boolean k(CharSequence charSequence) {
        return charSequence == null || e.matcher(charSequence).matches();
    }

    public static List<String> l(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> listM = m(charSequence, str, z, z2);
        if (listM == null || listM.isEmpty()) {
            return null;
        }
        return listM.get(0);
    }

    public static List<List<String>> m(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        int i2;
        String str2;
        String str3;
        int iIndexOf;
        int i3;
        int i4;
        String strReplaceAll;
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < length) {
            int i7 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i6 > 0) {
                i6--;
            }
            if (!matcher.find(i6)) {
                break;
            }
            int iEnd = matcher.end(i5);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = j.split(strGroup);
                int length2 = strArrSplit.length;
                int i8 = i5;
                i2 = i8;
                arrayList = null;
                str2 = null;
                str3 = null;
                while (i8 < length2) {
                    String str4 = strArrSplit[i8];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] strArrSplit2 = i.split(str4, i7);
                    if (strArrSplit2.length > 1) {
                        String str5 = strArrSplit2[0];
                        String str6 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            i2 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i8++;
                    i7 = 2;
                }
            } else {
                arrayList = null;
                i2 = 0;
                str2 = null;
                str3 = null;
            }
            int i9 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i9);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i10 = iIndexOf + 1;
                    if (str.charAt(i10) == ' ' || str.charAt(i10) == '\t') {
                        i9 = iIndexOf + 2;
                    }
                }
                if (i2 == 0 || ((iIndexOf < 1 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i9 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i4 = length;
                i3 = 0;
            } else {
                if (iIndexOf <= iEnd) {
                    i3 = 0;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                        iIndexOf--;
                    }
                    String strSubstring = str.substring(iEnd, iIndexOf);
                    if (z) {
                        strSubstring = strSubstring.trim();
                    }
                    if (i2 != 0) {
                        strReplaceAll = i(strSubstring, str2);
                        if (z2) {
                            strReplaceAll = k.matcher(strReplaceAll).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            strSubstring = k.matcher(strSubstring).replaceAll("\n").trim();
                        }
                        strReplaceAll = h.matcher(g.matcher(f.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if ("uri".equals(str3)) {
                        try {
                            strReplaceAll = URI.create(strReplaceAll).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(strReplaceAll);
                        arrayList2.add(arrayList3);
                        i3 = 0;
                    } else {
                        i3 = 0;
                        arrayList.add(0, strReplaceAll);
                        arrayList2.add(arrayList);
                    }
                }
                i4 = iIndexOf + 1;
            }
            i5 = i3;
            i6 = i4;
        }
        return arrayList2;
    }

    public static void n(String[] strArr, int i2, StringBuilder sb) {
        String str = strArr[i2];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }

    public static void o(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    public static String q(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String[] r(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(ResultParser.f6728a);
    }

    public static String[] s(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    strSubstring = list.get(i2);
                    int iIndexOf = strSubstring.indexOf(61);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if (e.f.c.equalsIgnoreCase(strSubstring.substring(0, iIndexOf))) {
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                        break;
                    }
                    i2++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(ResultParser.f6728a);
    }

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public s10 e(ug7 ug7Var) {
        String massagedText = ResultParser.getMassagedText(ug7Var);
        Matcher matcher = d.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> listM = m("FN", massagedText, true, false);
        if (listM == null) {
            listM = m("N", massagedText, true, false);
            j(listM);
        }
        List<String> listL = l("NICKNAME", massagedText, true, false);
        String[] strArrSplit = listL == null ? null : l.split(listL.get(0));
        List<List<String>> listM2 = m("TEL", massagedText, true, false);
        List<List<String>> listM3 = m("EMAIL", massagedText, true, false);
        List<String> listL2 = l(fv9.b, massagedText, false, false);
        List<List<String>> listM4 = m("ADR", massagedText, true, true);
        List<String> listL3 = l("ORG", massagedText, true, true);
        List<String> listL4 = l("BDAY", massagedText, true, false);
        List<String> list = (listL4 == null || k(listL4.get(0))) ? listL4 : null;
        List<String> listL5 = l("TITLE", massagedText, true, false);
        List<List<String>> listM5 = m("URL", massagedText, true, false);
        List<String> listL6 = l("IMPP", massagedText, true, false);
        List<String> listL7 = l("GEO", massagedText, true, false);
        String[] strArrSplit2 = listL7 == null ? null : m.split(listL7.get(0));
        return new s10(r(listM), strArrSplit, null, r(listM2), s(listM2), r(listM3), s(listM3), q(listL6), q(listL2), r(listM4), s(listM4), q(listL3), q(list), q(listL5), r(listM5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }
}
