package com.alibaba.ariver.legacy.v8worker;

import android.os.Handler;
import com.alipay.mobile.jsengine.v8.JavaCallback;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24316a = 0;
    private boolean b = false;
    private ArrayList<h> c = new ArrayList<>();
    private j d = new j();
    private Handler e;

    public i(V8 v8, Handler handler) {
        this.e = handler;
        v8.registerJavaMethod(new JavaCallback() { // from class: com.alibaba.ariver.legacy.v8worker.i.1
            @Override // com.alipay.mobile.jsengine.v8.JavaCallback
            public Object invoke(V8Object v8Object, V8Array v8Array) {
                V8Function v8Function = (V8Function) v8Array.get(0);
                int iIntValue = ((Integer) v8Array.get(1)).intValue();
                boolean zBooleanValue = ((Boolean) v8Array.get(2)).booleanValue();
                int iB = i.this.b();
                h hVar = new h(i.this, v8Function, iB, zBooleanValue);
                if (iB < i.this.c.size()) {
                    i.this.c.set(iB, hVar);
                } else {
                    i.this.c.add(hVar);
                }
                if (zBooleanValue) {
                    long j = iIntValue;
                    i.this.d.a(hVar, j, j);
                } else {
                    i.this.d.a(hVar, iIntValue);
                }
                return Integer.valueOf(iB + 1);
            }
        }, "__nativeCreateTimer__");
        v8.registerJavaMethod(new JavaVoidCallback() { // from class: com.alibaba.ariver.legacy.v8worker.i.2
            @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
            public void invoke(V8Object v8Object, V8Array v8Array) {
                h hVar;
                int iIntValue = ((Integer) v8Array.get(0)).intValue() - 1;
                if (iIntValue < 0 || iIntValue >= i.this.c.size() || (hVar = (h) i.this.c.get(iIntValue)) == null) {
                    return;
                }
                i.this.a(iIntValue);
                hVar.a();
            }
        }, "__nativeDeleteTimer__");
    }

    public void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.d.a();
    }

    public void d() {
        if (this.b) {
            this.b = false;
            this.d.b();
        }
    }

    public void e() {
        this.d.c();
        this.d.d();
        for (int i = 0; i < this.c.size(); i++) {
            h hVar = this.c.get(i);
            if (hVar != null) {
                this.c.set(i, null);
                hVar.a();
            }
        }
    }

    public Handler a() {
        return this.e;
    }

    public int b() {
        int size = this.c.size();
        if (size <= 100) {
            return size;
        }
        for (int i = this.f24316a; i < size; i++) {
            if (this.c.get(i) == null) {
                int i2 = this.f24316a + 1;
                this.f24316a = i2;
                if (i2 >= size) {
                    this.f24316a = 0;
                }
                return i;
            }
        }
        return size;
    }

    public void a(int i) {
        this.c.set(i, null);
    }
}
