package com.kc.openset.ad_embed.zy;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYADNID {

    @Keep
    public @interface ADV {
        public static final String BAIDU = "BAIDU";
        public static final String CSJ = "CSJ";
        public static final String GDT = "GDT";
        public static final String HUAWEI = "HUAWEI";
        public static final String KUAISHOU = "KUAISHOU";
        public static final String OCTOPUS = "OCTOPUS";
        public static final String ONEWAY = "ONEWAY";
        public static final String OPPO = "OPPO";
        public static final String OTHER = "OTHER";
        public static final String QUMENG = "QM";
        public static final String SIGMOB = "SIGMOB";
        public static final String VIVO = "VIVO";
        public static final String XIAOMI = "XIAOMI";
    }

    @Keep
    public @interface Reason {
        public static final String ADM_BLACKLIST_FILTER = "1003";
        public static final String BID_PRICE_FILTER = "1001";
        public static final String COMPETE_FILTER = "1004";
        public static final String OTHER_FILTER = "1006";
        public static final String PRICE_LOW_FILTER = "1002";
        public static final String TIMEOUT_FILTER = "1005";
    }

    static {
        OSETSDKProtected.interface11(4207);
    }

    public static native String getWinBidder(String str);
}
