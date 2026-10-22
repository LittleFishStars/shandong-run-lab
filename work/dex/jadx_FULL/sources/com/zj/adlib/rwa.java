package com.zj.adlib;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class rwa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f44557a = "0123456789";

    public static String a() {
        Random random = new Random();
        int iNextInt = random.nextInt(10);
        Locale locale = Locale.US;
        String str = String.format(locale, "%05d", Integer.valueOf(iNextInt));
        int iNextInt2 = random.nextInt(10);
        int iNextInt3 = random.nextInt(100);
        return new a(f44557a, iNextInt3).c(iNextInt2, str) + String.format(locale, zh9.f, Integer.valueOf(iNextInt2)) + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(iNextInt3));
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44558a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f19445a;
        public int b;

        public a(String str, int i) {
            this.f44558a = 1103515245;
            this.b = 12345;
            this.f19445a = d(str, i, str.length());
        }

        public final char a(int i) {
            this.f19445a.length();
            return this.f19445a.charAt(i);
        }

        public final int b(char c) {
            this.f19445a.length();
            return this.f19445a.indexOf(c);
        }

        public final String c(int i, String str) {
            return f(i, str);
        }

        public final String d(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                int iE = e(i);
                int i4 = iE % length;
                i = e(iE);
                int i5 = i % length;
                char cCharAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, cCharAt);
            }
            return stringBuffer.toString();
        }

        public final int e(int i) {
            return (int) (((((long) i) * ((long) this.f44558a)) + ((long) this.b)) & 2147483647L);
        }

        public final String f(int i, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f19445a.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                int iB = b(str.charAt(i2));
                if (iB < 0) {
                    break;
                }
                sb.append(a(((iB + i) + i2) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public a() {
            this((byte) 0);
        }

        public a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }
    }
}
