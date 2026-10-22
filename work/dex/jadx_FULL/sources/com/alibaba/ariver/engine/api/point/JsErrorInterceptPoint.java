package com.alibaba.ariver.engine.api.point;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface JsErrorInterceptPoint extends Extension {
    @ThreadType(ExecutorType.NORMAL)
    void onJsEngineErrorIntercept(String str, String str2);

    @ThreadType(ExecutorType.NORMAL)
    void onWorkerErrorIntercept(String str, String str2);
}
