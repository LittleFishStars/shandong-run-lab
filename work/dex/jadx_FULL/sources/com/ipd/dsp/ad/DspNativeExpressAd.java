package com.ipd.dsp.ad;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspNativeExpressAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onNativeExpressAdClick();

        @Keep
        void onNativeExpressAdClose();

        @Keep
        void onNativeExpressAdRenderFail(int i, String str);

        @Keep
        void onNativeExpressAdShow();
    }

    @Nullable
    @Keep
    View getNativeExpressView(Context context);

    @Keep
    String getRequestId();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);

    @Keep
    void setVolumeOn(boolean z);
}
