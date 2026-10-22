package com.fl.saas.adx.util;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.fl.saas.C1428p0;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.b1;
import com.zj.adlib.c49;
import com.zj.adlib.co1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommConstant {
    private static final String TAG = "FLSDK";

    public static class API {
        public static final String ApiVersion = "4.4";
        private static final String HOST_INIT = "http://39.107.124.86/";
        public static final String NEW_API_BID = "http://s.funlinkads.com/ad/ad";
        public static final String NEW_INIT = "https://t.funlinkads.com/log/initialization";
        public static final String NEW_VIDEO_SERVER_VERIFY = "http://s.funlinkads.com/server/serverVerify";
        public static final String REPORT_DP_EFFECT = "https://t.funlinkads.com/log/dpEffect";
        public static final String REPORT_DP_URL = "https://t.funlinkads.com/log/js_dpurl";
        public static final String REPORT_KEYWORD = "https://t.funlinkads.com/log/ka_rep";
        public static final String URL_GET_DATA = "http://39.107.124.86/api/dp/content";
        public static final String URL_REQUEST = "http://39.107.124.86/api/dp/config";
        public static final String URL_WAKEUP_PLACES = "http://s.funlinkads.com/ad/bgWakeUpPlaces";
    }

    public static class ImageUrl {
        public static final String CLICK_AREA_BG = "https://creative.medproad.com/medpro/imgs/944e91c4ed73a3267d43f9b9eee5bea.png";
        public static final String CUSTOM_SPREAD_BG = "https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp";
        public static final String ENVELOP_BOTTOM = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_bottom.webp";
        public static final String ENVELOP_TOP = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_envelope_top.webp";
        public static final String FINGER_GUIDE = "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp";
        public static final String ICON_ALL_ARROW = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_all_arrow.webp";
        public static final String SPREAD_CLICK_BG = "https://creative.medproad.com/medpro/imgs/yd_saas_bg_click_area.webp";
    }

    public static class SdkVersion {
        public static final String SDK_PACKAGE_NAME = "com.fl.saas.adx";
        public static final String SDK_VERSION_CODE = "29105";
        public static final String SDK_VERSION_VALUE = "2.9.1";
    }

    public static String getClassTag(Class<?> cls) {
        return getClassTag(null, cls);
    }

    public static String getObjTag(Object obj) {
        if (obj != null) {
            return getClassTag(obj.getClass());
        }
        LogcatUtil.e(TAG, "getObjTag is NULL");
        return "FLSDK-NULL-Obj";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getClassTag$0() {
        return "getClassTag is NULL";
    }

    public static String getClassTag(String str, Class<?> cls) {
        StringBuilder sb = new StringBuilder(TAG);
        if (!TextUtils.isEmpty(str)) {
            sb.append(c49.f40900a);
            sb.append(str);
        }
        sb.append(c49.f40900a);
        sb.append((String) C1428p0.b(cls).a((Function) new co1()).b(new b1() { // from class: com.zj.adlib.do1
            @Override // com.fl.saas.b1
            public final Object a() {
                return CommConstant.lambda$getClassTag$0();
            }
        }));
        return sb.toString();
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
}
