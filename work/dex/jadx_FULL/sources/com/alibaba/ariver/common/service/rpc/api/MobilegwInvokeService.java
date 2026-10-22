package com.alibaba.ariver.common.service.rpc.api;

import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.permission.openauth.model.request.JsApiInvokeRequestModel;
import com.alibaba.ariver.permission.openauth.model.result.JsApiInvokeResultModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public interface MobilegwInvokeService extends Proxiable {
    JsApiInvokeResultModel jsApiInvoke(JsApiInvokeRequestModel jsApiInvokeRequestModel);
}
