package com.huachenjie.works.page.comment.base;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$loadCommentReply$2", f = "CommentUtil.kt", i = {1}, l = {82, 92}, m = "invokeSuspend", n = {o.f}, s = {"L$3"})
public final class CommentUtil$loadCommentReply$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentBean $comment;
    final /* synthetic */ int $commentType;
    final /* synthetic */ CommentMoreBean $moreBean;
    final /* synthetic */ BaseCommentVM $viewModel;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUtil$loadCommentReply$2(int i, CommentBean commentBean, BaseCommentVM baseCommentVM, CommentMoreBean commentMoreBean, Continuation<? super CommentUtil$loadCommentReply$2> continuation) {
        super(2, continuation);
        this.$commentType = i;
        this.$comment = commentBean;
        this.$viewModel = baseCommentVM;
        this.$moreBean = commentMoreBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$loadCommentReply$2(this.$commentType, this.$comment, this.$viewModel, this.$moreBean, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0084  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00de  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e6  */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x00b6, please report this as an issue */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity pageEntity;
        CommentBean commentBean;
        BaseCommentVM baseCommentVM;
        CommentMoreBean commentMoreBean;
        List list;
        CoroutineDispatcher coroutineDispatcherC;
        CommentUtil$loadCommentReply$2$1$1 commentUtil$loadCommentReply$2$1$1;
        PageEntity pageEntity2;
        CommentBean commentBean2;
        BaseCommentVM baseCommentVM2;
        CommentMoreBean commentMoreBean2;
        BaseCommentAdapter value;
        List<BaseNode> childNode;
        int iIndexOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pageEntity2 = (PageEntity) this.L$3;
                commentMoreBean2 = (CommentMoreBean) this.L$2;
                baseCommentVM2 = (BaseCommentVM) this.L$1;
                commentBean2 = (CommentBean) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            value = baseCommentVM2.i().getValue();
            if (value != null) {
                childNode = commentBean2.getChildNode();
                if (childNode != null) {
                    iIndexOf = childNode.indexOf(commentMoreBean2);
                } else {
                    iIndexOf = 0;
                }
                List list2 = pageEntity2.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "it.list");
                value.nodeAddData(commentBean2, iIndexOf, list2);
                if (pageEntity2.getHasNext()) {
                    commentMoreBean2.setLoading(false);
                    List<BaseNode> childNode2 = commentBean2.getChildNode();
                    value.nodeSetData(commentBean2, childNode2 != null ? childNode2.indexOf(commentMoreBean2) : 0, commentMoreBean2);
                } else {
                    value.nodeRemoveData(commentBean2, commentMoreBean2);
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Function5 function5C = CommentDelegate.f37252a.c(this.$commentType);
        if (function5C != null) {
            Integer numBoxInt = Boxing.boxInt(this.$comment.getSubCommentPageNum());
            String refreshTime = this.$viewModel.getRefreshTime();
            String bizNo = this.$comment.getBizNo();
            String commentNo = this.$comment.getCommentNo();
            this.label = 1;
            obj = function5C.invoke(numBoxInt, refreshTime, bizNo, commentNo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            pageEntity = null;
        }
        if (pageEntity != null) {
            commentBean = this.$comment;
            baseCommentVM = this.$viewModel;
            commentMoreBean = this.$moreBean;
            list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            if (!list.isEmpty()) {
                commentBean.setSubCommentPageNum(commentBean.getSubCommentPageNum() + 1);
            }
            coroutineDispatcherC = jo2.c();
            commentUtil$loadCommentReply$2$1$1 = new CommentUtil$loadCommentReply$2$1$1(pageEntity, null);
            this.L$0 = commentBean;
            this.L$1 = baseCommentVM;
            this.L$2 = commentMoreBean;
            this.L$3 = pageEntity;
            this.label = 2;
            if (v41.h(coroutineDispatcherC, commentUtil$loadCommentReply$2$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pageEntity2 = pageEntity;
            commentBean2 = commentBean;
            baseCommentVM2 = baseCommentVM;
            commentMoreBean2 = commentMoreBean;
            value = baseCommentVM2.i().getValue();
            if (value != null) {
                childNode = commentBean2.getChildNode();
                if (childNode != null) {
                    iIndexOf = childNode.indexOf(commentMoreBean2);
                } else {
                    iIndexOf = 0;
                }
                List list3 = pageEntity2.getList();
                Intrinsics.checkNotNullExpressionValue(list3, "it.list");
                value.nodeAddData(commentBean2, iIndexOf, list3);
                if (pageEntity2.getHasNext()) {
                    commentMoreBean2.setLoading(false);
                    List<BaseNode> childNode3 = commentBean2.getChildNode();
                    value.nodeSetData(commentBean2, childNode3 != null ? childNode3.indexOf(commentMoreBean2) : 0, commentMoreBean2);
                } else {
                    value.nodeRemoveData(commentBean2, commentMoreBean2);
                }
            }
        }
        return Unit.INSTANCE;
        pageEntity = (PageEntity) obj;
        if (pageEntity != null) {
            commentBean = this.$comment;
            baseCommentVM = this.$viewModel;
            commentMoreBean = this.$moreBean;
            list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            if (!list.isEmpty()) {
                commentBean.setSubCommentPageNum(commentBean.getSubCommentPageNum() + 1);
            }
            coroutineDispatcherC = jo2.c();
            commentUtil$loadCommentReply$2$1$1 = new CommentUtil$loadCommentReply$2$1$1(pageEntity, null);
            this.L$0 = commentBean;
            this.L$1 = baseCommentVM;
            this.L$2 = commentMoreBean;
            this.L$3 = pageEntity;
            this.label = 2;
            if (v41.h(coroutineDispatcherC, commentUtil$loadCommentReply$2$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pageEntity2 = pageEntity;
            commentBean2 = commentBean;
            baseCommentVM2 = baseCommentVM;
            commentMoreBean2 = commentMoreBean;
            value = baseCommentVM2.i().getValue();
            if (value != null) {
                childNode = commentBean2.getChildNode();
                if (childNode != null) {
                    iIndexOf = childNode.indexOf(commentMoreBean2);
                } else {
                    iIndexOf = 0;
                }
                List list4 = pageEntity2.getList();
                Intrinsics.checkNotNullExpressionValue(list4, "it.list");
                value.nodeAddData(commentBean2, iIndexOf, list4);
                if (pageEntity2.getHasNext()) {
                    commentMoreBean2.setLoading(false);
                    List<BaseNode> childNode4 = commentBean2.getChildNode();
                    value.nodeSetData(commentBean2, childNode4 != null ? childNode4.indexOf(commentMoreBean2) : 0, commentMoreBean2);
                } else {
                    value.nodeRemoveData(commentBean2, commentMoreBean2);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
