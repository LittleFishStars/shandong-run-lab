package com.alibaba.triver.open.preload;

import android.taobao.windvane.b.g;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.uc.WVUCWebView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.v8worker.V8Proxy;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.JSEngine2;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements IPreloadJob<Object> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "worker-preload-open";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Object> getResultClazz() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Object preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        Delegate delegateGenerateDelegate;
        if (!WVUCWebView.getUCSDKSupport()) {
            g.a().a(new android.taobao.windvane.b.b() { // from class: com.alibaba.triver.open.preload.d.1
                @Override // android.taobao.windvane.b.b
                public void a() {
                    super.a();
                    ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.open.preload.d.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Delegate delegateGenerateDelegate2 = ((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate();
                            if (delegateGenerateDelegate2 != null) {
                                JSEngine2.Initialize(delegateGenerateDelegate2);
                            }
                        }
                    });
                }
            });
            WVCore.c().a(new android.taobao.windvane.extra.core.a() { // from class: com.alibaba.triver.open.preload.d.2
                @Override // android.taobao.windvane.extra.core.a
                public void b() {
                    super.b();
                    ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.open.preload.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate() != null) {
                                JSEngine2.Initialize(((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate());
                            }
                        }
                    });
                }
            });
        }
        if (!WVUCWebView.getUCSDKSupport() || (delegateGenerateDelegate = ((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate()) == null) {
            return null;
        }
        JSEngine2.Initialize(delegateGenerateDelegate);
        return null;
    }
}
