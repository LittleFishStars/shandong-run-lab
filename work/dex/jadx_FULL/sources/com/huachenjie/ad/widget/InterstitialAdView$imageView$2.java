package com.huachenjie.ad.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.util.SDAdUtil;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.zj.adlib.cr2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InterstitialAdView$imageView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ InterstitialAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialAdView$imageView$2(InterstitialAdView interstitialAdView) {
        super(0);
        this.this$0 = interstitialAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(InterstitialAdView interstitialAdView, View view) {
        Intrinsics.checkNotNullParameter(interstitialAdView, "this$0");
        InterstitialAdListener interstitialAdListener = interstitialAdView.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.a java.lang.String;
        if (interstitialAdListener != null) {
            interstitialAdListener.a(interstitialAdView.loadSupplier, "");
        }
        SDAdUtil.f32744a.c(interstitialAdView.adConfig);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m190invoke() {
        ImageView imageView = new ImageView(this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String);
        final InterstitialAdView interstitialAdView = this.this$0;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(interstitialAdView.mWidth, interstitialAdView.mHeight));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.ad.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialAdView$imageView$2.invoke$lambda$1$lambda$0(interstitialAdView, view);
            }
        });
        RequestManager requestManagerWith = Glide.with(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String);
        AdPlatformSwitch adPlatformSwitch = interstitialAdView.adConfig;
        requestManagerWith.load(adPlatformSwitch != null ? adPlatformSwitch.getImgUrl() : null).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new CenterCrop(), new RoundedCorners(cr2.c(interstitialAdView.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, 20.0f))).into(imageView);
        return imageView;
    }
}
