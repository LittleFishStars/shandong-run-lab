package com.bykv.vk.component.ttvideo.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface MediaPlayer {
    public static final int AE_CLIMITER = 1;
    public static final int AE_COMPRESSOR = 0;
    public static final int AUDIO_MASTER = 0;
    public static final int AVCOL_PRI_BT2020 = 9;
    public static final int AVCOL_PRI_BT709 = 1;
    public static final int AVCOL_PRI_UNSPECIFIED = 2;
    public static final int AVCOL_SPC_BT2020_CL = 10;
    public static final int AVCOL_SPC_BT2020_NCL = 9;
    public static final int AVCOL_SPC_BT709 = 1;
    public static final int AVCOL_SPC_UNSPECIFIED = 2;
    public static final int AVCOL_TRC_ARIB_STD_B67 = 18;
    public static final int AVCOL_TRC_BT709 = 1;
    public static final int AVCOL_TRC_SMPTE2084 = 16;
    public static final int AVCOL_TRC_UNSPECIFIED = 2;
    public static final int CACHE_LOADER = 4;
    public static final int CONSTRAST_IMAGE_ENHANCEMENT = 1;
    public static final int DEFAULT_IMAGE_ENHANCEMENT = 0;
    public static final int DISABLE_DECODE_EXTERN_INFO = 0;
    public static final int DISABLE_TEST_NET_SPEED_VALUE = -1;
    public static final int ENABLE_DECODE_EXTERN_INFO = 1;
    public static final int ENABLE_TEST_NET_SPEED_INTERVAL_VALUE = 1;
    public static final int ENABLE_TEST_NET_SPEED_VALUE = 0;
    public static final int FFMPEG_LOG_DEBUG = 48;
    public static final int FFMPEG_LOG_ERROR = 16;
    public static final int FFMPEG_LOG_TRACE = 56;
    public static final int FRC_DEFAULT = 1;
    public static final int FRC_DISABLE = 0;
    public static final int FRC_HIGH = 3;
    public static final int FRC_MEDIUM = 2;
    public static final int HTTP_LOADER = 0;
    public static final int IMAGE_LAYOUT_ASPECT_FILL = 2;
    public static final int IMAGE_LAYOUT_ASPECT_FIT = 0;
    public static final int IMAGE_LAYOUT_FROM_LEFT_UP = 3;
    public static final int IMAGE_LAYOUT_TO_FILL = 1;
    public static final int IS_LIVE_PLAY = 0;
    public static final int IS_OS_PLAYER = 0;
    public static final int IS_TT_IPC_PLAYER = 2;
    public static final int IS_TT_LITE_IPC_PLAYER = 4;
    public static final int IS_TT_LITE_PLAYER = 3;
    public static final int IS_TT_PLAYER = 1;
    public static final int IS_VOD_PLAY = 1;
    public static final int IsBreakpadCrashValue = 1;
    public static final int IsSimpleCrashValue = 0;
    public static final int LANCZOS_SCALE_VALUE = 1;
    public static final int LINEAR_SCALE_VALUE = 0;
    public static final int MEDIA_EXTERN_INFO_STREAM_INFO = 19;
    public static final int MEDIA_INFO_AUDIO_DECODE_STALL = -268435439;
    public static final int MEDIA_INFO_AUDIO_DEMUX_STALL = -268435441;
    public static final int MEDIA_INFO_AUDIO_PTS_BACK = -268435437;
    public static final int MEDIA_INFO_AUDIO_RENDER_STALL = 251658250;
    public static final int MEDIA_INFO_AUDIO_RENDER_START = 251658252;
    public static final int MEDIA_INFO_AVOUTSYNC_END = -268435406;
    public static final int MEDIA_INFO_AVOUTSYNC_START = -268435407;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BARRAGE_MASK_INFO = -268435392;

    @SuppressLint({"InlinedApi"})
    public static final int MEDIA_INFO_BUFFERING_END = 702;

    @SuppressLint({"InlinedApi"})
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_BUFFER_RECVED = 251658242;
    public static final int MEDIA_INFO_DECODER_START = -268435404;
    public static final int MEDIA_INFO_DEVICE_OPENED = 251658245;
    public static final int MEDIA_INFO_FIRST_FRAME_AFTER_SEEK = 251658248;
    public static final int MEDIA_INFO_FORMATER_START = -268435405;
    public static final int MEDIA_INFO_HTTP_REDIRECT = 251658241;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_POSITION_UPDATE = -268435438;
    public static final int MEDIA_INFO_PREBUFFERING_START = -268435408;
    public static final int MEDIA_INFO_ROTATION_CHANGED = 251658243;
    public static final int MEDIA_INFO_RTC_AUDIO_DECODE_STALL = -268435423;
    public static final int MEDIA_INFO_RTC_EVENT_NOTIFY = 43;
    public static final int MEDIA_INFO_RTC_LOG_INFO = 44;
    public static final int MEDIA_INFO_RTC_TRACE_INFO = 40;
    public static final int MEDIA_INFO_RTC_VIDEO_DECODE_STALL = -268435424;
    public static final int MEDIA_INFO_SAR_CHANGED = 251658246;
    public static final int MEDIA_INFO_SILENCE_DETECTED = 251658253;
    public static final int MEDIA_INFO_SOCKET_CONNECTRED = 251658240;
    public static final int MEDIA_INFO_SPEED_CHANGED = 251658247;
    public static final int MEDIA_INFO_SPSPPS_INFO = 33;
    public static final int MEDIA_INFO_STREAM_CHANGED = 251658244;
    public static final int MEDIA_INFO_SUBTITLE_INFO = -268435391;

    @SuppressLint({"InlinedApi"})
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_UNKNOWN = 1;

    @SuppressLint({"InlinedApi"})
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODE_STALL = -268435440;
    public static final int MEDIA_INFO_VIDEO_DEMUX_STALL = -268435442;
    public static final int MEDIA_INFO_VIDEO_READY_FOR_DISPLAY = -268435390;

    @SuppressLint({"InlinedApi"})
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_RENDER_STALL = 251658251;
    public static final int MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED = 251658249;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_PLAYER_AAC_CODEC_ID = 2;
    public static final int MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE = 254;
    public static final int MEDIA_PLAYER_ANR_CRASH_VALUE = 0;
    public static final int MEDIA_PLAYER_AUDIO_DECODER_WRITE_ERROR = -499978;
    public static final int MEDIA_PLAYER_AUDIO_TRACK_ENABLE_OPTION = 61;
    public static final int MEDIA_PLAYER_AUDIO_TRACK_VOICE_VALUE = 1;
    public static final int MEDIA_PLAYER_AUTO_TEST_CHANGED_TYPR_VALUE = 0;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_FFMPEG = 0;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_ID = 1;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_JX = 2;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_KSY = 1;
    public static final int MEDIA_PLAYER_BYTEVC2_CODEC_ID = 33;
    public static final int MEDIA_PLAYER_CRASHED_ERROR = -2139062143;
    public static final int MEDIA_PLAYER_CRASH_SIMPLE_VALUE = 1;
    public static final int MEDIA_PLAYER_DECRYPTION_KEY = 64;
    public static final int MEDIA_PLAYER_DECRYPTION_KEY_IS_NULL_ERROR = -499973;
    public static final int MEDIA_PLAYER_DEFAULT_RENDER = 49;
    public static final int MEDIA_PLAYER_DEFAULT_VOICE = 48;
    public static final int MEDIA_PLAYER_DRM_DECRYPT_FAILED = -499698;
    public static final int MEDIA_PLAYER_DRM_OPEN_FAILED = -499699;
    public static final int MEDIA_PLAYER_DUMMY_VOICE_VALUE = 2;
    public static final int MEDIA_PLAYER_EGL_VER_2 = 2;
    public static final int MEDIA_PLAYER_EGL_VER_3 = 3;
    public static final int MEDIA_PLAYER_H264_CODEC_ID = 0;
    public static final int MEDIA_PLAYER_HIJACK_MEDIA_TYPE_ERROR = -499970;
    public static final int MEDIA_PLAYER_HIJACK_VID_ERROR = -499972;
    public static final int MEDIA_PLAYER_HTTP_BAD_REQUEST_ERROR = -499899;
    public static final int MEDIA_PLAYER_HTTP_CONTENT_TYPE_IS_NOT_VALID_ERROR = -499891;
    public static final int MEDIA_PLAYER_HTTP_FORBIDEN_ERROR = -499897;
    public static final int MEDIA_PLAYER_HTTP_NOT_FOUND_ERROR = -499896;
    public static final int MEDIA_PLAYER_HTTP_OTHER_4xx_ERROR = -499894;
    public static final int MEDIA_PLAYER_HTTP_REDIRECT_ERROR = -499890;
    public static final int MEDIA_PLAYER_HTTP_SERVER_ERROR_ERROR = -499893;
    public static final int MEDIA_PLAYER_HTTP_UNAUTHORIZED_ERROR = -499898;
    public static final int MEDIA_PLAYER_HURRY_CATCH_TIME_VALUE = 0;
    public static final int MEDIA_PLAYER_HURRY_SKIP_TIME_VALUE = 1;
    public static final int MEDIA_PLAYER_INVALID_INPUT_DATA_ERROR = -499985;
    public static final int MEDIA_PLAYER_IS_MOBILE_NETWORK = 1;
    public static final int MEDIA_PLAYER_IS_OTHER_NETWORK = 2;
    public static final int MEDIA_PLAYER_IS_WIFI_NETWORK = 0;
    public static final int MEDIA_PLAYER_MEDIACODEC_DEVICE = 4;
    public static final int MEDIA_PLAYER_MP3_CODEC_ID = 3;
    public static final int MEDIA_PLAYER_NATIVEWINDOW_DEVICE = 1;
    public static final int MEDIA_PLAYER_NDK_CRASH_VALUE = 2;
    public static final int MEDIA_PLAYER_NONE_ERROR = 0;
    public static final int MEDIA_PLAYER_NOSETTING_RENDER_VALUE = 3;
    public static final int MEDIA_PLAYER_OPENGL_DEVICE = 0;
    public static final int MEDIA_PLAYER_OPEN_DECODER_ERROR = -499996;
    public static final int MEDIA_PLAYER_OPEN_DEVICE_ERROR = -499989;
    public static final int MEDIA_PLAYER_OPEN_OUTER_ERROR = -499993;
    public static final int MEDIA_PLAYER_OPEN_OUTLET_ERROR = -499992;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE = 174;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED = 175;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF = 610;
    public static final int MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE = 601;
    public static final int MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE = 650;
    public static final int MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD = 178;
    public static final int MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD = 176;
    public static final int MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD = 177;
    public static final int MEDIA_PLAYER_OPTION_ABR_PREDICT_VIDEO_BITRATE = 600;
    public static final int MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT = 179;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_ABR_STREAM_INFO = 147;
    public static final int MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT = 173;
    public static final int MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT = 253;
    public static final int MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END = 313;
    public static final int MEDIA_PLAYER_OPTION_AE_SRC_LUFS = 644;
    public static final int MEDIA_PLAYER_OPTION_AE_SRC_PEAK = 646;
    public static final int MEDIA_PLAYER_OPTION_AE_TAR_LUFS = 645;
    public static final int MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR = 231;
    public static final int MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC = 348;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_APPID = 512;
    public static final int MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC = 181;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_BUFFER_LENGTH = 73;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CHECK_INFO = 203;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID = 140;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CODEC_PROFILE = 402;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX = 519;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN = 603;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR = 222;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME = 632;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME = 631;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME = 623;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES = 637;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY = 306;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREGAIN = 303;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO = 305;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_THRESHOLD = 304;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE = 643;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME = 269;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME = 273;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME = 275;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR = 251;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE = 244;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME = 260;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD = 321;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME = 628;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME = 267;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME = 271;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE = 460;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TOTAL_CACHED_LEN = 639;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME = 268;
    public static final int MEDIA_PLAYER_OPTION_AUTO_ROTATION = 33;
    public static final int MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME = 624;
    public static final int MEDIA_PLAYER_OPTION_AVG_DOWNLOAD_BITRATE = 615;
    public static final int MEDIA_PLAYER_OPTION_AVG_PLAY_BITRATE = 614;
    public static final int MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH = 616;
    public static final int MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES = 461;
    public static final int MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT = 656;
    public static final int MEDIA_PLAYER_OPTION_AVPH_PARAMS = 941;
    public static final int MEDIA_PLAYER_OPTION_AVPTS_DIFF_LIST = 825;
    public static final int MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD = 347;
    public static final int MEDIA_PLAYER_OPTION_BACKGROUND_STATUS = 658;
    public static final int MEDIA_PLAYER_OPTION_BARRAGE_MASKURL = 612;
    public static final int MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN = 605;
    public static final int MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN = 604;
    public static final int MEDIA_PLAYER_OPTION_BIT_RATE = 171;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_BEFORE_FIRST_FRAME = 211;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_DATA_OF_MILLISECONDS = 86;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO = 310;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_TIMEOUT = 81;
    public static final int MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START = 609;
    public static final int MEDIA_PLAYER_OPTION_BYTEVC1_CODEC_TYPE = 67;
    public static final int MEDIA_PLAYER_OPTION_CACHE_DIR = 34;
    public static final int MEDIA_PLAYER_OPTION_CATCHUP_SPEED = 80;
    public static final int MEDIA_PLAYER_OPTION_CHANNELS = 553;
    public static final int MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET = 557;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME = 453;
    public static final int MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME = 452;
    public static final int MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME = 455;
    public static final int MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME = 456;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME = 457;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME = 451;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME = 450;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME = 454;
    public static final int MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT = 952;
    public static final int MEDIA_PLAYER_OPTION_COLOR_PRIMARIES = 911;
    public static final int MEDIA_PLAYER_OPTION_COLOR_SPACE = 910;
    public static final int MEDIA_PLAYER_OPTION_COLOR_TRC = 912;
    public static final int MEDIA_PLAYER_OPTION_CRASH_INFO = 5001;
    public static final int MEDIA_PLAYER_OPTION_CRASH_TEST = 22;
    public static final int MEDIA_PLAYER_OPTION_CRASH_TYPE = 26;
    public static final int MEDIA_PLAYER_OPTION_CURRENT_VOLUME = 53;
    public static final int MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD = 294;
    public static final int MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME = 93;
    public static final int MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD = 363;
    public static final int MEDIA_PLAYER_OPTION_DECODE_EXTERN_INFO = 52;
    public static final int MEDIA_PLAYER_OPTION_DECODE_FIRST_AUDIO_FRAME_TIME = 78;
    public static final int MEDIA_PLAYER_OPTION_DECODE_FIRST_VIDEO_FRAME_TIME = 77;
    public static final int MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME = 161;
    public static final int MEDIA_PLAYER_OPTION_DEC_CREATE_TIME = 626;
    public static final int MEDIA_PLAYER_OPTION_DEFAULT_AUDIO_BITRATE = 131;
    public static final int MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE = 130;
    public static final int MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE = 263;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME = 621;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME = 625;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD = 362;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE = 530;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START = 133;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM = 651;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS = 279;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT = 247;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_MC_REUSE = 401;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_PLAYER_STAYAWAKE = 5003;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME = 98;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_SHORT_SEEK = 201;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE = 564;
    public static final int MEDIA_PLAYER_OPTION_DNS_START_TIME = 622;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_DIALOG_ENHANCE = 703;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_END_POINTER = 701;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL = 706;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_PRESENTATION_ID = 705;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_REF_LEVEL = 704;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_VIRTUALIZER = 702;
    public static final int MEDIA_PLAYER_OPTION_DOWNLOAD_SPEED = 63;
    public static final int MEDIA_PLAYER_OPTION_DRM_CLOSE_ROOT_CHECK = 209;
    public static final int MEDIA_PLAYER_OPTION_DRM_DOWNGRADE = 208;
    public static final int MEDIA_PLAYER_OPTION_DRM_TYPE = 206;
    public static final int MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME = 346;
    public static final int MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS = 345;
    public static final int MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP = 539;
    public static final int MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK = 148;
    public static final int MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND = 183;
    public static final int MEDIA_PLAYER_OPTION_EMBELLISH_VOLUME_TIME = 64;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_ASYNC = 262;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK = 563;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIO_EFFECT = 302;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE = 655;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK = 613;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL = 296;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI = 334;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT = 317;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE = 611;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY = 680;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION = 681;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR = 172;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY = 556;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL = 361;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI = 372;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE = 648;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL = 360;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ = 560;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE = 514;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FALLBACK_SW_DEC = 257;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK = 823;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR = 324;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE = 242;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK = 640;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP = 292;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL = 657;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE = 241;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT = 370;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER = 542;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME = 649;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT = 291;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK = 641;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION = 368;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY = 215;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_QCOM_VPP = 212;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME = 299;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL = 323;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RTCPLAY = 800;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT = 515;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT = 248;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SHARP = 189;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM = 653;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG = 652;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY = 185;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER = 380;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUB = 618;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN = 316;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY = 561;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK = 333;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH = 642;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC = 558;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER = 284;
    public static final int MEDIA_PLAYER_OPTION_ERROR_CODE = 5000;
    public static final int MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM = 220;
    public static final int MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY = 559;
    public static final int MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING = 551;
    public static final int MEDIA_PLAYER_OPTION_FILE_FORMAT = 516;
    public static final int MEDIA_PLAYER_OPTION_FILE_SIZE = 517;
    public static final int MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION = 537;
    public static final int MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE = 536;
    public static final int MEDIA_PLAYER_OPTION_FIRST_PACKET_TIME = 70;
    public static final int MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME = 459;
    public static final int MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC = 550;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE = 531;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME = 620;
    public static final int MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF = 635;
    public static final int MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS = 633;
    public static final int MEDIA_PLAYER_OPTION_FRC_LEVEL = 285;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME = 158;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME = 163;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME = 156;
    public static final int MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF = 152;
    public static final int MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS = 151;
    public static final int MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS = 283;
    public static final int MEDIA_PLAYER_OPTION_GET_DROP_COUNT = 153;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS = 342;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS = 344;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS = 341;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS = 343;
    public static final int MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION = 188;
    public static final int MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME = 187;
    public static final int MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS = 282;
    public static final int MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS = 654;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAYER_HOLDER = 902;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_PREPARED_TIME = 307;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_STARTED_TIME = 308;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA = 240;
    public static final int MEDIA_PLAYER_OPTION_GET_RES_HEADERS = 335;
    public static final int MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME = 338;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS = 186;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME = 157;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME = 162;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME = 155;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME = 337;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME = 336;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS = 150;
    public static final int MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA = 287;
    public static final int MEDIA_PLAYER_OPTION_HARDWARE_DECODE_ENABLE = 59;
    public static final int MEDIA_PLAYER_OPTION_HIJACK_CODE = 204;
    public static final int MEDIA_PLAYER_OPTION_HIJACK_EXIT = 246;
    public static final int MEDIA_PLAYER_OPTION_HOST_CACHE_MILLSEC = 41;
    public static final int MEDIA_PLAYER_OPTION_HOST_IP_ADDR = 71;
    public static final int MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET = 290;
    public static final int MEDIA_PLAYER_OPTION_HTTP_HEADERS = 20;
    public static final int MEDIA_PLAYER_OPTION_HTTP_LOADER_TYPE = 14;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_LOAD_PER_PERCENT = 18;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECEIVE_HEADER = 30;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECONNECT = 7;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECONNECT_DELAY_MAX = 8;
    public static final int MEDIA_PLAYER_OPTION_HTTP_REDIRECT = 32;
    public static final int MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME = 821;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME = 822;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_TIMEOUT = 9;
    public static final int MEDIA_PLAYER_OPTION_HURRY_MILLISECOND = 397;
    public static final int MEDIA_PLAYER_OPTION_HURRY_TIME = 15;
    public static final int MEDIA_PLAYER_OPTION_HURRY_TYPE = 84;
    public static final int MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO = 184;
    public static final int MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF = 252;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_ENHANCEMENT = 37;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_LAYOUT = 36;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_SCALE = 38;
    public static final int MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED = 541;
    public static final int MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF = 349;
    public static final int MEDIA_PLAYER_OPTION_IS_VPP_LEVEL = 213;
    public static final int MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY = 194;
    public static final int MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE = 293;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME = 367;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME = 365;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME = 319;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME = 366;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME = 364;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME = 320;
    public static final int MEDIA_PLAYER_OPTION_LATENCYTIME = 567;
    public static final int MEDIA_PLAYER_OPTION_LAZY_SEEK = 146;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_LICENSE_DIR = 510;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_LICENSE_FILENAME = 511;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_STREAM_INFO = 147;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST = 930;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT = 714;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT = 713;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO = 710;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD = 711;
    public static final int MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP = 812;
    public static final int MEDIA_PLAYER_OPTION_LIVE_START_INDEX = 298;
    public static final int MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS = 198;
    public static final int MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID = 811;
    public static final int MEDIA_PLAYER_OPTION_LOADER_TYPE = 200;
    public static final int MEDIA_PLAYER_OPTION_LOOP_COUNT = 193;
    public static final int MEDIA_PLAYER_OPTION_LOOP_END_TIME = 138;
    public static final int MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO = 195;
    public static final int MEDIA_PLAYER_OPTION_LOOP_START_TIME = 137;
    public static final int MEDIA_PLAYER_OPTION_MASK_STREAM_OPENED_TIME = 852;
    public static final int MEDIA_PLAYER_OPTION_MASK_STREAM_OPEN_TIME = 851;
    public static final int MEDIA_PLAYER_OPTION_MASTER_TYPE = 13;
    public static final int MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP = 606;
    public static final int MEDIA_PLAYER_OPTION_MAX_BUFFERING_DATA_OF_MILLISECONDS = 110;
    public static final int MEDIA_PLAYER_OPTION_MAX_CACHE_SECONDS = 24;
    public static final int MEDIA_PLAYER_OPTION_MAX_VOLUME = 54;
    public static final int MEDIA_PLAYER_OPTION_MDAT_POS = 608;
    public static final int MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF = 216;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY = 91;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME = 164;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_RENDER = 88;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA = 132;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE = 90;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_COMMENT = 47;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_DOWNLOAD_BYTES = 45;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_KEY = 17;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_LOADED_SIZE = 21;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_MAX_CACHE_SIZE = 19;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FORMAT = 44;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_PLAY_BYTES = 46;
    public static final int MEDIA_PLAYER_OPTION_META_DATA_INFO = 142;
    public static final int MEDIA_PLAYER_OPTION_MIN_FRAME_DURATION = 55;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_MODULE_ID = 513;
    public static final int MEDIA_PLAYER_OPTION_MODULE_NAME = 509;
    public static final int MEDIA_PLAYER_OPTION_MOOV_POS = 607;
    public static final int MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO = 340;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_AUTO_RECONNECT = 7;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT = 538;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TIMEOUT = 9;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT = 230;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TYPE = 39;
    public static final int MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD = 369;
    public static final int MEDIA_PLAYER_OPTION_NOTIFY_DEAD_LOCK = 301;
    public static final int MEDIA_PLAYER_OPTION_NO_AV_SYNC = 820;
    public static final int MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE = 552;
    public static final int MEDIA_PLAYER_OPTION_ONLY_DECODER_SEI = 2;
    public static final int MEDIA_PLAYER_OPTION_OPEN_FAIL_TRY_AGINE = 82;
    public static final int MEDIA_PLAYER_OPTION_OPEN_RAISR = 89;
    public static final int MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES = 853;
    public static final int MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE = 827;
    public static final int MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME = 828;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME = 627;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE = 92;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_FORBID_DROP_FRAME_VALUE = 0;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_HURRY_DROP = 2;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_LIMIT_MAX_FRAME_RATE_DROP_VALUE = 1;
    public static final int MEDIA_PLAYER_OPTION_OUTPUT_LOG = 223;
    public static final int MEDIA_PLAYER_OPTION_PLAY_LOG_INFO = 5002;
    public static final int MEDIA_PLAYER_OPTION_PLAY_SPLIT_STREAM = 87;
    public static final int MEDIA_PLAYER_OPTION_PLAY_TYPE = 325;
    public static final int MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL = 647;
    public static final int MEDIA_PLAYER_OPTION_POST_PREPARE = 276;
    public static final int MEDIA_PLAYER_OPTION_PREFER_NEAREST_SAMPLE = 95;
    public static final int MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS = 286;
    public static final int MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE = 196;
    public static final int MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND = 371;
    public static final int MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL = 379;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT = 352;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED = 351;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE = 927;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY = 354;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_MTU_DISCOVERY = 357;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE = 396;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER = 921;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST = 924;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE = 920;
    public static final int MEDIA_PLAYER_OPTION_QUIC_INIT_MTU = 356;
    public static final int MEDIA_PLAYER_OPTION_QUIC_INIT_RTT = 388;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY = 393;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS = 389;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS = 390;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS = 391;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS = 392;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION = 394;
    public static final int MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT = 355;
    public static final int MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO = 395;
    public static final int MEDIA_PLAYER_OPTION_QUIC_PARAMS = 940;
    public static final int MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE = 923;
    public static final int MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT = 922;
    public static final int MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS = 353;
    public static final int MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW = 928;
    public static final int MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW = 929;
    public static final int MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION = 926;
    public static final int MEDIA_PLAYER_OPTION_QUIC_VERSION = 925;
    public static final int MEDIA_PLAYER_OPTION_RANGE_MODE = 258;
    public static final int MEDIA_PLAYER_OPTION_READ_CACHE_MODE = 289;
    public static final int MEDIA_PLAYER_OPTION_READ_MODE = 277;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_AUDIO_FRAME_TIME = 76;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_VIDEO_FRAME_TIME = 75;
    public static final int MEDIA_PLAYER_OPTION_RENDER_DEVICE = 139;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_200 = 381;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_300 = 382;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_400 = 383;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_500 = 384;
    public static final int MEDIA_PLAYER_OPTION_REND_FIRST_FRAME_TIME = 210;
    public static final int MEDIA_PLAYER_OPTION_REUSE_SOCKET = 154;
    public static final int MEDIA_PLAYER_OPTION_ROTATION = 555;
    public static final int MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME = 808;
    public static final int MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER = 816;
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS = 814;
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE = 882;
    public static final int MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD = 813;
    public static final int MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE = 880;
    public static final int MEDIA_PLAYER_OPTION_RTC_INITED_TIME = 806;
    public static final int MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY = 881;
    public static final int MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT = 803;
    public static final int MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER = 815;
    public static final int MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME = 807;
    public static final int MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL = 804;
    public static final int MEDIA_PLAYER_OPTION_RTC_START_TIME = 809;
    public static final int MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_ENABLE = 802;
    public static final int MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL = 805;
    public static final int MEDIA_PLAYER_OPTION_RTC_STAT_INFO = 810;
    public static final int MEDIA_PLAYER_OPTION_RTC_VENDOR_TYPE = 801;
    public static final int MEDIA_PLAYER_OPTION_SAMPLE_RATE = 554;
    public static final int MEDIA_PLAYER_OPTION_SAVED_HOST_TIME = 68;
    public static final int MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD = 295;
    public static final int MEDIA_PLAYER_OPTION_SEEK_END_ENABLE = 143;
    public static final int MEDIA_PLAYER_OPTION_SETTING_RENDER_TYPE = 56;
    public static final int MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE = 378;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION = 329;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE = 328;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY = 376;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT = 712;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN = 332;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF = 331;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST = 330;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION = 327;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE = 326;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY = 377;
    public static final int MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL = 339;
    public static final int MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID = 182;
    public static final int MEDIA_PLAYER_OPTION_SET_EGL_VER = 256;
    public static final int MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL = 281;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS = 374;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH = 373;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS = 375;
    public static final int MEDIA_PLAYER_OPTION_SET_FRAMES_DROP = 159;
    public static final int MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT = 192;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING = 544;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE = 533;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL = 534;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD = 535;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD = 543;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    public static final int MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN = 532;
    public static final int MEDIA_PLAYER_OPTION_SET_MAX_FPS = 134;
    public static final int MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE = 500;
    public static final int MEDIA_PLAYER_OPTION_SET_MEDIA_ID = 901;
    public static final int MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY = 197;
    public static final int MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH = 136;
    public static final int MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET = 135;
    public static final int MEDIA_PLAYER_OPTION_SET_RADIO_MODE = 261;
    public static final int MEDIA_PLAYER_OPTION_SET_TRACK_VOLUME = 94;
    public static final int MEDIA_PLAYER_OPTION_SET_UNSUPPORT_SAMPLERATE = 111;
    public static final int MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE = 523;
    public static final int MEDIA_PLAYER_OPTION_SIDX_INFOS = 521;
    public static final int MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE = 522;
    public static final int MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES = 145;
    public static final int MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH = 199;
    public static final int MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT = 297;
    public static final int MEDIA_PLAYER_OPTION_SKIP_FIND_STREAM_INFO = 96;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND = 398;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED = 191;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME = 190;
    public static final int MEDIA_PLAYER_OPTION_SMOOTH_DELAYED_SEC = 40;
    public static final int MEDIA_PLAYER_OPTION_SOCKET_RECV_BUFFER_SIZE = 25;
    public static final int MEDIA_PLAYER_OPTION_SPADE = 144;
    public static final int MEDIA_PLAYER_OPTION_SPEEDX_DROP = 358;
    public static final int MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT = 359;
    public static final int MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED = 311;
    public static final int MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES = 309;
    public static final int MEDIA_PLAYER_OPTION_START_PLAY_TIME = 100;
    public static final int MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC = 278;
    public static final int MEDIA_PLAYER_OPTION_STREAM_FORMAT = 315;
    public static final int MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME = 850;
    public static final int MEDIA_PLAYER_OPTION_SUB_PATH_INFO = 617;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_FXAA_OPTION = 166;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_OPTION = 165;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION = 167;
    public static final int MEDIA_PLAYER_OPTION_SWITCH_SUBID = 619;
    public static final int MEDIA_PLAYER_OPTION_SYS_ERROR_CODE = 31;
    public static final int MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS = 518;
    public static final int MEDIA_PLAYER_OPTION_TEST_ACTION = 83;
    public static final int MEDIA_PLAYER_OPTION_TEST_NET_SPEED = 79;
    public static final int MEDIA_PLAYER_OPTION_TEST_NET_SPEED_DIFF = 66;
    public static final int MEDIA_PLAYER_OPTION_TEST_WINDOW_CHNAGE_TYPE = 85;
    public static final int MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME = 318;
    public static final int MEDIA_PLAYER_OPTION_THREAD_PRIORITY_VALUE = 562;
    public static final int MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE = 312;
    public static final int MEDIA_PLAYER_OPTION_TOKEN_URL_TEMPLATE = 207;
    public static final int MEDIA_PLAYER_OPTION_TRAN_CONNECT_TIME = 69;
    public static final int MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE = 942;
    public static final int MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_TIMEOUT = 943;
    public static final int MEDIA_PLAYER_OPTION_TT_HLS_DRM = 250;
    public static final int MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN = 249;
    public static final int MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE = 288;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_USE_CODEC_POOL = 400;
    public static final int MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO = 97;
    public static final int MEDIA_PLAYER_OPTION_VALID_HTTP_CONTENT = 29;
    public static final int MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN = 280;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_BUFFER_LENGTH = 72;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CHECK_INFO = 202;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID = 141;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CODEC_PROFILE = 403;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX = 520;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN = 602;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR = 221;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME = 630;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST = 824;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500 = 387;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500 = 386;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_STACK = 160;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME = 629;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500 = 385;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES = 636;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME = 266;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME = 272;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME = 274;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON = 540;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_ID = 205;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE = 826;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME = 458;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE = 243;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME = 259;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR = 245;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_THRESHOLD = 322;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME = 264;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME = 270;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN = 638;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME = 265;
    public static final int MEDIA_PLAYER_OPTION_VOICE_STREAM_TYPE = 255;
    public static final int MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME = 314;
    public static final int MEDIA_PLAYER_PANO_RENDER_VALUE = 1;
    public static final int MEDIA_PLAYER_PCMS16LE_CODEC_ID = 4;
    public static final int MEDIA_PLAYER_PLAN_RENDER_VALUE = 0;
    public static final int MEDIA_PLAYER_SAVE_FILE_MODE_TYPE = 58;
    public static final int MEDIA_PLAYER_SETTING_CODEC_ERROR = -499998;
    public static final int MEDIA_PLAYER_SETTING_IS_NULL_ERROR = -499999;
    public static final int MEDIA_PLAYER_SETTING_OUTER_ERROR = -499995;
    public static final int MEDIA_PLAYER_SETTING_OUTLET_ERROR = -499994;
    public static final int MEDIA_PLAYER_SETTING_URI_IS_ERROR = -499987;
    public static final int MEDIA_PLAYER_SETTING_URI_IS_NULL_ERROR = -499988;
    public static final int MEDIA_PLAYER_SLES_VOICE_VALUE = 0;
    public static final int MEDIA_PLAYER_START_DECODER_ERROR = -499997;
    public static final int MEDIA_PLAYER_START_OUTLET_ERROR = -499990;
    public static final int MEDIA_PLAYER_START_OUTPUTER_ERROR = -499991;
    public static final int[] MEDIA_PLAYER_SUPPORT_SAMPLERATES = TTPlayerKeys.SupportSampleRates;
    public static final int MEDIA_PLAYER_TCP_FAILED_TO_RESOLVE_HOSTNAME_ERROR = -499799;
    public static final int MEDIA_PLAYER_TCP_READ_NETWORK_TIMEOUT_ERROR = -499793;
    public static final int MEDIA_PLAYER_TCP_RECEIVE_DATA_FAILED_ERROR = -499794;
    public static final int MEDIA_PLAYER_TCP_SEND_DATA_FAILED_ERROR = -499795;
    public static final int MEDIA_PLAYER_TCP_WRITE_NETWORK_TIMEOUT_ERROR = -499792;
    public static final int MEDIA_PLAYER_TEST_SURFACE_CHANGED_VALUE = 2;
    public static final int MEDIA_PLAYER_TEST_VIEW_CHANGED_VALUE = 1;
    public static final int MEDIA_PLAYER_URL_IS_NOT_MP4_ERROR = -499986;
    public static final int MEDIA_PLAYER_VIDEO_DECODER_WRITE_ERROR = -499977;
    public static final int MEDIA_PLAYER_VIDEO_TRACK_ENABLE_OPTION = 62;
    public static final int MEDIA_PLAYER_VR_RENDER_VALUE = 2;
    public static final int MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING = 566;
    public static final int MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT = 565;
    public static final int MouseDown = 1;
    public static final int MouseMove = 2;
    public static final int MouseUp = 3;
    public static final int NEAREST_SCALE_VALUE = 2;
    public static final int NHTTP_LOADER = 1;
    public static final int NOT_SAVE_FILE_MODE = 0;
    public static final int OPEN_FILE_MODE = 1;
    public static final int PANO_AUTO_ROTATION_DISABLE = 0;
    public static final int PANO_AUTO_ROTATION_ENABLE = 1;
    public static final int PanoIsGestureControl = 1;
    public static final int PanoIsSensorControl = 0;
    public static final int REAL_MASTER = 1;
    public static final int REPLACE_FILE_MODE = 0;
    public static final int SAVE_FILE_MODE = 1;
    public static final int TestANRCrashValue = 0;
    public static final int TestNativeCrashValue = 2;
    public static final int TestSimpleCrashValue = 1;
    public static final int VIDEO_MASTER = 2;
    public static final int VIEW_ROTATION_LEFT = 1;
    public static final int VIEW_ROTATION_NONE = 0;
    public static final int VIEW_ROTATION_OPTION = 23;
    public static final int VIEW_ROTATION_RIGHT = 2;

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnExternInfoListener {
        void onExternInfo(MediaPlayer mediaPlayer, int i, String str);
    }

    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnLogListener {
        void onLogInfo(MediaPlayer mediaPlayer, String str);
    }

    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    public interface OnScreenshotListener {
        void onTakeScreenShotCompletion(Bitmap bitmap);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface onSARChangedListener {
        void onSARChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    void deselectTrack(int i);

    int getCurrentPosition();

    String getDataSource();

    int getDuration();

    float getFloatOption(int i, float f);

    int getIntOption(int i, int i2);

    long getLongOption(int i, long j);

    int getPlayerType();

    int getSelectedTrack(int i);

    String getStringOption(int i);

    TrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoType();

    int getVideoWidth();

    boolean isLooping();

    boolean isMute();

    boolean isOSPlayer();

    boolean isPlaying();

    void mouseEvent(int i, int i2, int i3);

    void pause();

    void prepare();

    void prepareAsync();

    @Deprecated
    void prevClose();

    void release();

    void releaseAsync();

    void reset();

    void rotateCamera(float f, float f2);

    void seekTo(int i);

    void selectTrack(int i);

    void setCacheFile(String str, int i);

    void setDataSource(Context context, Uri uri) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDataSource(IMediaDataSource iMediaDataSource) throws IOException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(String str) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDisplay(SurfaceHolder surfaceHolder);

    int setFloatOption(int i, float f);

    void setIntOption(int i, int i2);

    void setIsMute(boolean z);

    long setLongOption(int i, long j);

    void setLooping(boolean z);

    void setMediaTransport(MediaTransport mediaTransport);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnExternInfoListener(OnExternInfoListener onExternInfoListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLogListener(OnLogListener onLogListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSARChangedListener(onSARChangedListener onsarchangedlistener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setPanoVideoControlModel(int i);

    void setPlaybackParams(PlaybackParams playbackParams);

    void setScreenOnWhilePlaying(boolean z);

    void setStringOption(int i, String str);

    void setSurface(Surface surface);

    void setVolume(float f, float f2);

    void setWakeMode(Context context, int i);

    void start();

    void stop();

    void switchStream(int i, int i2);

    void takeScreenshot(OnScreenshotListener onScreenshotListener);

    public static class TrackInfo {

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_METADATA = 5;

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;

        @SuppressLint({"InlinedApi"})
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        private MediaFormat mFormat;
        private String mLanguage;
        private int mStreamType;

        public TrackInfo(int i, MediaFormat mediaFormat) {
            this.mFormat = mediaFormat;
            this.mStreamType = 0;
            if (i == 1) {
                this.mStreamType = 2;
            } else if (i == 0) {
                this.mStreamType = 1;
            } else if (i == 2) {
                this.mStreamType = 4;
            }
            this.mLanguage = "zh-cn";
        }

        public MediaFormat getFormat() {
            return this.mFormat;
        }

        public String getLanguage() {
            return this.mLanguage;
        }

        public int getTrackType() {
            return this.mStreamType;
        }

        public TrackInfo(android.media.MediaPlayer.TrackInfo trackInfo) {
            this.mStreamType = trackInfo.getTrackType();
            this.mLanguage = trackInfo.getLanguage();
            int i = this.mStreamType;
            if (i == 2) {
                this.mFormat = MediaFormat.createAudioFormat(trackInfo.getFormat());
            } else if (i == 1) {
                this.mFormat = MediaFormat.createVideoFormat(trackInfo.getFormat());
            } else if (i == 4) {
                this.mFormat = MediaFormat.createSubtitleFormat(trackInfo.getFormat());
            }
        }
    }
}
