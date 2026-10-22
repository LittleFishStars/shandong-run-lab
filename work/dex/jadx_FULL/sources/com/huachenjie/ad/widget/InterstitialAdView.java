package com.huachenjie.ad.widget;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.R;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.util.SDAdUtil;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.cr2;
import com.zj.adlib.fx7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/ad/widget/InterstitialAdView;", "", "", "m", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "", "I", "loadSupplier", "Lcom/huachenjie/ad/interfaces/InterstitialAdListener;", "Lcom/huachenjie/ad/interfaces/InterstitialAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "b", "mWidth", "c", "mHeight", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mDialog", "Landroid/widget/ImageView;", "Lkotlin/Lazy;", t.d, "()Landroid/widget/ImageView;", "imageView", "j", "closeView", "Landroid/widget/FrameLayout;", "k", "()Landroid/widget/FrameLayout;", "contentView", "<init>", "(Landroid/app/Activity;Lcom/huachenjie/common/bean/AdPlatformSwitch;ILcom/huachenjie/ad/interfaces/InterstitialAdListener;)V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class InterstitialAdView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int loadSupplier;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Activity activity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Dialog mDialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final InterstitialAdListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public final AdPlatformSwitch adConfig;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy imageView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int mWidth;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy closeView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int mHeight;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy contentView;

    public InterstitialAdView(@NotNull Activity activity, @Nullable AdPlatformSwitch adPlatformSwitch, int i, @Nullable InterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        this.activity = activity;
        this.adConfig = adPlatformSwitch;
        this.loadSupplier = i;
        this.listener = interstitialAdListener;
        int iJ = fx7.j() - cr2.c(activity, 84.0f);
        this.mWidth = iJ;
        this.mHeight = (int) ((iJ * 3.0f) / 2.0f);
        this.imageView = LazyKt.lazy(new InterstitialAdView$imageView$2(this));
        this.closeView = LazyKt.lazy(new InterstitialAdView$closeView$2(this));
        this.contentView = LazyKt.lazy(new Function0<FrameLayout>() { // from class: com.huachenjie.ad.widget.InterstitialAdView$contentView$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FrameLayout m189invoke() {
                FrameLayout frameLayout = new FrameLayout(this.this$0.activity);
                InterstitialAdView interstitialAdView = this.this$0;
                frameLayout.addView(interstitialAdView.l());
                frameLayout.addView(interstitialAdView.j());
                return frameLayout;
            }
        });
    }

    public final ImageView j() {
        return (ImageView) this.closeView.getValue();
    }

    public final FrameLayout k() {
        return (FrameLayout) this.contentView.getValue();
    }

    public final ImageView l() {
        return (ImageView) this.imageView.getValue();
    }

    public final void m() {
        InterstitialAdListener interstitialAdListener = this.listener;
        if (interstitialAdListener != null) {
            interstitialAdListener.e(this.loadSupplier, "");
        }
        SDAdUtil.f32744a.d(this.adConfig);
        Dialog dialog = new Dialog(this.activity, R.style.base_dialog_theme);
        this.mDialog = dialog;
        dialog.setCancelable(false);
        Dialog dialog2 = this.mDialog;
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = this.mDialog;
        if (dialog3 != null) {
            dialog3.setContentView(k(), new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
        }
        Dialog dialog4 = this.mDialog;
        if (dialog4 != null) {
            dialog4.show();
        }
    }
}
