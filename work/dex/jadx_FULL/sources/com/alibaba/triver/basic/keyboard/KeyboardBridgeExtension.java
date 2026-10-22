package com.alibaba.triver.basic.keyboard;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class KeyboardBridgeExtension implements BridgeExtension {
    @ActionFilter
    public void hideKeyboard(@BindingNode(App.class) App app, @BindingCallback BridgeCallback bridgeCallback) {
        if (!(app.getAppContext().getContext() instanceof Activity)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(5, "App Context not Activity"));
            return;
        }
        Activity activity = (Activity) app.getAppContext().getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }
}
