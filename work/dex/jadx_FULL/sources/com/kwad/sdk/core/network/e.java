package com.kwad.sdk.core.network;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    public static e aSZ = new e(-1, "请求超时事件");
    public static e aTa = new e(-2, "请求异常");
    public static e aTb = new e(-1000, "该业务组件未加载");
    public static e aTc = new e(40001, "网络错误");
    public static e aTd = new e(40002, "数据解析错误");
    public static e aTe = new e(40003, "数据为空");
    public static e aTf = new e(40004, "视频资源缓存失败");
    public static e aTg = new e(40005, "网络超时");
    public static e aTh = new e(40007, "图片下载失败");
    public static e aTi = new e(40008, "广告场景不匹配");
    public static e aTj = new e(40009, "广告加载异常");
    public static e aTk = new e(40010, "activity场景不匹配");
    public static e aTl = new e(40011, "sdk初始化失败");
    public static e aTm = new e(40012, "权限未开启");
    public static e aTn = new e(40013, "SDK未调用start方法");
    public static e aTo = new e(100006, "更多视频请前往快手App查看");
    public static e aTp = new e(100007, "复制链接失败，请稍后重试");
    public static e aTq = new e(100008, "内容有点敏感，不可以发送哦");
    public static e aTr = new e(130001, "数据不存在");
    public static e aTs = new e(0, "网络超时");
    public final int errorCode;
    public final String msg;

    private e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
