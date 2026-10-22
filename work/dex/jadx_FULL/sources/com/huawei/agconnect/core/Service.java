package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f37376a;
    private final Class<?> b;
    private final Object c;
    private boolean d;
    private boolean e;
    private boolean f;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Class<?> f37377a;
        Class<?> b;
        Object c;
        private boolean d;
        private boolean e;
        private boolean f;

        public Service build() {
            Class<?> cls = this.f37377a;
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            }
            Class<?> cls2 = this.b;
            if (cls2 == null) {
                Object obj = this.c;
                if (obj == null) {
                    throw new IllegalArgumentException("the clazz or object parameter must set one");
                }
                Service service = new Service(cls, obj);
                service.d = this.d;
                return service;
            }
            if (cls2.isInterface() || !Modifier.isPublic(this.b.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
            }
            Service service2 = new Service((Class) this.f37377a, (Class) this.b);
            service2.d = this.d;
            service2.e = this.e;
            service2.f = this.f;
            return service2;
        }

        public Builder isAutoCreated(boolean z) {
            this.f = z;
            return this;
        }

        public Builder isSharedInstance(boolean z) {
            this.e = z;
            return this;
        }

        public Builder isSingleton(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f37377a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.c = obj;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f37376a = cls;
        this.b = cls2;
        this.c = null;
    }

    private Service(Class<?> cls, Object obj) {
        this.f37376a = cls;
        this.b = null;
        this.c = obj;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.c;
    }

    public Class<?> getInterface() {
        return this.f37376a;
    }

    public Class<?> getType() {
        return this.b;
    }

    public boolean isAutoCreated() {
        return this.f;
    }

    public boolean isSharedInstance() {
        return this.e;
    }

    public boolean isSingleton() {
        return this.d;
    }
}
