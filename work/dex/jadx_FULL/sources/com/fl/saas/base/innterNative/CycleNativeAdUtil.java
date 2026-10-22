package com.fl.saas.base.innterNative;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CycleNativeAdUtil {
    public static NativeAdView getCycleView(Activity activity, NativeAd nativeAd, AdParams adParams, NativePrepareInfo nativePrepareInfo) {
        String mainImageUrl;
        if (activity == null || nativeAd == null || nativeAd.getAdMaterial() == null) {
            return null;
        }
        if (nativeAd.isNativeExpress()) {
            NativeAdView nativeAdView = new NativeAdView(activity);
            if (nativeAd.getAdMaterial().getAdMediaView() == null) {
                return null;
            }
            View adMediaView = nativeAd.getAdMaterial().getAdMediaView();
            ViewHelper.removeParent(adMediaView);
            nativeAdView.addView(adMediaView);
            nativeAd.renderAdContainer(nativeAdView, null);
            return nativeAdView;
        }
        NativeAdView nativeAdView2 = new NativeAdView(activity);
        View viewInflate = View.inflate(activity, R.layout.yd_saas_view_cycle_native, null);
        int mobileHeight = DeviceUtil.getMobileHeight();
        int iDip2px = DeviceUtil.dip2px(200.0f);
        if (adParams != null) {
            float expressHeight = adParams.getExpressHeight();
            if (expressHeight > 0.0f) {
                iDip2px = DeviceUtil.dip2px(expressHeight);
            }
            mobileHeight = DeviceUtil.dip2px(adParams.getExpressWidth());
        }
        nativeAdView2.addView(viewInflate, new FrameLayout.LayoutParams(mobileHeight, iDip2px));
        nativeAd.renderAdContainer(nativeAdView2, viewInflate);
        View view = (ImageView) viewInflate.findViewById(R.id.iv_closed);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_logo);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.text_desc);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.img_poster);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.fl_mediaview);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.iv_ad);
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        textView.setText(adMaterial.getTitle());
        textView2.setText(adMaterial.getDescription());
        if (!TextUtils.isEmpty(adMaterial.getIconUrl())) {
            ImageLoader.loadImage(adMaterial.getIconUrl(), imageView);
        }
        if (adMaterial.getAdMediaView() != null) {
            imageView2.setVisibility(8);
            View adMediaView2 = adMaterial.getAdMediaView();
            ViewHelper.removeParent(adMediaView2);
            frameLayout.addView(adMediaView2, new FrameLayout.LayoutParams(-1, -1));
        } else {
            frameLayout.setVisibility(8);
            if (TextUtils.isEmpty(adMaterial.getMainImageUrl())) {
                mainImageUrl = (String) Check.findFirstNonNull(adMaterial.getImageUrlList());
                if (!TextUtils.isEmpty(mainImageUrl)) {
                }
            } else {
                mainImageUrl = adMaterial.getMainImageUrl();
            }
            ImageLoader.loadImage(mainImageUrl, imageView2);
        }
        if (adMaterial.getAdLogoBitmap() != null) {
            imageView3.setImageBitmap(adMaterial.getAdLogoBitmap());
        } else if (!TextUtils.isEmpty(adMaterial.getAdLogoUrl())) {
            ImageLoader.loadImage(adMaterial.getAdLogoUrl(), imageView3);
        }
        nativePrepareInfo.setClickView(viewInflate);
        nativePrepareInfo.setCloseView(view);
        nativePrepareInfo.setImageView(imageView2);
        return nativeAdView2;
    }
}
