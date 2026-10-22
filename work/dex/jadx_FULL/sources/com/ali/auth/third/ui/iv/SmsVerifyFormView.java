package com.ali.auth.third.ui.iv;

import com.ali.auth.third.core.model.RpcResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface SmsVerifyFormView {
    String getPageName();

    void onSMSSendFail(RpcResponse rpcResponse);

    void onSendSMSSuccess(long j);

    void onVerifyFail(int i, String str);

    void onVerifySuccess(String str);
}
