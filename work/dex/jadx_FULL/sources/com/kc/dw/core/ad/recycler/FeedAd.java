package com.kc.dw.core.ad.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class FeedAd<T extends InteractionListener> extends a<T> implements RecyclerAdData {
    public String actionText;
    public int adPatternType;
    public String appIntro;
    public String appIntroUrl;
    public String appName;
    public List<SsdAdInfo.PermissionBean> appPermissionList;
    public String appPremissionUrl;
    public String appSize;
    public String appVersion;
    public String content;
    public String desc;
    public String developer;
    public long duration;
    private FeedExpressAdInteractionListener expressListener;
    public String from;
    public String fromId;
    public String fromLogo;
    public Bitmap fromLogoBitmap;
    public int height;
    public String iconTitle;
    public String iconUrl;
    public String[] imgUrls;
    public int interactionType;
    public View mediaView;
    public FeedInteractionListener nativeListener;
    public String packageName;
    public String platform;
    public String privacyAgreement;
    public String title;
    public int width;

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, FeedInteractionListener feedInteractionListener) {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        Activity activity;
        if (!isNativeExpress()) {
            bindAdToView(context, viewGroup, list, new FeedInteractionListener(this, recylcerAdInteractionListener) { // from class: com.kc.dw.core.ad.recycler.FeedAd.1
                public final FeedAd this$0;
                public final RecylcerAdInteractionListener val$nativeInteractionListener;

                {
                    this.this$0 = this;
                    this.val$nativeInteractionListener = recylcerAdInteractionListener;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                    if (recylcerAdInteractionListener2 != null) {
                        recylcerAdInteractionListener2.onAdClicked();
                    }
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                    RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                    if (recylcerAdInteractionListener2 != null) {
                        recylcerAdInteractionListener2.onAdClosed();
                    }
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                    if (recylcerAdInteractionListener2 != null) {
                        recylcerAdInteractionListener2.onAdExposure();
                    }
                }
            });
            return;
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (viewGroup.getContext() instanceof Activity) {
            context = viewGroup.getContext();
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        setExpressAdInteractionListener(new FeedExpressAdInteractionListener(this, recylcerAdInteractionListener, viewGroup) { // from class: com.kc.dw.core.ad.recycler.FeedAd.2
            public final FeedAd this$0;
            public final ViewGroup val$container;
            public final RecylcerAdInteractionListener val$nativeInteractionListener;

            {
                this.this$0 = this;
                this.val$nativeInteractionListener = recylcerAdInteractionListener;
                this.val$container = viewGroup;
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdClicked() {
                RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                if (recylcerAdInteractionListener2 != null) {
                    recylcerAdInteractionListener2.onAdClicked();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdClosed() {
                RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                if (recylcerAdInteractionListener2 != null) {
                    recylcerAdInteractionListener2.onAdClosed();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
            public void onAdExposure() {
                RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                if (recylcerAdInteractionListener2 != null) {
                    recylcerAdInteractionListener2.onAdExposure();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
            public void onRenderError(int i, String str) {
                com.kc.dw.core.service.logrecord.a.a(5, "f5", this.this$0.adWrapper, i, str);
                RecylcerAdInteractionListener recylcerAdInteractionListener2 = this.val$nativeInteractionListener;
                if (recylcerAdInteractionListener2 != null) {
                    recylcerAdInteractionListener2.onAdRenderFailed();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
            public void onRenderSuccess() {
                try {
                    if (this.val$container == null || this.this$0.getExpressView() == null) {
                        return;
                    }
                    this.val$container.removeAllViews();
                    this.val$container.addView(this.this$0.getExpressView());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        render(activity);
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        View mediaView;
        if (isNativeExpress() || (mediaView = getMediaView()) == null) {
            return;
        }
        setNativeMediaListener(new NativeAdMediaListener(this, recyclerAdMediaListener) { // from class: com.kc.dw.core.ad.recycler.FeedAd.3
            public final FeedAd this$0;
            public final RecyclerAdMediaListener val$nativeRecyclerAdMediaListener;

            {
                this.this$0 = this;
                this.val$nativeRecyclerAdMediaListener = recyclerAdMediaListener;
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoCompleted() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = this.val$nativeRecyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoCompleted();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoError() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = this.val$nativeRecyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoError();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoPause() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = this.val$nativeRecyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoPause();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoResume() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = this.val$nativeRecyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoResume();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoStart() {
                RecyclerAdMediaListener recyclerAdMediaListener2 = this.val$nativeRecyclerAdMediaListener;
                if (recyclerAdMediaListener2 != null) {
                    recyclerAdMediaListener2.onVideoStart();
                }
            }
        });
        viewGroup.removeAllViews();
        viewGroup.addView(mediaView);
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void destroy() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return this.actionText;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        return this.adPatternType;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return this.appIntro;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return this.appIntroUrl;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return this.appName;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public List<SsdAdInfo.PermissionBean> getAppPermissionList() {
        return this.appPermissionList;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return this.appPremissionUrl;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return this.appSize;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return this.content;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        return this.desc;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return this.developer;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return this.duration;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public FeedExpressAdInteractionListener getExpressAdInteractionListener() {
        return this.expressListener;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return this.from;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return this.fromId;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return this.fromLogo;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public Bitmap getFromLogoBitmap() {
        return this.fromLogoBitmap;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return this.height;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return this.iconTitle;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        return this.imgUrls;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return this.interactionType;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return this.mediaView;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public FeedInteractionListener getNativeAdInteractionListener() {
        return this.nativeListener;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return "";
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return this.platform;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        return this.title;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return "";
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return this.width;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void mute() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.adWrapper, new TypeMsg().setData(2));
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setExpressAdInteractionListener(FeedExpressAdInteractionListener feedExpressAdInteractionListener) {
        this.expressListener = feedExpressAdInteractionListener;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setNativeMediaListener(NativeAdMediaListener nativeAdMediaListener) {
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPlatformLoader(b<RecyclerMixCommonAdLoader> bVar) {
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }
}
