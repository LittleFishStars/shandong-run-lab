package com.huachenjie.ad.widget;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.ad.R;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.zj.adlib.cr2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InterstitialAdView$closeView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ InterstitialAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialAdView$closeView$2(InterstitialAdView interstitialAdView) {
        super(0);
        this.this$0 = interstitialAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(InterstitialAdView interstitialAdView, View view) {
        Intrinsics.checkNotNullParameter(interstitialAdView, "this$0");
        InterstitialAdListener interstitialAdListener = interstitialAdView.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.a java.lang.String;
        if (interstitialAdListener != null) {
            interstitialAdListener.b(interstitialAdView.loadSupplier);
        }
        Dialog dialog = interstitialAdView.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m188invoke() {
        ImageView imageView = new ImageView(this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String);
        final InterstitialAdView interstitialAdView = this.this$0;
        imageView.setImageResource(R.drawable.interstitial_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cr2.c(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, 24.0f), cr2.c(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, 24.0f));
        layoutParams.gravity = GravityCompat.END;
        layoutParams.rightMargin = cr2.c(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, 16.0f);
        layoutParams.topMargin = cr2.c(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, 16.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.ad.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialAdView$closeView$2.invoke$lambda$2$lambda$1(interstitialAdView, view);
            }
        });
        return imageView;
    }
}
