package com.huachenjie.ad.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.ad.util.SDAdUtil;
import com.zj.adlib.cr2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BannerAdView$imageView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BannerAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerAdView$imageView$2(Context context, BannerAdView bannerAdView) {
        super(0);
        this.$context = context;
        this.this$0 = bannerAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(BannerAdView bannerAdView, View view) {
        Intrinsics.checkNotNullParameter(bannerAdView, "this$0");
        BannerAdListener bannerAdListener = bannerAdView.mListener;
        if (bannerAdListener != null) {
            Integer num = bannerAdView.mLoadSupplier;
            bannerAdListener.c(num != null ? num.intValue() : -1);
        }
        SDAdUtil.f32744a.c(bannerAdView.mAdConfig);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m187invoke() {
        ImageView imageView = new ImageView(this.$context);
        Context context = this.$context;
        final BannerAdView bannerAdView = this.this$0;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, cr2.c(context, 80.0f)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.ad.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerAdView$imageView$2.invoke$lambda$1$lambda$0(bannerAdView, view);
            }
        });
        return imageView;
    }
}
