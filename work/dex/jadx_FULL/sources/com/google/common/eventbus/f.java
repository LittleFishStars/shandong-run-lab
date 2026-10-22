package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.g;
import com.google.common.base.i;
import com.google.common.base.m;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoadingCache<Class<?>, ImmutableList<Method>> f32037a = CacheBuilder.D().M().b(new a());
    public static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> b = CacheBuilder.D().M().b(new b());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Weak
    public final com.google.common.eventbus.c f6254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConcurrentMap<Class<?>, CopyOnWriteArraySet<d>> f6255a = Maps.V();

    public class a extends CacheLoader<Class<?>, ImmutableList<Method>> {
        @Override // com.google.common.cache.CacheLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableList<Method> load(Class<?> cls) throws Exception {
            return f.e(cls);
        }
    }

    public class b extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
        @Override // com.google.common.cache.CacheLoader
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImmutableSet<Class<?>> load(Class<?> cls) {
            return ImmutableSet.copyOf((Collection) TypeToken.of((Class) cls).getTypes().rawTypes());
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f32038a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<Class<?>> f6256a;

        public c(Method method) {
            this.f32038a = method.getName();
            this.f6256a = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f32038a.equals(cVar.f32038a) && this.f6256a.equals(cVar.f6256a);
        }

        public int hashCode() {
            return g.b(this.f32038a, this.f6256a);
        }
    }

    public f(com.google.common.eventbus.c cVar) {
        this.f6254a = (com.google.common.eventbus.c) i.E(cVar);
    }

    @VisibleForTesting
    public static ImmutableSet<Class<?>> c(Class<?> cls) {
        try {
            return b.getUnchecked(cls);
        } catch (UncheckedExecutionException e) {
            throw m.q(e.getCause());
        }
    }

    public static ImmutableList<Method> d(Class<?> cls) {
        try {
            return f32037a.getUnchecked(cls);
        } catch (UncheckedExecutionException e) {
            m.w(e.getCause());
            throw e;
        }
    }

    public static ImmutableList<Method> e(Class<?> cls) {
        Set setRawTypes = TypeToken.of((Class) cls).getTypes().rawTypes();
        HashMap mapY = Maps.Y();
        Iterator it = setRawTypes.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    i.w(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    i.z(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), com.google.common.primitives.c.f(parameterTypes[0]).getSimpleName());
                    c cVar = new c(method);
                    if (!mapY.containsKey(cVar)) {
                        mapY.put(cVar, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf(mapY.values());
    }

    public final Multimap<Class<?>, d> b(Object obj) {
        HashMultimap hashMultimapCreate = HashMultimap.create();
        UnmodifiableIterator<Method> it = d(obj.getClass()).iterator();
        while (it.hasNext()) {
            Method next = it.next();
            hashMultimapCreate.put(next.getParameterTypes()[0], d.d(this.f6254a, obj, next));
        }
        return hashMultimapCreate;
    }

    public Iterator<d> f(Object obj) {
        ImmutableSet<Class<?>> immutableSetC = c(obj.getClass());
        ArrayList arrayListU = Lists.u(immutableSetC.size());
        UnmodifiableIterator<Class<?>> it = immutableSetC.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet<d> copyOnWriteArraySet = this.f6255a.get(it.next());
            if (copyOnWriteArraySet != null) {
                arrayListU.add(copyOnWriteArraySet.iterator());
            }
        }
        return Iterators.i(arrayListU.iterator());
    }

    @VisibleForTesting
    public Set<d> g(Class<?> cls) {
        return (Set) com.google.common.base.e.a(this.f6255a.get(cls), ImmutableSet.of());
    }

    public void h(Object obj) {
        for (Map.Entry<Class<?>, Collection<d>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<d> value = entry.getValue();
            CopyOnWriteArraySet<d> copyOnWriteArraySet = this.f6255a.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<d> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) com.google.common.base.e.a(this.f6255a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    public void i(Object obj) {
        for (Map.Entry<Class<?>, Collection<d>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<d> value = entry.getValue();
            CopyOnWriteArraySet<d> copyOnWriteArraySet = this.f6255a.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                String strValueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 65);
                sb.append("missing event subscriber for an annotated method. Is ");
                sb.append(strValueOf);
                sb.append(" registered?");
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }
}
