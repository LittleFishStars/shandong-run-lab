package com.huachenjie.channel.widget;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.channel.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class UploadPictureButton$ivDel$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ UploadPictureButton this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadPictureButton$ivDel$2(UploadPictureButton uploadPictureButton) {
        super(0);
        this.this$0 = uploadPictureButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(UploadPictureButton uploadPictureButton, View view) {
        Intrinsics.checkNotNullParameter(uploadPictureButton, "this$0");
        uploadPictureButton.e();
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m324invoke() {
        View viewFindViewById = this.this$0.findViewById(R.id.iv_del);
        final UploadPictureButton uploadPictureButton = this.this$0;
        ImageView imageView = (ImageView) viewFindViewById;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.channel.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UploadPictureButton$ivDel$2.invoke$lambda$1$lambda$0(uploadPictureButton, view);
            }
        });
        return imageView;
    }
}
