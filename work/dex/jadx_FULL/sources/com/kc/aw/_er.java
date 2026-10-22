package com.kc.aw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.interf.PtgVideoAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface _er {
    void _a();

    void _a(Context context, _h _hVar);

    void _a(ViewGroup viewGroup);

    void _a(_dl _dlVar);

    void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener);

    void _b();

    View _c();

    PtgNativeExpressAd.CustomizeVideo getCustomizeVideo();

    void pauseVideo();

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void startVideo();
}
