package cn.jy.ad.sdk.jyapi;

import android.view.ViewGroup;
import cn.jy.ad.sdk.jyinter.IAdBidding;
import cn.jy.ad.sdk.jyinter.IAdProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JySplash extends IAdProvider, IAdBidding {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdClose();

        @Deprecated
        void onAdExposure();

        void onAdShow();
    }

    void destroy();

    @Deprecated
    int getInteractionType();

    @Deprecated
    int getUnionType();

    boolean isValid();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void showAd(ViewGroup viewGroup);
}
