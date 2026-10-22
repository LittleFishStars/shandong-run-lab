package com.huachenjie.channel.page.message_detail;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.channel.R;
import com.zj.adlib.ft1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/huachenjie/base/bean/MoreOptBean;", "<anonymous parameter 1>", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MessageDetailActivity$initTitle$1$1 extends Lambda implements Function2<MoreOptBean, Integer, Unit> {
    final /* synthetic */ MessageDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageDetailActivity$initTitle$1$1(MessageDetailActivity messageDetailActivity) {
        super(2);
        this.this$0 = messageDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MessageDetailActivity messageDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(messageDetailActivity, "this$0");
        messageDetailActivity.getMViewModel().j();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MoreOptBean) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MoreOptBean moreOptBean, int i) {
        Intrinsics.checkNotNullParameter(moreOptBean, "<anonymous parameter 0>");
        MessageDetailActivity messageDetailActivity = this.this$0;
        String string = messageDetailActivity.getString(R.string.channel_organize_published_del_dialog_title);
        final MessageDetailActivity messageDetailActivity2 = this.this$0;
        ft1.p(messageDetailActivity, string, new View.OnClickListener() { // from class: com.huachenjie.channel.page.message_detail.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageDetailActivity$initTitle$1$1.invoke$lambda$0(messageDetailActivity2, view);
            }
        });
    }
}
