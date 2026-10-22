package com.alipay.mobile.jsengine.v8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Array extends V8Object {

    public static class Undefined extends V8Array {
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
        public int executeIntegerFunction(String str, V8Array v8Array) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public Object get(int i) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public boolean[] getBooleans(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public byte getByte(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public byte[] getBytes(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public double[] getDoubles(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int[] getIntegers(int i, int i2) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public String[] getStrings(int i, int i2) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int length() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array, com.alipay.mobile.jsengine.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array getArray(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public boolean getBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getBooleans(int i, int i2, boolean[] zArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getBytes(int i, int i2, byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public double getDouble(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getDoubles(int i, int i2, double[] dArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getInteger(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getIntegers(int i, int i2, int[] iArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Object getObject(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public String getString(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getStrings(int i, int i2, String[] strArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType() {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(double d) {
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

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public int getType(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array, com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
        public Undefined twin() {
            return (Undefined) super.twin();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.alipay.mobile.jsengine.v8.V8Array
        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }
    }

    public V8Array() {
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Value createTwin() {
        return new V8Array(this.b);
    }

    public Object get(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGet(v8.getV8RuntimePtr(), 6, this.c, i);
    }

    public V8Array getArray(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        Object objArrayGet = v8.arrayGet(v8.getV8RuntimePtr(), 5, this.c, i);
        if (objArrayGet == null || (objArrayGet instanceof V8Array)) {
            return (V8Array) objArrayGet;
        }
        throw new V8ResultUndefined();
    }

    public boolean getBoolean(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetBoolean(v8.getV8RuntimePtr(), getHandle(), i);
    }

    public boolean[] getBooleans(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetBooleans(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public byte getByte(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetByte(v8.getV8RuntimePtr(), getHandle(), i);
    }

    public byte[] getBytes(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetBytes(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public double getDouble(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetDouble(v8.getV8RuntimePtr(), getHandle(), i);
    }

    public double[] getDoubles(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetDoubles(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getInteger(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetInteger(v8.getV8RuntimePtr(), getHandle(), i);
    }

    public int[] getIntegers(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetIntegers(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public V8Object getObject(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        Object objArrayGet = v8.arrayGet(v8.getV8RuntimePtr(), 6, this.c, i);
        if (objArrayGet == null || (objArrayGet instanceof V8Object)) {
            return (V8Object) objArrayGet;
        }
        throw new V8ResultUndefined();
    }

    public String getString(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetString(v8.getV8RuntimePtr(), getHandle(), i);
    }

    public String[] getStrings(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetStrings(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public int getType(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.getType(v8.getV8RuntimePtr(), getHandle(), i);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        long jInitNewV8Array = this.b.initNewV8Array(j);
        this.d = false;
        addObjectReference(jInitNewV8Array);
    }

    public int length() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.arrayGetSize(v8.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(int i) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addArrayIntItem(v8.getV8RuntimePtr(), getHandle(), i);
        return this;
    }

    public V8Array pushNull() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addArrayUndefinedItem(v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object
    public String toString() {
        return (this.d || this.b.isReleased()) ? "[Array released]" : super.toString();
    }

    public V8Array(V8 v8) {
        super(v8);
        v8.a();
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Array twin() {
        return (V8Array) super.twin();
    }

    public V8Array(V8 v8, Object obj) {
        super(v8, obj);
    }

    public int getBooleans(int i, int i2, boolean[] zArr) {
        this.b.a();
        checkReleased();
        if (i2 <= zArr.length) {
            V8 v8 = this.b;
            return v8.arrayGetBooleans(v8.getV8RuntimePtr(), getHandle(), i, i2, zArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getBytes(int i, int i2, byte[] bArr) {
        this.b.a();
        checkReleased();
        if (i2 <= bArr.length) {
            V8 v8 = this.b;
            return v8.arrayGetBytes(v8.getV8RuntimePtr(), getHandle(), i, i2, bArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getDoubles(int i, int i2, double[] dArr) {
        this.b.a();
        checkReleased();
        if (i2 <= dArr.length) {
            V8 v8 = this.b;
            return v8.arrayGetDoubles(v8.getV8RuntimePtr(), getHandle(), i, i2, dArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getIntegers(int i, int i2, int[] iArr) {
        this.b.a();
        checkReleased();
        if (i2 <= iArr.length) {
            V8 v8 = this.b;
            return v8.arrayGetIntegers(v8.getV8RuntimePtr(), getHandle(), i, i2, iArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getStrings(int i, int i2, String[] strArr) {
        this.b.a();
        checkReleased();
        if (i2 <= strArr.length) {
            V8 v8 = this.b;
            return v8.arrayGetStrings(v8.getV8RuntimePtr(), getHandle(), i, i2, strArr);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getType() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.getArrayType(v8.getV8RuntimePtr(), getHandle());
    }

    public V8Array push(boolean z) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addArrayBooleanItem(v8.getV8RuntimePtr(), getHandle(), z);
        return this;
    }

    public int getType(int i, int i2) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.getType(v8.getV8RuntimePtr(), getHandle(), i, i2);
    }

    public V8Array push(double d) {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.addArrayDoubleItem(v8.getV8RuntimePtr(), getHandle(), d);
        return this;
    }

    public V8Array push(String str) {
        this.b.a();
        checkReleased();
        if (str == null) {
            V8 v8 = this.b;
            v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            V8 v9 = this.b;
            v9.addArrayUndefinedItem(v9.getV8RuntimePtr(), getHandle());
        } else {
            V8 v10 = this.b;
            v10.addArrayStringItem(v10.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.b.a();
        checkReleased();
        this.b.a(v8Value);
        if (v8Value == null) {
            V8 v8 = this.b;
            v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            V8 v9 = this.b;
            v9.addArrayUndefinedItem(v9.getV8RuntimePtr(), getHandle());
        } else {
            V8 v10 = this.b;
            v10.addArrayObjectItem(v10.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        this.b.a();
        checkReleased();
        if (obj instanceof V8Value) {
            this.b.a((V8Value) obj);
        }
        if (obj == null) {
            V8 v8 = this.b;
            v8.addArrayNullItem(v8.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            V8 v9 = this.b;
            v9.addArrayUndefinedItem(v9.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            V8 v10 = this.b;
            v10.addArrayDoubleItem(v10.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            V8 v11 = this.b;
            v11.addArrayIntItem(v11.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            V8 v12 = this.b;
            v12.addArrayDoubleItem(v12.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            V8 v13 = this.b;
            v13.addArrayDoubleItem(v13.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            V8 v14 = this.b;
            v14.addArrayBooleanItem(v14.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            V8 v15 = this.b;
            v15.addArrayStringItem(v15.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (obj instanceof V8Value) {
            V8 v16 = this.b;
            v16.addArrayObjectItem(v16.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }
}
