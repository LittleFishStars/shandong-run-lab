package com.fl.saas.adx.base.inner.spread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.C1428p0;
import com.fl.saas.R;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.base.bean.Size;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.base.inner.InnerNativeViewHelper;
import com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.adx.base.inner.spread.coustomView.SpreadHorizontalView;
import com.fl.saas.adx.base.inner.spread.coustomView.SpreadVerticalView;
import com.fl.saas.adx.base.widget.InterceptClickLayout;
import com.fl.saas.adx.base.widget.SkipView;
import com.fl.saas.adx.util.Check;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;
import com.zj.adlib.pf4;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SpreadViewHelper implements NativeSpreadView {
    private final View clickArea;
    private final ImageView guideView;
    private final ImageView ivClickArea;
    private final ImageView mAdLogo;
    private final View mClick;
    private final Context mContext;
    private final SpreadViewEvent mEvent;
    private final SkipView mSkip;
    private InnerNativeCustomView mSpreadView;
    private final NativeMaterial material;
    private NativeAdView nativeAdView;
    private final String skipDes;
    private final InterceptClickLayout spreadContainer;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.spread.SpreadViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements FLImageLoader.OnBitmapLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoaded$0(B b, String str, Bitmap bitmap, boolean z) {
            if (bitmap == null || b == null) {
                return;
            }
            b.a(bitmap);
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
        public void onBitmapLoadFailed(String str, String str2) {
            if (DeviceUtil.filling_timing != 0) {
                SpreadViewHelper.this.mEvent.onAdFailed(new FLError("图片加载失败"));
            }
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
        public void onBitmapLoaded(String str, Bitmap bitmap, boolean z) {
            SpreadViewHelper spreadViewHelper;
            InnerNativeCustomView spreadVerticalView;
            Drawable drawableA = AbstractC1398a0.a(SpreadViewHelper.this.mContext, bitmap);
            if (drawableA == null) {
                if (DeviceUtil.filling_timing != 0) {
                    SpreadViewHelper.this.mEvent.onAdFailed(new FLError("图片加载失败"));
                    return;
                }
                return;
            }
            if (DeviceUtil.filling_timing != 0) {
                if (drawableA.getIntrinsicWidth() > drawableA.getIntrinsicHeight()) {
                    spreadViewHelper = SpreadViewHelper.this;
                    spreadVerticalView = new SpreadHorizontalView(spreadViewHelper.mContext);
                } else {
                    spreadViewHelper = SpreadViewHelper.this;
                    spreadVerticalView = new SpreadVerticalView(spreadViewHelper.mContext);
                }
                spreadViewHelper.mSpreadView = spreadVerticalView;
            }
            final B bLoadIcon = SpreadViewHelper.this.mSpreadView.loadIcon();
            if (bLoadIcon != null && !TextUtils.isEmpty(SpreadViewHelper.this.material.getIconUrl())) {
                FLImageLoader.getInstance(SpreadViewHelper.this.mContext).loadBitmap(SpreadViewHelper.this.material.getIconUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.adx.base.inner.spread.b
                    @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str2, Bitmap bitmap2, boolean z2) {
                        SpreadViewHelper.AnonymousClass1.lambda$onBitmapLoaded$0(bLoadIcon, str2, bitmap2, z2);
                    }
                });
            }
            SpreadViewHelper spreadViewHelper2 = SpreadViewHelper.this;
            spreadViewHelper2.bindMediaView(spreadViewHelper2.mSpreadView, drawableA);
            if (DeviceUtil.filling_timing != 0) {
                SpreadViewHelper.this.mEvent.onLoaded(SpreadViewHelper.this);
            }
        }
    }

    public SpreadViewHelper(Context context, NativeMaterial nativeMaterial, SpreadViewEvent spreadViewEvent) {
        this.skipDes = TextUtils.equals("zh-CN", DeviceUtil.getSysLanguage()) ? "跳过 " : "Skip ";
        this.mContext = context;
        this.material = nativeMaterial;
        InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(context, R.layout.fl_adx_spread);
        this.spreadContainer = interceptClickLayout;
        interceptClickLayout.setMatchParent();
        this.mEvent = spreadViewEvent;
        this.mAdLogo = (ImageView) interceptClickLayout.findViewById(R.id.iv_ad_logo);
        this.mSkip = (SkipView) interceptClickLayout.findViewById(R.id.v_skip);
        this.mClick = interceptClickLayout.findViewById(R.id.v_click);
        this.clickArea = interceptClickLayout.findViewById(R.id.yd_saas_click_area);
        this.ivClickArea = (ImageView) interceptClickLayout.findViewById(R.id.iv_click_area);
        this.guideView = (ImageView) interceptClickLayout.findViewById(R.id.yd_saas_click_area_guide);
    }

    private void addAppInfo() {
        TextView textViewCreateAppInfoView = InnerNativeViewHelper.createAppInfoView(this.mContext, this.material);
        if (textViewCreateAppInfoView == null) {
            return;
        }
        textViewCreateAppInfoView.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#4D000000"), Color.parseColor("#00000000")}));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int iDip2px = DeviceUtil.dip2px(10.0f);
        textViewCreateAppInfoView.setPadding(iDip2px, iDip2px, iDip2px, 0);
        layoutParams.gravity = 48;
        this.spreadContainer.addView(textViewCreateAppInfoView, layoutParams);
        this.spreadContainer.addFilterViews(textViewCreateAppInfoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindMediaView(InnerNativeCustomView innerNativeCustomView, Drawable drawable) {
        innerNativeCustomView.setMediaView((this.material.getAdType() != 3 || this.material.getAdMediaView() == null) ? null : this.material.getAdMediaView(), drawable);
        this.spreadContainer.addView(this.mSpreadView.getAdView(), 0, ViewHelper.getMatchParent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$initView$0(Integer num) {
        if (num.intValue() == 0) {
            return this.skipDes;
        }
        return this.skipDes + num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.mEvent.onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        cancelCountdown();
        this.mEvent.onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setInterceptClick$3(float f, float f2) {
        if (this.clickArea.getVisibility() != 0) {
            return false;
        }
        Rect viewRectOnScreen = ViewHelper.getViewRectOnScreen(this.clickArea);
        return Math.pow((double) (f - ((float) (DeviceUtil.getMobileWidth() / 2))), 2.0d) + Math.pow((double) (f2 - ((float) (viewRectOnScreen.bottom - DeviceUtil.dip2px(28.0f)))), 2.0d) <= Math.pow((double) ((viewRectOnScreen.width() / 2) - DeviceUtil.dip2px(10.0f)), 2.0d);
    }

    private void loadAdIcon() {
        if (this.material.getAdLogo() != null) {
            this.mAdLogo.setImageBitmap(this.material.getAdLogo());
        } else {
            if (TextUtils.isEmpty(this.material.getAdLogoUrl())) {
                return;
            }
            FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.mAdLogo, this.material.getAdLogoUrl());
        }
    }

    private void loadView() {
        View adMediaView = this.material.getAdMediaView();
        String mainImageUrl = !TextUtils.isEmpty(this.material.getMainImageUrl()) ? this.material.getMainImageUrl() : (String) Check.findFirstNonNull(this.material.getImageUrlList());
        if (!TextUtils.isEmpty(mainImageUrl)) {
            if (DeviceUtil.filling_timing == 0) {
                Size size = this.material.getSize();
                InnerNativeCustomView spreadVerticalView = (size == null || size.getWidth() <= size.getHeight()) ? new SpreadVerticalView(this.mContext) : new SpreadHorizontalView(this.mContext);
                this.mSpreadView = spreadVerticalView;
                this.mEvent.onLoaded(this);
            }
            FLImageLoader.getInstance(this.mContext).loadBitmap(mainImageUrl, new AnonymousClass1());
            return;
        }
        if (adMediaView == null) {
            this.mEvent.onAdFailed(FLError.create(20405, "media and imgUrl is empty"));
            return;
        }
        SpreadVerticalView spreadVerticalView2 = new SpreadVerticalView(this.mContext);
        this.mSpreadView = spreadVerticalView2;
        bindMediaView(spreadVerticalView2, null);
        this.mEvent.onLoaded(this);
    }

    private void render() {
        this.mSpreadView.setTitle(this.material.getTitle()).setCAT(this.material.getCallToAction()).setDes(this.material.getDescription());
        loadAdIcon();
        this.spreadContainer.addFilterViews(this.mSpreadView.getCATView());
    }

    private void setInterceptClick() {
        this.spreadContainer.setOutIntercept(new InterceptClickLayout.OnIntercept() { // from class: com.zj.adlib.qo8
            @Override // com.fl.saas.adx.base.widget.InterceptClickLayout.OnIntercept
            public final boolean isIntercept(float f, float f2) {
                return this.f44264a.lambda$setInterceptClick$3(f, f2);
            }
        });
    }

    private void setInterceptFilter() {
        this.spreadContainer.setFilterPattern(2);
        this.spreadContainer.addFilterViews(this.mSkip);
        this.spreadContainer.addFilterViews(this.mClick);
    }

    private void startGuideAnimation() {
        if (this.clickArea.getVisibility() == 0) {
            this.guideView.startAnimation(AnimationUtils.loadAnimation(this.guideView.getContext(), R.anim.fl_adx_anim_spread_guide));
        }
    }

    @Override // com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView
    public void cancelCountdown() {
        this.mSkip.cancel();
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public View getCATView() {
        return (View) C1428p0.a(this.mSpreadView).a((Function) new pf4()).c(null);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public View[] getClicks() {
        return new View[]{this.mSpreadView.getAdView(), this.mClick, this.clickArea};
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public NativeAdView getNativeAdView() {
        if (this.nativeAdView == null) {
            NativeAdView nativeAdView = new NativeAdView(this.mContext);
            this.nativeAdView = nativeAdView;
            nativeAdView.removeAllViews();
            this.nativeAdView.addView(getSelfView(), ViewHelper.getMatchParent());
        }
        return this.nativeAdView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public ViewGroup getSelfView() {
        return this.spreadContainer;
    }

    public void initView() {
        this.mSkip.setOnTick(new Function() { // from class: com.zj.adlib.ko8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f42872a.lambda$initView$0((Integer) obj);
            }
        }).setFinish(new Runnable() { // from class: com.zj.adlib.mo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f43350a.lambda$initView$1();
            }
        }).setCancel(new Runnable() { // from class: com.zj.adlib.oo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f43794a.lambda$initView$2();
            }
        });
        setInterceptClick();
        loadView();
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public void onClicked() {
        SkipView skipView = this.mSkip;
        if (skipView != null) {
            skipView.onClick();
        }
    }

    @Override // com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView
    public void setClickAreaVisibility(View view) {
        if (view != null) {
            this.clickArea.setVisibility(8);
            setInterceptFilter();
            this.spreadContainer.addFilterViews(view);
        } else {
            this.clickArea.setVisibility(0);
            FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.guideView, "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp");
            FLImageLoader.getInstance(this.mContext).setEnableDiskCache(true).setEnableMemoryCache(true).loadImage(this.ivClickArea, "https://creative.medproad.com/medpro/imgs/yd_saas_bg_click_area.webp");
            setInterceptFilter();
        }
    }

    @Override // com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView
    public void setViewType(boolean z, boolean z2, int i) {
        SkipView skipView = this.mSkip;
        if (skipView != null) {
            if (z2) {
                skipView.setValue(1, i);
            }
            this.mSkip.setShowCountDown(z);
        }
    }

    @Override // com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView
    public void show() {
        render();
        addAppInfo();
        View view = this.mClick;
        if (view != null) {
            view.bringToFront();
        }
        SkipView skipView = this.mSkip;
        if (skipView != null) {
            skipView.bringToFront();
        }
    }

    @Override // com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView
    public void startCountdown() {
        this.mSkip.start();
        startGuideAnimation();
    }
}
