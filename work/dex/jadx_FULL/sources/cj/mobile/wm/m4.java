package cj.mobile.wm;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m4 {
    public static final v4 dexd = new dexa();
    public final Map<Class, Map<Class, w4>> dexa = new HashMap();
    public final Map<Class, Map<Class, v4>> dexb = new HashMap();
    public final Context dexc;

    public static class dexa implements v4 {
        @Override // cj.mobile.wm.v4
        public y2 dexa(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public m4(Context context) {
        this.dexc = context.getApplicationContext();
    }

    private <T, Y> void dexa(Class<T> cls, Class<Y> cls2, v4<T, Y> v4Var) {
        Map<Class, v4> map = this.dexb.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.dexb.put(cls, map);
        }
        map.put(cls2, v4Var);
    }

    private <T, Y> void dexb(Class<T> cls, Class<Y> cls2) {
        dexa(cls, cls2, dexd);
    }

    private <T, Y> v4<T, Y> dexc(Class<T> cls, Class<Y> cls2) {
        Map<Class, v4> map = this.dexb.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> w4<T, Y> dexd(Class<T> cls, Class<Y> cls2) {
        Map<Class, w4> map;
        Map<Class, w4> map2 = this.dexa.get(cls);
        w4 w4Var = map2 != null ? map2.get(cls2) : null;
        if (w4Var == null) {
            for (Class cls3 : this.dexa.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.dexa.get(cls3)) != null && (w4Var = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return w4Var;
    }

    public synchronized <T, Y> v4<T, Y> dexa(Class<T> cls, Class<Y> cls2) {
        v4<T, Y> v4VarDexc = dexc(cls, cls2);
        if (v4VarDexc != null) {
            if (dexd.equals(v4VarDexc)) {
                return null;
            }
            return v4VarDexc;
        }
        w4<T, Y> w4VarDexd = dexd(cls, cls2);
        if (w4VarDexd != null) {
            v4VarDexc = w4VarDexd.dexa(this.dexc, this);
            dexa(cls, cls2, v4VarDexc);
        } else {
            dexb(cls, cls2);
        }
        return v4VarDexc;
    }

    public synchronized <T, Y> w4<T, Y> dexa(Class<T> cls, Class<Y> cls2, w4<T, Y> w4Var) {
        w4<T, Y> w4VarPut;
        this.dexb.clear();
        Map<Class, w4> map = this.dexa.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.dexa.put(cls, map);
        }
        w4VarPut = map.put(cls2, w4Var);
        if (w4VarPut != null) {
            Iterator<Map<Class, w4>> it = this.dexa.values().iterator();
            while (it.hasNext()) {
                if (it.next().containsValue(w4VarPut)) {
                    w4VarPut = null;
                    break;
                }
            }
        }
        return w4VarPut;
    }
}
