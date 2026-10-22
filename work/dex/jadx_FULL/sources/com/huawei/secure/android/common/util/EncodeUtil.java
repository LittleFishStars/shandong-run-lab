package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.aliyun.vod.common.utils.IOUtils;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class EncodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37753a = "EncodeUtil";
    private static final char[] b = {',', '.', '-', '_'};
    private static final String[] c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z'))) {
                c[c2] = b(c2).intern();
            } else {
                c[c2] = null;
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(cArr, Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    private static String b(char c2) {
        return Integer.toHexString(c2);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character chA = a(aVar);
                if (chA != null) {
                    sb.append(chA);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e(f37753a, "decode js: " + e.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e) {
            Log.e(f37753a, "encode js: " + e.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (a(ch.charValue()) == null) {
            return "" + ch;
        }
        String hexString = Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    private static boolean a(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c2) {
        if (c2 < 255) {
            return c[c2];
        }
        return b(c2);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character chD = aVar.d();
        if (chD == null) {
            aVar.i();
            return null;
        }
        if (chD.charValue() != '\\') {
            aVar.i();
            return null;
        }
        Character chD2 = aVar.d();
        if (chD2 == null) {
            aVar.i();
            return null;
        }
        if (chD2.charValue() == 'b') {
            return '\b';
        }
        if (chD2.charValue() == 't') {
            return '\t';
        }
        if (chD2.charValue() == 'n') {
            return '\n';
        }
        if (chD2.charValue() == 'v') {
            return (char) 11;
        }
        if (chD2.charValue() == 'f') {
            return '\f';
        }
        if (chD2.charValue() == 'r') {
            return '\r';
        }
        if (chD2.charValue() == '\"') {
            return '\"';
        }
        if (chD2.charValue() == '\'') {
            return '\'';
        }
        if (chD2.charValue() == '\\') {
            return Character.valueOf(IOUtils.DIR_SEPARATOR_WINDOWS);
        }
        int i = 0;
        if (Character.toLowerCase(chD2.charValue()) == 'x') {
            StringBuilder sb = new StringBuilder();
            while (i < 2) {
                Character chE = aVar.e();
                if (chE != null) {
                    sb.append(chE);
                    i++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int i2 = Integer.parseInt(sb.toString(), 16);
                if (Character.isValidCodePoint(i2)) {
                    return Character.valueOf((char) i2);
                }
            } catch (NumberFormatException unused) {
                aVar.i();
                return null;
            }
        } else if (Character.toLowerCase(chD2.charValue()) == 'u') {
            StringBuilder sb2 = new StringBuilder();
            while (i < 4) {
                Character chE2 = aVar.e();
                if (chE2 != null) {
                    sb2.append(chE2);
                    i++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int i3 = Integer.parseInt(sb2.toString(), 16);
                if (Character.isValidCodePoint(i3)) {
                    return Character.valueOf((char) i3);
                }
            } catch (NumberFormatException unused2) {
                aVar.i();
                return null;
            }
        } else if (a.c(chD2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(chD2);
            Character chD3 = aVar.d();
            if (!a.c(chD3)) {
                aVar.a(chD3);
            } else {
                sb3.append(chD3);
                Character chD4 = aVar.d();
                if (!a.c(chD4)) {
                    aVar.a(chD4);
                } else {
                    sb3.append(chD4);
                }
            }
            try {
                int i4 = Integer.parseInt(sb3.toString(), 8);
                if (Character.isValidCodePoint(i4)) {
                    return Character.valueOf((char) i4);
                }
            } catch (NumberFormatException unused3) {
                aVar.i();
                return null;
            }
        }
        return chD2;
    }
}
