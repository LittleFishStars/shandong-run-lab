package com.beizi.fusion;

import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class tg extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27784a;

    public tg(String str) {
        this.f27784a = str;
    }

    private BigDecimal a() {
        return qj.b(this.f27784a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f27784a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof tg) {
            return this.f27784a.equals(((tg) obj).f27784a);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f27784a);
    }

    public int hashCode() {
        return this.f27784a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f27784a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f27784a);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f27784a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f27784a;
    }
}
