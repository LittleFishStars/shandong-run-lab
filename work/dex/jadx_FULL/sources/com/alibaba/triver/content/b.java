package com.alibaba.triver.content;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ErrorView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.R;
import com.alibaba.triver.app.g;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.model.ErrorInfo;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IPageLoadProxy;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements ErrorView, com.alibaba.triver.impl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f24806a;

    public b(Context context) {
        this.f24806a = context;
    }

    @Override // com.alibaba.triver.impl.a
    public void a(Page page, int i, String str, String str2, String str3, String str4) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.errorCode = str;
        errorInfo.errorMsg = str2;
        errorInfo.subTitle = str3;
        errorInfo.errorLogo = str4;
        if (i == 1) {
            errorInfo.buttonAction = ErrorInfo.buttonActionType.refresh;
            if (TextUtils.isEmpty(str2)) {
                errorInfo.errorMsg = InternationalUtil.getString(this.f24806a, R.string.triver_wait_title);
            }
            if (TextUtils.isEmpty(errorInfo.subTitle)) {
                errorInfo.subTitle = InternationalUtil.getString(this.f24806a, R.string.triver_wait_tip);
            }
        } else if (i == 2) {
            errorInfo.buttonAction = ErrorInfo.buttonActionType.back;
            if (TextUtils.isEmpty(str2)) {
                errorInfo.errorMsg = InternationalUtil.getString(this.f24806a, R.string.triver_wait_title);
            }
            if (TextUtils.isEmpty(errorInfo.subTitle)) {
                errorInfo.subTitle = InternationalUtil.getString(this.f24806a, R.string.triver_wait_tip2);
            }
        } else if (i == 3) {
            errorInfo.buttonAction = ErrorInfo.buttonActionType.update;
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
            String str5 = (configsByGroup == null || TextUtils.isEmpty(configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL))) ? "https://huodong.m.taobao.com/act/snipcode.html" : configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_UPDATE_URL);
            errorInfo.buttonText = InternationalUtil.getString(this.f24806a, R.string.triver_update_tip);
            errorInfo.buttonUrl = str5;
            if (TextUtils.isEmpty(errorInfo.errorMsg)) {
                errorInfo.errorMsg = InternationalUtil.getString(this.f24806a, R.string.triver_version_too_lower);
            }
            if (TextUtils.isEmpty(errorInfo.subTitle)) {
                errorInfo.subTitle = InternationalUtil.getString(this.f24806a, R.string.triver_must_update_info);
            }
        }
        errorInfo.errorTitle = errorInfo.errorMsg;
        a(page, errorInfo);
    }

    @Override // com.alibaba.ariver.app.api.ui.ErrorView, com.alibaba.triver.impl.a
    public boolean enableShowErrorPage() {
        return true;
    }

    @Override // com.alibaba.ariver.app.api.ui.ErrorView
    public void showErrorView(Page page, String str, int i, String str2, String str3) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.errorCode = Integer.toString(i);
        errorInfo.errorMsg = str2;
        errorInfo.errorTitle = str2;
        errorInfo.subTitle = str3;
        errorInfo.buttonAction = ErrorInfo.buttonActionType.back;
        a(page, errorInfo);
    }

    private void a(Page page, ErrorInfo errorInfo) {
        IPageLoadProxy iPageLoadProxy = (IPageLoadProxy) RVProxy.get(IPageLoadProxy.class);
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null || page.getPageContext().getPageContainer().getView() == null) {
            return;
        }
        ViewGroup view = page.getPageContext().getPageContainer().getView();
        View viewFindViewById = view.findViewById(R.id.previous_error_view);
        if (viewFindViewById != null) {
            view.removeView(viewFindViewById);
        }
        View errorView = iPageLoadProxy.getErrorView(this.f24806a, new g(page, new com.alibaba.triver.app.e(page.getApp())), errorInfo);
        errorView.setId(R.id.previous_error_view);
        view.addView(errorView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.alibaba.triver.impl.a
    public void a(Page page) {
        ViewGroup view;
        View viewFindViewById;
        if (page == null || page.getPageContext() == null || page.getPageContext().getPageContainer() == null || page.getPageContext().getPageContainer().getView() == null || (viewFindViewById = (view = page.getPageContext().getPageContainer().getView()).findViewById(R.id.previous_error_view)) == null) {
            return;
        }
        view.removeView(viewFindViewById);
    }
}
