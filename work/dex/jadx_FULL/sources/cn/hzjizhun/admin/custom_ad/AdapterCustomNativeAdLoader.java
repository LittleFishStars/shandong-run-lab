package cn.hzjizhun.admin.custom_ad;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;
import cn.hzjizhun.admin.ad.utils.JZAdUtil;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.image.ImageLoaderCallback;
import cn.hzjizhun.admin.image.ImageLoaderImp;
import cn.hzjizhun.admin.sdaa;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.view.INativeAdPop;
import cn.hzjizhun.admin.view.NativeAdPopHelper;
import cn.hzjizhun.admin.view.SlideLRLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomNativeAdLoader extends AdapterCustomAdLoader<JZNativeAdInfo, JZNativeAdListener, JZNativeAd> {
    private final View.OnClickListener mAdClickListener = new View.OnClickListener() { // from class: com.zj.adlib.i00
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f42240a.lambda$new$1(view);
        }
    };

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener mAdTouchListener = new View.OnTouchListener() { // from class: com.zj.adlib.k00
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f42710a.lambda$new$2(view, motionEvent);
        }
    };
    private ImageView mCloseIv;
    private ViewGroup mNativeView;

    private void closeEvent(final ViewGroup viewGroup, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.g00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f16649a.lambda$closeEvent$0(viewGroup, view);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAdNativeExpressAdView() {
        try {
            if (!isReleased() && this.mAdObject != null) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.jz_layout_channel_native, null);
                this.mNativeView = viewGroup;
                ImageView imageView = (ImageView) viewGroup.findViewById(R.id.channel_native_iv);
                TextView textView = (TextView) this.mNativeView.findViewById(R.id.channel_native_name_tv);
                TextView textView2 = (TextView) this.mNativeView.findViewById(R.id.channel_native_desc_tv);
                ImageView imageView2 = (ImageView) this.mNativeView.findViewById(R.id.channel_native_ad_iv);
                ImageView imageView3 = (ImageView) this.mNativeView.findViewById(R.id.channel_native_close_iv);
                this.mCloseIv = imageView3;
                setCloseViewIcon(imageView3);
                closeEvent(this.mNativeView, this.mCloseIv);
                loadPicView(imageView);
                updateIcon(imageView2);
                String title = this.mAdObject.getTitle();
                String desc = this.mAdObject.getDesc();
                if (TextUtils.isEmpty(title) && TextUtils.isEmpty(desc)) {
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    getAdNativeFlowOnlyPicView(imageView, imageView2, this.mCloseIv);
                } else {
                    textView.setText("" + title);
                    textView2.setText("" + desc);
                }
                if (this.mAdObject.isKeen()) {
                    this.mNativeView.setOnTouchListener(this.mAdTouchListener);
                } else {
                    this.mNativeView.setOnClickListener(this.mAdClickListener);
                }
                return this.mNativeView;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private NativeAdPopHelper getNativeAdPopHelper() {
        try {
            return JZAdUtil.getsNativeAdPopHelper((JZNativeAdInfo) this.mAdInfo);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeEvent$0(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            try {
                if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof SlideLRLayout)) {
                    ((SlideLRLayout) viewGroup.getParent()).hideChild();
                    adClose();
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (viewGroup != null && viewGroup.getTag() != null) {
            viewGroup.setVisibility(8);
        }
        adClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        adClickSource(Cs.MC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        adClickSource(Cs.KC);
        return true;
    }

    private void loadPicView(ImageView imageView) {
        CustomAdPosResult customAdPosResult;
        ImageLoaderImp imageLoaderImp = this.mImageLoader;
        if (imageLoaderImp == null || (customAdPosResult = this.mAdObject) == null || imageView == null) {
            return;
        }
        imageLoaderImp.loadImage(customAdPosResult.getImgUrl(), imageView, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomNativeAdLoader.3
            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onError() {
                if (((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd == null || ((JZNativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener() == null) {
                    return;
                }
                ((JZNativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener().onRenderFailed((JZNativeAdInfo) AdapterCustomNativeAdLoader.this.getAdInfo(), new JZAdError(302, "load img failed"));
            }

            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onSuccess() {
                ALog.d(((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).TAG, "开始曝光");
                AdapterCustomNativeAdLoader.this.onAdExposeListener();
            }
        });
    }

    private void setOnlyIconParams(ImageView imageView, ImageView imageView2) {
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.removeRule(1);
            layoutParams2.removeRule(8);
            layoutParams2.addRule(3, imageView.getId());
            layoutParams2.addRule(5, imageView.getId());
            layoutParams2.bottomMargin = DisplayUtil.dp2px(16);
            layoutParams2.leftMargin = DisplayUtil.dp2px(0);
            imageView2.setLayoutParams(layoutParams2);
        }
    }

    private void updateIcon(ImageView imageView) {
        ImageLoaderImp imageLoaderImp;
        try {
            CustomAdPosResult customAdPosResult = this.mAdObject;
            if (customAdPosResult == null || (imageLoaderImp = this.mImageLoader) == null || imageView == null) {
                return;
            }
            imageLoaderImp.loadIcon(customAdPosResult.getIconUrl(), imageView);
        } catch (Throwable unused) {
        }
    }

    public void getAdNativeFlowOnlyPicView(ImageView imageView, ImageView imageView2, ImageView imageView3) {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -2;
            marginLayoutParams.setMargins(DisplayUtil.dp2px(16), DisplayUtil.dp2px(16), DisplayUtil.dp2px(16), 0);
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setAdjustViewBounds(true);
            setOnlyIconParams(imageView, imageView2);
            setNativeFlowCloseIvParams(imageView3, imageView);
        } catch (Throwable unused) {
        }
    }

    public View getAdNativePopView() {
        CustomAdPosResult customAdPosResult;
        try {
            if (isReleased() || (customAdPosResult = this.mAdObject) == null) {
                return null;
            }
            customAdPosResult.isNativePop = true;
            ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.jz_layout_channel_native_pop, null);
            this.mNativeView = viewGroup;
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.channel_pic_iv);
            ImageView imageView2 = (ImageView) this.mNativeView.findViewById(R.id.iv_ad_icon);
            LinearLayout linearLayout = (LinearLayout) this.mNativeView.findViewById(R.id.llPopClick);
            loadPicView(imageView);
            updateIcon(imageView2);
            if (this.mAdObject.isKeen()) {
                this.mNativeView.setOnTouchListener(this.mAdTouchListener);
            } else {
                linearLayout.setOnClickListener(this.mAdClickListener);
            }
            return this.mNativeView;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader, cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        T t = this.mAd;
        if (t != 0 && ((JZNativeAd) t).getAdListener() != null) {
            JZAdUtil.removeNativeAdPopHelper((INativeAdPop) this.mAdInfo);
        }
        this.mNativeView = null;
    }

    public void renderNativeAd(ViewGroup viewGroup) {
        ImageView imageView;
        ImageView imageView2;
        try {
            if (isReleased()) {
                return;
            }
            ALog.d(this.TAG, "render...");
            if (getNativeAdPopHelper() != null && this.mAdObject != null) {
                getNativeAdPopHelper().isKeen(this.mAdObject.isKeen());
            }
            if (viewGroup != null && viewGroup.getVisibility() != 0) {
                viewGroup.setVisibility(0);
            }
            ViewGroup viewGroup2 = this.mNativeView;
            if (viewGroup2 != null && viewGroup2.getParent() != null && (this.mNativeView.getParent() instanceof SlideLRLayout) && (imageView2 = this.mCloseIv) != null) {
                imageView2.setVisibility(0);
            }
            ViewGroup viewGroup3 = this.mNativeView;
            if (viewGroup3 == null || viewGroup3.getTag() == null || (imageView = this.mCloseIv) == null) {
                return;
            }
            imageView.setVisibility(0);
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        try {
            final ArrayList arrayList = new ArrayList();
            arrayList.add((JZNativeAdInfo) getAdInfo());
            this.mImageLoader.preLoadImage(this.mAdObject.getImgUrl(), new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomNativeAdLoader.2
                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onError() {
                    AdapterCustomNativeAdLoader.this.onAdFailedListener(new JZAdError(301, "preload img failed"));
                }

                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onSuccess() {
                    if (((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd == null || ((JZNativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener() == null) {
                        return;
                    }
                    ((JZNativeAd) ((AdapterAdLoaderImp) AdapterCustomNativeAdLoader.this).mAd).getAdListener().onAdReceive(arrayList);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void setNativeFlowCloseIvParams(ImageView imageView, ImageView imageView2) {
        if (imageView == null || imageView2 == null) {
            return;
        }
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) marginLayoutParams;
                layoutParams.removeRule(11);
                layoutParams.removeRule(8);
                layoutParams.addRule(3, imageView2.getId());
                layoutParams.addRule(7, imageView2.getId());
                layoutParams.bottomMargin = DisplayUtil.dp2px(0);
                layoutParams.rightMargin = DisplayUtil.dp2px(0);
                imageView.setLayoutParams(layoutParams);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZNativeAdInfo createAdInfo() {
        return new sdaa(this.mPosInfo, this) { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomNativeAdLoader.1
            @Override // cn.hzjizhun.admin.view.INativeAdFlow
            public View getNativeExpressAdView(ViewGroup viewGroup) {
                return AdapterCustomNativeAdLoader.this.getAdNativeExpressAdView();
            }

            @Override // cn.hzjizhun.admin.view.INativeAdPop
            public View getNativePopView() {
                return AdapterCustomNativeAdLoader.this.getAdNativePopView();
            }

            @Override // cn.hzjizhun.admin.ad.bean.JZNativeBaseAdInfo
            public void render(ViewGroup viewGroup) {
                AdapterCustomNativeAdLoader.this.renderNativeAd(viewGroup);
            }
        };
    }
}
