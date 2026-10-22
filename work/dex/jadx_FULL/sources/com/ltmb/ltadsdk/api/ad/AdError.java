package com.ltmb.ltadsdk.api.ad;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class AdError {
    public static int ERROR_NO_AD = 2000;
    public static int ERROR_RENDER_FAIL = 3000;
    public static int ERROR_SDK_INIT_FAIL = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40330a;
    public String b;
    public static AdPair<Integer, String> ERROR_INIT_PROCESSING = new AdPair<>(200001, "初始化失败，正在初始化中！");
    public static AdPair<Integer, String> ERROR_INIT_FAIL = new AdPair<>(200002, "初始化失败！");
    public static AdPair<Integer, String> ERROR_INIT_PARAMS_EMPTY = new AdPair<>(200003, "初始化失败，SYAdInitConfig为空！");
    public static AdPair<Integer, String> ERROR_START_FAIL_NOINIT = new AdPair<>(200004, "初始化失败！");
    public static AdPair<Integer, String> ERROR_START_FAIL_UNKNOWN = new AdPair<>(200004, "初始化失败，未知错误！");
    public static int ERROR_CONFIGREQUEST = 310000;
    public static AdPair<Integer, String> ERROR_CONFIG_EMPTY = new AdPair<>(300001, "配置请求失败，内容为空！");
    public static AdPair<Integer, String> ERROR_CONFIG_DECRYPT = new AdPair<>(300002, "配置请求失败，解析异常！");
    public static AdPair<Integer, String> ERROR_CONFIG_RETRY = new AdPair<>(300003, "配置请求失败！");
    public static AdPair<Integer, String> ERROR_CONFIG_JSON_EXCEPTION = new AdPair<>(300004, "配置请求失败，解析异常");
    public static AdPair<Integer, String> ERROR_CONFIG_EXCEPTION = new AdPair<>(300005, "配置请求失败，解析异常");
    public static AdPair<Integer, String> ERROR_CONFIG_UNKNOWN = new AdPair<>(300006, "配置请求失败");
    public static int ERROR_ADREQUEST = 420000;
    public static AdPair<Integer, String> ERROR_NO_INIT = new AdPair<>(400001, "广告SDK未初始化，请调用SYAdSdk.init()！");
    public static AdPair<Integer, String> ERROR_REQUEST_UNKNOWN = new AdPair<>(400002, "程序异常！");
    public static AdPair<Integer, String> ERROR_REQUEST_NO_NETWORK = new AdPair<>(400003, "广告请求失败，请检查网络是否连接！");
    public static AdPair<Integer, String> ERROR_REQUEST_FC = new AdPair<>(400004, "广告请求失败，不满足频控！");
    public static AdPair<Integer, String> ERROR_REQUEST_CONFIG_EMPTY = new AdPair<>(400005, "广告请求失败，广告配置为空！");
    public static AdPair<Integer, String> ERROR_REQUEST_AD_EMPTY = new AdPair<>(400006, "广告请求失败，没有合适的广告！");
    public static AdPair<Integer, String> ERROR_AD_REQUEST_API_EXCEPTION = new AdPair<>(400007, "接口发生异常");
    public static AdPair<Integer, String> ERROR_NO_START = new AdPair<>(400008, "广告SDK未启动，请调用SYAdSdk.start()！");
    public static AdPair<Integer, String> ERROR_REQUEST_AD_HAP_BLOCK = new AdPair<>(400009, "广告请求失败，素材被过滤！");
    public static AdPair<Integer, String> ERROR_REQUEST_AD_DECRYPT = new AdPair<>(400010, "广告请求失败，素材解析失败！");
    public static AdPair<Integer, String> ERROR_REQUEST_AD_JSON_EXCEPTION = new AdPair<>(400011, "广告请求失败，素材解析失败！");
    public static AdPair<Integer, String> ERROR_VIDEO_PLAYER_ERROR = new AdPair<>(500000, "视频播放异常");
    public static AdPair<Integer, String> ERROR_SPLASH_CONTAINER_NULL = new AdPair<>(500101, "开屏展示失败，容器为空！");
    public static AdPair<Integer, String> ERROR_SPLASH_CONTAINER_INVISIBLE = new AdPair<>(500102, "开屏展示失败，容器不可见！");
    public static AdPair<Integer, String> ERROR_SPLASH_RENDER_UNKNOWN = new AdPair<>(500103, "开屏展示失败，未知异常!");
    public static AdPair<Integer, String> ERROR_INTERSTITIAL_RENDER_TEMP_NO_SUPPORT = new AdPair<>(500201, "插屏模版不支持！");
    public static AdPair<Integer, String> ERROR_INTERSTITIAL_RENDER_TEMP_IMAGE_DLD_FAIL = new AdPair<>(500202, "插屏图片下载失败！");
    public static AdPair<Integer, String> ERROR_PLUGIN_URL_EMPTY = new AdPair<>(600001, "插件url为空！");

    public AdError(AdPair<Integer, String> adPair) {
        this.f40330a = adPair.getFirst().intValue();
        this.b = adPair.getSecond();
    }

    public int getCode() {
        return this.f40330a;
    }

    public String getMessage() {
        return this.b;
    }

    public String toString() {
        return "{code=" + this.f40330a + ", message=" + this.b + "}";
    }

    public AdError(int i) {
        this.f40330a = i;
    }

    public AdError(int i, String str) {
        this.f40330a = i;
        this.b = str;
    }
}
