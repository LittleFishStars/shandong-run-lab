package com.kwad.components.core.innerEc.qcpx;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class ReceiveQcpxBody extends AdCouponReceiveParam {
    public long creativeId;
    public String flowTag = "universeClosure";
    public long llsid;

    public static ReceiveQcpxBody newInstance(AdTemplate adTemplate) {
        AdCouponReceiveParam adCouponReceiveParam;
        if (adTemplate == null || (adCouponReceiveParam = e.eO(adTemplate).adCouponReceiveParam) == null) {
            return null;
        }
        ReceiveQcpxBody receiveQcpxBody = new ReceiveQcpxBody();
        receiveQcpxBody.receiveToast = adCouponReceiveParam.receiveToast;
        receiveQcpxBody.receiveFailToast = adCouponReceiveParam.receiveFailToast;
        receiveQcpxBody.sign = adCouponReceiveParam.sign;
        String str = adCouponReceiveParam.ext;
        receiveQcpxBody.ext = str;
        if (str == null) {
            receiveQcpxBody.ext = "";
        }
        receiveQcpxBody.flowType = adCouponReceiveParam.flowType;
        receiveQcpxBody.llsid = e.eL(adTemplate);
        receiveQcpxBody.creativeId = e.eY(adTemplate);
        return receiveQcpxBody;
    }
}
