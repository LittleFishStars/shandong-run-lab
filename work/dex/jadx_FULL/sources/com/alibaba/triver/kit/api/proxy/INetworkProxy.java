package com.alibaba.triver.kit.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface INetworkProxy extends Proxiable {

    public interface RequestListener {
        void onFailure(ResponseDO responseDO);

        void onSuccess(ResponseDO responseDO);
    }

    ResponseDO execute(RequestParams requestParams);

    void executeAsync(RequestParams requestParams, RequestListener requestListener);
}
