package com.ali.auth.third.core.cookies;

import android.text.TextUtils;
import com.ali.auth.third.core.trace.SDKLogger;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.y.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LoginCookieUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23413a = 6;
    private static final int b = 8;

    public static void expiresCookies(c cVar) {
        Long l = 1000L;
        cVar.e = l.longValue();
    }

    public static String getHttpDomin(c cVar) {
        String strSubstring = cVar.f23416a;
        if (!TextUtils.isEmpty(strSubstring) && strSubstring.startsWith(Consts.DOT)) {
            strSubstring = strSubstring.substring(1);
        }
        return "https://" + strSubstring;
    }

    public static JSONObject getKeyValues(String str) {
        String strSubstring;
        String strTrim;
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            String cookie = a.a().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                for (String str2 : cookie.split(l.b)) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length >= 2 && strArrSplit[0].contains(str)) {
                        if (strArrSplit.length == 2) {
                            strTrim = strArrSplit[0].trim();
                            strSubstring = strArrSplit[1].trim();
                        } else {
                            int iIndexOf = str2.indexOf("=");
                            String strTrim2 = strArrSplit[0].trim();
                            strSubstring = str2.substring(iIndexOf + 1);
                            strTrim = strTrim2;
                        }
                        jSONObject.put(strTrim, strSubstring);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String cookie = a.a().getCookie(".taobao.com");
            if (!TextUtils.isEmpty(cookie)) {
                for (String str2 : cookie.split(l.b)) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length >= 2 && str.equals(strArrSplit[0].trim())) {
                        return strArrSplit.length == 2 ? strArrSplit[1].trim() : str2.substring(str2.indexOf("=") + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static c parseCookie(String str) {
        String strSubstring;
        StringBuilder sb;
        String str2;
        int iIndexOf;
        int iIndexOf2;
        int length = str.length();
        int iIndexOf3 = 0;
        while (iIndexOf3 >= 0 && iIndexOf3 < length) {
            char c = ' ';
            if (str.charAt(iIndexOf3) != ' ') {
                int iIndexOf4 = str.indexOf(59, iIndexOf3);
                char c2 = com.alipay.sdk.m.p.a.h;
                int iIndexOf5 = str.indexOf(61, iIndexOf3);
                c cVar = new c();
                if ((iIndexOf4 == -1 || iIndexOf4 >= iIndexOf5) && iIndexOf5 != -1) {
                    cVar.c = str.substring(iIndexOf3, iIndexOf5);
                    if (iIndexOf5 < length - 1 && str.charAt(iIndexOf5 + 1) == '\"' && (iIndexOf3 = str.indexOf(34, iIndexOf5 + 2)) == -1) {
                        break;
                    }
                    int iIndexOf6 = str.indexOf(59, iIndexOf3);
                    iIndexOf4 = iIndexOf6 == -1 ? length : iIndexOf6;
                    if (iIndexOf4 - iIndexOf5 > 4096) {
                        int i = iIndexOf5 + 1;
                        strSubstring = str.substring(i, i + 4096);
                    } else {
                        int i2 = iIndexOf5 + 1;
                        strSubstring = (i2 == iIndexOf4 || iIndexOf4 < iIndexOf5) ? "" : str.substring(i2, iIndexOf4);
                    }
                    cVar.d = strSubstring;
                } else {
                    if (iIndexOf4 == -1) {
                        iIndexOf4 = length;
                    }
                    cVar.c = str.substring(iIndexOf3, iIndexOf4);
                    cVar.d = null;
                }
                while (iIndexOf4 >= 0 && iIndexOf4 < length) {
                    if (str.charAt(iIndexOf4) != c && str.charAt(iIndexOf4) != ';') {
                        if (str.charAt(iIndexOf4) == ',') {
                            break;
                        }
                        int i3 = length - iIndexOf4;
                        int i4 = f23413a;
                        if (i3 < i4 || !str.substring(iIndexOf4, iIndexOf4 + i4).equalsIgnoreCase("secure")) {
                            int i5 = b;
                            if (i3 < i5 || !str.substring(iIndexOf4, iIndexOf4 + i5).equalsIgnoreCase("httponly")) {
                                int iIndexOf7 = str.indexOf(c2, iIndexOf4);
                                if (iIndexOf7 > 0) {
                                    String lowerCase = str.substring(iIndexOf4, iIndexOf7).toLowerCase();
                                    if (lowerCase.equals("expires") && (iIndexOf2 = str.indexOf(44, iIndexOf7)) != -1 && iIndexOf2 - iIndexOf7 <= 10) {
                                        iIndexOf4 = iIndexOf2 + 1;
                                    }
                                    int iIndexOf8 = str.indexOf(59, iIndexOf4);
                                    iIndexOf4 = str.indexOf(44, iIndexOf4);
                                    if (iIndexOf8 == -1 && iIndexOf4 == -1) {
                                        iIndexOf4 = length;
                                    } else if (iIndexOf8 != -1) {
                                        if (iIndexOf4 != -1) {
                                            iIndexOf8 = Math.min(iIndexOf8, iIndexOf4);
                                        }
                                        iIndexOf4 = iIndexOf8;
                                    }
                                    String strSubstring2 = str.substring(iIndexOf7 + 1, iIndexOf4);
                                    if (strSubstring2.length() > 2 && strSubstring2.charAt(0) == '\"' && (iIndexOf = strSubstring2.indexOf(34, 1)) > 0) {
                                        strSubstring2 = strSubstring2.substring(1, iIndexOf);
                                    }
                                    String str3 = strSubstring2;
                                    if (lowerCase.equals("expires")) {
                                        try {
                                            cVar.e = b.e(str3);
                                        } catch (IllegalArgumentException e) {
                                            e = e;
                                            sb = new StringBuilder();
                                            str2 = "illegal format for expires: ";
                                            sb.append(str2);
                                            sb.append(str3);
                                            SDKLogger.e("login.LoginCookieUtils", sb.toString(), e);
                                        }
                                    } else if (lowerCase.equals("max-age")) {
                                        try {
                                            cVar.e = System.currentTimeMillis() + (Long.parseLong(str3) * 1000);
                                        } catch (NumberFormatException e2) {
                                            e = e2;
                                            sb = new StringBuilder();
                                            str2 = "illegal format for max-age: ";
                                            sb.append(str2);
                                            sb.append(str3);
                                            SDKLogger.e("login.LoginCookieUtils", sb.toString(), e);
                                        }
                                    } else if (lowerCase.equals("path")) {
                                        if (str3.length() > 0) {
                                            cVar.b = str3;
                                        }
                                    } else if (lowerCase.equals("domain")) {
                                        int iLastIndexOf = str3.lastIndexOf(46);
                                        if (iLastIndexOf == 0) {
                                            cVar.f23416a = null;
                                        } else {
                                            try {
                                                Integer.parseInt(str3.substring(iLastIndexOf + 1));
                                            } catch (NumberFormatException unused) {
                                                String lowerCase2 = str3.toLowerCase();
                                                if (lowerCase2.charAt(0) != '.') {
                                                    lowerCase2 = '.' + lowerCase2;
                                                }
                                                cVar.f23416a = lowerCase2;
                                            }
                                        }
                                    }
                                    c = ' ';
                                    c2 = com.alipay.sdk.m.p.a.h;
                                } else {
                                    iIndexOf4 = length;
                                }
                            } else {
                                iIndexOf4 += i5;
                                cVar.g = true;
                                if (iIndexOf4 == length) {
                                    break;
                                }
                                if (str.charAt(iIndexOf4) == c2) {
                                }
                            }
                            c = ' ';
                        } else {
                            iIndexOf4 += i4;
                            cVar.f = true;
                            if (iIndexOf4 == length) {
                                break;
                            }
                            if (str.charAt(iIndexOf4) != c2) {
                                c = ' ';
                            }
                        }
                    }
                    iIndexOf4++;
                    c = ' ';
                    c2 = com.alipay.sdk.m.p.a.h;
                }
                return cVar;
            }
            iIndexOf3++;
        }
        return null;
    }
}
