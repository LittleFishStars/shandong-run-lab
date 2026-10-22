package com.blankj.utilcode.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class BusUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f28120a = "nULl";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1243a = "BusUtils";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, List<b>> f1244a;
    public final Map<String, Set<Object>> b;
    public final Map<String, List<String>> c;
    public final Map<String, Map<String, Object>> d;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface Bus {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f28121a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f1246a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1247a;
        public final /* synthetic */ Object b;

        public a(Object obj, Object obj2, b bVar, boolean z) {
            this.f1246a = obj;
            this.b = obj2;
            this.f28121a = bVar;
            this.f1247a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusUtils.this.t(this.f1246a, this.b, this.f28121a, this.f1247a);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28122a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1248a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Method f1249a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<String> f1250a = new CopyOnWriteArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1251a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public b(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
            this.f1248a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f1251a = z;
            this.f = str6;
            this.f28122a = i;
        }

        public final String a() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("#");
            sb.append(this.c);
            if ("".equals(this.d)) {
                str = "()";
            } else {
                str = "(" + this.d + " " + this.e + ")";
            }
            sb.append(str);
            return sb.toString();
        }

        public String toString() {
            return "BusInfo { tag : " + this.f1248a + ", desc: " + a() + ", sticky: " + this.f1251a + ", threadMode: " + this.f + ", method: " + this.f1249a + ", priority: " + this.f28122a + " }";
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BusUtils f28123a = new BusUtils();
    }

    public BusUtils() {
        this.f1244a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        g();
    }

    public static void A(String str) {
        e().B(str);
    }

    public static String C() {
        return e().toString();
    }

    public static void D(@Nullable Object obj) {
        e().E(obj);
    }

    public static BusUtils e() {
        return c.f28123a;
    }

    public static void m(@NonNull String str) {
        n(str, f28120a);
    }

    public static void n(@NonNull String str, @NonNull Object obj) {
        e().o(str, obj);
    }

    public static void q(@NonNull String str) {
        r(str, f28120a);
    }

    public static void r(@NonNull String str, Object obj) {
        e().s(str, obj);
    }

    public static void v(@Nullable Object obj) {
        e().z(obj);
    }

    public static void y(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        e().x(str, str2, str3, str4, str5, z, str6, i);
    }

    public final void B(String str) {
        List<b> list = this.f1244a.get(str);
        if (list == null) {
            Log.e(f1243a, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (b bVar : list) {
            if (bVar.f1251a) {
                synchronized (this.d) {
                    Map<String, Object> map = this.d.get(bVar.b);
                    if (map != null && map.containsKey(str)) {
                        map.remove(str);
                    }
                    return;
                }
            }
        }
    }

    public final void E(Object obj) {
        if (obj == null) {
            return;
        }
        String name = obj.getClass().getName();
        synchronized (this.b) {
            Set<Object> set = this.b.get(name);
            if (set != null && set.contains(obj)) {
                set.remove(obj);
                return;
            }
            Log.e(f1243a, "The bus of <" + obj + "> was not registered before.");
        }
    }

    public final void b(Object obj, String str, Object obj2) {
        List<b> list = this.f1244a.get(str);
        if (list == null) {
            Log.e(f1243a, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (b bVar : list) {
            if (bVar.f1250a.contains(obj.getClass().getName()) && bVar.f1251a) {
                synchronized (this.d) {
                    Map<String, Object> map = this.d.get(bVar.b);
                    if (map != null && map.containsKey(str)) {
                        i(obj, obj2, bVar, true);
                    }
                }
            }
        }
    }

    public final void c(Object obj) {
        Map<String, Object> map = this.d.get(obj.getClass().getName());
        if (map == null) {
            return;
        }
        synchronized (this.d) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(obj, entry.getKey(), entry.getValue());
            }
        }
    }

    public final Class d(String str) throws ClassNotFoundException {
        str.hashCode();
        switch (str) {
            case "double":
                return Double.TYPE;
            case "int":
                return Integer.TYPE;
            case "byte":
                return Byte.TYPE;
            case "char":
                return Character.TYPE;
            case "long":
                return Long.TYPE;
            case "boolean":
                return Boolean.TYPE;
            case "float":
                return Float.TYPE;
            case "short":
                return Short.TYPE;
            default:
                return Class.forName(str);
        }
    }

    public final Method f(b bVar) {
        try {
            return "".equals(bVar.d) ? Class.forName(bVar.b).getDeclaredMethod(bVar.c, new Class[0]) : Class.forName(bVar.b).getDeclaredMethod(bVar.c, d(bVar.d));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void g() {
    }

    public final void h(Object obj, b bVar, boolean z) {
        i(null, obj, bVar, z);
    }

    public final void i(Object obj, Object obj2, b bVar, boolean z) {
        if (bVar.f1249a == null) {
            Method methodF = f(bVar);
            if (methodF == null) {
                return;
            } else {
                bVar.f1249a = methodF;
            }
        }
        l(obj, obj2, bVar, z);
    }

    public final void j(Object obj, b bVar, Set<Object> set) {
        try {
            if (obj == f28120a) {
                Iterator<Object> it = set.iterator();
                while (it.hasNext()) {
                    bVar.f1249a.invoke(it.next(), new Object[0]);
                }
            } else {
                Iterator<Object> it2 = set.iterator();
                while (it2.hasNext()) {
                    bVar.f1249a.invoke(it2.next(), obj);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    public final void k(Object obj, b bVar, boolean z) {
        l(null, obj, bVar, z);
    }

    public final void l(Object obj, Object obj2, b bVar, boolean z) {
        a aVar = new a(obj, obj2, bVar, z);
        String str = bVar.f;
        str.hashCode();
        switch (str) {
            case "SINGLE":
                ThreadUtils.p0().execute(aVar);
                break;
            case "IO":
                ThreadUtils.k0().execute(aVar);
                break;
            case "CPU":
                ThreadUtils.f0().execute(aVar);
                break;
            case "MAIN":
                ThreadUtils.s0(aVar);
                break;
            case "CACHED":
                ThreadUtils.d0().execute(aVar);
                break;
            default:
                aVar.run();
                break;
        }
    }

    public final void o(String str, Object obj) {
        p(str, obj, false);
    }

    public final void p(String str, Object obj, boolean z) {
        List<b> list = this.f1244a.get(str);
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                h(obj, it.next(), z);
            }
            return;
        }
        Log.e(f1243a, "The bus of tag <" + str + "> is not exists.");
        if (this.f1244a.isEmpty()) {
            Log.e(f1243a, "Please check whether the bus plugin is applied.");
        }
    }

    public final void s(String str, Object obj) {
        List<b> list = this.f1244a.get(str);
        if (list == null) {
            Log.e(f1243a, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (b bVar : list) {
            if (bVar.f1251a) {
                synchronized (this.d) {
                    Map<String, Object> concurrentHashMap = this.d.get(bVar.b);
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap<>();
                        this.d.put(bVar.b, concurrentHashMap);
                    }
                    concurrentHashMap.put(str, obj);
                }
                h(obj, bVar, true);
            } else {
                h(obj, bVar, false);
            }
        }
    }

    public final void t(Object obj, Object obj2, b bVar, boolean z) {
        Set<Object> hashSet = new HashSet<>();
        if (obj == null) {
            Iterator<String> it = bVar.f1250a.iterator();
            while (it.hasNext()) {
                Set<Object> set = this.b.get(it.next());
                if (set != null && !set.isEmpty()) {
                    hashSet.addAll(set);
                }
            }
            if (hashSet.size() == 0) {
                if (z) {
                    return;
                }
                Log.e(f1243a, "The " + bVar + " was not registered before.");
                return;
            }
        } else {
            hashSet.add(obj);
        }
        j(obj2, bVar, hashSet);
    }

    public String toString() {
        return "BusUtils: " + this.f1244a;
    }

    public final void u(Class<?> cls, String str) {
        if (this.c.get(str) == null) {
            synchronized (this.c) {
                if (this.c.get(str) == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Map.Entry<String, List<b>> entry : this.f1244a.entrySet()) {
                        for (b bVar : entry.getValue()) {
                            try {
                                if (Class.forName(bVar.b).isAssignableFrom(cls)) {
                                    copyOnWriteArrayList.add(entry.getKey());
                                    bVar.f1250a.add(str);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    this.c.put(str, copyOnWriteArrayList);
                }
            }
        }
    }

    public final void w(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        x(str, str2, str3, str4, str5, z, str6, 0);
    }

    public final void x(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        List<b> copyOnWriteArrayList = this.f1244a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f1244a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(new b(str, str2, str3, str4, str5, z, str6, i));
    }

    public final void z(@Nullable Object obj) {
        boolean z;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        String name = cls.getName();
        synchronized (this.b) {
            Set<Object> copyOnWriteArraySet = this.b.get(name);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                this.b.put(name, copyOnWriteArraySet);
                z = true;
            } else {
                z = false;
            }
            if (!copyOnWriteArraySet.contains(obj)) {
                copyOnWriteArraySet.add(obj);
                if (z) {
                    u(cls, name);
                }
                c(obj);
                return;
            }
            Log.w(f1243a, "The bus of <" + obj + "> already registered.");
        }
    }
}
