package com.kwad.components.core.innerEc.logger;

import com.kwad.components.core.offline.b.a.q;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.crash.b;
import com.kwai.adclient.kscommerciallogger.model.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static void a(InnerEcEvent innerEcEvent) {
        try {
            InnerEcEvent innerEcEventCopyFrom = InnerEcEvent.copyFrom(innerEcEvent);
            innerEcEventCopyFrom.status = 10;
            b(innerEcEventCopyFrom);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aP(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 1));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aQ(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 4));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aR(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 5));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aS(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 8));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aT(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 8001));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aU(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 8002));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aV(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 8003));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void aW(AdTemplate adTemplate) {
        try {
            b(InnerEcEvent.createCommonEvent(adTemplate, 9));
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void b(InnerEcEvent innerEcEvent, q qVar) {
        try {
            InnerEcEvent innerEcEventCopyFrom = InnerEcEvent.copyFrom(innerEcEvent);
            innerEcEventCopyFrom.status = 12;
            innerEcEventCopyFrom.payOrderNo = qVar.acq;
            innerEcEventCopyFrom.payMerchantId = qVar.acr;
            innerEcEventCopyFrom.payOriginalResultCode = qVar.acs;
            innerEcEventCopyFrom.payExtData = qVar.act;
            b(innerEcEventCopyFrom);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void c(InnerEcEvent innerEcEvent, q qVar) {
        try {
            InnerEcEvent innerEcEventCopyFrom = InnerEcEvent.copyFrom(innerEcEvent);
            innerEcEventCopyFrom.status = 13;
            innerEcEventCopyFrom.payErrorMsg = qVar.errorMsg;
            innerEcEventCopyFrom.payOrderNo = qVar.acq;
            innerEcEventCopyFrom.payMerchantId = qVar.acr;
            innerEcEventCopyFrom.payOriginalResultCode = qVar.acs;
            innerEcEventCopyFrom.payExtData = qVar.act;
            b(innerEcEventCopyFrom);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void d(AdTemplate adTemplate, boolean z) {
        try {
            InnerEcEvent innerEcEventCreateAdClickEvent = InnerEcEvent.createAdClickEvent(adTemplate);
            innerEcEventCreateAdClickEvent.clickUserNowCancel = z;
            b(innerEcEventCreateAdClickEvent);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void f(AdTemplate adTemplate, int i, String str) {
        try {
            InnerEcError innerEcErrorCreateCommonError = InnerEcError.createCommonError(adTemplate, 2);
            innerEcErrorCreateCommonError.errorCode = i;
            innerEcErrorCreateCommonError.errorMsg = str;
            a(innerEcErrorCreateCommonError);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void h(AdTemplate adTemplate, String str) {
        try {
            InnerEcEvent innerEcEventCreateCommonEvent = InnerEcEvent.createCommonEvent(adTemplate, 5001);
            innerEcEventCreateCommonEvent.authType = str;
            b(innerEcEventCreateCommonEvent);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void i(AdTemplate adTemplate, String str) {
        try {
            InnerEcEvent innerEcEventCreateCommonEvent = InnerEcEvent.createCommonEvent(adTemplate, 5002);
            innerEcEventCreateCommonEvent.authType = str;
            b(innerEcEventCreateCommonEvent);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void j(AdTemplate adTemplate, String str) {
        try {
            InnerEcEvent innerEcEventCreateCommonEvent = InnerEcEvent.createCommonEvent(adTemplate, 6);
            innerEcEventCreateCommonEvent.authType = str;
            b(innerEcEventCreateCommonEvent);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void k(AdTemplate adTemplate, String str) {
        try {
            InnerEcEvent innerEcEventCreateCommonEvent = InnerEcEvent.createCommonEvent(adTemplate, 7);
            innerEcEventCreateCommonEvent.authType = str;
            b(innerEcEventCreateCommonEvent);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void l(AdTemplate adTemplate, String str) {
        try {
            InnerEcError innerEcErrorCreateCommonError = InnerEcError.createCommonError(adTemplate, 3);
            innerEcErrorCreateCommonError.errorMsg = str;
            a(innerEcErrorCreateCommonError);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void m(AdTemplate adTemplate, String str) {
        try {
            InnerEcError innerEcErrorCreateCommonError = InnerEcError.createCommonError(adTemplate, 1);
            innerEcErrorCreateCommonError.errorUrl = str;
            a(innerEcErrorCreateCommonError);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void a(InnerEcEvent innerEcEvent, q qVar) {
        try {
            InnerEcEvent innerEcEventCopyFrom = InnerEcEvent.copyFrom(innerEcEvent);
            innerEcEventCopyFrom.status = 11;
            innerEcEventCopyFrom.payOrderNo = qVar.acq;
            innerEcEventCopyFrom.payMerchantId = qVar.acr;
            b(innerEcEventCopyFrom);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void h(AdTemplate adTemplate, int i) {
        try {
            InnerEcError innerEcErrorCreateCommonError = InnerEcError.createCommonError(adTemplate, 1);
            innerEcErrorCreateCommonError.errorCode = i;
            a(innerEcErrorCreateCommonError);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    private static void b(InnerEcEvent innerEcEvent) {
        try {
            c.w("InnerEcCLogger", "reportInnerEcEvent:" + innerEcEvent);
            com.kwad.sdk.commercial.c.b(false, (com.kwad.sdk.commercial.c.a) innerEcEvent, d.bvc);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    public static void a(InnerEcError innerEcError, q qVar) {
        try {
            InnerEcError innerEcErrorCopyFrom = InnerEcError.copyFrom(innerEcError);
            innerEcErrorCopyFrom.status = 5;
            innerEcErrorCopyFrom.payErrorMsg = qVar.errorMsg;
            innerEcErrorCopyFrom.payOrderNo = qVar.acq;
            innerEcErrorCopyFrom.payMerchantId = qVar.acr;
            innerEcErrorCopyFrom.payOriginalResultCode = qVar.acs;
            innerEcErrorCopyFrom.payExtData = qVar.act;
            a(innerEcErrorCopyFrom);
        } catch (Throwable th) {
            b.u(th);
        }
    }

    private static void a(InnerEcError innerEcError) {
        try {
            c.w("InnerEcCLogger", "reportInnerEcError:" + innerEcError);
            com.kwad.sdk.commercial.c.b(true, (com.kwad.sdk.commercial.c.a) innerEcError, d.bvc);
        } catch (Throwable th) {
            b.u(th);
        }
    }
}
