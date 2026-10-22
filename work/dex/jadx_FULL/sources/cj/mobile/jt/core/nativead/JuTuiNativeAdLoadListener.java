package cj.mobile.jt.core.nativead;

import cj.mobile.jt.core.modle.AdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface JuTuiNativeAdLoadListener {
    void onAdLoadFail(AdError adError);

    void onAdLoadSuccess(List<JuTuiNativeAdData> list);
}
