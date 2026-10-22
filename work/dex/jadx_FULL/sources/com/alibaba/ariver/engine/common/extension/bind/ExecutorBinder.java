package com.alibaba.ariver.engine.common.extension.bind;

import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingExecutor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExecutorBinder implements Binder<BindingExecutor, Executor> {
    @Override // com.alibaba.ariver.engine.common.extension.bind.Binder
    public Executor bind(Class<Executor> cls, BindingExecutor bindingExecutor) {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(bindingExecutor.value());
    }
}
