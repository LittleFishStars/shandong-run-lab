package cj.mobile.wm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b8 {
    public static final d9 dexb = new d9();
    public final Map<d9, a8<?, ?>> dexa = new HashMap();

    public <T, Z> a8<T, Z> dexa(Class<T> cls, Class<Z> cls2) {
        a8<T, Z> a8Var;
        d9 d9Var = dexb;
        synchronized (d9Var) {
            d9Var.dexa(cls, cls2);
            a8Var = (a8) this.dexa.get(d9Var);
        }
        return a8Var == null ? c8.dexa() : a8Var;
    }

    public <T, Z> void dexa(Class<T> cls, Class<Z> cls2, a8<T, Z> a8Var) {
        this.dexa.put(new d9(cls, cls2), a8Var);
    }
}
