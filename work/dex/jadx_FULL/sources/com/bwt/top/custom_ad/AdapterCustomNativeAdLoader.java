package com.bwt.top.custom_ad;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bwt.top.AdUtil;
import com.bwt.top.NativeAd;
import com.bwt.top.NativeAdListener;
import com.bwt.top.R;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.ad.adapter.AdapterCustomAdLoader;
import com.bwt.top.ad.bean.NativeAdInfo;
import com.bwt.top.ad.bean.ddksa;
import com.bwt.top.custom_ad.http.CustomAdPosResult;
import com.bwt.top.exception.AdError;
import com.bwt.top.image.ImageLoaderCallback;
import com.bwt.top.image.ImageLoaderImp;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DisplayUtil;
import com.bwt.top.view.SlideLRLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdapterCustomNativeAdLoader extends AdapterCustomAdLoader<NativeAdInfo, NativeAdListener, NativeAd> {
    private ImageView closeIv;
    private TextView descTv;
    private ImageView icIV;
    private final View.OnClickListener mAdClickListener = new View.OnClickListener() { // from class: com.zj.adlib.h00
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f42019a.ddksa(view);
        }
    };

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener mAdTouchListener = new View.OnTouchListener() { // from class: com.zj.adlib.j00
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f42475a.kdsksdda(view, motionEvent);
        }
    };
    private TextView nameTv;
    private ViewGroup nativeView;
    private ImageView picIv;

    private void closeEvent() {
        try {
            ViewGroup viewGroup = this.nativeView;
            if (viewGroup == null) {
                return;
            }
            this.closeIv = (ImageView) viewGroup.findViewById(R.id.channel_native_close_iv);
            byte[] bArrDecode = Base64.decode(this.mCloseBitmap64, 0);
            this.closeIv.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            this.closeIv.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.f00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41559a.kdsksdda(view);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ddksa(View view) {
        adClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void kdsksdda(View view) {
        try {
            ViewGroup viewGroup = this.nativeView;
            if (viewGroup != null && viewGroup.getParent() != null && (this.nativeView.getParent() instanceof SlideLRLayout)) {
                ((SlideLRLayout) this.nativeView.getParent()).hideChild();
                adClose();
                return;
            }
            ViewGroup viewGroup2 = this.nativeView;
            if (viewGroup2 != null && viewGroup2.getTag() != null) {
                this.nativeView.setVisibility(8);
            }
            adClose();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean kdsksdda(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        adClick();
        return true;
    }

    private void setPopIconParams() {
        ViewGroup.LayoutParams layoutParams = this.icIV.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(1);
            layoutParams2.addRule(5, this.picIv.getId());
            layoutParams2.leftMargin = DisplayUtil.dp2px(1);
        }
    }

    private void updateIcon() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || this.mImageLoader == null || this.nativeView == null || TextUtils.isEmpty(customAdPosResult.getIconUrl())) {
            return;
        }
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), this.icIV);
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader, com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void adClick() {
        try {
            if (AdUtil.getsNativeAdPopHelper() != null && this.mIsClick) {
            } else {
                super.adClick();
            }
        } finally {
            if (AdUtil.getsNativeAdPopHelper() != null) {
                AdUtil.getsNativeAdPopHelper().closeAd();
            }
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public NativeAdInfo createAdInfo() {
        return new ddksa(this.mPosInfo, this) { // from class: com.bwt.top.custom_ad.AdapterCustomNativeAdLoader.1
            @Override // com.bwt.top.ad.bean.NativeAdInfo
            public View getNativeExpressAdView(ViewGroup viewGroup) {
                return AdapterCustomNativeAdLoader.this.nativeView;
            }

            @Override // com.bwt.top.view.INativeAdPop
            public View getNativePopView() {
                return AdapterCustomNativeAdLoader.this.getAdNativePopView();
            }

            @Override // com.bwt.top.ad.bean.NativeAdInfo
            public void render(ViewGroup viewGroup) {
                AdapterCustomNativeAdLoader.this.renderNativeAd(viewGroup);
            }
        };
    }

    public View getAdNativePopView() {
        ALog.d(this.TAG, "getNativePopView");
        if (this.nativeView == null || this.picIv == null || isReleased()) {
            return null;
        }
        this.nameTv.setVisibility(8);
        this.descTv.setVisibility(8);
        setPopIconParams();
        ViewGroup.LayoutParams layoutParams = this.picIv.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.picIv.setLayoutParams(layoutParams);
        this.picIv.setAdjustViewBounds(true);
        return this.nativeView;
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        super.readyAdView();
        ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.layout_channel_native, null);
        this.nativeView = viewGroup;
        this.picIv = (ImageView) viewGroup.findViewById(R.id.channel_native_iv);
        this.nameTv = (TextView) this.nativeView.findViewById(R.id.channel_native_name_tv);
        this.descTv = (TextView) this.nativeView.findViewById(R.id.channel_native_desc_tv);
        this.icIV = (ImageView) this.nativeView.findViewById(R.id.channel_native_ad_iv);
        closeEvent();
        if (this.mAdObject.isKeen()) {
            this.nativeView.setOnTouchListener(this.mAdTouchListener);
        } else {
            this.nativeView.setOnClickListener(this.mAdClickListener);
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterCustomAdLoader, com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.nativeView = null;
        this.picIv = null;
        this.nameTv = null;
        this.descTv = null;
    }

    public void renderNativeAd(ViewGroup viewGroup) {
        CustomAdPosResult customAdPosResult;
        if (isReleased()) {
            return;
        }
        ALog.d(this.TAG, "render");
        if (AdUtil.getsNativeAdPopHelper() != null && this.mAdObject != null) {
            AdUtil.getsNativeAdPopHelper().isKeen(this.mAdObject.isKeen());
        }
        if (viewGroup != null && viewGroup.getVisibility() != 0) {
            viewGroup.setVisibility(0);
        }
        ViewGroup viewGroup2 = this.nativeView;
        if (viewGroup2 != null && viewGroup2.getParent() != null && (this.nativeView.getParent() instanceof SlideLRLayout)) {
            this.closeIv.setVisibility(0);
        }
        ViewGroup viewGroup3 = this.nativeView;
        if (viewGroup3 != null && viewGroup3.getTag() != null) {
            this.closeIv.setVisibility(0);
        }
        ImageLoaderImp imageLoaderImp = this.mImageLoader;
        if (imageLoaderImp != null && (customAdPosResult = this.mAdObject) != null && this.picIv != null) {
            imageLoaderImp.loadImage(customAdPosResult.getImgUrl(), this.picIv, new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomNativeAdLoader.3
                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onError() {
                    if (((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd == null || ((NativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener() == null) {
                        return;
                    }
                    ((NativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener().onRenderFailed((NativeAdInfo) AdapterCustomNativeAdLoader.this.getAdInfo(), new AdError(301, "load img failed"));
                }

                @Override // com.bwt.top.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomNativeAdLoader.this.onAdExposeListener();
                }
            });
        }
        updateIcon();
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        this.nameTv.setText("" + this.mAdObject.getTitle());
        this.descTv.setText("" + this.mAdObject.getDesc());
        final ArrayList arrayList = new ArrayList();
        arrayList.add((NativeAdInfo) getAdInfo());
        this.mImageLoader.preLoadImage(this.mAdObject.getImgUrl(), new ImageLoaderCallback() { // from class: com.bwt.top.custom_ad.AdapterCustomNativeAdLoader.2
            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onError() {
                AdapterCustomNativeAdLoader.this.onAdFailedListener(new AdError(301, "preload img failed"));
            }

            @Override // com.bwt.top.image.ImageLoaderCallback
            public void onSuccess() {
                if (((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd == null || ((NativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener() == null) {
                    return;
                }
                ((NativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener().onAdReceive(arrayList);
            }
        });
    }
}
