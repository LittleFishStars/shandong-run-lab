package com.alibaba.triver.embed.video.fullscreenvideo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TBMiniAppVideo f24877a;
    public static TBMiniAppVideo b;

    public static TBMiniAppVideo a() {
        return f24877a;
    }

    public static TBMiniAppVideo b() {
        return b;
    }

    public static TBMiniAppVideo c() {
        return b() != null ? b() : a();
    }

    public static void d() {
        TBMiniAppVideo tBMiniAppVideo = b;
        if (tBMiniAppVideo != null) {
            tBMiniAppVideo.C();
            b = null;
        }
        TBMiniAppVideo tBMiniAppVideo2 = f24877a;
        if (tBMiniAppVideo2 != null) {
            tBMiniAppVideo2.C();
            f24877a = null;
        }
    }

    public static void a(TBMiniAppVideo tBMiniAppVideo) {
        f24877a = tBMiniAppVideo;
    }

    public static void b(TBMiniAppVideo tBMiniAppVideo) {
        b = tBMiniAppVideo;
    }
}
