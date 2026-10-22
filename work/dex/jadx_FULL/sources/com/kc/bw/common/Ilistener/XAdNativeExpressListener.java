package com.kc.bw.common.Ilistener;

import android.view.View;
import com.kc.bw.common.Ibase.XAdBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface XAdNativeExpressListener extends XAdBaseListener {
    void onADIsVideo(boolean z);

    void onAdClose();

    void onRenderSuccess(View view, int i, int i2);
}
