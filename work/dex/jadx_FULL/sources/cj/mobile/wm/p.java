package cj.mobile.wm;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class p implements g0 {
    public final Class<?> dexa;
    public final g0 dexb;

    public p(Class<?> cls, g0 g0Var) {
        this.dexa = cls;
        this.dexb = g0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public final void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) != 0) {
                m0Var.write("[]");
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        int i = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m0Var.write(91);
            while (i < zArr.length) {
                if (i != 0) {
                    m0Var.write(44);
                }
                m0Var.dexa(zArr[i]);
                i++;
            }
            m0Var.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            m0Var.dexa((byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            m0Var.dexa(new String((char[]) obj));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length = dArr.length - 1;
            if (length == -1) {
                m0Var.append((CharSequence) "[]");
                return;
            }
            m0Var.write(91);
            while (i < length) {
                double d = dArr[i];
                if (Double.isNaN(d)) {
                    m0Var.dexa();
                } else {
                    m0Var.append((CharSequence) Double.toString(d));
                }
                m0Var.write(44);
                i++;
            }
            double d2 = dArr[length];
            if (Double.isNaN(d2)) {
                m0Var.dexa();
            } else {
                m0Var.append((CharSequence) Double.toString(d2));
            }
            m0Var.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length2 = fArr.length - 1;
            if (length2 == -1) {
                m0Var.append((CharSequence) "[]");
                return;
            }
            m0Var.write(91);
            while (i < length2) {
                float f = fArr[i];
                if (Float.isNaN(f)) {
                    m0Var.dexa();
                } else {
                    m0Var.append((CharSequence) Float.toString(f));
                }
                m0Var.write(44);
                i++;
            }
            float f2 = fArr[length2];
            if (Float.isNaN(f2)) {
                m0Var.dexa();
            } else {
                m0Var.append((CharSequence) Float.toString(f2));
            }
            m0Var.write(93);
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m0Var.write(91);
            while (i < iArr.length) {
                if (i != 0) {
                    m0Var.write(44);
                }
                m0Var.dexb(iArr[i]);
                i++;
            }
            m0Var.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m0Var.write(91);
            while (i < jArr.length) {
                if (i != 0) {
                    m0Var.write(44);
                }
                m0Var.dexa(jArr[i]);
                i++;
            }
            m0Var.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m0Var.write(91);
            while (i < sArr.length) {
                if (i != 0) {
                    m0Var.write(44);
                }
                m0Var.dexb(sArr[i]);
                i++;
            }
            m0Var.write(93);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length3 = objArr.length;
        j0 j0Var = zVar.dexm;
        zVar.dexa(j0Var, obj, obj2, 0);
        try {
            m0Var.write(91);
            while (i < length3) {
                if (i != 0) {
                    m0Var.write(44);
                }
                Object obj3 = objArr[i];
                if (obj3 != null) {
                    (obj3.getClass() == this.dexa ? this.dexb : zVar.dexa.dexa(obj3.getClass())).dexa(zVar, obj3, Integer.valueOf(i), null);
                } else if (m0Var.dexa(com.wangmai.insightvision.openadsdk.d.j.a0.g) && (obj instanceof String[])) {
                    m0Var.dexa("");
                } else {
                    m0Var.append((CharSequence) "null");
                }
                i++;
            }
            m0Var.write(93);
        } finally {
            zVar.dexm = j0Var;
        }
    }
}
