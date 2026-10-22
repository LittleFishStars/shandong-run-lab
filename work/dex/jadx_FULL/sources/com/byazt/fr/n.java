package com.byazt.fr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2053, 46})
public class n implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder c;

    public n(IMediationViewBinder iMediationViewBinder) {
        this.c = iMediationViewBinder;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        switch (com.byazt.rl.ve.c(sparseArray).tt().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.c.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.c.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.c.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.c.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.c.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.c.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.c.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.c.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.c.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.c.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.c.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.c.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.c.getShakeViewContainerId()));
            case 271034:
                return this.c.getExtras();
            default:
                return com.byazt.rl.ve.ve.apply(sparseArray);
        }
    }
}
