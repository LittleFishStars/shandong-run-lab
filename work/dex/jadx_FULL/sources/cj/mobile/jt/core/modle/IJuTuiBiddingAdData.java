package cj.mobile.jt.core.modle;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface IJuTuiBiddingAdData {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class LOSS_REASON {
        public final int code;
        public static final LOSS_REASON PRICE_FILTER = new LOSS_REASON("PRICE_FILTER", 0, 5001);
        public static final LOSS_REASON OTHER = new LOSS_REASON("OTHER", 1, 6001);
        private static final /* synthetic */ LOSS_REASON[] $VALUES = $values();

        private static /* synthetic */ LOSS_REASON[] $values() {
        }

        private LOSS_REASON(String str, int i, int i2) {
        }

        public static LOSS_REASON valueOf(String str) {
        }

        public static LOSS_REASON[] values() {
        }
    }

    long getEcpm();

    Map<String, String> getExtra();

    void notifyLoss(float f, LOSS_REASON loss_reason, String str);

    void notifyWin(float f);
}
