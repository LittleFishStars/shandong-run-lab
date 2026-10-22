package com.alibaba.ariver.legacy.v8worker;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24302a = "JSWorker";
    private n b;
    private V8Object c;
    private HandlerThread d;
    private Handler e;
    private V8 f;
    private V8Function g;
    private V8Function h;

    public class a implements JavaVoidCallback {
        public a() {
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
        }
    }

    public class b implements JavaVoidCallback {
        public b() {
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                f.this.b((V8Function) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(f.f24302a, "failed to set onmessage in Worker", th);
            }
        }
    }

    public class c implements JavaVoidCallback {
        public c() {
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                f.this.a((V8Object) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(f.f24302a, "failed to postMessage in Worker", th);
            }
        }
    }

    public f(n nVar, String str, V8Object v8Object, final String str2, final Object obj) {
        this.b = nVar;
        this.c = v8Object;
        HandlerThread handlerThread = new HandlerThread(str);
        this.d = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.d.getLooper());
        this.e = handler;
        handler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.a(str2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        V8 v8 = this.f;
        return v8 == null || v8.isReleased();
    }

    public void b(V8Function v8Function) {
        V8Function v8Function2 = this.h;
        if (v8Function2 != null) {
            v8Function2.release();
        }
        this.h = v8Function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object obj) {
        V8 v8CreateV8Runtime = V8.createV8Runtime("worker");
        this.f = v8CreateV8Runtime;
        v8CreateV8Runtime.registerJavaMethod(new a(), "importScripts");
        this.f.registerJavaMethod(new b(), "onMessage");
        this.f.registerJavaMethod(new c(), com.alibaba.triver.embed.webview.b.f24908a);
        e.a(this.f);
        a(((V8Proxy) RVProxy.get(V8Proxy.class)).getMultiWorkerJS(), "https://appx/v8.multiworker.js", 0);
        RVLogger.d(f24302a, "Starting JS Worker...");
        a(obj, str, 0);
        RVLogger.d(f24302a, "JS Worker ready.");
    }

    public void b(V8Object v8Object) {
        a(v8Object, this.e, true);
    }

    private void a(Object obj, String str, int i) {
        if (b()) {
            return;
        }
        try {
            if (obj instanceof String) {
                this.f.executeVoidScript((String) obj, str, i);
            } else if (obj instanceof byte[]) {
                this.f.executeVoidScript((byte[]) obj, str, i);
            }
            this.f.pumpMessageLoop(false);
        } catch (Throwable th) {
            RVLogger.e(f24302a, "Caught exception when executeScript " + str + "\n" + m.a(th));
        }
    }

    public void a() {
        if (b()) {
            return;
        }
        V8Object v8Object = this.c;
        if (v8Object != null) {
            v8Object.release();
            this.c = null;
        }
        V8Function v8Function = this.g;
        if (v8Function != null) {
            v8Function.release();
            this.g = null;
        }
        this.e.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.b()) {
                    return;
                }
                try {
                    if (f.this.h != null) {
                        f.this.h.release();
                        f.this.h = null;
                    }
                    f.this.f.release();
                } catch (Throwable th) {
                    try {
                        RVLogger.e(f.f24302a, "Caught exception when release v8 vm", th);
                    } finally {
                        f.this.d.quitSafely();
                    }
                }
            }
        });
    }

    public void a(V8Function v8Function) {
        V8Function v8Function2 = this.g;
        if (v8Function2 != null) {
            v8Function2.release();
        }
        this.g = v8Function;
    }

    public void a(V8Object v8Object) {
        a(v8Object, this.b.getHandler(), false);
    }

    private void a(V8Object v8Object, Handler handler, final boolean z) {
        final long jSerialize = v8Object.serialize();
        v8Object.release();
        if (jSerialize == 0) {
            RVLogger.e(f24302a, "failed to serialize js object...");
        } else {
            handler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.f.3
                @Override // java.lang.Runnable
                public void run() {
                    V8 v8Runtime = z ? f.this.f : f.this.b.getV8Runtime();
                    V8Function v8Function = z ? f.this.h : f.this.g;
                    if (v8Runtime == null || v8Runtime.isReleased() || v8Function == null || v8Function.isReleased()) {
                        V8.cancelSerialization(jSerialize);
                        return;
                    }
                    V8Value v8ValueDeserialize = v8Runtime.deserialize(jSerialize);
                    V8Array v8Array = new V8Array(v8Runtime);
                    v8Array.push(v8ValueDeserialize);
                    try {
                        v8Function.call(v8Runtime, v8Array);
                        if (v8ValueDeserialize != null) {
                        }
                    } catch (Throwable th) {
                        try {
                            RVLogger.e(f.f24302a, "doPostMessage " + m.a(th));
                        } finally {
                            if (v8ValueDeserialize != null) {
                                v8ValueDeserialize.release();
                            }
                            v8Array.release();
                        }
                    }
                }
            });
        }
    }
}
