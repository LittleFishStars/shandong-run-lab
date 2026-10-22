package com.kc.openset.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ErrorManager {
    public static final int ADV_ERROR_CODE_EVENT_REPORT_FAIL = 73099;
    public static final int ADV_ERROR_CODE_HTTP_REQUEST_FAIL = 73020;
    public static final int ADV_ERROR_CODE_MATERIAL_RENDER_FAIL = 73001;
    public static final int ADV_ERROR_CODE_RESULT_DATA_ERROR = 73024;
    public static final int ADV_ERROR_CODE_RESULT_PARSE_FAIL = 73023;
    public static final int ADV_ERROR_CODE_VIDEO_PLAY_FAIL = 73002;
    public static final int ADV_ERROR_CODE_VIEW_CREATE_FAIL = 73000;
    public static final int SS_ERROR_CODE_ACTIVITY_IS_UNSAFE = 70009;
    public static final int SS_ERROR_CODE_AD_CACHE_FAIL = 70037;
    public static final int SS_ERROR_CODE_AD_CONFIG_EXCEPTION = 70047;
    public static final int SS_ERROR_CODE_AD_FILTER = 70063;
    public static final int SS_ERROR_CODE_AD_GROUP_OR_ALL_TIMEOUT_EXCEPTION = 70048;
    public static final int SS_ERROR_CODE_AD_IS_EXPIRED = 70050;
    public static final int SS_ERROR_CODE_AD_IS_SHOWED = 70049;
    public static final int SS_ERROR_CODE_AD_LOAD_EXCEPTION = 70015;
    public static final int SS_ERROR_CODE_AD_LOAD_FAIL = 70002;
    public static final int SS_ERROR_CODE_AD_LOAD_FAIL_OBJ_IS_NULL = 70020;
    public static final int SS_ERROR_CODE_AD_LOAD_TIMEOUT = 70038;
    public static final int SS_ERROR_CODE_AD_PRE_LOAD_FAIL = 70036;
    public static final int SS_ERROR_CODE_AD_RENDER_FAIL = 70028;
    public static final int SS_ERROR_CODE_AD_RETURN_TYPE_ERROR = 70033;
    public static final int SS_ERROR_CODE_APPLICATION_ERROR = 70065;
    public static final int SS_ERROR_CODE_APP_CRASH_ERROR = 70099;
    public static final int SS_ERROR_CODE_BIDDING_AD_GET_ECPM_EXCEPTION = 70035;
    public static final int SS_ERROR_CODE_BIDDING_AD_GET_ECPM_OBJ_IS_NULL = 70043;
    public static final int SS_ERROR_CODE_BID_FAIL_ADN_ERROR_REPORT = 70019;
    public static final int SS_ERROR_CODE_BID_FAIL_ERROR_REPORT = 70017;
    public static final int SS_ERROR_CODE_BID_SUCCESS_ADN_ERROR_REPORT = 70018;
    public static final int SS_ERROR_CODE_BID_SUCCESS_ERROR_REPORT = 70016;
    public static final int SS_ERROR_CODE_CALL_BACK_OBJ_IS_NULL = 70004;
    public static final int SS_ERROR_CODE_CALL_REWARD_BUT_NOT_VERIFY = 70032;
    public static final int SS_ERROR_CODE_DEEPLINK_OPT_ERROR = 70066;
    public static final int SS_ERROR_CODE_EN_OR_DE_FAIL = 70014;
    public static final int SS_ERROR_CODE_EXEC_START_ACTIVITY_ERROR = 70059;
    public static final int SS_ERROR_CODE_HL_AD_INFO_GET_ERROR = 70057;
    public static final int SS_ERROR_CODE_HOOK_ERROR = 70064;
    public static final int SS_ERROR_CODE_HOOK_INVOKE_METHOD_EXCEPTION = 70062;
    public static final int SS_ERROR_CODE_HTTP_REQUEST_FAIL = 70001;
    public static final int SS_ERROR_CODE_IMAGE_LOAD_FAIL = 70056;
    public static final int SS_ERROR_CODE_INIT_CONFIG_IS_NULL = 70044;
    public static final int SS_ERROR_CODE_KS_JSON_PARSE_ERROR = 70052;
    public static final int SS_ERROR_CODE_LIFECYCLE_LISTENER_ERROR = 70067;
    public static final int SS_ERROR_CODE_LOAD_INIT_REQUEST_FAIL = 70021;
    public static final int SS_ERROR_CODE_LOAD_INIT_RESULT_FAIL = 70022;
    public static final int SS_ERROR_CODE_NATIVE_VIEW_VIEW_CONFIG_IS_NULL = 70051;
    public static final int SS_ERROR_CODE_NETWORK_FAILED = 70003;
    public static final int SS_ERROR_CODE_NOT_SUPPORT_AD_TYPE = 70025;
    public static final int SS_ERROR_CODE_NO_INIT_OR_INIT_FAIL = 70008;
    public static final int SS_ERROR_CODE_OAID_LOAD_FAIL = 70042;
    public static final int SS_ERROR_CODE_PINE_CLICK_EXT_CHANGE_JSON_ERROR = 70054;
    public static final int SS_ERROR_CODE_PINE_CLICK_FLOW_ERROR = 70055;
    public static final int SS_ERROR_CODE_PINE_HOOK_ERROR = 70053;
    public static final int SS_ERROR_CODE_PINE_INIT_ERROR = 70058;
    public static final int SS_ERROR_CODE_POS_ID_IS_EMPTY = 70006;
    public static final int SS_ERROR_CODE_RENDER_SUCCESS_BUT_AD_OBJ_IS_NULL = 70034;
    public static final int SS_ERROR_CODE_REQUEST_INFO_MISS = 70029;
    public static final int SS_ERROR_CODE_REQUEST_VIEW_TYPE_ERROR = 70030;
    public static final int SS_ERROR_CODE_RESULT_DATA_ERROR = 70024;
    public static final int SS_ERROR_CODE_RESULT_PARSE_FAIL = 70023;
    public static final int SS_ERROR_CODE_REWARD_CALLBACK_CHECK_FAIL = 70046;
    public static final int SS_ERROR_CODE_REWARD_CALLBACK_INIT_FAIL = 70045;
    public static final int SS_ERROR_CODE_S2S_TOKEN_ERROR = 70069;
    public static final int SS_ERROR_CODE_SDK_CRASH_ERROR = 70098;
    public static final int SS_ERROR_CODE_SHOW_FAIL_CONTAINER_IS_INVISIBLE = 70027;
    public static final int SS_ERROR_CODE_SHOW_FAIL_CONTAINER_IS_NULL = 70026;
    public static final int SS_ERROR_CODE_SHOW_FAIL_NO_ADN_INFO = 70031;
    public static final int SS_ERROR_CODE_TAKU_HOOK_EXCEPTION = 70060;
    public static final int SS_ERROR_CODE_TAKU_HOOK_REPLACE_PRICE_UPLOAD_EXCEPTION = 70061;
    public static final int SS_ERROR_CODE_THREAD_SWITCHING_EXCEPTION = 70005;
    public static final int SS_ERROR_CODE_VIDEO_CONTENT_CONFIG_ERROR = 70039;
    public static final int SS_ERROR_CODE_VIDEO_CONTENT_NET_CONFIG_ERROR = 70040;
    public static final int SS_ERROR_CODE_VIDEO_CONTENT_TUBE_UNLOCK_ERROR = 70041;
    public static final int SS_ERROR_CODE_WEBVIEW_ERROR = 70068;
    public static final int SS_INIT_REQUEST_ERROR_CODE = 70000;
    public static final int TAP_ERROR_CODE_RESULT_EXCEPTION = 71001;
    public static final int TAP_ERROR_CODE_RESULT_NO_AD = 71002;
    public static final int TAP_ERROR_CODE_RESULT_PARSE_FAIL = 71003;
    public static final String ERROR_MESSAGE_NETWORK_FAILED = OSETSDKProtected.getString2(3081);
    public static final String SS_ERROR_MESSAGE_AD_LOAD_FAIL = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_CLICK = OSETSDKProtected.getString2(437);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_CLOSE = OSETSDKProtected.getString2(438);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_DETAIL_VIEW_CLOSED = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_ERROR = OSETSDKProtected.getString2(WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_LIKE);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_LOAD = OSETSDKProtected.getString2(406);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_FAIL = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_SUCCESS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_VIDEO_COMPLETE = OSETSDKProtected.getString2(441);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_VIDEO_CONTINUE = OSETSDKProtected.getString2(442);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_VIDEO_PAUSE = OSETSDKProtected.getString2(443);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_RENDER_VIDEO_START = OSETSDKProtected.getString2(WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_DETAIL_LIKE);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_REWARD = OSETSDKProtected.getString2(460);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_SHOW = OSETSDKProtected.getString2(439);
    public static final String SS_ERROR_MESSAGE_CALL_BACK_OBJ_IS_NULL_SKIP = OSETSDKProtected.getString2(470);
    public static final String SS_ERROR_MESSAGE_NO_INIT_OR_INIT_FAIL = OSETSDKProtected.getString2(241);
    public static final String SS_ERROR_MESSAGE_POS_ID_IS_EMPTY = OSETSDKProtected.getString2(3082);

    static {
        OSETSDKProtected.interface11(4933);
    }

    public static native void requestErrorMessage(int i, String str);

    public static native void requestErrorMessage(int i, Throwable th);

    public static native void requestErrorMessage(String str, String str2);

    public static native void requestErrorMessage(String str, String str2, com.kc.openset.ad.e eVar);

    public static native void requestErrorMessage(String str, String str2, String str3);

    public static native void requestErrorMessage(String str, Throwable th);
}
