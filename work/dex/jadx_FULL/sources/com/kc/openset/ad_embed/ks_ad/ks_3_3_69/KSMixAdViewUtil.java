package com.kc.openset.ad_embed.ks_ad.ks_3_3_69;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.R;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsNativeAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSMixAdViewUtil {
    private static final String TAG = OSETSDKProtected.getString2(791);
    private static WeakReference<AdSingleImageViewHolder> mViewHolder;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSMixAdViewUtil$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsNativeAd.VideoPlayListener {
        final KSMixNativeAdInteractionListener val$adInteractionListener;

        static {
            OSETSDKProtected.interface11(4026);
        }

        public AnonymousClass1(KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener) {
            this.val$adInteractionListener = kSMixNativeAdInteractionListener;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayComplete();

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayError(int i, int i2);

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayPause();

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayReady();

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayResume();

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public native void onVideoPlayStart();
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSMixAdViewUtil$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsNativeAd.AdInteractionListener {
        final KSMixNativeAdInteractionListener val$adInteractionListener;

        static {
            OSETSDKProtected.interface11(4027);
        }

        public AnonymousClass2(KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener) {
            this.val$adInteractionListener = kSMixNativeAdInteractionListener;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdClicked(View view, KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdShow(KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogDismiss();

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogShow();
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSMixAdViewUtil$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements View.OnClickListener {
        final KsNativeAd val$ad;

        static {
            OSETSDKProtected.interface11(4028);
        }

        public AnonymousClass3(KsNativeAd ksNativeAd) {
            this.val$ad = ksNativeAd;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSMixAdViewUtil$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 implements KsApkDownloadListener {
        final KsNativeAd val$ad;
        final AdBaseViewHolder val$adBaseViewHolder;

        static {
            OSETSDKProtected.interface11(4029);
        }

        public AnonymousClass4(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd) {
            this.val$adBaseViewHolder = adBaseViewHolder;
            this.val$ad = ksNativeAd;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadFailed();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadFinished();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadStarted();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onIdle();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onInstalled();

        @Override // com.kwad.sdk.api.KsApkDownloadListener
        public native void onPaused(int i);

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onProgressUpdate(int i);
    }

    @Keep
    public static class AdBaseViewHolder {
        ViewGroup mAdContainer;
        TextView mAdConvertBtn;
        TextView mAdDesc;
        ImageView mAdIcon;
        ImageView mAdLogoIcon;
        TextView mAdName;
        TextView mAdSourceDesc;
        FrameLayout mAdVideoContainer;
        ImageView mDislikeBtn;

        static {
            OSETSDKProtected.interface11(4030);
        }

        public AdBaseViewHolder(View view) {
            this.mAdIcon = (ImageView) view.findViewById(R.id.oset_ks_app_icon);
            this.mAdName = (TextView) view.findViewById(R.id.oset_ks_app_title);
            this.mAdDesc = (TextView) view.findViewById(R.id.oset_ks_app_desc);
            this.mAdConvertBtn = (TextView) view.findViewById(R.id.oset_ks_app_download_btn);
            this.mDislikeBtn = (ImageView) view.findViewById(R.id.oset_ks_ad_dislike);
            this.mAdLogoIcon = (ImageView) view.findViewById(R.id.oset_ks_ksad_logo_icon);
            this.mAdSourceDesc = (TextView) view.findViewById(R.id.oset_ks_ksad_logo_text);
            this.mAdContainer = (ViewGroup) view.findViewById(R.id.oset_ks_ad_container);
            this.mAdVideoContainer = (FrameLayout) view.findViewById(R.id.oset_ks_video_container);
        }

        public native void destroy();
    }

    @Keep
    public static class AdGroupImageViewHolder extends AdBaseViewHolder {
        ImageView mAdImageLeft;
        ImageView mAdImageMid;
        ImageView mAdImageRight;

        static {
            OSETSDKProtected.interface11(4031);
        }

        public AdGroupImageViewHolder(View view) {
            super(view);
            this.mAdImageLeft = (ImageView) view.findViewById(R.id.oset_ks_ad_image_left);
            this.mAdImageMid = (ImageView) view.findViewById(R.id.oset_ks_ad_image_mid);
            this.mAdImageRight = (ImageView) view.findViewById(R.id.oset_ks_ad_image_right);
        }

        @Override // com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSMixAdViewUtil.AdBaseViewHolder
        public native void destroy();
    }

    @Keep
    public static class AdSingleImageViewHolder extends AdBaseViewHolder {
        ImageView mAdImage;

        public AdSingleImageViewHolder(View view) {
            super(view);
            this.mAdImage = (ImageView) view.findViewById(R.id.oset_ks_ad_image);
        }
    }

    @Keep
    public static class AdVideoViewHolder extends AdBaseViewHolder {
        public AdVideoViewHolder(View view) {
            super(view);
        }
    }

    @Keep
    public interface KSMixNativeAdInteractionListener {
        void onAdClicked();

        void onAdShow();

        void onAdShowFail(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4035);
    }

    private static native void bindCommonData(Activity activity, ViewGroup viewGroup, AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd, KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener);

    private static native void bindDownloadListener(AdBaseViewHolder adBaseViewHolder, KsNativeAd ksNativeAd);

    public static native void destroy();

    public static native View getGroupImageItemView(Activity activity, KsNativeAd ksNativeAd, KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener);

    public static native View getSingleImageItemView(Activity activity, KsNativeAd ksNativeAd, KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener);

    public static native View getVideoItemView(Activity activity, KsNativeAd ksNativeAd, KSMixNativeAdInteractionListener kSMixNativeAdInteractionListener);

    private static native void loadImage(Context context, String str, ImageView imageView);
}
