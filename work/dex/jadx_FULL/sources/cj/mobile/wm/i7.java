package cj.mobile.wm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i7 {
    public static final d9 dexb = new d9();
    public final Map<d9, h7<?, ?>> dexa = new HashMap();

    public <Z, R> h7<Z, R> dexa(Class<Z> cls, Class<R> cls2) {
        h7<Z, R> h7Var;
        if (cls.equals(cls2)) {
            return j7.dexa();
        }
        d9 d9Var = dexb;
        synchronized (d9Var) {
            d9Var.dexa(cls, cls2);
            h7Var = (h7) this.dexa.get(d9Var);
        }
        if (h7Var != null) {
            return h7Var;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void dexa(Class<Z> cls, Class<R> cls2, h7<Z, R> h7Var) {
        this.dexa.put(new d9(cls, cls2), h7Var);
    }
}
