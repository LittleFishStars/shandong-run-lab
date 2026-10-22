package cj.mobile.wm;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r implements g0, j {
    public static final r dexa = new r();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.math.BigDecimal] */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 2) {
            if (type == BigInteger.class) {
                String strDexl = dex13Var.dexl();
                dex13Var.dexb(16);
                return (T) new BigInteger(strDexl, 10);
            }
            T t = (T) dex13Var.dexc();
            dex13Var.dexb(16);
            return t;
        }
        if (iDexu != 3) {
            Object objDexe = dex11Var.dexe();
            if (objDexe == null) {
                return null;
            }
            return type == BigInteger.class ? (T) q0.dexb(objDexe) : (T) q0.dexa(objDexe);
        }
        ?? r5 = (T) dex13Var.dexc();
        dex13Var.dexb(16);
        if (type != BigInteger.class) {
            return r5;
        }
        int iScale = r5.scale();
        if (iScale < -100 || iScale > 100) {
            throw new NumberFormatException();
        }
        return (T) r5.toBigInteger();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
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
        if (obj instanceof BigInteger) {
            m0Var.write(((BigInteger) obj).toString());
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        m0Var.write(bigDecimal.toString());
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) == 0 || type == BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        m0Var.write(46);
    }
}
