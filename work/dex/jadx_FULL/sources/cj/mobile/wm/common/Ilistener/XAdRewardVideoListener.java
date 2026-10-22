package cj.mobile.wm.common.Ilistener;

import android.os.Bundle;
import cj.mobile.wm.common.Ibase.XAdBaseListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface XAdRewardVideoListener extends XAdBaseListener {
    void onAdClose();

    void onAdLoad();

    void onExposureFailed(String str);

    void onRewarded(boolean z, Bundle bundle);

    void onVideoComplete();

    void onVideoError(String str);
}
