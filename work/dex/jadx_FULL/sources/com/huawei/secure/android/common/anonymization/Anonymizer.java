package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.net.c;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Anonymizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37702a = "Anonymizer";

    public static String maskAccountId(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        return str.length() < 8 ? maskCommonString(str, 0, 1) : maskCommonString(str, 0, 4);
    }

    public static String maskBankAccount(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, '*');
        }
        return (str.length() < 11 || str.length() >= 20) ? maskCommonString(str, 6, 4) : maskCommonString(str, 4, 4);
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return a.a(str, '*');
        }
        String[] strArrA = a.a(str, 4);
        return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), "0123456789", "*"));
    }

    public static String maskCommonString(String str, int i, int i2) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (str.length() <= i + i2) {
            length = str.length() - 1;
            i = 1;
        } else {
            length = str.length() - i2;
        }
        String[] strArrA = a.a(str, i, length);
        return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), '*'), a.a(strArrA, 2));
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            String[] strArrA = a.a(str, 1);
            return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), '*'));
        }
        String[] strArrA2 = a.a(str, iIndexOf, iIndexOf + 1, str.lastIndexOf(46));
        return a.a("", a.a(a.a(strArrA2, 0), '*'), a.a(strArrA2, 1), a.a(a.a(strArrA2, 2), '*'), a.a(strArrA2, 3));
    }

    public static String maskId(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 12, 0);
    }

    public static String maskImeiImsi(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 4, 0);
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return a.a(str, '*');
        }
        String[] strArrA = a.a(str, iLastIndexOf + 1);
        return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), '*'));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] strArrB = a.b(str, c.b);
        if (strArrB.length <= 1) {
            return a.a(str, '*');
        }
        if (strArrB.length != 8) {
            String[] strArrA = a.a(str, str.indexOf(58) + 1);
            return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), "0123456789ABCDEFabcdef", "*"));
        }
        strArrB[2] = maskLower8Bit(strArrB[2]);
        for (int i = 3; i < strArrB.length; i++) {
            strArrB[i] = a.a(strArrB[i], '*');
        }
        return a.a(u15.f19942b, strArrB);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f37702a, "maskLower8Bit: s is null");
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, '*');
        }
        String[] strArrA = a.a(str, str.length() - 2);
        return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), '*'));
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int iA = a.a(str, '-', 2);
        if (iA < 0) {
            return a.a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] strArrA = a.a(str, iA);
        return a.a("", a.a(strArrA, 0), a.a(a.a(strArrA, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskName(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return str.length() <= 1 ? "*" : maskCommonString(str, 1, 0);
    }

    public static String maskPhone(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return a.a(str, '*');
        }
        return (str.length() < 8 || str.length() >= 11) ? maskCommonString(str, 3, 4) : maskCommonString(str, 2, 2);
    }
}
