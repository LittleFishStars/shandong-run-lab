package com.kc.aw.lib.constants;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgErrorCode {
    public static final String ILLEGAL_PATH = "404 not found";
    public static final String ILLEGAL_REQUEST = "400 无效的请求";
    public static final String ILLEGAL_SERVER = "502 Bad Gateway";
    public static final int LOAD_AD_SUC = 0;
    public static final String PACKAGE_NAME_ERROR_STR = "包名校验失败，请检查包名！";
    public static final int SDK_AD_DATA_ERR = 50028;
    public static final int SDK_AD_SLOT_ERR = 50027;
    public static final int SDK_AD_STYLE_ERR = 50029;
    public static final int SDK_BELOW_BASE_PRICE = 50024;
    public static final String SDK_BELOW_BASE_PRICE_STR = "广告价格低于底价！";
    public static final int SDK_CLICK_ERR = 60001;
    public static final String SDK_CLICK_ERR_MSG1 = "不支持的点击类型！";
    public static final int SDK_CONTEXT_ERROR = 50022;
    public static final int SDK_DP_PERMISSION_PROHIBIT = 50013;
    public static final int SDK_FORBID_AD = 10001;
    public static final int SDK_INIT = 50006;
    public static final String SDK_INIT_1 = "消耗源未初始化";
    public static final int SDK_INTERNAL = -1;
    public static final int SDK_INTERNAL_ERROR = 50008;
    public static final String SDK_INTERNAL_ERR_MSG1 = "当前网络异常！";
    public static final int SDK_LOAD_ERROR = 50020;
    public static final int SDK_NET_ERR = 50026;
    public static final int SDK_NOT_READY = 50003;
    public static final int SDK_NOT_SUPPORT = 50012;
    public static final int SDK_NOT_USED = 50005;
    public static final int SDK_NO_AD = 10000;
    public static final String SDK_NO_AD_1 = "无广告！";
    public static final String SDK_NO_AD_2 = "请求成功，无广告！";
    public static final int SDK_NO_MATCHED_POLICY = 50018;
    public static final int SDK_NO_SUPPORT = 50021;
    public static final int SDK_NULL_COEDID = 50002;
    public static final int SDK_NULL_PROVIDER = 50001;
    public static final int SDK_PACKAGE_NAME_ERROR = 50023;
    public static final int SDK_PARAM_ERR = 50000;
    public static final int SDK_RENDER_ERROR = 50007;
    public static final String SDK_RENDER_ERROR_1 = "渲染失败！";
    public static final String SDK_RENDER_ERROR_2 = "媒体传入广告容器异常！";
    public static final String SDK_RENDER_ERROR_3 = "消耗源广告视图异常！";
    public static final String SDK_RENDER_ERROR_4 = "消耗源广告对象异常！";
    public static final String SDK_RENDER_ERROR_5 = "广告资源已过期！请获取最新广告资源。";
    public static final String SDK_RENDER_ERROR_6 = "广告数据为空，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_7 = "广告位类型不合法，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_8 = "广告样式不合法，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_9 = "广告布局异常，请重试！";
    public static final int SDK_RENDER_ERROR_BECAUSE_NO_AD_CONTAINER = 50016;
    public static final int SDK_REQUEST_INTERRUPT_BECAUSE_PARAMS_MISS = 50015;
    public static final int SDK_REQUEST_OVER_TIME = 50014;
    public static final int SDK_RESOURCE_ERROR = 50009;
    public static final String SDK_RESOURCE_ERR_MSG1 = "资源数据异常！";
    public static final String SDK_RESOURCE_ERR_MSG2 = "资源检测异常！";
    public static final String SDK_RESOURCE_ERR_MSG3 = "广告资源异常！";
    public static final int SDK_SECURITY_ERROR = 50010;
    public static final int SDK_SPLASH_SINGLE_ERROR = 50019;
    public static final int SDK_THIRD_ERROR = 50017;
    public static final int SDK_TIMEOUT = 50004;
    public static final int SDK_UNKNOWN = 50011;
    public static final int SDK_VIDEO_PLAY_ERR = 50025;
    public static final int WHAT_NO_SUPPORT = 10;
    public static final int WHERE_LOAD = 8;
    public static final int WHO_APP = 101;
    public static final int WHO_SLOT = 102;

    public static String AD_DATA_ERROR() {
        return "广告数据为空！";
    }

    public static String AD_OBJ_ERROR() {
        return "广告对象为空！";
    }

    public static String AD_SLOT_ERROR() {
        return "广告Slot为空！";
    }

    public static String AD_STYLE_ERROR() {
        return SDK_RENDER_ERROR_8;
    }

    public static String AD_STYLE_ERROR_DEBUG() {
        return "广告样式(%s,%s,%s)不合法，请联系平台处理！";
    }

    public static String APP_NETWORK_ERROR() {
        return "网络异常!";
    }

    public static String APP_SLOT_ERROR() {
        return "slotId 或 apiId 不能为空!";
    }
}
