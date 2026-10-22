package com.kc.cw.ad.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class g {

    @Keep
    public enum a {
        ADP_UNKNOWN(0),
        ADP_REWARD(1),
        ADP_SPLASH(2),
        ADP_INTERSTITIAL(3),
        ADP_BANNER(4),
        ADP_FULL_SCREEN(5),
        ADP_NATIVE(6),
        ADP_DRAW(7);

        private final int i;

        a(int i) {
            this.i = i;
        }

        public static a a(int i) {
            switch (i) {
                case 0:
                    return ADP_UNKNOWN;
                case 1:
                    return ADP_REWARD;
                case 2:
                    return ADP_SPLASH;
                case 3:
                    return ADP_INTERSTITIAL;
                case 4:
                    return ADP_BANNER;
                case 5:
                    return ADP_FULL_SCREEN;
                case 6:
                    return ADP_NATIVE;
                case 7:
                    return ADP_DRAW;
                default:
                    return null;
            }
        }
    }

    @Keep
    public enum b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);

        private final int g;

        b(int i) {
            this.g = i;
        }
    }

    @Keep
    public enum c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);

        private final int f;

        c(int i) {
            this.f = i;
        }

        public static c a(int i) {
            if (i == 0) {
                return ISP_UNKNOWN;
            }
            if (i == 1) {
                return ISP_CN_MOBILE;
            }
            if (i == 2) {
                return ISP_CN_UNICOM;
            }
            if (i == 3) {
                return ISP_CN_TEL;
            }
            if (i != 4) {
                return null;
            }
            return ISP_OTHER;
        }

        public final int a() {
            return this.f;
        }
    }

    @Keep
    public enum d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);

        private final int h;

        d(int i2) {
            this.h = i2;
        }

        public static d a(int i2) {
            switch (i2) {
                case 0:
                    return NET_UNKNOWN;
                case 1:
                    return NET_3G;
                case 2:
                    return NET_4G;
                case 3:
                    return NET_5G;
                case 4:
                    return NET_WIFI;
                case 5:
                    return NET_OTHER;
                case 6:
                    return NET_2G;
                default:
                    return null;
            }
        }

        public final int a() {
            return this.h;
        }
    }

    @Keep
    public enum e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);

        private final int e;

        e(int i) {
            this.e = i;
        }
    }

    @Keep
    public enum f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);

        private final int g;

        f(int i) {
            this.g = i;
        }

        public static f a(int i) {
            if (i == 0) {
                return RENDER_UNKNOWN;
            }
            if (i == 1) {
                return RENDER_VIDEO;
            }
            if (i == 2) {
                return RENDER_PIC;
            }
            if (i == 3) {
                return RENDER_H5;
            }
            if (i == 4) {
                return RENDER_JSON;
            }
            if (i != 5) {
                return null;
            }
            return RENDER_VAST_VIDEO;
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.a.g$g, reason: collision with other inner class name */
    @Keep
    public enum EnumC0968g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);

        private final int d;

        EnumC0968g(int i) {
            this.d = i;
        }
    }

    @Keep
    public enum h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);

        private final int d;

        h(int i) {
            this.d = i;
        }

        public static h a(int i) {
            if (i == 0) {
                return SCREEN_DIRECTION_UNKOWN;
            }
            if (i == 1) {
                return PORTRAIT;
            }
            if (i != 2) {
                return null;
            }
            return LANDSCAPE;
        }
    }

    @Keep
    public enum i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);

        private final int f;

        i(int i) {
            this.f = i;
        }
    }
}
