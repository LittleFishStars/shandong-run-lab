package cj.mobile.jt.core.modle;

import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public enum AdErrorCode {
    INIT_FAIL("INIT_FAIL", "请检查广告位是否缺少APP_ID或POS_ID"),
    SLOT_INVALID("SLOT_INVALID", "广告请求方法与代码位渲染方式不一致"),
    NETWORK_ERROR("NETWORK_ERROR", "网络异常"),
    AD_CONTENT_ERROR("AD_CONTENT_ERROR", "广告数据异常"),
    PARSE_ERROR("PARSE_ERROR", "广告数据异常，解析失败"),
    TIMEOUT("TIMEOUT", "请求超时"),
    NO_FILL("NO_FILL", "无填充"),
    SERVER_ERROR("SERVER_ERROR", "服务器错误"),
    RENDER_FAIL("RENDER_FAIL", "物料加载失败或者渲染错误"),
    RENDER_TIMEOUT("RENDER_TIMEOUT", "广告展示超时"),
    TEMPLATE_UNKNOWN("TEMPLATE_UNKNOWN", "渲染错误, 未知的模版样式"),
    RENDER_LESS_CONTAINER("RENDER_LESS_CONTAINER", "渲染错误, 缺少广告容器"),
    RENDER_HAD_EXPOSED("RENDER_HAD_EXPOSED", "渲染错误, 广告重复展示"),
    RENDER_INVALID_CONTAINER("RENDER_INVALID_CONTAINER", "渲染错误, 广告容器已销毁"),
    RENDER_WINDOW_TOKEN("RENDER_WINDOW_TOKEN", "插屏广告展示错误，window或者windowToken为null"),
    RENDER_INVALID_CONTEXT("RENDER_INVALID_CONTEXT", "渲染错误, Activity/Context为空"),
    THIRD_PARTY_ERROR("THIRD_PARTY_ERROR", "第三方SDK错误"),
    UNKNOWN("UNKNOWN", AlibcProtocolConstant.UNKNOWN_ERROR);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22496a;
    public final String b;

    AdErrorCode(String str, String str2) {
    }

    public static AdErrorCode valueOf(String str) {
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AdErrorCode[] valuesCustom() {
    }
}
