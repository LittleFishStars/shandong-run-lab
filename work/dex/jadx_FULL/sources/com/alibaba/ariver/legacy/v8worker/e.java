package com.alibaba.ariver.legacy.v8worker;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.jsengine.v8.JavaVoidCallback;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Object;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    public static String a(V8Array v8Array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v8Array.length(); i++) {
            Object obj = v8Array.get(i);
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(obj);
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
        }
        return sb.toString();
    }

    public static void a(V8 v8) {
        v8.registerJavaMethod(new JavaVoidCallback() { // from class: com.alibaba.ariver.legacy.v8worker.e.1
            @Override // com.alipay.mobile.jsengine.v8.JavaVoidCallback
            public void invoke(V8Object v8Object, V8Array v8Array) {
                RVLogger.d("V8WorkerConsole", e.a(v8Array));
            }
        }, "__nativeLog__");
    }
}
