package com.alibaba.ariver.kernel.api.invoke;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.scheduler.Schedulable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AwareExtensionInvoker extends ExtensionInvoker {
    static final String TAG = "AriverKernel:ExtensionInvoker:Aware";

    public AwareExtensionInvoker(Node node, ExtensionInvoker.InvokeCallback invokeCallback, Class<? extends Extension> cls) {
        super(node, invokeCallback, cls);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        System.currentTimeMillis();
        Extension extension = immutableList.get(0);
        NodeAwareUtils.handleSetNode(this.targetNode, extension);
        if (extension instanceof Schedulable) {
            ((Schedulable) extension).setExecutorFactory((RVExecutorService) RVProxy.get(RVExecutorService.class));
        }
        return ExtensionInvoker.InvokeResult.proceed();
    }
}
