package cn.jy.ad.sdk.jyapi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.jy.ad.sdk.jybn.VideoOption;
import cn.jy.ad.sdk.jyinter.ApkDownloadInterface;
import cn.jy.ad.sdk.jyinter.IAdBidding;
import cn.jy.ad.sdk.jyinter.IAdProvider;
import cn.jy.ad.sdk.jyinter.NativeADAppMiitInfo;
import cn.jy.ad.sdk.jyview.JyMediaView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JyFeed extends IAdProvider, IAdBidding, ApkDownloadInterface {
    public static final int AD_MODE_IMAGE = 1;
    public static final int AD_MODE_UNKNOWN = 0;
    public static final int AD_MODE_VIDEO = 2;

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    public interface StatusChangeListener {
        void onAdStatusChanged();
    }

    public interface VideoListener {
        @Deprecated
        void onVideoClicked();

        void onVideoComplete();

        void onVideoError(int i, String str);

        void onVideoLoad();

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();

        @Deprecated
        void onVideoStop();
    }

    void destroy();

    Bitmap getAdLogo();

    @Deprecated
    String getAdLogoUrl();

    NativeADAppMiitInfo getAppMiitInfo();

    String getButtonText();

    int getCreativeType();

    String getDesc();

    int getDuration();

    @Override // cn.jy.ad.sdk.jyinter.IAdProvider
    Map<String, Object> getExtraInfo();

    int getHeight();

    @Deprecated
    String getHtmlSnippet();

    String getIconUrl();

    String getImageUrl();

    List<String> getImageUrls();

    int getInteractionType();

    String getTitle();

    @Deprecated
    int getUnionType();

    int getVideoHeight();

    @Deprecated
    String getVideoUrl();

    View getVideoView();

    int getVideoWidth();

    int getWidth();

    boolean isValid();

    void pauseVideo();

    void registerViewForInteraction(ViewGroup viewGroup, View view);

    void registerViewForInteraction(ViewGroup viewGroup, View view, FrameLayout.LayoutParams layoutParams);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, FrameLayout.LayoutParams layoutParams);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams);

    void registerViewForInteraction(JyMediaView jyMediaView);

    @Deprecated
    void resume();

    void resumeVideo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setStatusChangeListener(StatusChangeListener statusChangeListener);

    void setVideoListener(VideoListener videoListener);

    @Deprecated
    void setVideoOption(VideoOption videoOption);

    void startVideo();

    void stopVideo();
}
