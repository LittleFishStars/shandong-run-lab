package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.core.util.Pair;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.InnerNativeViewHelper;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMHView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialHMVView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMHView;
import com.fl.saas.base.inner.interstitial.coustomView.InterstitialVMVView;
import com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.base.innterNative.BindActionView;
import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.saas.bean.CloseButtonPosition;
import com.fl.saas.common.saas.bean.Orientation;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.YdImageLoader;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Size;
import com.fl.saas.common.widget.CountDownTextView;
import com.fl.saas.common.widget.InterceptClickLayout;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.zj.adlib.cg4;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialViewHelper implements NativeInterstitialView {
    private WeakReference<Activity> activityRef;
    private final FrameLayout adContainer;
    private int animalStartTime;
    private int animalTime;
    private int clickType;
    private ImageView closeView;
    private final RelativeLayout closeViewLayout;
    private int count;
    private Dialog dialog;
    private Orientation dialogStyle;
    private ImageView envelopeCloseView;
    private View envelopeVClose;
    private boolean isFullScreenInterstitial;
    private boolean isShakeType;
    private boolean isVisible;
    private final ImageView mAdLogo;
    private WeakReference<Context> mContext;
    private CountDownTextView mEnvelopeSkip;
    private InnerNativeCustomView mInterstitialView;
    private boolean mIsAutoClose;
    private final InterceptClickLayout mLayout;
    private final InterstitialViewEvent mLoaderEvent;
    private final NativeMaterial mMaterial;
    private CountDownTextView mSkip;
    private NativeAdView nativeAdView;
    private CloseButtonPosition pos;
    private RainTextureView rainTextureView;
    private int scaleSize;
    private int speed;
    private View vBottomArea;
    private View vClose;
    private View vTopArea;
    private boolean isApi = false;
    private boolean smallEnvelope = false;
    private boolean isDestroyed = false;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.interstitial.InterstitialViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements YdImageLoader.OnBitmapLoadListener {
        final /* synthetic */ WeakReference val$selfRef;

        public AnonymousClass1(WeakReference weakReference) {
            this.val$selfRef = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoadFailed$2(InterstitialViewHelper interstitialViewHelper, Consumer consumer, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || consumer == null) {
                return;
            }
            consumer.accept(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoaded$0(InterstitialViewHelper interstitialViewHelper, Consumer consumer, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || consumer == null) {
                return;
            }
            consumer.accept(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoaded$1(InterstitialViewHelper interstitialViewHelper, Consumer consumer, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || consumer == null) {
                return;
            }
            consumer.accept(bitmap);
        }

        @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadListener
        public void onBitmapLoadFailed(String str, String str2) {
            final InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) this.val$selfRef.get();
            if (DeviceUtil.filling_timing != 0) {
                if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
                    return;
                }
                interstitialViewHelper.mLoaderEvent.onAdFailed(new YdError("素材加载失败"));
                return;
            }
            if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
                return;
            }
            final Consumer<Bitmap> consumerLoadIcon = interstitialViewHelper.mInterstitialView.loadIcon();
            if (consumerLoadIcon != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                YdImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new YdImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.base.inner.interstitial.d
                    @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str3, Bitmap bitmap, boolean z) {
                        InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoadFailed$2(interstitialViewHelper, consumerLoadIcon, str3, bitmap, z);
                    }
                });
            }
            interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, null);
            if (DeviceUtil.filling_timing != 0) {
                interstitialViewHelper.mLoaderEvent.onLoaded(interstitialViewHelper);
            }
        }

        @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadListener
        public void onBitmapLoaded(String str, Bitmap bitmap, boolean z) {
            final InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) this.val$selfRef.get();
            if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (DeviceUtil.filling_timing != 0) {
                interstitialViewHelper.mLoaderEvent.onLoaded(interstitialViewHelper);
            }
            Drawable drawableFromBitmap = ImageUtils.getDrawableFromBitmap((Context) interstitialViewHelper.mContext.get(), bitmap);
            if (drawableFromBitmap != null) {
                if (DeviceUtil.filling_timing != 0) {
                    interstitialViewHelper.mInterstitialView = interstitialViewHelper.createAdView(drawableFromBitmap.getIntrinsicWidth() > drawableFromBitmap.getIntrinsicHeight() ? Orientation.HORIZONTAL : Orientation.VERTICAL);
                }
                if (InterstitialViewHelper.this.mInterstitialView == null) {
                    return;
                }
                final Consumer<Bitmap> consumerLoadIcon = InterstitialViewHelper.this.mInterstitialView.loadIcon();
                if (consumerLoadIcon != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                    YdImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new YdImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.base.inner.interstitial.b
                        @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadSuccessListener
                        public final void onSuccess(String str2, Bitmap bitmap2, boolean z2) {
                            InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoaded$0(interstitialViewHelper, consumerLoadIcon, str2, bitmap2, z2);
                        }
                    });
                }
                interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, drawableFromBitmap);
                return;
            }
            if (DeviceUtil.filling_timing != 0) {
                interstitialViewHelper.mInterstitialView = interstitialViewHelper.createAdView(Orientation.VERTICAL);
            }
            if (InterstitialViewHelper.this.mInterstitialView == null) {
                return;
            }
            final Consumer<Bitmap> consumerLoadIcon2 = InterstitialViewHelper.this.mInterstitialView.loadIcon();
            if (consumerLoadIcon2 != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                YdImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new YdImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.base.inner.interstitial.c
                    @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str2, Bitmap bitmap2, boolean z2) {
                        InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoaded$1(interstitialViewHelper, consumerLoadIcon2, str2, bitmap2, z2);
                    }
                });
            }
            interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, null);
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.base.inner.interstitial.InterstitialViewHelper$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition;
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$common$saas$bean$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$fl$saas$common$saas$bean$Orientation = iArr;
            try {
                iArr[Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$common$saas$bean$Orientation[Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CloseButtonPosition.values().length];
            $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition = iArr2;
            try {
                iArr2[CloseButtonPosition.IMAGE_BOTTOM_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition[CloseButtonPosition.IMAGE_TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public InterstitialViewHelper(Context context, boolean z, NativeMaterial nativeMaterial, Orientation orientation, InterstitialViewEvent interstitialViewEvent) {
        this.mContext = new WeakReference<>(context);
        this.isFullScreenInterstitial = z;
        this.mMaterial = nativeMaterial;
        this.dialogStyle = orientation;
        this.mLoaderEvent = interstitialViewEvent;
        InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(context, z ? R.layout.yd_saas_fullscreen_interstitial : R.layout.yd_saas_interstitial);
        this.mLayout = interceptClickLayout;
        this.adContainer = (FrameLayout) interceptClickLayout.findViewById(R.id.yd_saas_interstitial_ad_container);
        this.mSkip = (CountDownTextView) interceptClickLayout.findViewById(R.id.tv_skip);
        this.mAdLogo = (ImageView) interceptClickLayout.findViewById(R.id.iv_ad_logo);
        this.closeView = (ImageView) interceptClickLayout.findViewById(R.id.iv_close);
        this.vClose = interceptClickLayout.findViewById(R.id.v_close);
        this.vTopArea = interceptClickLayout.findViewById(R.id.v_top);
        this.vBottomArea = interceptClickLayout.findViewById(R.id.v_bottom);
        this.closeViewLayout = (RelativeLayout) interceptClickLayout.findViewById(R.id.yd_saas_interstitial_close_layout);
        this.vClose.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.pg4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43978a.lambda$new$0(view);
            }
        });
    }

    private boolean addAdView() {
        if (this.isDestroyed) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = this.adContainer.getLayoutParams();
        if (this.isFullScreenInterstitial) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            try {
                Pair<Integer, Integer> interstitialSize = getInterstitialSize();
                layoutParams.width = interstitialSize.first.intValue();
                layoutParams.height = (this.dialogStyle == Orientation.HORIZONTAL || this.smallEnvelope) ? -2 : interstitialSize.second.intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        this.adContainer.setLayoutParams(layoutParams);
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView == null) {
            return true;
        }
        RelativeLayout relativeLayout = this.closeViewLayout;
        relativeLayout.addView(rainTextureView, relativeLayout.getChildCount() - 2, ViewHelper.getMatchParent());
        return true;
    }

    private void addAppInfo() {
        TextView textViewCreateAppInfoView;
        if (this.isDestroyed || this.mMaterial == null || this.mContext.get() == null || (textViewCreateAppInfoView = InnerNativeViewHelper.createAppInfoView(this.mContext.get(), this.mMaterial)) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int iDip2px = DeviceUtil.dip2px(10.0f);
        textViewCreateAppInfoView.setPadding(iDip2px, 0, iDip2px, iDip2px);
        layoutParams.gravity = 80;
        this.mLayout.addView(textViewCreateAppInfoView, layoutParams);
        this.mLayout.addFilterViews(textViewCreateAppInfoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindMediaView(InnerNativeCustomView innerNativeCustomView, Drawable drawable) {
        if (this.isDestroyed || innerNativeCustomView == null) {
            return;
        }
        innerNativeCustomView.setMediaView((this.mMaterial.getAdType() != 3 || this.mMaterial.getAdMediaView() == null) ? null : this.mMaterial.getAdMediaView(), drawable);
        this.adContainer.addView(this.mInterstitialView.getAdView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InnerNativeCustomView createAdView(Orientation orientation) {
        ImageView imageView;
        if (this.isDestroyed || this.mContext.get() == null) {
            return null;
        }
        if (this.isFullScreenInterstitial) {
            return new InterstitialFullScreenView(this.mContext.get(), this.mMaterial);
        }
        Orientation orientation2 = this.dialogStyle;
        if (orientation2 == Orientation.HORIZONTAL) {
            int i = AnonymousClass2.$SwitchMap$com$fl$saas$common$saas$bean$Orientation[orientation.ordinal()];
            if (i == 1) {
                return new InterstitialHMVView(this.mContext.get());
            }
            if (i == 2) {
                return new InterstitialHMHView(this.mContext.get());
            }
        } else if (orientation2 == Orientation.VERTICAL) {
            int i2 = AnonymousClass2.$SwitchMap$com$fl$saas$common$saas$bean$Orientation[orientation.ordinal()];
            if (i2 == 1) {
                return new InterstitialVMVView(this.mContext.get());
            }
            if (i2 == 2) {
                return new InterstitialVMHView(this.mContext.get());
            }
        } else if (orientation2 == Orientation.ENVELOPE) {
            this.smallEnvelope = TextUtils.isEmpty(!TextUtils.isEmpty(this.mMaterial.getMainImageUrl()) ? this.mMaterial.getMainImageUrl() : (String) Check.findFirstNonNull(this.mMaterial.getImageUrlList())) || TextUtils.isEmpty(this.mMaterial.getTitle()) || TextUtils.isEmpty(this.mMaterial.getDescription());
            Context context = this.mContext.get();
            boolean z = this.smallEnvelope;
            CloseButtonPosition closeButtonPosition = this.pos;
            CloseButtonPosition closeButtonPosition2 = CloseButtonPosition.IMAGE_TOP_RIGHT;
            InterstitialEnvelopeView interstitialEnvelopeView = new InterstitialEnvelopeView(context, orientation, z, closeButtonPosition == closeButtonPosition2, this.animalStartTime, this.animalTime);
            interstitialEnvelopeView.setSpeed(this.speed);
            interstitialEnvelopeView.setAdType(this.isApi);
            interstitialEnvelopeView.setOnlyButton(isOnlyButton());
            CloseButtonPosition closeButtonPosition3 = this.pos;
            if (closeButtonPosition3 == CloseButtonPosition.FLOAT_TOP_RIGHT || closeButtonPosition3 == closeButtonPosition2) {
                this.mSkip.setVisibility(8);
                this.closeView.setVisibility(8);
                this.vClose.setVisibility(8);
                this.mEnvelopeSkip = interstitialEnvelopeView.getSkip();
                this.envelopeCloseView = interstitialEnvelopeView.getCloseView();
                this.envelopeVClose = interstitialEnvelopeView.getSpaceView();
                this.mLayout.addFilterViews(this.envelopeCloseView);
                this.mLayout.addFilterViews(this.envelopeVClose);
                View view = this.envelopeVClose;
                if (view != null) {
                    view.bringToFront();
                }
                ImageView imageView2 = this.envelopeCloseView;
                if (imageView2 != null) {
                    imageView2.bringToFront();
                }
                if (this.isVisible) {
                    this.mEnvelopeSkip.setVisibility(0);
                    this.envelopeCloseView.setVisibility(4);
                    this.envelopeVClose.setVisibility(4);
                } else {
                    this.mEnvelopeSkip.setVisibility(4);
                    this.envelopeCloseView.setVisibility(0);
                    this.envelopeVClose.setVisibility(0);
                    this.mEnvelopeSkip.setCount(this.count);
                }
                this.envelopeVClose.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wf4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f45587a.lambda$createAdView$4(view2);
                    }
                });
                this.mEnvelopeSkip.setOnTick(new Function() { // from class: com.zj.adlib.yf4
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return InterstitialViewHelper.lambda$createAdView$5((Integer) obj);
                    }
                });
                this.mEnvelopeSkip.setFinish(new Runnable() { // from class: com.zj.adlib.ag4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f40528a.lambda$createAdView$6();
                    }
                });
                RainTextureView rainTextureView = this.rainTextureView;
                if (rainTextureView != null) {
                    rainTextureView.setSaveClickItem(false);
                }
                if (this.scaleSize > 0 && (imageView = this.envelopeCloseView) != null) {
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    int iDip2px = DeviceUtil.dip2px((this.scaleSize * 20) / 50.0f);
                    layoutParams.width = iDip2px;
                    layoutParams.height = iDip2px;
                    this.envelopeCloseView.setLayoutParams(layoutParams);
                }
            } else {
                this.mEnvelopeSkip = interstitialEnvelopeView.getSkip();
                this.envelopeCloseView = interstitialEnvelopeView.getCloseView();
                this.envelopeVClose = interstitialEnvelopeView.getSpaceView();
                this.mEnvelopeSkip.setVisibility(8);
                this.envelopeCloseView.setVisibility(8);
                this.envelopeVClose.setVisibility(8);
            }
            return interstitialEnvelopeView;
        }
        return new InterstitialVMVView(this.mContext.get());
    }

    @NonNull
    public static Pair<Integer, Integer> getInterstitialSize() {
        int iRound;
        int iRound2;
        int mobileWidth = DeviceUtil.getMobileWidth();
        int mobileHeight = DeviceUtil.getMobileHeight();
        if (mobileWidth > mobileHeight) {
            iRound = Math.round(mobileHeight * 0.6f);
            iRound2 = iRound;
        } else {
            iRound = Math.round(mobileWidth * 0.8f);
            iRound2 = Math.round((iRound / 9.0f) * 16.0f);
        }
        return Pair.create(Integer.valueOf(iRound), Integer.valueOf(iRound2));
    }

    private void handleDialogDismiss() {
        Activity topActivity;
        try {
            WeakReference<Activity> weakReference = this.activityRef;
            if (weakReference != null && (((topActivity = weakReference.get()) != null && !topActivity.isFinishing()) || ((topActivity = DeviceUtil.getTopActivity()) != null && !topActivity.isFinishing()))) {
                topActivity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        InterstitialViewEvent interstitialViewEvent = this.mLoaderEvent;
        if (interstitialViewEvent != null) {
            interstitialViewEvent.onDismiss();
        }
    }

    private boolean isOnlyButton() {
        if (this.clickType == 1 && (this.mMaterial.getAdType() == 2 || this.mMaterial.getAdType() == 1)) {
            return true;
        }
        if (this.clickType == 2 && this.mMaterial.getAdType() == 3) {
            return true;
        }
        return this.clickType == 3 && this.mMaterial.getAdType() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$15(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$16(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$4(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createAdView$5(Integer num) {
        return num + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$6() {
        if (this.isDestroyed) {
            return;
        }
        this.mEnvelopeSkip.setVisibility(4);
        this.envelopeCloseView.setVisibility(0);
        this.envelopeVClose.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadView$7(Consumer consumer, String str, Bitmap bitmap, boolean z) {
        if (this.isDestroyed) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
            return;
        }
        if (bitmap == null || consumer == null) {
            return;
        }
        consumer.accept(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$render$8(WeakReference weakReference, String str, Bitmap bitmap, boolean z) {
        InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) weakReference.get();
        if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed || bitmap == null) {
            return;
        }
        interstitialViewHelper.loadAdIcon(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$setCountDown$1(Integer num) {
        return num + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCountDown$2() {
        if (this.isDestroyed) {
            return;
        }
        this.mSkip.setVisibility(4);
        this.closeView.setVisibility(0);
        this.vClose.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setRainView$10(WeakReference weakReference) {
        InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) weakReference.get();
        if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
            return;
        }
        interstitialViewHelper.rainTextureView = null;
        interstitialViewHelper.mLayout.setFilterPattern(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setRainView$9(float f, float f2) {
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView != null) {
            return rainTextureView.isClickItem(f, f2) || this.rainTextureView.hasClickItem();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$11(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$12(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$13(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$14(View view) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showDialog$3(WeakReference weakReference, DialogInterface dialogInterface) {
        InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) weakReference.get();
        if (interstitialViewHelper != null) {
            interstitialViewHelper.handleDialogDismiss();
        }
    }

    private void loadAdIcon(Bitmap bitmap) {
        ImageView imageView;
        int i;
        if (this.isDestroyed || bitmap == null) {
            return;
        }
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView instanceof InnerNativeAdLogo) {
            ((InnerNativeAdLogo) innerNativeCustomView).setAdLogo(bitmap);
            imageView = this.mAdLogo;
            if (imageView == null) {
                return;
            } else {
                i = 8;
            }
        } else {
            ImageView imageView2 = this.mAdLogo;
            if (imageView2 == null) {
                return;
            }
            imageView2.setImageBitmap(bitmap);
            imageView = this.mAdLogo;
            i = 0;
        }
        imageView.setVisibility(i);
    }

    private void render() {
        if (this.isDestroyed || this.mInterstitialView == null || this.mMaterial == null || this.mContext.get() == null) {
            return;
        }
        try {
            this.mInterstitialView.setTitle(this.mMaterial.getTitle()).setCAT(TextUtils.isEmpty(this.mMaterial.getCallToAction()) ? "查看详情" : this.mMaterial.getCallToAction()).setDes(this.mMaterial.getDescription());
            if (this.mMaterial.getAdLogo() != null) {
                loadAdIcon(this.mMaterial.getAdLogo());
            } else if (!TextUtils.isEmpty(this.mMaterial.getAdLogoUrl())) {
                final WeakReference weakReference = new WeakReference(this);
                YdImageLoader.getInstance(this.mContext.get()).loadBitmap(this.mMaterial.getAdLogoUrl(), new YdImageLoader.OnBitmapLoadSuccessListener() { // from class: com.zj.adlib.ng4
                    @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str, Bitmap bitmap, boolean z) {
                        InterstitialViewHelper.lambda$render$8(weakReference, str, bitmap, z);
                    }
                });
            }
            this.mLayout.addFilterViews(this.adContainer, this.mInterstitialView.getCATView(), this.vTopArea, this.vBottomArea);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopRain() {
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView != null) {
            rainTextureView.stop();
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void addActionView(View view) {
        if (this.isDestroyed || view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.adContainer.addView(view, layoutParams);
        this.mLayout.addFilterViews(view);
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView instanceof BindActionView) {
            ((BindActionView) innerNativeCustomView).bindActionView(view);
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void click() {
        if (this.isDestroyed) {
            return;
        }
        ImageView imageView = this.closeView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.of4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43737a.lambda$click$15(view);
                }
            });
        }
        ImageView imageView2 = this.envelopeCloseView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dg4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41178a.lambda$click$16(view);
                }
            });
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void closeDialog() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void destroy() {
        this.isDestroyed = true;
        InnerNativeCustomView innerNativeCustomView = this.mInterstitialView;
        if (innerNativeCustomView != null && (innerNativeCustomView instanceof InterstitialEnvelopeView)) {
            ((InterstitialEnvelopeView) innerNativeCustomView).cancelAnimal();
        }
        CountDownTextView countDownTextView = this.mSkip;
        if (countDownTextView != null) {
            countDownTextView.cancel();
        }
        CountDownTextView countDownTextView2 = this.mEnvelopeSkip;
        if (countDownTextView2 != null) {
            countDownTextView2.cancel();
        }
        stopRain();
        Dialog dialog = this.dialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.dialog.dismiss();
            }
            this.dialog.setOnDismissListener(null);
            this.dialog = null;
        }
        InnerNativeCustomView innerNativeCustomView2 = this.mInterstitialView;
        if (innerNativeCustomView2 != null) {
            if (innerNativeCustomView2.getAdView() != null && this.mInterstitialView.getAdView().getParent() != null) {
                ((ViewGroup) this.mInterstitialView.getAdView().getParent()).removeView(this.mInterstitialView.getAdView());
            }
            this.mInterstitialView = null;
        }
        RainTextureView rainTextureView = this.rainTextureView;
        if (rainTextureView != null) {
            rainTextureView.setOnStatusListener(null);
            if (this.rainTextureView.getParent() != null) {
                ((ViewGroup) this.rainTextureView.getParent()).removeView(this.rainTextureView);
            }
            this.rainTextureView = null;
        }
        this.mContext = null;
        this.activityRef = null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View getCATView() {
        InnerNativeCustomView innerNativeCustomView;
        if (this.isDestroyed || (innerNativeCustomView = this.mInterstitialView) == null) {
            return null;
        }
        return (View) Optional.of(innerNativeCustomView).map(new cg4()).orElse(null);
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public View[] getClicks() {
        return isOnlyButton() ? new View[]{this.rainTextureView} : new View[]{this.rainTextureView, this.adContainer, this.vTopArea, this.vBottomArea};
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public NativeAdView getNativeAdView() {
        if (this.isDestroyed) {
            return null;
        }
        NativeAdView nativeAdView = this.nativeAdView;
        if (nativeAdView == null) {
            NativeAdView nativeAdView2 = new NativeAdView(this.mContext.get());
            this.nativeAdView = nativeAdView2;
            nativeAdView2.addView(getSelfView(), ViewHelper.getMatchParent());
        } else {
            ViewHelper.removeParent(nativeAdView);
        }
        return this.nativeAdView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public ViewGroup getSelfView() {
        return this.mLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
    
        if (r6.mInterstitialView != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadView() {
        if (this.isDestroyed || this.mMaterial == null || this.mContext.get() == null) {
            return;
        }
        View adMediaView = this.mMaterial.getAdMediaView();
        String mainImageUrl = !TextUtils.isEmpty(this.mMaterial.getMainImageUrl()) ? this.mMaterial.getMainImageUrl() : (String) Check.findFirstNonNull(this.mMaterial.getImageUrlList());
        if (TextUtils.isEmpty(mainImageUrl)) {
            if (adMediaView != null) {
                InnerNativeCustomView innerNativeCustomViewCreateAdView = createAdView(Orientation.VERTICAL);
                this.mInterstitialView = innerNativeCustomViewCreateAdView;
                if (innerNativeCustomViewCreateAdView == null) {
                    this.mLoaderEvent.onAdFailed(YdError.create(20405, "media and imgUrl is empty"));
                    return;
                }
                final Consumer<Bitmap> consumerLoadIcon = innerNativeCustomViewCreateAdView.loadIcon();
                if (consumerLoadIcon != null && !TextUtils.isEmpty(this.mMaterial.getIconUrl())) {
                    YdImageLoader.getInstance(this.mContext.get()).loadBitmap(this.mMaterial.getIconUrl(), new YdImageLoader.OnBitmapLoadSuccessListener() { // from class: com.zj.adlib.bg4
                        @Override // com.fl.saas.common.util.YdImageLoader.OnBitmapLoadSuccessListener
                        public final void onSuccess(String str, Bitmap bitmap, boolean z) {
                            this.f40746a.lambda$loadView$7(consumerLoadIcon, str, bitmap, z);
                        }
                    });
                }
                bindMediaView(this.mInterstitialView, null);
                this.mLoaderEvent.onLoaded(this);
                return;
            }
            this.mLoaderEvent.onAdFailed(YdError.create(20405, "media and imgUrl is empty"));
            return;
        }
        YdImageLoader.getInstance(this.mContext.get()).loadBitmap(mainImageUrl, new AnonymousClass1(new WeakReference(this)));
        if (DeviceUtil.filling_timing != 0) {
            return;
        }
        Size size = this.mMaterial.getSize();
        this.mInterstitialView = createAdView((size == null || size.getWidth() <= size.getHeight()) ? Orientation.VERTICAL : Orientation.HORIZONTAL);
    }

    @Override // com.fl.saas.base.inner.InnerNativeView
    public void onClicked() {
        if (this.isDestroyed) {
            return;
        }
        stopRain();
        if (this.mIsAutoClose) {
            closeDialog();
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAdType(boolean z) {
        this.isApi = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalStartTime(int i) {
        this.animalStartTime = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalTime(int i) {
        this.animalTime = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAutoClose(boolean z) {
        this.mIsAutoClose = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClickType(int i) {
        this.clickType = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClosePos(@NonNull CloseButtonPosition closeButtonPosition) {
        if (this.isDestroyed) {
            return this;
        }
        this.pos = closeButtonPosition;
        if (this.isFullScreenInterstitial) {
            return this;
        }
        if (closeButtonPosition == CloseButtonPosition.FLOAT_TOP_RIGHT) {
            this.vTopArea.setVisibility(8);
            this.vBottomArea.setVisibility(8);
            return this;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mSkip.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.closeView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.vClose.getLayoutParams();
        layoutParams.removeRule(7);
        layoutParams.removeRule(6);
        layoutParams2.removeRule(7);
        layoutParams2.removeRule(6);
        layoutParams3.removeRule(7);
        layoutParams3.removeRule(6);
        int iDip2px = DeviceUtil.dip2px(8.0f);
        int i = AnonymousClass2.$SwitchMap$com$fl$saas$common$saas$bean$CloseButtonPosition[closeButtonPosition.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (this.dialogStyle == Orientation.ENVELOPE) {
                    this.vTopArea.setVisibility(8);
                } else {
                    this.vTopArea.setVisibility(0);
                }
                this.vBottomArea.setVisibility(8);
                int i2 = R.id.yd_saas_interstitial_ad_container;
                layoutParams.addRule(2, i2);
                layoutParams.addRule(7, i2);
                layoutParams.setMargins(0, 0, 0, iDip2px);
                this.mSkip.setLayoutParams(layoutParams);
                layoutParams2.addRule(2, i2);
                layoutParams2.addRule(7, i2);
                layoutParams2.setMargins(0, 0, 0, iDip2px);
                this.closeView.setLayoutParams(layoutParams2);
                layoutParams3.addRule(2, i2);
                layoutParams3.addRule(7, i2);
                layoutParams3.setMargins(0, 0, 0, iDip2px);
            }
            return this;
        }
        this.vTopArea.setVisibility(8);
        this.vBottomArea.setVisibility(0);
        int i3 = R.id.yd_saas_interstitial_ad_container;
        layoutParams.addRule(3, i3);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, iDip2px, 0, 0);
        this.mSkip.setLayoutParams(layoutParams);
        layoutParams2.addRule(3, i3);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, iDip2px, 0, 0);
        this.closeView.setLayoutParams(layoutParams2);
        layoutParams3.addRule(3, i3);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, iDip2px, 0, 0);
        this.vClose.setLayoutParams(layoutParams3);
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setCloseViewSize(int i) {
        if (this.isDestroyed) {
            return this;
        }
        this.scaleSize = i;
        if (i <= 0) {
            return this;
        }
        ViewGroup.LayoutParams layoutParams = this.closeView.getLayoutParams();
        int iDip2px = DeviceUtil.dip2px((i * 24) / 50.0f);
        layoutParams.width = iDip2px;
        layoutParams.height = iDip2px;
        this.closeView.setLayoutParams(layoutParams);
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void setContext(Context context) {
        if (context != null) {
            this.mContext = new WeakReference<>(context);
        }
        if (context instanceof Activity) {
            this.activityRef = new WeakReference<>((Activity) context);
        }
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setCountDown(boolean z, int i) {
        CountDownTextView countDownTextView;
        if (this.isDestroyed) {
            return this;
        }
        this.isVisible = z;
        this.count = i;
        if (!z) {
            if (this.mEnvelopeSkip != null) {
                this.mSkip.setVisibility(8);
                this.closeView.setVisibility(8);
                this.vClose.setVisibility(8);
                this.mEnvelopeSkip.setVisibility(4);
                this.envelopeCloseView.setVisibility(0);
                this.envelopeVClose.setVisibility(0);
            } else {
                this.mSkip.setVisibility(4);
                this.closeView.setVisibility(0);
                this.vClose.setVisibility(0);
                countDownTextView = this.mSkip;
            }
            countDownTextView.setCount(i);
            return this;
        }
        if (this.mEnvelopeSkip != null) {
            this.mSkip.setVisibility(8);
            this.closeView.setVisibility(8);
            this.vClose.setVisibility(8);
            this.mEnvelopeSkip.setVisibility(0);
            this.envelopeCloseView.setVisibility(4);
            this.envelopeVClose.setVisibility(4);
        } else {
            this.mSkip.setVisibility(0);
            this.closeView.setVisibility(4);
            this.vClose.setVisibility(4);
            this.mSkip.setCount(i);
            this.mSkip.setOnTick(new Function() { // from class: com.zj.adlib.sf4
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return InterstitialViewHelper.lambda$setCountDown$1((Integer) obj);
                }
            });
            this.mSkip.setFinish(new Runnable() { // from class: com.zj.adlib.uf4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45138a.lambda$setCountDown$2();
                }
            });
        }
        return this;
        countDownTextView = this.mEnvelopeSkip;
        countDownTextView.setCount(i);
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setRainView(boolean z) {
        if (!this.isDestroyed && z && this.mContext.get() != null) {
            this.rainTextureView = new RainTextureView(this.mContext.get());
            this.mLayout.setFilterPattern(2);
            this.mLayout.setOutIntercept(new InterceptClickLayout.OnIntercept() { // from class: com.zj.adlib.tg4
                @Override // com.fl.saas.common.widget.InterceptClickLayout.OnIntercept
                public final boolean isIntercept(float f, float f2) {
                    return this.f44913a.lambda$setRainView$9(f, f2);
                }
            });
            this.rainTextureView.setAutoRemove();
            final WeakReference weakReference = new WeakReference(this);
            this.rainTextureView.setOnStatusListener(new RainTextureView.OnStatusListener() { // from class: com.zj.adlib.qf4
                @Override // com.fl.saas.base.widget.RainTextureView.OnStatusListener
                public final void onStop() {
                    InterstitialViewHelper.lambda$setRainView$10(weakReference);
                }
            });
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setShakeType(boolean z) {
        this.isShakeType = z;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setSpeed(int i) {
        this.speed = i;
        return this;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public void setViewType(boolean z, int i) {
        ImageView imageView;
        View.OnClickListener onClickListener;
        if (this.isDestroyed) {
            return;
        }
        if (z) {
            View view = this.vClose;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int iDip2px = DeviceUtil.dip2px((i * 40) / 100.0f);
                layoutParams.width = iDip2px;
                layoutParams.height = iDip2px;
                this.vClose.setLayoutParams(layoutParams);
            }
            View view2 = this.envelopeVClose;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                int iDip2px2 = DeviceUtil.dip2px((i * 40) / 100.0f);
                layoutParams2.width = iDip2px2;
                layoutParams2.height = iDip2px2;
                this.envelopeVClose.setLayoutParams(layoutParams2);
            }
            if (!isOnlyButton()) {
                return;
            }
            ImageView imageView2 = this.closeView;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.fg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f41670a.lambda$setViewType$11(view3);
                    }
                });
            }
            imageView = this.envelopeCloseView;
            if (imageView == null) {
                return;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.hg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f42122a.lambda$setViewType$12(view3);
                    }
                };
            }
        } else {
            ImageView imageView3 = this.closeView;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f42580a.lambda$setViewType$13(view3);
                    }
                });
            }
            imageView = this.envelopeCloseView;
            if (imageView == null) {
                return;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.lg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f43059a.lambda$setViewType$14(view3);
                    }
                };
            }
        }
        imageView.setOnClickListener(onClickListener);
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public boolean showDialog(Activity activity) {
        if (this.isDestroyed) {
            return false;
        }
        this.activityRef = new WeakReference<>(activity);
        render();
        Dialog dialog = new Dialog(activity);
        this.dialog = dialog;
        Window window = dialog.getWindow();
        window.requestFeature(1);
        this.dialog.getWindow().setDimAmount(0.7f);
        this.dialog.getWindow().addFlags(2);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (!addAdView()) {
            return false;
        }
        this.dialog.setContentView(getNativeAdView());
        window.setLayout(-1, -1);
        this.dialog.setCancelable(false);
        this.dialog.setCanceledOnTouchOutside(false);
        final WeakReference weakReference = new WeakReference(this);
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.rg4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InterstitialViewHelper.lambda$showDialog$3(weakReference, dialogInterface);
            }
        });
        addAppInfo();
        this.dialog.show();
        return true;
    }

    @Override // com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView startCountdown() {
        if (this.isDestroyed) {
            return this;
        }
        CountDownTextView countDownTextView = this.mSkip;
        if (countDownTextView != null && countDownTextView.getVisibility() == 0) {
            this.mSkip.start();
        }
        CountDownTextView countDownTextView2 = this.mEnvelopeSkip;
        if (countDownTextView2 != null && countDownTextView2.getVisibility() == 0) {
            this.mEnvelopeSkip.start();
        }
        return this;
    }
}
