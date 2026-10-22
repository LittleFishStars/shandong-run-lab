package com.huachenjie.channel.page.notify.post;

import android.text.Html;
import android.text.SpannableString;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.notify.post.NotifyPostCommentVM$loadMoreData$1", f = "NotifyPostCommentVM.kt", i = {1}, l = {25, 26}, m = "invokeSuspend", n = {"commentList"}, s = {"L$0"})
public final class NotifyPostCommentVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ NotifyPostCommentVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.post.NotifyPostCommentVM$loadMoreData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.page.notify.post.NotifyPostCommentVM$loadMoreData$1$1", f = "NotifyPostCommentVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nNotifyPostCommentVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotifyPostCommentVM.kt\ncom/huachenjie/channel/page/notify/post/NotifyPostCommentVM$loadMoreData$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,34:1\n1855#2,2:35\n*S KotlinDebug\n*F\n+ 1 NotifyPostCommentVM.kt\ncom/huachenjie/channel/page/notify/post/NotifyPostCommentVM$loadMoreData$1$1\n*L\n27#1:35,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageEntity<CommentOnMeBean> $commentList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageEntity<CommentOnMeBean> pageEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$commentList = pageEntity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$commentList, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<CommentOnMeBean> list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PageEntity<CommentOnMeBean> pageEntity = this.$commentList;
            if (pageEntity == null || (list = pageEntity.getList()) == null) {
                return null;
            }
            for (CommentOnMeBean commentOnMeBean : list) {
                String string = new SpannableString(Html.fromHtml(commentOnMeBean.getContent())).toString();
                Intrinsics.checkNotNullExpressionValue(string, "SpannableString(Html.fro…l(it.content)).toString()");
                commentOnMeBean.setNoHtmlContent(string);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyPostCommentVM$loadMoreData$1(NotifyPostCommentVM notifyPostCommentVM, Continuation<? super NotifyPostCommentVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = notifyPostCommentVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotifyPostCommentVM$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity<?> pageEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pageEntity = (PageEntity) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.u().setValue(pageEntity);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f33012a;
        int pageNum = this.this$0.getPageNum();
        String refreshTime = this.this$0.getRefreshTime();
        this.label = 1;
        obj = requestModel.g0(pageNum, refreshTime, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity<?> pageEntity2 = (PageEntity) obj;
        CoroutineDispatcher coroutineDispatcherC = jo2.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(pageEntity2, null);
        this.L$0 = pageEntity2;
        this.label = 2;
        if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        pageEntity = pageEntity2;
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
