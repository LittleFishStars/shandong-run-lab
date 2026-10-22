package com.huachenjie.works.page.comment.base;

import android.content.Context;
import android.text.TextUtils;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.bean.comment.TargetComment;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$publishCommentReply$2", f = "CommentUtil.kt", i = {}, l = {168, 178}, m = "invokeSuspend", n = {}, s = {})
public final class CommentUtil$publishCommentReply$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentReplyBean $commentReplyBean;
    final /* synthetic */ int $commentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ Function1<CommentReplyBean, Unit> $onSuccess;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommentUtil$publishCommentReply$2(CommentReplyBean commentReplyBean, Function0<Unit> function0, int i, Context context, Function1<? super CommentReplyBean, Unit> function1, Continuation<? super CommentUtil$publishCommentReply$2> continuation) {
        super(2, continuation);
        this.$commentReplyBean = commentReplyBean;
        this.$onFail = function0;
        this.$commentType = i;
        this.$context = context;
        this.$onSuccess = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$publishCommentReply$2(this.$commentReplyBean, this.$onFail, this.$commentType, this.$context, this.$onSuccess, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d1  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function6 function6F;
        CommentReplyBean commentReplyBean;
        TargetComment targetComment;
        String targetCommentNo;
        Function0<Unit> function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            commentReplyBean = (CommentReplyBean) obj;
            if (commentReplyBean != null) {
                Function1<CommentReplyBean, Unit> function1 = this.$onSuccess;
                commentReplyBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentReplyBean.getContent(), 0, 2, null));
                function1.invoke(commentReplyBean);
            } else {
                function0 = this.$onFail;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$commentReplyBean.getImage() == null || StringsKt.startsWith$default(this.$commentReplyBean.getImage().getPath(), "http", false, 2, (Object) null)) {
            function6F = CommentDelegate.f37252a.f(this.$commentType);
            if (function6F != null) {
                Function6 function6 = function6F;
                String content = this.$commentReplyBean.getContent();
                String bizNo = this.$commentReplyBean.getBizNo();
                targetComment = this.$commentReplyBean.getTargetComment();
                if (targetComment != null || (targetCommentNo = targetComment.getTargetCommentNo()) == null) {
                    targetCommentNo = "";
                }
                List<String> atUserList = this.$commentReplyBean.getAtUserList();
                CommentImageBean image = this.$commentReplyBean.getImage();
                this.label = 2;
                obj = function6.invoke(content, bizNo, targetCommentNo, atUserList, image, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                commentReplyBean = (CommentReplyBean) obj;
            } else {
                commentReplyBean = null;
            }
        } else {
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            CommentUtil$publishCommentReply$2$path$1 commentUtil$publishCommentReply$2$path$1 = new CommentUtil$publishCommentReply$2$path$1(this.$context, this.$commentReplyBean, this.$commentType, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC, commentUtil$publishCommentReply$2$path$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (commentReplyBean != null) {
            Function1<CommentReplyBean, Unit> function2 = this.$onSuccess;
            commentReplyBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentReplyBean.getContent(), 0, 2, null));
            function2.invoke(commentReplyBean);
        } else {
            function0 = this.$onFail;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            Function0<Unit> function3 = this.$onFail;
            if (function3 != null) {
                function3.invoke();
            }
            return Unit.INSTANCE;
        }
        CommentImageBean image2 = this.$commentReplyBean.getImage();
        Intrinsics.checkNotNull(str);
        image2.setPath(str);
        function6F = CommentDelegate.f37252a.f(this.$commentType);
        if (function6F != null) {
            Function6 function7 = function6F;
            String content2 = this.$commentReplyBean.getContent();
            String bizNo2 = this.$commentReplyBean.getBizNo();
            targetComment = this.$commentReplyBean.getTargetComment();
            if (targetComment != null) {
                targetCommentNo = "";
            } else {
                targetCommentNo = "";
            }
            List<String> atUserList2 = this.$commentReplyBean.getAtUserList();
            CommentImageBean image3 = this.$commentReplyBean.getImage();
            this.label = 2;
            obj = function7.invoke(content2, bizNo2, targetCommentNo, atUserList2, image3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            commentReplyBean = (CommentReplyBean) obj;
        } else {
            commentReplyBean = null;
        }
        if (commentReplyBean != null) {
            Function1<CommentReplyBean, Unit> function4 = this.$onSuccess;
            commentReplyBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentReplyBean.getContent(), 0, 2, null));
            function4.invoke(commentReplyBean);
        } else {
            function0 = this.$onFail;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}
