package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.bean.comment.CommentBean;
import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class BaseCommentFragment$initAdapter$commentProvider$1 extends FunctionReferenceImpl implements Function1<CommentBean, Unit> {
    public BaseCommentFragment$initAdapter$commentProvider$1(Object obj) {
        super(1, obj, BaseCommentFragment.ClickProxy.class, "clickComment", "clickComment(Lcom/huachenjie/works/bean/comment/CommentBean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentBean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CommentBean commentBean) {
        Intrinsics.checkNotNullParameter(commentBean, bo.g);
        ((BaseCommentFragment.ClickProxy) ((CallableReference) this).receiver).b(commentBean);
    }
}
