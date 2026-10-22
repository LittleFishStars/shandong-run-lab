package com.kwad.components.core.innerEc.logger;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class InnerEcError extends BaseInnerEcMsg {
    public static final int CODE_AUTH_ERROR = 2000;
    public static final int STATUS_AUTH_ERROR = 2;
    public static final int STATUS_H5_ERROR = 6;
    public static final int STATUS_LIVE_PLAY_ERROR = 4;
    public static final int STATUS_LIVE_ROOM_ERROR = 3;
    public static final int STATUS_PAY_ERROR = 5;
    public static final int STATUS_RENDER_ERROR = 1;
    private static final long serialVersionUID = -277676687150458316L;
    public String errorUrl;
    public String payErrorMsg;
    public String payExtData;
    public String payMerchantId;
    public String payOrderNo;
    public int payOriginalResultCode;

    public static InnerEcError copyFrom(InnerEcError innerEcError) {
        InnerEcError innerEcError2 = new InnerEcError();
        try {
            innerEcError2.parseJson(innerEcError.toJson());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return innerEcError2;
    }

    public static InnerEcError createCommonError(AdTemplate adTemplate, int i) {
        InnerEcError innerEcError = new InnerEcError();
        innerEcError.status = i;
        innerEcError.setAdTemplate(adTemplate);
        return innerEcError;
    }

    public static InnerEcError createEmptyError(AdTemplate adTemplate) {
        InnerEcError innerEcError = new InnerEcError();
        innerEcError.setAdTemplate(adTemplate);
        return innerEcError;
    }
}
