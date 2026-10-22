package com.ali.auth.third.login.task;

import android.app.Activity;
import android.webkit.WebView;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.task.TaskWithDialog;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.ui.context.CallbackContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RefreshSidTask extends TaskWithDialog<String, Void, Void> {
    public RefreshSidTask(WebView webView) {
        super((Activity) webView.getContext());
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(String... strArr) {
        if (!KernelContext.credentialService.isSessionValid()) {
            CallbackContext.setActivity(this.activity);
            LoginComponent.INSTANCE.showLogin(this.activity);
        }
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        CommonUtils.toastSystemException();
    }
}
