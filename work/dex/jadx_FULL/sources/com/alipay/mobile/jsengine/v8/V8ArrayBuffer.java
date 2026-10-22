package com.alipay.mobile.jsengine.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8ArrayBuffer extends V8Value {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteBuffer f25361a;

    public V8ArrayBuffer(V8 v8, int i) {
        super(v8);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        ByteBuffer byteBufferCreateV8ArrayBufferBackingStore = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.c, i);
        this.f25361a = byteBufferCreateV8ArrayBufferBackingStore;
        byteBufferCreateV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8Value createTwin() {
        return new V8ArrayBuffer(this.b, this.f25361a);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        this.b.a();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            int iLimit = byteBuffer.limit();
            V8 v8 = this.b;
            this.c = v8.initNewV8ArrayBuffer(v8.getV8RuntimePtr(), byteBuffer, iLimit);
        } else {
            int iIntValue = ((Integer) obj).intValue();
            V8 v9 = this.b;
            this.c = v9.initNewV8ArrayBuffer(v9.getV8RuntimePtr(), iIntValue);
        }
        this.d = false;
        addObjectReference(this.c);
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.b.a();
        checkReleased();
        this.f25361a.put(bArr);
        return this;
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8ArrayBuffer twin() {
        this.b.a();
        checkReleased();
        return (V8ArrayBuffer) super.twin();
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer) {
        this.b.a();
        checkReleased();
        this.f25361a.put(byteBuffer);
        return this;
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        if (byteBuffer.isDirect()) {
            initialize(v8.getV8RuntimePtr(), byteBuffer);
            this.f25361a = byteBuffer;
            byteBuffer.order(ByteOrder.nativeOrder());
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }
}
