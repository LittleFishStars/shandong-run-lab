package com.alibaba.triver.open.impl;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.triver.open.api.DowngradeEnum;
import com.alibaba.triver.open.proxy.IRouterProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WorkerExceptionImpl implements WorkerExceptionPoint, NodeAware<Page> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Page f25066a = null;

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.engine.api.point.WorkerExceptionPoint
    public void onCreateWorkerException(String str) {
        Page page = this.f25066a;
        if (page == null || (page.getPageContext() instanceof com.alibaba.triver.open.container.a)) {
            return;
        }
        ((IRouterProxy) RVProxy.get(IRouterProxy.class)).downgrade(this.f25066a.getPageContext().getActivity(), null, this.f25066a.getApp().getStartUrl(), DowngradeEnum.WORKER_EXCEPTION.getKey());
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.open.impl.WorkerExceptionImpl.1
            @Override // java.lang.Runnable
            public void run() {
                WorkerExceptionImpl.this.f25066a.getPageContext().getActivity().finish();
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.f25066a = weakReference.get();
    }
}
