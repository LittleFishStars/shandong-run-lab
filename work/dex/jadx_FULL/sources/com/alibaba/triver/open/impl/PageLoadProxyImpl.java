package com.alibaba.triver.open.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.widget.ILoadingView;
import com.alibaba.triver.kit.api.widget.ITitleBar;
import com.alibaba.triver.open.widget.TBCircularProgress;
import com.alibaba.triver.open.widget.e;
import com.alibaba.triver.open.widget.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageLoadProxyImpl implements IPageLoadProxy {
    @Override // com.alibaba.triver.kit.api.proxy.IPageLoadProxy
    public ITitleBar attachPage(ITitleBar iTitleBar, Page page) {
        iTitleBar.attachPage(page);
        return iTitleBar;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IPageLoadProxy
    public int getDefaultTitleBarHeight(Context context, TinyApp tinyApp) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.triver_action_bar_height);
        int statusBarHeight = CommonUtils.getStatusBarHeight(context) + 0;
        if ("1".equals(CommonUtils.get("ro.miui.notch"))) {
            statusBarHeight -= CommonUtils.dip2px(context, 3.0f);
        }
        return dimensionPixelSize + statusBarHeight;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IPageLoadProxy
    public View getErrorView(Context context, Page page, ErrorInfo errorInfo) {
        e eVar = new e();
        eVar.attatchPage(page);
        View view = eVar.getView(context);
        eVar.a(errorInfo, false);
        return view;
    }

    @Override // com.alibaba.triver.kit.api.proxy.IPageLoadProxy
    public ILoadingView getLoadingView(Context context, Page page) {
        final TBCircularProgress tBCircularProgress = new TBCircularProgress(context);
        final FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(CommonUtils.dip2px(context, 100.0f), CommonUtils.dip2px(context, 100.0f));
        layoutParams.gravity = 17;
        tBCircularProgress.setLayoutParams(layoutParams);
        frameLayout.addView(tBCircularProgress);
        return new ILoadingView() { // from class: com.alibaba.triver.open.impl.PageLoadProxyImpl.1
            @Override // com.alibaba.triver.kit.api.widget.ILoadingView
            public View getContentView() {
                return frameLayout;
            }

            @Override // com.alibaba.triver.kit.api.widget.ILoadingView
            public void update(String str) {
                tBCircularProgress.setProgressText(str);
            }
        };
    }

    @Override // com.alibaba.triver.kit.api.proxy.IPageLoadProxy
    public ITitleBar getTitleBar(Context context, TinyApp tinyApp) {
        return new h(context);
    }
}
