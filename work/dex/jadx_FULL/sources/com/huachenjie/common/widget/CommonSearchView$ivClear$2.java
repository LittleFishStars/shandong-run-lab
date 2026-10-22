package com.huachenjie.common.widget;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CommonSearchView$ivClear$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ CommonSearchView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchView$ivClear$2(CommonSearchView commonSearchView) {
        super(0);
        this.this$0 = commonSearchView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(CommonSearchView commonSearchView, View view) {
        Intrinsics.checkNotNullParameter(commonSearchView, "this$0");
        commonSearchView.getEtSearch().setText("");
        Function0<Unit> clearListener = commonSearchView.getClearListener();
        if (clearListener != null) {
            clearListener.invoke();
        }
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ImageView m380invoke() {
        View viewFindViewById = this.this$0.getLlSearch().findViewById(R.id.iv_clear);
        final CommonSearchView commonSearchView = this.this$0;
        ImageView imageView = (ImageView) viewFindViewById;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSearchView$ivClear$2.invoke$lambda$1$lambda$0(commonSearchView, view);
            }
        });
        return imageView;
    }
}
