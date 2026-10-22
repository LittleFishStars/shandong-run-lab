package com.alibaba.alibctriver.extensions;

import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.PageDO;
import com.alibaba.alibctriver.AlibcTriverSDK;
import com.alibaba.ariver.app.api.App;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.open.preload.c;
import com.alibaba.triver.point.RenderPreloadPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcRenderPreloadExtension implements RenderPreloadPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23677a = "AlibcRenderPreloadExtension";

    private static void a() {
        ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.alibctriver.extensions.AlibcRenderPreloadExtension.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IPreloadJob iPreloadJob = (IPreloadJob) c.class.newInstance();
                    PageDO page = AlibcConfigService.getInstance().getPage();
                    if (page != null) {
                        JSONObject suites = AlibcTriverSDK.parseSuites(page.getSuites());
                        PreloadScheduler.getInstance();
                        iPreloadJob.preLoad(suites, PreloadScheduler.PointType.PRELOAD_RESOURCE);
                    }
                } catch (Exception e) {
                    AlibcLogger.e(AlibcRenderPreloadExtension.f23677a, e.getMessage());
                }
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.triver.point.RenderPreloadPoint
    public void onPreloadRender(App app) {
    }
}
