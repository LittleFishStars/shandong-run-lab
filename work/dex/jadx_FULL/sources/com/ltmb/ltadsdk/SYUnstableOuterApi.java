package com.ltmb.ltadsdk;

import com.aliyun.vod.log.core.AliyunLogCommon;
import com.heytap.mcssdk.constant.b;
import com.ltmb.ltadsdk.api.AdBidLossInfo;
import com.ltmb.ltadsdk.api.ad.ClientBiddingAd;
import com.ltmb.ltadsdk.api.ad.SYAdCallable;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.h8;
import com.ltmb.ltadsdk.pkg.n0;
import com.ltmb.ltadsdk.pkg.o0;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SYUnstableOuterApi {
    public static String MEDIA_REQUEST_ID = "media_request_id";

    public static boolean enableSOUT() {
        return d9.a;
    }

    public static void notifyBidLossNoRec(AdBidLossInfo adBidLossInfo, String str, String str2, String str3, long j, Map<String, Object> map) {
        if (adBidLossInfo != null) {
            try {
                Intrinsics.checkNotNullParameter(adBidLossInfo, AliyunLogCommon.LogLevel.INFO);
                Intrinsics.checkNotNullParameter(str, "sdk");
                Intrinsics.checkNotNullParameter(str2, "requestId");
                Intrinsics.checkNotNullParameter(str3, "slotId");
                try {
                    n0 n0Var = new n0();
                    n0Var.d = str3;
                    n0Var.m = j;
                    n0Var.z = str2;
                    n0Var.a = str2;
                    n0Var.a("aggsdk", str);
                    if (map != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            n0Var.a(entry.getKey(), entry.getValue());
                        }
                    }
                    n0Var.g = adBidLossInfo.getType();
                    n0Var.a("winprice", adBidLossInfo.getPrice());
                    n0Var.a("winadn", adBidLossInfo.getCom.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ADN_NAME java.lang.String());
                    Intrinsics.checkNotNullParameter("sdk_ad_bid_fail_norec", b.k);
                    Intrinsics.checkNotNullParameter(n0Var, "params");
                    o0.t.a().a("sdk_ad_bid_fail_norec", n0Var);
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
    }

    public static void onMediaLoad(ClientBiddingAd clientBiddingAd, Map<String, Object> map) {
        if (clientBiddingAd == null) {
            return;
        }
        try {
            if (clientBiddingAd instanceof SYAdCallable) {
                ((SYAdCallable) clientBiddingAd).onMediaLoadAd(map);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static String onMediaRequest(String str, String str2, Map<String, Object> map) {
        try {
            String strA = h8.a.a();
            Intrinsics.checkNotNullParameter(strA, "requestId");
            Intrinsics.checkNotNullParameter(str, "sdk");
            Intrinsics.checkNotNullParameter(str2, "slotId");
            try {
                n0 n0Var = new n0();
                n0Var.a("aggsdk", str);
                n0Var.d = str2;
                n0Var.z = strA;
                n0Var.a = strA;
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        n0Var.a(entry.getKey(), entry.getValue());
                    }
                }
                Intrinsics.checkNotNullParameter("sdk_media_req", b.k);
                Intrinsics.checkNotNullParameter(n0Var, "params");
                o0.t.a().a("sdk_media_req", n0Var);
            } catch (Throwable unused) {
            }
            return strA;
        } catch (Throwable th) {
            d9.d.a(th);
            return "";
        }
    }

    public static void onReceiveAd(ClientBiddingAd clientBiddingAd, long j, long j2, long j3) {
        onReceiveAd(clientBiddingAd, j, j2, j3, null);
    }

    public static void onReceiveAdClick(ClientBiddingAd clientBiddingAd, Map<String, Object> map) {
        if (clientBiddingAd == null) {
            return;
        }
        try {
            if (clientBiddingAd instanceof SYAdCallable) {
                ((SYAdCallable) clientBiddingAd).onMediaReceiveAdClick(map);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static void onReceiveAdShow(ClientBiddingAd clientBiddingAd, Map<String, Object> map) {
        if (clientBiddingAd == null) {
            return;
        }
        try {
            if (clientBiddingAd instanceof SYAdCallable) {
                ((SYAdCallable) clientBiddingAd).onMediaReceiveAdShow(map);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static void onThirdAggSdkInitFail(String str, long j, int i, String str2, String str3, String str4) {
        try {
            HashMap map = new HashMap();
            map.put("aggadapterver", str3);
            map.put("aggsdkver", str4);
            Intrinsics.checkNotNullParameter(str, "sdk");
            try {
                n0 n0Var = new n0();
                n0Var.a("aggsdk", str);
                n0Var.a("success", Boolean.FALSE);
                n0Var.a("cost", Long.valueOf(j));
                n0Var.a("code", Integer.valueOf(i));
                if (str2 == null) {
                    str2 = "";
                }
                n0Var.a("msg", str2);
                for (Map.Entry entry : map.entrySet()) {
                    n0Var.a((String) entry.getKey(), entry.getValue());
                }
                Intrinsics.checkNotNullParameter("sdk_third_agg_init", b.k);
                Intrinsics.checkNotNullParameter(n0Var, "params");
                o0.t.a().a("sdk_third_agg_init", n0Var);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static void onThirdAggSdkInitSuccess(String str, long j, String str2, String str3) {
        try {
            HashMap map = new HashMap();
            map.put("aggadapterver", str2);
            map.put("aggsdkver", str3);
            Intrinsics.checkNotNullParameter(str, "sdk");
            try {
                n0 n0Var = new n0();
                n0Var.a("aggsdk", str);
                n0Var.a("success", Boolean.TRUE);
                n0Var.a("cost", Long.valueOf(j));
                n0Var.a("code", 0);
                n0Var.a("msg", "");
                for (Map.Entry entry : map.entrySet()) {
                    n0Var.a((String) entry.getKey(), entry.getValue());
                }
                Intrinsics.checkNotNullParameter("sdk_third_agg_init", b.k);
                Intrinsics.checkNotNullParameter(n0Var, "params");
                o0.t.a().a("sdk_third_agg_init", n0Var);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static void sout(String str) {
        d9.d.a(str);
    }

    public static void onReceiveAd(ClientBiddingAd clientBiddingAd, long j, long j2, long j3, Map<String, Object> map) {
        if (clientBiddingAd == null) {
            return;
        }
        try {
            if (clientBiddingAd instanceof SYAdCallable) {
                d9.d.a("onReceiveAd");
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("aggrequesttime", Long.valueOf(j));
                map.put("agginitsuctime", Long.valueOf(j2));
                map.put("aggreceivertime", Long.valueOf(j3));
                ((SYAdCallable) clientBiddingAd).onMediaReceiveAd(map);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public static void sout(Throwable th) {
        d9.d.a(th);
    }
}
