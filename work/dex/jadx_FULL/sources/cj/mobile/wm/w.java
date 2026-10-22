package cj.mobile.wm;

import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import java.lang.reflect.Member;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class w implements Comparable<w> {
    public final n0 dexa;
    public final boolean dexb;
    public final int dexc;
    public final String dexd;
    public char[] dexe;
    public dexa dexf;

    public static class dexa {
        public g0 dexa;
        public Class<?> dexb;

        public dexa(g0 g0Var, Class<?> cls) {
            this.dexa = g0Var;
            this.dexb = cls;
        }
    }

    public w(n0 n0Var) {
        boolean z;
        this.dexa = n0Var;
        dex08 dex08VarDexa = n0Var.dexa();
        String str = null;
        if (dex08VarDexa != null) {
            z = false;
            for (com.wangmai.insightvision.openadsdk.d.j.a0 a0Var : dex08VarDexa.serialzeFeatures()) {
                if (a0Var == com.wangmai.insightvision.openadsdk.d.j.a0.c) {
                    z = true;
                }
            }
            String strTrim = dex08VarDexa.format().trim();
            str = strTrim.length() != 0 ? strTrim : null;
            this.dexc = com.wangmai.insightvision.openadsdk.d.j.a0.a(dex08VarDexa.serialzeFeatures());
        } else {
            this.dexc = 0;
            z = false;
        }
        this.dexb = z;
        this.dexd = str;
        String str2 = n0Var.dexa;
        int length = str2.length();
        this.dexe = new char[length + 3];
        str2.getChars(0, str2.length(), this.dexe, 1);
        char[] cArr = this.dexe;
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = com.google.common.net.c.b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public int compareTo(w wVar) {
        return this.dexa.compareTo(wVar.dexa);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public Object dexa(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        try {
            return this.dexa.dexa(obj);
        } catch (Exception e) {
            n0 n0Var = this.dexa;
            Member member = n0Var.dexb;
            if (member == null) {
                member = n0Var.dexc;
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("get property error。 " + (member.getDeclaringClass().getName() + Consts.DOT + member.getName()), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(z zVar) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var = zVar.dexb;
        int i = m0Var.dexc;
        if ((com.wangmai.insightvision.openadsdk.d.j.a0.a.y & i) == 0 || (i & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0) {
            m0Var.dexa(this.dexa.dexa, true);
        } else {
            char[] cArr = this.dexe;
            m0Var.write(cArr, 0, cArr.length);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(z zVar, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        String str = this.dexd;
        if (str != null) {
            zVar.dexa(obj, str);
            return;
        }
        if (this.dexf == null) {
            Class<?> cls = obj == null ? this.dexa.dexg : obj.getClass();
            this.dexf = new dexa(zVar.dexa.dexa(cls), cls);
        }
        dexa dexaVar = this.dexf;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == dexaVar.dexb) {
                g0 g0Var = dexaVar.dexa;
                n0 n0Var = this.dexa;
                g0Var.dexa(zVar, obj, n0Var.dexa, n0Var.dexh);
                return;
            } else {
                g0 g0VarDexa = zVar.dexa.dexa(cls2);
                n0 n0Var2 = this.dexa;
                g0VarDexa.dexa(zVar, obj, n0Var2.dexa, n0Var2.dexh);
                return;
            }
        }
        if ((this.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.h.y) != 0 && Number.class.isAssignableFrom(dexaVar.dexb)) {
            zVar.dexb.write(48);
            return;
        }
        int i = this.dexc;
        if ((com.wangmai.insightvision.openadsdk.d.j.a0.i.y & i) != 0 && Boolean.class == dexaVar.dexb) {
            zVar.dexb.write(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        } else if ((i & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) == 0 || !Collection.class.isAssignableFrom(dexaVar.dexb)) {
            dexaVar.dexa.dexa(zVar, null, this.dexa.dexa, dexaVar.dexb);
        } else {
            zVar.dexb.write("[]");
        }
    }
}
