package com.fl.saas.adx.base.inner.interstitial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.core.util.Pair;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.C1428p0;
import com.fl.saas.EnumC1430q0;
import com.fl.saas.EnumC1433s;
import com.fl.saas.R;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.base.bean.Size;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.InnerNativeAdLogo;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.base.inner.InnerNativeViewHelper;
import com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialEnvelopeView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialFullScreenView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialHMHView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialHMVView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialVMHView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.InterstitialVMVView;
import com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.adx.base.innterNative.BindActionView;
import com.fl.saas.adx.base.widget.CountDownTextView;
import com.fl.saas.adx.base.widget.InterceptClickLayout;
import com.fl.saas.adx.util.Check;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.FLImageLoader;
import com.fl.saas.adx.util.ViewHelper;
import com.zj.adlib.pf4;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialViewHelper implements NativeInterstitialView {
    private final FrameLayout adContainer;
    private double alpha;
    private int animalStartTime;
    private int animalTime;
    private int clickType;
    private ImageView closeView;
    private int count;
    private ImageView envelopeCloseView;
    private View envelopeVClose;
    private final FrameLayout fl_app_info;
    private EnumC1430q0 interstitialStyle;
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
    private OnAdCloseListener onAdCloseListener;
    private EnumC1433s pos;
    private int scaleSize;
    private int speed;
    private View vBottomArea;
    private View vClose;
    private View vTopArea;
    private boolean smallEnvelope = false;
    private boolean isDestroyed = false;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements FLImageLoader.OnBitmapLoadListener {
        final /* synthetic */ WeakReference val$selfRef;

        public AnonymousClass1(WeakReference weakReference) {
            this.val$selfRef = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoadFailed$2(InterstitialViewHelper interstitialViewHelper, B b, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || b == null) {
                return;
            }
            b.a(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoaded$0(InterstitialViewHelper interstitialViewHelper, B b, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || b == null) {
                return;
            }
            b.a(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBitmapLoaded$1(InterstitialViewHelper interstitialViewHelper, B b, String str, Bitmap bitmap, boolean z) {
            if (interstitialViewHelper.isDestroyed) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
                return;
            }
            if (bitmap == null || b == null) {
                return;
            }
            b.a(bitmap);
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
        public void onBitmapLoadFailed(String str, String str2) {
            final InterstitialViewHelper interstitialViewHelper = (InterstitialViewHelper) this.val$selfRef.get();
            if (DeviceUtil.filling_timing != 0) {
                if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
                    return;
                }
                interstitialViewHelper.mLoaderEvent.onAdFailed(new FLError("素材加载失败"));
                return;
            }
            if (interstitialViewHelper == null || interstitialViewHelper.isDestroyed) {
                return;
            }
            final B bLoadIcon = interstitialViewHelper.mInterstitialView.loadIcon();
            if (bLoadIcon != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                FLImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.adx.base.inner.interstitial.d
                    @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str3, Bitmap bitmap, boolean z) {
                        InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoadFailed$2(interstitialViewHelper, bLoadIcon, str3, bitmap, z);
                    }
                });
            }
            interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, null);
            if (DeviceUtil.filling_timing != 0) {
                interstitialViewHelper.mLoaderEvent.onLoaded(interstitialViewHelper);
            }
        }

        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
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
            Drawable drawableA = AbstractC1398a0.a((Context) interstitialViewHelper.mContext.get(), bitmap);
            if (drawableA != null) {
                if (DeviceUtil.filling_timing != 0) {
                    interstitialViewHelper.mInterstitialView = interstitialViewHelper.createAdView(drawableA.getIntrinsicWidth() > drawableA.getIntrinsicHeight() ? EnumC1430q0.HORIZONTAL : EnumC1430q0.VERTICAL);
                }
                if (InterstitialViewHelper.this.mInterstitialView == null) {
                    return;
                }
                final B bLoadIcon = InterstitialViewHelper.this.mInterstitialView.loadIcon();
                if (bLoadIcon != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                    FLImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.adx.base.inner.interstitial.b
                        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                        public final void onSuccess(String str2, Bitmap bitmap2, boolean z2) {
                            InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoaded$0(interstitialViewHelper, bLoadIcon, str2, bitmap2, z2);
                        }
                    });
                }
                interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, drawableA);
                return;
            }
            if (DeviceUtil.filling_timing != 0) {
                interstitialViewHelper.mInterstitialView = interstitialViewHelper.createAdView(EnumC1430q0.VERTICAL);
            }
            if (InterstitialViewHelper.this.mInterstitialView == null) {
                return;
            }
            final B bLoadIcon2 = InterstitialViewHelper.this.mInterstitialView.loadIcon();
            if (bLoadIcon2 != null && !TextUtils.isEmpty(interstitialViewHelper.mMaterial.getIconUrl())) {
                FLImageLoader.getInstance((Context) interstitialViewHelper.mContext.get()).loadBitmap(interstitialViewHelper.mMaterial.getIconUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.fl.saas.adx.base.inner.interstitial.c
                    @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str2, Bitmap bitmap2, boolean z2) {
                        InterstitialViewHelper.AnonymousClass1.lambda$onBitmapLoaded$1(interstitialViewHelper, bLoadIcon2, str2, bitmap2, z2);
                    }
                });
            }
            interstitialViewHelper.bindMediaView(interstitialViewHelper.mInterstitialView, null);
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$base$bean$CloseButtonPosition;
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$base$bean$Orientation;

        static {
            int[] iArr = new int[EnumC1430q0.values().length];
            $SwitchMap$com$fl$saas$base$bean$Orientation = iArr;
            try {
                iArr[EnumC1430q0.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$base$bean$Orientation[EnumC1430q0.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC1433s.values().length];
            $SwitchMap$com$fl$saas$base$bean$CloseButtonPosition = iArr2;
            try {
                iArr2[EnumC1433s.IMAGE_BOTTOM_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fl$saas$base$bean$CloseButtonPosition[EnumC1433s.IMAGE_TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface OnAdCloseListener {
        void onClose();
    }

    public InterstitialViewHelper(Context context, boolean z, NativeMaterial nativeMaterial, EnumC1430q0 enumC1430q0, InterstitialViewEvent interstitialViewEvent) {
        this.mContext = new WeakReference<>(context);
        this.isFullScreenInterstitial = z;
        this.mMaterial = nativeMaterial;
        this.interstitialStyle = enumC1430q0;
        this.mLoaderEvent = interstitialViewEvent;
        InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(context, z ? R.layout.fl_adx_fullscreen_interstitial : R.layout.fl_adx_interstitial);
        this.mLayout = interceptClickLayout;
        this.adContainer = (FrameLayout) interceptClickLayout.findViewById(R.id.fl_saas_interstitial_ad_container);
        this.fl_app_info = (FrameLayout) interceptClickLayout.findViewById(R.id.fl_app_info);
        this.mSkip = (CountDownTextView) interceptClickLayout.findViewById(R.id.tv_skip);
        this.mAdLogo = (ImageView) interceptClickLayout.findViewById(R.id.iv_ad_logo);
        this.closeView = (ImageView) interceptClickLayout.findViewById(R.id.iv_close);
        this.vClose = interceptClickLayout.findViewById(R.id.v_close);
        this.vTopArea = interceptClickLayout.findViewById(R.id.v_top);
        this.vBottomArea = interceptClickLayout.findViewById(R.id.v_bottom);
        this.vClose.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.qg4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44205a.lambda$new$0(view);
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
                layoutParams.height = (this.interstitialStyle == EnumC1430q0.HORIZONTAL || this.smallEnvelope) ? -2 : interstitialSize.second.intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        this.adContainer.setLayoutParams(layoutParams);
        return true;
    }

    private void addAppInfo() {
        TextView textViewCreateAppInfoView;
        if (this.isDestroyed || this.mMaterial == null || this.mContext.get() == null || (textViewCreateAppInfoView = InnerNativeViewHelper.createAppInfoView(this.mContext.get(), this.mMaterial)) == null) {
            return;
        }
        if (!this.isFullScreenInterstitial) {
            textViewCreateAppInfoView.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#4D000000"), Color.parseColor("#00000000")}));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int iDip2px = DeviceUtil.dip2px(10.0f);
        int i = iDip2px / 2;
        textViewCreateAppInfoView.setPadding(iDip2px, i, iDip2px, i);
        this.fl_app_info.addView(textViewCreateAppInfoView, layoutParams);
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
    public InnerNativeCustomView createAdView(EnumC1430q0 enumC1430q0) {
        ImageView imageView;
        if (this.isDestroyed || this.mContext.get() == null) {
            return null;
        }
        if (this.isFullScreenInterstitial) {
            return new InterstitialFullScreenView(this.mContext.get(), this.mMaterial);
        }
        EnumC1430q0 enumC1430q1 = this.interstitialStyle;
        if (enumC1430q1 == EnumC1430q0.HORIZONTAL) {
            int i = AnonymousClass2.$SwitchMap$com$fl$saas$base$bean$Orientation[enumC1430q0.ordinal()];
            if (i == 1) {
                return new InterstitialHMVView(this.mContext.get());
            }
            if (i == 2) {
                return new InterstitialHMHView(this.mContext.get());
            }
        } else if (enumC1430q1 == EnumC1430q0.VERTICAL) {
            int i2 = AnonymousClass2.$SwitchMap$com$fl$saas$base$bean$Orientation[enumC1430q0.ordinal()];
            if (i2 == 1) {
                return new InterstitialVMVView(this.mContext.get());
            }
            if (i2 == 2) {
                return new InterstitialVMHView(this.mContext.get());
            }
        } else if (enumC1430q1 == EnumC1430q0.ENVELOPE) {
            this.smallEnvelope = TextUtils.isEmpty(!TextUtils.isEmpty(this.mMaterial.getMainImageUrl()) ? this.mMaterial.getMainImageUrl() : (String) Check.findFirstNonNull(this.mMaterial.getImageUrlList())) || TextUtils.isEmpty(this.mMaterial.getTitle()) || TextUtils.isEmpty(this.mMaterial.getDescription());
            Context context = this.mContext.get();
            boolean z = this.smallEnvelope;
            EnumC1433s enumC1433s = this.pos;
            EnumC1433s enumC1433s2 = EnumC1433s.IMAGE_TOP_RIGHT;
            InterstitialEnvelopeView interstitialEnvelopeView = new InterstitialEnvelopeView(context, enumC1430q0, z, enumC1433s == enumC1433s2, this.animalStartTime, this.animalTime);
            interstitialEnvelopeView.setSpeed(this.speed);
            interstitialEnvelopeView.setOnlyButton(isOnlyButton());
            EnumC1433s enumC1433s3 = this.pos;
            if (enumC1433s3 == EnumC1433s.FLOAT_TOP_RIGHT || enumC1433s3 == enumC1433s2) {
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
                this.envelopeVClose.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.sg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f44687a.lambda$createAdView$3(view2);
                    }
                });
                this.mEnvelopeSkip.setOnTick(new Function() { // from class: com.zj.adlib.ug4
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return InterstitialViewHelper.lambda$createAdView$4((Integer) obj);
                    }
                });
                this.mEnvelopeSkip.setFinish(new Runnable() { // from class: com.zj.adlib.rf4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44443a.lambda$createAdView$5();
                    }
                });
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

    private boolean isOnlyButton() {
        return this.clickType == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$12(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$click$13(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$3(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createAdView$4(Integer num) {
        return num + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAdView$5() {
        if (this.isDestroyed) {
            return;
        }
        this.mEnvelopeSkip.setVisibility(4);
        this.envelopeCloseView.setVisibility(0);
        this.envelopeVClose.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadView$6(B b, String str, Bitmap bitmap, boolean z) {
        if (this.isDestroyed) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
            return;
        }
        if (bitmap == null || b == null) {
            return;
        }
        b.a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$render$7(WeakReference weakReference, String str, Bitmap bitmap, boolean z) {
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
    public /* synthetic */ void lambda$setViewType$10(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$11(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$8(View view) {
        closeInterstitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewType$9(View view) {
        closeInterstitial();
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
                FLImageLoader.getInstance(this.mContext.get()).loadBitmap(this.mMaterial.getAdLogoUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.zj.adlib.zf4
                    @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                    public final void onSuccess(String str, Bitmap bitmap, boolean z) {
                        InterstitialViewHelper.lambda$render$7(weakReference, str, bitmap, z);
                    }
                });
            }
            this.mLayout.addFilterViews(this.adContainer, this.mInterstitialView.getCATView(), this.vTopArea, this.vBottomArea);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public void click() {
        if (this.isDestroyed) {
            return;
        }
        ImageView imageView = this.closeView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vf4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45339a.lambda$click$12(view);
                }
            });
        }
        ImageView imageView2 = this.envelopeCloseView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xf4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45813a.lambda$click$13(view);
                }
            });
        }
    }

    public void closeInterstitial() {
        InterstitialViewEvent interstitialViewEvent = this.mLoaderEvent;
        if (interstitialViewEvent != null) {
            interstitialViewEvent.onDismiss();
        }
        OnAdCloseListener onAdCloseListener = this.onAdCloseListener;
        if (onAdCloseListener != null) {
            onAdCloseListener.onClose();
        }
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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
        closeInterstitial();
        InnerNativeCustomView innerNativeCustomView2 = this.mInterstitialView;
        if (innerNativeCustomView2 != null) {
            if (innerNativeCustomView2.getAdView() != null && this.mInterstitialView.getAdView().getParent() != null) {
                ((ViewGroup) this.mInterstitialView.getAdView().getParent()).removeView(this.mInterstitialView.getAdView());
            }
            this.mInterstitialView = null;
        }
        this.mContext = null;
    }

    public double getAlpha() {
        return this.alpha;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public View getCATView() {
        InnerNativeCustomView innerNativeCustomView;
        if (this.isDestroyed || (innerNativeCustomView = this.mInterstitialView) == null) {
            return null;
        }
        return (View) C1428p0.a(innerNativeCustomView).a((Function) new pf4()).c(null);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public View[] getClicks() {
        if (this.isDestroyed) {
            return new View[0];
        }
        if (isOnlyButton()) {
            return new View[0];
        }
        return this.clickType == 2 ? new View[]{this.mLayout, this.adContainer, this.vTopArea, this.vBottomArea} : new View[]{this.adContainer, this.vTopArea, this.vBottomArea};
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
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

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
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
                InnerNativeCustomView innerNativeCustomViewCreateAdView = createAdView(EnumC1430q0.VERTICAL);
                this.mInterstitialView = innerNativeCustomViewCreateAdView;
                if (innerNativeCustomViewCreateAdView == null) {
                    this.mLoaderEvent.onAdFailed(FLError.create(20405, "media and imgUrl is empty"));
                    return;
                }
                final B bLoadIcon = innerNativeCustomViewCreateAdView.loadIcon();
                if (bLoadIcon != null && !TextUtils.isEmpty(this.mMaterial.getIconUrl())) {
                    FLImageLoader.getInstance(this.mContext.get()).loadBitmap(this.mMaterial.getIconUrl(), new FLImageLoader.OnBitmapLoadSuccessListener() { // from class: com.zj.adlib.tf4
                        @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadSuccessListener
                        public final void onSuccess(String str, Bitmap bitmap, boolean z) {
                            this.f19785a.lambda$loadView$6(bLoadIcon, str, bitmap, z);
                        }
                    });
                }
                bindMediaView(this.mInterstitialView, null);
                this.mLoaderEvent.onLoaded(this);
                return;
            }
            this.mLoaderEvent.onAdFailed(FLError.create(20405, "media and imgUrl is empty"));
            return;
        }
        FLImageLoader.getInstance(this.mContext.get()).loadBitmap(mainImageUrl, new AnonymousClass1(new WeakReference(this)));
        if (DeviceUtil.filling_timing != 0) {
            return;
        }
        Size size = this.mMaterial.getSize();
        this.mInterstitialView = createAdView((size == null || size.getWidth() <= size.getHeight()) ? EnumC1430q0.VERTICAL : EnumC1430q0.HORIZONTAL);
    }

    public void onActivityStart(Activity activity) {
        InterstitialViewEvent interstitialViewEvent = this.mLoaderEvent;
        if (interstitialViewEvent != null) {
            interstitialViewEvent.onActivityShow(activity);
        }
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeView
    public void onClicked() {
        if (!this.isDestroyed && this.mIsAutoClose) {
            closeInterstitial();
        }
    }

    public void readerAdView() {
        render();
        addAdView();
        addAppInfo();
    }

    public void setAlpha(double d) {
        this.alpha = d;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalStartTime(int i) {
        this.animalStartTime = i;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAnimalTime(int i) {
        this.animalTime = i;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setAutoClose(boolean z) {
        this.mIsAutoClose = z;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClickType(int i) {
        this.clickType = i;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setClosePos(@NonNull EnumC1433s enumC1433s) {
        if (this.isDestroyed) {
            return this;
        }
        this.pos = enumC1433s;
        if (this.isFullScreenInterstitial) {
            return this;
        }
        if (enumC1433s == EnumC1433s.FLOAT_TOP_RIGHT) {
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
        int i = AnonymousClass2.$SwitchMap$com$fl$saas$base$bean$CloseButtonPosition[enumC1433s.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (this.interstitialStyle == EnumC1430q0.ENVELOPE) {
                    this.vTopArea.setVisibility(8);
                } else {
                    this.vTopArea.setVisibility(0);
                }
                this.vBottomArea.setVisibility(8);
                int i2 = R.id.fl_saas_interstitial_ad_container;
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
        int i3 = R.id.fl_saas_interstitial_ad_container;
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

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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
            this.mSkip.setOnTick(new Function() { // from class: com.zj.adlib.mg4
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return InterstitialViewHelper.lambda$setCountDown$1((Integer) obj);
                }
            });
            this.mSkip.setFinish(new Runnable() { // from class: com.zj.adlib.og4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43741a.lambda$setCountDown$2();
                }
            });
        }
        return this;
        countDownTextView = this.mEnvelopeSkip;
        countDownTextView.setCount(i);
        return this;
    }

    public void setOnAdCloseListener(OnAdCloseListener onAdCloseListener) {
        this.onAdCloseListener = onAdCloseListener;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setShakeType(boolean z) {
        this.isShakeType = z;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
    public NativeInterstitialView setSpeed(int i) {
        this.speed = i;
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.eg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f41432a.lambda$setViewType$8(view3);
                    }
                });
            }
            imageView = this.envelopeCloseView;
            if (imageView == null) {
                return;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.gg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f41902a.lambda$setViewType$9(view3);
                    }
                };
            }
        } else {
            ImageView imageView3 = this.closeView;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ig4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f42353a.lambda$setViewType$10(view3);
                    }
                });
            }
            imageView = this.envelopeCloseView;
            if (imageView == null) {
                return;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.kg4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f42811a.lambda$setViewType$11(view3);
                    }
                };
            }
        }
        imageView.setOnClickListener(onClickListener);
    }

    @Override // com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView
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
