package com.fl.saas.common.util;

import android.text.TextUtils;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.utils.LogcatUtil;
import com.zj.adlib.c49;
import com.zj.adlib.co1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommConstant {
    private static final String TAG = "YdSDK";

    public static class API {
        public static final String ApiVersion = "4.4";
        private static final String HOST_INIT = "http://39.107.124.86/";
        public static final String NEW_API_BID = "http://ads.adfunlink.com:8080/ad/api_bidding";
        public static final String NEW_C2S_BID = "http://adtracker.adfunlink.com/log/bid_response";
        public static final String NEW_CLICK = "http://adtracker.adfunlink.com/log/click";
        public static final String NEW_DISPLAY = "http://adtracker.adfunlink.com/log/impress";
        public static final String NEW_ERROR_NEW = "http://adtracker.adfunlink.com/log/error_response2";
        public static final String NEW_FILL = "http://adtracker.adfunlink.com/log/traffic_response";
        public static final String NEW_INIT = "http://adtracker.adfunlink.com/log/newInitialization";
        public static final String NEW_REQUEST_SHOW = "http://adtracker.adfunlink.com/log/trigger_impress";
        public static final String NEW_S2S = "http://ads.adfunlink.com:8080/ad/bid";
        public static final String NEW_S2S_BIDDING_REPORT = "http://adtracker.adfunlink.com/log/s2s_bidding_notice2";
        public static final String NEW_SDK_BID = "http://ads.adfunlink.com:8080/api/server_bidding";
        public static final String NEW_SDK_REQUSET = "http://adtracker.adfunlink.com/log/traffic_request";
        public static final String NEW_VIDEO_SERVER_VERIFY = "http://ads.adfunlink.com:8080/server/serverVerify";
        public static final String REPORT_BACKGROUND_SHOW_AD = "http://adtracker.adfunlink.com/log/adv_impress_background_merge_info";
        public static final String REPORT_DP_EFFECT = "http://adtracker.adfunlink.com/log/dpEffect";
        public static final String REPORT_DP_URL = "http://adtracker.adfunlink.com/log/js_dpurl";
        public static final String REPORT_KEYWORD = "http://adtracker.adfunlink.com/log/ka_rep";
        public static final String REPORT_MATERIAL = "http://adtracker.adfunlink.com/log/creative_collect";
        public static final String REQUEST_MERGE = "http://adtracker.adfunlink.com/log/adv_request_merge_info";
        public static final String RESPONSE_MERGE = "http://adtracker.adfunlink.com/log/adv_response_merge_info";
        public static final String UPLOAD_CRASH_URL = "http://adtracker.adfunlink.com/log/crash_log";
        public static final String URL_CONFIG_NEW = "http://ads.adfunlink.com:8080/server/newConfig";
        public static final String URL_GET_DATA = "http://39.107.124.86/api/dp/content";
        public static final String URL_REQUEST = "http://39.107.124.86/api/dp/config";
    }

    public static class ImageUrl {
        public static final String CLICK_AREA_BG = "https://creative.medproad.com/medpro/imgs/944e91c4ed73a3267d43f9b9eee5bea.png";
        public static final String CUSTOM_SPREAD_BG = "https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp";
        public static final String ENVELOP_BOTTOM = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_bottom.webp";
        public static final String ENVELOP_TOP = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_top.webp";
        public static final String FINGER_GUIDE = "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp";
        public static final String ICON_ALL_ARROW = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_all_arrow.webp";
        public static final String ICON_RAIN1 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_rain_1.webp";
        public static final String ICON_RAIN2 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_rain_2.webp";
        public static final String ICON_RAIN3 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_rain_3.webp";
        public static final String ICON_RAIN4 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_rain_4.webp";
        public static final String ICON_RAIN5 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_rain_5.webp";
        public static final String SPREAD_CLICK_BG = "https://creative.medproad.com/medpro/imgs/yd_saas_bg_click_area.webp";
    }

    public static class ReportType {
        public static final int C2S_BIDDING = 10;
        public static final int CLICK = 2;
        public static final int DISPLAY = 1;
        public static final int REQUEST_SHOW = 9;
        public static final int SDK_REQUEST = 8;
    }

    public static class SdkVersion {
        public static final String SDK_PACKAGE_NAME = "com.yd.saas";
        public static final String SDK_VERSION_CODE = "29004";
        public static final String SDK_VERSION_KEY = "sdkVersion";
        public static final String SDK_VERSION_VALUE = "2.9.0";
    }

    public static String getClassTag(Class<?> cls) {
        return getClassTag(null, cls);
    }

    public static String getClassTag(String str, Class<?> cls) {
        StringBuilder sb = new StringBuilder(TAG);
        if (!TextUtils.isEmpty(str)) {
            sb.append(c49.f40900a);
            sb.append(str);
        }
        sb.append(c49.f40900a);
        sb.append((String) Optional.ofNullable(cls).map(new co1()).orElseGet(new Supplier() { // from class: com.zj.adlib.bo1
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                return CommConstant.lambda$getClassTag$0();
            }
        }));
        return sb.toString();
    }

    public static String getObjTag(Object obj) {
        if (obj != null) {
            return getClassTag(obj.getClass());
        }
        LogcatUtil.e(TAG, "getObjTag is NULL");
        return "YdSDK-NULL-Obj";
    }

    public static String getObjTag(String str, Object obj) {
        if (obj != null) {
            return getClassTag(str, obj.getClass());
        }
        LogcatUtil.e(TAG, "getObjTag is NULL");
        StringBuilder sb = new StringBuilder(TAG);
        if (!TextUtils.isEmpty(str)) {
            sb.append(c49.f40900a);
            sb.append(str);
        }
        sb.append("-NULL-Obj");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getClassTag$0() {
        return "getClassTag is NULL";
    }
}
