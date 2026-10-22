package com.kc.bw.common.Ilistener;

import android.os.Bundle;
import com.kc.bw.common.Ibase.XAdBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface XAdRewardVideoListener extends XAdBaseListener {
    void onAdClose();

    void onAdLoad();

    void onRewarded(boolean z, Bundle bundle);

    void onVideoComplete();

    void onVideoError(String str);
}
