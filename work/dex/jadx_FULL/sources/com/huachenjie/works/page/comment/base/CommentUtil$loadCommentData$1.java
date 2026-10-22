package com.huachenjie.works.page.comment.base;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$loadCommentData$1", f = "CommentUtil.kt", i = {1, 1}, l = {29, 35}, m = "invokeSuspend", n = {"data", o.f}, s = {"L$0", "L$2"})
public final class CommentUtil$loadCommentData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $commentType;
    final /* synthetic */ BaseCommentVM $viewModel;
    final /* synthetic */ String $worksNo;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUtil$loadCommentData$1(int i, BaseCommentVM baseCommentVM, String str, Continuation<? super CommentUtil$loadCommentData$1> continuation) {
        super(2, continuation);
        this.$commentType = i;
        this.$viewModel = baseCommentVM;
        this.$worksNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$loadCommentData$1(this.$commentType, this.$viewModel, this.$worksNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    /* JADX WARN: Code duplicated, block: B:20:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x007c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0088  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:42:0x0100  */
    /* JADX WARN: Code duplicated, block: B:44:0x010c  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity pageEntity;
        BaseCommentVM baseCommentVM;
        int i;
        CoroutineDispatcher coroutineDispatcherC;
        CommentUtil$loadCommentData$1$1$1 commentUtil$loadCommentData$1$1$1;
        int i2;
        PageEntity pageEntity2;
        BaseCommentAdapter value;
        List list;
        BaseCommentAdapter value2;
        BaseLoadMoreModule loadMoreModule;
        BaseCommentAdapter value3;
        BaseLoadMoreModule loadMoreModule2;
        BaseCommentAdapter value4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$0;
                pageEntity = (PageEntity) this.L$2;
                baseCommentVM = (BaseCommentVM) this.L$1;
                pageEntity2 = (PageEntity) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (baseCommentVM.getPageNum() == 1) {
                if (i2 == 2) {
                    baseCommentVM.j().setValue(Boxing.boxInt(pageEntity2.getTotal()));
                }
                value4 = baseCommentVM.i().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            } else {
                value = baseCommentVM.i().getValue();
                if (value != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "it.list");
                    value.addData((Collection<? extends BaseNode>) list2);
                }
            }
            baseCommentVM.p(pageEntity.getRefreshTime());
            list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            if (!list.isEmpty()) {
                baseCommentVM.o(baseCommentVM.getPageNum() + 1);
            }
            if (pageEntity.getHasNext()) {
                value3 = baseCommentVM.i().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value2 = baseCommentVM.i().getValue();
                if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        Function4 function4B = CommentDelegate.f37252a.b(this.$commentType);
        if (function4B != null) {
            Integer numBoxInt = Boxing.boxInt(this.$viewModel.getPageNum());
            String refreshTime = this.$viewModel.getRefreshTime();
            String str = this.$worksNo;
            this.label = 1;
            obj = function4B.invoke(numBoxInt, refreshTime, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            pageEntity = null;
        }
        if (pageEntity != null) {
            baseCommentVM = this.$viewModel;
            i = this.$commentType;
            coroutineDispatcherC = jo2.c();
            commentUtil$loadCommentData$1$1$1 = new CommentUtil$loadCommentData$1$1$1(pageEntity, null);
            this.L$0 = pageEntity;
            this.L$1 = baseCommentVM;
            this.L$2 = pageEntity;
            this.I$0 = i;
            this.label = 2;
            if (v41.h(coroutineDispatcherC, commentUtil$loadCommentData$1$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i2 = i;
            pageEntity2 = pageEntity;
            if (baseCommentVM.getPageNum() == 1) {
                if (i2 == 2) {
                    baseCommentVM.j().setValue(Boxing.boxInt(pageEntity2.getTotal()));
                }
                value4 = baseCommentVM.i().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            } else {
                value = baseCommentVM.i().getValue();
                if (value != null) {
                    List list3 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list3, "it.list");
                    value.addData((Collection<? extends BaseNode>) list3);
                }
            }
            baseCommentVM.p(pageEntity.getRefreshTime());
            list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            if (!list.isEmpty()) {
                baseCommentVM.o(baseCommentVM.getPageNum() + 1);
            }
            if (pageEntity.getHasNext()) {
                value3 = baseCommentVM.i().getValue();
                if (value3 != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value2 = baseCommentVM.i().getValue();
                if (value2 != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
        }
        return Unit.INSTANCE;
        pageEntity = (PageEntity) obj;
        if (pageEntity != null) {
            baseCommentVM = this.$viewModel;
            i = this.$commentType;
            coroutineDispatcherC = jo2.c();
            commentUtil$loadCommentData$1$1$1 = new CommentUtil$loadCommentData$1$1$1(pageEntity, null);
            this.L$0 = pageEntity;
            this.L$1 = baseCommentVM;
            this.L$2 = pageEntity;
            this.I$0 = i;
            this.label = 2;
            if (v41.h(coroutineDispatcherC, commentUtil$loadCommentData$1$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i2 = i;
            pageEntity2 = pageEntity;
            if (baseCommentVM.getPageNum() == 1) {
                if (i2 == 2) {
                    baseCommentVM.j().setValue(Boxing.boxInt(pageEntity2.getTotal()));
                }
                value4 = baseCommentVM.i().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            } else {
                value = baseCommentVM.i().getValue();
                if (value != null) {
                    List list4 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "it.list");
                    value.addData((Collection<? extends BaseNode>) list4);
                }
            }
            baseCommentVM.p(pageEntity.getRefreshTime());
            list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            if (!list.isEmpty()) {
                baseCommentVM.o(baseCommentVM.getPageNum() + 1);
            }
            if (pageEntity.getHasNext()) {
                value3 = baseCommentVM.i().getValue();
                if (value3 != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value2 = baseCommentVM.i().getValue();
                if (value2 != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
