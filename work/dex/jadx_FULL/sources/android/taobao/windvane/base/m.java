package android.taobao.windvane.base;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class m {
    private static m c = null;
    private static final String d = "ServiceManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Class<?>, Class<?>> f21202a = new ConcurrentHashMap();
    private Map<Class<?>, Object> b = new ConcurrentHashMap();

    private m() {
    }

    public static m a() {
        if (c == null) {
            synchronized (m.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }

    @Nullable
    public <T> T b(Class<T> cls) {
        return (T) a((Class) cls, true);
    }

    public <T> boolean a(Class<T> cls, Class<? extends T> cls2) {
        if (cls != null && cls2 != null) {
            this.f21202a.put(cls, cls2);
            return true;
        }
        Log.e(d, "register failed, name or service is null.");
        return false;
    }

    public boolean a(Class<?> cls, Object obj) {
        if (cls != null && obj != null) {
            this.b.put(cls, obj);
            return true;
        }
        Log.e(d, "register failed, name or service is null.");
        return false;
    }

    public boolean a(Class<?> cls) {
        if (cls == null) {
            Log.e(d, "UnReister on a null service failed");
            return false;
        }
        if (this.b.remove(cls) == null) {
            Log.e(d, "no match service=[" + cls.getSimpleName() + "] to remove");
            return false;
        }
        Log.i(d, "remove service=[" + cls.getSimpleName() + "] success");
        return true;
    }

    public <T> T a(Class<T> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        T t = (T) this.b.get(cls);
        if (t != null) {
            return t;
        }
        Class<?> cls2 = this.f21202a.get(cls);
        if (cls2 == null && (cls2 = this.f21202a.get(cls)) == null) {
            Log.e(d, cls + " service not registered.");
            return null;
        }
        try {
            T t2 = (T) cls2.newInstance();
            if (z) {
                this.b.put((Class<?>) cls, t2);
            }
            return t2;
        } catch (IllegalAccessException e) {
            Log.e(d, "getService failed.", e);
            return null;
        } catch (InstantiationException e2) {
            Log.e(d, "getService failed.", e2);
            return null;
        }
    }
}
