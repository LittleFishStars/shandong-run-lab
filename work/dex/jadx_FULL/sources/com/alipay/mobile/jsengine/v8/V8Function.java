package com.alipay.mobile.jsengine.v8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Function extends V8Object {
    public V8Function(V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        this.b.a();
        checkReleased();
        this.b.a((V8Value) v8Object);
        this.b.a((V8Value) v8Array);
        if (v8Object == null) {
            v8Object = this.b;
        }
        long handle = v8Array == null ? 0L : v8Array.getHandle();
        if (v8Object.isUndefined()) {
            v8Object = this.b;
        }
        long handle2 = v8Object.getHandle();
        V8 v8 = this.b;
        return v8.executeFunction(v8.getV8RuntimePtr(), handle2, this.c, handle);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Value createTwin() {
        return new V8Function(this.b);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        if (obj == null) {
            super.initialize(j, null);
            return;
        }
        long[] jArrInitNewV8Function = this.b.initNewV8Function(j);
        this.b.a((JavaCallback) obj, jArrInitNewV8Function[1]);
        this.d = false;
        addObjectReference(jArrInitNewV8Function[0]);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object
    public String toString() {
        return (this.d || this.b.isReleased()) ? "[Function released]" : super.toString();
    }

    public V8Function(V8 v8) {
        this(v8, null);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Function twin() {
        return (V8Function) super.twin();
    }
}
