package com.alipay.mobile.jsengine.v8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Context extends V8Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25362a;

    public V8Context(V8 v8) {
        super(v8);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Value createTwin() {
        return new V8Context(this.b);
    }

    public void enter() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.enterContext(v8.getV8RuntimePtr(), this.f25362a);
    }

    public void exit() {
        this.b.a();
        checkReleased();
        V8 v8 = this.b;
        v8.exitContext(v8.getV8RuntimePtr(), this.f25362a);
    }

    public long getContextHandle() {
        return this.f25362a;
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        long jInitNewV8Context = this.b.initNewV8Context(j, obj != null ? ((V8Object) obj).getHandle() : 0L);
        this.f25362a = jInitNewV8Context;
        this.d = false;
        addObjectReference(this.b.getContextGlobalHandle(j, jInitNewV8Context));
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object
    public String toString() {
        return (this.d || this.b.isReleased()) ? "[Context released]" : super.toString();
    }

    public V8Context(V8 v8, Object obj, String str) {
        super(v8, obj);
        v8.debugRegisterContext(this.f25362a, str);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Object, com.alipay.mobile.jsengine.v8.V8Value
    public V8Context twin() {
        return (V8Context) super.twin();
    }
}
