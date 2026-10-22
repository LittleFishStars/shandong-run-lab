package com.ipd.dsp.internal.components.glide.load.data;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    public static final com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?> b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?>> f38259a = new HashMap();

    public class a implements com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<Object> {
        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public com.ipd.dsp.internal.components.glide.load.data.a<Object> a(@NonNull Object obj) {
            return new C0871b(obj);
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.load.data.b$b, reason: collision with other inner class name */
    public static final class C0871b implements com.ipd.dsp.internal.components.glide.load.data.a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f38260a;

        public C0871b(@NonNull Object obj) {
            this.f38260a = obj;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a
        public void b() {
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a
        @NonNull
        public Object c() {
            return this.f38260a;
        }
    }

    public synchronized void a(@NonNull com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?> interfaceC0870a) {
        this.f38259a.put(interfaceC0870a.a(), interfaceC0870a);
    }

    @NonNull
    public synchronized <T> com.ipd.dsp.internal.components.glide.load.data.a<T> a(@NonNull T t) {
        com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?> interfaceC0870a;
        m.a(t);
        interfaceC0870a = this.f38259a.get(t.getClass());
        if (interfaceC0870a == null) {
            for (com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?> interfaceC0870a2 : this.f38259a.values()) {
                if (interfaceC0870a2.a().isAssignableFrom(t.getClass())) {
                    interfaceC0870a = interfaceC0870a2;
                    break;
                }
            }
        }
        if (interfaceC0870a == null) {
            interfaceC0870a = b;
        }
        return (com.ipd.dsp.internal.components.glide.load.data.a<T>) interfaceC0870a.a(t);
    }
}
