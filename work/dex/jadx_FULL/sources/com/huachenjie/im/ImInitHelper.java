package com.huachenjie.im;

import com.huachenjie.im.custom.base.CustomAttachParser;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.lifecycle.SdkLifecycleObserver;
import com.netease.nimlib.sdk.msg.MsgService;
import com.zj.adlib.i4a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ImInitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ImInitHelper f34381a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f9621a = "imLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OperateCallback f9622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Observer<Boolean> f9623a = new Observer<Boolean>() { // from class: com.huachenjie.im.ImInitHelper.1
        public void onEvent(Boolean bool) {
            ((SdkLifecycleObserver) NIMClient.getService(SdkLifecycleObserver.class)).observeMainProcessInitCompleteResult(ImInitHelper.this.f9623a, false);
            i4a.b(ImInitHelper.f9621a, "主进程初始化完毕" + bool);
            if (bool == null || !bool.booleanValue()) {
                if (ImInitHelper.this.f9622a != null) {
                    ImInitHelper.this.f9622a.onFailed(404);
                }
                i4a.b(ImInitHelper.f9621a, "主进程初始化失败");
            } else {
                ((MsgService) NIMClient.getService(MsgService.class)).registerCustomAttachmentParser(new CustomAttachParser());
                if (ImInitHelper.this.f9622a != null) {
                    ImInitHelper.this.f9622a.onSuccess(null);
                }
            }
            ImInitHelper.this.f9622a = null;
        }
    };

    public static ImInitHelper c() {
        ImInitHelper imInitHelper;
        synchronized (ImInitHelper.class) {
            if (f34381a == null) {
                f34381a = new ImInitHelper();
            }
            imInitHelper = f34381a;
        }
        return imInitHelper;
    }

    public void d(OperateCallback operateCallback) {
        this.f9622a = operateCallback;
        i4a.b(f9621a, "NIMClient.initSDK()");
        NIMClient.initSDK();
        i4a.b(f9621a, "observeMainProcessInitCompleteResult");
        ((SdkLifecycleObserver) NIMClient.getService(SdkLifecycleObserver.class)).observeMainProcessInitCompleteResult(this.f9623a, true);
    }
}
