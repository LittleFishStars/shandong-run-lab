package com.hailiang.advlib.common;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f32558a;
    private static Map<String, Class> b = new HashMap();

    @Keep
    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f32559a;
        final b b;

        public a(b bVar, String str) {
            this.b = bVar;
            this.f32559a = str;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Method declaredMethod = ((Class) b.b.get(this.f32559a)).getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (Modifier.isPrivate(declaredMethod.getModifiers())) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod.invoke(null, objArr);
            } catch (Error | RuntimeException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.hailiang.advlib.common.b$b, reason: collision with other inner class name */
    @Keep
    public class C0766b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f32560a;
        final b b;

        public C0766b(b bVar, Object obj) {
            this.b = bVar;
            this.f32560a = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                Method method2 = this.f32560a.getClass().getMethod(method.getName(), method.getParameterTypes());
                return method2.invoke(Modifier.isStatic(method2.getModifiers()) ? null : this.f32560a, objArr);
            } catch (Error | RuntimeException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private b() {
    }

    private <T> T a(Class<T> cls, String str) {
        if (b.get(str) == null) {
            return null;
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this, str));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004c A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:7:0x0014, B:9:0x0017, B:13:0x0021, B:26:0x0049, B:16:0x002a, B:17:0x002f, B:19:0x0032, B:25:0x0044, B:22:0x003e, B:27:0x004c), top: B:37:0x0014 }] */
    private <T> T a(boolean z, Class<T> cls, Object... objArr) {
        boolean z2;
        Object objNewInstance;
        Class cls2 = b.get(cls.getName());
        T t = null;
        if (cls2 == null) {
            return null;
        }
        if (objArr == null) {
            objNewInstance = cls2.newInstance();
            t = (T) objNewInstance;
            break;
        }
        try {
            if (objArr.length > 0) {
                for (Constructor<?> constructor : cls2.getConstructors()) {
                    if (objArr.length == constructor.getParameterTypes().length) {
                        Class<?>[] parameterTypes = constructor.getParameterTypes();
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            }
                            if (!parameterTypes[i].isInstance(objArr[i])) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        if (z2) {
                            objNewInstance = constructor.newInstance(objArr);
                        }
                    }
                }
            } else {
                objNewInstance = cls2.newInstance();
            }
            t = (T) objNewInstance;
            break;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return (t == null || z) ? t : (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0766b(this, t));
    }

    public static b c() {
        if (f32558a == null) {
            synchronized (b.class) {
                try {
                    if (f32558a == null) {
                        f32558a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f32558a;
    }

    public <T> T a(Class<T> cls) {
        return (T) a(cls, cls.getName());
    }

    public <T> T a(Class<T> cls, Object... objArr) {
        return (T) a(false, cls, objArr);
    }

    public void a(Class cls, Class cls2) {
        b.put(cls.getName(), cls2);
    }

    public <T> Class<T> b(Class cls) {
        return b.get(cls.getName());
    }

    public <T> T b(Class<T> cls, Object... objArr) {
        return (T) a(true, cls, objArr);
    }

    public void b() {
        b.clear();
    }
}
