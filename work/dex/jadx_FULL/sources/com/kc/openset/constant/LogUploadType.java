package com.kc.openset.constant;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum LogUploadType {
    INIT_TRACK,
    OAID_TRACK,
    REQUEST_TRACK,
    REQUEST_SUCCESS_TRACK,
    REQUEST_RESULT_TRACK,
    IMP_TRACK,
    CLICK_TRACK,
    CLOSE_TRACK,
    USER_TRACK,
    ERROR_TRACK,
    REQUEST_ALL_TRACK,
    SKIP_TRACK,
    REWARD_TRACK,
    APPLICATION_LIST_TRACK,
    REWARD_LIFECYCLE_TRACK,
    IMP_USER_TRACK,
    REQUEST_USER_TRACK,
    KS_VIDEO_CONTENT_OPEN,
    TAP_TAP_REPORT_TRACK,
    TT_VIDEO_CONTENT_OPEN,
    BID_RESULT_TRACK,
    REWARD_CALLBACK_RESULT,
    ADV_IMP_TRACK,
    ADV_BIDDING_TRACK,
    ADV_CLICK_TRACK,
    ADV_TRACKING_TRACK,
    ADV_OPERATION_TRACK,
    DEEPLINK_REGEX_CHECK_PASS,
    DEEPLINK_REPLACE_RESULT;

    static {
        OSETSDKProtected.interface11(4408);
    }

    public static native LogUploadType valueOf(String str);

    public static native LogUploadType[] values();
}
