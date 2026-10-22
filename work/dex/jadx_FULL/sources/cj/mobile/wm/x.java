package cj.mobile.wm;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class x implements g0, j {
    public static x dexa = new x();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        T t;
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 8) {
            dex13Var.dexb(16);
            return null;
        }
        if (iDexu == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(dex13Var.dexh());
            } else {
                try {
                    t = (T) Integer.valueOf(dex13Var.dexe());
                } catch (NumberFormatException e) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("int value overflow, field : " + obj, e);
                }
            }
            dex13Var.dexb(16);
            return t;
        }
        if (iDexu == 3) {
            BigDecimal bigDecimalDexc = dex13Var.dexc();
            dex13Var.dexb(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(bigDecimalDexc.longValueExact()) : (T) Integer.valueOf(bigDecimalDexc.intValueExact());
        }
        T t2 = (T) dex11Var.dexe();
        try {
            t2 = (type == Long.TYPE || type == Long.class) ? (T) q0.dexk(t2) : (T) q0.dexj(t2);
            return t2;
        } catch (Exception e2) {
            throw new com.wangmai.insightvision.openadsdk.d.d("cast error, field : " + obj + ", value " + t2, e2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        m0 m0Var = zVar.dexb;
        Number number = (Number) obj;
        if (number == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.h.y) != 0) {
                m0Var.write(48);
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        if (obj instanceof Long) {
            m0Var.dexa(number.longValue());
        } else {
            m0Var.dexb(number.intValue());
        }
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                i = 66;
            } else if (cls == Short.class) {
                i = 83;
            } else {
                if (cls != Long.class) {
                    return;
                }
                long jLongValue = number.longValue();
                if (jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
                    return;
                } else {
                    i = 76;
                }
            }
            m0Var.write(i);
        }
    }
}
