package com.byazt.kb;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 688, 13})
public class tt implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener c;

    public tt(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.c = iMediationInterstitialFullAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 131101:
                this.c.onAdShow();
                return null;
            case 131102:
                this.c.onAdVideoBarClick();
                return null;
            case 131103:
                this.c.onAdClose();
                return null;
            case 131104:
                this.c.onVideoComplete();
                return null;
            case 131105:
                this.c.onSkippedVideo();
                return null;
            case 131106:
                this.c.onInterstitialFullShowFail(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            case 131107:
                this.c.onVideoError();
                return null;
            case 131108:
                this.c.onAdOpened();
                return null;
            case 131109:
                this.c.onAdLeftApplication();
                return null;
            case 131110:
                this.c.onRewardVerify((Bundle) valueSetTt.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
