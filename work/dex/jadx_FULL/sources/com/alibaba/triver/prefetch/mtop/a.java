package com.alibaba.triver.prefetch.mtop;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.network.AsyncRequestClient;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.network.SyncRequestClient;
import com.alibaba.triver.kit.api.orange.TROrangeController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements com.alibaba.triver.prefetch.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f25114a = null;
    private static final String b = "MtopPrefetch";

    private a() {
    }

    @Override // com.alibaba.triver.prefetch.a.b
    public void b(com.alibaba.triver.prefetch.a.c cVar, com.alibaba.triver.prefetch.a.a aVar) {
    }

    public static a a() {
        if (f25114a == null) {
            synchronized (a.class) {
                if (f25114a == null) {
                    f25114a = new a();
                }
            }
        }
        return f25114a;
    }

    @Override // com.alibaba.triver.prefetch.a.b
    public void a(com.alibaba.triver.prefetch.a.c cVar, final com.alibaba.triver.prefetch.a.a aVar) {
        Object objA = cVar.a();
        if (!(objA instanceof b.a)) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        b.a aVar2 = (b.a) objA;
        final SyncRequestClient syncRequestClientA = aVar2.a();
        final RequestParams requestParamsB = aVar2.b();
        RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        if (syncRequestClientA instanceof AsyncRequestClient) {
            ((AsyncRequestClient) syncRequestClientA).executeAysnc();
        } else if (rVExecutorService == null) {
            a(syncRequestClientA, requestParamsB, aVar);
        } else {
            rVExecutorService.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.triver.prefetch.mtop.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(syncRequestClientA, requestParamsB, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SyncRequestClient syncRequestClient, RequestParams requestParams, com.alibaba.triver.prefetch.a.a aVar) {
        CommonResponse commonResponseExecute;
        T t;
        try {
            commonResponseExecute = syncRequestClient.execute(requestParams);
        } catch (Throwable th) {
            th.printStackTrace();
            commonResponseExecute = null;
        }
        if (commonResponseExecute == null || (t = commonResponseExecute.successData) == 0) {
            if (aVar != null) {
                try {
                    aVar.a();
                    return;
                } catch (Throwable th2) {
                    RVLogger.e(b, th2);
                    return;
                }
            }
            return;
        }
        c.a(requestParams, t.toString(), TROrangeController.getMtopCacheTimeoutBySecond() * 1000);
        if (aVar != null) {
            try {
                aVar.a(commonResponseExecute.successData);
            } catch (Throwable th3) {
                RVLogger.e(b, th3);
            }
        }
    }
}
