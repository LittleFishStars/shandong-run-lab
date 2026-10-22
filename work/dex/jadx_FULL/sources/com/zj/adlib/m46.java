package com.zj.adlib;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class m46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<DecimalFormat> f43218a = new a();

    public class a extends ThreadLocal<DecimalFormat> {
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            return (DecimalFormat) NumberFormat.getInstance();
        }
    }

    public m46() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static double a(float f) {
        return new BigDecimal(String.valueOf(f)).doubleValue();
    }

    public static String b(double d, int i) {
        return f(d, false, 1, i, true);
    }

    public static String c(double d, int i, int i2, boolean z) {
        return f(d, false, i, i2, z);
    }

    public static String d(double d, int i, boolean z) {
        return f(d, false, 1, i, z);
    }

    public static String e(double d, boolean z, int i) {
        return f(d, z, 1, i, true);
    }

    public static String f(double d, boolean z, int i, int i2, boolean z2) {
        DecimalFormat decimalFormatN = n();
        decimalFormatN.setGroupingUsed(z);
        decimalFormatN.setRoundingMode(z2 ? RoundingMode.HALF_UP : RoundingMode.DOWN);
        decimalFormatN.setMinimumIntegerDigits(i);
        decimalFormatN.setMinimumFractionDigits(i2);
        decimalFormatN.setMaximumFractionDigits(i2);
        return decimalFormatN.format(d);
    }

    public static String g(double d, boolean z, int i, boolean z2) {
        return f(d, z, 1, i, z2);
    }

    public static String h(float f, int i) {
        return l(f, false, 1, i, true);
    }

    public static String i(float f, int i, int i2, boolean z) {
        return l(f, false, i, i2, z);
    }

    public static String j(float f, int i, boolean z) {
        return l(f, false, 1, i, z);
    }

    public static String k(float f, boolean z, int i) {
        return l(f, z, 1, i, true);
    }

    public static String l(float f, boolean z, int i, int i2, boolean z2) {
        return f(a(f), z, i, i2, z2);
    }

    public static String m(float f, boolean z, int i, boolean z2) {
        return l(f, z, 1, i, z2);
    }

    public static DecimalFormat n() {
        return f43218a.get();
    }
}
