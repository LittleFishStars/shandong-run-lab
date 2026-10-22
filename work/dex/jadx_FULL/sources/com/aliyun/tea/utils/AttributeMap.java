package com.aliyun.tea.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AttributeMap implements AutoCloseable {
    private final Map<Key<?>, Object> attributes;

    private AttributeMap(Map<? extends Key<?>, ?> map) {
        this.attributes = new HashMap(map);
    }

    public static AttributeMap empty() {
        return new AttributeMap(new HashMap());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator<Object> it = this.attributes.values().iterator();
        while (it.hasNext()) {
            IOUtils.closeIfCloseable(it.next());
        }
        this.attributes.clear();
    }

    public <T> boolean containsKey(Key<T> key) {
        return this.attributes.containsKey(key);
    }

    public AttributeMap copy() {
        HashMap map = new HashMap();
        for (Map.Entry<Key<?>, Object> entry : this.attributes.entrySet()) {
            entry.getKey().validateValue(entry.getValue());
            map.put(entry.getKey(), entry.getValue());
        }
        return new AttributeMap(map);
    }

    public <T> T get(Key<T> key) {
        Validate.notNull(key, "Key to retrieve must not be null.", new Object[0]);
        return key.convertValue(this.attributes.get(key));
    }

    public <T> AttributeMap put(Key<T> key, T t) {
        Validate.notNull(key, "Key to set must not be null.", new Object[0]);
        this.attributes.put(key, t);
        return this;
    }

    public <T> AttributeMap putIfAbsent(Key<T> key, T t) {
        Validate.notNull(key, "Key to set must not be null.", new Object[0]);
        if (this.attributes.get(key) == null) {
            this.attributes.put(key, t);
        }
        return this;
    }

    public int size() {
        return this.attributes.size();
    }

    public static abstract class Key<T> {
        private final Class<?> valueType;

        public static class UnsafeValueType {
            private final Class<?> valueType;

            public UnsafeValueType(Class<?> cls) {
                this.valueType = cls;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Key(Class<T> cls) {
            this.valueType = cls;
        }

        public final T convertValue(Object obj) {
            validateValue(obj);
            return (T) this.valueType.cast(obj);
        }

        public final void validateValue(Object obj) {
            if (obj != null) {
                Validate.isAssignableFrom(this.valueType, obj.getClass(), "Invalid option: %s. Required value of type %s, but was %s.", this, this.valueType, obj.getClass());
            }
        }

        public Key(UnsafeValueType unsafeValueType) {
            this.valueType = unsafeValueType.valueType;
        }
    }
}
