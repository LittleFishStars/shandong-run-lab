package com.huachenjie.ad.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class SplashAdView$countDownView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SplashAdView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdView$countDownView$2(Context context, SplashAdView splashAdView) {
        super(0);
        this.$context = context;
        this.this$0 = splashAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2$lambda$1(SplashAdView splashAdView, View view) {
        Intrinsics.checkNotNullParameter(splashAdView, "this$0");
        SplashAdListener splashAdListener = splashAdView.mListener;
        if (splashAdListener != null) {
            Integer num = splashAdView.mLoadSupplier;
            splashAdListener.b(num != null ? num.intValue() : -1);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextView m193invoke() {
        TextView textView = new TextView(this.$context);
        Context context = this.$context;
        final SplashAdView splashAdView = this.this$0;
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        textView.setText("跳过  5s");
        textView.setGravity(17);
        textView.setBackground(new DrawableCreator.Builder().setSolidColor(Integer.MIN_VALUE).setCornersRadius(cr2.c(context, 22.0f)).build());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cr2.c(context, 122.0f), cr2.c(context, 44.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = cr2.c(context, 16.0f);
        layoutParams.bottomMargin = cr2.c(context, 30.0f);
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.ad.widget.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashAdView$countDownView$2.invoke$lambda$2$lambda$1(splashAdView, view);
            }
        });
        return textView;
    }
}
