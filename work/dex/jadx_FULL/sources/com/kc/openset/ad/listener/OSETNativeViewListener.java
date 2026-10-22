package com.kc.openset.ad.listener;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OSETNativeViewListener extends OSETBaseListener {
    void onAdDetailViewClosed();

    void onClick(View view);

    void onClose(View view);

    void onRenderSuccess(View view);

    void onShow(View view);
}
