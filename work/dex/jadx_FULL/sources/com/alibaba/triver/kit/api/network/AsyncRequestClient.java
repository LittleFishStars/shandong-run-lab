package com.alibaba.triver.kit.api.network;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AsyncRequestClient<E extends RequestParams, T extends Serializable, D> extends SyncRequestClient<E, T, D> implements INetworkProxy.RequestListener {
    private E mParams;
    protected CommonListener<T, D> mRequestListenerRef;

    public AsyncRequestClient(E e, CommonListener<T, D> commonListener) {
        this.mParams = e;
        if (commonListener != null) {
            this.mRequestListenerRef = commonListener;
        }
    }

    public void executeAysnc() {
        ((INetworkProxy) RVProxy.get(INetworkProxy.class)).executeAsync(this.mParams, this);
    }

    @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
    public void onFailure(ResponseDO responseDO) {
        if (this.mRequestListenerRef != null) {
            CommonResponse<T, D> commonResponseBuildResponse = buildResponse(responseDO);
            this.mRequestListenerRef.onFailure(commonResponseBuildResponse.errorCode, commonResponseBuildResponse.errorMsg, commonResponseBuildResponse.errorData);
        }
    }

    @Override // com.alibaba.triver.kit.api.proxy.INetworkProxy.RequestListener
    public void onSuccess(ResponseDO responseDO) {
        if (this.mRequestListenerRef == null) {
            return;
        }
        CommonResponse<T, D> commonResponseBuildResponse = buildResponse(responseDO);
        if (commonResponseBuildResponse.success) {
            this.mRequestListenerRef.onSuccess(commonResponseBuildResponse.successData);
        } else {
            this.mRequestListenerRef.onFailure(commonResponseBuildResponse.errorCode, commonResponseBuildResponse.errorMsg, commonResponseBuildResponse.errorData);
        }
    }
}
