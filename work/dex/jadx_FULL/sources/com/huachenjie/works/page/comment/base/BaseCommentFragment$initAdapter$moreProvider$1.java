package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BaseCommentFragment$initAdapter$moreProvider$1 extends FunctionReferenceImpl implements Function2<CommentBean, CommentMoreBean, Unit> {
    public BaseCommentFragment$initAdapter$moreProvider$1(Object obj) {
        super(2, obj, BaseCommentFragment.ClickProxy.class, "clickMore", "clickMore(Lcom/huachenjie/works/bean/comment/CommentBean;Lcom/huachenjie/works/bean/comment/CommentMoreBean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CommentBean) obj, (CommentMoreBean) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CommentBean commentBean, @NotNull CommentMoreBean commentMoreBean) {
        Intrinsics.checkNotNullParameter(commentBean, bo.g);
        Intrinsics.checkNotNullParameter(commentMoreBean, "p1");
        ((BaseCommentFragment.ClickProxy) ((CallableReference) this).receiver).d(commentBean, commentMoreBean);
    }
}
