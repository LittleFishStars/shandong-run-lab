package cn.jy.ad.sdk.jyapi;

import android.view.View;
import cn.jy.ad.sdk.jyinter.IAdBidding;
import cn.jy.ad.sdk.jyinter.IAdProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JyDraw extends IAdProvider, IAdBidding {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    public interface RenderListener {
        void onRenderFail(View view, int i, String str);

        void onRenderSuccess(View view, float f, float f2);
    }

    public interface VideoListener {
        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i, String str);

        void onVideoLoad();

        void onVideoProgressUpdate(long j, long j2);
    }

    void destroy();

    View getAdView();

    @Deprecated
    int getInteractionType();

    @Deprecated
    int getUnionType();

    boolean isValid();

    void render();

    void resume();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setRenderListener(RenderListener renderListener);

    void setVideoListener(VideoListener videoListener);
}
