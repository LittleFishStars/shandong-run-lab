package com.alibaba.triver.extensions;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.content.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TitleBarExtension implements PageHidePoint, PagePausePoint, PageResumePoint, PageShowPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageHidePoint
    public void onPageHide(final Page page) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TitleBarExtension.1
            @Override // java.lang.Runnable
            public void run() {
                if (page.getPageContext() != null) {
                    TitleBar titleBar = page.getPageContext().getTitleBar();
                    if (titleBar instanceof e) {
                        ((e) titleBar).a().onHide();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(final Page page) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TitleBarExtension.2
            @Override // java.lang.Runnable
            public void run() {
                if (page.getPageContext() != null) {
                    TitleBar titleBar = page.getPageContext().getTitleBar();
                    if (titleBar instanceof e) {
                        ((e) titleBar).a().onHide();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(final Page page) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TitleBarExtension.3
            @Override // java.lang.Runnable
            public void run() {
                if (page.getPageContext() != null) {
                    TitleBar titleBar = page.getPageContext().getTitleBar();
                    if (titleBar instanceof e) {
                        ((e) titleBar).a().onShow();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageShowPoint
    public void onPageShow(final Page page, JSONObject jSONObject) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.TitleBarExtension.4
            @Override // java.lang.Runnable
            public void run() {
                if (page.getPageContext() != null) {
                    TitleBar titleBar = page.getPageContext().getTitleBar();
                    if (titleBar instanceof e) {
                        ((e) titleBar).a().onShow();
                    }
                }
            }
        });
    }
}
