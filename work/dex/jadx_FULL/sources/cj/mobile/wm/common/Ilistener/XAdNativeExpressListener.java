package cj.mobile.wm.common.Ilistener;

import android.view.View;
import cj.mobile.wm.common.Ibase.XAdBaseListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface XAdNativeExpressListener extends XAdBaseListener {
    void onADIsVideo(boolean z);

    void onAdClose();

    void onRenderFailed(String str);

    void onRenderSuccess(View view, int i, int i2);
}
