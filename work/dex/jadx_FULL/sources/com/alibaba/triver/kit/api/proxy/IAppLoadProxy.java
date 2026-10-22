package com.alibaba.triver.kit.api.proxy;

import android.content.Context;
import android.view.View;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.Page;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.model.EntryInfo;
import com.alibaba.triver.kit.api.model.ErrorInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DefaultImpl("com.alibaba.triver.kit.impl.AppLoadProxyImpl")
public interface IAppLoadProxy extends Proxiable {
    View getErrorView(Context context, Page page, ErrorInfo errorInfo);

    void hideAppLoading(View view);

    boolean isShowError(View view);

    boolean isShowLoading(View view);

    void onAppLoadError(View view, TinyApp tinyApp, ErrorInfo errorInfo);

    void onRenderSuccess(View view);

    void removeAppLoadError(View view, TinyApp tinyApp);

    void showAppLoading(View view, TinyApp tinyApp, EntryInfo entryInfo);

    void updateAppInfo(View view, EntryInfo entryInfo);
}
