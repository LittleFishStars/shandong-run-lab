package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
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
public /* synthetic */ class BaseCommentFragment$initAdapter$commentReplyProvider$1 extends FunctionReferenceImpl implements Function2<CommentBean, CommentReplyBean, Unit> {
    public BaseCommentFragment$initAdapter$commentReplyProvider$1(Object obj) {
        super(2, obj, BaseCommentFragment.ClickProxy.class, "clickReply", "clickReply(Lcom/huachenjie/works/bean/comment/CommentBean;Lcom/huachenjie/works/bean/comment/CommentReplyBean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CommentBean) obj, (CommentReplyBean) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CommentBean commentBean, @NotNull CommentReplyBean commentReplyBean) {
        Intrinsics.checkNotNullParameter(commentBean, bo.g);
        Intrinsics.checkNotNullParameter(commentReplyBean, "p1");
        ((BaseCommentFragment.ClickProxy) ((CallableReference) this).receiver).e(commentBean, commentReplyBean);
    }
}
