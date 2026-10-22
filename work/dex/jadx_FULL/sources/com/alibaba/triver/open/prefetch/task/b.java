package com.alibaba.triver.open.prefetch.task;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.open.prefetch.PrefectchCallback;
import com.alibaba.triver.open.prefetch.context.ImagePrefetchContext;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends c<ImagePrefetchContext> {
    public b(ImagePrefetchContext imagePrefetchContext, PrefectchCallback prefectchCallback) {
        super(imagePrefetchContext, prefectchCallback);
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public void a(String str, Object... objArr) {
        Iterator<String> it = ((ImagePrefetchContext) this.f25075a).params.imgUrls.iterator();
        while (it.hasNext()) {
            ((IImageProxy) RVProxy.get(IImageProxy.class)).loadImage(it.next(), null, null);
        }
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public boolean b(String str, Object... objArr) {
        T t = this.f25075a;
        return (t == 0 || ((ImagePrefetchContext) t).params == null || ((ImagePrefetchContext) t).params.imgUrls == null || ((ImagePrefetchContext) t).params.imgUrls.isEmpty()) ? false : true;
    }

    @Override // com.alibaba.triver.open.prefetch.task.c
    public ExecutorType a() {
        return ExecutorType.UI;
    }
}
