package com.huachenjie.works.page.comment.base;

import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$loadCommentReply$2$1$1", f = "CommentUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCommentUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommentUtil.kt\ncom/huachenjie/works/page/comment/base/CommentUtil$loadCommentReply$2$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1855#2,2:230\n*S KotlinDebug\n*F\n+ 1 CommentUtil.kt\ncom/huachenjie/works/page/comment/base/CommentUtil$loadCommentReply$2$1$1\n*L\n93#1:230,2\n*E\n"})
public final class CommentUtil$loadCommentReply$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageEntity<CommentReplyBean> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUtil$loadCommentReply$2$1$1(PageEntity<CommentReplyBean> pageEntity, Continuation<? super CommentUtil$loadCommentReply$2$1$1> continuation) {
        super(2, continuation);
        this.$it = pageEntity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$loadCommentReply$2$1$1(this.$it, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<CommentReplyBean> list = this.$it.getList();
        Intrinsics.checkNotNullExpressionValue(list, "it.list");
        for (CommentReplyBean commentReplyBean : list) {
            commentReplyBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentReplyBean.getContent(), 0, 2, null));
        }
        return Unit.INSTANCE;
    }
}
