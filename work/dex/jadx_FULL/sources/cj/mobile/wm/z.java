package cj.mobile.wm;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z {
    public final k0 dexa;
    public final m0 dexb;
    public String dexj;
    public DateFormat dexk;
    public j0 dexm;
    public TimeZone dexn;
    public List<q> dexc = null;
    public List<l> dexd = null;
    public List<h0> dexe = null;
    public List<o> dexf = null;
    public List<e0> dexg = null;
    public List<i0> dexh = null;
    public int dexi = 0;
    public IdentityHashMap<Object, j0> dexl = null;
    public Locale dexo = dex04.b;

    public z(m0 m0Var, k0 k0Var) {
        this.dexn = dex04.f22670a;
        this.dexb = m0Var;
        this.dexa = k0Var;
        this.dexn = dex04.f22670a;
    }

    public static Object dexa(z zVar, Object obj, Object obj2, Object obj3) {
        List<o> list = zVar.dexf;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = dex04.b(obj2);
            }
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                obj3 = it.next().dexa(obj, (String) obj2, obj3);
            }
        }
        return obj3;
    }

    public void dexa() {
        this.dexi--;
    }

    public void dexa(j0 j0Var, Object obj, Object obj2, int i) {
        if ((this.dexb.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.o.y) == 0) {
            this.dexm = new j0(j0Var, obj, obj2, i);
            if (this.dexl == null) {
                this.dexl = new IdentityHashMap<>();
            }
            this.dexl.put(obj, this.dexm);
        }
    }

    public void dexa(com.wangmai.insightvision.openadsdk.d.j.a0 a0Var, boolean z) {
        this.dexb.dexa(a0Var, z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexa(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj == null) {
            this.dexb.dexa();
            return;
        }
        try {
            this.dexa.dexa(obj.getClass()).dexa(this, obj, null, null);
        } catch (IOException e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexa(Object obj, Object obj2, Type type, int i) throws com.wangmai.insightvision.openadsdk.d.d {
        try {
            if (obj == null) {
                this.dexb.dexa();
            } else {
                this.dexa.dexa(obj.getClass()).dexa(this, obj, obj2, type);
            }
        } catch (IOException e) {
            throw new com.wangmai.insightvision.openadsdk.d.d(e.getMessage(), e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexa(Object obj, String str) throws com.wangmai.insightvision.openadsdk.d.d {
        if (!(obj instanceof Date)) {
            dexa(obj);
            return;
        }
        DateFormat dateFormatDexd = dexd();
        if (dateFormatDexd == null) {
            dateFormatDexd = new SimpleDateFormat(str, this.dexo);
            dateFormatDexd.setTimeZone(this.dexn);
        }
        this.dexb.dexa(dateFormatDexd.format((Date) obj));
    }

    public void dexa(String str) {
        this.dexj = str;
        if (this.dexk != null) {
            this.dexk = null;
        }
    }

    public boolean dexa(Object obj, Object obj2) {
        List<i0> list = this.dexh;
        if (list == null) {
            return true;
        }
        for (i0 i0Var : list) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = dex04.b(obj2);
            }
            if (!i0Var.dexa(this, obj, (String) obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean dexa(Object obj, Object obj2, Object obj3) {
        List<h0> list = this.dexe;
        if (list == null) {
            return true;
        }
        if (obj2 != null && !(obj2 instanceof String)) {
            obj2 = dex04.b(obj2);
        }
        Iterator<h0> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().dexb(obj, (String) obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    public Object dexb(Object obj, Object obj2, Object obj3) {
        List<e0> list = this.dexg;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = dex04.b(obj2);
            }
            Iterator<e0> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().dexa(obj, (String) obj2, obj3);
            }
        }
        return obj2;
    }

    public List<l> dexb() {
        if (this.dexd == null) {
            this.dexd = new ArrayList();
        }
        return this.dexd;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexb(Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        m0 m0Var;
        String str;
        j0 j0Var = this.dexm;
        if (obj == j0Var.dexb) {
            m0Var = this.dexb;
            str = "{\"$ref\":\"@\"}";
        } else {
            j0 j0Var2 = j0Var.dexa;
            if (j0Var2 == null || obj != j0Var2.dexb) {
                while (true) {
                    j0 j0Var3 = j0Var.dexa;
                    if (j0Var3 == null) {
                        break;
                    } else {
                        j0Var = j0Var3;
                    }
                }
                if (obj == j0Var.dexb) {
                    m0Var = this.dexb;
                    str = "{\"$ref\":\"$\"}";
                } else {
                    String string = this.dexl.get(obj).toString();
                    this.dexb.write("{\"$ref\":\"");
                    this.dexb.write(string);
                    m0Var = this.dexb;
                    str = "\"}";
                }
            } else {
                m0Var = this.dexb;
                str = "{\"$ref\":\"..\"}";
            }
        }
        m0Var.write(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexb(Object obj, Object obj2) throws com.wangmai.insightvision.openadsdk.d.d {
        dexa(obj, obj2, (Type) null, 0);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public final void dexb(String str) throws com.wangmai.insightvision.openadsdk.d.d {
        if (str == null) {
            m0 m0Var = this.dexb;
            if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.g.y) != 0) {
                m0Var.dexa("");
                return;
            } else {
                m0Var.dexa();
                return;
            }
        }
        m0 m0Var2 = this.dexb;
        if ((m0Var2.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.b.y) != 0) {
            m0Var2.dexb(str);
        } else {
            m0Var2.dexa(str, (char) 0, true);
        }
    }

    public List<q> dexc() {
        if (this.dexc == null) {
            this.dexc = new ArrayList();
        }
        return this.dexc;
    }

    public DateFormat dexd() {
        String str;
        if (this.dexk == null && (str = this.dexj) != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.dexo);
            this.dexk = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.dexn);
        }
        return this.dexk;
    }

    public List<e0> dexe() {
        if (this.dexg == null) {
            this.dexg = new ArrayList();
        }
        return this.dexg;
    }

    public List<h0> dexf() {
        if (this.dexe == null) {
            this.dexe = new ArrayList();
        }
        return this.dexe;
    }

    public List<i0> dexg() {
        if (this.dexh == null) {
            this.dexh = new ArrayList();
        }
        return this.dexh;
    }

    public List<o> dexh() {
        if (this.dexf == null) {
            this.dexf = new ArrayList();
        }
        return this.dexf;
    }

    public void dexi() {
        this.dexi++;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexj() throws com.wangmai.insightvision.openadsdk.d.d {
        this.dexb.write(10);
        for (int i = 0; i < this.dexi; i++) {
            this.dexb.write(9);
        }
    }

    public String toString() {
        return this.dexb.toString();
    }
}
