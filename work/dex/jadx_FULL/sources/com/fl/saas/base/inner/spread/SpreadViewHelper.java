package com.fl.saas.base.inner.spread;

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
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.InnerNativeViewHelper;
import com.fl.saas.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.base.inner.spread.coustomView.SpreadHorizontalView;
import com.fl.saas.base.inner.spread.coustomView.SpreadVerticalView;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.common.widget.InterceptClickLayout;
import com.fl.saas.common.widget.SkipView;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.zj.adlib.cg4;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SpreadViewHelper implements NativeSpreadView {
    private final View clickArea;
    private final ImageView guideView;
    private boolean hasClickArea;
    private final ImageView ivClickArea;
    private final ImageView mAdLogo;
    private final View mClick;
    private Context mContext;
    private final SpreadViewEvent mEvent;
    private final SkipView mSkip;
    private InnerNativeCustomView mSpreadView;
    private final NativeMaterial material;
    private NativeAdView nativeAdView;
    private RainTextureView rainTextureView;
    private final String skipDes;
    private final InterceptClickLayout spreadContainer;

    public SpreadViewHelper(Context context, NativeMaterial nativeMaterial, SpreadViewEvent spreadViewEvent) {
        this.skipDes = TextUtils.equals("zh-CN", DeviceUtil.getSysLanguage()) ? "跳过 " : "Skip ";
        this.hasClickArea = false;
        this.mContext = context;
        this.material = nativeMaterial;
        InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(context, R.layout.yd_saas_spread);
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

    private void bindMediaView(InnerNativeCustomView innerNativeCustomView, Drawable drawable) {
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
        stopRain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        cancelCountdown();
        this.mEvent.onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadView$3(Drawable drawable) {
        if (DeviceUtil.filling_timing != 0) {
            this.mSpreadView = drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight() ? new SpreadHorizontalView(this.mContext) : new SpreadVerticalView(this.mContext);
            this.mEvent.onLoaded(this);
        }
        Consumer<Bitmap> consumerLoadIcon = this.mSpreadView.loadIcon();
        if (consumerLoadIcon != null && !TextUtils.isEmpty(this.material.getIconUrl())) {
            ImageLoader.loadImageBitmap(this.material.getIconUrl(), consumerLoadIcon);
        }
        bindMediaView(this.mSpreadView, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setInterceptClick$5(float f, float f2) {
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView != null && (rainTextureView.isClickItem(f, f2) || this.rainTextureView.hasClickItem())) {
            return true;
        }
        if (this.clickArea.getVisibility() != 0) {
            return false;
        }
        Rect viewRectOnScreen = ViewHelper.getViewRectOnScreen(this.clickArea);
        return Math.pow((double) (f - ((float) (DeviceUtil.getMobileWidth() / 2))), 2.0d) + Math.pow((double) (f2 - ((float) (viewRectOnScreen.bottom - DeviceUtil.dip2px(28.0f)))), 2.0d) <= Math.pow((double) ((viewRectOnScreen.width() / 2) - DeviceUtil.dip2px(10.0f)), 2.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRainView$4() {
        this.rainTextureView = null;
        this.spreadContainer.setFilterPattern(this.hasClickArea ? 2 : 0);
    }

    private void loadAdIcon() {
        if (this.material.getAdLogo() != null) {
            this.mAdLogo.setImageBitmap(this.material.getAdLogo());
        } else {
            if (TextUtils.isEmpty(this.material.getAdLogoUrl())) {
                return;
            }
            ImageLoader.loadImage(this.material.getAdLogoUrl(), this.mAdLogo);
        }
    }

    private void loadView() {
        View adMediaView = this.material.getAdMediaView();
        String mainImageUrl = !TextUtils.isEmpty(this.material.getMainImageUrl()) ? this.material.getMainImageUrl() : (String) Check.findFirstNonNull(this.material.getImageUrlList());
        if (TextUtils.isEmpty(mainImageUrl)) {
            if (adMediaView == null) {
                this.mEvent.onAdFailed(YdError.create(20405, "media and imgUrl is empty"));
                return;
            }
            SpreadVerticalView spreadVerticalView = new SpreadVerticalView(this.mContext);
            this.mSpreadView = spreadVerticalView;
            bindMediaView(spreadVerticalView, null);
            this.mEvent.onLoaded(this);
            return;
        }
        ImageLoader.loadImage("https://creative.medproad.com/medpro/imgs/yd_saas_bg_click_area.webp", this.ivClickArea);
        if (DeviceUtil.filling_timing == 0) {
            Size size = this.material.getSize();
            InnerNativeCustomView spreadVerticalView2 = (size == null || size.getWidth() <= size.getHeight()) ? new SpreadVerticalView(this.mContext) : new SpreadHorizontalView(this.mContext);
            this.mSpreadView = spreadVerticalView2;
            this.mEvent.onLoaded(this);
        }
        Consumer consumer = new Consumer() { // from class: com.zj.adlib.so8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44736a.lambda$loadView$3((Drawable) obj);
            }
        };
        final SpreadViewEvent spreadViewEvent = this.mEvent;
        Objects.requireNonNull(spreadViewEvent);
        ImageLoader.loadImageDrawable(mainImageUrl, consumer, new Consumer() { // from class: com.zj.adlib.to8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                spreadViewEvent.onAdFailed((YdError) obj);
            }
        });
    }

    private void render() {
        this.mSpreadView.setTitle(this.material.getTitle()).setCAT(this.material.getCallToAction()).setDes(this.material.getDescription());
        loadAdIcon();
        this.spreadContainer.addFilterViews(this.mSpreadView.getCATView());
    }

    private void setInterceptClick() {
        this.spreadContainer.setOutIntercept(new InterceptClickLayout.OnIntercept() { // from class: com.zj.adlib.vo8
            @Override // com.fl.saas.common.widget.InterceptClickLayout.OnIntercept
            public final boolean isIntercept(float f, float f2) {
                return this.f45405a.lambda$setInterceptClick$5(f, f2);
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
            this.guideView.startAnimation(AnimationUtils.loadAnimation(this.guideView.getContext(), R.anim.yd_saas_anim_spread_guide));
        }
    }

    private void stopRain() {
        Optional.ofNullable(this.rainTextureView).ifPresent(new Consumer() { // from class: com.zj.adlib.po8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((RainTextureView) obj).stop();
            }
        });
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void cancelCountdown() {
        this.mSkip.cancel();
        stopRain();
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View getCATView() {
        return (View) Optional.of(this.mSpreadView).map(new cg4()).orElse(null);
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View[] getClicks() {
        return new View[]{this.mSpreadView.getAdView(), this.mClick, this.clickArea, this.rainTextureView};
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public NativeAdView getNativeAdView() {
        if (this.nativeAdView == null) {
            NativeAdView nativeAdView = new NativeAdView(this.mContext);
            this.nativeAdView = nativeAdView;
            nativeAdView.removeAllViews();
            this.nativeAdView.addView(getSelfView(), ViewHelper.getMatchParent());
        }
        return this.nativeAdView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public ViewGroup getSelfView() {
        return this.spreadContainer;
    }

    public void initView() {
        ImageLoader.loadImage("https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp", this.guideView);
        this.mSkip.setOnTick(new Function() { // from class: com.zj.adlib.jo8
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f42630a.lambda$initView$0((Integer) obj);
            }
        }).setFinish(new Runnable() { // from class: com.zj.adlib.lo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f43116a.lambda$initView$1();
            }
        }).setCancel(new Runnable() { // from class: com.zj.adlib.no8
            @Override // java.lang.Runnable
            public final void run() {
                this.f43575a.lambda$initView$2();
            }
        });
        setInterceptClick();
        loadView();
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public void onClicked() {
        stopRain();
        SkipView skipView = this.mSkip;
        if (skipView != null) {
            skipView.onClick();
        }
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void setClickAreaVisibility(boolean z, View view) {
        this.hasClickArea = view != null || z;
        if (view != null) {
            setInterceptFilter();
            this.spreadContainer.addFilterViews(view);
        } else {
            this.clickArea.setVisibility(z ? 0 : 8);
            if (z) {
                setInterceptFilter();
            }
        }
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void setContext(Context context) {
        this.mContext = context;
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void setRainView(boolean z) {
        if (z) {
            this.rainTextureView = new RainTextureView(this.mContext);
            ViewHelper.removeParent(this.mSkip);
            InterceptClickLayout interceptClickLayout = this.spreadContainer;
            interceptClickLayout.addView(this.rainTextureView, interceptClickLayout.getChildCount(), ViewHelper.getMatchParent());
            InterceptClickLayout interceptClickLayout2 = this.spreadContainer;
            interceptClickLayout2.addView(this.mSkip, interceptClickLayout2.getChildCount());
            this.rainTextureView.setAutoRemove();
            this.rainTextureView.setOnStatusListener(new RainTextureView.OnStatusListener() { // from class: com.zj.adlib.ro8
                @Override // com.fl.saas.base.widget.RainTextureView.OnStatusListener
                public final void onStop() {
                    this.f44499a.lambda$setRainView$4();
                }
            });
        }
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void setViewType(boolean z, boolean z2, int i) {
        SkipView skipView = this.mSkip;
        if (skipView != null) {
            if (z2) {
                skipView.setValue(1, i);
            }
            this.mSkip.setShowCountDown(z);
        }
    }

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
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

    @Override // com.fl.saas.base.inner.spread.coustomView.NativeSpreadView
    public void startCountdown() {
        this.mSkip.start();
        startGuideAnimation();
        Optional.ofNullable(this.rainTextureView).ifPresent(new Consumer() { // from class: com.zj.adlib.uo8
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((RainTextureView) obj).start();
            }
        });
    }
}
