package com.alipay.mobile.jsengine.v8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class V8Value implements Releasable {
    public static final int BOOLEAN = 3;
    public static final int BYTE = 9;
    public static final int DOUBLE = 2;
    public static final int FLOAT_32_ARRAY = 16;
    public static final int FLOAT_64_ARRAY = 2;
    public static final int INTEGER = 1;
    public static final int INT_16_ARRAY = 13;
    public static final int INT_32_ARRAY = 1;
    public static final int INT_8_ARRAY = 9;
    public static final int NULL = 0;
    public static final int STRING = 4;
    public static final int UNDEFINED = 99;
    public static final int UNKNOWN = 0;
    public static final int UNSIGNED_INT_16_ARRAY = 14;
    public static final int UNSIGNED_INT_32_ARRAY = 15;
    public static final int UNSIGNED_INT_8_ARRAY = 11;
    public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    public static final int V8_ARRAY = 5;
    public static final int V8_ARRAY_BUFFER = 10;
    public static final int V8_FUNCTION = 7;
    public static final int V8_OBJECT = 6;
    public static final int V8_TYPED_ARRAY = 8;
    protected V8 b;
    protected long c;
    protected boolean d = true;

    public V8Value() {
    }

    @Deprecated
    public static String getStringRepresentaion(int i) {
        return getStringRepresentation(i);
    }

    public static String getStringRepresentation(int i) {
        if (i == 99) {
            return "Undefined";
        }
        switch (i) {
            case 0:
                return "Null";
            case 1:
                return "Integer";
            case 2:
                return "Double";
            case 3:
                return "Boolean";
            case 4:
                return "String";
            case 5:
                return "V8Array";
            case 6:
                return "V8Object";
            case 7:
                return "V8Function";
            case 8:
                return "V8TypedArray";
            case 9:
                return "Byte";
            case 10:
                return "V8ArrayBuffer";
            case 11:
                return "UInt8Array";
            case 12:
                return "UInt8ClampedArray";
            case 13:
                return "Int16Array";
            case 14:
                return "UInt16Array";
            case 15:
                return "UInt32Array";
            case 16:
                return "Float32Array";
            default:
                throw new IllegalArgumentException("Invalid V8 type: " + i);
        }
    }

    public void addObjectReference(long j) {
        this.c = j;
        try {
            this.b.b(this);
        } catch (Error e) {
            release();
            throw e;
        } catch (RuntimeException e2) {
            release();
            throw e2;
        }
    }

    public void checkReleased() {
        if (this.d) {
            throw new IllegalStateException("Object released");
        }
    }

    public abstract V8Value createTwin();

    public boolean equals(Object obj) {
        return strictEquals(obj);
    }

    public long getHandle() {
        checkReleased();
        return this.c;
    }

    public V8 getRuntime() {
        return this.b;
    }

    public int getV8Type() {
        if (isUndefined()) {
            return 99;
        }
        this.b.a();
        this.b.checkReleased();
        V8 v8 = this.b;
        return v8.getType(v8.getV8RuntimePtr(), this.c);
    }

    public int hashCode() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        return v8.identityHash(v8.getV8RuntimePtr(), getHandle());
    }

    public void initialize(long j, Object obj) {
        long jInitNewV8Object = this.b.initNewV8Object(j);
        this.d = false;
        addObjectReference(jInitNewV8Object);
    }

    public boolean isReleased() {
        return this.d;
    }

    public boolean isUndefined() {
        return false;
    }

    public boolean isWeak() {
        this.b.a();
        this.b.checkReleased();
        V8 v8 = this.b;
        return v8.isWeak(v8.getV8RuntimePtr(), getHandle());
    }

    public boolean jsEquals(Object obj) {
        this.b.a();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v8 = this.b;
        return v8.equals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    @Override // com.alipay.mobile.jsengine.v8.Releasable
    public void release() {
        this.b.a();
        if (this.d) {
            return;
        }
        try {
            this.b.c(this);
        } finally {
            this.d = true;
            V8 v8 = this.b;
            v8.release(v8.getV8RuntimePtr(), this.c);
        }
    }

    public long serialize() {
        return this.b.serialize(this.c);
    }

    public V8Value setWeak() {
        this.b.a();
        this.b.checkReleased();
        this.b.f25359a.put(Long.valueOf(getHandle()), this);
        V8 v8 = this.b;
        v8.setWeak(v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public boolean strictEquals(Object obj) {
        this.b.a();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v8 = this.b;
        return v8.strictEquals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    public V8Value twin() {
        if (isUndefined()) {
            return this;
        }
        this.b.a();
        this.b.checkReleased();
        V8Value v8ValueCreateTwin = createTwin();
        this.b.createTwin(this, v8ValueCreateTwin);
        return v8ValueCreateTwin;
    }

    public V8Value(V8 v8) {
        if (v8 == null) {
            this.b = (V8) this;
        } else {
            this.b = v8;
        }
    }
}
