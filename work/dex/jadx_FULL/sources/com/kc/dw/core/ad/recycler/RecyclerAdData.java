package com.kc.dw.core.ad.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.ResultBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RecyclerAdData extends ISBidding {
    void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, FeedInteractionListener feedInteractionListener);

    @Deprecated
    void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener);

    @Deprecated
    void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener);

    void destroy();

    String getActionText();

    int getAdPatternType();

    View getAdView();

    String getAppIntro();

    String getAppIntroUrl();

    String getAppName();

    List<SsdAdInfo.PermissionBean> getAppPermissionList();

    String getAppPremissionUrl();

    String getAppSize();

    String getAppVersion();

    String getContent();

    MsCustomVideo getCustomVideo();

    ResultBean getData();

    String getDesc();

    String getDeveloper();

    long getDuration();

    FeedExpressAdInteractionListener getExpressAdInteractionListener();

    View getExpressView();

    String getFrom();

    String getFromId();

    String getFromLogo();

    Bitmap getFromLogoBitmap();

    int getHeight();

    String getIconTitle();

    String getIconUrl();

    String[] getImgUrls();

    int getInteractionType();

    View getMediaView();

    FeedInteractionListener getNativeAdInteractionListener();

    String getPackageName();

    String getPlatFormEcpm();

    String getPlatform();

    String getPrivacyAgreement();

    String getTitle();

    String getVideoCover();

    String getVideoUrl();

    int getWidth();

    boolean isAdValid();

    boolean isNativeExpress();

    void mute();

    void pauseVideo();

    void render(Activity activity);

    void replay();

    void resumeVideo();

    void setExpressAdInteractionListener(FeedExpressAdInteractionListener feedExpressAdInteractionListener);

    void setExpressMediaListener(ExpressMediaListener expressMediaListener);

    void setNativeMediaListener(NativeAdMediaListener nativeAdMediaListener);

    void startVideo();

    void stopVideo();

    void unmute();
}
