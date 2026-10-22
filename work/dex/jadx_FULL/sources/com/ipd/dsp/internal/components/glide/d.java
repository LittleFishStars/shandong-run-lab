package com.ipd.dsp.internal.components.glide;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, b> f38245a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, b> f38246a = new HashMap();

        public a a(b bVar, boolean z) {
            if (z) {
                a(bVar);
                return this;
            }
            this.f38246a.remove(bVar.getClass());
            return this;
        }

        public a a(b bVar) {
            this.f38246a.put(bVar.getClass(), bVar);
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public interface b {
    }

    public d(a aVar) {
        this.f38245a = Collections.unmodifiableMap(new HashMap(aVar.f38246a));
    }

    @Nullable
    public <T extends b> T a(Class<T> cls) {
        return (T) this.f38245a.get(cls);
    }

    public boolean b(Class<? extends b> cls) {
        return this.f38245a.containsKey(cls);
    }
}
