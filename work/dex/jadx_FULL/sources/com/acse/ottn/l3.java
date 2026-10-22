package com.acse.ottn;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l3 implements Cloneable {
    public static final s4 k = new x1();
    public static final s4 l = new h1();
    public static Class[] m;
    public static Class[] n;
    public static Class[] o;
    public static final HashMap<Class, HashMap<String, Method>> p;
    public static final HashMap<Class, HashMap<String, Method>> q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23077a;
    public k3 b;
    public Method c;
    public Method d;
    public Class e;
    public c2 f;
    public final ReentrantReadWriteLock g;
    public final Object[] h;
    public s4 i;
    public Object j;

    public static class b extends l3 {
        public k1 r;
        public j1 s;
        public float t;

        public b(String str, j1 j1Var) {
            super(str);
            this.e = Float.TYPE;
            this.f = j1Var;
            this.s = j1Var;
        }

        @Override // com.acse.ottn.l3
        public Object b() {
            return Float.valueOf(this.t);
        }

        @Override // com.acse.ottn.l3
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.s = (j1) bVar.f;
            return bVar;
        }

        @Override // com.acse.ottn.l3
        public void a(float... fArr) {
            super.a(fArr);
            this.s = (j1) this.f;
        }

        @Override // com.acse.ottn.l3
        public void b(Class cls) {
            if (this.b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.l3
        public void a(float f) {
            this.t = this.s.b(f);
        }

        public b(k3 k3Var, j1 j1Var) {
            super(k3Var);
            this.e = Float.TYPE;
            this.f = j1Var;
            this.s = j1Var;
            if (k3Var instanceof k1) {
                this.r = (k1) this.b;
            }
        }

        @Override // com.acse.ottn.l3
        public void a(Object obj) {
            k1 k1Var = this.r;
            if (k1Var != null) {
                k1Var.a(obj, this.t);
                return;
            }
            k3 k3Var = this.b;
            if (k3Var != null) {
                k3Var.a(obj, Float.valueOf(this.t));
                return;
            }
            if (this.c != null) {
                try {
                    this.h[0] = Float.valueOf(this.t);
                    this.c.invoke(obj, this.h);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        public b(String str, float... fArr) {
            super(str);
            a(fArr);
        }

        public b(k3 k3Var, float... fArr) {
            super(k3Var);
            a(fArr);
            if (k3Var instanceof k1) {
                this.r = (k1) this.b;
            }
        }
    }

    public static class c extends l3 {
        public z1 r;
        public y1 s;
        public int t;

        public c(String str, y1 y1Var) {
            super(str);
            this.e = Integer.TYPE;
            this.f = y1Var;
            this.s = y1Var;
        }

        @Override // com.acse.ottn.l3
        public Object b() {
            return Integer.valueOf(this.t);
        }

        @Override // com.acse.ottn.l3
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public c clone() {
            c cVar = (c) super.clone();
            cVar.s = (y1) cVar.f;
            return cVar;
        }

        @Override // com.acse.ottn.l3
        public void a(int... iArr) {
            super.a(iArr);
            this.s = (y1) this.f;
        }

        @Override // com.acse.ottn.l3
        public void b(Class cls) {
            if (this.b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.l3
        public void a(float f) {
            this.t = this.s.b(f);
        }

        public c(k3 k3Var, y1 y1Var) {
            super(k3Var);
            this.e = Integer.TYPE;
            this.f = y1Var;
            this.s = y1Var;
            if (k3Var instanceof z1) {
                this.r = (z1) this.b;
            }
        }

        @Override // com.acse.ottn.l3
        public void a(Object obj) {
            z1 z1Var = this.r;
            if (z1Var != null) {
                z1Var.a(obj, this.t);
                return;
            }
            k3 k3Var = this.b;
            if (k3Var != null) {
                k3Var.a(obj, Integer.valueOf(this.t));
                return;
            }
            if (this.c != null) {
                try {
                    this.h[0] = Integer.valueOf(this.t);
                    this.c.invoke(obj, this.h);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        public c(String str, int... iArr) {
            super(str);
            a(iArr);
        }

        public c(k3 k3Var, int... iArr) {
            super(k3Var);
            a(iArr);
            if (k3Var instanceof z1) {
                this.r = (z1) this.b;
            }
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        m = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        n = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        o = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        p = new HashMap<>();
        q = new HashMap<>();
    }

    public static l3 a(String str, int... iArr) {
        return new c(str, iArr);
    }

    public void b(Class cls) {
        this.c = a(cls, p, p3.h, this.e);
    }

    public void c(Object obj) {
        k3 k3Var = this.b;
        if (k3Var != null) {
            try {
                k3Var.a(obj);
                for (b2 b2Var : this.f.e) {
                    if (!b2Var.f()) {
                        b2Var.a(this.b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.b.a() + ") on target object " + obj + ". Trying reflection instead");
                this.b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.c == null) {
            b((Class) cls);
        }
        for (b2 b2Var2 : this.f.e) {
            if (!b2Var2.f()) {
                if (this.d == null) {
                    a((Class) cls);
                }
                try {
                    b2Var2.a(this.d.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    public void d(Object obj) {
        a(obj, this.f.e.get(0));
    }

    public String toString() {
        return this.f23077a + ": " + this.f.toString();
    }

    public static l3 a(k3<?, Integer> k3Var, int... iArr) {
        return new c(k3Var, iArr);
    }

    public void b(Object obj) {
        ArrayList<b2> arrayList = this.f.e;
        a(obj, arrayList.get(arrayList.size() - 1));
    }

    public void d() {
        s4 s4Var;
        if (this.i == null) {
            Class cls = this.e;
            if (cls == Integer.class) {
                s4Var = k;
            } else {
                s4Var = cls == Float.class ? l : null;
            }
            this.i = s4Var;
        }
        s4 s4Var2 = this.i;
        if (s4Var2 != null) {
            this.f.a(s4Var2);
        }
    }

    public l3(String str) {
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = new ReentrantReadWriteLock();
        this.h = new Object[1];
        this.f23077a = str;
    }

    public static l3 a(String str, float... fArr) {
        return new b(str, fArr);
    }

    public Object b() {
        return this.j;
    }

    public static l3 a(k3<?, Float> k3Var, float... fArr) {
        return new b(k3Var, fArr);
    }

    public static l3 a(String str, s4 s4Var, Object... objArr) {
        l3 l3Var = new l3(str);
        l3Var.a(objArr);
        l3Var.a(s4Var);
        return l3Var;
    }

    public static <V> l3 a(k3 k3Var, s4<V> s4Var, V... vArr) {
        l3 l3Var = new l3(k3Var);
        l3Var.a((Object[]) vArr);
        l3Var.a((s4) s4Var);
        return l3Var;
    }

    public l3(k3 k3Var) {
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = new ReentrantReadWriteLock();
        this.h = new Object[1];
        this.b = k3Var;
        if (k3Var != null) {
            this.f23077a = k3Var.a();
        }
    }

    public static l3 a(String str, b2... b2VarArr) {
        c2 c2VarA = c2.a(b2VarArr);
        if (c2VarA instanceof y1) {
            return new c(str, (y1) c2VarA);
        }
        if (c2VarA instanceof j1) {
            return new b(str, (j1) c2VarA);
        }
        l3 l3Var = new l3(str);
        l3Var.f = c2VarA;
        l3Var.e = b2VarArr[0].d();
        return l3Var;
    }

    public String c() {
        return this.f23077a;
    }

    public static l3 a(k3 k3Var, b2... b2VarArr) {
        c2 c2VarA = c2.a(b2VarArr);
        if (c2VarA instanceof y1) {
            return new c(k3Var, (y1) c2VarA);
        }
        if (c2VarA instanceof j1) {
            return new b(k3Var, (j1) c2VarA);
        }
        l3 l3Var = new l3(k3Var);
        l3Var.f = c2VarA;
        l3Var.e = b2VarArr[0].d();
        return l3Var;
    }

    public void a(int... iArr) {
        this.e = Integer.TYPE;
        this.f = c2.a(iArr);
    }

    public void a(float... fArr) {
        this.e = Float.TYPE;
        this.f = c2.a(fArr);
    }

    public void a(b2... b2VarArr) {
        int length = b2VarArr.length;
        b2[] b2VarArr2 = new b2[Math.max(length, 2)];
        this.e = b2VarArr[0].d();
        for (int i = 0; i < length; i++) {
            b2VarArr2[i] = b2VarArr[i];
        }
        this.f = new c2(b2VarArr2);
    }

    public void a(Object... objArr) {
        this.e = objArr[0].getClass();
        this.f = c2.a(objArr);
    }

    public final Method a(Class cls, String str, Class cls2) {
        Class<?>[] clsArr;
        String strA = a(str, this.f23077a);
        Method declaredMethod = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(strA, null);
            } catch (NoSuchMethodException e) {
                try {
                    declaredMethod = cls.getDeclaredMethod(strA, null);
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f23077a + ": " + e);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            if (this.e.equals(Float.class)) {
                clsArr = m;
            } else if (this.e.equals(Integer.class)) {
                clsArr = n;
            } else {
                clsArr = this.e.equals(Double.class) ? o : new Class[]{this.e};
            }
            for (Class<?> cls3 : clsArr) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method = cls.getMethod(strA, clsArr2);
                        this.e = cls3;
                        return method;
                    } catch (NoSuchMethodException unused2) {
                        declaredMethod = cls.getDeclaredMethod(strA, clsArr2);
                        declaredMethod.setAccessible(true);
                        this.e = cls3;
                        return declaredMethod;
                    }
                } catch (NoSuchMethodException unused3) {
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f23077a + " with value type " + this.e);
        }
        return declaredMethod;
    }

    public final Method a(Class cls, HashMap<Class, HashMap<String, Method>> map, String str, Class cls2) {
        try {
            this.g.writeLock().lock();
            HashMap<String, Method> map2 = map.get(cls);
            Method methodA = map2 != null ? map2.get(this.f23077a) : null;
            if (methodA == null) {
                methodA = a(cls, str, cls2);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(cls, map2);
                }
                map2.put(this.f23077a, methodA);
            }
            return methodA;
        } finally {
            this.g.writeLock().unlock();
        }
    }

    public final void a(Class cls) {
        this.d = a(cls, q, p3.f, null);
    }

    public final void a(Object obj, b2 b2Var) {
        k3 k3Var = this.b;
        if (k3Var != null) {
            b2Var.a(k3Var.a(obj));
        }
        try {
            if (this.d == null) {
                a((Class) obj.getClass());
            }
            b2Var.a(this.d.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (InvocationTargetException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    @Override // 
    /* JADX INFO: renamed from: a */
    public l3 clone() {
        try {
            l3 l3Var = (l3) super.clone();
            l3Var.f23077a = this.f23077a;
            l3Var.b = this.b;
            l3Var.f = this.f.clone();
            l3Var.i = this.i;
            return l3Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void a(Object obj) {
        k3 k3Var = this.b;
        if (k3Var != null) {
            k3Var.a(obj, b());
        }
        if (this.c != null) {
            try {
                this.h[0] = b();
                this.c.invoke(obj, this.h);
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public void a(s4 s4Var) {
        this.i = s4Var;
        this.f.a(s4Var);
    }

    public void a(float f) {
        this.j = this.f.a(f);
    }

    public void a(String str) {
        this.f23077a = str;
    }

    public void a(k3 k3Var) {
        this.b = k3Var;
    }

    public static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }
}
