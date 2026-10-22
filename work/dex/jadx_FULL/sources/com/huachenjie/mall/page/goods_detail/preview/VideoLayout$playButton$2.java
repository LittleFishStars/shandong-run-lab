package com.huachenjie.mall.page.goods_detail.preview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.mall.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class VideoLayout$playButton$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ VideoLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoLayout$playButton$2(Context context, VideoLayout videoLayout) {
        super(0);
        this.$context = context;
        this.this$0 = videoLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ImageView imageView, VideoLayout videoLayout, View view) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(videoLayout, "this$0");
        PlayerManager.Companion companion = PlayerManager.INSTANCE;
        if (companion.a().getIsPlaying()) {
            companion.a().s(true);
            imageView.setImageResource(R.drawable.mall_ic_video_play);
        } else {
            companion.a().y(false);
            videoLayout.k();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m548invoke() {
        final ImageView imageView = new ImageView(this.$context);
        imageView.setImageResource(R.drawable.mall_ic_video_play);
        final VideoLayout videoLayout = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.mall.page.goods_detail.preview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoLayout$playButton$2.invoke$lambda$0(imageView, videoLayout, view);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(SizeUtils.b(80.0f), SizeUtils.b(80.0f));
        layoutParams.addRule(13);
        this.this$0.addView(imageView, layoutParams);
        return imageView;
    }
}
