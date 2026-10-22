package com.zj.adlib;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
public final class q84<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableMap<TypeToken<? extends B>, B> f44150a;

    @Beta
    public static final class b<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap.b<TypeToken<? extends B>, B> f44151a;

        public q84<B> a() {
            return new q84<>(this.f44151a.a());
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> b(TypeToken<T> typeToken, T t) {
            this.f44151a.f(typeToken.rejectTypeVariables(), t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> c(Class<T> cls, T t) {
            this.f44151a.f(TypeToken.of((Class) cls), t);
            return this;
        }

        public b() {
            this.f44151a = ImmutableMap.builder();
        }
    }

    public static <B> b<B> o() {
        return new b<>();
    }

    public static <B> q84<B> t() {
        return new q84<>(ImmutableMap.of());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T a(TypeToken<T> typeToken) {
        return (T) x(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) x(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public <T extends B> T k0(TypeToken<T> typeToken, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public B put(TypeToken<? extends B> typeToken, B b2) {
        throw new UnsupportedOperationException();
    }

    public final <T extends B> T x(TypeToken<T> typeToken) {
        return this.f44150a.get(typeToken);
    }

    public q84(ImmutableMap<TypeToken<? extends B>, B> immutableMap) {
        this.f44150a = immutableMap;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f44150a;
    }
}
