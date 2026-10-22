package com.beizi.fusion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class lg extends fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f27510a;

    public lg(Number number) {
        Objects.requireNonNull(number);
        this.f27510a = number;
    }

    private static boolean a(lg lgVar) {
        Object obj = lgVar.f27510a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lg.class != obj.getClass()) {
            return false;
        }
        lg lgVar = (lg) obj;
        if (this.f27510a == null) {
            return lgVar.f27510a == null;
        }
        if (a(this) && a(lgVar)) {
            if ((this.f27510a instanceof BigInteger) || (lgVar.f27510a instanceof BigInteger)) {
                return i().equals(lgVar.i());
            }
            return l().longValue() == lgVar.l().longValue();
        }
        Object obj2 = this.f27510a;
        if (obj2 instanceof Number) {
            Object obj3 = lgVar.f27510a;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return h().compareTo(lgVar.h()) == 0;
                }
                double dK = k();
                double dK2 = lgVar.k();
                return dK == dK2 || (Double.isNaN(dK) && Double.isNaN(dK2));
            }
        }
        return obj2.equals(lgVar.f27510a);
    }

    public BigDecimal h() {
        Object obj = this.f27510a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : qj.b(m());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f27510a == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = l().longValue();
        } else {
            Object obj = this.f27510a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(l().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public BigInteger i() {
        Object obj = this.f27510a;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return a(this) ? BigInteger.valueOf(l().longValue()) : qj.c(m());
    }

    public boolean j() {
        return n() ? ((Boolean) this.f27510a).booleanValue() : Boolean.parseBoolean(m());
    }

    public double k() {
        return o() ? l().doubleValue() : Double.parseDouble(m());
    }

    public Number l() {
        Object obj = this.f27510a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new tg((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String m() {
        Object obj = this.f27510a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (o()) {
            return l().toString();
        }
        if (n()) {
            return ((Boolean) this.f27510a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f27510a.getClass());
    }

    public boolean n() {
        return this.f27510a instanceof Boolean;
    }

    public boolean o() {
        return this.f27510a instanceof Number;
    }

    public lg(String str) {
        Objects.requireNonNull(str);
        this.f27510a = str;
    }
}
