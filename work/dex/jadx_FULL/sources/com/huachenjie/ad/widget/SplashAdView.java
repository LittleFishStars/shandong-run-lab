package com.huachenjie.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.ad.util.SDAdUtil;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.zj.adlib.jo2;
import com.zj.adlib.oj3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/huachenjie/ad/widget/SplashAdView;", "Landroid/widget/FrameLayout;", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "", "loadSupplier", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "showAd", "a", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "mAdConfig", "Ljava/lang/Integer;", "mLoadSupplier", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", "mListener", "Landroid/widget/ImageView;", "Lkotlin/Lazy;", "getImageView", "()Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "b", "getCountDownView", "()Landroid/widget/TextView;", "countDownView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ad_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"SetTextI18n"})
public final class SplashAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public SplashAdListener mListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public AdPlatformSwitch mAdConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer mLoadSupplier;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy imageView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy countDownView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SplashAdView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SplashAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SplashAdView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getCountDownView() {
        return (TextView) this.countDownView.getValue();
    }

    private final ImageView getImageView() {
        return (ImageView) this.imageView.getValue();
    }

    public final void a(FragmentActivity activity) {
        oj3.V0(oj3.e1(oj3.f1(oj3.O0(oj3.J0(new SplashAdView$startCountDown$1(null)), jo2.e()), new SplashAdView$startCountDown$2(this, null)), new SplashAdView$startCountDown$3(this, null)), LifecycleOwnerKt.getLifecycleScope(activity));
    }

    public final void showAd(@NotNull FragmentActivity activity, @Nullable AdPlatformSwitch adConfig, int loadSupplier, @Nullable SplashAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        this.mAdConfig = adConfig;
        this.mLoadSupplier = Integer.valueOf(loadSupplier);
        this.mListener = listener;
        if (listener != null) {
            listener.d(loadSupplier);
        }
        if (listener != null) {
            listener.e(loadSupplier, "");
        }
        SDAdUtil.f32744a.d(adConfig);
        Glide.with(getContext()).load(adConfig != null ? adConfig.getImgUrl() : null).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new CenterCrop()).into(getImageView());
        a(activity);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SplashAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageView = LazyKt.lazy(new SplashAdView$imageView$2(context, this));
        this.countDownView = LazyKt.lazy(new SplashAdView$countDownView$2(context, this));
        addView(getImageView());
        addView(getCountDownView());
    }
}
