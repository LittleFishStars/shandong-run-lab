package com.byazt.ut;

import com.byazt.nr.m;
import com.byazt.omf.p;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 834, 15})
public final class uj implements Function<Object, Object> {
    public static final String TAG = "AutoService";
    public static uj tt;
    public int ve = p.tt;
    public final c c = new c();

    private uj() {
    }

    public static com.byazt.dna.c getAppContext(String str) {
        return getInstance().c.c(str);
    }

    public static uj getInstance() {
        uj ujVar = tt;
        if (ujVar != null) {
            return ujVar;
        }
        synchronized (uj.class) {
            if (tt == null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                tt = new uj();
                m.c(TAG, "getInstance cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
        }
        return tt;
    }

    public static <T> T getService(Class<T> cls) {
        throw new RuntimeException("not support");
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        String str;
        try {
            if (obj == null) {
                return Collections.unmodifiableMap(this.c.c());
            }
            if (obj instanceof Function) {
                this.c.c(this, (Function) obj);
            } else {
                if (obj instanceof String) {
                    return this.c.c(String.valueOf(obj), null, false);
                }
                if (obj instanceof Integer) {
                    return Integer.valueOf(this.ve);
                }
            }
            return this.c.c(obj);
        } catch (Exception e) {
            m.tt(TAG, "AutoService apply error", e);
            i iVarA = this.c.a();
            if (iVarA != null) {
                if (obj == null) {
                    str = "";
                } else {
                    str = obj.getClass().getName() + " " + obj;
                }
                iVarA.c(0, str, e);
            }
            return null;
        }
    }

    public int getVersion() {
        return this.ve;
    }

    @Deprecated
    public void setForbiddenReuseList(List<String> list) {
        this.c.c(list);
    }

    public void setListener(i iVar) {
        this.c.c(iVar);
    }

    public static <T> T getService(Class<T> cls, com.byazt.dna.c cVar) {
        throw new RuntimeException("not support");
    }

    public static <T> T getService(String str) {
        return (T) getService(str, (com.byazt.dna.c) null);
    }

    public static <T> T getService(String str, com.byazt.dna.c cVar) {
        c cVar2 = getInstance().c;
        T t = (T) cVar2.c(str, cVar, true);
        return t == null ? (T) cVar2.c(str, cVar) : t;
    }
}
