package cn.jy.ad.sdk.jyinter;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IAdBidding {
    public static final String ADN_ID = "adnId";
    public static final String LOSS_PRICE = "lossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    public interface AdnId {
        public static final int BAIDU = 5;
        public static final int CSJ = 3;
        public static final int GDT = 2;
        public static final int JD = 6;
        public static final int KS = 4;
        public static final int OTHER = 0;
        public static final int SALE = -1;
        public static final int SIGMOB = 11;
        public static final int ZSMOB = 1;
    }

    public interface LossReason {
        public static final int LOW_PRICE = 1;
        public static final int NOT_COMPETITION = 3;
        public static final int NO_AD = 2;
        public static final int OTHER = 10001;
    }

    void reportBiddingFail(Map<String, Object> map);

    void reportBiddingSuccess(Map<String, Object> map);
}
