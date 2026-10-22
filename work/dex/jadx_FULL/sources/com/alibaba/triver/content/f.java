package com.alibaba.triver.content;

import android.app.Activity;
import com.alibaba.ariver.app.ui.DefaultViewSpecProvider;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.TinyApp;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends DefaultViewSpecProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f24815a;
    private TinyApp b;

    public f(Activity activity, TinyApp tinyApp) {
        super(activity);
        this.b = tinyApp;
    }

    @Override // com.alibaba.ariver.app.ui.DefaultViewSpecProvider
    public int getTabBarHeight() {
        return super.getTabBarHeight();
    }

    @Override // com.alibaba.ariver.app.ui.DefaultViewSpecProvider
    public int getTitleBarHeight() {
        if (this.f24815a == null) {
            this.f24815a = Integer.valueOf(((IPageLoadProxy) RVProxy.get(IPageLoadProxy.class)).getDefaultTitleBarHeight(getActivity(), this.b));
        }
        return this.f24815a.intValue();
    }
}
