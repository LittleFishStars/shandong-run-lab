package com.hailiang.advlib.ui.front;

import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface InciteVideoListener {
    void onADClick(Bundle bundle);

    void onADClose(Bundle bundle);

    void onADShow(Bundle bundle);

    void onReward(Bundle bundle);

    void onVideoComplete(Bundle bundle);

    void onVideoFail(Bundle bundle);
}
