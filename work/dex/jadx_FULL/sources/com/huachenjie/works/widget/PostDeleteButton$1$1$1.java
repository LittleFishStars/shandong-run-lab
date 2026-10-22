package com.huachenjie.works.widget;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.works.R;
import com.zj.adlib.ft1;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/huachenjie/base/bean/MoreOptBean;", "index", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PostDeleteButton$1$1$1 extends Lambda implements Function2<MoreOptBean, Integer, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ PostDeleteButton this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDeleteButton$1$1$1(Activity activity, PostDeleteButton postDeleteButton) {
        super(2);
        this.$activity = activity;
        this.this$0 = postDeleteButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Activity activity, PostDeleteButton postDeleteButton, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(postDeleteButton, "this$0");
        Dialog dialogP = DialogUtil.p(activity, false);
        if (dialogP != null) {
            dialogP.show();
        }
        CoroutineExtKt.c(CoroutineExtKt.a(postDeleteButton), false, null, new PostDeleteButton$1$1$1$1$1(dialogP, null), new PostDeleteButton$1$1$1$1$2(postDeleteButton, activity, null), 3, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MoreOptBean) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MoreOptBean moreOptBean, int i) {
        Intrinsics.checkNotNullParameter(moreOptBean, "<anonymous parameter 0>");
        if (i == 0) {
            Activity activity = this.$activity;
            String strE = ys8.e(R.string.works_detail_delete_post_confirm);
            final Activity activity2 = this.$activity;
            final PostDeleteButton postDeleteButton = this.this$0;
            ft1.p(activity, strE, new View.OnClickListener() { // from class: com.huachenjie.works.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostDeleteButton$1$1$1.invoke$lambda$0(activity2, postDeleteButton, view);
                }
            });
        }
    }
}
