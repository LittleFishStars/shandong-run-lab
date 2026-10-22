package com.byazt.fr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 20})
public class c implements Function<SparseArray<Object>, Object> {
    private final IMediationAdSlot c;

    public c(IMediationAdSlot iMediationAdSlot) {
        this.c = iMediationAdSlot;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        int iIntValue = com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987);
        if (iIntValue == 8260031) {
            return this.c;
        }
        switch (iIntValue) {
            case 266001:
                return Boolean.class.cast(Boolean.valueOf(this.c.isSplashShakeButton()));
            case 266002:
                return Boolean.class.cast(Boolean.valueOf(this.c.isSplashPreLoad()));
            case 266003:
                return Boolean.class.cast(Boolean.valueOf(this.c.isMuted()));
            case 266004:
                return Float.class.cast(Float.valueOf(this.c.getVolume()));
            case 266005:
                return Boolean.class.cast(Boolean.valueOf(this.c.isUseSurfaceView()));
            case 266006:
                return this.c.getExtraObject();
            case 266007:
                return Boolean.class.cast(Boolean.valueOf(this.c.isBidNotify()));
            case 266008:
                return this.c.getScenarioId();
            case 266009:
                return Boolean.class.cast(Boolean.valueOf(this.c.isAllowShowCloseBtn()));
            case 266010:
                return Float.class.cast(Float.valueOf(this.c.getShakeViewWidth()));
            case 266011:
                return Float.class.cast(Float.valueOf(this.c.getShakeViewHeight()));
            case 266012:
                return this.c.getWxAppId();
            default:
                switch (iIntValue) {
                    case 266101:
                        return new ve(this.c.getMediationNativeToBannerListener());
                    case 266102:
                        return new uj(this.c.getMediationSplashRequestInfo());
                    case 266103:
                        return this.c.getRewardName();
                    case 266104:
                        return Integer.class.cast(Integer.valueOf(this.c.getRewardAmount()));
                    default:
                        return null;
                }
        }
    }
}
