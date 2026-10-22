package com.alibaba.sdk.android.oss.callback;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface OSSCompletedCallback<T1 extends OSSRequest, T2 extends OSSResult> {
    void onFailure(T1 t1, ClientException clientException, ServiceException serviceException);

    void onSuccess(T1 t1, T2 t2);
}
