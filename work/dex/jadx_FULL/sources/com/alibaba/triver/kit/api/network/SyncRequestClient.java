package com.alibaba.triver.kit.api.network;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.alibaba.triver.kit.api.model.ResponseDO;
import com.alibaba.triver.kit.api.proxy.INetworkProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class SyncRequestClient<E extends RequestParams, T, D> {
    private static final String TAG = "SyncRequestClient";
    protected E mParams;

    public CommonResponse<T, D> buildResponse(ResponseDO responseDO) {
        CommonResponse<T, D> commonResponse = new CommonResponse<>();
        if (responseDO == null) {
            commonResponse.success = false;
            commonResponse.errorCode = "MTOP_RESPONSE_NULL";
            commonResponse.errorMsg = "网络请求异常";
            return commonResponse;
        }
        byte[] bArr = responseDO.data;
        if (bArr == null) {
            RVLogger.d("[mtop]", "response data is null");
            commonResponse.success = false;
            commonResponse.errorCode = responseDO.errorCode;
            commonResponse.errorMsg = responseDO.errorMsg;
            return commonResponse;
        }
        if (responseDO.success) {
            commonResponse.success = true;
            try {
                commonResponse.successData = configSuccessResponse(bArr);
            } catch (Exception e) {
                commonResponse.success = false;
                commonResponse.errorCode = "MTOP_RESPONSE_JSON_PARSE_ERROR";
                commonResponse.errorMsg = "网络请求异常";
                RVLogger.e(TAG, "configSuccessResponse error", e);
                RVLogger.e(TAG, new String(responseDO.data));
            }
        } else {
            commonResponse.success = false;
            commonResponse.errorCode = responseDO.errorCode;
            commonResponse.errorMsg = responseDO.errorMsg;
            try {
                commonResponse.errorData = configFailureResponse(bArr);
            } catch (Exception e2) {
                RVLogger.e(TAG, "configSuccessResponse error", e2);
            }
        }
        return commonResponse;
    }

    public abstract D configFailureResponse(byte[] bArr);

    public abstract T configSuccessResponse(byte[] bArr);

    public CommonResponse<T, D> execute(E e) {
        this.mParams = e;
        try {
            return buildResponse(((INetworkProxy) RVProxy.get(INetworkProxy.class)).execute(e));
        } catch (Exception e2) {
            RVLogger.e(TAG, "execute error", e2);
            CommonResponse<T, D> commonResponse = new CommonResponse<>();
            commonResponse.success = false;
            commonResponse.errorCode = "REQUEST_UNKNOWN_ERROR";
            commonResponse.errorMsg = e2.getMessage();
            return commonResponse;
        }
    }
}
