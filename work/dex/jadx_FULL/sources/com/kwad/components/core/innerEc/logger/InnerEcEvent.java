package com.kwad.components.core.innerEc.logger;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.innerEc.live.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class InnerEcEvent extends BaseInnerEcMsg {
    public static final int STATUS_ACCOUNT_INFO_EXIST = 4;
    public static final int STATUS_AD_CLICK = 2;
    public static final int STATUS_AD_SHOW = 1;
    public static final int STATUS_AUTH_SUCCESS = 7;
    public static final int STATUS_GET_ACCOUNT_INFO = 3;
    public static final int STATUS_GET_AUTH_CODE_SUCCESS = 6;
    public static final int STATUS_LIVE_ROOM_LAUNCH_SUCCESS = 9;
    public static final int STATUS_PAY_CANCEL = 13;
    public static final int STATUS_PAY_SUCCESS = 12;
    public static final int STATUS_START_AUTH = 5;
    public static final int STATUS_START_AUTH_TYPE = 5002;
    public static final int STATUS_START_AUTH_USER_CANCEL = 5001;
    public static final int STATUS_START_LIVE_ROOM = 8;
    public static final int STATUS_START_LIVE_ROOM_ONCREATE = 8001;
    public static final int STATUS_START_LIVE_ROOM_ONVIEW_CREATE = 8002;
    public static final int STATUS_START_LIVE_ROOM_START_LOAD_TK = 8003;
    public static final int STATUS_START_ORDER_PAGE = 10;
    public static final int STATUS_START_PAY = 11;
    private static final long serialVersionUID = 2414167612185500084L;
    public String authType;
    public int clickCancelTime;
    public boolean clickHasInnerecFailed;
    public boolean clickLiveCheckEnv;
    public boolean clickUserNowCancel;
    public String payErrorMsg;
    public String payExtData;
    public String payMerchantId;
    public String payOrderNo;
    public int payOriginalResultCode;

    public static InnerEcEvent copyFrom(InnerEcEvent innerEcEvent) {
        InnerEcEvent innerEcEvent2 = new InnerEcEvent();
        try {
            innerEcEvent2.parseJson(innerEcEvent.toJson());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return innerEcEvent2;
    }

    public static InnerEcEvent createAdClickEvent(AdTemplate adTemplate) {
        InnerEcEvent innerEcEventCreateCommonEvent = createCommonEvent(adTemplate, 2);
        innerEcEventCreateCommonEvent.clickCancelTime = com.kwad.components.core.innerEc.local.a.getCancelCount();
        innerEcEventCreateCommonEvent.clickLiveCheckEnv = b.ru();
        innerEcEventCreateCommonEvent.clickHasInnerecFailed = adTemplate.hasInnerEcFailed();
        return innerEcEventCreateCommonEvent;
    }

    public static InnerEcEvent createCommonEvent(AdTemplate adTemplate, int i) {
        InnerEcEvent innerEcEvent = new InnerEcEvent();
        innerEcEvent.status = i;
        innerEcEvent.setAdTemplate(adTemplate);
        return innerEcEvent;
    }

    public static InnerEcEvent createEmptyEvent(AdTemplate adTemplate) {
        InnerEcEvent innerEcEvent = new InnerEcEvent();
        innerEcEvent.setAdTemplate(adTemplate);
        return innerEcEvent;
    }

    @Override // com.kwad.components.core.innerEc.logger.BaseInnerEcMsg, com.kwad.sdk.core.response.a.a
    public String toString() {
        return super.toString();
    }
}
