package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.view.View;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.widget.ILoadingView;
import com.alibaba.triver.kit.api.widget.ITitleBar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.impl.PageLoadProxyImpl")
public interface IPageLoadProxy extends Proxiable {
    ITitleBar attachPage(ITitleBar iTitleBar, Page page);

    int getDefaultTitleBarHeight(Context context, TinyApp tinyApp);

    View getErrorView(Context context, Page page, ErrorInfo errorInfo);

    ILoadingView getLoadingView(Context context, Page page);

    ITitleBar getTitleBar(Context context, TinyApp tinyApp);
}
