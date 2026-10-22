package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.v8.JavaCallback;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o implements JavaCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f24341a = "WorkerJsapiCallback";
    private n b;
    private int c = 1;
    private Map<Integer, f> d = new HashMap();

    public class a implements JavaVoidCallback {
        private f b;

        public a(f fVar) {
            this.b = fVar;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                this.b.a((V8Function) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(o.f24341a, "failed to set onmessage of JS Worker", th);
            }
        }
    }

    public class b implements JavaVoidCallback {
        private f b;

        public b(f fVar) {
            this.b = fVar;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                this.b.b((V8Object) v8Array.get(0));
            } catch (Throwable th) {
                RVLogger.e(o.f24341a, "failed to postMessage to JS Worker", th);
            }
        }
    }

    public class c implements JavaVoidCallback {
        private int b;
        private f c;

        public c(int i, f fVar) {
            this.b = i;
            this.c = fVar;
        }

        @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            try {
                o.this.a(this.b, this.c);
            } catch (Throwable th) {
                RVLogger.e(o.f24341a, "failed to terminate JS Worker", th);
            }
        }
    }

    public o(n nVar) {
        this.b = nVar;
    }

    public static int a() {
        return 1;
    }

    public void a(int i, f fVar) {
        this.d.remove(Integer.valueOf(i));
        fVar.a();
    }

    public void b() {
        Iterator<Map.Entry<Integer, f>> it = this.d.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        this.d.clear();
    }

    @Override // com.alipay.mobile.jsengine.v8.JavaCallback
    public Object invoke(V8Object v8Object, V8Array v8Array) {
        if (this.b.isDestroyed()) {
            return null;
        }
        if (this.d.size() >= a()) {
            RVLogger.e(f24341a, "The number of worker exceeds system limit");
            return V8.getUndefined();
        }
        try {
            V8Object v8Object2 = (V8Object) v8Array.get(0);
            String string = v8Object2.getString("scriptPath");
            v8Object2.release();
            String strReplace = this.b.getWorkerId().replace("index.worker.js", string);
            String strLoadResource = this.b.loadResource(strReplace);
            RVLogger.d(f24341a, "create JS Worker: " + string + ", " + strLoadResource.length() + " bytes");
            int i = this.c;
            this.c = i + 1;
            V8Object v8Object3 = new V8Object(this.b.getV8Runtime());
            f fVar = new f(this.b, "JSWorker_" + i, v8Object3, strReplace, strLoadResource);
            v8Object3.registerJavaMethod(new a(fVar), "onMessage");
            v8Object3.registerJavaMethod(new b(fVar), com.alibaba.triver.embed.webview.b.f24908a);
            v8Object3.registerJavaMethod(new c(i, fVar), "terminate");
            try {
                a(v8Object3);
            } catch (Throwable th) {
                RVLogger.e(f24341a, "failed to hideWorkerProperty for JSWorker: ", th);
            }
            this.d.put(Integer.valueOf(i), fVar);
            return v8Object3;
        } catch (Throwable th2) {
            RVLogger.e(f24341a, "failed to create JS Worker", th2);
            return V8.getUndefined();
        }
    }

    private void a(V8Object v8Object) {
        V8 v8Runtime = this.b.getV8Runtime();
        if (v8Runtime == null || v8Runtime.isReleased() || v8Object == null) {
            return;
        }
        V8Object object = v8Runtime.getObject("Object");
        V8Function v8Function = (V8Function) object.getObject("defineProperty");
        V8Object v8Object2 = new V8Object(v8Runtime);
        v8Object2.add("writable", false);
        v8Object2.add("configurable", false);
        v8Object2.add("enumerable", false);
        String[] strArr = {"onMessage", com.alibaba.triver.embed.webview.b.f24908a, "terminate"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            V8Array v8Array = new V8Array(v8Runtime);
            v8Array.push((V8Value) v8Object);
            v8Array.push(str);
            v8Array.push((V8Value) v8Object2);
            try {
                Object objCall = v8Function.call(object, v8Array);
                if (objCall instanceof Releasable) {
                    ((Releasable) objCall).release();
                }
            } catch (Throwable th) {
                try {
                    RVLogger.e(f24341a, "failed to hideWorkerProperty for JS Worker: ", th);
                } catch (Throwable th2) {
                    v8Array.release();
                    throw th2;
                }
            }
            v8Array.release();
        }
        object.release();
        v8Function.release();
        v8Object2.release();
    }
}
