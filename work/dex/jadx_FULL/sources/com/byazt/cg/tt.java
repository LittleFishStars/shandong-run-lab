package com.byazt.cg;

import com.acse.ottn.p3;
import com.byazt.dna.or;
import com.byazt.nr.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 549, 13})
public class tt implements or {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28354a;
    public Class c;
    public Method n;
    public Method tt;
    public Method uj;
    public Method ve;

    public tt() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.c = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod(p3.f, String.class);
            this.tt = declaredMethod;
            declaredMethod.setAccessible(true);
            this.f28354a = true;
        } catch (Exception unused) {
            this.c = null;
            this.f28354a = false;
        }
    }

    private Method c(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.c.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.dna.or
    public String get(String str) {
        return (String) c(this.tt, str);
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        if (this.n == null) {
            this.n = c("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) c(this.n, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        if (this.ve == null) {
            this.ve = c("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) c(this.ve, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        if (this.uj == null) {
            this.uj = c("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) c(this.uj, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
    }

    private <T> T c(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.c, str);
        } catch (Exception e) {
            m.tt("SystemPropRefect", "invoke failed", e);
            return null;
        }
    }

    public boolean c() {
        return this.f28354a;
    }
}
