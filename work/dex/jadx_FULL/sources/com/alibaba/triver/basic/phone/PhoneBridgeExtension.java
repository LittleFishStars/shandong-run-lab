package com.alibaba.triver.basic.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PhoneBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24711a = "com.alibaba.triver.basic.phone.PhoneBridgeExtension";

    private static void a(Activity activity, Intent intent) {
        if (intent == null || activity == null) {
            return;
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            RVLogger.e(f24711a, "startActivity exception", e);
        }
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

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse sendSMS(@BindingApiContext ApiContext apiContext, @BindingParam({"mobile"}) String str, @BindingParam({"content"}) String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(WVUCWebViewClient.SCHEME_SMS);
        sb.append(!TextUtils.isEmpty(str) ? Uri.encode(str) : "");
        String string = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            string = string + "?body=" + Uri.encode(str2);
        }
        Uri url = CommonUtils.parseUrl(string);
        if (url == null) {
            return BridgeResponse.INVALID_PARAM;
        }
        Intent intent = new Intent("android.intent.action.VIEW", url);
        intent.setFlags(268435456);
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (intent.resolveActivity(rVEnvironmentService.getApplicationContext().getPackageManager()) == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        a(rVEnvironmentService.getTopActivity().get(), intent);
        return BridgeResponse.SUCCESS;
    }
}
