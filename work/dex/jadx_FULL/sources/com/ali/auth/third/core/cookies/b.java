package com.ali.auth.third.core.cookies;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f23414a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23415a;
        int b;
        int c;

        public a(int i, int i2, int i3) {
            this.f23415a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private static int a(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    private static int b(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static a c(String str) {
        int i;
        int iCharAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            iCharAt = (iCharAt * 10) + (str.charAt(1) - '0');
            i = 2;
        } else {
            i = 1;
        }
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = i3 + 1 + 1;
        return new a(iCharAt, ((str.charAt(i2) - '0') * 10) + (str.charAt(i3) - '0'), ((str.charAt(i4) - '0') * 10) + (str.charAt(i4 + 1) - '0'));
    }

    private static int d(String str) {
        if (str.length() == 2) {
            int iCharAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return iCharAt >= 70 ? iCharAt + 1900 : iCharAt + 2000;
        }
        if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        }
        if (str.length() == 4) {
            return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
        }
        return 1970;
    }

    public static long e(String str) throws IllegalArgumentException {
        int iB;
        int iD;
        int iA;
        a aVarC;
        int i;
        int i2;
        int i3;
        Matcher matcher = f23414a.matcher(str);
        if (matcher.find()) {
            iA = a(matcher.group(1));
            iB = b(matcher.group(2));
            iD = d(matcher.group(3));
            aVarC = c(matcher.group(4));
        } else {
            Matcher matcher2 = b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            iB = b(matcher2.group(1));
            int iA2 = a(matcher2.group(2));
            a aVarC2 = c(matcher2.group(3));
            iD = d(matcher2.group(4));
            iA = iA2;
            aVarC = aVarC2;
        }
        if (iD >= 2038) {
            i2 = 0;
            i3 = 2038;
            i = 1;
        } else {
            i = iA;
            i2 = iB;
            i3 = iD;
        }
        Time time = new Time("UTC");
        time.set(aVarC.c, aVarC.b, aVarC.f23415a, i, i2, i3);
        return time.toMillis(false);
    }
}
