package com.ali.auth.third.core.registry.b;

import com.ali.auth.third.core.registry.ServiceRegistration;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements com.ali.auth.third.core.registry.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Class<?>, List<b>> f23422a = new HashMap();
    private Map<ServiceRegistration, b> b = new HashMap();
    private ReadWriteLock c = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: com.ali.auth.third.core.registry.b.a$a, reason: collision with other inner class name */
    public static class C0117a implements ServiceRegistration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23423a = UUID.randomUUID().toString();
        private com.ali.auth.third.core.registry.a b;
        private Map<String, String> c;

        public C0117a(com.ali.auth.third.core.registry.a aVar, Map<String, String> map) {
            this.b = aVar;
            this.c = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C0117a.class == obj.getClass()) {
                return this.f23423a.equals(((C0117a) obj).f23423a);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f23423a;
            return (str == null ? 0 : str.hashCode()) + 31;
        }

        @Override // com.ali.auth.third.core.registry.ServiceRegistration
        public void setProperties(Map<String, String> map) {
            if (map == null) {
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.c.put(entry.getKey(), entry.getValue());
                }
            }
        }

        @Override // com.ali.auth.third.core.registry.ServiceRegistration
        public void unregister() {
            this.b.a(this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class<?>[] f23424a;
        public Object b;
        public Map<String, String> c;
    }

    @Override // com.ali.auth.third.core.registry.a
    public ServiceRegistration a(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        if (clsArr == null || clsArr.length == 0 || obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        b bVar = new b();
        bVar.b = obj;
        bVar.f23424a = clsArr;
        bVar.c = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    bVar.c.put(entry.getKey(), entry.getValue());
                }
            }
        }
        this.c.writeLock().lock();
        try {
            for (Class<?> cls : clsArr) {
                List<b> arrayList = this.f23422a.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(2);
                    this.f23422a.put(cls, arrayList);
                }
                arrayList.add(bVar);
            }
            C0117a c0117a = new C0117a(this, bVar.c);
            this.b.put(c0117a, bVar);
            return c0117a;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    @Override // com.ali.auth.third.core.registry.a
    public Object a(ServiceRegistration serviceRegistration) {
        if (serviceRegistration == null) {
            return null;
        }
        this.c.writeLock().lock();
        try {
            b bVarRemove = this.b.remove(serviceRegistration);
            if (bVarRemove == null) {
                return null;
            }
            Class<?>[] clsArr = bVarRemove.f23424a;
            if (clsArr != null) {
                for (Class<?> cls : clsArr) {
                    List<b> list = this.f23422a.get(cls);
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == bVarRemove) {
                            it.remove();
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        this.f23422a.remove(cls);
                    }
                }
            }
            return bVarRemove.b;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    @Override // com.ali.auth.third.core.registry.a
    public <T> T a(Class<T> cls, Map<String, String> map) {
        Object obj;
        b next;
        boolean z;
        this.c.readLock().lock();
        try {
            List<b> list = this.f23422a.get(cls);
            if (list != null && list.size() != 0) {
                if (map == null || map.size() == 0) {
                    obj = list.get(0).b;
                } else {
                    Iterator<b> it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = true;
                                    break;
                                }
                                Map.Entry<String, String> next2 = it2.next();
                                String str = next.c.get(next2.getKey());
                                if (str == null || !str.equals(next2.getValue())) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    } while (!z);
                    obj = next.b;
                }
                return cls.cast(obj);
            }
            return null;
        } finally {
            this.c.readLock().unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ali.auth.third.core.registry.a
    public <T> T[] b(Class<T> cls, Map<String, String> map) {
        T[] tArr;
        boolean z;
        this.c.readLock().lock();
        try {
            List<b> list = this.f23422a.get(cls);
            if (list != null && list.size() != 0) {
                if (map != null && map.size() != 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (b bVar : list) {
                        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = true;
                                break;
                            }
                            Map.Entry<String, String> next = it.next();
                            String str = bVar.c.get(next.getKey());
                            if (str == null || !str.equals(next.getValue())) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            arrayList.add(cls.cast(bVar.b));
                        }
                    }
                    tArr = (T[]) arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
                }
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, list.size()));
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    tArr2[i] = cls.cast(list.get(i).b);
                }
                this.c.readLock().unlock();
                return tArr2;
            }
            tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            this.c.readLock().unlock();
            return tArr;
        } catch (Throwable th) {
            this.c.readLock().unlock();
            throw th;
        }
    }
}
