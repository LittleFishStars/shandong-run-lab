package com.ipd.dsp.ad;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ipd.dsp.api.IBid;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspDrawAd extends IBid {

    @Keep
    public interface InteractionListener {
        @Keep
        void onDownloadConfirmDialogDismiss();

        @Keep
        void onDownloadConfirmDialogShow();

        @Keep
        void onDrawAdClick();

        @Keep
        void onDrawAdPlayError(int i, String str);

        @Keep
        void onDrawAdRenderFail(int i, String str);

        @Keep
        void onDrawAdRenderSuccess(@NonNull View view);

        @Keep
        void onDrawAdShow();
    }

    @Keep
    String getRequestId();

    @Keep
    void isDimBehind(boolean z);

    @Keep
    void isVolumeOn(boolean z);

    @Keep
    void render(Activity activity);

    @Keep
    void setInteractionListener(InteractionListener interactionListener);
}
