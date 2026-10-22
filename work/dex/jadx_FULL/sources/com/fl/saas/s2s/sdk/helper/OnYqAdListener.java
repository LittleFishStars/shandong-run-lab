package com.fl.saas.s2s.sdk.helper;

import com.fl.saas.config.exception.YdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface OnYqAdListener {
    void onAdFailed(YdError ydError);

    void onNativeAdReceived(List<AdInfoPoJo> list);
}
