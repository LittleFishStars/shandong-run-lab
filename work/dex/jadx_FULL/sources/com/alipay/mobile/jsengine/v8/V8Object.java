package com.alipay.mobile.jsengine.v8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Object extends V8Value {

    public static class Undefined extends V8Object {
        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public double executeDoubleFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public Object executeFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int executeIntegerFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public Object executeJSFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String executeStringFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public void executeVoidFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String[] getKeys() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object getObject(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String getString(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int getType(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public int hashCode() {
            return 919;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean isReleased() {
            return false;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value
        public boolean isUndefined() {
            return true;
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Value, com.alipay.mobile.jsengine.v8.Releasable
        public void release() {
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }
    }

    public V8Object(V8 v8) {
        this(v8, null);
    }

    private void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public V8Object add(String str, int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.add(v8.getV8RuntimePtr(), this.c, str, i);
        return this;
    }

    public V8Object addNull(String str) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addNull(v8.getV8RuntimePtr(), this.c, str);
        return this;
    }

    public V8Object addUndefined(String str) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addUndefined(v8.getV8RuntimePtr(), this.c, str);
        return this;
    }

    public boolean contains(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.contains(v8.getV8RuntimePtr(), this.c, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8Value createTwin() {
        return new V8Object(this.b);
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        Object objExecuteFunction = v8.executeFunction(v8.getV8RuntimePtr(), 5, this.c, str, handle);
        if (objExecuteFunction instanceof V8Array) {
            return (V8Array) objExecuteFunction;
        }
        throw new V8ResultUndefined();
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        return v8.executeBooleanFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        return v8.executeDoubleFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public Object executeFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        return v8.executeFunction(v8.getV8RuntimePtr(), 0, this.c, str, handle);
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        return v8.executeIntegerFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, null);
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        Object objExecuteFunction = v8.executeFunction(v8.getV8RuntimePtr(), 6, this.c, str, handle);
        if (objExecuteFunction instanceof V8Object) {
            return (V8Object) objExecuteFunction;
        }
        throw new V8ResultUndefined();
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        return v8.executeStringFunction(v8.getV8RuntimePtr(), getHandle(), str, handle);
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Array);
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        V8 v8 = this.b;
        v8.executeVoidFunction(v8.getV8RuntimePtr(), this.c, str, handle);
    }

    public Object get(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.get(v8.getV8RuntimePtr(), 6, this.c, str);
    }

    public V8Array getArray(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        Object obj = v8.get(v8.getV8RuntimePtr(), 5, this.c, str);
        if (obj == null || (obj instanceof V8Array)) {
            return (V8Array) obj;
        }
        throw new V8ResultUndefined();
    }

    public boolean getBoolean(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.getBoolean(v8.getV8RuntimePtr(), this.c, str);
    }

    public double getDouble(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.getDouble(v8.getV8RuntimePtr(), this.c, str);
    }

    public int getInteger(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.getInteger(v8.getV8RuntimePtr(), this.c, str);
    }

    public String[] getKeys() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.getKeys(v8.getV8RuntimePtr(), this.c);
    }

    public V8Object getObject(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        Object obj = v8.get(v8.getV8RuntimePtr(), 6, this.c, str);
        if (obj == null || (obj instanceof V8Object)) {
            return (V8Object) obj;
        }
        throw new V8ResultUndefined();
    }

    public String getString(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.getString(v8.getV8RuntimePtr(), this.c, str);
    }

    public int getType(String str) {
        this.b.a();
        checkReleased();
        a(str);
        V8 v8 = this.b;
        return v8.getType(v8.getV8RuntimePtr(), this.c, str);
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        this.b.a();
        checkReleased();
        this.b.a(javaCallback, getHandle(), str);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.setPrototype(v8.getV8RuntimePtr(), this.c, v8Object.getHandle());
        return this;
    }

    public String toString() {
        if (isReleased() || this.b.isReleased()) {
            return "[Object released]";
        }
        this.b.a();
        V8 v8 = this.b;
        return v8.toString(v8.getV8RuntimePtr(), getHandle());
    }

    public V8Object(V8 v8, Object obj) {
        super(v8);
        if (v8 != null) {
            this.b.a();
            initialize(this.b.getV8RuntimePtr(), obj);
        }
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, null);
        }
        V8Array v8Array = new V8Array(this.b.getRuntime());
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    v8Array.pushNull();
                } else if (obj instanceof V8Value) {
                    v8Array.push((V8Value) obj);
                } else if (obj instanceof Integer) {
                    v8Array.push((Integer) obj);
                } else if (obj instanceof Double) {
                    v8Array.push((Double) obj);
                } else if (obj instanceof Long) {
                    v8Array.push(((Long) obj).doubleValue());
                } else if (obj instanceof Float) {
                    v8Array.push(((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    v8Array.push((Boolean) obj);
                } else {
                    if (!(obj instanceof String)) {
                        throw new IllegalArgumentException("Unsupported Object of type: " + obj.getClass());
                    }
                    v8Array.push((String) obj);
                }
            }
            Object objExecuteFunction = executeFunction(str, v8Array);
            v8Array.release();
            return objExecuteFunction;
        } catch (Throwable th) {
            v8Array.release();
            throw th;
        }
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8Object twin() {
        return (V8Object) super.twin();
    }

    public V8Object add(String str, boolean z) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.add(v8.getV8RuntimePtr(), this.c, str, z);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        this.b.a();
        checkReleased();
        this.b.a(javaVoidCallback, getHandle(), str);
        return this;
    }

    public V8Object() {
    }

    public V8Object add(String str, double d) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.add(v8.getV8RuntimePtr(), this.c, str, d);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        return registerJavaMethod(obj, str, str2, clsArr, false);
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        this.b.a();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.b.a(obj, method, getHandle(), str2, z);
            return this;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public V8Object add(String str, String str2) {
        this.b.a();
        checkReleased();
        if (str2 == null) {
            V8 v8 = this.b;
            v8.addNull(v8.getV8RuntimePtr(), this.c, str);
        } else if (str2.equals(V8.getUndefined())) {
            V8 v9 = this.b;
            v9.addUndefined(v9.getV8RuntimePtr(), this.c, str);
        } else {
            V8 v10 = this.b;
            v10.add(v10.getV8RuntimePtr(), this.c, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        this.b.a();
        checkReleased();
        this.b.a(v8Value);
        if (v8Value == null) {
            V8 v8 = this.b;
            v8.addNull(v8.getV8RuntimePtr(), this.c, str);
        } else if (v8Value.equals(V8.getUndefined())) {
            V8 v9 = this.b;
            v9.addUndefined(v9.getV8RuntimePtr(), this.c, str);
        } else {
            V8 v10 = this.b;
            v10.addObject(v10.getV8RuntimePtr(), this.c, str, v8Value.getHandle());
        }
        return this;
    }
}
