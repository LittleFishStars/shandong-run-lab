package com.huachenjie.common.widget;

import android.view.View;
import android.widget.TextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.R;
import com.zj.adlib.qa4;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CommonSearchViewV2$tvSearch$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ CommonSearchViewV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonSearchViewV2$tvSearch$2(CommonSearchViewV2 commonSearchViewV2) {
        super(0);
        this.this$0 = commonSearchViewV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(CommonSearchViewV2 commonSearchViewV2, View view) {
        Intrinsics.checkNotNullParameter(commonSearchViewV2, "this$0");
        commonSearchViewV2.getEtSearch().clearFocus();
        qa4.b(commonSearchViewV2.getEtSearch());
        commonSearchViewV2.getSearchListener().invoke(commonSearchViewV2.getEtSearch().getText().toString());
    }

    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextView m388invoke() {
        View viewFindViewById = this.this$0.getLlSearch().findViewById(R.id.tv_search);
        final CommonSearchViewV2 commonSearchViewV2 = this.this$0;
        TextView textView = (TextView) viewFindViewById;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.common.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonSearchViewV2$tvSearch$2.invoke$lambda$1$lambda$0(commonSearchViewV2, view);
            }
        });
        return textView;
    }
}
