package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class i {
    public static String EI() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.Mo().Z("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return str;
    }

    private static String EJ() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.Mo().Z("eapi", "api.e.kuaishou.com");
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return str;
    }

    public static String EK() {
        return EI() + "/rest/e/v3/open/univ";
    }

    public static String EL() {
        return EI() + "/rest/e/v4/open/univ";
    }

    public static String EM() {
        return EI() + "/rest/e/open/user/follow";
    }

    public static String EN() {
        return EJ() + "/rest/e/v1/x7coupon/receive";
    }

    public static String EO() {
        return EI() + "/rest/e/v4/open/univ/bidding";
    }

    public static String EP() {
        return EI() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String EQ() {
        return EI() + "/rest/e/v3/open/logBatch";
    }

    public static String ER() {
        return EI() + "/rest/e/v3/open/config";
    }

    public static String ES() {
        return EI() + "/rest/e/v3/open/callback";
    }

    public static String ET() {
        return EI() + "/rest/e/v3/open/crashLog";
    }

    public static String EU() {
        return EI() + "/rest/e/v3/open/appCheck";
    }

    public static String EV() {
        return EI() + "/rest/e/v3/open/collect";
    }

    public static String EW() {
        return EI() + "/rest/e/v3/open/checkReward";
    }

    public static String EX() {
        return EI() + "/rest/e/v3/open/rewardFraudVerify";
    }

    public static String EY() {
        return EI() + "/rest/e/v3/open/kwaiGeoLocation";
    }

    public static String EZ() {
        return EI() + "/rest/e/v3/open/getMiMarketUrl";
    }

    public static String Fa() {
        return EI() + "/rest/e/v3/open/user/auth";
    }

    public static String Fb() {
        return "https://style-browse-openapi.test.gifshow.com//rest/e/internal/adBrowse";
    }

    public static String Fc() {
        return EI() + "/rest/e/v3/open/conversionStatus";
    }

    public static String Fd() {
        return EI() + "/rest/e/v3/open/uaid";
    }

    public static String Fe() {
        return "https://msg.cmpassport.com/h5/uaidAdGetMobile";
    }

    public static String Ff() {
        return EI() + "/rest/e/v3/open/sdk/warmup";
    }

    public static String Fg() {
        return EI() + "/rest/e/open/live/like/send";
    }

    public static String Fh() {
        return EI() + "/rest/e/open/live/comment/history";
    }

    public static String Fi() {
        return EI() + "/rest/e/open/live/comment/send";
    }

    public static String Fj() {
        return EI() + "/rest/e/open/live/startPlay";
    }

    public static String Fk() {
        return EI() + "/rest/e/open/live/stop";
    }

    public static String Fl() {
        return EI() + "/rest/e/open/live/newPlayurl";
    }

    public static String Fm() {
        return EI() + "/rest/e/open/emotion/package";
    }

    public static String cN(String str) {
        return str + "/rest/e/system/speed";
    }
}
