package cj.mobile.wm;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f0 implements g0, j {
    public static final f0 dexb = new f0();
    public DecimalFormat dexa = null;

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.math.BigDecimal] */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String strDexl = dex13Var.dexl();
                dex13Var.dexb(16);
                return (T) Double.valueOf(Double.parseDouble(strDexl));
            }
            if (type == Float.TYPE || type == Float.class) {
                String strDexl2 = dex13Var.dexl();
                dex13Var.dexb(16);
                return (T) Float.valueOf(Float.parseFloat(strDexl2));
            }
            long jDexh = dex13Var.dexh();
            dex13Var.dexb(16);
            if (type == Short.TYPE || type == Short.class) {
                return (T) Short.valueOf((short) jDexh);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                return (T) Byte.valueOf((byte) jDexh);
            }
            return (jDexh < -2147483648L || jDexh > 2147483647L) ? (T) Long.valueOf(jDexh) : (T) Integer.valueOf((int) jDexh);
        }
        if (iDexu != 3) {
            Object objDexe = dex11Var.dexe();
            if (objDexe == null) {
                return null;
            }
            if (type == Double.TYPE || type == Double.class) {
                return (T) q0.dexh(objDexe);
            }
            if (type == Float.TYPE || type == Float.class) {
                return (T) q0.dexi(objDexe);
            }
            if (type == Short.TYPE || type == Short.class) {
                return (T) q0.dexl(objDexe);
            }
            return (type == Byte.TYPE || type == Byte.class) ? (T) q0.dexd(objDexe) : (T) q0.dexa(objDexe);
        }
        if (type == Double.TYPE || type == Double.class) {
            String strDexl3 = dex13Var.dexl();
            dex13Var.dexb(16);
            return (T) Double.valueOf(Double.parseDouble(strDexl3));
        }
        if (type == Float.TYPE || type == Float.class) {
            String strDexl4 = dex13Var.dexl();
            dex13Var.dexb(16);
            return (T) Float.valueOf(Float.parseFloat(strDexl4));
        }
        ?? r8 = (T) dex13Var.dexc();
        dex13Var.dexb(16);
        if (type == Short.TYPE || type == Short.class) {
            return (T) Short.valueOf(r8.shortValueExact());
        }
        return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r8.byteValueExact()) : r8;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        String string;
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.h.y) != 0) {
                m0Var.write(48);
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (Float.isNaN(fFloatValue) || Float.isInfinite(fFloatValue)) {
                m0Var.dexa();
                return;
            }
            String string2 = Float.toString(fFloatValue);
            if (string2.endsWith(".0")) {
                string2 = string2.substring(0, string2.length() - 2);
            }
            m0Var.write(string2);
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0) {
                m0Var.write(70);
                return;
            }
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
            m0Var.dexa();
            return;
        }
        DecimalFormat decimalFormat = this.dexa;
        if (decimalFormat == null) {
            string = Double.toString(dDoubleValue);
            if (string.endsWith(".0")) {
                string = string.substring(0, string.length() - 2);
            }
        } else {
            string = decimalFormat.format(dDoubleValue);
        }
        m0Var.append((CharSequence) string);
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0) {
            m0Var.write(68);
        }
    }
}
