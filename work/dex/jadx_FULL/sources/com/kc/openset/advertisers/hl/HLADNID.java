package com.kc.openset.advertisers.hl;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLADNID {

    @Keep
    public @interface ADV {
        public static final String BAIDU = "baidu";
        public static final String CSJ = "toutiao";
        public static final String GDT = "gdt";
        public static final String HAILIANG = "hailiang";
        public static final String KUAISHOU = "kuaishou";
        public static final String OPPO = "oppo";
        public static final String OTHER = "other";
        public static final String SIGMOB = "sigmob";
        public static final String VIVO = "vivo";
        public static final String XIAOMI = "xiaomi";
        public static final String ZS = "zs";
    }

    @Keep
    public @interface Reason {
        public static final String BID_FAIL = "101";
        public static final String BLACKLIST_FILTER = "102";
        public static final String CACHE_TIMEOUT = "1001";
        public static final String COMPETE_FILTER = "103";
        public static final String EXCEED_UPPER_LIMIT = "1002";
        public static final String OTHER = "1000";
        public static final String PRICE_FILTER = "100";
        public static final String TIMEOUT_FILTER = "104";
    }

    static {
        OSETSDKProtected.interface11(4258);
    }

    public static native String getWinBidder(String str);
}
