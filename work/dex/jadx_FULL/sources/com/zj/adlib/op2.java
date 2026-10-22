package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class op2<T> implements Provider<T>, Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f43799a = false;
    public static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Object f18690a = b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Provider<T> f18691a;

    public op2(Provider<T> provider) {
        this.f18691a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> a(P p) {
        return p instanceof Lazy ? (Lazy) p : new op2((Provider) xw6.b(p));
    }

    public static <P extends Provider<T>, T> Provider<T> b(P p) {
        xw6.b(p);
        return p instanceof op2 ? p : new op2(p);
    }

    public static Object c(Object obj, Object obj2) {
        if (!((obj == b || (obj instanceof tl5)) ? false : true) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // com.google.android.datatransport.runtime.dagger.Lazy
    public T get() {
        Object obj = (T) this.f18690a;
        Object obj2 = b;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f18690a;
                if (obj == obj2) {
                    obj = (T) this.f18691a.get();
                    this.f18690a = c(this.f18690a, obj);
                    this.f18691a = null;
                }
            }
        }
        return (T) obj;
    }
}
