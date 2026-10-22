package com.huachenjie.ad.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.util.SDAdUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class NativeAdView$imageView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ NativeAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdView$imageView$2(Context context, NativeAdView nativeAdView) {
        super(0);
        this.$context = context;
        this.this$0 = nativeAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(NativeAdView nativeAdView, View view) {
        Intrinsics.checkNotNullParameter(nativeAdView, "this$0");
        NativeAdListener nativeAdListener = nativeAdView.mListener;
        if (nativeAdListener != null) {
            Integer num = nativeAdView.mLoadSupplier;
            nativeAdListener.a(num != null ? num.intValue() : -1, "");
        }
        SDAdUtil.f32744a.c(nativeAdView.mAdConfig);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m192invoke() {
        ImageView imageView = new ImageView(this.$context);
        final NativeAdView nativeAdView = this.this$0;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.ad.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NativeAdView$imageView$2.invoke$lambda$1$lambda$0(nativeAdView, view);
            }
        });
        return imageView;
    }
}
