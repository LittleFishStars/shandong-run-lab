package com.bykv.vk.component.ttvideo;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.model.LiveURL;
import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public interface ILivePlayer {
    public static final int DEFAULT_CODEC_ID_BYTEVC1 = 1;
    public static final int DEFAULT_CODEC_ID_H264 = 0;
    public static final int DISABLE = 0;
    public static final int ENABLE = 1;
    public static final int HURRY_TYPE_CATCH_TIME = 0;
    public static final int HURRY_TYPE_NONE = -1;
    public static final int HURRY_TYPE_SKIP_TIME = 1;
    public static final int IMAGE_ENHANCEMENT_DEFAULT = 0;
    public static final int IMAGE_SCALE_LINEAR = 0;
    public static final int INITIAL_VALUE_INT = -1;
    public static final float INITINAL_VALUE_FLOAT = -1.0f;
    public static final int LIVE_BUFFERING_DATA_OF_MILLSECONDS = 10;
    public static final int LIVE_BUFFERING_TIMEOUT = 11;
    public static final int LIVE_DATALOADER_OPEN_TIMEOUT = 52;
    public static final int LIVE_DATALOADER_RETRY_COUNT = 53;
    public static final int LIVE_DATALOADER_RW_TIMEOUT = 51;
    public static final int LIVE_NETWORK_TIMEOUT = 12;
    public static final int LIVE_OPION_MEDIA_CODEC_CHECK_SIDE_DATA = 22;
    public static final int LIVE_OPTION_BYTEVC1_DECODER_TYPE = 9;
    public static final int LIVE_OPTION_CACHE = 0;
    public static final int LIVE_OPTION_CATCH_SPEED = 19;
    public static final int LIVE_OPTION_ENABLE_BYTEVC1 = 6;
    public static final int LIVE_OPTION_ENABLE_CACHE_FILE = 8;
    public static final int LIVE_OPTION_ENABLE_HARDWARE_DECODE = 7;
    public static final int LIVE_OPTION_FORBID_OS_PLAYER = 3;
    public static final int LIVE_OPTION_HURRY_MILLISECOND = 83;
    public static final int LIVE_OPTION_HURRY_TIME = 17;
    public static final int LIVE_OPTION_HURRY_TYPE = 18;
    public static final int LIVE_OPTION_IMAGE_ENHANCEMENT = 1;
    public static final int LIVE_OPTION_IMAGE_LAYOUT = 4;
    public static final int LIVE_OPTION_IMAGE_SCALE = 2;
    public static final int LIVE_OPTION_MAX_FILE_CACHE_SIZE = 14;
    public static final int LIVE_OPTION_RENDER_TYPE = 5;
    public static final int LIVE_OPTION_SLOW_PLAY_MILLISECOND = 84;
    public static final int LIVE_OPTION_SLOW_PLAY_SPEED = 20;
    public static final int LIVE_OPTION_SLOW_PLAY_TIME = 21;
    public static final int LIVE_OPTION_USE_EXTERNAL_DIR = 15;
    public static final int LIVE_OPTION_USE_TEST_ACTION = 16;
    public static final int LIVE_P2P_PCDN = 7;
    public static final int LIVE_P2P_XY = 1;
    public static final int LIVE_PLAYER_BYTEVC1_CODEC_FFMPEG = 0;
    public static final int LIVE_PLAYER_BYTEVC1_CODEC_JX = 2;
    public static final int LIVE_PLAYER_BYTEVC1_CODEC_KSY = 1;
    public static final int LIVE_PLAYER_CACHE_FILE_PATH = 26;
    public static final int LIVE_PLAYER_DEGRADE_MODE = 25;
    public static final int LIVE_PLAYER_ENTER_ACTION = 64;
    public static final int LIVE_PLAYER_ENTER_METHOD = 63;
    public static final int LIVE_PLAYER_OPTION_ABR_STRATEGY = 65;
    public static final int LIVE_PLAYER_OPTION_ALOG_PATH = 59;
    public static final int LIVE_PLAYER_OPTION_ASYNC_INIT_CODEC = 33;
    public static final int LIVE_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO = 46;
    public static final int LIVE_PLAYER_OPTION_BYTEVC1_HARDWARE_DECODE = 36;
    public static final int LIVE_PLAYER_OPTION_CDN_ABR_SWITCH_RESOLUTION = 86;
    public static final int LIVE_PLAYER_OPTION_CHECK_BUFFERING_END_ADVANCE = 54;
    public static final int LIVE_PLAYER_OPTION_CHECK_PACKET_CORRUPT = 62;
    public static final int LIVE_PLAYER_OPTION_DEFAULT_CODEC_ID = 34;
    public static final int LIVE_PLAYER_OPTION_DOWNLOAD_SPEED = 68;
    public static final int LIVE_PLAYER_OPTION_ENABLE_FAST_OPEN_STREAM = 40;
    public static final int LIVE_PLAYER_OPTION_ENABLE_FLV_ABR = 67;
    public static final int LIVE_PLAYER_OPTION_ENABLE_FREE_FLOW = 85;
    public static final int LIVE_PLAYER_OPTION_ENABLE_HTTPK_DEGRADE = 39;
    public static final int LIVE_PLAYER_OPTION_ENABLE_MDL = 48;
    public static final int LIVE_PLAYER_OPTION_ENABLE_MULT_SEI = 82;
    public static final int LIVE_PLAYER_OPTION_ENABLE_NTP = 42;
    public static final int LIVE_PLAYER_OPTION_ENABLE_P2P = 49;
    public static final int LIVE_PLAYER_OPTION_ENABLE_RESOLUTION_DEGRADE = 56;
    public static final int LIVE_PLAYER_OPTION_ENABLE_SEI_UPLOAD = 41;
    public static final int LIVE_PLAYER_OPTION_ENABLE_SHARP = 32;
    public static final int LIVE_PLAYER_OPTION_ENABLE_SR = 70;
    public static final int LIVE_PLAYER_OPTION_ENABLE_TEXTURE_RENDER = 69;
    public static final int LIVE_PLAYER_OPTION_H264_HARDWARE_DECODE = 35;
    public static final int LIVE_PLAYER_OPTION_IN_MAINLOOPER = 44;
    public static final int LIVE_PLAYER_OPTION_MAX_CACHE_SECONDS = 37;
    public static final int LIVE_PLAYER_OPTION_MIN_TIMESHIFT = 79;
    public static final int LIVE_PLAYER_OPTION_P2P_TYPE = 50;
    public static final int LIVE_PLAYER_OPTION_PLAY_RESOLUTION = 58;
    public static final int LIVE_PLAYER_OPTION_PLAY_URL = 57;
    public static final int LIVE_PLAYER_OPTION_QUEUE_MAX_FULL = 78;
    public static final int LIVE_PLAYER_OPTION_RESOLUTION = 43;
    public static final int LIVE_PLAYER_OPTION_SET_URL_HOST = 89;
    public static final int LIVE_PLAYER_OPTION_SHARPEN_MODE = 87;
    public static final int LIVE_PLAYER_OPTION_SHARPEN_SUPPORT_SCENE = 88;
    public static final int LIVE_PLAYER_OPTION_SPLIT_STREAM_ENABLE = 38;
    public static final int LIVE_PLAYER_OPTION_SR_ALG_TYPE = 71;
    public static final int LIVE_PLAYER_OPTION_SR_DSP_MODULE_NAME = 74;
    public static final int LIVE_PLAYER_OPTION_SR_KERNAL_BIN_PATH = 72;
    public static final int LIVE_PLAYER_OPTION_SR_MODE = 75;
    public static final int LIVE_PLAYER_OPTION_SR_OCL_MODULE_NAME = 73;
    public static final int LIVE_PLAYER_OPTION_SR_SUPPORT_SCENE = 76;
    public static final int LIVE_PLAYER_OPTION_STALL_COUNT_THRES_OF_DEGRADE = 55;
    public static final int LIVE_PLAYER_OPTION_START_DIRECT_AFTER_PREPARED = 47;
    public static final int LIVE_PLAYER_OPTION_START_PLAY_BUFFER_THRESHOLD = 45;
    public static final int LIVE_PLAYER_OPTION_STREAM_FORMAT = 60;
    public static final int LIVE_PLAYER_OPTION_SUGGEST_PROTOCOL = 66;
    public static final int LIVE_PLAYER_OPTION_TCP_FAST_OPEN = 61;
    public static final int LIVE_PLAYER_OPTION_TIME_SHIFT = 77;
    public static final int LIVE_PLAYER_OPTION_TOB_MODULE_ID = 81;
    public static final int LIVE_PLAYER_OPTION_TOB_SWITCH = 80;
    public static final int LIVE_PLAYER_URL_ABILITY = 31;
    public static final int LOG_TYPE_ABR_STREAM_INFO = 8;
    public static final int LOG_TYPE_AVPH_STREAM_INFO = 9;
    public static final int LOG_TYPE_FIRST_FRAME = 0;
    public static final int LOG_TYPE_PLAYING_INFO = 1;
    public static final int LOG_TYPE_PREPARE_RESULT = 7;
    public static final int LOG_TYPE_RENDER_STALL = 4;
    public static final int LOG_TYPE_SESSION_TIME_SERIES = 3;
    public static final int LOG_TYPE_STALL_END = 6;
    public static final int LOG_TYPE_STALL_START = 5;
    public static final int LOG_TYPE_STOP_INFO = 2;
    public static final int PLAYER_DEGRADE_MODE_LITE = 0;
    public static final int PLAYER_DEGRADE_MODE_OS = 1;
    public static final int PLAYER_IP = 2;
    public static final int PLAYER_OWN = 1;
    public static final int PLAYER_SYS = 0;
    public static final int PLAYER_TIME_BASE = 1000000;
    public static final int RENDER_TYPE_DEFAULT = 3;
    public static final long RETRY_TIME_INTERVAL_DEFAULT = 10000;
    public static final int RET_FAIL = -1;
    public static final int RET_OK = 0;
    public static final int STREAM_AUDIO = 1;
    public static final int STREAM_VIDEO = 0;
    public static final int kLiveSettingsAsyncInitCodecEnable = 12;
    public static final int kLiveSettingsBufferTime = 7;
    public static final int kLiveSettingsBufferingTimeout = 9;
    public static final int kLiveSettingsBufferingWaterMark = 8;
    public static final int kLiveSettingsByteVC1HardwareDecodeEnable = 6;
    public static final int kLiveSettingsH264HardwareDecodeEnable = 5;
    public static final int kLiveSettingsHurrySpeed = 2;
    public static final int kLiveSettingsHurryTime = 1;
    public static final int kLiveSettingsNetAdaptiveEnable = 0;
    public static final int kLiveSettingsNetWorkTimeout = 10;
    public static final int kLiveSettingsSharpEnable = 11;
    public static final int kLiveSettingsSlowPlaySpeed = 4;
    public static final int kLiveSettingsSlowPlayTime = 3;
    public static final int kLiveSettingsUploadSessionSeriesEnable = 13;

    void closeDNS();

    void closeSeiCheck();

    void enableSeiCheck();

    void enableUploadSessionSeries();

    float getMaxVolume();

    String getPlayerErrorInfo();

    float getPlayerVolume();

    long getSeiDelay();

    String getServerIP();

    JSONObject getStaticLog();

    String getStringOption(int i, String str);

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isIPPlayer();

    boolean isOsPlayer();

    boolean isPlaying();

    void openNTP();

    void pause();

    void play();

    boolean playResolution(String str);

    void release();

    void releaseAsync();

    void reset();

    void setAsyncInit(int i);

    void setCommonFlag(String str);

    void setDisableVideoRender(Boolean bool);

    void setFloatOption(int i, float f);

    void setIntOption(int i, int i2);

    void setLocalURL(String str);

    void setLongOption(int i, long j);

    void setLooping(boolean z);

    void setMute(Boolean bool);

    void setPlayURLs(LiveURL[] liveURLArr);

    void setPlayerVolume(float f);

    void setPreviewFlag(boolean z);

    void setProjectKey(String str);

    void setStreamInfo(String str);

    void setStringOption(int i, String str);

    void setSurface(Surface surface);

    void setSurfaceHolder(SurfaceHolder surfaceHolder);

    void setVideoFormat(String str);

    void setVolume(float f);

    void stop();
}
